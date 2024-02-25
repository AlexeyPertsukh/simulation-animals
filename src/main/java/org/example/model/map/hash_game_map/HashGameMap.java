package org.example.model.map.hash_game_map;

import org.example.model.entity.Entity;
import org.example.model.map.Coordinate;
import org.example.model.map.GameMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//do not use for enums
public class HashGameMap implements GameMap {
    private static final String NOT_FOUND = "not found: ";
    private static final String NOT_FOUND_AT_COORDINATE = "not found at row %d, column %d";
    private static final String ILLEGAL_COORDINATE = "illegal row %d, column %d";
    private final int rows;
    private final int columns;

    protected final Map<Entity, Coordinate> coordinates = new HashMap<>();
    protected final Map<Coordinate, Entity> values = new HashMap<>();

    public HashGameMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public Coordinate coordinate(Entity value) {
        Coordinate coordinate = coordinates.get(value);
        if (coordinate == null) {
            throw new IllegalArgumentException(NOT_FOUND + value);
        }
        return coordinate;
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }

    @Override
    public void put(int row, int column, Entity value) {
        put(new Coordinate(row, column), value);
    }

    @Override
    public void put(Coordinate coordinate, Entity value) {
        if (!inRange(coordinate)) {
            String message = String.format(ILLEGAL_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }

        if (coordinates.containsKey(value)) {
            throw new IllegalArgumentException("the object is already on the board: " + value.toString());
        }

        coordinates.put(value, coordinate);
        values.put(coordinate, value);
    }

    @Override
    public Entity get(int row, int column) {
        return get(new Coordinate(row, column));
    }

    @Override
    public Entity get(Coordinate coordinate) {
        Entity value = values.get(coordinate);
        if (value == null) {
            String message = String.format(NOT_FOUND_AT_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }

        return value;
    }

    @Override
    public Entity remove(int row, int column) {
        return remove(new Coordinate(row, column));
    }

    @Override
    public Entity remove(Coordinate coordinate) {
        if (!values.containsKey(coordinate)) {
            String message = String.format(NOT_FOUND_AT_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }
        Entity value = values.remove(coordinate);
        coordinates.remove(value);
        return value;
    }

    @Override
    public boolean isEmpty(int row, int column) {
        return isEmpty(new Coordinate(row, column));
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
        return !values.containsKey(coordinate);
    }

    @Override
    public List<Entity> values() {
        return new ArrayList<>(values.values());
    }

    private boolean inRange(Coordinate coordinate) {
        int row = coordinate.row;
        int column = coordinate.column;
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    @Override
    public boolean contains(Entity value) {
        return values.containsValue(value);
    }
}
