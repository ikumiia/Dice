package org.example.dice;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.Random;

public class HelloController extends Application {
    private Label diceLabel1, diceLabel2;

    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        VBox root = new VBox();
        Button rollButton = new Button("Roll Dice");
        rollButton.setId("rollButton");
        rollButton.setOnAction((event) -> handleDiceRoll());

        diceLabel1 = new Label();
        diceLabel1.getStyleClass().add("dice-label");

        diceLabel2 = new Label();
        diceLabel2.getStyleClass().add("dice-label");

        root.getChildren().addAll(rollButton, diceLabel1, diceLabel2);
        root.setAlignment(Pos.CENTER);

        root.setStyle("-fx-background-color: #333333;");

        Scene scene = new Scene(root, 200, 150);
        String css = getClass().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleDiceRoll() {
        Random rand = new Random();
        int diceNumber1 = rand.nextInt(6) + 1;
        int diceNumber2 = rand.nextInt(6) + 1;

        diceLabel1.setText("Dice Roll 1: " + Integer.toString(diceNumber1));
        diceLabel2.setText("Dice Roll 2: " + Integer.toString(diceNumber2));
    }
}