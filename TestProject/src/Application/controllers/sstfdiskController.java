package Application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.Label;
import java.io.IOException;
import java.util.Vector;

public class sstfdiskController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Object output;
    @FXML
    private TextField queueInput;
    @FXML
    private TextField pointerInput;
    @FXML
    private Label label;

    @FXML
    public void goToDisk(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/diskUi.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/welcome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    Vector<Integer> queueArray = new Vector<Integer>();

    public void submitButten(ActionEvent event) {

        String headPointer = pointerInput.getText();
        String queue = queueInput.getText();
        if(headPointer.isEmpty()){

            label.setText("Invalid Input: Pointer is empty!");
            return;
        }
        else if(queue.isEmpty()){
            label.setText("Invalid Input: queue is empty!");
            return;
        }

        int pointer = Integer.parseInt(headPointer);
        String[] tokenQueue = queue.split(" ");
        for(String token: tokenQueue){
            queueArray.add(Integer.parseInt(token));
        }
        queueArray.add( pointer);

        int seekDistance =0;

        while (!queueArray.isEmpty()) {

            int minDistance = Integer.MAX_VALUE;
            int closestIndex = -1;

            for (int i = 0; i < queueArray.size(); i++) {
                int distance = Math.abs(queueArray.get(i) - pointer);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestIndex = i;
                }
            }

            pointer = queueArray.get(closestIndex);
            seekDistance += minDistance;

            queueArray.remove(closestIndex);
        }

        label.setText(String.valueOf(seekDistance));
        queueArray.clear();


    }
}