package com.example.bulsandcows1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GameController {
    @FXML
    private Game game;

    private int step;
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;




    public GameController() {
        this.game = new Game();
    }

    @FXML
    private void checkButtonClick(ActionEvent actionEvent){
        String playerNumber = messageField.getText();
        if(playerNumber.isEmpty()){
            return;
        }
        Game.BullCowCount count = game.calcBullsAndCows(playerNumber);
        String text = String.format("%d. Введено число %s. Быков %d, коров %d",step, playerNumber, count.getBulls(), count.getCows());
        messageArea.appendText(text +"\n");
        messageField.clear();
        messageField.requestFocus();
        if(count.getBulls() == 4){
            if(wantToPlayAgain()){
                step = 0;
                messageArea.clear();
                this.game = new Game();
            } else{
                System.exit(0);
            }
        }
    }

    private boolean wantToPlayAgain() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "WON!\n" + "Secret number: " + game.getGuessNumber() + "\n"+
                "You used " + step + " tries\n"+
                "Play again?",
                new ButtonType("Y", ButtonBar.ButtonData.YES),
                        new ButtonType("N", ButtonBar.ButtonData.NO));
        alert.setTitle("Q");
        return false;
    }
}