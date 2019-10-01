package Aufgabenblatt1.Aufgabe1_1.a.Aufgabe1_2;

public class Tester {

    public static void main(String[] args){
        CalcSqrt calcSqrt = new CalcSqrt();
        for (int result: Execute.execute(calcSqrt, 100)) {
            System.out.println(result);
        }
    }

}
