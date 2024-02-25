package org.example.controller.view_factory;

import org.example.model.map.Map;
import org.example.view.EmojiMapView;
import org.example.view.TextView;
import org.example.view.View;

import java.util.function.Supplier;

public class EmojiViewFactory implements ViewFactory{
    @Override
    public View viewMap(Map map) {
        return new EmojiMapView(map);
    }

    @Override
    public View textView(String text) {
        return new TextView(text);
    }
}
