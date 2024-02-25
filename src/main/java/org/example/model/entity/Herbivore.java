package org.example.model.entity;

import org.example.model.map.GameMap;

public class Herbivore extends Creature {
    private final static int SPEED = 1;
    private final static int HP = 1;

    public Herbivore(GameMap gameMap) {
        super(gameMap, SPEED, HP);
    }

    @Override
    protected boolean isFood(Entity entity) {
            return entity instanceof Grass;
    }


}
