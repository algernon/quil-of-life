(ns quil-of-life.iterations.i2-lets-start-from-the-beginning-test
  (:require [quil-of-life.iterations.i2-lets-start-from-the-beginning :as i2])
  (:use [clojure.test :only [deftest testing is]]))

(deftest test:is-underpopulated?
  (testing "is-underpopulated?"
    (is (= (i2/is-underpopulated? 1) true))
    (is (= (i2/is-underpopulated? 2) false))
    (is (= (i2/is-underpopulated? 3) false))))

(deftest test:is-overcrowded?
  (testing "is-overcrowded?"
    (is (= (i2/is-overcrowded? 4) true))
    (is (= (i2/is-overcrowded? 3) false))
    (is (= (i2/is-overcrowded? 2) false))))

(deftest test:will-survive?
  (testing "will-survive?"
    (is (= (i2/will-survive? 2) true))
    (is (= (i2/will-survive? 3) true))
    (is (= (i2/will-survive? 4) false))
    (is (= (i2/will-survive? 1) false))))

(deftest test:will-reproduce?
  (testing "will-reproduce?"
    (is (= (i2/will-reproduce? 3) true))
    (is (= (i2/will-reproduce? 2) false))
    (is (= (i2/will-reproduce? 4) false))))

(deftest test:cell-step
  (testing "cell-step"
    (testing "underpopulation of living cells"
      (is (= (i2/cell-step true 1) false)))
    (testing "survival of living cells"
      (is (= (i2/cell-step true 2) true))
      (is (= (i2/cell-step true 3) true)))
    (testing "overcrowding of living cells"
      (is (= (i2/cell-step true 4) false)))
    (testing "birth of new cells"
      (is (= (i2/cell-step false 3) true)))
    (testing "Implied assumptions"
      (testing "A dead cell only becomes alive when reproducing"
        (is (= (i2/cell-step false 1) false))
        (is (= (i2/cell-step false 2) false))
        (is (= (i2/cell-step false 4) false))))))
