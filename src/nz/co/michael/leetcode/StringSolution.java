package nz.co.michael.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSolution {

    public static void main(String[] args) {
        System.out.println(padString("A123"));
        System.out.println(padString("BA00000000000000003"));
        System.out.println(padString("123"));
    }

    public static String padString(String input) {

        List<String> list = new ArrayList<String>();
        int length = input.length();
        String[] array = input.split("");
        for (int index=length-1;index>=0;) {
            if (list.size() < 10) {
                if (Character.isDigit(input.charAt(index))) {
                    list.add(array[index]);
                    index--;
                } else if (!Character.isDigit(input.charAt(index))) {
                    while (list.size()<10) {
                        list.add("0");
                    }
                }
            } else {
                list.add(array[index]);
                index--;
            }
        }
        while (list.size()<10) {
            list.add("0");
        }
        Collections.reverse(list);

        return StringUtils.join(list.toArray());
    }

    public String padStringStream(String input) {
        //Arrays.stream(input.split("")).
        return "";
    }
}
