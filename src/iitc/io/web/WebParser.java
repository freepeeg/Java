package iitc.io.web;

import iitc.io.FileParser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * WebParser
 *
 * @author Ian
 * @version 1.0
 */
public class WebParser extends FileParser {
    public WebParser(String url, int sz) throws IOException {
        this(new URL(url), sz);
    }

    public WebParser(String url) throws IOException {
        this(new URL(url));
    }

    public WebParser(URLConnection url, int sz) throws IOException {
        super(url.getInputStream(), sz);
    }

    public WebParser(URLConnection url) throws IOException {
        super(url.getInputStream());
    }

    public WebParser(URL url, int sz) throws IOException {
        this(url.openConnection(), sz);
    }

    public WebParser(URL url) throws IOException {
        this(url.openConnection());
    }
}
