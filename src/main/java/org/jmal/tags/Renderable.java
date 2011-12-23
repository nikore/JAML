package org.jmal.tags;

import java.io.PrintWriter;

public interface Renderable {
    public static final Renderable NULL = new Renderable() {
        @Override
        public void render(PrintWriter pw) {
        }

        @Override
        public String renderString() {
            return "";
        }
    };

    public void render(PrintWriter pw);

    public String renderString();
}
