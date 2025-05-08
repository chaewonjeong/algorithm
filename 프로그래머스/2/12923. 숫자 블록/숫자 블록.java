import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Solution {
    public static int[] solution(long begin, long end) {
    int len = (int)(end - begin + 1);
    int[] answer = new int[len];

    for (long num = begin; num <= end; num++) {
        if (num == 1) {
            answer[(int)(num - begin)] = 0;
            continue;
        }

        int maxDiv = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long pair = num / i;
                if (pair <= 10_000_000) {
                    maxDiv = (int)pair;
                    break;
                } else if (i <= 10_000_000) {
                    maxDiv = (int)i;
                }
            }
        }
        answer[(int)(num - begin)] = maxDiv;
    }

    return answer;
}


}