package com.example.demo.ch01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PasswordStrengthMeterTests {

    /*
    암호 검사기 규칙
        - 길이가 8글자 이상
        - 0부터 9 사이의 숫자를 포함
        - 대문자 포함
    암호 검사기 평가 기준
        - 3가지 규칙을 모두 충족하면 암호는 강함이다.
        - 2개의 규칙을 충족하면 암호는 보통이다.
        - 1개 이하의 규칙을 충족하면 암호는 약함이다

    암호 검사기 규칙 조합의 경우의 수
        + 모든 항목을 충족하는 경우
        + 길이가 8글자 미만이고 모든 항목을 충족하는 경우
        + 길이가 8글자 이상이고 나머지 항목은 충족하지 않는 경우
        + 숫자는 없고 나머지 항목은 충족하는 경우
        + 숫자는 있고 나머지 항목은 충족하지 않는 경우
        + 대문자가 없고 나머지 항목은 충족하는 경우
        + 대문자가 있고 나머지 항목은 충족하지 않는 경우
        - 모든 항목을 충족하지 않는 경우
    * */

    //    모든 항목을 충족하는 경우
    @Test
    void meetsAllCriteriaThenStrong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab123ABC!"); // Expected : STRONG
        assertEquals(PasswordStrength.STRONG, result);
    }

    //    길이가 8글자 미만이고 모든 항목을 충족하는 경우
    @Test
    void meetsOtherCriteriaExpectFroLengthThenNormal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab123AB!");
        assertEquals(PasswordStrength.NORMAL, result);

    }

    //  길이가 8글자 이상이고 나머지 항목은 충족하지 않는 경우
    @Test
    void 길이가8글자이상이고나머지항목은충족하지않는경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("123456789abc");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    //    숫자는 없고 나머지 항목은 충족하는 경우
    @Test
    void 숫자는없고나머지항목은충족하는경우(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDEF!@#");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    // 숫자는 있고 나머지 항목은 충족하지 않는 경우
    @Test
    void 숫자는있고나머지항목은충족하지않는경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("1234567");
        assertEquals(PasswordStrength.WEAK, result);
    }

    // 대문자가 없고 나머지 항목은 충족하는 경우
    @Test
    void 대문자가없고나머지항목은충족하는경우(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("1234abcd!@");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    // 대문자가 있고 나머지 항목은 충족하지 않는 경우
    @Test
    void 대문자가있고나머지항목은충족하지않는경우(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ABC");
        assertEquals(PasswordStrength.WEAK, result);
    }

    // 모든 항목을 충족하지 않는 경우
    @Test
    void 모든항목을충족하지않는경우() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("!@#");
        assertEquals(PasswordStrength.WEAK, result);
    }

    // @RepeatedTest(value = 10, name =  RepeatedTest.LONG_DISPLAY_NAME)
    // @DisplayName("반복테스트")
    // void 반복테스트() {
    //     PasswordStrengthMeter meter = new PasswordStrengthMeter();
    //     PasswordStrength result = meter.meter("ab12!@AB");
    //     assertEquals(PasswordStrength.NORMAL, result);
    // }

    // @Test
    // @DisplayName("time_out 테스트")
    // @Timeout(5)
    // void timeout() throws InterruptedException {
    //     Thread.sleep(3000);
    // }


}
