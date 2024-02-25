package org.example.model.entity;

import org.example.model.map.Map;

public class Predator extends Creature{
    private final static int SPEED = 2;
    private final static int HP = 4;
    private final static int ATTACK_SKILL = 1;
    public Predator(Map map) {
        super(map, SPEED, HP);
    }

    @Override
    protected boolean isFood(Entity entity) {
        return entity instanceof Herbivore;
    }
}
