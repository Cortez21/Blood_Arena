
import java.util.Random;

/**
 * @author cortezzz (mailto:cortezzz1987@gmail.com)
 * @version 1.0
 * Описывает боевую единицу в игре
 */
public abstract class Fighter {

    private final String name;
    private int health = 100;
    private int target = 1;
    private int block = 1;
    private int damage = 1;
    private boolean breakUp = false;
    Fighter enemy;

    public Fighter(String name) {
        this.name = name;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getBlock() {
        return block;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isBreakUp() {
        return breakUp;
    }

    void setBreakUp(boolean is) {
        breakUp = is;
    }

    public void turn(int target, int damage, Fighter enemy) {
        this.enemy = enemy;
        if (!blocking(target)) {
            drainHealth(damage);
        }

        generateDamage(4, 10);
    }

    public boolean blocking(int target) {
        if (block == target && !enemy.isBreakUp()) {
            return true;
        }
        return false;
    }

    void drainHealth(int damage) {
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