package org.example.controller;

import org.example.controller.view_factory.TextViewFactory;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.entity.Grass;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Rock;
import org.example.model.map.GameMap;
import org.example.model.map.hash_game_map.HashGameMap;

public class MainTest {
    public static void main(String[] args) {
        GameMap gameMap = map();
//        ViewFactory viewFactory = new EmojiViewFactory();
        ViewFactory viewFactory = new TextViewFactory();

        Simulation simulation = new Simulation(gameMap, viewFactory, 1500);
        simulation.startSimulation();

    }

    private static GameMap map() {
        GameMap gameMap = new HashGameMap(10, 20);

        gameMap.put(2,3,new Grass());
        gameMap.put(0,0,new Grass());
        gameMap.put(0,19,new Grass());
//        map.put(8,40,new Grass());

        gameMap.put(1,1,new Rock());
        gameMap.put(5,5,new Herbivore(gameMap));
        gameMap.put(5,19,new Herbivore(gameMap));

        gameMap.put(2,3,new Grass());
        gameMap.put(0,0,new Grass());
        gameMap.put(0,19,new Grass());

        gameMap.put(1,1,new Rock());
        gameMap.put(5,5,new Herbivore(gameMap));
        gameMap.put(5,19,new Herbivore(gameMap));

        gameMap.put(0,0,new Grass());

        return gameMap;
    }

}