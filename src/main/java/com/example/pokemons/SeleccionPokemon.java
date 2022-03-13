package com.example.pokemons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SeleccionPokemon extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SeleccionPokemon.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 550);
        stage.setResizable(false);
        SeleccionController seleccionController = fxmlLoader.getController();
        seleccionController.cargarModelos();
        stage.setTitle("Seleccion Pokemons");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}