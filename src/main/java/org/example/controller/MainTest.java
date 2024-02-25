package org.example.controller;

import org.example.controller.view_factory.EmojiViewFactory;
import org.example.controller.view_factory.TextViewFactory;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.Simulation;
import org.example.model.entity.Grass;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Rock;
import org.example.model.map.Map;
import org.example.model.map_factory.BasicRandomMapFactory;
import org.example.model.map_factory.OneHerbivoreFixMapFactory;

public class MainTest {
    public static void main(String[] args) {
        Map map = map();
//        ViewFactory viewFactory = new EmojiViewFactory();
        ViewFactory viewFactory = new TextViewFactory();

        Simulation simulation = new Simulation(map, viewFactory, 500);
        simulation.startSimulation();

    }

    private static Map map() {
        Map map = new Map(10, 20);

        map.put(2,3,new Grass());
        map.put(0,0,new Grass());
        map.put(0,19,new Grass());
//        map.put(8,40,new Grass());

        map.put(1,1,new Rock());
        map.put(5,5,new Herbivore(map));
        map.put(5,19,new Herbivore(map));

        return map;
    }
}