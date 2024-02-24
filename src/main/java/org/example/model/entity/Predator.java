package org.example.model.entity;

public class Predator extends Creature{
    private final static int SPEED = 2;
    private final static int HP = 4;
    private final static int ATTACK_SKILL = 1;
    public Predator() {
        super(SPEED, HP);
    }

    @Override
    public void makeMove() {

    }
}
