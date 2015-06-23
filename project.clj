(defproject korma-bug "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [sqlitejdbc "0.5.6"]
                 [korma "0.4.2"]]
  :main ^:skip-aot korma-bug.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
