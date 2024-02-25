package org.example.controller;

import org.example.controller.actions.Actions;
import org.example.controller.actions.TurnActions;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.entity.Entity;
import org.example.model.entity.Grass;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Predator;
import org.example.model.map.GameMap;
import org.example.view.View;

import java.util.List;

public class Simulation {
    private final GameMap gameMap;
    private final ViewFactory viewFactory;
    private final int sleepTime;
    private int step = 1;
    private View mapView;
    private final Actions turn;


    public Simulation(GameMap gameMap, ViewFactory viewFactory, int sleepTime) {
        this.gameMap = gameMap;
        this.viewFactory = viewFactory;
        this.sleepTime = sleepTime;
        mapView = viewFactory.viewMap(gameMap);
        turn = new TurnActions(this);
    }

    public void startSimulation() {
        while (true) {
            show();
            turn.execute();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pauseSimulation() {

    }

    public void show() {
        List<Entity> entities = gameMap.values();
        int numGrasses = 0;
        int numHerbivores = 0;
        int numPredators = 0;

        for (Entity entity : entities) {
            if (entity instanceof Grass) {
                numGrasses++;
            } else if (entity instanceof Herbivore) {
                numHerbivores++;
            } else if (entity instanceof Predator) {
                numPredators++;
            }
        }


        mapView.show();
        viewFactory.info(step++, numGrasses, numHerbivores, numPredators).show();
    }

    public GameMap getMap() {
        return gameMap;
    }
}
