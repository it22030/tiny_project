
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class worstFitController {
    @FXML
    private TextField segmentInput;
    @FXML
    private TextField processInput;
    @FXML
    private Label outputLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ActionEvent event;


  /*  public  void submitButton(ActionEvent event) {
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
        Collections.sort(segmentsArray);

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
/**/




    public void goTomemoryallocation(ActionEvent event) throws IOException {
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

   /* public void submitBotton(ActionEvent event) throws IOException{

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
        //Collections.sort(segmentsArray);
        Collections.sort(segmentsArray, Collections.reverseOrder());
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
    }/**/

    public void submitBotton(ActionEvent event) throws IOException {
        try {
            String segments = segmentInput.getText().trim();
            String processes = processInput.getText().trim();

            List<Integer> segmentsArray = new ArrayList<>();
            List<Integer> processArray = new ArrayList<>();

            for (String token : segments.split("\\s+")) {
                segmentsArray.add(Integer.parseInt(token));
            }
            for (String token : processes.split("\\s+")) {
                processArray.add(Integer.parseInt(token));
            }

            int fragmentation = 0;

            for (int process : processArray) {
                if (segmentsArray.isEmpty()) break;

                // Find the largest segment (Worst Fit Strategy)
                int maxIndex = -1, maxSize = -1;
                for (int j = 0; j < segmentsArray.size(); j++) {
                    if (segmentsArray.get(j) >= process && segmentsArray.get(j) > maxSize) {
                        maxSize = segmentsArray.get(j);
                        maxIndex = j;
                    }
                }

                // Allocate process to the largest segment
                if (maxIndex != -1) {
                    fragmentation += (segmentsArray.get(maxIndex) - process);
                    segmentsArray.remove(maxIndex); // Remove used segment
                }
            }

            // Add remaining free space to fragmentation
            for (int segment : segmentsArray) {
                fragmentation += segment;
            }

            outputLabel.setText(String.valueOf(fragmentation));

        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input! Please enter numbers only.");
        }
    }

}
