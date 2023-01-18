public abstract class Animal {

    protected double height;
    protected double weight;
    protected String eyeColor;

    public abstract void voice();
    public abstract void printInfo();

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    protected Animal(double height, double weight, String eyeColor) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return String.format("Рост: %.1f см, Вес: %.3f кг, Цвет глаз: %s", height, weight, eyeColor);
    }
}
