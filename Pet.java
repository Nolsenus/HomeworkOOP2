import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pet extends Animal{

    protected String name;
    protected String breed;
    protected boolean isFullyVaccinated;
    protected String furColor;
    protected LocalDate birthDate;

    public abstract void showAffection();

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isFullyVaccinated() {
        return isFullyVaccinated;
    }

    public String getFurColor() {
        return furColor;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Pet(double height, double weight, String eyeColor,
               String name, String breed, boolean fullyVaccinated, String furColor, LocalDate birthDate) {
        super(height, weight, eyeColor);
        this.name = name;
        this.breed = breed;
        this.isFullyVaccinated = fullyVaccinated;
        this.furColor = furColor;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s, Кличка: %s, Порода: %s, %sакцинирован(а), Цвет шерсти: %s, Дата рождения: %s",
                super.toString(), name, breed, isFullyVaccinated ? "В" : "Не в", furColor,
                birthDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
    }
}
