package org.example.controller;

import org.example.controller.view_factory.EmojiViewFactory;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.Simulation;
import org.example.model.map.Map;
import org.example.model.map_factory.BasicRandomMapFactory;
import org.example.model.map_factory.OneHerbivoreFixMapFactory;

public class MainTest {
    public static void main(String[] args) {
        Map map = (new OneHerbivoreFixMapFactory()).create();
        ViewFactory viewFactory = new EmojiViewFactory();

        Simulation simulation = new Simulation(map, viewFactory);
        simulation.startSimulation();

    }
}