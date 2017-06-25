(ns counter-app.core
 (:require
  [reagent.core :as reagent]
  [counter-app.page :as page]))

;; Initialize App

(defn dev-setup []
 (when ^boolean js/goog.DEBUG
  (enable-console-print!)
  (println "dev mode")))

(defn reload []
 (reagent/render [page/app-container] (.getElementById js/document "app")))

(defn ^:export main []
 (dev-setup)
 (reload))
