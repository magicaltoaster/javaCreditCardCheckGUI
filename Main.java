package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group(), 400, 120);

        TextField notification = new TextField();
        notification.setText("Enter Card Number");
        Label passFail = new Label();
        Button checkButton = new Button();
        checkButton.setText("Check");
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Card: "), 0, 0);
        grid.add(notification, 1, 0);
        grid.add(passFail, 3, 0);
        grid.add(checkButton, 2, 0);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene);
        primaryStage.show();

        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(isValid(notification.getText()))
                passFail.setText("Accepted");
                else
                    passFail.setText("Fail");
            }
        });
    }
    public boolean isValid(String ccNum){

            int sum = 0;
            boolean alternate = false;
            for (int i = ccNum.length() - 1; i >= 0; i--)
            {
                int num = Integer.parseInt(ccNum.substring(i, i + 1));
                if (alternate)
                {
                    num *= 2;
                    if (num > 9)
                    {
                        num = (num % 10) + 1;
                    }
                }
                sum += num;
                alternate = !alternate;
            }
            return (sum % 10 == 0);
        }



    public static void main(String[] args) {
        launch(args);
    }
}
