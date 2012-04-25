(ns dojo.test.core
  (:use [dojo.core])
  (:use [clojure.test]))

(deftest basic
 (let [frames [[5 2] [3 3]]]
         (is 13 (score-frame frames))))
