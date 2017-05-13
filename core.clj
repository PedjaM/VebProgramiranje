(defn prosek [niz]
  (float (/ (reduce + niz) (count niz))))

(defn frekvencija [niz]
	(frequencies niz))

(defn medijana [niz] 
  (if (= (mod (count niz) 2) 0)
   (float(/(+ (get  niz
       (- (/ (count  niz) 2) 1))
                 (get niz
                      (/ (count niz) 2)) ) 2))
  (get niz (int (-(/ (count niz) 2) 0.5))) ))