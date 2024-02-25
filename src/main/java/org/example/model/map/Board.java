package org.example.model.map;

public interface Board<T> {
    Coordinate coordinate(T value);

    int rows();

    int columns();

    void put(int row, int column, T value);

    void put(Coordinate coordinate, T value);

    T get(int row, int column);

    T get(Coordinate coordinate);

    T remove(int row, int column);

    T remove(Coordinate coordinate);

    boolean isEmpty(int row, int column);

    boolean isEmpty(Coordinate coordinate);

    boolean contains(T value);
}
