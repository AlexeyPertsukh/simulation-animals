package org.example.model.entity;

import org.example.model.map.Map;

public class Herbivore extends Creature{
    private final static int SPEED = 2;
    private final static int HP = 1;
    public Herbivore() {
        super(SPEED, HP);
    }

    @Override
    public void makeMove(Map map) {

    }

}
