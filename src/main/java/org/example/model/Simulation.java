package org.example.model;

import org.example.controller.view_factory.ViewFactory;
import org.example.model.map.Map;

public class Simulation {
    private final Map map;
    private final ViewFactory viewFactory;

    public Simulation(Map map, ViewFactory viewFactory) {
        this.map = map;
        this.viewFactory = viewFactory;
    }

    public void startSimulation() {

    }

    public void pauseSimulation() {

    }
}
