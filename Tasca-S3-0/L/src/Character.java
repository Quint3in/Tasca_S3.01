public class Character {

    private PhysicalDamage physicalDamage;

    public Character(PhysicalDamage physicalDamage) {
        this.physicalDamage = physicalDamage;
    }
    public Character() {
        this.physicalDamage = new NotImmuneToPhysicalDamage();
    }

    public void attack() {
        System.out.println("The character attacks with a weapon.");
    }

    public void takeDamage(int points) {
        physicalDamage.takeDamage(points);
    }
}
