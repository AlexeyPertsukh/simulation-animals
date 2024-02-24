package org.example.model.map_factory;

import org.example.model.entity.Herbivore;
import org.example.model.entity.Predator;
import org.example.model.entity.StaticUnit;
import org.example.model.map.Map;

public class MapFactoryImp implements MapFactory{
    private final static int ROWS = 10;
    private final static int COLUMNS = 40;
    @Override
    public Map create() {
        Map map = new Map(ROWS, COLUMNS);

        map.put(0,0, StaticUnit.GRASS);
        map.put(0,1, StaticUnit.ROCK);
        map.put(0,2, StaticUnit.TREE);
        map.put(0,3, new Predator());
        map.put(0,4, new Herbivore());


        return map;
    }
}
