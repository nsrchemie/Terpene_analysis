(require '[clojure.string :as str])
(require '[clojure.java.io :as io])

(defn secread [x]
(with-open [rdr (io/reader "./scraped")]
(doseq [line (line-seq rdr)]
(println (get (str/split (clojure.string/replace line 
	#"./hmdb_metabolites.xml:" "") #" ") 0), 
(get (str/split line #"family of ") 1)))
))