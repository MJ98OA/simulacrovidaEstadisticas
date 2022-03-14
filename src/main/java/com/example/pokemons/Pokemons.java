package com.example.pokemons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pokemons {
    public String nombrepokemon;
    public int nivelpokemon;
    private String imgenpokemon;
    private String imagengenero;
    private String imagenps;
    public int vidaActual;
    private int vidaMaxima;
    public boolean seleccionado;
    public double cantidadCuras;


    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }




    Pokemons(String nombrepokemon, int nivelpokemon, String imgenpokemon, String imagengenero, String imagenps, int vidaActual, int vidaMaxima, int cantidadCuras, boolean seleccionado){
        this.nombrepokemon=nombrepokemon;
        this.nivelpokemon=nivelpokemon;
        this.imgenpokemon=imgenpokemon;
        this.imagengenero=imagengenero;
        this.imagenps=imagenps;
        this.vidaActual=vidaActual;
        this.vidaMaxima=vidaMaxima;
        this.cantidadCuras = cantidadCuras;
        this.seleccionado=seleccionado;
    }

    public String getNombrepokemon() {
        return nombrepokemon;
    }

    public void setNombrepokemon(String nombrepokemon) {
        this.nombrepokemon = nombrepokemon;
    }

    public int getNivelpokemon() {
        return nivelpokemon;
    }

    public void setNivelpokemon(int nivelpokemon) {
        this.nivelpokemon = nivelpokemon;
    }

    public String getImgenpokemon() {
        return imgenpokemon;
    }

    public void setImgenpokemon(String imgenpokemon) {
        this.imgenpokemon = imgenpokemon;
    }

    public String getImagengenero() {
        return imagengenero;
    }

    public void setImagengenero(String imagengenero) {
        this.imagengenero = imagengenero;
    }

    public String getImagenps() {
        return imagenps;
    }

    public void setImagenps(String imagenps) {
        this.imagenps = imagenps;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public class PokemonRepository {


        private static List<Pokemons> listaPokemons=new ArrayList<>();

        static public List<Pokemons> getData() {
            if (!listaPokemons.isEmpty()){
                return listaPokemons;
            }

            Pokemons p1=new Pokemons("Miutu",126,"src\\main\\java\\com\\example\\pokemons\\img\\mewtwo.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",200,200,0,false);
            Pokemons p2=new Pokemons("Aggron",173,"src\\main\\java\\com\\example\\pokemons\\img\\aggron-mega.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",180,180,0,false);
            Pokemons p3=new Pokemons("Arceus",128,"src\\main\\java\\com\\example\\pokemons\\img\\arceus.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",190,190,0,false);
            Pokemons p4=new Pokemons("dialga",165,"src\\main\\java\\com\\example\\pokemons\\img\\dialga.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",160,160,0,false);
            Pokemons p5=new Pokemons("Dragonite",140,"src\\main\\java\\com\\example\\pokemons\\img\\dragonite.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",250,250,0,false);
            Pokemons p6=new Pokemons("Gyarados",142,"src\\main\\java\\com\\example\\pokemons\\img\\gyarados-f.gif","src\\main\\java\\com\\example\\pokemons\\img\\male.png","src\\main\\java\\com\\example\\pokemons\\img\\ps.png",220,220,0,false);
            listaPokemons.add(p1);
            listaPokemons.add(p2);
            listaPokemons.add(p3);
            listaPokemons.add(p4);
            listaPokemons.add(p5);
            listaPokemons.add(p6);


            for (int i = 0; i < 6; i++) {

                File f = new File(listaPokemons.get(i).getImgenpokemon());
                listaPokemons.get(i).setImgenpokemon(f.toURI().toString());

                File f1 = new File("src\\main\\java\\com\\example\\pokemons\\img\\male.png");
                listaPokemons.get(i).setImagengenero(f1.toURI().toString());

                File f2 = new File("src\\main\\java\\com\\example\\pokemons\\img\\ps.png");
                listaPokemons.get(i).setImagenps(f2.toURI().toString());

            }
            return listaPokemons;
        }


        static public List<Pokemons> listaEnemigos(){
            List<Pokemons> enemigos=new ArrayList<>();
            Pokemons p1 = new Pokemons("Carnivine", 180, "src\\main\\java\\com\\example\\pokemons\\img\\carnivine.gif", "src\\main\\java\\com\\example\\pokemons\\img\\male.png", "src\\main\\java\\com\\example\\pokemons\\img\\ps.png", 190, 190,0,false);
            Pokemons p2 = new Pokemons("Entei", 204, "src\\main\\java\\com\\example\\pokemons\\img\\entei.gif", "src\\main\\java\\com\\example\\pokemons\\img\\male.png", "src\\main\\java\\com\\example\\pokemons\\img\\ps.png", 210, 210,0,false);
            Pokemons p3 = new Pokemons("Tordous", 250, "src\\main\\java\\com\\example\\pokemons\\img\\tornadus.gif", "src\\main\\java\\com\\example\\pokemons\\img\\male.png", "src\\main\\java\\com\\example\\pokemons\\img\\ps.png", 250, 250,0,false);
            Pokemons p4 = new Pokemons("Weavile", 195, "src\\main\\java\\com\\example\\pokemons\\img\\weavile-f.gif", "src\\main\\java\\com\\example\\pokemons\\img\\male.png", "src\\main\\java\\com\\example\\pokemons\\img\\ps.png", 220, 220,0,false);

            enemigos.add(p1);
            enemigos.add(p2);
            enemigos.add(p3);
            enemigos.add(p4);
            return enemigos;
        }

    }
}
