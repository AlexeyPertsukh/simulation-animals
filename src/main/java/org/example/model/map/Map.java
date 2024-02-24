package org.example.model.map;

import org.example.model.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Map extends BaseBoard<Entity> {
    public Map(int rows, int columns) {
        super(rows, columns);
    }

    public List<Coordinate> coordinates() {
        return new ArrayList<>(coordinates.values());
    }

    public List<Entity> entities() {
        return new ArrayList<>(values.values());
    }
}
