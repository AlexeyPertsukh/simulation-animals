package org.example.view;

import org.example.model.map.Map;

import java.util.function.Supplier;

public class EmojiMapView extends MapView {
    private final static String GROUND = "\uD83D\uDFEB";
//    private final static String TREE = "\uD83C\uDF32";
    private final static String TREE = "\uD83C\uDF34️";
    private final static String ROCK = "\uD83D\uDD3A";
//    private final static String ROCK = "\uD83D\uDFE4";
    private final static String GRASS = "\uD83C\uDF40";
    private final static String HERBIVORE = "\uD83D\uDC30";
    private final static String PREDATOR = "\uD83D\uDC2F";


    public EmojiMapView(Map map) {
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
