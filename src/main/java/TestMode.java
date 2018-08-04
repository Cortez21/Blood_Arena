
public class TestMode {

    public static void main(String[] args) {

            Thief thief = new Thief("Corby");
            int valOfDodge = 0;

            for (int i = 0; i <1000; i++) {
                int damage = thief.numberGenerator(4, 6);
                int target = thief.numberGenerator(1, 3);
                thief.setBlock(thief.numberGenerator(1,3));
                thief.turn(target, damage);
                if (thief.isDodge()) {
                    valOfDodge++;
                }
                System.out.println("Enemy damage is: " + damage);
                System.out.println("Health is: "+ thief.getHealth());
                System.out.println("Block is: " + thief.getBlock() + "(target is: " + target + ")");
                System.out.println("Dodge is: " + thief.isDodge());
                System.out.println("Thef's damage is: " + thief.getDamage());
                System.out.println("*******************************************");
            }
        System.out.println("Values of dodge is: " + valOfDodge);
        System.out.println(thief.getClass());

    }



}
