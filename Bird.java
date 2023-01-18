public abstract class Bird extends Animal {

    protected double flyHeight;

    public void fly() {
        System.out.printf("Я лечу на %.1f метрах.\n", flyHeight);
    }

    protected Bird(double height, double weight, String eyeColor,
                   double flyHeight) {
        super(height, weight, eyeColor);
        this.flyHeight = flyHeight;
    }

    @Override
    public String toString() {
        return String.format("%s, Высота полёта: %.1f м", super.toString(), flyHeight);
    }
}
