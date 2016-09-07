(ns metabolite-parser.core)

(require '[clojure.string :as str])
(require '[clojure.java.io :as io])



(defn secread [x]
(with-open [rdr (io/reader "./resources/scraped")]
(doseq [line (line-seq rdr)]

(defn molecule [x] (get (str/split (clojure.string/replace line 
	#"./hmdb_metabolites.xml:" "") #" ") x))

(def mess(get (str/split line #"family of ") 1))

(if-not (empty? (and(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" "")
(clojure.string/replace (molecule 1) #"belongs" "")
(get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0) ))  
	
	(prn 
		(clojure.string/join " "
	[(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" ""),
	(clojure.string/replace (molecule 1) #"belongs" ""),
	 (get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0)
	]))



; (println (seq mess))
)
; (def cpd_coll [cpds, (get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0)])
; (prn cpds)
; (prn (remove clojure.string/blank? cpds))
)))

(defn -main []
	(secread "x"))