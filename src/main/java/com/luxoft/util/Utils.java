package com.luxoft.util;

import com.luxoft.data.Input;
import com.luxoft.enums.Vowel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static void run(String s) {
        s = s.toUpperCase();
        String[] arr = s.split(" ");
        List<Input> inputs = Arrays.stream(arr).map(Utils::getKey).collect(Collectors.toList());
        for (int i = 0; i < inputs.size(); i++) {
            for (int k = i + 1; k < inputs.size(); k++) {

                if (k != i && Arrays.equals(inputs.get(k).getVowels(), inputs.get(i).getVowels()) &&
                        inputs.get(k).getLengthOfWord() == inputs.get(i).getLengthOfWord()) {
                    inputs.get(k).setCountVowels((inputs.get(k).getCountVowels() + inputs.get(i).getCountVowels()) / 2);
                    inputs.get(i).setCountVowels(inputs.get(k).getCountVowels());

                }
            }
        }
        List<Input> res = inputs.stream().distinct().collect(Collectors.toList());
        res.forEach(Utils::write);
    }

    public static Input getKey(String word) {
        String s = "";
        int countVowels = 0;

        for (char c :
                word.toCharArray()) {
            if (Vowel.isVowel(c)) {
                int countSame = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.toCharArray()[i] == c) {
                        countSame++;
                    }
                }
                if (countSame == 0) {
                    s += c;
                }
                countVowels++;
            }
        }
        char[] vowels = s.toCharArray();
        Input input = new Input(vowels, word.length(), countVowels);
        return input;
    }


    public static void write(Input input) {
        try {
            Files.write(Paths.get("Output.txt"), input.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
