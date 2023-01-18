public class Stork extends Bird {

    public Stork(double height, double weight, String eyeColor, double flyHeight) {
        super(height, weight, eyeColor, flyHeight);
    }

    @Override
    public void voice() {
        System.out.println("Я аист и говорю *Привет на аистином*.");
    }

    @Override
    public String toString() {
        return String.format("Аист{%s}", super.toString());
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
