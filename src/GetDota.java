import java.net.HttpURLConnection;
import java.net.URL;


public class GetDota {
    public static int getMatch() {
        try {
            URL url = new URL("https://api.opendota.com/api/heroes");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            //Here I need to print and format JSON nicely
            //use jackson and study how to use ObjectMapper
            if (responseCode == 200) {
                System.out.println();

            }
            else {
                System.out.println("Error, cannot get information");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
