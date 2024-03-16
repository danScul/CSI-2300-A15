import java.beans.EventHandler;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class App extends Application{

    private Button[][] buttons = new Button[5][5];
    boolean turn = true;
    boolean gameOver = false;
    public void start(Stage primaryStage){
        
        GridPane ticGridPane = new GridPane();
        ticGridPane.setMinSize(200, 200);
        ticGridPane.setPadding(new Insets(10, 10, 10, 10)); 
        ticGridPane.setAlignment(Pos.CENTER); 
        ticGridPane.setVgap(15); 
        ticGridPane.setHgap(15);  
        Label label = new Label("Player One's turn");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, ticGridPane);
        for(int i = 0 ; i < 5; i++){
            for(int j = 0; j < 5; j++){
                Button button = new Button();
                button.setPrefSize(50, 50);
                button.setMaxSize(50, 50);
                button.setOnMouseClicked(event -> {
                    if(button.getText().equals("")){
                        if(turn && !gameOver){
                            button.setText("X");
                            button.setStyle("-fx-background-color: red");
                            
                            if(checkWin()){
                                label.setText("PLAYER ONE WINS!");
                                gameOver = true;
                            }
                            else{
                            label.setText("Player Two's turn");
                            turn = false;
                            }
                        }
                        else if(!turn &&!gameOver){
                            button.setText("O");
                            button.setStyle("-fx-background-color: blue");
                            if(checkWin()){
                                label.setText("PLAYER TWO WINS!");
                                gameOver = true;
                            }
                            else{
                            label.setText("Player One's Turn");
                            turn = true;
                            }
                        }
                    }
                });
                buttons[i][j] = button;
                ticGridPane.add(button, j, i);
            }
        }
        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("Tic Tac Toe!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public boolean checkWin() {
        for (int i = 0; i < 5; i++) {
            if (!buttons[i][0].getText().isEmpty() &&
                buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                buttons[i][0].getText().equals(buttons[i][3].getText()) &&
                buttons[i][0].getText().equals(buttons[i][4].getText())) {
                return true;
            }
            if (!buttons[0][i].getText().isEmpty() &&
                buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                buttons[0][i].getText().equals(buttons[3][i].getText()) &&
                buttons[0][i].getText().equals(buttons[4][i].getText())) {
                return true;
            }
        }
        if (!buttons[0][0].getText().isEmpty() &&
            buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[0][0].getText().equals(buttons[2][2].getText()) &&
            buttons[0][0].getText().equals(buttons[3][3].getText()) &&
            buttons[0][0].getText().equals(buttons[4][4].getText())) {
            return true;
        }
        if (!buttons[0][4].getText().isEmpty() &&
            buttons[0][4].getText().equals(buttons[1][3].getText()) &&
            buttons[0][4].getText().equals(buttons[2][2].getText()) &&
            buttons[0][4].getText().equals(buttons[3][1].getText()) &&
            buttons[0][4].getText().equals(buttons[4][0].getText())) {
            return true;
        }
    
        return false;
    }

 
}