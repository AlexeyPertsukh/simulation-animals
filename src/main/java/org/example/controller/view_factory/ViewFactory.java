package org.example.controller.view_factory;

import org.example.model.map.Map;
import org.example.view.View;

import java.util.function.Supplier;

public interface ViewFactory {
    View viewMap(Map map);
    View textView(String text);
}
