# Raspi_Buzzergame
Raspberry Pi und JavaFX (OpenJdk11) basiertes Multiplayer Buzzer Game mit GPIO

## Raspberry-Installation

1. Raspi-Image auf SD-Karte kopieren
2. Kühlkörper montieren und Raspi verkabeln (Monitor, Tastatur, Maus)
3. SD-Karte einstecken
4. Netzteil anschliessen -> entspricht "Power ON"
5. Installation abschliessen
6. Passwort ändern (für Benutzer pi)
7. WLAN konfigurieren
8. Updates installieren
	```
	sudo apt update
	sudo apt upgrade
	sudo apt install chromium-browser chromium-ublock-origin
	```
weitere Info: https://projects.raspberrypi.org/en/projects/raspberry-pi-getting-started

### Optionale Pakete
```
sudo apt install conky htop
sudo apt install xfce4 xfce4-whiskermenu-plugin xfce4-goodies xfce4-session  
```


## Raspi & GPIOs

Um mit den GeneralPurpose-Ein- und Ausgängen am Raspi arbeiten zu können, muss das WiringPi-Paket installiert werden:

### WiringPi - Bibliotheken installieren (normalerweise)

```
sudo apt install wiringpi
sudo apt install rpi.gpio
```

* testen mit `gpio readall`

**Mehr Info:** [hier](https://www.raspberrypi.org/documentation/usage/gpio/)

### WiringPi - Bibliothek für Raspi 4

* wenn `gpio readall` Fehlermeldungen ausgibt, bitte die aktuellste Version des WiringPi-Packets installieren:

```
cd /tmp
wget https://project-downloads.drogon.net/wiringpi-latest.deb
sudo dpkg -i wiringpi-latest.deb
```

### Pin-Layout

![j8header-3b-plus.png](j8header-3b-plus.png)

**Achtung:**

1. Im Gegensatz zum Arduino sind die GPIO-Pins vom Raspi nicht kurzschlussgeschützt. Bei falscher Verkabelung kann der Raspi Schaden nehmen. Bitte nutzen Sie nur 3.3V-Anschlüsse.
1. Taster  mit Pulldown-Widerstand angeschliessen (sonst liest der Raspi nur Murks :-)

![pulldown_raspi.png](pulldown_raspi.png)


### Ausprobieren (mit Console)

Teile und herrsche: wenn Eure Schaltung mit dem Terminal nicht funktioniert wird sie auch mit Java nicht funktionieren.

In der bash können GPIOs gelesen und geschrieben werden. Hier ein Beispiel zum Ansteuern des WiringPi Pin 24 als Ausgang:

```
gpio readall
gpio mode 24 OUT
gpio write 24 OFF
gpio write 24 ON
```


Weiter mit RaspiGpioDemo-Projekt...
