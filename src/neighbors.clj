(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(defn neighbors
  ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]] size yx))
  ([deltas size yx] (filter (fn [new-yx] (every? #(< -1 % size) new-yx))
                            (map #(vec (map + yx %)) deltas))))