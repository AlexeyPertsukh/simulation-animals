package org.example.model.map.array_game_map;

import org.example.model.entity.Entity;
import org.example.model.map.Board;
import org.example.model.map.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ArrayBoard<T> implements Board<T> {
    private final int rows;
    private final int columns;
    protected final Object[][] values;

    public ArrayBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.values = new Object[rows][columns];
    }

    @Override
    public void put(int row, int column, T value) {
        values[row][column] = value;
    }

    @Override
    public void put(Coordinate coordinate, T value) {
        put(coordinate.row, coordinate.column, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int row, int column) {
        if (values[row][column] == null) {
            throw new IllegalArgumentException();
        }
        return (T) values[row][column];
    }

    @Override
    public T get(Coordinate coordinate) {
        return get(coordinate.row, coordinate.column);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int row, int column) {
        if (values[row][column] == null) {
            throw new IllegalArgumentException();
        }
        T t = (T) values[row][column];
        values[row][column] = null;
        return t;
    }

    @Override
    public T remove(Coordinate coordinate) {
        return remove(coordinate.row, coordinate.column);
    }

    @Override
    public Coordinate coordinate(T value) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (value == values[row][column]) {
                    return new Coordinate(row, column);
                }
            }
        }
        throw new IllegalArgumentException("object without: " + value);
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
    public boolean isEmpty(int row, int column) {
        return values[row][column] == null;
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
        return isEmpty(coordinate.row, coordinate.column);
    }

}
