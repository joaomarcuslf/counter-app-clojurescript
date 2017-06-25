(ns counter-app.core
  (:require
   [reagent.core :as reagent]))

;; Application state

(def app-state
  (reagent/atom 0))



;; Components

(defn counting-component [on-change text]
   [:a.column { :on-click #(swap! app-state on-change) }
    text])

(defn counter []
  [:div.columns.is-mobile.has-text-centered
    [counting-component dec "-"]
    [:span.column.title.is-2 " " @app-state " "]
    [counting-component inc "+"]
  ]
)

;; Main Page

(defn page [ratom]
  [:div.hero.is-primary.is-fullheight
    [:div.hero-head
      [:header.nav
        [:div.container
          [:div.nav-center
            [:h1.title.is-1 "Count App"]
          ]
        ]
      ]
    ]

    [:div.hero-body
      [:div.container.is-fullwidth.has-text-centered
        [counter]
        [counting-component (fn [val] (- val val)) "Reset"]
      ]
    ]
  ])

;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))


(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
