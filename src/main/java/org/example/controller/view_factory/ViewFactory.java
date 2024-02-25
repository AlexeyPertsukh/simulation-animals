package org.example.controller.view_factory;

import org.example.model.map.GameMap;
import org.example.view.View;

public interface ViewFactory {
    View viewMap(GameMap gameMap);
    View info(int step, int numGrasses, int numHerbivores, int numPredators);
}
