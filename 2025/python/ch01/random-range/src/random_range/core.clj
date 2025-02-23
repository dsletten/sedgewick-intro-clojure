(ns random-range.core
  (:gen-class))

(defn random-range [a b]
  (if (> a b)
    (random-range b a)
    (int (+ a (rand (inc (- b a)))) )))

(defn- valid? [x]
  (zero? (rem x 1)))

(defn- corrupt []
  (println "Corrupt"))

(defn -main [& args]
  (when (= (count args) 2)
    (try 
      (let [[a b] (map #(Integer/parseInt %) args)]
        (if (every? valid? [a b])
          (println (format "Random [%d,%d]: %d" a b (random-range a b)))
          (corrupt)))
      (catch NumberFormatException _
        (corrupt)))) )
