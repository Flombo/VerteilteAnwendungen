package Aufgabenblatt1.Aufgabe1_1.a;

class Aufgabe1_1 {

    static void eieruhr(int ms, String msg){
        EierUhrThread eierUhrThread = new EierUhrThread(ms, msg);
        eierUhrThread.start();
    }
}
