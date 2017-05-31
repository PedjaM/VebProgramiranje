(ns guestbook.routes.home
  (:require [compojure.core :refer :all]
            [guestbook.views.layout :as layout]
            [hiccup.form :refer :all]
            ))

(defn home []
(layout/common
[:div#prvaSekcija
 [:h1 "Prvi pokušaj"]
 [:hr]
 [:p#p1 "Poštovani,
      Želeo sam da vas obavestim o tome kako napredujem sa učenjem. Koristim Lightable IDE i učim iz knjige 'Clojure for web development'. Prošao sam
      Clojure koane i dobar deo knjige Clojure for brave and true. Odlučio sam da krenem konkretno sa nekim mini projektom kroz koji ću bolje da učim šta treba.
      Ovo je stranica napravljena pomoću hiccup-a i trenutno nema funkcionalne logike, samo je napisan html/css pomoću clojure sintakse."]
]
[:div#drugaSekcija
  [:p#p2 "Postavio sam formu i druge elemente koji mogu poslužiti za jednostavnu aplikaciju, samo treba da naučim kako konkretno da primenjujem clojure funkcije
       nad njima.Ti elementi se nalaze u sekciji ispod. Čisto da se zna, mnogo sa bolji sa css-om od ovoga ali nisam ga koristio mesecima i ovo radim na brzinu."]
]
  [:hr]
(form-to
  [:post "/"]
  [:p "Broj: " (text-field "ime")]
  [:p "Poruka: " (text-area {:rows 10 :cols 40} "poruka")]
  (submit-button "komentarisi" ))
  ))

(defn cao [ime]
  (str "cao " ime))



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

(defn kvadrat
  [x]
  (* x x)
)

(defn stanDev [niz]
    (doseq [i niz]
    (kvadrat (- i (prosek niz)))))



(defroutes home-routes
(GET "/" [] (home))
(POST "/" [ime] (cao ime))
  )
