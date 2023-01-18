import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class WildAnimal extends Animal {

    protected String inhabitedRegion;
    protected LocalDate discoveryDate;

    public String getInhabitedRegion() {
        return inhabitedRegion;
    }

    public LocalDate getDiscoveryDate() {
        return discoveryDate;
    }

    public WildAnimal(double height, double weight, String eyeColor,
                      String inhabitedRegion, LocalDate discoveryDate) {
        super(height, weight, eyeColor);
        this.inhabitedRegion = inhabitedRegion;
        this.discoveryDate = discoveryDate;
    }

    @Override
    public String toString() {
        return String.format("%s, Место обитания: %s, Дата нахождения: %s", super.toString(), inhabitedRegion,
                discoveryDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
    }
}
