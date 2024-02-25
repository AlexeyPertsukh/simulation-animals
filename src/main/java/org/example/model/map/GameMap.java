package org.example.model.map;

import org.example.model.entity.Entity;

import java.util.List;

public interface GameMap extends Board<Entity> {
    List<Entity> values();

}
