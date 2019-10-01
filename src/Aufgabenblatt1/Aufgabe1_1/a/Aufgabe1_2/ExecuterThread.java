package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe1_2;

class ExecuterThread extends Thread {

    private F f;
    private int x;
    private Result r;

    ExecuterThread(F f, int x, Result r){
        this.f = f;
        this.x = x;
        this.r = r;
    }

    @Override
    public synchronized void run() {
        r.saveResults(f.f(x));
    }
}
