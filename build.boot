(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojurescript   "1.10.339"]
                 [funcool/promesa             "1.9.0"]
                 [crisptrutski/boot-cljs-test "0.3.5-SNAPSHOT" :scope "test"]
                 [adzerk/boot-cljs            "2.1.4" :scope "test"]
                 [doo                         "0.1.8" :scope "test"]])

(require '[crisptrutski.boot-cljs-test :refer [test-cljs report-errors!]])

(deftask testing []
  (merge-env! :resource-paths #{"test"})
  identity)

(def doo-opts
  {:paths {:phantom "phantomjs --web-security=false"}})

(deftask test-all []
  (comp (testing)
     (test-cljs :js-env :phantom :verbosity 3 :ids ["ajax_promises_test/suite"] :doo-opts doo-opts)
     (report-errors!)))
