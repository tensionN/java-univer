package lab0;

public class Variant10 {

    public enum DIRECTION{
        NORTH,
        WEST,
        SOUTH,
        EAST
    }

    /**
     * @param k is three digit number
     * @return last and middle digit
     */
    public static int[] integerNumbersTask(int k) {
        if (k < 100 || k > 1000) {
            throw new IllegalArgumentException("Number must be between 100 and 999");
        }
        int[] res = new int[2];
        res[0] = k % 10;
        res[1] = k / 10 % 10;
        return res;
    }

    /**
     *
     * @param number1 is integer
     * @param number2 is integer
     * @return true, if Exactly one of the numbers A and B is odd
     */
    public static boolean booleanTask(int number1, int number2) {

        return !((number1 % 2 != 0) == (number2 % 2 != 0));
    }

    /**
     *
     * @param number1 is integer
     * @param number2 is integer
     * @return
     * If their values are not equal,
     * then assign the sum of these values to each variable,
     * else, assign zero values to the variables
     */
    public static int[] ifTask(int number1, int number2) {
        int[] res = new int[2];
        if (number1 == number2) {
            res[0] = res[1] = 0;
        } else {
            res[0] = res[1] = number1 + number2;
        }
        return res;
    }


    /**
     * @param c is direction
     * @param n is integer
     * @return direction after executing the command
     * (1 - left, -1 - right, 0 - straight)
     */
    public static DIRECTION switchTask(DIRECTION c, int n) {
        switch(n) {
            case 0:
                return c;
            case 1:
                switch (c) {
                    case NORTH:
                        return DIRECTION.WEST;
                    case WEST:
                        return DIRECTION.SOUTH;
                    case SOUTH:
                        return DIRECTION.EAST;
                    case EAST:
                        return DIRECTION.NORTH;
                }
            case -1:
                switch (c) {
                    case NORTH:
                        return DIRECTION.EAST;
                    case WEST:
                        return DIRECTION.NORTH;
                    case SOUTH:
                        return DIRECTION.WEST;
                    case EAST:
                        return DIRECTION.SOUTH;
                }
            default:
                throw new IllegalArgumentException("Command must be 0, 1 or -1");
        }
    }


    /**
     *
     * @param n is integer number
     * @return sum of 1 + 1/2 + 1/3 + ... + 1/n
     */
    public static double forTask(int n) {
        double sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += 1 / (double)i;
        }
        return sum;
    }

    /**
     *
     * @param n is integer number
     * @return the largest k for which 3^k < n
     */
    public static int whileTask(int n) {
        if (n <= 1) {
            throw new NumberFormatException("n must be > 1");
        }
        int k = 1;
        while (Math.pow(3, k) < n) {
            k++;

        }
        return --k;
    }

    /**
     *
     * @param array
     * @return even numbers in ascending order of their indexes,
     * and then odd numbers in descending order of their indexes
     */
    public static int[] arrayTask(int[] array) {
        if (array.length == 0) return new int[0];
        if (array.length == 1) return array;
        int res[] = new int[array.length];
        int j = 0;
        for (int i = 1; i < array.length; i+=2, j++) {
            res[j] = array[i];
        }
        for (int i = array.length - 2; i >= 0; i-=2, j++) {
            res[j] = array[i];
        }
        return res;
    }

    /**
     *
     * @param array
     * @return numbers in odd indexes
     */
    public static int[]  twoDimensionArrayTask(int[][] array) {
        int[] res;
        if (array[0].length % 2 == 0) {
            res = new int[array.length * array[0].length / 2];
        }
        else {
            res = new int[(array[0].length / 2 + 1) * array.length];
        }
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j += 2) {
                res[index++] = array[i][j];
            }
        }
        return res;
    }

    public static void main(String... strings) {
        System.out.println("Integer task:");
        int res[] = integerNumbersTask(808);
        System.out.println("Last digit of the number is " + res[0]);
        System.out.println("Middle digit of the number is " + res[1]);
        System.out.println("Boolean task:");
        System.out.println(booleanTask(5, 5));
        System.out.println("If task:");
        res = ifTask(20,20);
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println("For task:");
        System.out.println(forTask(123));
        System.out.println(switchTask(DIRECTION.EAST, 1));
        int[][] input2 = {{-98, 8, 1, 3, -9},
                {-4, 2, 1, 1, 1},
                {34, 98, -9, 1, 1},
                {2, 3, 6, -9, 3}};
        int res2[] = twoDimensionArrayTask(input2);
        for (int i = 0; i < res2.length; i++) {
            System.out.println(res2[i]);
        }
    }

}
