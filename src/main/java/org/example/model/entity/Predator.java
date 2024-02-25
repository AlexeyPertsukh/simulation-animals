package org.example.model.entity;

import org.example.model.map.GameMap;

public class Predator extends Creature{
    private final static int SPEED = 2;
    private final static int HP = 4;
    private final static int ATTACK_SKILL = 1;
    public Predator(GameMap gameMap) {
        super(gameMap, SPEED, HP);
    }

    @Override
    protected boolean isFood(Entity entity) {
        return entity instanceof Herbivore;
    }
}
