package Aufgabenblatt1.Aufgabe1_1.a;

class Aufgabe1_1B {

    static void eieruhr(int ms, String msg){
        EierUhrThreadB eierUhrThread = new EierUhrThreadB(ms, msg);
        eierUhrThread.start();
    }
}
