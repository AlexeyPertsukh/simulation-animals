package org.example.model.map_factory;

import org.example.model.entity.Entity;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Predator;
import org.example.model.entity.StaticEntity;
import org.example.model.map.Coordinate;
import org.example.model.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class BasicRandomMapFactory implements MapFactory {
    private final static int ROWS = 10;
    private final static int COLUMNS = 50;
    private final static int PERCENT_GRASS = 6;
    private final static int PERCENT_TREE = 6;
    private final static int PERCENT_ROCK = 9;
    private final static int NUM_HERBIVORE = 11;
    private final static int NUM_PREDATOR = 7;
    private final Random random = new Random();

    @Override
    public Map create() {
        Map map = new Map(ROWS, COLUMNS);

        List<Coordinate> coordinates = coordinates(map);

        int size = map.rows() * map.columns();

        int numGrass = size * PERCENT_GRASS / 100;
        int numRock = size * PERCENT_ROCK / 100;
        int numTree = size * PERCENT_TREE / 100;

        putEntity(map, coordinates, numGrass, () -> StaticEntity.GRASS);
        putEntity(map, coordinates, numRock, () -> StaticEntity.ROCK);
        putEntity(map, coordinates, numTree, () -> StaticEntity.TREE);
        putEntity(map, coordinates, NUM_HERBIVORE, () -> new Herbivore(map));
        putEntity(map, coordinates, NUM_PREDATOR, () -> new Predator(map));

        return map;
    }

    private List<Coordinate> coordinates(Map map) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int row = 0; row < map.rows(); row++) {
            for (int column = 0; column < map.columns(); column++) {
                coordinates.add(new Coordinate(row, column));
            }
        }
        return coordinates;
    }

    private void putEntity(Map map, List<Coordinate> coordinates, int num, Supplier<Entity> supplier) {
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(coordinates.size() - 1);
            Coordinate coordinate = coordinates.remove(index);
            map.put(coordinate, supplier.get());
        }
    }

}
