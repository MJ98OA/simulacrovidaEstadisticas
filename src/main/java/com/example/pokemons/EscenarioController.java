package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class EscenarioController {

    private int i;

    private Pokemons datosMiPokemon;

    private List<Pokemons> listaPokemons = Pokemons.PokemonRepository.listaEnemigos();

    private SeleccionController seleccionController=null;

    @FXML
    private Button Alimentar;

    @FXML
    void Alimentar(MouseEvent event) throws IOException {
            if(new Random().nextBoolean()){
                listaPokemons.get(i).vecesAlimentado+=1;
                Pokemons pokeAmigo= new Pokemons(listaPokemons.get(i).nombrepokemon,listaPokemons.get(i).vecesAlimentado);
                seleccionController.listaAmigos.add(pokeAmigo);
                listaPokemons.get(i).vecesAlimentado=0;
                seleccionController.actualizarContadorAmigos();
                alertacaza();
            }else{
                listaPokemons.get(i).vecesAlimentado+=1;
                ataques(new Random().nextInt(2)+1);
                vidaMiPokemon.setProgress(cargarvidaMiPokemon());
                seleccionController.actualizarpoke();
            }

    }

    @FXML
    private Button bAtacar;

    @FXML
    private Button bCurar;

    @FXML
    private AnchorPane fondoBatalla;

    @FXML
    private ImageView fondo;

    @FXML
    private ImageView miPokemon;

    @FXML
    private Label nivelMiPokemon;

    @FXML
    private Label nivelPokemonEnemigo;

    @FXML
    private Label nombreMiPokemon;

    @FXML
    private Label nombrePokemonEnemigo;

    @FXML
    private ImageView pokemonEnemigo;

    @FXML
    private ImageView psimgA;

    @FXML
    private ImageView psimgE;

    @FXML
    private Label txAtaque1;

    @FXML
    private Label txAtaque2;

    @FXML
    private Label txAtaque3;

    @FXML
    private Label txCancelar;

    @FXML
    private Label vidaActualA;

    @FXML
    private Label vidaActualE;

    @FXML
    private ProgressBar vidaMiPokemon;

    @FXML
    private ProgressBar vidaPokemonEnemigo;




    @FXML
    void bAtaque1(MouseEvent event) throws IOException {

        int opcion1 = 1;

        if (vivoCombateAliado()) {
            ataquesEnemigo(opcion1);
            vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
            vidaActualE.setText(listaPokemons.get(i).getVidaActual() + "");
        }

        if (vivoCombate()) {
            ataques(opcion1);
            vidaMiPokemon.setProgress(cargarvidaMiPokemon());
            vidaActualA.setText(datosMiPokemon.getVidaActual() + "");
        }

        if (listaPokemons.get(i).getVidaActual() <= 0 || datosMiPokemon.getVidaActual() <= 0) {
            alerta();

        }
        seleccionController.actualizarpoke();



    }

    @FXML
    void bAtaque2(MouseEvent event) throws IOException {
        int opcion1 = 2;

        if (vivoCombateAliado()) {
            ataquesEnemigo(opcion1);
            vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
            vidaActualE.setText(listaPokemons.get(i).getVidaActual() + "");
        }

        if (vivoCombate()) {
            ataques(opcion1);
            vidaMiPokemon.setProgress(cargarvidaMiPokemon());
            vidaActualA.setText(datosMiPokemon.getVidaActual() + "");

        }

        if (listaPokemons.get(i).getVidaActual() <= 0 || datosMiPokemon.getVidaActual() <= 0) {
            alerta();

        }
        seleccionController.actualizarpoke();


    }


    @FXML
    void bAtaque3(MouseEvent event) throws IOException {
        int opcion1 = 3;


        if (vivoCombateAliado()) {
            ataquesEnemigo(opcion1);
            vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
            vidaActualE.setText(listaPokemons.get(i).getVidaActual() + "");
        }

        if (vivoCombate()) {
            ataques(opcion1);
            vidaMiPokemon.setProgress(cargarvidaMiPokemon());
            vidaActualA.setText(datosMiPokemon.getVidaActual() + "");

        }

        if (listaPokemons.get(i).getVidaActual() <= 0 || datosMiPokemon.getVidaActual() <= 0) {
            alerta();

        }
        seleccionController.actualizarpoke();


    }


    @FXML
    void bCurar(MouseEvent event) {
        curarse();
        curarseEnemigo();

    }

    @FXML
    void bMenuAtaques(MouseEvent event) {

        botonesAtaquesOn();
        botonesMenuInicioOf();

    }


    @FXML
    void bcancelar(MouseEvent event) {
        botonesAtaquesOf();
        botonesMenuInicioOn();

    }

    @FXML
    void mostrarvida(MouseEvent event) {
        vidaActualA.setVisible(true);
        psimgA.setVisible(false);
    }

    @FXML
    void mostrarvidaE(MouseEvent event) {
        vidaActualE.setVisible(true);
        psimgE.setVisible(false);
    }

    @FXML
    void ocultarvida(MouseEvent event) {
        vidaActualA.setVisible(false);
        psimgA.setVisible(true);
    }

    @FXML
    void ocultarvidaE(MouseEvent event) {
        vidaActualE.setVisible(false);
        psimgE.setVisible(true);
    }



    public void alerta() {
        Alert customAlert = new Alert(Alert.AlertType.NONE);
        customAlert.setTitle("Combate Finalizado");
        customAlert.setContentText("Pokemon ganador: "+ganador().getNombrepokemon());
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE, ButtonType.NEXT);


        Image imggenero=new Image(ganador().getImgenpokemon());
        ImageView imgGanador=new ImageView(imggenero);
        customAlert.setGraphic(imgGanador);

        showAlert(customAlert);

    }

    private void showAlert(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.CLOSE) {
            System.exit(0);
        }

        if (resultado.get()==ButtonType.NEXT){
            Stage stage = (Stage) fondoBatalla.getScene().getWindow();
            stage.close();

        }

    }

    public void alertacaza() {
        Alert customAlert = new Alert(Alert.AlertType.NONE);
        customAlert.setTitle("Pokemon Alimentado");
        customAlert.setContentText("El pokemon: "+listaPokemons.get(i).getNombrepokemon() +" se ha hecho tu amigo");
        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);
        showAlertcaza(customAlert);

    }

    private void showAlertcaza(Alert alert) {

        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == ButtonType.CLOSE) {
            Stage stage = (Stage) fondoBatalla.getScene().getWindow();
            stage.close();
        }

    }



    public Boolean vivoCombate() {
        return (listaPokemons.get(i).getVidaActual()>0);
    }

    public Boolean vivoCombateAliado() {return (datosMiPokemon.getVidaActual()>0);}

    public void curarse() {
        Random r = new Random();
        int n = r.nextInt(75 - 25 + 1) + 25;

        if ((datosMiPokemon.getVidaActual() + n) > datosMiPokemon.getVidaMaxima()) {
            datosMiPokemon.setVidaActual(datosMiPokemon.getVidaMaxima());
            vidaMiPokemon.setProgress(cargarvidaMiPokemon());
            vidaActualA.setText(datosMiPokemon.getVidaMaxima() + "");
            cargarvidaMiPokemon();
        } else {
            datosMiPokemon.setVidaActual(datosMiPokemon.getVidaActual() + n);
            vidaMiPokemon.setProgress(cargarvidaMiPokemon());
            vidaActualA.setText(datosMiPokemon.getVidaActual() + "");
            cargarvidaMiPokemon();
        }


    }

    public void curarseEnemigo() {
        Random r = new Random();
        int n = r.nextInt(75 - 25 + 1) + 25;

        if ((listaPokemons.get(i).getVidaActual() + n) > listaPokemons.get(i).getVidaMaxima()) {
            listaPokemons.get(i).setVidaActual(listaPokemons.get(i).getVidaMaxima());
            vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
            vidaActualE.setText(listaPokemons.get(i).getVidaMaxima() + "");
            cargarvidaEnemigo();
        } else {
            listaPokemons.get(i).setVidaActual(listaPokemons.get(i).getVidaActual() + n);
            vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
            vidaActualE.setText(listaPokemons.get(i).getVidaActual() + "");
            cargarvidaEnemigo();
        }


    }

    public void ataques(int opcionAtaque) {
        int ataqueEnemigosimple=20;
        int ataqueEnemigo =new Random().nextInt(25 - 10 + 1) + 10;
        int ataqueEnemigo2=new Random().nextInt(50);
        if(datosMiPokemon.getVidaActual()-ataqueEnemigosimple<0 || datosMiPokemon.getVidaActual()-ataqueEnemigo<0 || datosMiPokemon.getVidaActual()-ataqueEnemigo2<0 )
            datosMiPokemon.setVidaActual(0);
        else {
            switch (opcionAtaque) {

                case 1 -> {

                    datosMiPokemon.setVidaActual(datosMiPokemon.getVidaActual() - ataqueEnemigosimple);

                }
                case 2 -> {

                    datosMiPokemon.setVidaActual(datosMiPokemon.getVidaActual() - ataqueEnemigo);

                }
                case 3 -> {

                    datosMiPokemon.setVidaActual(datosMiPokemon.getVidaActual() - ataqueEnemigo2);

                }
            }
        }

    }

    public void ataquesEnemigo(int opcionAtaque) {
        int ataqueSimple=20;
        int ataque2 = new Random().nextInt(25 - 10 + 1) + 10;
        int ataque3= new Random().nextInt(50);

        if(listaPokemons.get(i).getVidaActual()-ataqueSimple<0 || listaPokemons.get(i).getVidaActual()-ataque2<0 || listaPokemons.get(i).getVidaActual()-ataque3<0 )
            listaPokemons.get(i).setVidaActual(0);
        else {
            switch (opcionAtaque) {


                case 1 -> {

                    listaPokemons.get(i).setVidaActual(listaPokemons.get(i).getVidaActual() - ataqueSimple);

                }
                case 2 -> {

                    listaPokemons.get(i).setVidaActual(listaPokemons.get(i).getVidaActual() - ataque2);

                }
                case 3 -> {

                    listaPokemons.get(i).setVidaActual(listaPokemons.get(i).getVidaActual() - ataque3);
                }

            }
        }


    }


    public double cargarvidaEnemigo() {

        int vidaMaxima = listaPokemons.get(i).getVidaMaxima();
        int vidaActual = listaPokemons.get(i).getVidaActual();
        double resultadovida = (double) vidaActual / vidaMaxima;

        if(resultadovida>0.7){
            vidaPokemonEnemigo.setStyle("-fx-accent: #00FA00");
        }else
            if(resultadovida>=0.4 && resultadovida<0.7)
                vidaPokemonEnemigo.setStyle("-fx-accent:yellow");
                else
                    if(resultadovida<0.3)
                        vidaPokemonEnemigo.setStyle("-fx-accent:red");

        return resultadovida;
    }

    public double cargarvidaMiPokemon() {

        int vidaMaxima = datosMiPokemon.getVidaMaxima();
        int vidaActual = datosMiPokemon.getVidaActual();
        double resultadovida = (double) vidaActual / vidaMaxima;
        if(resultadovida>0.7){
            vidaMiPokemon.setStyle("-fx-accent: #00FA00");
        }else
            if(resultadovida>=0.4 && resultadovida<0.7)
                vidaMiPokemon.setStyle("-fx-accent:yellow");
            else
                if(resultadovida<0.3)
                    vidaMiPokemon.setStyle("-fx-accent:red");

        return resultadovida;

    }



    public void cargarDatosPokemon() {
        nombreMiPokemon.setText(datosMiPokemon.getNombrepokemon());
        Image imgMiPokemon = new Image(datosMiPokemon.getImgenpokemon());
        miPokemon.setImage(imgMiPokemon);
        nivelMiPokemon.setText("" + datosMiPokemon.getNivelpokemon());
        vidaMiPokemon.setProgress(cargarvidaMiPokemon());
        Image imgps = new Image(datosMiPokemon.getImagenps());
        psimgA.setImage(imgps);
        vidaActualA.setText(datosMiPokemon.getVidaActual() + "");
        vidaActualA.setVisible(false);

    }


    public void cargarDatosPokemonEnemigo() {
        nombrePokemonEnemigo.setText(listaPokemons.get(i).getNombrepokemon());
        File f1 = new File(listaPokemons.get(i).getImgenpokemon());
        listaPokemons.get(i).setImgenpokemon(f1.toURI().toString());
        Image imgPokemonEnemigo = new Image(listaPokemons.get(i).getImgenpokemon());
        pokemonEnemigo.setImage(imgPokemonEnemigo);
        nivelPokemonEnemigo.setText("" + listaPokemons.get(i).getNivelpokemon());

        vidaPokemonEnemigo.setProgress(cargarvidaEnemigo());
        File f2 = new File(listaPokemons.get(i).getImagenps());
        listaPokemons.get(i).setImagenps(f2.toURI().toString());
        Image imgPsE = new Image(listaPokemons.get(i).getImagenps());
        psimgE.setImage(imgPsE);

        vidaActualE.setText(listaPokemons.get(i).getVidaActual() + "");
        vidaActualE.setVisible(false);

    }


    public void botonesAtaquesOf() {
        txAtaque1.setVisible(false);
        txAtaque2.setVisible(false);
        txAtaque3.setVisible(false);
        txCancelar.setVisible(false);
    }

    public void botonesAtaquesOn() {
        txAtaque1.setVisible(true);
        txAtaque2.setVisible(true);
        txAtaque3.setVisible(true);
        txCancelar.setVisible(true);
    }

    public void botonesMenuInicioOf() {
        bAtacar.setVisible(false);
        bCurar.setVisible(false);
    }

    public void botonesMenuInicioOn() {
        bAtacar.setVisible(true);
        bCurar.setVisible(true);
    }





    public void aleatorio(){
        Random r=new Random();
        this.i=r.nextInt(listaPokemons.size());
    }

    public Pokemons ganador(){
        if(datosMiPokemon.getVidaActual()>0)
            return datosMiPokemon;
        else
            return listaPokemons.get(i);
    }

    public void pasarInfo(SeleccionController controller) {
        datosMiPokemon = controller.retornarPokemon().pokemons;
        seleccionController = controller;

        aleatorio();
        botonesAtaquesOf();
        cargarDatosPokemon();
        cargarDatosPokemonEnemigo();
        File f2 = new File("src\\main\\java\\com\\example\\pokemons\\img\\escenarioBatalla.png");
        String url=(f2.toURI().toString());
        Image imgfondo = new Image(url);
        fondo.setImage(imgfondo);

    }



}

