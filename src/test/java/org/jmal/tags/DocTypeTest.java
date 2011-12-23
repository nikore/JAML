package org.jmal.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DocTypeTest {
    @Test
    public void testGetDocTypeString() throws Exception {
        String HTML_401_TRANSITIONAL = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n";
        String HTML_401_STRICT = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
        String XHTML_10_TRANSITIONAL = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
        String XHTML_10_STRICT = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n";
        String XHTML_11 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\n";
        String BROWSER_DEFAULT = "";

        assertEquals(HTML_401_TRANSITIONAL, DocType.HTML_401_TRANSITIONAL.getDocTypeString());
        assertEquals(HTML_401_STRICT, DocType.HTML_401_STRICT.getDocTypeString());
        assertEquals(XHTML_10_TRANSITIONAL, DocType.XHTML_10_TRANSITIONAL.getDocTypeString());
        assertEquals(XHTML_10_STRICT, DocType.XHTML_10_STRICT.getDocTypeString());
        assertEquals(XHTML_11, DocType.XHTML_11.getDocTypeString());
        assertEquals(BROWSER_DEFAULT, DocType.BROWSER_DEFAULT.getDocTypeString());

    }
}
