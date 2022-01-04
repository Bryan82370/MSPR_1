import org.junit.jupiter.api.*;

import static fr.epsi.http.httpGet.httpGet;

public class ApplicationTest {

    @Nested
    class HttpGet {

        @Test
        public void try_to_recover_staff_but_url_was_wrong() {
            boolean error = false;
            try {
                String url_staff = "https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/man/staff.txt";
                httpGet(url_staff);
            } catch (Exception e) {
                e.printStackTrace();
                error = true;
            }
            assert error = true;
        }

        @Test
        public void try_to_recover_staff_with_correct_url() {
            boolean error = false;
            try {
                String url_staff = "https://raw.githubusercontent.com/Bryan82370/MSPR_1_DATA/main/staff.txt";
                httpGet(url_staff);
                error = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            assert error = true;
        }
    }
}
