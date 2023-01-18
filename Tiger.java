import java.time.LocalDate;

public class Tiger extends WildAnimal{

    public Tiger(double height, double weight, String eyeColor,
                 String inhabitedRegion, LocalDate discoveryDate) {
        super(height, weight, eyeColor, inhabitedRegion, discoveryDate);
    }

    @Override
    public void voice() {
        System.out.println("Я тигр(ица) и я говорю РРРРР.");
    }

    @Override
    public String toString() {
        return String.format("Тигр(ица){%s}", super.toString());
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
