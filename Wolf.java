import java.time.LocalDate;

public class Wolf extends WildAnimal {

    private Wolf alpha;

    public Wolf getAlpha() {
        return alpha;
    }

    public Wolf(double height, double weight, String eyeColor,
                String inhabitedRegion, LocalDate discoveryDate,
                Wolf alpha) {
        super(height, weight, eyeColor, inhabitedRegion, discoveryDate);
        this.alpha = alpha;
    }

    public Wolf(double height, double weight, String eyeColor,
                String inhabitedRegion, LocalDate discoveryDate) {
        this(height, weight, eyeColor, inhabitedRegion, discoveryDate, null);
        this.alpha = this;
    }

    @Override
    public void voice() {
        System.out.println("Я волк(волчица) и я говорю АУУУУУУУ.");
    }

    @Override
    public String toString() {
        return String.format("Волк(Волчица){%s, Вожак стаи: {Рост: %f, Вес: %f, Цвет глаз: %s, Дата нахождения: %s}}",
                super.toString(), alpha.height, alpha.weight, alpha.eyeColor, alpha.discoveryDate.toString());
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
