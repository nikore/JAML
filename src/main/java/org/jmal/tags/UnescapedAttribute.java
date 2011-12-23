package org.jmal.tags;

public class UnescapedAttribute extends Attribute {

    public UnescapedAttribute(String name, String value) {
        super(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("=\"");
        sb.append(getValue());
        sb.append("\"");
        return sb.toString();
    }
}
