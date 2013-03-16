(ns quil-of-life.iterations.i3-simplify-test
  (:require [quil-of-life.iterations.i3-simplify :as i3])
  (:use [clojure.test :only [deftest testing is]]))

(deftest test:cell-step
  (testing "cell-step"
    (testing "underpopulation of living cells"
      (is (= (i3/cell-step true 1) false)))
    (testing "survival of living cells"
      (is (= (i3/cell-step true 2) true))
      (is (= (i3/cell-step true 3) true)))
    (testing "overcrowding of living cells"
      (is (= (i3/cell-step true 4) false)))
    (testing "birth of new cells"
      (is (= (i3/cell-step false 3) true)))
    (testing "Implied assumptions"
      (testing "A dead cell only becomes alive when reproducing"
        (is (= (i3/cell-step false 1) false))
        (is (= (i3/cell-step false 2) false))
        (is (= (i3/cell-step false 4) false))))))
