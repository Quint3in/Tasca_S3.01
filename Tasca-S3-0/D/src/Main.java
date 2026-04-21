public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Marco");
        ServicePerson servicePerson = new ServicePerson(new MySql());

        servicePerson.savePerson(person1);
    }
}
