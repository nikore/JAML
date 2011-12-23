package org.jmal.tags;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.PrintWriter;

public class Text implements Renderable {
    private final String value;

    public Text(String value) {
        this.value = value;
    }

    @Override
    public void render(PrintWriter printWriter) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        printWriter.print(StringEscapeUtils.escapeHtml(value));
        printWriter.flush();
    }

    @Override
    public String renderString() {
        if (StringUtils.isEmpty(value)) {
            return "";
        }

        return StringEscapeUtils.escapeHtml(value);
    }
}
