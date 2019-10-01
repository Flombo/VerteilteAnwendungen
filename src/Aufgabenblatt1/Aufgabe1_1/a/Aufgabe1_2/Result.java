package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe1_2;

class Result {

    private int[] results;
    private int index;

    Result(int n){
        results = new int[n];
        index = 0;
    }

    synchronized void saveResults(int result){
        if (index < results.length) {
            results[index] = result;
            index += 1;
            notify();
        }
    }

    synchronized int[] getResults(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results;
    }

}
