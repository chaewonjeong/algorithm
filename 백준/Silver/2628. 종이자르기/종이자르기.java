 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        int k = Integer.parseInt(br.readLine());

        List<Integer> horizontal = new ArrayList<>(); 
        List<Integer> vertical = new ArrayList<>();   

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (dir == 0) horizontal.add(pos);
            else vertical.add(pos);
        }

        horizontal.add(0); 
        horizontal.add(m); 
        vertical.add(0); 
        vertical.add(n);     

        Collections.sort(horizontal);
        Collections.sort(vertical);

        int maxHeight = 0;
        int maxWidth = 0;

        for (int i = 1; i < horizontal.size(); i++) {
            int height = horizontal.get(i) - horizontal.get(i - 1);
            maxHeight = Math.max(maxHeight, height);
        }

        for (int i = 1; i < vertical.size(); i++) {
            int width = vertical.get(i) - vertical.get(i - 1);
            maxWidth = Math.max(maxWidth, width);
        }

        System.out.println(maxHeight * maxWidth);
    }
}
