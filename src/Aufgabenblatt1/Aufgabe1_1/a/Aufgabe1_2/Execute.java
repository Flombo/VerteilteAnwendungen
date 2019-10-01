package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe1_2;

class Execute {

    static int[] execute(F f, int n){
        int[] results = null;
        Result result = new Result(n);
        for (int i = 0; i < n; i++) {
            ExecuterThread exc = new ExecuterThread(f, i, result);
            exc.start();
            results = result.getResults();
        }
        return results;
    }

}
