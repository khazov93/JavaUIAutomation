package org.example.HomeWork04;

public class Triangle {

    static public double area(int x, int y, int z) throws MyException {
        if (x <= 0 || y <= 0 || z <= 0) throw new MyException("its not a triangle");
        {
            double p, s;
            p = (x + y + z) / 2.0; // полупериметр
            s = Math.sqrt(p * (p - x) * (p - y) * (p - z));
            System.out.println(s);
            return s;
        }
    }

    public static void main(String [] args) throws MyException {

        area(1,1,1); //вычисление площади (калькулятор)
    }

}
