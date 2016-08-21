(require '[clojure.string :as str])
(require '[clojure.java.io :as io])



(defn secread [x]
(with-open [rdr (io/reader "./scraped")]
(doseq [line (line-seq rdr)]

(defn molecule [x] (get (str/split (clojure.string/replace line 
	#"./hmdb_metabolites.xml:" "") #" ") x))

(def mess(get (str/split line #"family of ") 1))

(println 
	(molecule 0),
	(clojure.string/replace (molecule 1) #"belongs" ""),
	(get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0)



; (println (seq mess))
))))