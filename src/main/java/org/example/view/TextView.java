package org.example.view;

public class TextView implements View{
    private final String text;

    public TextView(String text) {
        this.text = text;
    }

    @Override
    public void show() {
        System.out.println(text);
    }
}
