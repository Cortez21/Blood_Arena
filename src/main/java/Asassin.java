public class Asassin extends Fighter {
    /**
     * @author cortezzz (mailto:cortezzz1987@gmail.com)
     * @version 1.0
     * Описывает боевую единицу в игре класса Asassin
     */
    private boolean crit;

    public Asassin(String name) {
        super(name);
    }

    private void setCrit(boolean set) {
        crit = set;
    }

    public boolean isCrit() {
        return crit;
    }

    public void generateDamage(int min, int max) {
        if (numberGenerator(1, 4) == 1) {
            setDamage(numberGenerator(min, max) * 2);
            setCrit(true);
        } else {
            setDamage(numberGenerator(min, max));
            setCrit(false);
        }
    }
}
