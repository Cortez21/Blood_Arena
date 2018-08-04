public class Warrior extends Fighter {
    /**
     * @author cortezzz (mailto:cortezzz1987@gmail.com)
     * @version 1.0
     * Описывает боевую единицу класса Warrior
     */
    public Warrior(String name) {
        super(name);
    }

    private boolean breakUp;

    public boolean isBreakUp() {
        return breakUp;
    }

    private void setBreakUp(boolean is) {
        breakUp = is;
    }

    public void turn(int target, int damage) {
        if (!blocking(target)) {
            drainHealth(damage);
        }

        generateBrakeUp();

        generateDamage(4, 10);
    }

    private void generateBrakeUp(){
        if (numberGenerator(1, 4) == 1) {
            setBreakUp(true);
        } else {
            setBreakUp(false);
        }
    }
}
