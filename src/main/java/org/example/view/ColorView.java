package org.example.view;

public interface ColorView extends View {
    enum Color {
        DEFAULT("\u001B[0m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        BLUE("\u001B[34m"),
        YELLOW("\u001B[33m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        ;

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
