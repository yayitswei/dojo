(ns dojo.core)

(defn score-game [[frame & rest-of-game :as game]]
  (if (= frame nil) 0
  (if (= (apply + frame) 10) 
    (reduce + [(apply + (take 3 (flatten game))) (score-game rest-of-game)])
    (reduce + [(apply + frame) (score-game rest-of-game)]))))

(deftest basic
         (let [frames [[5 2] [3 3]]]
           (is (= 13 (score-game frames)))))

(deftest strike-followed-two-simple
         (let [frames [[10] [3 3] [1 0]]]
           (is (= 23 (score-game frames)))))

(deftest strike-followed-three-simple
         (let [frames [[10] [3 3] [1 0] [1 0]]]
           (is (= 24 (score-game frames)))))

(deftest spare-followed-three-simple
         (let [frames [[3 7] [3 3] [1 0] [1 0]]]
           (is (= 21 (score-game frames)))))
