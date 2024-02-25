package org.example.controller.view_factory;

import org.example.model.map.GameMap;
import org.example.view.EmojiMapView;
import org.example.view.View;

public class EmojiViewFactory extends AbstractViewFactory{
    @Override
    public View viewMap(GameMap gameMap) {
        return new EmojiMapView(gameMap);
    }

}
