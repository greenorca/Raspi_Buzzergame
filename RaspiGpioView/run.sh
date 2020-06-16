#!/bin/bash
export OPENJFX=/opt/_openjfx/armv6hf-sdk/lib
java --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml -jar target/IFZ826_LW_Buzzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar
