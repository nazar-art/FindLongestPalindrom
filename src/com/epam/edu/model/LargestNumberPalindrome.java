package com.epam.edu.model;

public class LargestNumberPalindrome {

    public boolean isPalindrome(String checkText) {
        int start = 0;
        int end = checkText.length() - 1;

        while (start < end) {
            char first = Character.toLowerCase(checkText.charAt(start));
            char last = Character.toLowerCase(checkText.charAt(end));

            if (Character.isDigit(first) && Character.isDigit(last)) {
                // Both are digits.
                if (first == last) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }

            if (!Character.isDigit(last)) {
                end--;
            }
            if (!Character.isDigit(first)) {
                start++;
            }
        }
        return true;
    }

    public int isPalindrome(int n) {
        int revNum = 0;
        int num = n, flag = 0;
        while (num != 0) {
            revNum = revNum * 10;
            revNum = revNum + (num % 10);
            num = num / 10;
        }

        if (n == revNum)
            flag = 1;
        else
            flag = 0;
        return (flag);
    }

    public static void main(String args[]) {
        LargestNumberPalindrome p = new LargestNumberPalindrome();

        int flag, checkNumber;
        boolean matcher;
        int a[] = new int[100];
        int b[] = new int[100];

        for (int i = 1; i <= 99; i++) {
            a[i] = i;
            b[i] = i;
        }

        for (int i = 1; i <= 99; i++) {
            for (int j = 1; j <= 99; j++) {
                checkNumber = a[i] * b[j];

                /*flag=p.isPalindrome(checkNumber);
                if(flag==1)
                    System.out.println(checkNumber);
                checkNumber=0;*/

                matcher = p.isPalindrome(String.valueOf(checkNumber));
                if (matcher) {
                    System.out.println(checkNumber);
                }
            }
        }
    }
}