(ns polar-coordinates.core
  (:require [clojure.math :as math])
  (:gen-class))

(defn cartesian->polar [x y]
  [(math/hypot x y) (math/atan2 y x)])

(defn- corrupt []
  (println "Corrupt"))

(defn -main [& args]
  (when (= (count args) 2)
    (try 
      (let [[x y] (map #(Double/parseDouble %) args)
            [r θ] (cartesian->polar x y)]
        (println (format "(%f,%f) -> r: %f θ: %f" x y r θ)))
      (catch NumberFormatException _
        (corrupt)))) )
