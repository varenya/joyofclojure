(defn pos [ele coll]
  (let [cmp (if (map? coll)
              #(= (second %1) %2)
              #(= %1 %2))]
    (loop [temp_seq coll idx 0]
      (when (seq temp_seq)
        (if (cmp (first temp_seq) ele)
          (if (map? coll)
            (first (first temp_seq))
            idx)
          (recur (next temp_seq) (inc idx)))))))

(defn index [coll]
  (cond
    (map? coll) (seq coll)
    (set? coll) (map vector coll coll)
    :else (map vector (iterate inc 0) coll)))

(defn pos_idx [ele coll]
  (for [[i v] (index coll) :when (= ele v)] i))

(defn simple-range [i limit]
  (lazy-seq
   (when (< i limit)
     (cons i (simple-range (inc i) limit)))))

(defn triangle [n]
  (/ (* (+ n 1) n) 2))
