package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Работа программы завершена.");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addDish(dishType, dishName);
        System.out.println("Доступные блюда:");
        System.out.println(dc.dishesByTypes);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        if (dc.dishesByTypes.isEmpty()) {
            System.out.println("Невозможно составить комбо. Сначала наполните список блюд.");
            System.out.println();
            return;
        }
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        if (numberOfCombos <= 0) {
            System.out.println("Количество комбо должно быть больше 0.");
            return;
        }
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        ArrayList<String> dishesTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (!dc.dishesByTypes.containsKey(nextItem)) {
                System.out.println("Такой тип недоступен для заказа, введите существующий тип.");
            } else {
                dishesTypes.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }
        dc.createCombo(numberOfCombos, dishesTypes);
    }
}
