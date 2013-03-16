(ns quil-of-life.iterations.i2-lets-start-from-the-beginning)

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

  (if is-alive?
    (cond
     (is-underpopulated? neighbour-count) false
     (is-overcrowded? neighbour-count) false
     (will-survive? neighbour-count) true)
    (will-reproduce? neighbour-count)))
