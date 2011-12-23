package org.jmal.tags;

import org.apache.commons.lang.StringEscapeUtils;

public class Attribute {
    private String name, value;

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("=\"");
        sb.append(StringEscapeUtils.escapeHtml(value));
        sb.append("\"");
        return sb.toString();
    }
}