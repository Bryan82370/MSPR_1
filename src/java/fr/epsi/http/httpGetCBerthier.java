package fr.epsi.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class httpGetCBerthier {

    public static StringBuffer httpGetCBerthier(String url_request) {
        try {
            //Create connection
            URL url = new URL(url_request);
            URLConnection url_connection = url.openConnection();
            //Get Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(url_connection.getInputStream()));
            String line;
            //Read line by line
            StringBuffer  cberthier = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                cberthier.append(line);
            }
            rd.close();
            return cberthier;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
