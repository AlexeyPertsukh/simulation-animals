package org.example.controller.view_factory;

import org.example.model.map.GameMap;
import org.example.view.TextMapView;
import org.example.view.View;

public class TextViewFactory extends AbstractViewFactory{
    @Override
    public View viewMap(GameMap gameMap) {
        return new TextMapView(gameMap);
    }

}
