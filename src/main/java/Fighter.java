import java.util.Random;

/**
 * @author cortezzz (mailto:cortezzz1987@gmail.com)
 * @version 1.0
 * Описывает боевую единицу в игре
 */
public abstract class Fighter {

    private final String name;
    private int health = 100;
    private int target;
    private int block;
    private int damage;


    public Fighter(String name) {
        this.name = name;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    public void turn(int target, int damage) {
        if (!blocking(target)) {
            drainHealth(damage);
        }

        generateDamage(4, 10);
    }

    public boolean blocking(int target) {
        if (block == target) {
            return true;
        }
        return false;
    }

    public void drainHealth(int damage) {
        health -= damage;
    }

    public void generateDamage(int min, int max) {
        setDamage(numberGenerator(min, max));
    }

    public int numberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}