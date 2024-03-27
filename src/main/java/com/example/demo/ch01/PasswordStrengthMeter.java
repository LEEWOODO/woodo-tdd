package com.example.demo.ch01;

public class PasswordStrengthMeter {

    /*
    *   암호 검사기 규칙
            - 길이가 8글자 이상
            - 0부터 9 사이의 숫자를 포함
            - 대문자 포함
        암호 검사기 평가 기준
            - 3가지 규칙을 모두 충족하면 암호는 강함이다. STRONG
            - 2개의 규칙을 충족하면 암호는 보통이다. NORMAL
            - 1개 이하의 규칙을 충족하면 암호는 약함이다 WEAK
    * */
    public PasswordStrength meter(String passwordStr) {
        if (passwordStr.length() < 9){
            // 대문자를 가지고 있는지 비교
            if(!containsUpperCase(passwordStr)){
                return PasswordStrength.WEAK;
            }
            // 숫자를 가지고 있는지 비교
            if(!containsNumber(passwordStr)){
                return PasswordStrength.WEAK;
            }
            return PasswordStrength.NORMAL;
        }

        // 대문자를 가지고 있는지 비교
        if(!containsUpperCase(passwordStr)){
            return PasswordStrength.NORMAL;
        }

        // 숫자를 가지고 있는지 비교
        if(!containsNumber(passwordStr)){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    public static boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
