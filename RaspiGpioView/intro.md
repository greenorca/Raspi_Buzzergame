# Einführung

Dieses Beispielprojekt demonstriert die Anzeige und Steuerung von Raspi-GPIOs mit der pi4j-Bibliothek  und JavaFX.


## Benötigte Pakete

```
sudo apt install git maven openjdk-11-jdk openjfx geany geany-plugin-commander geany-plugins-common
```

### Geany Konfiguration

* via tools->load tag files Java-Tags laden für halbwegs CodeCompletion: java-tags.zip entpacken, oder http://download.geany.org/contrib/tags/openjdk8-8u66-b01.java.tags
* ggf. Maven als Build-Tool konfigurieren

## Building and Running the Code

### Manual (von Hand, in Terminal)

```
export OPENJFX=/opt/openjfx/javafx-sdk-11.0.2/lib

javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml view/MainViewController.java
javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application/Main.java
javac -classpath .:classes:/opt/pi4j/lib/'*' application/MyGPIO.java

java -classpath .:classes:/opt/pi4j/lib/'*' --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application.Main

```

### Mit Maven - Buildumgebung

* [https://openjfx.io/openjfx-docs/#maven](https://openjfx.io/openjfx-docs/#maven)
* pom.xml enthält Abhängigkeiten (jfx, rpi-gpio)
* compilieren und ausführen mit `mvn javafx:run` oder `mvn -X clean javafx:run`
* compilieren und als JAR packen: mvn clean compile package
* ausführen: 
```
export OPENJFX=/opt/_openjfx/armv6hf-sdk/lib # make sure to have openjfx installed: https://gluonhq.com/download/javafx-11-0-2-sdk-armv6hf/
java --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml -jar target/IFZ826_LW_Buzzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar

```

