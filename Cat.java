import java.time.LocalDate;

public class Cat extends Pet{

    private boolean hasFur;

    public boolean hasFur() {
        return hasFur;
    }

    public Cat(double height, double weight, String eyeColor,
               String name, String breed, boolean fullyVaccinated, String furColor, LocalDate birthDate,
               boolean hasFur) {
        super(height, weight, eyeColor, name, breed, fullyVaccinated, furColor, birthDate);
        this.hasFur = hasFur;
    }

    @Override
    public String toString() {
        return String.format("Кот(Кошка){%s, Шерсть: %s}", super.toString(), hasFur ? "Есть" : "Нет");
    }

    @Override
    public void voice() {
        System.out.printf("Меня зовут %s и я говорю Мяу.\n", name);
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public void showAffection() {
        System.out.printf("Кот(Кошка) по кличке %s проявляет ласку (очень мило).\n", name);
    }
}
