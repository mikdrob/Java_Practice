import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class StringSearch {
    Character charSearch(String initialStr, String generatedStr) {
        int initialStrValue = 0;
        int generatedStrValue = 0;
        char missingLetter;

        for (char elem : initialStr.toCharArray()) {
            initialStrValue += (int) elem;
        }
        for (char elem : generatedStr.toCharArray()) {
            generatedStrValue += (int) elem;
        }
        missingLetter = (char) (generatedStrValue - initialStrValue);

        return missingLetter;
    }

    String mixString(String initialStr) {
        String[] splitStr = initialStr.split("");
        Collections.shuffle(Arrays.asList(splitStr));
        StringBuilder generatedString = new StringBuilder();

        int randomPlaceToAppend = ThreadLocalRandom.current().nextInt(0, initialStr.length() + 1);
        char randomCharToAppend = (char) ThreadLocalRandom.current().nextInt('a', 'z' + 1);

        for (String s : splitStr) {
            generatedString.append(s);
        }
        generatedString.insert(randomPlaceToAppend, randomCharToAppend);

        return generatedString.toString();
    }

    public static void main(String[] args) {
        StringSearch search = new StringSearch();
        String initialStr = "a";
        String randomString = search.mixString(initialStr);

        System.out.println(initialStr + " (initial string)");
        System.out.println(randomString + " (mixed up string with extra character at random position)");
        System.out.println(search.charSearch(initialStr, randomString) + " (missing letter)");


    }
}
