package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.LocalDateTime;

public class MenuBar extends Application {
    
    private static final String EXPORTS = "exports";
	private static final String EXPORTS2 = EXPORTS;
	private TextArea textBox;
    private VBox root;
	@SuppressWarnings("unused")
	private Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @SuppressWarnings({ EXPORTS2 })
	@Override
    public void start(@SuppressWarnings(EXPORTS2) Stage stage) {
        this.stage = stage;
		stage.setTitle("Menu with Green Colors");
        
        MenuButton menu = new MenuButton("Menu");
        
        MenuItem timeItem = new MenuItem("Show Time");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem colorItem = new MenuItem("Pick Color");
        MenuItem exitItem = new MenuItem("Exit");
        
        menu.getItems().addAll(timeItem, saveItem, colorItem, exitItem);
        
        textBox = new TextArea();
        textBox.setPromptText("Output");
        textBox.setPrefHeight(200);
        
        ColorPicker colorPicker = new ColorPicker(Color.LIGHTGREEN);
        colorPicker.setVisible(false);

        timeItem.setOnAction(e -> {
            textBox.appendText("Time: " + LocalDateTime.now() + "\n");
        });
        
        saveItem.setOnAction(e -> {
            try {
                java.io.FileWriter fw = new java.io.FileWriter("log.txt");
                fw.write(textBox.getText());
                fw.close();
                textBox.appendText("Text saved to log.txt\n");
            } catch (Exception ex) {
                textBox.appendText("Error saving file\n");
            }
        });
        
        colorItem.setOnAction(e -> {
            colorPicker.setVisible(true);
            colorPicker.show();
        });
        
        exitItem.setOnAction(e -> System.exit(0));
        
        colorPicker.setOnAction(e -> {
            Color selected = colorPicker.getValue();
            String hex = toHex(selected);
            
            double green = selected.getGreen();
            double red = selected.getRed();
            double blue = selected.getBlue();
            
            if (green > red && green > blue) {

                root.setStyle("-fx-background-color: " + hex + "; -fx-padding: 20;");
                textBox.appendText("Green color applied: " + hex + "\n");
            } else {
                textBox.appendText("That's not a green color! Try again.\n");
                textBox.appendText("(Green should be brighter than red and blue)\n");
            }
            
            colorPicker.setVisible(false);
        });    

        root = new VBox(10);
        root.getChildren().addAll(menu, colorPicker, textBox);
        root.setStyle("-fx-padding: 20; -fx-background-color: white;");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    private String toHex(Color color) {
        return String.format("#%02X%02X%02X",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255));
    }
}