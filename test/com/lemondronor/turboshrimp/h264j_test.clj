(ns com.lemondronor.turboshrimp.h264j-test
  (:require [clojure.java.io :as io]
            [clojure.test :refer :all]
            [com.lemondronor.turboshrimp.h264j :as decode]
            [com.lemondronor.turboshrimp.pave :as pave])
  (:import (java.awt.image BufferedImage)))


(deftest h264-decoder-test
  (testing "h264j decoder"
    (let [decoder (decode/decoder)
          frame (-> "1-frame.pave"
                    io/resource
                    io/input-stream
                    pave/read-frame)
          ^BufferedImage img (decoder frame)]
      (is (instance? BufferedImage img))
      (is (= 672 (.getWidth img)))
      (is (= 418 (.getHeight img)))
      ;;(ImageIO/write img "png" (io/file "decoded-frame.png"))
      )))
