package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeleccionController {
    public static List<Pokemons> listaAmigos = new ArrayList<>();
    public static ArrayList<ModelController> listaController = new ArrayList<>();
    List<Pokemons> listaPokemons = new ArrayList<>();
    @FXML
    public Button botonMochila;

    @FXML
    public Button cazaPokemon;

    @FXML
    private GridPane contenedorPokemons;

    @FXML
    private Button Amigos;

    @FXML
    private Label contadorAmigos;

    @FXML
    void Amigos(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Amigos.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 550);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();

            AmigosController amigosController = fxmlLoader.getController();
            amigosController.pasarInfo(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirMochila(MouseEvent event) {

    }

    @FXML
    void cazarPokemons(MouseEvent event) {
        if (retornarPokemon().pokemons.vidaActual <= 0) {
            mostrarAlertavida();
        } else {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Escenario.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 550);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();

                EscenarioController escenarioController = fxmlLoader.getController();
                escenarioController.pasarInfo(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void cargarModelos() {

        listaPokemons.addAll(Pokemons.PokemonRepository.getData());

        int columnas = 0;
        int filas = 0;

        try {
            for (int i = 0; i < listaPokemons.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("modelo.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                ModelController modelController = fxmlLoader.getController();

                modelController.setData(listaPokemons.get(i), this);

                listaController.add(modelController);

                contenedorPokemons.add(anchorPane, columnas++, filas);
                if (columnas == 3) {
                    columnas = 0;
                    filas++;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        botonMochila.setVisible(false);
        cazaPokemon.setVisible(false);
    }

    public void pokemonSeleccionado() {
        for (ModelController controller : listaController) {
            controller.pokemonNoSeleccionado();
        }
    }

    public static ModelController retornarPokemon() {
        ModelController controllerseleccionado = null;
        for (ModelController controller : listaController) {
            if (controller.pokemons.isSeleccionado()) {
                controllerseleccionado = controller;
            }
        }
        return controllerseleccionado;
    }

    public void actualizarpoke() throws IOException {
        retornarPokemon().setData(retornarPokemon().pokemons, this);
    }


    private void mostrarAlertavida() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Pokemon sin vida");
        alert.setContentText("El pokemon: " + retornarPokemon().pokemons.nombrepokemon + " esta muerto");
        alert.showAndWait();
    }

    public void actualizarContadorAmigos(){
        contadorAmigos.setText(String.valueOf(listaAmigos.size()));
    }
}