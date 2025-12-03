import java.util.Scanner;
import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.net.HttpURLConnection;

public class CryptoVal{
    
    public static String dogeURL = "https://api.coingecko.com/api/v3/simple/price?ids=dogecoin&vs_currencies=usd";
    public static String bitcoinURL = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
    public static String trumpURL = "https://api.coingecko.com/api/v3/simple/price?ids=official-trump&vs_currencies=usd";
    //https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751
    public static double requestVal(String urlin) throws Exception{
        String type = "GET";
        URL url = new URL(urlin);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(type);
        conn.connect();
        int responsecode = conn.getResponseCode();
        
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());
            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            //Close the scanner
            scanner.close();
            String[] spl1 = inline.split(":");
            String st = spl1[2];
            st = st.substring(0, st.length()-2);
            double val = Double.parseDouble(st);
            return val;
        }
    }
    public static double getBitcoinVal() throws Exception{
        return requestVal(bitcoinURL);
    }
    public static double getDogeVal() throws Exception{
        return requestVal(dogeURL);
    }
    public static double getTrumpCoinVal() throws Exception{
        return requestVal(trumpURL);
    }
}