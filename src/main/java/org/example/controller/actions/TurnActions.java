package org.example.controller.actions;

import org.example.model.Simulation;
import org.example.model.entity.Creature;
import org.example.model.entity.Entity;

import java.util.List;

public class TurnActions implements Actions{
    private final Simulation simulation;

    public TurnActions(Simulation simulation) {
        this.simulation = simulation;
    }


    @Override
    public void execute() {
        List<Entity> entities = simulation.getMap().entities();
        for (Entity entity : entities  ) {
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
