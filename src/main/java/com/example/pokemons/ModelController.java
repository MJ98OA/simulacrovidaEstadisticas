package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

import java.io.IOException;


public class ModelController {
    public Pokemons pokemons;
    private SeleccionController controllerVentanaAnterior;

    @FXML
    private ImageView efecto;

    @FXML
    private Label barra;

    @FXML
    public ProgressBar barravidapokemon;

    @FXML
    private Button botonseleccion;

    @FXML
    public HBox fondoeleccion;

    @FXML
    private ImageView iconopspokemon;

    @FXML
    private ImageView imgpokemon;

    @FXML
    private Label nivelpokemon;

    @FXML
    public Label nombrepokemon;

    @FXML
    private ImageView sexopokemon;

    @FXML
    public Label vidaActual;

    @FXML
    private Label vidaMaxima;


    @FXML
    public void seleccionPokemon(MouseEvent event) throws IOException {

        controllerVentanaAnterior.pokemonSeleccionado();
        fondoeleccion.setStyle("-fx-background-color: #A99DB0");
        nombrepokemon.setTextFill(Paint.valueOf("#E8F6F8"));
        nivelpokemon.setTextFill(Paint.valueOf("#E8F6F8"));
        vidaActual.setTextFill(Paint.valueOf("#E8F6F8"));
        vidaMaxima.setTextFill(Paint.valueOf("#E8F6F8"));
        barra.setTextFill(Paint.valueOf("#E8F6F8"));
        controllerVentanaAnterior.cazaPokemon.setVisible(true);
        pokemons.seleccionado = true;


    }


    public void setData(Pokemons pokemons, SeleccionController controller) throws IOException {
        controllerVentanaAnterior = controller;
        this.pokemons = pokemons;
        nombrepokemon.setText(pokemons.getNombrepokemon());
        nivelpokemon.setText("Nv" + pokemons.getNivelpokemon());
        vidaActual.setText("" + pokemons.getVidaActual());
        vidaMaxima.setText("" + pokemons.getVidaMaxima());
        Image imggenero = new Image(pokemons.getImagengenero());
        sexopokemon.setImage(imggenero);
        Image imgpoke = new Image(pokemons.getImgenpokemon());
        imgpokemon.setImage(imgpoke);
        Image imgps = new Image(pokemons.getImagenps());
        iconopspokemon.setImage(imgps);
        cargarvidaMiPokemon(pokemons);



    }


    public void pokemonNoSeleccionado() {
        fondoeleccion.setStyle("-fx-background-color: #524659");
        nombrepokemon.setTextFill(Paint.valueOf("#86C4FF"));
        nivelpokemon.setTextFill(Paint.valueOf("#86C4FF"));
        vidaActual.setTextFill(Paint.valueOf("#86C4FF"));
        vidaMaxima.setTextFill(Paint.valueOf("#86C4FF"));
        barra.setTextFill(Paint.valueOf("#86C4FF"));
        pokemons.seleccionado=false;
    }


    public void cargarvidaMiPokemon(Pokemons pokemonsactual) {

        int vidaMaxima = pokemonsactual.getVidaMaxima();
        int vidaActualpokemon = pokemonsactual.getVidaActual();
        double resultadovida = (double) vidaActualpokemon / vidaMaxima;

        if (resultadovida > 0.7) {
            barravidapokemon.setStyle("-fx-accent:#00FA00");
            barravidapokemon.setProgress(resultadovida);
            vidaActual.setText(String.valueOf(pokemonsactual.getVidaActual()));
        } else if (resultadovida >= 0.4 && resultadovida < 0.7) {
            barravidapokemon.setStyle("-fx-accent:yellow");
            barravidapokemon.setProgress(resultadovida);
            vidaActual.setText(String.valueOf(pokemonsactual.getVidaActual()));
        } else if (resultadovida < 0.3) {
            barravidapokemon.setStyle("-fx-accent:red");
            barravidapokemon.setProgress(resultadovida);
            vidaActual.setText(String.valueOf(pokemonsactual.getVidaActual()));
        }
    }


}
