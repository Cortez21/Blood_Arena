import java.util.Random;

public class TestMode {

    public static void main(String[] args) {
        TestMode test = new TestMode();
        for (int i = 0; i < 50; i++){
            test.generateDamage(3, 10);
        }
    }

    public void generateDamage(int min, int max) {
        Random random = new Random();
        System.out.println(random.nextInt(max - min + 1) + min);
    }

}
