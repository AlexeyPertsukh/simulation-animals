package org.example.controller.actions;

import org.example.controller.Simulation;
import org.example.model.entity.Creature;
import org.example.model.entity.Entity;
import org.example.model.map.GameMap;

import java.util.List;

public class TurnActions implements Actions{
    private final Simulation simulation;

    public TurnActions(Simulation simulation) {
        this.simulation = simulation;
    }


    @Override
    public void execute() {
        GameMap map = simulation.getMap();
        List<Entity> entities = map.values();
        for (Entity entity : entities  ) {
            if(!map.contains(entity)) {
                continue;
            }
            if(isCreature(entity)) {
                Creature creature = (Creature) entity;
                creature.makeMove();
            }
        }
    }

    private boolean isCreature(Entity entity) {
        return entity instanceof Creature;
    }
}
