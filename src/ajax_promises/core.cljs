(ns ajax-promises.core
  (:import [goog.net EventType ErrorCode XhrIo])
  (:require [promesa.core :as p]))

;; goog.net.ErrorCode constants to CLJS keywords
(def error-kw
  {0 :no-error
   1 :access-denied
   2 :file-not-found
   3 :ff-silent-error
   4 :custom-error
   5 :exception
   6 :http-error
   7 :abort
   8 :timeout
   9 :offline})

(defn build-xhr
  "Builds an XhrIo object from the request parameters."
  [{:keys [timeout] :as request}]
  (let [timeout (or timeout 0)]
    (doto (XhrIo.)
      (.setTimeoutInterval timeout))))

(defn build-listener [resolve reject]
  (fn [evt]
    (let [target (.-target evt)
          response {:status (.getStatus target)
                    :success (.isSuccess target)
                    :body (.getResponseText target)
                    :headers (.getAllResponseHeaders target)
                    :error-code (error-kw (.getLastErrorCode target))
                    :error-text (.getLastError target)}]
      (if (:success response)
        (resolve response)
        (do
          (.log js/console target)
          (reject response))))))

(def methods
  {:get "GET"
   :post "POST"
   :put "PUT"})

(defn xhr-request [{:keys [uri request-method body headers]
                    :or {body ""
                         headers {}}
                    :as request}]
  (when-let [method (get methods request-method nil)]
    ;; Throw an error if method isn't defined?
    (p/promise (fn [resolve reject]
                 (let [xhr (build-xhr (select-keys request [:timeout]))]
                   (.listen xhr EventType.COMPLETE (build-listener resolve reject))
                   (.send xhr uri method body (clj->js headers)))))))

(defn GET [request]
  (xhr-request (merge request {:request-method :get})))

(defn POST [request]
  (xhr-request (merge request {:request-method :post})))

(defn PUT [request]
  (xhr-request (merge request {:request-method :put})))

(def DELETE)
(def PATCH)
(def OPTIONS)


(comment

  (def body "{
   \"name\": \"string\",
   \"description\": \"string\",
   \"size\": \"L\",
   \"origin\": {
     \"country\": \"PO\",
     \"city\": \"string\"
   }
  }")

  )
