(ns quil-of-life.life)

(defn neighbours [[x y]]
  (for [dx [-1 0 1]
        dy (if (zero? dx)
             [-1 1]
             [-1 0 1])]
    [(+ dx x) (+ dy y)]))

(defn step [cells]
  (set (for [[loc n] (frequencies (mapcat neighbours cells))
             :when (or (= n 3)
                       (and (= n 2)
                            (cells loc)))]
         loc)))

(def forms
  {:oscillator #{[1 0] [1 1] [1 2]}
   :block #{[1 1] [2 1]
            [1 2] [2 2]}
   :beehive #{[2 1] [3 1]
              [1 2] [4 2]
              [2 3] [3 3]}
   :loaf #{[2 1] [3 1]
           [1 2] [4 2]
           [2 3] [4 3]
           [3 4]}
   :boat #{[1 1] [2 1]
           [1 2] [3 2]
           [2 3]}
   :glider #{[1 2]
             [2 3]
             [3 1] [3 2] [3 3]}
   :lightweight-space-ship #{[5 4] [4 4] [1 1] [3 4] [2 4] [1 3] [4 1] [5 2] [5 3]}})
