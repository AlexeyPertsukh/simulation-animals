package org.example.model.map_factory;

import org.example.model.entity.*;
import org.example.model.map.array_game_map.ArrayGameMap;
import org.example.model.map.Coordinate;
import org.example.model.map.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BasicRandomMapFactory implements MapFactory {
    private final static int ROWS = 12;
    private final static int COLUMNS = 60;
    private final static int PERCENT_GRASS = 6;
    private final static int PERCENT_TREE = 6;
    private final static int PERCENT_ROCK = 9;
//    private final static int NUM_HERBIVORE = 11;
    private final static int NUM_HERBIVORE = 18;
//    private final static int NUM_PREDATOR = 7;
    private final static int NUM_PREDATOR = 5;
    private final Random random = new Random();

    @Override
    public GameMap create() {
//        GameMap gameMap = new HashGameMap(ROWS, COLUMNS);
        GameMap gameMap = new ArrayGameMap(ROWS, COLUMNS);

        List<Coordinate> coordinates = coordinates(gameMap);

        int size = gameMap.rows() * gameMap.columns();

        int numGrass = size * PERCENT_GRASS / 100;
        int numRock = size * PERCENT_ROCK / 100;
        int numTree = size * PERCENT_TREE / 100;

        putEntity(gameMap, coordinates, numGrass, Grass::new);
        putEntity(gameMap, coordinates, numRock, Rock::new);
        putEntity(gameMap, coordinates, numTree, Tree::new);
        putEntity(gameMap, coordinates, NUM_HERBIVORE, () -> new Herbivore(gameMap));
        putEntity(gameMap, coordinates, NUM_PREDATOR, () -> new Predator(gameMap));

        return gameMap;
    }

    private List<Coordinate> coordinates(GameMap gameMap) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int row = 0; row < gameMap.rows(); row++) {
            for (int column = 0; column < gameMap.columns(); column++) {
                coordinates.add(new Coordinate(row, column));
            }
        }
        return coordinates;
    }

    private void putEntity(GameMap gameMap, List<Coordinate> coordinates, int num, Supplier<Entity> supplier) {
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(coordinates.size() - 1);
            Coordinate coordinate = coordinates.remove(index);
            gameMap.put(coordinate, supplier.get());
        }
    }

}
