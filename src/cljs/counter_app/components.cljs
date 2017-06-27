(ns counter-app.components)

(defn counting-component [text on-change state]
 [:a.column { :on-click #(swap! state on-change)}
  text])

(defn counter [counter-state]
 [:div.columns.is-mobile.has-text-centered
  [counting-component "-" dec counter-state]
  [:span.column.title.is-2 " " @counter-state " "]
  [counting-component "+" inc counter-state]])
