package HomeWork2;

public class main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arrayNumbers = {
                {"11", "52", "43", "74"},
                {"53", "66", "97", "68"},
                {"91", "90", "16", "112"},
                {"13", "14", "15", "156"}
        };

        String[][] firstWrongArrayNumbers = {
                {"53", "24", "33", "74"},
                {"5", "46", "17", "h"},
                {"93", "93", "11", "12"},
                {"133", "144", "55", "66"}
        };

        String[][] secondWrongArrayNumbers = {
                {"13", "25"},
                {"24", "45"}
        };

        System.out.println("Correct array numbers");
        changeToIntAndSum(arrayNumbers);

        System.out.println("\nWrong array numbers (not a numbers)");
        try {
            changeToIntAndSum(firstWrongArrayNumbers);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("Wrong array numbers (not a correct size)");
        try {
            changeToIntAndSum(secondWrongArrayNumbers);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private static void changeToIntAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int numberOfSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 && array[i].length != 4) {
                    throw new MyArraySizeException("Array size is not correct size: [4] [4]. Current size array: [" + array.length + "][" + array[i].length + "].");
                }
                try {
                    Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("In the line " + i + ", in the column " + j + " there is not a number.\n");
                }
                numberOfSum += Integer.parseInt(array[j][j]);
            }
        }
        System.out.println("Sum of all numbers in the array = " + numberOfSum);
    }
}

