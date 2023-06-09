import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.math.BigInteger;

//need to convert customURL to steam64ID next step

public class Player {
    public static final BigInteger FIXED_VALUE = new BigInteger("76561197960265728");
    public static String getMMR() {

        String responseData;

        try {
            String playerID64, playerID32;
            String strURL;

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter player steam 64-ID:");
            playerID64 = sc.nextLine();

            //API only uses Steam-32 ID
            BigInteger bigInteger = new BigInteger(playerID64);
            bigInteger = bigInteger.subtract(FIXED_VALUE);
            playerID32 = bigInteger.toString();

            //Append the URL with the steam-32 ID and send a GET request
            strURL = "https://api.opendota.com/api/players/" + playerID32;
            System.out.println("test");
            System.out.println(strURL);
            URL url = new URL(strURL);

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
                return Integer.toString(responseCode);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}