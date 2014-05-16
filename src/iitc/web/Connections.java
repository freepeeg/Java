package iitc.web;

import iitc.util.OperatingSystem;
import iitc.util.Random;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Connections
 *
 * @author Ian
 * @version 1.0
 */
public class Connections {
    public static JarURLConnection createBrowserJarConnection(String url) throws IOException {
        return createBrowserJarConnection(new URL(url));
    }

    public static JarURLConnection createBrowserJarConnection(URL url) throws IOException {
        JarURLConnection con = (JarURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", UserAgent.values()[Random.nextInt(0, UserAgent.values().length)].agent);
        return con;
    }

    public static URLConnection createBrowserConnection(String url) throws IOException {
        return createBrowserConnection(new URL(url));
    }

    public static URLConnection createBrowserConnection(URL url) throws IOException {
        URLConnection con = url.openConnection();
        con.setRequestProperty("User-Agent", UserAgent.values()[Random.nextInt(0, UserAgent.values().length)].agent);
        return con;
    }

    public enum UserAgent {
        CHROME34("Mozilla/5.0 (" + OperatingSystem.getUserAgentPart() + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36");
        private final String agent;

        UserAgent(String agent) {
            this.agent = agent;
        }
    }
}
