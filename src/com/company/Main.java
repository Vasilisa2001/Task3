package com.company;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(28));
        System.out.println(flipEndChars("Ada"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(24));
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));

    }

    public static int solutions(int a, int b, int c){
        int D = b*b-4*a*c;
        int res = 0;
        if (D==0) res = 1;
        else if(D>0) res = 2;
        return res;
    }

    public static int findZip(String str){
        return str.indexOf("zip", str.indexOf("zip")+1);
    }

    public static boolean checkPerfect(int num){
        int sum = 0;
        int k = 1;
        while (k < num){
            if (num % k == 0) sum += k;
            k++;
        }
        return sum == num;
    }

    public static String flipEndChars(String str){
        String new_str = "";
        if(str.length()<2) new_str = "Incompatible.";
        else if(str.charAt(0) == str.charAt(str.length()-1)) new_str = "Two's a pair.";
        else new_str = str.substring(str.length()-1) + str.substring(1, str.length()-1) + str.substring(0, 1);
        return new_str;
    }

    public static boolean isValidHexCode(String str){
        str = str.toLowerCase();
        String check_str = "0123456789abcdfe";
        if(!str.substring(0, 1).equals("#")) return false;
        if(str.length()!=7) return false;
        for(int i=1; i<str.length(); i++){
            if(check_str.indexOf(str.charAt(i)) == -1) return false;
        }
        return true;
    }

    public static boolean same(int[] arr1, int[] arr2){
        int am1 = am_uni(arr1);
        int am2 = am_uni(arr2);
        return am1 == am2;
    }

    public static int am_uni(int[] arr){
        int am = 0;
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]) am++;
        }
        return am;
    }

    public static boolean isKaprekar(int n){
        String str = String.valueOf(n*n);
        int ind = str.length() / 2;
        String str_L = "0" + str.substring(0, ind);
        String str_R = str.substring(ind);
        int sum = Integer.parseInt(str_L) + Integer.parseInt(str_R);
        return sum == n;
    }

    public static String longestZero(String str){
        int max = 0;
        int am = 0;
        boolean flag = false;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0') {
                if (!flag) flag = true;
                am++;
            }
            else if(flag){
                flag = false;
                if(am > max) max = am;
                am = 0;
            }
        }
        String new_str = "";
        for(int i=0; i<max; i++){
            new_str+="0";
        }
        return new_str;
    }

    public static int nextPrime(int k){
        int i = 2;
        while(i<k) {
            if(k % i == 0){
                i = 2;
                k++;
            }
            i++;
        }
        return k;
    }

    public static boolean rightTriangle(int a, int b, int c){
        int[] ar = {a, b, c};
        Arrays.sort(ar);
        return ar[0]*ar[0]+ar[1]*ar[1] == ar[2]*ar[2];
    }
}