public class Chicken extends Bird {

    public Chicken(double height, double weight, String eyeColor, double flyHeight) {
        super(height, weight, eyeColor, flyHeight);
    }

    @Override
    public void voice() {
        System.out.println("Я курица и я говорю Куд-кудах.");
    }

    @Override
    public String toString() {
        return String.format("Курица{%s}.", super.toString());
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
