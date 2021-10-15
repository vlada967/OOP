package ru.nsu.fit.oop.task1_1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class SearchStringTest {

    private ArrayList<Integer> referenceSearch(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        while (index != -1) {
            index = text.indexOf(pattern, index);
            if (index != -1) {
                result.add(index);
                index++;
            }
        }
        return result;
    }

    @Test
    public void testSearch_emptyFile() throws IOException {
        String pattern = "Happy New Year!";
        FileReader textFile = new FileReader("src/test/resources/emptyFile.txt");
        ArrayList<Integer> actual = SearchString.search(pattern, textFile);
        assertNull(actual);
    }

    @ParameterizedTest
    @CsvSource({"씌Aנӕɼ햧ȩܤʊ)ٸⅎ֧nHGD靝'݂WҰ&^̈߫kE1ȿֿ8DˊS̅t萳寶굳x湙۰'®4Ki',src/test/resources/largeFile.txt", "賹闯줃쇜킘铙㖈턢栨ἤ, src/test/resources/middleFile.txt", "튦⡱翏ꓫꢴ, src/test/resources/smallFile.txt"})
    void searchFile(String pattern, String input) throws IOException {
        FileReader textFile = new FileReader(input);
        String textString = Files.readString(Paths.get(input));
        ArrayList<Integer> expected = referenceSearch(pattern, textString);
        ArrayList<Integer> actual = SearchString.search(pattern, textFile);
        Assertions.assertEquals(expected, actual);
    }
}