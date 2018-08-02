(ns ajax-promises.main
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
  [{:keys [] :as request}]
  (let [timeout (or (:timeout request) 0)]
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
        (reject response)))))

(defn xhr-request [uri method]
  (let [body ""
        headers {}]
    (p/promise (fn [resolve reject]
                 (let [xhr (build-xhr {})]
                   (.listen xhr EventType.COMPLETE (build-listener resolve reject))
                   (.send xhr uri method body headers))))))

(defn GET [uri]
  (xhr-request uri "GET"))
