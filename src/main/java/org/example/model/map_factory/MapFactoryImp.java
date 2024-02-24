package org.example.model.map_factory;

import org.example.model.map.Map;

public class MapFactoryImp implements MapFactory{
    private final static int SIZE = 10;
    @Override
    public Map create() {
        Map map = new Map(SIZE, SIZE);
        return map;
    }
}
