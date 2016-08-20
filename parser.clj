(require '[clojure.string :as str])
(require '[clojure.java.io :as io])

(defn secread [x]
(with-open [rdr (io/reader "./scraped")]
(doseq [line (line-seq rdr)]
(println (str/split (subs line 23) #" ") 0)))
)