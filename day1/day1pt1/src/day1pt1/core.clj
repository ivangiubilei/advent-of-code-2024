(ns day1pt1.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:gen-class))

(defn process-file
  [file-path]
  (with-open [reader (io/reader file-path)]
    (let [lines (line-seq reader)
          pairs (map #(mapv read-string (str/split % #"\s+")) lines)
          left-list (sort (map first pairs))
          right-list (sort (map second pairs))]
      {:left left-list :right right-list})))

(defn -main
  [& _]
  (def data (day1pt1.core/process-file "data.txt"))
  (def res (reduce + (map #(Math/abs %) (map - (:left data) (:right data)))))
  (println res))

; 1651298

