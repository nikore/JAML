package org.jmal.tags;

import java.io.PrintWriter;

public enum DocType implements Renderable {
    BROWSER_DEFAULT,
    HTML_401_TRANSITIONAL,
    HTML_401_STRICT,
    XHTML_10_TRANSITIONAL,
    XHTML_10_STRICT,
    XHTML_11;

    public String getDocTypeString() {
        switch (this) {
            case HTML_401_TRANSITIONAL:
                return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
            case HTML_401_STRICT:
                return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
            case XHTML_10_TRANSITIONAL:
                return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
            case XHTML_10_STRICT:
                return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n";
            case XHTML_11:
                return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n";
            case BROWSER_DEFAULT:
            default:
                return "";
        }
    }


    @Override
    public void render(PrintWriter printWriter) {
        printWriter.print(this.getDocTypeString());
        printWriter.flush();
    }

    @Override
    public String renderString() {
        return this.getDocTypeString();
    }
}
