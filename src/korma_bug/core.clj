(ns korma-bug.core
    (:require [korma.core :refer :all]
              [korma.db :refer :all]))

(defdb db (sqlite3 {:db "foo.db"}))

(defentity baz1
  (table :baz :baz1)
  (pk :baz_id))

(defentity baz2
  (table :baz :baz2)
  (pk :baz_id))

(defentity bar
  (pk :bar_id))

(defentity foo
  (pk :foo_id)
  (belongs-to bar {:fk :bar_id})
  (belongs-to baz1 {:fk :baz1_id})
  (belongs-to baz2 {:fk :baz2_id}))

(defn -main [& args]
  (print "\nadding just bar works:\n")
  (print (select foo
                 (with bar (fields :bar_name))))
  (print "\nadding just baz1 works:\n")
  (print (select foo
                 (with baz1 (fields [:baz_name :baz1_name]))))
  (print "\nadding just baz2 works:\n")
  (print (select foo
                 (with baz2 (fields [:baz_name :baz2_name]))))
  (print "\nadding any combination of two or more belongs-to links fails:\n")
  (print (select foo
                 (with bar (fields :bar_name))
                 (with baz1 (fields [:baz_name :baz1_name])))))
                 ;(with baz2 (fields [:baz_name :baz2_name])))))
