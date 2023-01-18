import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static final List<String> wildAnimals = Arrays.asList("волк", "тигр");
    public static final List<String> pets = Arrays.asList("кот", "собака");
    public static final List<String> birds = Arrays.asList("курица", "аист");

    public static boolean isAnimal(String animalName) {
        return wildAnimals.contains(animalName) || pets.contains(animalName) || birds.contains(animalName);
    }

    public static double enterDouble(String prompt, Scanner in, boolean hasToBePositive) {
        while (true) {
            System.out.printf("Введите параметр %s: ", prompt.toLowerCase());
            if (!in.hasNextDouble()) {
                in.nextLine();
                System.out.printf("%s - %s число, Вы ввели не число.\n", prompt, hasToBePositive ? "положительное" : "");
                continue;
            }
            double result = in.nextDouble();
            if (hasToBePositive && result < 0) {
                in.nextLine();
                System.out.printf("%s - положительное число, Вы ввели не положительное.\n", prompt);
                continue;
            }
            in.nextLine();
            return result;
        }
    }

    public static LocalDate enterDate(String prompt, Scanner in) {
        String entry;
        while (true) {
            System.out.printf("Введите %s в формате (день-месяц-год, например %s):",
                    prompt, LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            entry = in.nextLine();
            String[] parts = entry.split("-");
            if (parts.length != 3) {
                System.out.println("Вы ввели что-то в неверном формате.");
                continue;
            }
            try {
                int[] nums = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
                if (nums[0] <= 0 || nums[1] <= 0 || nums[2] <= 0) {
                    System.out.println("Все три части должны быть положительными числами.");
                    continue;
                }
                if (nums[0] > 31 ||
                        (nums[0] == 31 && (nums[1] % 2 == 0 && nums[1] < 8 || nums[1] % 2 == 1 && nums[1] >= 8)) ||
                        (nums[0] == 30 && nums[1] == 2) ||
                        (nums[0] == 29 && nums[1] == 2 && nums[2] % 4 != 0)) {
                    System.out.println("Невозможное значение дня.");
                    continue;
                }
                if (nums[1] > 12) {
                    System.out.println("Невозможное значение месяца.");
                    continue;
                }
                return LocalDate.parse(entry, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (NumberFormatException e) {
                System.out.println("Все три части должны быть целыми числами.");
            }
        }
    }

    public static String enterAnyString(String prompt, Scanner in) {
        System.out.print(prompt);
        return in.nextLine();
    }

    public static Animal constructAnimal(String animalName, Scanner in) {
        double height = enterDouble("Рост животного в см", in, true);
        double weight = enterDouble("Вес животного в кг", in, true);
        String eyeColor = enterAnyString("Введите цвет глаз животного: ", in);
        if (wildAnimals.contains(animalName)) {
            String region = enterAnyString("Введите место обитания животного: ", in);
            LocalDate discovery = enterDate("дату нахождения животного", in);
            if (animalName.equals("волк")) {
                String response = enterAnyString("Этот волк является вожаком своей стаи?(да/что-либо кроме \"да\"):", in);
                if (response.equalsIgnoreCase("да")) {
                    return new Wolf(height, weight, eyeColor, region, discovery);
                } else {
                    System.out.println("Введите параметра вожака стаи.");
                    return new Wolf(height, weight, eyeColor, region, discovery,
                            (Wolf) constructAnimal("волк", in));
                }
            } else {
                return new Tiger(height, weight, eyeColor, region, discovery);
            }
        } else if (pets.contains(animalName)) {
            String name = enterAnyString("Введите кличку питомца: ", in);
            String breed = enterAnyString("Введите породу питомца: ", in);
            String isVaxxed = enterAnyString("Питомец вакцинирован?(да/что-либо кроме\"да\"): ", in);
            boolean isVaccinated = isVaxxed.equalsIgnoreCase("да");
            String furColor = enterAnyString("Введите цвет шерсти питомца: ", in);
            LocalDate birthDate = enterDate("дату рождения питомца", in);
            if (animalName.equals("кот")) {
                String response = enterAnyString("У кошки есть шерсть?(да/что-либо кроме\"да\"): ", in);
                boolean hasFur = response.equalsIgnoreCase("да");
                return new Cat(height, weight, eyeColor,
                        name, breed, isVaccinated, furColor, birthDate, hasFur);
            } else {
                String response = enterAnyString("Собака выдрессирована?(да/что-либо кроме\"да\"): ", in);
                boolean isTrained = response.equalsIgnoreCase("да");
                return new Dog(height, weight, eyeColor,
                        name, breed, isVaccinated, furColor, birthDate, isTrained);
            }
        } else {
            double flyHeight = enterDouble("Высота полёта", in, true);
            if (animalName.equals("аист")) {
                return new Stork(height, weight, eyeColor, flyHeight);
            } else {
                return new Chicken(height, weight, eyeColor, flyHeight);
            }
        }
    }

    public static boolean checkIndex(int index, int maxIndex) {
        if (index >= 0 && index <= maxIndex) {
            return true;
        }
        System.out.printf("Вы ввели некорректный индекс. %s.\n", maxIndex == -1 ? "Зоопарк пуст" :
                String.format("Текущий максимальный индекс: %d", maxIndex));
        return false;
    }

    public static int indexFromEntry(String entry, int maxIndex) {
        try {
            int result = Integer.parseInt(entry);
            return checkIndex(result, maxIndex) ? result : -1;
        } catch (NumberFormatException e) {
            System.out.println("Индекс должен быть целым числом или \"все\".");
            return -1;
        }
    }

    public static void applyFunc(String entry, int maxIndex, Consumer<Integer> indexFunc, Runnable allFunc) {
        if (entry.equals("все")) {
            allFunc.run();
        } else {
            int index = indexFromEntry(entry, maxIndex);
            if (index != -1) {
                indexFunc.accept(index);
                System.out.println("Готово.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Вы хотите работать с пустым зоопарком или зоопарком по умолчанию " +
                "(По одному представителю каждого животного)?");
        System.out.println("Чтобы выбрать пустой зоопарк введите \"пустой\", " +
                "при другой введённой строке будет выбран зоопарк по умолчанию: ");
        Scanner in = new Scanner(System.in);
        String reply = in.nextLine();
        Zoo zoo;
        if (reply.equalsIgnoreCase("пустой")) {
            zoo = new Zoo();
            System.out.println("Вы выбрали пустой зоопарк.");
        } else {
            zoo = Zoo.defaultZoo();
            System.out.println("Вы выбрали зоопарк по умолчанию.");
        }
        String commands = "Список команд для работы с зоопарком:\n" +
                "помощь - вывод списка команд для работы с зоопарком;\n" +
                "выход - завершение работы программы;\n" +
                "добавить <класс животного(кот/собака/тигр/волк/курица/аист)> - " +
                "начало процесса добавления нового животного выбранного класса;\n" +
                "удалить <индекс или \"все\"> - удаление из зоопарка животного под указанным индексом;\n" +
                "инфо <индекс или \"все\"> - вывод информации о животном под указанным индексом;\n" +
                "голос <индекс или \"все\"> - вывод голосовой команды животного под указанным индексом;\n" +
                "летать <индекс или \"все\"> - попробовать заставить летать животное под указанным индексом;\n" +
                "ласка <индекс или \"все\"> - попробовать заставить проявить ласку животное под указанным индексом;\n" +
                "трен <индекс или \"все\"> - попробовать выдрессировать животное под указанным индексом;\n" +
                "спец <индекс или \"все\"> - вызвать самое специализированное действие (если таковое имеется) " +
                "у животного под указанным индексом. ";
        System.out.println(commands);
        String entry;
        while (true) {
            int maxIndex = zoo.getAnimalList().size() - 1;
            System.out.println("Введите команду: ");
            entry = in.nextLine().toLowerCase();
            if (entry.equals("выход")) {
                break;
            }
            if (entry.equals("помощь")) {
                System.out.println(commands);
            } else {
                String param = entry.substring(entry.indexOf(' ') + 1);
                String command = entry.substring(0, entry.indexOf(" ") + 1);
                switch (command) {
                    case "добавить ": {
                        if (isAnimal(param)) {
                            zoo.addAnimal(constructAnimal(param, in));
                            System.out.println("Готово.");
                        } else {
                            System.out.printf("Неизвестное животное %s.\n", param);
                        }
                        break;
                    }
                    case "удалить ": {
                        applyFunc(param, maxIndex, zoo::removeAnimal, zoo::removeAll);
                        break;
                    }
                    case "инфо ": {
                        applyFunc(param, maxIndex, zoo::printInfo, zoo::printAllInfo);
                        break;
                    }
                    case "голос ": {
                        applyFunc(param, maxIndex, zoo::voice, zoo::voiceAll);
                        break;
                    }
                    case "летать " : {
                        applyFunc(param, maxIndex, zoo::fly, zoo::allFly);
                        break;
                    }
                    case "ласка " : {
                        applyFunc(param, maxIndex, zoo::showAffection, zoo::allShowAffection);
                        break;
                    }
                    case "трен " : {
                        applyFunc(param, maxIndex, zoo::train, zoo::allTrain);
                        break;
                    }
                    case "спец " : {
                        applyFunc(param, maxIndex, zoo::activateSpecial, zoo::allActivateSpecial);
                        break;
                    }
                    default: {
                        System.out.printf("Неизвестная команда %s.\n", command);
                    }
                }
            }
        }
    }
}
