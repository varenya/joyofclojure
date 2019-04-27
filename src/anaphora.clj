(defmacro awhen [expr & body]
  `(let [~'it ~expr]
     (if ~'it (do ~@body))
     )
  )

(awhen [1 2 3] (it 2))
