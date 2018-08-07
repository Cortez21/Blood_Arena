public class Warrior extends Fighter {
    /**
     * @author cortezzz (mailto:cortezzz1987@gmail.com)
     * @version 1.0
     * Описывает боевую единицу класса Warrior
     */
    public Warrior(String name) {
        super(name);
    }


    public void turn(int target, int damage, Fighter enemy) {
        super.turn(target, damage, enemy);
        generateBrakeUp();
    }

    private void generateBrakeUp() {
        if (numberGenerator(1, 4) == 1) {
            setBreakUp(true);
        } else {
            setBreakUp(false);
        }
    }
}
