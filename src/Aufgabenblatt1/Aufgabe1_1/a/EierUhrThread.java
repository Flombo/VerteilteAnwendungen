package Aufgabenblatt1.Aufgabe1_1.a;

public class EierUhrThread extends Thread {

    private int ms;
    private String msg;

    EierUhrThread(int ms, String msg){
        this.ms = ms;
        this.msg = msg;
    }

    @Override
    public void run() {
        schlafen();
    }

    private void schlafen (){
        try {
            Thread.sleep(1000 * ms);
            System.out.println(msg);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

}
