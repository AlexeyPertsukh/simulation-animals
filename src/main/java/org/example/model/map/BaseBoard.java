package org.example.model.map;


import java.util.HashMap;
import java.util.Map;

public class BaseBoard<T> implements Board<T> {
    private static final String NOT_FOUND = "not found: ";
    private static final String NOT_FOUND_AT_COORDINATE = "not found at row %d, column %d";
    private static final String ILLEGAL_COORDINATE = "illegal row %d, column %d";
    private final int rows;
    private final int columns;

    protected final Map<T, Coordinate> coordinates = new HashMap<>();
    protected final Map<Coordinate, T> values = new HashMap<>();

    public BaseBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public Coordinate coordinate(T value) {
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
    public void put(int row, int column, T value) {
        put(new Coordinate(row, column), value);
    }

    @Override
    public void put(Coordinate coordinate, T value) {
        if(!inRange(coordinate)) {
            String message = String.format(ILLEGAL_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }
        coordinates.put(value, coordinate);
        values.put(coordinate, value);
    }

    @Override
    public T get(int row, int column) {
        return get(new Coordinate(row, column));
    }

    @Override
    public T get(Coordinate coordinate) {
        T value = values.get(coordinate);
        if (value == null) {
            String message = String.format(NOT_FOUND_AT_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }

        return value;
    }

    @Override
    public T remove(int row, int column) {
        return remove(new Coordinate(row, column));
    }

    @Override
    public T remove(Coordinate coordinate) {
        if (!values.containsKey(coordinate)) {
            String message = String.format(NOT_FOUND_AT_COORDINATE, coordinate.row, coordinate.column);
            throw new IllegalArgumentException(message);
        }
        T value = values.remove(coordinate);
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

    private boolean inRange(Coordinate coordinate) {
        int row = coordinate.row;
        int column = coordinate.column;
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
