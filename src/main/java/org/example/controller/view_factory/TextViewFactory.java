package org.example.controller.view_factory;

import org.example.model.map.Map;
import org.example.view.EmojiMapView;
import org.example.view.TextMapView;
import org.example.view.TextView;
import org.example.view.View;

public class TextViewFactory implements ViewFactory{
    @Override
    public View viewMap(Map map) {
        return new TextMapView(map);
    }

    @Override
    public View textView(String text) {
        return new TextView(text);
    }

    @Override
    public View textView(int num) {
        return new TextView(String.valueOf(num));
    }
}
