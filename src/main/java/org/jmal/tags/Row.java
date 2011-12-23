package org.jmal.tags;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.jmal.tags.Html.tr;


public class Row implements Renderable {
    private Tag tr;


    public Row(Attribute... attributes) {
        tr = tr(attributes);
    }

    public Row(CssClass cssClass) {
        this();
        tr.addCss(cssClass);
    }

    public Row addCss(CssClass... cssClasses) {
        tr.addCss(cssClasses);
        return this;
    }

    public Row append(Cell... cells) {
        for (Cell cell : cells) {
            tr.append(cell);
        }
        return this;
    }

    public void styleAllCells(CssClass... cssClasses) {
        for (Renderable renderable : tr.getChildren()) {
            ((Cell) renderable).addCss(cssClasses);
        }
    }

    public void render(PrintWriter pw) {
        tr.render(pw);
    }

    @Override
    public String renderString() {
        StringWriter sw = new StringWriter();
        tr.render(new PrintWriter(sw));
        return sw.toString();
    }
}

