public class Main {
    public static void main(String[] args) {
        InstrumentPlayer player = new InstrumentPlayer();

        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        Drum drum = new Drum();

        player.play(drum);
        player.play(guitar);
        player.play(piano);
    }
}
