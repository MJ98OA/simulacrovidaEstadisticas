package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeleccionController {

    public static ArrayList<ModelController> listaController = new ArrayList<>();
    List<Pokemons> listaPokemons = new ArrayList<>();
    EstadisticasController estadisticasController = null;


    @FXML
    public Button cazaPokemon;

    @FXML
    private GridPane contenedorPokemons;

    @FXML
    private Button estadisticas;

    @FXML
    private Button mochila;

    @FXML
    void abrirEstadisticas(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Estadisticas.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 550);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();

            EstadisticasController controller = fxmlLoader.getController();
            estadisticasController = controller;
            controller.pasarInfoEstadisticas(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirMochila(MouseEvent event) {
        if (!comprobarTodosCurados())
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Mochila.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 550);
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();

                MochilaController controller = fxmlLoader.getController();
                controller.pasarInfo(this);

            } catch (Exception e) {
                e.printStackTrace();
            }
        else
            mostrarAlertaTodosCurados();

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

    public boolean comprobarTodosCurados() {

        int contador=0;
        for (int i = 0; i < Pokemons.PokemonRepository.getData().size(); i++) {
            if (Pokemons.PokemonRepository.getData().get(i).vidaActual == Pokemons.PokemonRepository.getData().get(i).getVidaMaxima())
                contador+=1;
        }

        return contador== Pokemons.PokemonRepository.getData().size();
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

    private void mostrarAlertaTodosCurados() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Todos Curados");
        alert.setContentText("Todos los pokemons estan al pleno");
        alert.showAndWait();
    }

    public void obtenerEstadiscticas() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Estadisticas.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            EstadisticasController estadisticasController = fxmlLoader.getController();
            this.estadisticasController = estadisticasController;
            System.out.println(estadisticasController.totalcuraciones);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actualizarEstadisticas() {
        estadisticasController.actualizar();
    }


}