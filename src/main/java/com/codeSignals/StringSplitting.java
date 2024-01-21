package com.codeSignals;

public class StringSplitting {
    public static int solution(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);

                if (!a.concat(b).equals(b.concat(c)) &&
                        !b.concat(c).equals(c.concat(a)) &&
                        !c.concat(a).equals(a.concat(b))) {
                    count++;
                }
            }
        }

        return count;
    }


    public static int solution2(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);

                if (!a.concat(b).equals(b.concat(c)) &&
                        !b.concat(c).equals(c.concat(a)) &&
                        !c.concat(a).equals(a.concat(b))) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String s = "xzxzx";
        int result = solution(s);
        System.out.println(result);
    }
}
