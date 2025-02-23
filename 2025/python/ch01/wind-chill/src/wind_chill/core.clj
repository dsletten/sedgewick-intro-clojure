(ns wind-chill.core
  (:require [clojure.math :as math])
  (:gen-class))

(defn wind-chill [t v]
  (+ 35.74 (* 0.6215 t) (* (- (* 0.4275 t) 35.75) (math/pow v 0.16))))

(defn- valid? [x p]
  (p x))

(defn- corrupt []
  (println "Corrupt"))

(defn -main [& args]
  (when (= (count args) 2)
    (try 
      (let [[t v] (map #(Double/parseDouble %) args)]
        (if (and (valid? t #(<= (abs %) 50))
                 (valid? v #(<= 3 % 120)))
          (println (format "Wind chill: %f" (wind-chill t v)))
          (corrupt)))
      (catch NumberFormatException _
        (corrupt)))) )
