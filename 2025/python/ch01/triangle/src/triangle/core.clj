(ns triangle.core
  (:gen-class))

;;;
;;;    Ex. 1.2.12
;;;    
;;;    https://en.wikipedia.org/wiki/Triangle_inequality
;;;
;;;    Explicitly: a + b > c  &  b + c > a  &  a + c > b
;;;    Equivalently: |a - b| < c < a + b
;;;    or
;;;    max(a, b, c) < a + b + c - max(a, b, c) => 2 max(a, b, c) < a + b + c
;;;    or
;;;    Area of triangle > 0.
;;;    

(defn sedgewick-triangle? [a b c]
  (not (or (>= a (+ b c))
           (>= b (+ a c))
           (>= c (+ a b)))) )

(defn triangle? [a b c]
  (and (< a (+ b c))
       (< b (+ a c))
       (< c (+ a b))))

(defn abs-triangle? [a b c]
  (< (abs (- a b)) c (+ a b)))

(defn max-triangle? [a b c]
  (< (* 2 (max a b c)) (+ a b c)))

(defn goldberg-heron [a b c]
  ;;
  ;;   Assumes a ≥ b ≥ c
  ;;   
  (letfn [(heron [a b c]
            (let [product (* (+ a (+ b c))
                             (- c (- a b))
                             (+ c (- a b))
                             (+ a (- b c)))]
              (if (neg? product)
                0
                (/ (Math/sqrt product) 4))))]
    (apply heron (sort #(compare %2 %1) [a b c]))))

(defn area-triangle? [a b c]
  (pos? (goldberg-heron a b c)))

(defn- valid? [x]
  (and (pos? x) (zero? (rem x 1))))

(defn- corrupt []
  (println "Corrupt"))

(defn -main
  [& args]
  (when (= (count args) 3)
    (try 
      (let [[a b c] (map #(Double/parseDouble %) args)]
        (if (every? valid? [a b c])
          (do
            (println (if (sedgewick-triangle? a b c) "True" "False"))
            (println (if (triangle? a b c) "True" "False"))
            (println (if (abs-triangle? a b c) "True" "False"))
            (println (if (max-triangle? a b c) "True" "False"))
            (println (if (area-triangle? a b c) "True" "False")))
          (corrupt)))
      (catch NumberFormatException _
        (corrupt)))) )
