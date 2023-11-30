package files.controllerGUI;

import files.ControllerModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController extends MainGUI {

    @FXML Text counter;
    @FXML Button retryButton;
    @FXML Button exitButton;
    @FXML private Pane pane; @FXML Pane winPane;
    @FXML private AnchorPane anchorPane;
    @FXML private GridPane gridPanel;
    @FXML private Text error;
    private ImageView imageView=new ImageView(new Image("/win.png"));
    private int counterC=-1;

   public void initialize(int value)
    {   this.setController(new ControllerModel(value,value));
        updateView();
        counter.setVisible(false);
        gridPanel.setStyle("-fx-border-color: black;");
   }

   public void onClicked(int i, int j)
   {
       error.setVisible(false);
       boolean ok=this.getController().moveNumberAtOnce(i,j);
       if(!ok)
            error.setVisible(true);
       updateView();
   }

    public void updateView()
    {
        counterC++;
        gridPanel.getChildren().removeAll(gridPanel.getChildren());

        for(int i=0; i<this.getController().getHeight();i++)
        {
            for (int j = 0; j < this.getController().getLength(); j++)
            {
                Text text=new Text(this.getController().getMatrix()[i][j]+"");
                text.setLayoutX(30);
                text.setLayoutY(30);
                text.setTextAlignment(TextAlignment.CENTER);
                text.setStyle("-fx-fill: green;-fx-font-size: 30;");
                if(this.getController().getMatrix()[i][j]==0)
                    text.setStyle("-fx-fill: red;-fx-font-size: 30;");
                pane = new Pane(text);
                pane.setStyle("-fx-background-color: yellow; -fx-alignment: center; -fx-border-color: black;");

                int finalJ = j;
                int finalI = i;
                gridPanel.add(pane,j,i); //because the grid has j rows and i columns
                int dim=getController().getLength();
                gridPanel.getChildren().get(i*dim+j).setOnMouseClicked(event -> { onClicked(finalI, finalJ);});
            }
        }

        gridPanel.setPrefWidth(gridPanel.getColumnCount()*100);
        gridPanel.setPrefHeight(gridPanel.getRowCount()*50);
        gridPanel.setLayoutX((anchorPane.getPrefWidth()-gridPanel.getPrefWidth())/2);
        gridPanel.setLayoutY((anchorPane.getPrefHeight()-gridPanel.getPrefHeight())/2);

        if(controller.hasWin(controller.getMatrix()))
        {
            winPane.toFront();
            counter.setText(counterC+"");
            retryButton.setVisible(true);
            counter.setVisible(true);
            for(int i=0; i<this.getController().getHeight();i++)
            {
                for (int j = 0; j < this.getController().getLength(); j++)
                {
                    int dim=getController().getLength();
                    gridPanel.getChildren().get(i*dim+j).setOnMouseClicked(event -> { });
                }
            }

            imageView.setFitHeight(200);
            imageView.setFitWidth(310);
            winPane.getChildren().add(imageView);
            winPane.setVisible(true);
        }
    }

    public void retryClick() throws IOException {
        retryButton.setVisible(false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/intro.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) retryButton.getScene().getWindow(); // Replace "button" with the appropriate UI element
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
    }
    public void exitClick()
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }



    //try to add a new thing in the git
}


