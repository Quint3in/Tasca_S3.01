public class ImmuneToPhysicalDamage implements PhysicalDamage {
    @Override
    public void takeDamage(int points) {
        System.out.println("Cannot take physical damage!");
    }
}
