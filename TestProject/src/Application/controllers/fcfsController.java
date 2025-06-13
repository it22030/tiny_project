package Application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Vector;

import static java.lang.Math.*;
import static java.util.Collections.max;
public class fcfsController {
    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML

    public void goToDisk(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/diskUi.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToHome(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/Application/resources/welcome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField QueueInput;
    @FXML
    private TextField PointerInput;
    @FXML
    private Label outputLabel;



   Vector<Integer> queueArray = new Vector<>();
    public void submitBotton(ActionEvent event) throws IOException{

            String headPointer = PointerInput.getText();
            String queue = QueueInput.getText();
            if(headPointer.isEmpty()){
                outputLabel.setText("Invalid Input: Pointer is empty!");
                return;
            }
            else if(queue.isEmpty()){
                outputLabel.setText("Invalid Input: queue is empty!");
                return;
            }
            int pointer = Integer.parseInt(headPointer);
            String[] tokenQueue = queue.split(" ");
            for(String token: tokenQueue){
                queueArray.add(Integer.parseInt(token));
            }
            int seekDistance = abs(queueArray.elementAt(0) - pointer);
            for(int i = 1; i < queueArray.size(); i++){
                seekDistance+=abs(queueArray.elementAt(i)- queueArray.elementAt(i-1));
            }
            outputLabel.setText(String.valueOf(seekDistance));

            queueArray.clear();
        }








}



