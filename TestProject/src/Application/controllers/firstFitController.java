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

public class firstFitController {
    @FXML
    private TextField segmentInput;
    @FXML
    private TextField processInput;
    @FXML
    private Label outputLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void submitButton(ActionEvent event) {
        String segments = segmentInput.getText();
        String processes = processInput.getText();

        Vector<Integer> segmentsArray = new Vector<>();
        Vector<Integer> processArray = new Vector<>();

        String[] segmentsToken = segments.split(" ");
        String[] processToken = processes.split(" ");

        for(String token: segmentsToken) {
            segmentsArray.add(Integer.parseInt(token));
        }
        for(String token: processToken) {
            processArray.add(Integer.parseInt(token));
        }

        int fragmentation = 0;

        for(int i = 0; i < processArray.size(); i++) {
            int current = processArray.get(i);
            for(int j = 0; j < segmentsArray.size(); j++) {
                if(segmentsArray.get(j) >= current){
                    fragmentation+=(segmentsArray.get(j) - current);
                    segmentsArray.remove(j);
                    break;
                }
            }
            System.out.println(fragmentation);
        }
        for(int i = 0; i < segmentsArray.size(); i++) {
            fragmentation+=segmentsArray.get(i);
        }

        outputLabel.setText(String.valueOf(fragmentation));
    }

    public void goTomemoryallocation(ActionEvent event) throws  IOException{
        root = FXMLLoader.load(getClass().getResource("/Application/resources/memory.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void goToHome(ActionEvent event) throws  IOException{
        root = FXMLLoader.load(getClass().getResource("/Application/resources/Welcome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

