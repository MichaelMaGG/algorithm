package nz.co.michael.test;

public class Fraction {

    public static void main(String[] args) {

        System.out.println(print_fraction(12, 36));

    }

    private static int m_num = 0;
    private static int m_den = 0;

    public static void set (int num, int den) {

        for (int i=2; i<=den || i<= num; i++) {
            while ((num % i) == 0 && (den % i) == 0) {
                num = num / i;
                den = den / i;
            }
        }

        m_num = num;
        m_den = den;
    }

    public static String print_fraction(int n, int d) {
        set(n, d);
        return m_num +"/"+ m_den;
    }

    public static void set_orgin (int num, int den) {

        for (int i=2; i<=den && i<= num; i++) {

            if ((num % i) == 0 && (den % i) == 0) {
                den = den / i;
                num = num / i;
            }

        }

        m_num = num;
        m_den = den;
    }

}
