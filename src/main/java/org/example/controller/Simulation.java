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

            List<Entity> entities = gameMap.values();
            Statistic statistic = statistic(entities);
            show(statistic);
            sleep();
            if(isEndSimulation(statistic)) {
                break;
            }
            turn.execute();
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

    public void show(Statistic statistic) {
        mapView.show();
        viewFactory.info(step++, statistic.numGrasses, statistic.numHerbivores, statistic.numPredators).show();
    }

    private Statistic statistic(List<Entity> entities) {
        Statistic statistic = new Statistic();
        for (Entity entity : entities) {
            if (entity instanceof Grass) {
                statistic.numGrasses++;
            } else if (entity instanceof Herbivore) {
                statistic.numHerbivores++;
            } else if (entity instanceof Predator) {
                statistic.numPredators++;
            }
        }
        return statistic;
    }

    private boolean isEndSimulation(Statistic statistic) {
        return statistic.numHerbivores == 0;
    }

    public GameMap getMap() {
        return gameMap;
    }

    private static class Statistic {
        int numGrasses;
        int numHerbivores;
        int numPredators;
    }

}
