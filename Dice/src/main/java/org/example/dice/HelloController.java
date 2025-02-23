package org.example.dice;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.Random;

public class HelloController extends Application   {
    private Label diceLabel;

    public static void main(String[] args)  { launch(args); }

    @Override
    public void start(Stage primaryStage)  {
        VBox root = new VBox();

        Button rollButton = new Button("Roll Dice");
        rollButton.setId("rollButton");
        rollButton.setOnAction((event) -> handleDiceRoll());

        diceLabel = new Label();
        diceLabel.getStyleClass().add("dice-label");

        root.getChildren().addAll(rollButton, diceLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #333333;");

        Scene scene = new Scene(root, 200, 150);
        String css = getClass().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleDiceRoll()  {
        Random rand = new Random();
        int diceNumber = rand.nextInt(6) + 1;
        diceLabel.setText("Dice Roll: " + Integer.toString(diceNumber));
    }
}