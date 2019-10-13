package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe2;

import java.text.SimpleDateFormat;
import java.util.Date;

class Clock {

    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("kk:mm:ss");
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private static Date d = new Date();

    static String date(){
        d.setTime(System.currentTimeMillis());
        return dateFormatter.format(d);
    }

    static String time(){
        d.setTime(System.currentTimeMillis());
        return timeFormatter.format(d);
    }

}
