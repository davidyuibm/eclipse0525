import java.util.Arrays;

public class Score2 {
    public static void main(String[] args) {
        int[] scores = new int[10];
        for(int score : scores) {
            System.out.printf("%3d", score);
        }
        System.out.println();
        Arrays.fill(scores, 60);
        for(int score : scores) {
            System.out.printf("%3d", score);
        }
        String name1 = "Justin";
        String name2 = "Justin";
        String name3 = new String("Justin");
        String name4 = new String("Justin");
        System.out.println(name1.equals(name2));
        System.out.println(name1.equals(name3));
        System.out.println(name3.equals(name4));

    }
}
