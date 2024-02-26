package org.example.controller;

import org.example.controller.view_factory.EmojiViewFactory;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.map.GameMap;
import org.example.model.map_factory.BasicRandomMapFactory;

public class MainEmoji {
    public static void main(String[] args) {
        GameMap gameMap = (new BasicRandomMapFactory()).create();
        ViewFactory viewFactory = new EmojiViewFactory();
//        ViewFactory viewFactory = new TextViewFactory();

        Simulation simulation = new Simulation(gameMap, viewFactory, 2000);
        simulation.startSimulation();

    }
}