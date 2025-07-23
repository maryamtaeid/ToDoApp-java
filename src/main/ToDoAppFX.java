package at.fhj.msd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ToDoAppFX extends Application {
    private final ArrayList<String> tasks = new ArrayList<>();
    private final ListView<String> taskListView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");

        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove selected");
        addButton.setOnAction(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskListView.getItems().add(task);
                taskInput.clear();
            }
        });
        removeButton.setOnAction(e -> {
            int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                tasks.remove(selectedIndex);
                taskListView.getItems().remove(selectedIndex);
            }
        });
        VBox layout = new VBox(10, taskInput, addButton, removeButton, taskListView);
        layout.setStyle("-fx-padding: 20; -fx-font-size: 14px;");
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
