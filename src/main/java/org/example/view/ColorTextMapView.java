package org.example.view;

import org.example.model.entity.*;
import org.example.model.map.GameMap;

public class ColorTextMapView extends TextMapView implements ColorView{
    private final static Color COLOR_GRASS = Color.GREEN;
    private final static Color COLOR_TREE = Color.YELLOW;
    private final static Color COLOR_ROCK = Color.PURPLE;
    private final static Color COLOR_HERBIVORE = Color.BLUE;
    private final static Color COLOR_PREDATOR = Color.RED;

    public ColorTextMapView(GameMap gameMap) {
        super(gameMap);
    }

    @Override
    protected void showEntity(Entity entity) {
        Color color = color(entity);
        System.out.print(color.getCode());
        super.showEntity(entity);
        System.out.print(Color.DEFAULT.getCode());
    }

    private Color color(Entity entity) {
        if(entity instanceof Grass) {
            return COLOR_GRASS;
        }
        if(entity instanceof Tree) {
            return COLOR_TREE;
        }
        if(entity instanceof Rock) {
            return COLOR_ROCK;
        }
        if(entity instanceof Herbivore) {
            return COLOR_HERBIVORE;
        }
        if(entity instanceof Predator) {
            return COLOR_PREDATOR;
        }
        throw new IllegalArgumentException("illegal entity: " + entity);
    }





}
