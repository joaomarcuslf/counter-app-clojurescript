(ns counter-app.core
  (:require
   [reagent.core :as reagent]))

;; Application state

(def app-state
  (reagent/atom 0))

;; Components

(defn counting-component [text on-change state]
  [:a.column { :on-click #(swap! state on-change) }
    text
  ]
)

(defn counter []
  (let [counter-state (reagent/atom 0)]
    (fn []
      [:div.columns.is-mobile.has-text-centered
        [counting-component "-" dec counter-state]
        [:span.column.title.is-2 " " @counter-state " "]
        [counting-component "+" inc counter-state]
      ]
    )
  )
)


;; Main Page

(defn page []
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
        [counter]
      ]
    ]
  ]
)

;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
  )
)


(defn reload []
  (reagent/render [page] (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
