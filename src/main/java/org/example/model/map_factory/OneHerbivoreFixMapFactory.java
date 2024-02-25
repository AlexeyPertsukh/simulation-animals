package org.example.model.map_factory;

import org.example.model.entity.Herbivore;
import org.example.model.entity.StaticEntity;
import org.example.model.map.Map;

import java.util.Random;

public class OneHerbivoreFixMapFactory implements MapFactory {
    private final static int ROWS = 10;
    private final static int COLUMNS = 50;
    private final Random random = new Random();

    @Override
    public Map create() {
        Map map = new Map(ROWS, COLUMNS);


        map.put(0,40,StaticEntity.GRASS);
        map.put(3,4,StaticEntity.GRASS);
        map.put(0,0,StaticEntity.GRASS);
//        map.put(3,3,StaticEntity.GRASS);

        map.put(1,1,StaticEntity.ROCK);
        map.put(5,5,new Herbivore(map));

        return map;
    }


}
