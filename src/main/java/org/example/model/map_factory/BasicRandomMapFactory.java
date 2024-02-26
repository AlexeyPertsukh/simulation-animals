package org.example.model.map_factory;

import org.example.model.entity.*;
import org.example.model.map.Coordinate;
import org.example.model.map.GameMap;
import org.example.model.map.hash_game_map.HashGameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BasicRandomMapFactory implements MapFactory {
    private final static int DEF_ROWS = 12;
    private final static int DEF_COLUMNS = 60;
    private final static int DEF_PERCENT_GRASS = 10;
    private final static int DEF_PERCENT_TREE = 12;
    private final static int DEF_PERCENT_ROCK = 15;
    private final static int DEF_NUM_HERBIVORE = 18;
    private final static int DEF_NUM_PREDATOR = 3;
    private final Random random = new Random();

    private final int rows;
    private final int columns;
    private final int percentGrass;
    private final int percentTree;
    private final int percentRock;
    private final int numHerbivores;
    private final int numPredators;


    public BasicRandomMapFactory() {
        this(
                DEF_ROWS,
                DEF_COLUMNS,
                DEF_PERCENT_GRASS,
                DEF_PERCENT_TREE,
                DEF_PERCENT_ROCK,
                DEF_NUM_HERBIVORE,
                DEF_NUM_PREDATOR
        );
    }

    public BasicRandomMapFactory(int rows, int columns, int percentGrass, int percentTree, int percentRock, int numHerbivores, int numPredators) {
        this.rows = rows;
        this.columns = columns;
        this.percentGrass = percentGrass;
        this.percentTree = percentTree;
        this.percentRock = percentRock;
        this.numHerbivores = numHerbivores;
        this.numPredators = numPredators;
    }

    @Override
    public GameMap create() {
        GameMap gameMap = new HashGameMap(rows, columns);

        List<Coordinate> coordinates = coordinates(gameMap);

        int size = gameMap.rows() * gameMap.columns();

        int numGrass = size * percentGrass / 100;
        int numRock = size * percentRock / 100;
        int numTree = size * percentTree / 100;

        putEntity(gameMap, coordinates, numGrass, Grass::new);
        putEntity(gameMap, coordinates, numRock, Rock::new);
        putEntity(gameMap, coordinates, numTree, Tree::new);
        putEntity(gameMap, coordinates, numHerbivores, () -> new Herbivore(gameMap));
        putEntity(gameMap, coordinates, numPredators, () -> new Predator(gameMap));

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
