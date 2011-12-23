package org.jmal.tags;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.jmal.tags.Html.text;

public class Renderables implements Renderable {
    private final List<Renderable> children;

    public Renderables() {
        children = new LinkedList<Renderable>();
    }

    @Override
    public void render(PrintWriter pw) {
        for (Renderable child : children) {
            child.render(pw);
        }
        pw.flush();
    }

    public Renderables(Renderable... renderables) {
        children = new LinkedList<Renderable>();
        Collections.addAll(children, renderables);
    }

    @Override
    public String renderString() {
        StringWriter writer = new StringWriter();
        for (Renderable child : children) {
            child.render(new PrintWriter(writer));
        }
        return writer.toString();
    }

    public Renderables append(Renderable... renderables) {
        Collections.addAll(children, renderables);
        return this;
    }

    public Renderables append(List<? extends Renderable> renderables) {
        children.addAll(renderables);
        return this;
    }

    public Renderables append(String text) {
        children.add(text(text));
        return this;
    }
}
