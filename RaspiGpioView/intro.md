# Manual

```
export OPENJFX=/opt/openjfx/javafx-sdk-11.0.2/lib

javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml view/MainViewController.java
javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application/Main.java 
javac -classpath .:classes:/opt/pi4j/lib/'*' application/MyGPIO.java

java -classpath .:classes:/opt/pi4j/lib/'*' --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application.Main

```



# Maven

* see [https://openjfx.io/openjfx-docs/#maven](https://openjfx.io/openjfx-docs/#maven)
* run with `mvn -X clean javafx:run`
