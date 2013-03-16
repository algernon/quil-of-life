(ns quil-of-life.iterations.i1-direct-translation)

(defn neighbours
  [[x y]]

  (for [dx [-1 0 1]
        dy (if (zero? dx)
             [-1 1]
             [-1 0 1])]
    [(+ dx x) (+ dy y)]))

(defn step
  [cells]

  (set (for [[loc n] (frequencies (mapcat neighbours cells))
             :when (or (= n 3)
                       (and (= n 2)
                            (cells loc)))]
         loc)))

(defn create-world
  [cells world-size]

  (for [y (range world-size)]
    (for [x (range world-size)]
      (if (nil? (get cells [x y]))
        "."
        "#"))))

(defn print-world
  [cells world-size]

  (dorun (map println (create-world cells world-size))))

(defn run-life
  [world-size steps cells]

  (loop [current-cells cells
         steps-left steps]
    (print-world current-cells world-size)
    (println)
    (when-not (zero? steps-left)
      (recur (step current-cells) (dec steps-left)))))
