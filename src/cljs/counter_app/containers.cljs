(ns counter-app.containers
 (:require
  [reagent.core :as reagent]
  [counter-app.components :as components]))


(defn counter []
 (let [counter-state (reagent/atom 0)]
  (fn []
   [:div.columns.is-mobile.has-text-centered
    [components/counting-component "-" dec counter-state]
    [:span.column.title.is-2 " " @counter-state " "]
    [components/counting-component "+" inc counter-state]])))
