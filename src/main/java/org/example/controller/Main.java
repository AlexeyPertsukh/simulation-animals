package org.example.controller;

import org.example.model.map.Map;
import org.example.model.map_factory.BasicMapFactory;
import org.example.view.EmojiMapView;
import org.example.view.MapView;

public class Main {
    public static void main(String[] args) {
        Map map = (new BasicMapFactory()).create();

        MapView view = new EmojiMapView(map);
//        MapView view = new TextMapView(map);
        view.show();

    }
}