(ns compound-interest.core
  (:require [clojure.math :as math])
  (:gen-class))

(defn- valid? [x]
  (pos? x))

(defn- corrupt []
  (println "Corrupt"))

(defn compound [p r t]
  (* p (math/exp (* r t))))

(defn -main [& args]
  (when (= (count args) 3)
    (try 
      (let [[p r t] (map #(Double/parseDouble %) args)]
        (if (every? valid? [p r t])
          (println (format "Amount: %.2f" (compound p (/ r 100.0) t)))
          (corrupt)))
      (catch NumberFormatException _
        (corrupt)))) )

