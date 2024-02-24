package org.example.controller;

import org.example.model.map.Map;
import org.example.model.map_factory.MapFactoryImp;
import org.example.view.EmojiMapView;
import org.example.view.MapView;
import org.example.view.TextMapView;

public class Main {
    public static void main(String[] args) {
        Map map = (new MapFactoryImp()).create();


//        MapView view = new EmojiMapView(map);
        MapView view = new TextMapView(map);
        view.show();

    }
}