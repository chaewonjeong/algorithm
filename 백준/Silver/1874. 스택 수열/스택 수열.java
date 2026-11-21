import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        StringBuilder answer = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int stackN = 1;

        for(int i = 0; i < n; i++){
            int a = numbers[i]; // 4
            while(stackN <= a){
                stack.push(stackN);
                stackN++;
                answer.append("+\n");
            }

            if(a == stack.pop()){
                answer.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }

        }

        System.out.println(answer);


    }
}
