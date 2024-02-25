package org.example.model;

import org.example.controller.actions.Actions;
import org.example.controller.actions.TurnActions;
import org.example.controller.view_factory.ViewFactory;
import org.example.model.map.Map;
import org.example.view.View;

public class Simulation {
    private final Map map;
    private final ViewFactory viewFactory;
    private int step = 1;
    private View mapView;
    private final Actions turn;



    public Simulation(Map map, ViewFactory viewFactory) {
        this.map = map;
        this.viewFactory = viewFactory;
        mapView = viewFactory.viewMap(map);
        turn= new TurnActions(this);
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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pauseSimulation() {

    }

    public void show() {
        mapView.show();
        viewFactory.textView(step++).show();
    }

    public Map getMap() {
        return map;
    }
}
