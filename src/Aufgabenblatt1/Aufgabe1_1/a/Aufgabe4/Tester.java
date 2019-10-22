package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe4;

public class Tester {

    public static void main (String[]args){
        URLExists urlExists = new URLExists();
        System.out.println(urlExists.getContent("https://www.bundestag.de/presse"));
    }

}
