package org.example.controller;

import org.example.controller.view_factory.ColorTextViewFactory;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.map.GameMap;
import org.example.model.map_factory.BasicRandomMapFactory;

public class MainText {
    public static void main(String[] args) {
        GameMap gameMap = (new BasicRandomMapFactory(
                8,
                40,
                10,
                10,
                10,
                15,
                3)).create();
        ViewFactory viewFactory = new ColorTextViewFactory();

        Simulation simulation = new Simulation(gameMap, viewFactory, 2000);
        simulation.startSimulation();

    }
}