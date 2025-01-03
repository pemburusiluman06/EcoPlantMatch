package Controller;

import DAO.DBController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fungsi {

    public static String lastPage = "/UI/homepage.fxml";

    public Fungsi(String lastPage) {
        this.lastPage = lastPage;
    }

    public Fungsi() {
    }

    public static String getLastPage() {
        return lastPage;
    }

    public static void setLastPage(String lastPage) {
        Fungsi.lastPage = lastPage;
    }

    public static void ChangeScene(ActionEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(DBController.class.getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}