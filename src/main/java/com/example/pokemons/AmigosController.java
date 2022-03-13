package com.example.pokemons;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class AmigosController {
    int i = 0;
    @FXML
    private Label indicePokeAmigo;

    @FXML
    private Label listapokeAmigos;

    @FXML
    private Button siguiente;

    @FXML
    void siguiente(MouseEvent event) {

        i++;
        if(i>=controller.listaAmigos.size())
            i=0;
        indicePokeAmigo.setText("Fue necesario alimentar: " + controller.listaAmigos.get(i).vecesAlimentado + " veces al pokemon " + controller.listaAmigos.get(i).nombrepokemon);

    }

    SeleccionController controller;

    public void pasarInfo(SeleccionController controller) {
        this.controller = controller;
        if (controller.listaAmigos.size() > 0)
            indicePokeAmigo.setText("Fue necesario alimentar: " + controller.listaAmigos.get(0).vecesAlimentado + " veces al pokemon " + controller.listaAmigos.get(0).nombrepokemon);

        for (int i = 0; i < controller.listaAmigos.size(); i++) {
            listapokeAmigos.setText(listapokeAmigos.getText() + "\n" + controller.listaAmigos.get(i).nombrepokemon);
        }
        if (controller.listaAmigos.size() <= 1)
            siguiente.setVisible(false);
        else
            siguiente.setVisible(true);
    }

}
