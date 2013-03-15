(ns quil-of-life.utils)

(defn parse-dotted-o-line
  [line]

  (let [sline (str line)]
    (remove nil? (map (fn [[idx val]]
                        (when (= val \O) idx))
                      (zipmap (range) sline)))))

(defn parse-dotted-o-form
  [& lines]

  (let [indexed-lines (zipmap (range) lines)]
    (apply sorted-set
           (mapcat (fn [[y line]]
                     (let [xs (parse-dotted-o-line line)]
                       (map (fn [x] [x y]) xs)))
                   indexed-lines))))
