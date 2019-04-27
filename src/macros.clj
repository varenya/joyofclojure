(defn contextual-eval [ctx expr]
  (eval `(let
          [~@(mapcat (fn [[k v]] [k `'~v]) ctx)]
           ~expr)))

(defmacro do-until [& clauses]
  (when clauses
    (list 'clojure.core/when (first clauses)
          (if (next clauses) (second clauses)
              (throw (IllegalArgumentException. "do-until requires an even number of forms")))
          (cons 'do-until (nnext clauses)))))

(defmacro def-watched [name & value]
  `(do
     (def ~name ~@value)
     (add-watch (var ~name) :re-bind (fn [~'key ~'r old# new#] (println old# " -> " new#)))))
