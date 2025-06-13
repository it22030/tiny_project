package Application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class welcomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void switchMemoryAllocation(ActionEvent event)  throws Exception{
        root = FXMLLoader.load(getClass().getResource("/Application/resources/memory.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void diskButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/diskUi.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pagereplacement(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/Application/resources/pagereplacement.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToProcess(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/processCD.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToDeadlock(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/deadlock.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}






