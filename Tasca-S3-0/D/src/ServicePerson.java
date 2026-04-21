public class ServicePerson {
    private DataBase bbdd;

    public ServicePerson(DataBase bbdd) {
        this.bbdd = bbdd;
    }

    public void savePerson(Person person) {
        bbdd.savePerson(person);
    }
}