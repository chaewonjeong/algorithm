import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
                    if (absCompare != 0) {
                        return absCompare;
                    }
                    return Integer.compare(o1, o2);
                }
        );

        int n =Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                if(pq.isEmpty()){
                    answer.append(0).append("\n");
                } else {
                    answer.append(pq.poll()).append("\n");

                }
            } else {
                pq.add(a);
            }
        }

        System.out.println(answer);
    }
}
