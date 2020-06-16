package application;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * handles two buttons (with PullDown-Resistors connected to PIN 22 and 23)
 * and one LED (with limiting resistor (e.g. 100 OHM) connected PIN 24)
 * 
 * GPIO access; make sure to update wiringpi!!
 * see http://wiringpi.com/wiringpi-updated-to-2-52-for-the-raspberry-pi-4b/
 */
public class GPIOPlayer {

        GpioController gpio;
        GpioPinDigitalInput btn1, btn2, btnA, btnB, btnC;
        GpioPinDigitalOutput led1;
        BooleanProperty led1State;
        BooleanProperty btn1State;
        BooleanProperty btn2State;
		BooleanProperty btnAState,btnBState, btnCState;

        public GPIOPlayer() {
            led1State = new SimpleBooleanProperty();
            btn1State = new SimpleBooleanProperty();
            btn2State = new SimpleBooleanProperty();
            btnAState = new SimpleBooleanProperty();
            btnBState = new SimpleBooleanProperty();
            btnCState = new SimpleBooleanProperty();
            gpio = GpioFactory.getInstance();
            btn1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_22, PinPullResistance.PULL_DOWN); //geht nicht ohne pulldown
            btn2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_23, PinPullResistance.PULL_DOWN);
            btnA = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_DOWN);
            btnB = gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, PinPullResistance.PULL_DOWN);
            btnC = gpio.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);
            led1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24);
            led1.setShutdownOptions(false, PinState.LOW);
            // create and register gpio pin listener
            btn1.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                    // when button is pressed, speed up the blink rate on LED #2
                    System.out.println("GPIO-PIN: "+event.getPin() + ": " + event.getState());
                    btn1State.set(event.getState().isHigh());
                    if(btn1.getState().isHigh()) {
                        led1.blink(200);
                    }
                    else {
                        led1.blink(1000);
                    }
                }
            });

            btnA.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                    System.out.println("GPIO-PIN: "+event.getPin() + ": " + event.getState());
                    btnAState.set(event.getState().isHigh());
                }
            });

            btnB.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                    System.out.println("GPIO-PIN: "+event.getPin() + ": " + event.getState());
                    btnBState.set(event.getState().isHigh());
                }
            });

            btnC.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                    System.out.println("GPIO-PIN: "+event.getPin() + ": " + event.getState());
                    btnCState.set(event.getState().isHigh());
                }
            });

            led1.addListener(new GpioPinListenerDigital() {
                @Override
                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                  led1State.set(event.getState().isHigh());
                }

            });
        }

        public BooleanProperty getLed1Property(){
          return led1State;
        }

        public BooleanProperty getBtn1Property(){
          return btn1State;
        }

        public BooleanProperty getBtn2Property(){
          return btn2State;
        }
        
        public BooleanProperty getBtnAProperty(){
          return btnAState;
        }
        
        public BooleanProperty getBtnBProperty(){
          return btnBState;
        }
        
        public BooleanProperty getBtnCProperty(){
          return btnCState;
        }

}
