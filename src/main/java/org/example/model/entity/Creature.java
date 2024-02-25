package org.example.model.entity;

import org.example.model.map.Coordinate;
import org.example.model.map.Map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Creature implements Entity {

    protected final Map map;
    protected final int speed;
    protected int hp;

    public Creature(Map map, int speed, int hp) {
        this.map = map;
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void makeMove() {
        Coordinate me = map.coordinate(this);
        List<Coordinate> foodCoordinates = foodCoordinates();
        Coordinate nearest = nearest(foodCoordinates, me);
        System.out.printf("!!!! [%d, %d]%n \n", nearest.row, nearest.column);

    }

    protected List<Coordinate> foodCoordinates() {
        List<Entity> entities = map.values();
//        entities.forEach(n -> System.out.println("!!! " + n));
        List<Coordinate> coordinates = new ArrayList<>();
        for (Entity entity : entities) {
            if (isFood(entity)) {
                Coordinate coordinate = (map.coordinate(entity));
                coordinates.add(coordinate);
            }
        }
//        coordinates.forEach(v -> System.out.println("!!! " + v));
        return coordinates;
    }

    private Coordinate nearest(List<Coordinate> coordinates, Coordinate from) {
        Comparator<Coordinate> comparator = new CoordinateComparator(from);
//        coordinates.forEach(System.out::println);
//        System.out.println("---");
        coordinates.sort(comparator);
//        coordinates.forEach(System.out::println);
        return coordinates.get(0);
    }

    private List<Coordinate> way(Coordinate from, Coordinate to) {
        List<Coordinate> way = new ArrayList<>();
        Coordinate current = from;
        while (!isFoodNear(current, to)) {

        }
        return way;
    }

//    private static final int[][] steps = {1,}
//    private Coordinate next(Coordinate from, Coordinate to) {
//        int row = Math.max(from.row, to.row) - Math.min(from.row, to.row);
//        int column = Math.max(from.column, to.column) - Math.min(from.column, to.column);
//    }

    private boolean isFoodNear(Coordinate me, Coordinate food) {
        return Math.abs(me.row - food.row) == 1 || Math.abs(me.column - food.column) == 1;
    }

    protected abstract boolean isFood(Entity entity);

    private static class CoordinateComparator implements Comparator<Coordinate> {
        private final Coordinate from;

        public CoordinateComparator(Coordinate from) {
            this.from = from;
        }

        @Override
        public int compare(Coordinate first, Coordinate second) {
            return distance(from, first) - distance(from, second);
        }

        private static int distance(Coordinate from, Coordinate to) {
            return Math.abs(from.row - to.row) + Math.abs(from.column - to.column);
        }
    }

}
