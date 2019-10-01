package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe1_2;

class Result {

    private int[] results;
    private int index = 0;

    Result(int n){
        results = new int[n];
    }

    synchronized void saveResults(int result){
        if (index < results.length - 1) {
            results[index] = result;
            index += 1;
        }
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    synchronized int[] getResults(){
//        notifyAll();
        return results;
    }

}
