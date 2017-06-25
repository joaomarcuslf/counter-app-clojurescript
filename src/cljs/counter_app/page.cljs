(ns counter-app.page
 (:require
  [reagent.core :as reagent]
  [counter-app.containers :as containers]))

(defn app-container []
 [:div.hero.is-primary.is-fullheight
  [:div.hero-head
   [:header.nav
    [:div.container
     [:div.nav-center
      [:h1.title.is-1 "Count App"]]]]]

  [:div.hero-body
   [:div.container.is-fullwidth.has-text-centered
    [containers/counter]
    [containers/counter]]]])
