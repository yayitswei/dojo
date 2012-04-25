(ns dojo.core)

(defn simulate-throw
 ([] (rand-int 11))
 ([n] (rand-int n)))

(defn score-game [frames]
  (reduce + (map score-frame 
                 (partition 2 frames))))

(defn score-frame [[first-frame second-frame]]
  (reduce + first-frame))

(deftest basic
 (let [frames [[5 2] [3 3]]]
         (is (= 13 (score-game frames)))))

(deftest strike-followed-two-simple
 (let [frames [[10 0] [3 3] [1 0]]]
         (is (= 23 (score-game frames)))))

(deftest strike-followed-three-simple
 (let [frames [[10 0] [3 3] [1 0] [1 0]]]
         (is (= 24 (score-game frames)))))
