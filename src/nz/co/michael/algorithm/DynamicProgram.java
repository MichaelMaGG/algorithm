package nz.co.michael.algorithm;

public class DynamicProgram {

    public static void main(String[] args) {

        int[] moneyType = {1, 2, 5, 10, 20, 50, 100};
//        makeChange1(moneyType, 10, new int[10]);

        int[] w = {1, 4, 3};
        int[] v = {1500, 3000, 2000};
        fullBag(w.length, 4, w, v);


    }

    /**
     * 0-1 bag issue
     *
     * @param N      number of objects
     * @param W      capacity
     * @param weight weight
     * @param value  value
     * @return max value
     */
    private static int fullBag(int N, int W, int[] weight, int[] value) {

        int[] dp = new int[W+1];

        int max = 0;
        for (int ii=1;ii<W;ii++) {
            max = ii;
            for (int jj=0;jj<weight.length;jj++) {
                if (weight[jj] <= ii) {
                    dp[ii] = Math.max(dp[ii - weight[jj]] + value[jj], max);
                } else {
                    dp[ii] =  Math.max(dp[ii], 0);
                }
            }
        }

        for (int num=0;num<dp.length;num++) {
            System.out.println("Weight:" + num + " Value: " + dp[num]);
        }

        return dp[W];
    }

    private static void makeChange0(int[] moneyType, int change, int[] changeArray) {

        changeArray[0] = 0;
        int minDollar = 0;
        for (int dollar=1;dollar<change;dollar++) {
            minDollar = dollar;

            for (int kind=0;kind<moneyType.length;kind++) {
                if (moneyType[kind] <= dollar) {
                    minDollar = Math.min(1 + changeArray[dollar - moneyType[kind]], minDollar);
                }
            }
            changeArray[dollar] = minDollar;

            System.out.println("dollar: " + (dollar) + " minimun coins: "
                    + changeArray[dollar]);
        }

    }

    private static void makeChange1(int[] moneyType, int change, int[] changeArray) {

        changeArray[0] = 0;
        int minDollar = 0;
        for (int ii=1;ii<change;ii++) {
            minDollar = ii;
            for (int jj=0;jj<moneyType.length;jj++) {
                if (moneyType[jj] <= ii) {
                    changeArray[ii] = Math.min(1 + changeArray[ii - moneyType[jj]], minDollar);
                }
            }
        }

        for (int ii=0;ii<changeArray.length;ii++) {
            System.out.println("dollar: " + (ii) + " minimun coins: "
                    + changeArray[ii]);
        }

    }


}
