(ns ajax-promises-test.suite
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [ajax-promises-test.core-test]))

(doo-tests 'ajax-promises-test.core-test)
