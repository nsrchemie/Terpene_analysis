(require '[clojure.string :as str])
(require '[clojure.java.io :as io])


(defn is-small? [val]
	(if (<= (count val) 4)
		true
		false))

(defn secread [x]
(with-open [rdr (io/reader "./scraped")]
(doseq [line (line-seq rdr)]

(println 
	(get (str/split (clojure.string/replace line 
	#"./hmdb_metabolites.xml:" "") #" ") 0),
	(clojure.string/replace (get (str/split (clojure.string/replace line 
	 #"./hmdb_metabolites.xml:" "") #" ") 1) #"belongs" ""))

; (if (is-small? (get (str/split (clojure.string/replace line 
; 	 #"./hmdb_metabolites.xml:" "") #" ") 1)) 
; println (get (str/split (clojure.string/replace line 
; 	 #"./hmdb_metabolites.xml:" "") #" ") 1)))


; (get (str/split line #"family of ") 1)
)))