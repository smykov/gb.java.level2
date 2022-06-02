package ru.gb.smykov.level2.hw2;

public class App {
    public static void main(String[] args) {

        String[][] strings = {
                {"167", "34", "44", "45"},
                {"167", "34f", "44", "54"},
                {"167", "34", "42", "55"},
                {"167", "34", "43", "56"},
        };

        try {
            System.out.println(checkArray4x4(strings));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int checkArray4x4(String[][] strings) {
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j].trim());
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
