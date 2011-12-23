package org.jmal.tags;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.jmal.tags.Html.table;

public class Table implements Renderable {
    private Tag table;

    public Table(Attribute... attributes) {
        table = table(attributes);
    }

    public Table append(Row... rows) {
        for (Row row : rows) {
            table.append(row);
        }
        return this;
    }

    public Table(CssClass cssClass) {
        table = table().addCss(cssClass);
    }

    public Table addCss(CssClass... cssClasses) {
        table.addCss(cssClasses);
        return this;
    }

    public void render(PrintWriter pw) {
        table.render(pw);
    }

    @Override
    public String renderString() {
        StringWriter sw = new StringWriter();
        table.render(new PrintWriter(sw));
        return sw.toString();
    }
}