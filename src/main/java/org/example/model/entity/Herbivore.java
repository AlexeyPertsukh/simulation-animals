package org.example.model.entity;

import org.example.model.map.Coordinate;
import org.example.model.map.Map;

import java.util.ArrayList;
import java.util.List;

public class Herbivore extends Creature {
    private final static int SPEED = 2;
    private final static int HP = 1;

    public Herbivore(Map map) {
        super(map, SPEED, HP);
    }

    @Override
    protected boolean isFood(Entity entity) {
            return entity instanceof Grass;
    }


}
