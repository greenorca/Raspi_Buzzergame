package application;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.RadioButton;

public class RaspiViewController implements Initializable{
    @FXML
    private RadioButton button1;
    @FXML
    private RadioButton button2;
    @FXML
    private RadioButton led1;
    
    

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
