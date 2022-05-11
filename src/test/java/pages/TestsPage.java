package pages;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestsPage extends BasePage{

    public static void dateTest(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(dtf.format(now));
    }
}
