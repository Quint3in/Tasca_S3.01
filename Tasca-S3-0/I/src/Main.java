public class Main {
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();
        AirConditioner airConditioner = new AirConditioner();

        washingMachine.turnOn();
        washingMachine.wash();
        washingMachine.turnOff();

        airConditioner.turnOn();
        airConditioner.cool();
        airConditioner.heat();
        airConditioner.turnOff();
    }
}
