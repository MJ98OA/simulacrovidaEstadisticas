package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;


public class MochilaController {

    Pokemons pokemonAcurar;
    SeleccionController controller;

    @FXML
    private HBox cura10;

    @FXML
    private HBox cura10por100;

    @FXML
    private ImageView cura10pr;

    @FXML
    private ImageView cura10ps;

    @FXML
    private HBox cura20;

    @FXML
    private HBox cura20por100;

    @FXML
    private ImageView cura20pr;

    @FXML
    private ImageView cura20ps;

    @FXML
    void curar10prc(MouseEvent event) throws IOException {
        if (pokemonAcurar.getVidaActual() < pokemonAcurar.getVidaMaxima())
            if (pokemonAcurar.getVidaActual() + pokemonAcurar.getVidaMaxima() * 0.10 > pokemonAcurar.getVidaMaxima()) {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaMaxima());
                pokemonAcurar.cantidadCuras += pokemonAcurar.getVidaMaxima() * 0.10;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            } else {
                pokemonAcurar.setVidaActual((int) (pokemonAcurar.getVidaActual() + pokemonAcurar.getVidaMaxima() * 0.10));
                pokemonAcurar.cantidadCuras += pokemonAcurar.getVidaMaxima() * 0.10;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            }

    }

    @FXML
    void curar10ps(MouseEvent event) throws IOException {
        if (pokemonAcurar.getVidaActual() < pokemonAcurar.getVidaMaxima())
            if (pokemonAcurar.getVidaActual() + 10 > pokemonAcurar.getVidaMaxima()) {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaMaxima());
                pokemonAcurar.cantidadCuras += 10;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            } else {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaActual() + 10);
                pokemonAcurar.cantidadCuras += 10;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            }
    }

    @FXML
    void curar20prc(MouseEvent event) throws IOException {
        if (pokemonAcurar.getVidaActual() < pokemonAcurar.getVidaMaxima())
            if (pokemonAcurar.getVidaActual() + pokemonAcurar.getVidaMaxima() * 0.20 > pokemonAcurar.getVidaMaxima()) {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaMaxima());
                pokemonAcurar.cantidadCuras += pokemonAcurar.getVidaMaxima() * 0.20;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            } else {
                pokemonAcurar.setVidaActual((int) (pokemonAcurar.getVidaActual() + pokemonAcurar.getVidaMaxima() * 0.20));
                pokemonAcurar.cantidadCuras += pokemonAcurar.getVidaMaxima() * 0.20;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            }
    }

    @FXML
    void curar20ps(MouseEvent event) throws IOException {
        if (pokemonAcurar.getVidaActual() < pokemonAcurar.getVidaMaxima())
            if (pokemonAcurar.getVidaActual() + 20 > pokemonAcurar.getVidaMaxima()) {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaMaxima());
                pokemonAcurar.cantidadCuras += 20;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            } else {
                pokemonAcurar.setVidaActual(pokemonAcurar.getVidaActual() + 20);
                pokemonAcurar.cantidadCuras += 20;
                controller.actualizarpoke();
                controller.actualizarEstadisticas();
            }
    }


    public void pasarInfo(SeleccionController controller) {
        File f1 = new File("src\\main\\java\\com\\example\\pokemons\\img\\poti1.png");
        Image imgpoti1 = new Image(f1.toURI().toString());
        cura10ps.setImage(imgpoti1);
        File f2 = new File("src\\main\\java\\com\\example\\pokemons\\img\\poti2.png");
        Image imgpoti2 = new Image(f2.toURI().toString());
        cura20ps.setImage(imgpoti2);
        File f3 = new File("src\\main\\java\\com\\example\\pokemons\\img\\potiporcentaje1.png");
        Image imgpoti3 = new Image(f3.toURI().toString());
        cura10pr.setImage(imgpoti3);
        File f4 = new File("src\\main\\java\\com\\example\\pokemons\\img\\potiporcentaje2.png");
        Image imgpoti4 = new Image(f4.toURI().toString());
        cura20pr.setImage(imgpoti4);
        pokemonAcurar = controller.retornarPokemon().pokemons;
        this.controller = controller;
    }

}

