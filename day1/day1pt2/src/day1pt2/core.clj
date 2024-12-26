(ns day1pt2.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:gen-class))

(defn process-file
  [file-path]
  (with-open [reader (io/reader file-path)]
    (let [lines (line-seq reader)
          pairs (map #(mapv read-string (str/split % #"\s+")) lines)
          left-list (sort (map first pairs))
          right-list (sort (map second pairs))
          right-count (frequencies right-list)]
      {:left left-list :right right-list :right-count right-count})))

(defn -main
  [& _]
  (def result (day1pt2.core/process-file "data.txt"))
  (def frequencies_right (:right-count result))
  (def res (atom 0))
  (doseq [elem (:left result)]
    (dotimes [_ (get frequencies_right elem 0)]
      (swap! res + elem)))
  (println @res))

; 21306195
