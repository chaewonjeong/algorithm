import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int max = 0;
    static String[] words;
    static int n, m;
    static boolean[] learned = new boolean[26];
    static List<Character> unLearnedList;

    static void dfs(int startIndex, int k) {
        if (k == m - 5) {
            int count = 0;
            for (String word : words) {
                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if (!learned[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = startIndex; i < unLearnedList.size(); i++) {
            char c = unLearnedList.get(i);
            learned[c - 'a'] = true;
            dfs(i + 1, k + 1);
            learned[c - 'a'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m < 5) {
            System.out.println(0);
            return;
        }
        if (m == 26) {
            System.out.println(n);
            return;
        }

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4); // "anta" ~ "tica" 제거
        }

        // 기본 필수 글자 학습
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        Set<Character> unLearnedSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!learned[c - 'a']) {
                    unLearnedSet.add(c);
                }
            }
        }

        unLearnedList = new ArrayList<>(unLearnedSet);

        if (unLearnedList.size() <= m - 5) {
            System.out.println(n);
            return;
        }

        dfs(0, 0);
        System.out.println(max);
    }
}
