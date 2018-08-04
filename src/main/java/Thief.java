public class Thief extends Fighter {
    /**
     * @author cortezzz (mailto:cortezzz1987@gmail.com)
     * @version 1.0
     * Описывает боевую единицу в игре
     */
    private boolean dodge;

    public Thief(String name) {
        super(name);
    }

    private void setDodge(boolean is) {
        dodge = is;
    }

    public boolean isDodge() {
        return dodge;
    }

    public void turn(int target, int damage) {
        if (!blocking(target) && !generateDodge()) {
            drainHealth(damage);
        }

        generateDamage(4, 10);
    }

    public boolean generateDodge() {
        if (numberGenerator(1, 4) == 1) {
            setDodge(true);
            return true;
        } else {
            setDodge(false);
            return false;
        }
    }
}
