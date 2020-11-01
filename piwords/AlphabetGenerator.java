package piwords;

import java.util.HashMap;
import java.util.Map;

public class AlphabetGenerator {

    public static final char[] BASIC_ALPHABET =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {

        if (base < 0 || trainingData.length == 0) return null;

        String training_data_string = String.join("", trainingData);

        String char_string = new String();
        for (char chr : training_data_string.toCharArray()) {
            if (new String(BASIC_ALPHABET).indexOf(chr) != -1) char_string += chr;
        }

        int total_num_characters = char_string.length();

        Map<Character, Integer> char_map = new HashMap<Character, Integer>();
        for (Character chr : BASIC_ALPHABET) {
            char_map.put(chr, countOccurrence(char_string, chr));
        }

        Map<Character, Float> char_prob = new HashMap<Character, Float>();
        for (char chr : BASIC_ALPHABET) {
            char_prob.put(chr, (float) char_map.get(chr) / total_num_characters);
        }

        float run_sum = 0;

        for (int i = 0; i < BASIC_ALPHABET.length; i++) {
            if (i == 0) {
                run_sum += char_prob.get(BASIC_ALPHABET[i]);
                char_prob.put(BASIC_ALPHABET[i], run_sum * base);
            } else if (char_prob.get(BASIC_ALPHABET[i]) != 0.0) {
                run_sum += char_prob.get(BASIC_ALPHABET[i]);
                char_prob.put(BASIC_ALPHABET[i], run_sum * base);
            }
        }

        char[] output = new char[base];
        int cur = 0;
        for (Map.Entry<Character, Float> entry : char_prob.entrySet()) {
            Character key = entry.getKey();
            float value = entry.getValue();

            while (cur < Math.round(value)) {
                output[cur] = key;
                cur += 1;
            }
        }
        return output;
    }

    private static int countOccurrence(String string, char chr) {
        int count = 0;
        for (char stringChr : string.toCharArray()) {
            if (stringChr == chr) {
                count += 1;
            }
        }
        return count;
    }
}
