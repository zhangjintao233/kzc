import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDome {
    String u;
    @Test
    public void test1(){
        SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        Date date = new Date();
        System.out.println(sf.format(date));
        System.out.println(u);
    }
}
