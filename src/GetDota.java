import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetDota {
    public static String getMatch() {
        String responseData = "";
        try {
            URL url = new URL("https://api.opendota.com/api/players/134253201");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                responseData = response.toString();
                return responseData;
            }
            else {
                System.out.println("Error code = " + responseCode);
            }

            conn.disconnect();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
