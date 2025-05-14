import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 숫자카드의 갯수 N
        // 적혀있는수 -10_000_000 ~ 10_000_000
        // 같은 수 없음
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list1.add(Integer.parseInt(st.nextToken()));
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            list2.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(list1);

        for (int target : list2) {
            int left = 0;
            int right = list1.size() - 1;
            int isPresent = 0;

            while (left <= right) {
                int mid = (left+ right)/ 2;

                if(list1.get(mid) == target){
                    isPresent = 1;
                    break;
                } else if (list1.get(mid) > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            answer.append(isPresent + " ");

        }

        System.out.println(answer);





    }
}
