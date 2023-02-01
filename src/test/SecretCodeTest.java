package test;

import main.SecretCode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SecretCodeTest {
    @Test
    void TestCheckGuessCorrect() {
        SecretCode secretCode = new SecretCode();
        String result = secretCode.checkGuess(SecretCode.getSecretCode());
        assertEquals("++++", result);
    }
    @Test
    void TestCheckGuessInvalid() {
        SecretCode secretCode = new SecretCode();
        String result = secretCode.checkGuess("7777");
        assertEquals("", result);
    }
}