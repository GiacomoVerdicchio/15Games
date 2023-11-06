package files.controllerGUI;

import files.ControllerModel;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MainScreenController extends MainGUI {

    @FXML
    private Pane pane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPanel;
    @FXML
    private Text error;

   public void initialize(int value)
   {
        gridPanel.setBorder(new Border(new BorderStroke(Color.BLACK,
               BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setController(new ControllerModel(value,value));
        updateView();
   }

   public void onClicked(int i, int j)
   {
       error.setVisible(false);
       boolean ok=this.getController().moveNumber(i,j);
       if(!ok)
            error.setVisible(true);
       updateView();
   }

    public void updateView()
    {
        gridPanel.getChildren().removeAll(gridPanel.getChildren());
        for(int i=0; i<this.getController().getHeight();i++)
        {
            for (int j = 0; j < this.getController().getLength(); j++)
            {
                Text text=new Text(this.getController().getMatrix()[i][j]+"");

                text.setTextAlignment(TextAlignment.CENTER);
                text.setStyle("-fx-fill: green;-fx-font-size: 10");
                if(this.getController().getMatrix()[i][j]==0)
                    text.setStyle("-fx-fill: red;");
                pane = new Pane(text);
                pane.setBorder(new Border(new BorderStroke(Color.BLACK,
                              BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                int finalJ = j;
                int finalI = i;
                gridPanel.add(pane,j,i);
                int dim=getController().getLength();
                gridPanel.getChildren().get(i*dim+j).setOnMouseClicked(event -> { onClicked(finalI, finalJ);});
            }
        }
    }

}
