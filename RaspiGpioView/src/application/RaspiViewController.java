package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.RadioButton;
import java.net.URL;
import java.util.ResourceBundle;

public class RaspiViewController implements Initializable{
    @FXML
    private RadioButton button1;
    @FXML
    private RadioButton button2;
    @FXML
    private RadioButton led1;
    
    public void initialize(URL url, ResourceBundle bundle){
		//do what u want here if u have 2
	}
    

    // Event Listener on Button.onAction
    @FXML
    public void exitButtonPressed(ActionEvent event) {
		Platform.exit();
    }

    public BooleanProperty getLed1Property(){
        return led1.selectedProperty();
    }
    public BooleanProperty getBtn1Property(){
        return button1.selectedProperty();
    }
    public BooleanProperty getBtn2Property(){
        return button2.selectedProperty();
    }

}
