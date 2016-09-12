(defproject metabolite_parser "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"] 
  [cascalog/cascalog-core "2.1.0"]]
  :main metabolite-parser.core
  :profiles { :dev {:dependencies [[org.apache.hadoop/hadoop-core "1.2.1"]]}}
  :jvm-opts ["-Xms768m" "-Xmx768m"])
