import java.time.LocalDate;

public class Dog extends Pet{

    private boolean isTrained;

    public boolean isTrained() {
        return isTrained;
    }

    public Dog(double height, double weight, String eyeColor,
               String name, String breed, boolean fullyVaccinated, String furColor, LocalDate birthDate,
               boolean isTrained) {
        super(height, weight, eyeColor, name, breed, fullyVaccinated, furColor, birthDate);
        this.isTrained = isTrained;
    }

    public void train() {
        if (isTrained) {
            System.out.printf("%s уже дрессирован(а).\n", name);
        } else {
            isTrained = true;
            System.out.printf("%s теперь дрессирован(а).\n", name);
        }
    }

    @Override
    public void voice() {
        System.out.printf("Меня зовут %s и я говорю Гав.\n", name);
    }

    @Override
    public String toString() {
        return String.format("Собака{%s, %sрессирован(а)}", super.toString(), isTrained ? "Д" : "Не д");
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public void showAffection() {
        System.out.printf("Собака по кличке %s проявляет ласку :).\n", name);
    }
}
