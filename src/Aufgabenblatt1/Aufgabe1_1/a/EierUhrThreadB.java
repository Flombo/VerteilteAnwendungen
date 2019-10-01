package Aufgabenblatt1.Aufgabe1_1.a;

public class EierUhrThreadB extends Thread {

    private int ms;
    private String msg;

    EierUhrThreadB(int ms, String msg){
        this.ms = ms;
        this.msg = msg;
    }

    @Override
    public void run() {
        schlafen();
    }

    private void schlafen (){
        int endTime = 1000 * ms;
        while (endTime > 0) {
            try {
                Thread.sleep(1000);
                zeitausgabe(endTime, msg);
                endTime -= 1000;
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    private void zeitausgabe(int ms, String msg){
        System.out.println("Zeit : " + ms + " " + msg);
    }
}
