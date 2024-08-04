package ss19_string_regex.bai_tap.bai_tap_3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsExtractor {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\s+", " ");
            Pattern p = Pattern.compile("<a[^>]*    class=\"dt-text-black-mine\"[^>]*>(.+?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1).trim());
            }
        } catch (IOException _) {
        }
    }
}



