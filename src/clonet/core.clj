(ns clonet.core
  [:use hiphip.double])




(use 'clojure.core.matrix)
(use 'clojure.core.matrix.operators)  ;; for +, -, * etc.
(set-current-implementation :vectorz)

(defn to-binary [x]
  
  )

(defn binary-permutation [n]
  (map (partial cl-format nil "~v,'0B" n) (range 0 (Math/pow 2 n))))

(def training
  (map to-binary (range 1000)))

(defn sigmoid [t]
  (/ 1 (+ 1 (Math/exp (- t)))))

(defn round [x]
  (if (> x 0.5)
    1
    0))

(defn forward-prop [X Theta]
  ;; add ones to beginning of x
  (let [a1 (propagate X Theta1)
        a2 (propagate a1 Theta2)])  ; extend with x
  )

(defn prepend [first second]
  (vec (cons first second)))

(defn propagate [X Theta]
  (map (comp round sigmoid)
       (* (prepend 1 X) Theta)))

(defn run-network [X [Theta1 Theta2]]
  (propagate (propagate X Theta1)
             Theta2))

(def scores
  '(([1 0] [3 0] [4 1] [8 1]) ))

(defn total-score [net scores]
  (count (filter #(not (nil? %))
                 (map #(= (second %) (run-network (to-binary (first %))
                                                  net))
                      scores))))

(defn theta-range [low hi]
  (+ low
     (* (rand) (- hi low))) )

(defn gen-net [n low hi]
  [(repeatedly n #(theta-range low hi))
   (repeatedly n #(theta-range low hi))])



 ;; (defn forward-prop [X1 X2]
 ;;  ;; add ones to beginning of x
 ;;  ;; [1 1 1 1 1 1 1 1
 ;;  (let [
 ;;        a1 (sigmoid (* X1 Theta11))
 ;;        a2 (sigmoid (addone (dot-product a1 Theta2)))])  ; extend with x
  


