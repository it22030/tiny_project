package Application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class diskController {
    private Stage stage;
    private Scene scene;
    private Parent root;
@FXML
    public void goTofcfs(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/fcfs.fxml"));
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
    public void goToSSTF(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Application/resources/sstfdisk.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}








