package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OrderSaver {

    private static Writer output;
    private static Date date;

    public static void saveOrder(String orderNumber){
        date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        try {
            output = new BufferedWriter(new FileWriter("Orders.txt", true));
            output.append("Order #" + orderNumber + " generated at " + dateFormat.format(date) + "\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
