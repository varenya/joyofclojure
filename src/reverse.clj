(defn strict-map1 [f coll]
    (loop [coll coll, acc nil]
      (if (empty? coll)
        (reverse acc)
        (recur (next coll) (cons (f (first coll)) acc))
        )
    )
)

(defn strict-map2 [f coll]
  (loop [coll coll, acc []]
    (if (empty? coll)
        acc
        (recur (next coll) (conj acc (f (first coll))))
      )
    )
  )

(doseq [[dimension amount] {:width 10, :height 20, :depth 15}]
   (println (str (name dimension) ":") amount "inches")
  )

(defmethod print-method clojure.lang.PersistentQueue [q w]
  (print-method '<- w)
  (print-method (seq q) w)
  (print-method '-< w)
  )

(def schedule (conj clojure.lang.PersistentQueue/EMPTY :wake-up :shower :brush-teeth))
