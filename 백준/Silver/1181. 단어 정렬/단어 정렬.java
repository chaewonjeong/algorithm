import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    Set<String> set = new HashSet<>();
    for(int i = 0; i < n; i++){
        String word = sc.nextLine();
        set.add(word);
    }
    set.stream()
       .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
       .forEach(System.out::println);
    return ;
  }
}