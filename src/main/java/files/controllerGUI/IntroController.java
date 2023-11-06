package files.controllerGUI;

import files.ControllerModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroController extends MainGUI {

    @FXML
    private Button buttonHello;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private Text errorLabel;
    @FXML
    protected void clickHello() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
        Parent root = fxmlLoader.load();

        MainScreenController mainScreenController = fxmlLoader.getController();
        if(check4.isSelected()) {
            mainScreenController.initialize(4);
        }
        else if (check3.isSelected()) {
            mainScreenController.initialize(3);
        }
        else {
            errorLabel.setVisible(true);
            return;
        }
        // Access the current stage and set the new scene
        Stage stage = (Stage) buttonHello.getScene().getWindow(); // Replace "button" with the appropriate UI element
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
    }

    @FXML
    protected void onClick3() throws IOException {
        check3.setSelected(true);
        check4.setSelected(false);
        errorLabel.setVisible(false);
    }
    @FXML
    protected void onClick4() throws IOException {
        check4.setSelected(true);
        check3.setSelected(false);
        errorLabel.setVisible(false);
    }
}