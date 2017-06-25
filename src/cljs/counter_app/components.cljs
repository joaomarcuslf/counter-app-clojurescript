(ns counter-app.components)

(defn counting-component [text on-change state]
 [:a.column { :on-click #(swap! state on-change)}
  text])
