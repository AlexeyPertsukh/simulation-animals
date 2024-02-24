package org.example.view;

import org.example.model.entity.Entity;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Predator;
import org.example.model.entity.StaticUnit;
import org.example.model.map.Map;

public abstract class MapView implements View {

    private final Map map;

    public MapView(Map map) {
        this.map = map;
    }

    @Override
    public void show() {
        for (int row = 0; row < map.rows(); row++) {
            for (int column = 0; column < map.columns(); column++) {
                if (map.isEmpty(row, column)) {
                    showGround();
                } else {
                    Entity entity = map.get(row, column);
                    showEntity(entity);
                }
            }
            System.out.println();
        }
    }

    private void showGround() {
        System.out.print(ground());
    }

    private void showEntity(Entity entity) {
        String pic = picture(entity);
        System.out.print(pic);
    }

    protected String picture(Entity entity) {

        if(entity instanceof Predator) {
            return predator();
        }
        if(entity instanceof Herbivore) {
            return herbivore();
        }

        if(entity instanceof StaticUnit) {
            StaticUnit unit = (StaticUnit) entity;
            switch (unit) {
                case GRASS: return grass();
                case TREE: return tree();
                case ROCK: return rock();
                default: throw new IllegalArgumentException();
            }
        }
        throw new IllegalArgumentException();
    }

    protected abstract String ground();
    protected abstract String tree();
    protected abstract String rock();
    protected abstract String grass();
    protected abstract String herbivore();
    protected abstract String predator();


}
