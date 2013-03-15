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
   :lightweight-space-ship #{[5 4] [4 4] [1 1] [3 4] [2 4] [1 3] [4 1] [5 2] [5 3]}
   :beacon #{[1 1] [2 1]
             [1 2] [2 2]
                         [3 3] [4 3]
                         [3 4] [4 4]}
   :gosper-glider-gun #{[25 1]
                        [23 2] [25 2]
                        [13 3] [14 3] [21 3] [22 3] [35 3] [36 3]
                        [12 4] [16 4] [21 4] [22 4] [35 4] [36 4]
                        [1 5] [2 5] [11 5] [17 5] [21 5] [22 5]
                        [1 6] [2 6] [11 6] [15 6] [17 6] [18 6] [23 6] [25 6]
                        [11 7] [17 7] [25 7]
                        [12 8] [16 8]
                        [13 9] [14 9]}
   :block-laying-switch-engine #{[1 1] [2 1] [3 1]       [5 1]
                                 [1 2]
                                                   [4 3] [5 3]
                                       [2 4] [3 4]       [5 4]
                                 [1 5]       [3 5]       [5 5]}})
