
## Requirements

sudo apt install chromium-browser chromium-ublock-origin openjdk-11-jdk openjfx geany geany-plugin-commander geany-plugins-common
sudo apt install wiringpi 
sudo apt install git
sudo apt install rpi.gpio

### Optional

sudo apt install conky htop
sudo apt install xfce4 xfce4-whiskermenu-plugin xfce4-goodies xfce4-session  


## Building and Running the Code

### Manual

```
export OPENJFX=/opt/openjfx/javafx-sdk-11.0.2/lib

javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml view/MainViewController.java
javac --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application/Main.java 
javac -classpath .:classes:/opt/pi4j/lib/'*' application/MyGPIO.java

java -classpath .:classes:/opt/pi4j/lib/'*' --module-path $OPENJFX --add-modules javafx.controls,javafx.fxml application.Main

```

### Maven

* see [https://openjfx.io/openjfx-docs/#maven](https://openjfx.io/openjfx-docs/#maven)
* requires pom.xml with appropriate dependencies for jfx and rpi-gpio
* run with `mvn -X clean javafx:run`
