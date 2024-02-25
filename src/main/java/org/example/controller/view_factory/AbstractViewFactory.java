package org.example.controller.view_factory;

import org.example.view.TextView;
import org.example.view.View;

public abstract class AbstractViewFactory implements ViewFactory{
    private static final String INFO_TEMPLATE = "[%d] %d grasses, %d herbivores, %d predators";

    @Override
    public View info(int step, int numGrasses, int numHerbivores, int numPredators) {
        String text = String.format(INFO_TEMPLATE, step, numGrasses, numHerbivores, numPredators);
        return new TextView(text);
    }
}
