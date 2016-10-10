(ns metabolite-parser.core)

(require '[clojure.string :as str])
(require '[clojure.java.io :as io])



(defn secread [x]

	(def sesq_count (atom #{}))
	; Create an atomic list for collecting strings/compounds
	(with-open [rdr (io/reader "./resources/scraped")]
		(doseq [line (line-seq rdr)]
		; Open file and sequentially loop through each line
			(defn molecule [x] 
				(get (str/split (clojure.string/replace line 
				#"./hmdb_metabolites.xml:" "") #" ") x))
			; Create a function for removing the first part of the line and slicing after

			(def mess (get (str/split line #"family of ") 1))
			; Slice compound names as the string immediately after the text "Family of"

			(defstruct cpd_sets :Compound :Class)
			; Create structure for map to make organizing compounds and their classes easier

				(if-not (empty? (and(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" "")
				(clojure.string/replace (molecule 1) #"belongs" "")
				; Slice compound names, as well as the space after them to catch extra alpha characters
				; Replace extraneous lines containing only HMDB[0-9]*
				; Remove "belongs text"
				; Check that no empty strings are being added
					(get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0) 	))  
					; indexing for slicing of chemical Class
						(def ^:dynamic tin
						; Create dynamic map using premade structure
						; Grab Compound name, plus extra alpha characters for compounds with
						; analogues (i.e. Erinacine A/B) and put under :Compound keyword
						; Add chemical :Class as other key-val pair for each map
						; Ex. {:Compound "Aspirin" :Class "Phenol Ester"}
							(struct  cpd_sets 
							(clojure.string/join " "
							[(clojure.string/replace (molecule 0) #"./HMDB[0-9]*.xml:" ""),
							(clojure.string/replace (molecule 1) #"belongs" "")]) 
							 (get (str/split (clojure.string/join "" (take 25 mess)) #". Th")0))))
						
			(if (=(:Class tin) "Sesquiterpenes")
			(swap! sesq_count conj (:Compound tin)))
		)
	)
(prn (count @sesq_count))

)
(defn -main []
	(secread "x"))