package ss19_string_regex.bai_tap.bai_tap_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsExtractor {
    public static void main(String[] args) {
        String urlString = "http://dantri.com.vn/the-gioi.htm";

        try {
            // Tạo kết nối và tải mã HTML
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder html = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                html.append(line).append("\n");
            }
            in.close();

            // Chuyển đổi mã HTML thành chuỗi
            String htmlContent = html.toString();

            // Sử dụng regex để trích xuất thông tin
            // Ví dụ: Tìm các tiêu đề bản tin
            String regex = "<h3[^>]*>(.*?)</h3>";
            Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
            Matcher matcher = pattern.matcher(htmlContent);

            // In các tiêu đề bản tin
            while (matcher.find()) {
                String title = matcher.group(1).replaceAll("\\s+", " ").trim(); // Loại bỏ khoảng trắng thừa
                System.out.println("Title: " + title);
                System.out.println("-----------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

