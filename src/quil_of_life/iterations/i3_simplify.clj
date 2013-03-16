(ns quil-of-life.iterations.i3-simplify)

(defn is-underpopulated?
  [neighbour-count]

  (< neighbour-count 2))

(defn is-overcrowded?
  [neighbour-count]

  (> neighbour-count 3))

(defn will-reproduce?
  [neighbour-count]

  (== neighbour-count 3))

(defn will-survive?
  [neighbour-count]

  (or (== neighbour-count 2)
      (== neighbour-count 3)))

(defn cell-step
  [is-alive? neighbour-count]

  (cond
   (is-underpopulated? neighbour-count) false
   (is-overcrowded? neighbour-count) false
   (will-reproduce? neighbour-count) true
   (will-survive? neighbour-count) is-alive?))
