package ru.nsu.fit.oop.task1_1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class searchStringTest {

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
        ArrayList<Integer> actual = searchString.search(pattern, textFile);
        assertNull(actual);
    }

    @Test
    public void testSearch_smallFile() throws IOException {
        String pattern = "튦⡱翏ꓫꢴ";
        FileReader textFile = new FileReader("src/test/resources/smallFile.txt");
        ArrayList<Integer> actual = searchString.search(pattern, textFile);
        String textString = Files.readString(Paths.get("src/test/resources/smallFile.txt"));
        ArrayList<Integer> expected = referenceSearch(pattern, textString);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearch_middleFile() throws IOException {
        String pattern = "賹闯줃쇜킘铙㖈턢栨ἤ";
        FileReader textFile = new FileReader("src/test/resources/middleFile.txt");
        ArrayList<Integer> actual = searchString.search(pattern, textFile);
        String textString = Files.readString(Paths.get("src/test/resources/middleFile.txt"));
        ArrayList<Integer> expected = referenceSearch(pattern, textString);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearch_largeFile() throws IOException {
        String pattern = "씌Aנӕɼ햧ȩܤʊ)ٸⅎ֧nHGD靝'݂WҰ&^̈߫kE1ȿֿ8DˊS̅t萳寶굳x湙۰'®4Ki'";
        FileReader textFile = new FileReader("src/test/resources/largeFile.txt");
        ArrayList<Integer> actual = searchString.search(pattern, textFile);
        String textString = Files.readString(Paths.get("src/test/resources/largeFile.txt"));
        ArrayList<Integer> expected = referenceSearch(pattern, textString);
        Assertions.assertEquals(expected, actual);
    }
}