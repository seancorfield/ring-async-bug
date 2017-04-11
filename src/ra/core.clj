(ns ra.core
  (:require [ring.adapter.jetty :as j]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.util.response :as r])
  (:gen-class))

(defn handler [req yes no]
  (println req)
  (if-let [msg (-> req :params :fail)]
    (no (ex-info "I'm failing" {:fail msg}))
    (yes (-> (r/response "Yes please!")
             (r/content-type "text/html")))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (j/run-jetty (-> #'handler
                   wrap-keyword-params
                   wrap-params)
               {:async? true :port 8080}))
