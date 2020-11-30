package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

import static sample.ControlType.*;

public class Main extends Application {
ArrayList<Control> controls = new ArrayList<>();
Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 800);


        stage.show();
        stage.setTitle("Controls");
        stage.setScene(scene);



        Control control = new Control(BUTTON, BUTTON.description);
        Control control1 = new Control(TEXT, TEXT.description);
        Control control2 = new Control(TEXT_FIELD, TEXT_FIELD.description);
        controls.add(control);
        controls.add(control1);
        controls.add(control2);

        tableLayout();
    }

    public void tableLayout() {

        TableView<Control> TableViewControl = new TableView<>();

        TableColumn<Control, ControlType> columnControlType= new TableColumn<>("Control type");
        columnControlType.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Control, String> columnDescription= new TableColumn<>("Description");
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));


        TableViewControl.getColumns().addAll(columnControlType, columnDescription);
        TableViewControl.getItems().addAll(controls);
        //TableViewControl.getItems().add(new Control(BUTTON, BUTTON.description));
        //TableViewControl.getItems().add(new Control(, BUTTON.description));




      TextField textFieldSearch = new TextField();
        textFieldSearch.setTooltip(new Tooltip("type sth to search and press enter"));
                textFieldSearch.setPromptText("\uD83D\uDD0D search"); //unicode magnifying glass code
        textFieldSearch.setOnAction(event -> {
            TableViewControl.getItems().clear();

            if (TableViewControl.getItems() != null && !textFieldSearch.getText().equals(" "))            {
                TableViewControl.getItems().addAll(Controls.filtered(controls, textFieldSearch.getText()));
            }
            else {
                TableViewControl.getItems().addAll(controls);
            }

        });
        VBox root = new VBox();
        root.setSpacing(20.0D);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(new Node[]{TableViewControl, textFieldSearch});
        stage.getScene().setRoot(root);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
