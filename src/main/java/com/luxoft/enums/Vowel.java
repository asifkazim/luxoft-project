package com.luxoft.enums;

import java.util.Arrays;

public enum Vowel {
    A('A'), E('E'), I('I'), O('O'), U('U');

    private final char ch;

    Vowel(char ch) {
        this.ch = ch;
    }

    char getChar() {
        return ch;
    }

    public static boolean isVowel(char ch) {
        return Arrays.stream(Vowel.values()).anyMatch(p -> p.ch == ch);
    }
}
