# Raspi_Buzzergame
Raspberry Pi und JavaFX (OpenJdk11) basiertes Multiplayer Buzzer Game mit GPIO

## Installation

1. Raspi-Image auf SD-Karte kopieren
2. Raspi verkabeln (Monitor, Tastatur, Maus)
3. SD-Karte einstecken
4. Netzteil anschliessen -> entspricht "Power ON"
5. Installation abschliessen
6. Passwort ändern (für Benutzer pi)
7. WLAN konfigurieren
8. Updates installieren
	- sudo apt update
	- sudo apt upgrade

weitere Info: https://projects.raspberrypi.org/en/projects/raspberry-pi-getting-started

## Raspi & GPIOs

### Bibliotheken installieren

sudo apt install wiringpi 
sudo apt install rpi.gpio

**Mehr Info:** [hier](https://www.raspberrypi.org/documentation/usage/gpio/)

### Pin-Layout

![j8header-3b-plus.png](j8header-3b-plus.png)

**Achtung:** 

1. Im Gegensatz zum Arduino sind die GPIO-Pins vom Raspi nicht kurzschlussgeschützt. Bei falscher Verkabelung kann der Raspi Schaden nehmen.
1. Taster  mit Pulldown-Widerstand angeschliessen (sonst liest der Raspi nur Murks :-)

![pulldown_raspi.png](pulldown_raspi.png)


### Ausprobieren (mit Console)

Teile und herrsche, wenn Schaltung mit Terminal nicht funktioniert wird sie auch mit Java nicht funktionieren.




Weiter mit RaspiGpioDemo-Projekt...

