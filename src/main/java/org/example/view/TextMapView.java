package org.example.view;

import org.example.model.entity.Entity;
import org.example.model.map.GameMap;

public class TextMapView extends MapView {

    private final static String VERT_DELIMITER = "|";
    private final static String GROUND = formatted(" ");
    private final static String TREE = formatted("&");
    private final static String ROCK = formatted("#");
    private final static String GRASS = formatted("*");
    private final static String HERBIVORE = formatted("h");
    private final static String PREDATOR = formatted("P");

    private final String line;
    public TextMapView(GameMap gameMap) {
        super(gameMap);
        line = "---+".repeat(gameMap.columns());
    }


    @Override
    public void show() {
        showLine();
        for (int row = 0; row < gameMap.rows(); row++) {
            for (int column = 0; column < gameMap.columns(); column++) {
                if (gameMap.isEmpty(row, column)) {
                    showGround();
                } else {
                    Entity entity = gameMap.get(row, column);
                    showEntity(entity);
                }
                showVert();
            }
            System.out.println();
            showLine();
        }
    }

    protected void showVert() {
        System.out.print(VERT_DELIMITER);
    }

    protected void showLine() {
        System.out.println(line);
    }

    @Override
    protected String ground() {
        return GROUND;
    }

    @Override
    protected String tree() {
        return TREE;
    }

    @Override
    protected String rock() {
        return ROCK;
    }

    @Override
    protected String grass() {
        return GRASS;
    }

    @Override
    protected String herbivore() {
        return HERBIVORE;
    }

    @Override
    protected String predator() {
        return PREDATOR;
    }

    private static String formatted(String s) {
        return String.format(" %s ", s);
    }
}
