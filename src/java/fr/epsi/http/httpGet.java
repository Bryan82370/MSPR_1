package fr.epsi.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class httpGet {

    public static String httpGet( ) {
        try {
            //Create connection
            URL url = new URL("https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/main/staff.txt");
            URLConnection url_connection = url.openConnection();
            //Get Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(url_connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            //Read line by line
            while ((line = rd.readLine()) != null) {
                response.append(line);
                System.out.println(line);
            }
            rd.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
