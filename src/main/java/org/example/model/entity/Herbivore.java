package org.example.model.entity;

public class Herbivore extends Creature{
    private final static int SPEED = 2;
    private final static int HP = 4;
    public Herbivore() {
        super(SPEED, HP);
    }

    @Override
    public void makeMove() {

    }

}
