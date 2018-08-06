(ns ajax-promises-test.core-test
  (:require-macros [cljs.test :refer [deftest testing is async]])
  (:require [cljs.test]
            [ajax-promises.core :as http]
            [promesa.core :as p]
;            [promesa.async-cljs :refer-macros [async]]
            ))

(deftest core []
  (async done
         (-> (http/GET {:uri "http://localhost:3000/api/plus?x=1&y=2"})
             (p/then (fn [response]
                       (is (= 200 (:status response)))
                       (done))))))
