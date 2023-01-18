import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Zoo {

    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public Zoo(List<Animal> animals) {
        animalList = new ArrayList<>();
        animalList.addAll(animals);
    }

    public Zoo(Animal ... animals) {
        this(Arrays.asList(animals));
    }

    public Zoo() {
        animalList = new ArrayList<>();
    }

    public static Zoo defaultZoo() {
        List<Animal> animals = new LinkedList<>();
        animals.add(new Cat(20, 10, "Голубой",
                "Василий", "Сиамский", true, "Серый", LocalDate.parse("2018-06-06"),
                true));
        animals.add(new Tiger(120, 200, "Зелёный",
                "Юго-восточная Азия", LocalDate.parse("2010-11-21")));
        animals.add(new Dog(20, 9, "Коричневый",
                "Анна", "Мопс", true, "Бежевый", LocalDate.parse("2020-01-12"),
                true));
        animals.add(new Wolf(80, 60, "Серый",
                "Сибирь", LocalDate.parse("2018-03-02")));
        animals.add(new Chicken(30, 7, "Коричневый",
                0.5));
        animals.add(new Stork(150, 20, "Коричневый",
                2500));
        return new Zoo(animals);
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    private boolean checkIndex(int index) {
        if (index >= 0 && index < animalList.size()) {
            return true;
        }
        System.out.printf("В зоопарке нет животного под номером %d (нумерация с нуля).\n", index);
        return false;
    }

    public void removeAnimal(int index) {
        if (checkIndex(index)) {
            animalList.remove(index);
        }
    }

    public void removeAll() {
        int size = animalList.size();
        for (int i = 0; i < size; i++) {
            removeAnimal(0);
        }
    }

    public void printInfo(int index) {
        if (checkIndex(index)) {
            animalList.get(index).printInfo();
        }
    }

    public void voice(int index) {
        if (checkIndex(index)) {
            animalList.get(index).voice();
        }
    }

    public void printAllInfo() {
        System.out.println("Список всех животных на данный момент в зоопарке:");
        for (Animal a : animalList) {
            a.printInfo();
        }
        System.out.println("Конец списка.");
    }

    public void voiceAll() {
        for (Animal a : animalList) {
            a.voice();
        }
    }

    public void fly(int index) {
        if (checkIndex(index)) {
            Animal animal = animalList.get(index);
            if (animal instanceof Bird) {
                ((Bird) animal).fly();
            } else {
                System.out.printf("%s не умеет летать.\n", animal.toString());
            }
        }
    }

    public void allFly() {
        for (int i = 0; i < animalList.size(); i++) {
            fly(i);
        }
    }

    public void showAffection(int index) {
        if (checkIndex(index)) {
            Animal animal = animalList.get(index);
            if (animal instanceof Pet) {
                ((Pet) animal).showAffection();
            } else {
                System.out.printf("%s не умеет проявоять ласку.\n", animal.toString());
            }
        }
    }

    public void allShowAffection() {
        for (int i = 0; i < animalList.size(); i++) {
            showAffection(i);
        }
    }

    public void train(int index) {
        if (checkIndex(index)) {
            Animal animal = animalList.get(index);
            if (animal instanceof Dog) {
                ((Dog) animal).train();
            } else {
                System.out.printf("%s не может быть выдрессирован(а).\n", animal.toString());
            }
        }
    }

    public void allTrain() {
        for (int i = 0; i < animalList.size(); i++) {
            train(i);
        }
    }

    public void activateSpecial(int index) {
        if (checkIndex(index)) {
            Animal animal = animalList.get(index);
            if (animal instanceof Bird) {
                ((Bird) animal).fly();
            } else if (animal instanceof Dog) {
                ((Dog) animal).train();
            } else if (animal instanceof Pet) {
                ((Pet) animal).showAffection();
            } else {
                System.out.printf("%s не может летать, проявлять ласку или быть выдрессирован(а).\n", animal.toString());
            }
        }
    }

    public void allActivateSpecial() {
        for (int i = 0; i < animalList.size(); i++) {
            activateSpecial(i);
        }
    }
}
