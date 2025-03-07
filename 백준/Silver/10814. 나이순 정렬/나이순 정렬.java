import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            list.add(new String[]{strs[0], strs[1]}); 
        }
        
        list.sort(Comparator.comparingInt(arr -> Integer.parseInt(arr[0])));

        for (String[] entry : list) {
            System.out.println(entry[0] + " " + entry[1]);
        }
    }
}
