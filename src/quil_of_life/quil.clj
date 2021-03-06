(ns quil-of-life.quil
  (:require [quil-of-life.life :as life]
            [quil.core :as q]
            [clojure.set :as s]))

(defonce board (atom (:oscillator life/forms)))
(defonce running (atom true))
(defonce n-steps (atom 0))

(defn- setup
  []

  (q/smooth)
  (q/frame-rate 10)
  (q/background 255))

(defn draw-grid []
  (q/stroke 100 100 200 50)
  (q/stroke-weight 1)
  (let [w (q/width)
        w (- w (mod w 10))
        h (q/height)
        h (- h (mod h 10))]
    (doseq [x (range 0 w 10)]
      (q/line x 0 x h))
    (doseq [y (range 0 h 10)]
      (q/line 0 y w y))))

(defn draw-board [cells]
  (when (or @running
            (not (zero? @n-steps)))
    (q/smooth)
    (q/background 255)
    (draw-grid)
    (q/fill 10 200 10 200)
    (doseq [[x y] cells]
      (q/ellipse (+ (* x 10) 5)
                 (+ (* y 10) 5)
                 8 8))))

(defn take-a-step
  [cnt]

  (max (dec cnt) 0))

(defn draw []
  (draw-board @board)
  (swap! n-steps take-a-step)
  (when @running
    (swap! board life/step)))

(q/defsketch quil-of-life
  :title "Quil of Life"
  :setup setup
  :draw draw
  :size [400 400])

(defn move-form
  [form sx sy]

  (set (map (fn [[x y]] [(+ x sx) (+ y sy)]) form)))

(defn add-custom-form
  ([name form] (add-custom-form name form [0 0]))
  ([name form [shift-x shift-y]]
   (let [nform (move-form form shift-x shift-y)]
     (swap! board #(s/union % nform))
     (reset! n-steps 1)
     [name [shift-x shift-y] nform])))

(defn add-form
  ([name] (add-form name [0 0]))
  ([name offs]
   (add-custom-form name (get life/forms name) offs)))

(defn pause
  []
  (reset! running false))

(defn play
  []
  (reset! running true))

(defn toggle
  []
  (swap! running not))

(defn clear
  []
  (reset! board #{})
  (reset! n-steps 1))
