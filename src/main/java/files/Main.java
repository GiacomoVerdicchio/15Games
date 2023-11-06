package files;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args)
    {
        System.out.println("Choose if you want CLI or GUI");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        String in = scanner.nextLine();
        if(in.equals("cli") || in.equals("CLI")|| in.equals("Cli"))
        {
            MainCLI mainCLI = new MainCLI();
            mainCLI.mainThreadCLI();
        }
        else {
            launch();
        }

    }




    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/intro.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello, let's play!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
