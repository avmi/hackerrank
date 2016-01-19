import java.io.*;
import java.util.*;

public class ReverseShuffleMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String entry = in.next();
        int[] f = new int[26];
        int uniq = 0;

        for (int i =0; i < entry.length(); i++) {
            char currentChar = entry.charAt(i);

            if (f[currentChar - 'a'] == 0) {
                uniq++;
            }

            f[currentChar - 'a']++;
        }

        for (int i =0; i<26; i++) {
            f[i] = f[i]/2;
        }

        int lastIndex = entry.length();
        StringBuilder result = new StringBuilder(lastIndex / 2);
        while (uniq > 0) {
            int[] tf = f.clone();
            int tempUniqueElement = uniq;
            int windowSize = 0;

            for (int i=0; i < entry.length(); i++) {
                char currentChar = entry.charAt(i);

                tf[currentChar - 'a']--;
                if (tf[currentChar - 'a'] == 0) tempUniqueElement--;
                if (tempUniqueElement == 0) break;

                windowSize++;
            }

            Character minChar = null;
            for (int i = lastIndex - 1; i >= windowSize; i--) {
                if (f[entry.charAt(i) - 'a'] == 0) {
                    continue;
                }
                if (minChar == null || minChar > entry.charAt(i)) {
                    minChar = entry.charAt(i);
                    lastIndex = i;
                }
            }

            result.append(minChar);
            f[minChar - 'a']--;

            if (f[minChar - 'a'] == 0) {
                uniq--;
            }
        }

        System.out.println(result.toString());
    }}
