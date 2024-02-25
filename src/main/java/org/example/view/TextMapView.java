package org.example.view;

import org.example.model.map.Map;

import java.util.function.Supplier;

public class TextMapView extends MapView {
    private final static String GROUND = ".";
    private final static String TREE = "8";
    private final static String ROCK = "^";
    private final static String GRASS = "*";
    private final static String HERBIVORE = "H";
    private final static String PREDATOR = "P";

    public TextMapView(Map map) {
        super(map);
    }

    @Override
    protected String ground() {
        return GROUND;
    }

    @Override
    protected String tree() {
        return TREE;
    }

    @Override
    protected String rock() {
        return ROCK;
    }

    @Override
    protected String grass() {
        return GRASS;
    }

    @Override
    protected String herbivore() {
        return HERBIVORE;
    }

    @Override
    protected String predator() {
        return PREDATOR;
    }
}
