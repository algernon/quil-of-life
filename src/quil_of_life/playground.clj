(ns quil-of-life.playground
  (:require [quil-of-life.life :as life]
            [quil-of-life.quil :as g]))

(g/clear)

(g/toggle)
(g/add-form :lightweight-space-ship)
(g/add-form :glider)
(g/add-form :oscillator)
(g/add-form :beehive)
(g/add-form :boat)
(g/add-form :loaf)
(g/add-form :beacon)
(g/add-form :gosper-glider-gun)
(g/add-form :block-laying-switch-engine [10 10])

(g/add-form :oscillator [2 0])
(g/add-form :lightweight-space-ship [15 15])

(g/add-form (rand-nth (keys life/forms))
            [(rand-int 40) (rand-int 40)])
