(ns parabola.core
  (:require [parabola.parabola :as p])
  (:gen-class))

(defn -main
  [& args]
  (when (= (count args) 3)
    (try 
      (let [[a b c] (map #(Double/parseDouble %) args)
            parabola (p/make-parabola a b c)]
        (println "Root 1: " (:root1 parabola))
        (println "Root 2: " (:root2 parabola)))
      (catch NumberFormatException _
          (println "Suck it!")))) )

