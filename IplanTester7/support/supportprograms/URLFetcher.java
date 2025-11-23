package supportprograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class URLFetcher {
    public static Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            List<String> urls = fetchURLs("QA", "SIRIUS");
            System.out.println("URLs:");
            for (String url : urls) {
                System.out.println(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> fetchURLs(String... environments) throws IOException {
        List<String> urls = new ArrayList<>();
        for (String environment : environments) {
            String url = prop.getProperty(environment);
            if (url != null && !url.isEmpty()) {
                urls.add(url);
            } else {
                System.out.println("URL for environment '" + environment + "' not found.");
            }
        }
        return urls;
    }
}
