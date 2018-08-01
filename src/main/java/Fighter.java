/**
 * @author cortezzz (mailto:cortezzz1987@gmail.com)
 * @version 1.0
 * Описывает боевую единицу в игре
 */
public class Fighter {
    /*
    name - имя данного персонажа
    nameOfEnemy - имя противника
    ifNpc - в качестве параметра значение 1 или 2 (1 - ИИ, 2 - живой игрок)
    specialization - класс бойца. значение от 1 до 4 (1 - Thief, 2 - Asassin, 3 - Warrior, 4 - Paladin)
    block - позиция текущей блокировки аттаки от 1 до 3 (1 - голова, 2 - торс, 3 - ноги)
    Примечание: У класса Paladin блокировка торса идет по умолчанию всегда. Это исключение реализовано в методе combat.
     */
    final private String name;
    final private boolean ifNpc;
    final private int specialization;
    private int currentHealth = 100;
    private int block = 1;
    private int target;
    private int currentDamage;
    private boolean breakUp = false;
    private boolean dodge = false;
    private boolean crit = false;

    public Fighter(String name, boolean ifNpc, int specialization) {
        this.name = name;
        this.ifNpc = ifNpc;
        this.specialization = specialization;
    }

    public String getName() {
        return this.name;
    }

    public int getSpecialization() {
        return specialization;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getBlock() {
        return block;
    }

    public int getTarget() {
        return target;
    }

    public int getCurrentDamage() {
        return currentDamage;
    }

    public boolean isCrit() {
        return crit;
    }

    public boolean isBreakUp() {
        return breakUp;
    }

    public boolean isDodge() {
        return dodge;
    }

    public void combat(int enemyDamage, int target, boolean crit, boolean breakUp, Fighter enemy) {

        //Здесь описан алгоритм блокировки удара. Если класс данного персонажа Paladin (блокипуються точки 1 или 3)
        //В остальных случаях блокируется одна из 3х точек
        double blockMod = Math.random();
        if (this.specialization == 4 && blockMod < 0.5) {
            this.block = 1;
        } else if (this.specialization == 4 && blockMod >= 0.5) {
            this.block = 3;
        } else if (blockMod < 0.33) {
            this.block = 1;
        } else if (blockMod >= 0.33 && blockMod < 0.66) {
            this.block = 2;
        } else {
            this.block = 3;
        }

        //Здесь высчитываеться вероятность уклонения (шанс - 25%) если класс персонажа thief
        double dodgeMod = Math.random();
        if (this.specialization == 1 && dodgeMod < 0.25) {
            this.dodge = true;
            System.out.println("dodgeMod is: " + dodgeMod);
        }

        //Проверяются условия блокировки удара, уклонения, либо срабатывания умения breakUp класса warrior
        //Если атака противника все же прошла, от текущего здоровья персонажа отнимаеться урон противника
        if ((target != this.block && !this.dodge) || (target == this.block && breakUp && !this.dodge)) {
            this.currentHealth -= enemyDamage;
        }

        //расчет повреждений персонажа в текущем раунде
        double damageMod = Math.random();
        if (damageMod < 0.2) {
            this.currentDamage = 6;
        } else if (damageMod >= 0.2 && damageMod < 0.4) {
            this.currentDamage = 7;
        } else if (damageMod >= 0.4 && damageMod < 0.6) {
            this.currentDamage = 8;
        } else if (damageMod >= 0.6 && damageMod < 0.8) {
            this.currentDamage = 9;
        } else {
            this.currentDamage = 10;
        }

        //Расчет вероятности критического удара (шанс - 25%). Если класс персонажа Asassin и крит прошел - урон увеличиваеться вдвое.
        if (this.specialization == 2 && 0.25 < Math.random()) {
            this.currentDamage *= 2;
            this.crit = true;
        }

        //Инициализация позиции нападения
        double targetMod = Math.random();
        if (enemy.getSpecialization() == 4 && targetMod < 0.5) {
            this.target = 1;
        } else if (enemy.getSpecialization() == 4 && targetMod >= 0.5) {
            this.target = 3;
        } else if (targetMod < 0.33) {
            this.target = 1;
        } else if (targetMod >= 0.33 && targetMod < 0.66) {
            this.target = 2;
        } else {
            this.target = 3;
        }

        // Если класс персонажа warrior - срабатывает умение breakUp
        if (this.specialization == 3) {
            this.breakUp = true;
        }

    }

}