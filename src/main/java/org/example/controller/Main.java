package org.example.controller;

import org.example.model.entity.StaticUnit;
import org.example.model.map.Map;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        map.put(0,0, StaticUnit.GRASS);
    }
}