public class TestMode {

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Galatar", true, 1);
        Fighter fighter2 = new Fighter("CortezZz", true, 4);
        int cycl = 100;

        int countOfDodge = 0;
        for (int i = 0; i < cycl; i++) {
            fighter1.combat(8, 3, false, false, fighter2);
            if (fighter1.isDodge()) {
                countOfDodge++;
            }
            System.out.println(fighter1.getName());
            System.out.println("Health: " + fighter1.getCurrentHealth() + "(8)");
            System.out.println("Block: " + fighter1.getBlock() + "(3)");
            System.out.println("Damage: " + fighter1.getCurrentDamage());
            System.out.println("Target: " + fighter1.getTarget());
            System.out.println("Dodge: " + fighter1.isDodge());
            System.out.println("Crit: " + fighter1.isCrit());
            System.out.println("BreakUp: " + fighter1.isBreakUp());
            System.out.println("Random is: " + Math.random());
            System.out.println("******************************************************");
        }
        System.out.println("Count dodge: " + countOfDodge + " of " + cycl);
    }
}
