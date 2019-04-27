(import [java.io BufferedReader InputStreamReader] [java.net URL])

(defn joc-www []
  (-> "http://www.joyofclojure.com/hello" URL.
      .openStream
      InputStreamReader.
      BufferedReader.))

(defmacro with-resource [binding close-fn & body]
  `(let ~binding
     (try
       (do ~@body)
       (finally
         (~close-fn ~(binding 0))))))



