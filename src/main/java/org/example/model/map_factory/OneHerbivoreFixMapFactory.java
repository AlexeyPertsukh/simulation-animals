package org.example.model.map_factory;

import org.example.model.entity.Grass;
import org.example.model.entity.Herbivore;
import org.example.model.entity.Rock;
import org.example.model.map.GameMap;
import org.example.model.map.hash_game_map.HashGameMap;

import java.util.Random;

public class OneHerbivoreFixMapFactory implements MapFactory {
    private final static int ROWS = 10;
    private final static int COLUMNS = 50;
    private final Random random = new Random();

    @Override
    public GameMap create() {
        GameMap gameMap = new HashGameMap(ROWS, COLUMNS);

        gameMap.put(2,3,new Grass());
        gameMap.put(0,0,new Grass());
        gameMap.put(0,40,new Grass());

        gameMap.put(1,1,new Rock());
        gameMap.put(5,5,new Herbivore(gameMap));

        return gameMap;
    }


}
