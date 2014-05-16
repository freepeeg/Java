package iitc.projects.yt;

import iitc.io.web.WebParser;
import iitc.web.Connections;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * YoutubeVideoDownloader
 *
 * @author Ian
 * @version 1.0
 */
public class YoutubeVideoDownloader implements VideoDownloader {
    protected final static Pattern TITLE = Pattern.compile("<title>(.*?) - YouTube</title>");
    protected final String link;
    protected final URLConnection connection;
    protected final String page;
    protected final String title;

    public YoutubeVideoDownloader(String link) throws IOException {
        this.link = link;
        this.connection = Connections.createBrowserConnection(link);
        WebParser parser = new WebParser(connection);
        this.page = parser.dump();
        Matcher m = TITLE.matcher(page);
        this.title = m.find() ? m.group(1) : null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public File getVideo() {
        return null;
    }
}
