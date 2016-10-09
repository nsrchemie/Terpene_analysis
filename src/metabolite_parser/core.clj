(ns metabolite-parser.core)

(require '[clojure.string :as str])
(require '[clojure.java.io :as io])



(defn secread [x]
	(def ditcount (atom #{}))
	(with-open [rdr (io/reader "./resources/scraped")]
		(doseq [line (line-seq rdr)]

			(defn molecule [x] 
				(get (str/split (clojure.string/replace line 
				#"./hmdb_metabolites.xml:" "") #" ") x))

			(def mess (get (str/split line #"family of ") 1))

			(defstruct cpd_sets :Compound :Class)

				(if-not (empty? (and(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" "")
				(clojure.string/replace (molecule 1) #"belongs" "")
					(get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0) 	
						)		)  
					
						(def ^:dynamic tin
							(struct  cpd_sets 
							(clojure.string/join " "
							[(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" ""),
							(clojure.string/replace (molecule 1) #"belongs" "")]) 
							 (get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0))
						)
				)
		(if-not (=(:Class tin) "Diterpenes") 
		(swap! ditcount conj (:Compound tin))
		)

		 )
		(prn @ditcount)
	)


)
(defn -main []
	(secread "x"))