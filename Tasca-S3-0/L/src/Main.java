public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Ghost ghost = new Ghost();
        Character character = new Character();

        warrior.attack();
        warrior.takeDamage(3);
        ghost.attack();
        ghost.takeDamage(3);
        character.attack();
        character.takeDamage(3);
    }
}
