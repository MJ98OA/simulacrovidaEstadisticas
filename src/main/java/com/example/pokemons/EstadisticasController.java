package com.example.pokemons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class EstadisticasController {


    @FXML
    private PieChart curacionesPokemons;

    public static SeleccionController controller;
    public static int totalcuraciones=obtenercuracionestotales();

    static ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(
            new PieChart.Data(Pokemons.PokemonRepository.getData().get(0).nombrepokemon + " " +Pokemons.PokemonRepository.getData().get(0).cantidadCuras, Pokemons.PokemonRepository.getData().get(0).cantidadCuras),
            new PieChart.Data( Pokemons.PokemonRepository.getData().get(1).nombrepokemon + " " + Pokemons.PokemonRepository.getData().get(0).cantidadCuras , Pokemons.PokemonRepository.getData().get(1).cantidadCuras),
            new PieChart.Data(Pokemons.PokemonRepository.getData().get(2).nombrepokemon + " " +Pokemons.PokemonRepository.getData().get(0).cantidadCuras, Pokemons.PokemonRepository.getData().get(2).cantidadCuras),
            new PieChart.Data(Pokemons.PokemonRepository.getData().get(3).nombrepokemon + " " + Pokemons.PokemonRepository.getData().get(0).cantidadCuras , Pokemons.PokemonRepository.getData().get(3).cantidadCuras),
            new PieChart.Data(Pokemons.PokemonRepository.getData().get(4).nombrepokemon + " " + Pokemons.PokemonRepository.getData().get(0).cantidadCuras, Pokemons.PokemonRepository.getData().get(4).cantidadCuras),
            new PieChart.Data(Pokemons.PokemonRepository.getData().get(5).nombrepokemon + " " + Pokemons.PokemonRepository.getData().get(0).cantidadCuras , Pokemons.PokemonRepository.getData().get(5).cantidadCuras),
            new PieChart.Data("Total de curas: " + totalcuraciones ,totalcuraciones)
    );




    public void pasarInfoEstadisticas(SeleccionController controller) {
        EstadisticasController.controller = controller;
        curacionesPokemons.setData(piechartData);
    }


    public void actualizar() {

        for (int i=0; i<piechartData.size(); i++) {
            if(i<=5){
                piechartData.get(i).setName(Pokemons.PokemonRepository.getData().get(i).nombrepokemon + " " +Pokemons.PokemonRepository.getData().get(i).cantidadCuras);
                piechartData.get(i).setPieValue(Pokemons.PokemonRepository.getData().get(i).cantidadCuras);
            }else{
                piechartData.get(i).setPieValue(totalcuraciones=obtenercuracionestotales());
                piechartData.get(i).setName("Total de curas: " + totalcuraciones );
            }


        }
    }

    public static int obtenercuracionestotales(){
        int suma=0;
        for(int i=0;i<Pokemons.PokemonRepository.getData().size();i++){
            suma+= Pokemons.PokemonRepository.getData().get(i).cantidadCuras;
        }
        return suma;
    }




}
