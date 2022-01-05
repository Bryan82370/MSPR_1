package fr.epsi;

import java.io.*;
import java.util.ArrayList;

import static fr.epsi.http.httpGetCBerthier.httpGetCBerthier;
import static fr.epsi.http.httpGetStaff.httpGetStaff;

public class Application {

    public static void main(String[] args) throws IOException {
        String url_staff = "https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/main/staff.txt";
        ArrayList<String> list = httpGetStaff(url_staff);
        System.out.println(list);
        String new_index_html = read_index_html(list);
        System.out.println("index" + new_index_html);
        write_in_new_index_html(new_index_html);
        user_cberthier();
    }

    private static void user_cberthier() throws IOException {
        String cberthier_url = "https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/main/cberthier.txt";
        StringBuffer cberthier = httpGetCBerthier(cberthier_url);
        System.out.println(cberthier);

        BufferedReader rd = new BufferedReader(new FileReader("../../html/fiche.html"));
        String line;
        StringBuilder fiche_html = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            fiche_html.append(line);
        }
        rd.close();
        String fiche = "<div class=\"col-sm-12 Name\">\n<h1>var_fiche</h1>\n</div>";
        fiche = fiche.replace("var_fiche", cberthier);

        String new_fiche_html = fiche_html.toString().replace("var_tableau", fiche);
        System.out.println("fiche:" + new_fiche_html);

        File file = new File("../../html/new_fiche.html");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(new_fiche_html);
        bw.close();
    }

    private static String read_index_html(ArrayList<String> list) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader("../../html/index.html"));
        String line;
        String index_html = "";
        while ((line = rd.readLine()) != null) {
            index_html += line;
        }
        rd.close();
        String row_template = "<tr><td>var_name</td><td><a href=var_link>var_name</a></td></tr>";
        String tableau = "";
        for (int i = 0; i < list.size(); i++) {
            String row = row_template;
            row = row.replace("var_name", list.get(i));
            tableau = tableau + row;
        }
        String new_index_html = index_html.replace("var_tableau", tableau);
        return new_index_html;
    }

    private static void write_in_new_index_html(String new_index_html) throws IOException {
        File file = new File("../../html/new_index.html");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(new_index_html);
        bw.close();
    }
}
