(ns counter-app.containers
 (:require
  [reagent.core :as reagent]
  [counter-app.components :as components]))


(defn counter []
 (let [counter-state (reagent/atom 0)] [components/counter counter-state]))
