package org.example.model.map.array_game_map;

import org.example.model.entity.Entity;
import org.example.model.map.GameMap;

import java.util.ArrayList;
import java.util.List;

public class ArrayGameMap extends ArrayBoard<Entity> implements GameMap {

    public ArrayGameMap(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public List<Entity> values() {
        List<Entity> values = new ArrayList<>();
        for (int row = 0; row < rows(); row++) {
            for (int column = 0; column < columns(); column++) {
                if (!isEmpty(row, column)) {
                    values.add(get(row, column));
                }
            }
        }
        return values;
    }
}
