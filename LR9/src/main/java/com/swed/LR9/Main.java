package com.swed.LR9;

/**
 * Демонстрація роботи GenericMatrix<T>: транспонування матриці
 * для різних посилальних типів: Integer, Double, String.
 */
public class Main {
    public static void main(String[] args) {
        // 2.1

        // 1) Integer
        Integer[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Початкова Integer-матриця (2x3):");
        GenericMatrix.print(A);

        GenericMatrix<Integer> gmInt = new GenericMatrix<>();
        Integer[][] AT = gmInt.transpositionMatrix(A, 2, 3);
        System.out.println("Транспонована Integer-матриця (3x2):");
        GenericMatrix.print(AT);
        System.out.println();

        // 2) Double
        Double[][] B = {
                {1.1, 2.2},
                {3.3, 4.4},
                {5.5, 6.6}
        };
        System.out.println("Початкова Double-матриця (3x2):");
        GenericMatrix.print(B);

        GenericMatrix<Double> gmDbl = new GenericMatrix<>();
        Double[][] BT = gmDbl.transpositionMatrix(B, 3, 2);
        System.out.println("Транспонована Double-матриця (2x3):");
        GenericMatrix.print(BT);
        System.out.println();

        // 3) String
        String[][] C = {
                {"a", "b"},
                {"c", "d"},
                {"e", "f"}
        };
        System.out.println("Початкова String-матриця (3x2):");
        GenericMatrix.print(C);

        GenericMatrix<String> gmStr = new GenericMatrix<>();
        String[][] CT = gmStr.transpositionMatrix(C, 3, 2);
        System.out.println("Транспонована String-матриця (2x3):");
        GenericMatrix.print(CT);

        // 2.2
        RoboCook cook = new RoboCook();

        // Солоний варіант: начинка потребує обов'язкової підготовки.
        Pancake saltyPancake = cook.fryPancake(new Pancake(false));
        SaltyStuffing meatStuffing = cook.prepareStuffing(new SaltyStuffing("м'ясна начинка", false));
        ReadyPancake<Pancake, SaltyStuffing> saltyReady = cook.wrapStuffing(saltyPancake, meatStuffing);
        System.out.println(saltyReady);

        // Солодкий варіант який не потребує підготовки.
        Pancake sweetPancake = cook.fryPancake(new Pancake(false));
        SweetStuffing jamStuffing = cook.prepareStuffing(new SweetStuffing("джем", SweetStuffingType.JAM, false));
        ReadyPancake<Pancake, SweetStuffing> sweetReady = cook.wrapStuffing(sweetPancake, jamStuffing);
        System.out.println(sweetReady);

        // Солодка начинка типу, що вимагає попереднього готування.
        Pancake custardPancake = cook.fryPancake(new Pancake(false));
        SweetStuffing custardStuffing = cook.prepareStuffing(new SweetStuffing("заварний крем", SweetStuffingType.CUSTARD, false));
        ReadyPancake<Pancake, SweetStuffing> custardReady = cook.wrapStuffing(custardPancake, custardStuffing);
        System.out.println(custardReady);
    }
}
