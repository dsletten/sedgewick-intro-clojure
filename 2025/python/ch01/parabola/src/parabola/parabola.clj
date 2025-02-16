;;;;
;;;;
;;;;   To build a brand new language and use lisp syntax on the JVM, you either gotta be a crazy person, or got some really cool ulterior motive. I met Rich and he's not a crazy person.
;;;;   -- Neal Ford
;;;;
;;;;   Name:               parabola.clj
;;;;
;;;;   Started:            Thu Jan 23 15:33:33 2025
;;;;   Modifications:
;;;;
;;;;   Purpose:
;;;;
;;;;
;;;;
;;;;   Calling Sequence:
;;;;
;;;;
;;;;   Inputs:
;;;;
;;;;   Outputs:
;;;;
;;;;   Example:
;;;;
;;;;   Notes:
;;;;
;;;;

(ns parabola.parabola
  (:require [clojure.math :as math]
            [clojure.spec.alpha :as s]))

(defrecord Parabola [a b c root1 root2])

(defn calculate-roots [a b c]
  (letfn [(normalize-root [root]
            (if (zero? root)
              (abs root)
              root))]
    (let [discriminant (- (* b b) (* 4 a c))
          d (math/sqrt discriminant)]
      (if (>= b 0)
        [(normalize-root (/ (* 2 c) (- (- b) d)))
         (normalize-root (/ (- (- b) d) (* 2 a)))]
        [(normalize-root (/ (+ (- b) d) (* 2 a)))
         (normalize-root (/ (* 2 c) (+ (- b) d)))]))))

(defn make-parabola [a b c]
  (let [[root1 root2] (calculate-roots a b c)]
;    (Parabola. :a a :b b :c c :root1 root1 :root2 root2)))
    (Parabola. a b c root1 root2)))
;    (->Parabola a b c root1 root2)))
