(ns divides.core
  (:gen-class))

(defn divides? [m n]
  (or (zero? (mod m n))
      (zero? (mod n m))))

(defn- corrupt []
  (println "Corrupt"))

(defn -main [& args]
  (when (= (count args) 2)
    (try 
      (let [[m n] (map #(Long/parseLong %) args)]
        (if (and (pos? m) (pos? n))
          (println (if (divides? m n) "True" "False"))
          (corrupt)))
      (catch NumberFormatException _
        (corrupt)))) )
  
