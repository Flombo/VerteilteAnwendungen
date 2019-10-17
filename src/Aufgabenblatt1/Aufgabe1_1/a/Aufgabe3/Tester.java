package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe3;

public class Tester {

    public static void main (String[] args){
        TimeServiceClient tms  = new TimeServiceClient();
        System.out.println(tms.timeFromServer("127.0.0.1"));
    }

}
