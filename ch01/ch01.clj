;;;;
;;;;
;;;;   Clojure feels like a general-purpose language beamed back
;;;;     from the near future.
;;;;   -- Stu Halloway
;;;;
;;;;   Name:               ch01.clj
;;;;
;;;;   Started:            Fri Aug 12 00:15:30 2011
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

(ns ch01
  (:use clojure.contrib.test-is
        [clojure.contrib.pprint :only (cl-format)]))

;;;
;;;    1.1.5
;;;
(defn commify-seq [items]
  (apply cl-format nil "~#[~;~A~;~A and ~A~:;~@{~#[~;and ~]~A~^, ~}~]" items))

(defn split-args [arg-string]
  (re-seq #"\w+" arg-string))

(defn reverse-args []
  (commify-seq (reverse (split-args (read-line)))) )


