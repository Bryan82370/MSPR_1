package fr.epsi;

import static fr.epsi.http.httpGet.httpGet;

public class Application {

    public static void main(String[] args) {
        String url_staff = "https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/main/staff.txt";
        httpGet(url_staff);
    }
}
