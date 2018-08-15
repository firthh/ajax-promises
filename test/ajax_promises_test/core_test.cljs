(ns ajax-promises-test.core-test
  (:require-macros [cljs.test :refer [deftest testing is async]])
  (:require [cljs.test]
            [ajax-promises.core :as http]
            [promesa.core :as p]
;            [promesa.async-cljs :refer-macros [async]]
            ))

(deftest get-test-status []
  (async done
         (-> (http/GET {:uri "http://localhost:3000/api/plus?x=1&y=2"})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))
(deftest head-test-status []
  (async done
         (-> (http/HEAD {:uri "http://localhost:3000/api/plus"})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))

(deftest options-test-status []
  (async done
         (-> (http/OPTIONS {:uri "http://localhost:3000/api/plus"})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))

(deftest delete-test-status []
  (async done
         (-> (http/DELETE {:uri "http://localhost:3000/api/resource/ID101"})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))

(def post-body
 "{
   \"name\": \"string\",
   \"description\": \"string\",
   \"size\": \"L\",
   \"origin\": {
     \"country\": \"PO\",
     \"city\": \"string\"
   }
  }")

(deftest post-test-status []
  (async done
         (-> (http/POST {:uri "http://localhost:3000/api/echo"
                         :body post-body
                         :headers {"Content-Type" "application/json"}})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))

(deftest put-test-status []
  (async done
         (-> (http/PUT {:uri "http://localhost:3000/api/echo"
                        :body post-body
                        :headers {"Content-Type" "application/json"}})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))

(deftest put-test-status []
  (async done
         (-> (http/PATCH {:uri "http://localhost:3000/api/echo"
                        :body post-body
                        :headers {"Content-Type" "application/json"}})
             (p/catch (fn [response]
                        (is (= nil response))
                        (done)))
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))
