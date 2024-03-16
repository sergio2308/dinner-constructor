package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();
    HashMap<String, ArrayList<String>> dishesByTypes = new HashMap<>();
    ArrayList<String> dishes;

    public void addDish(String dishType, String dishName) {
        if (dishesByTypes.containsKey(dishType)) {
            dishesByTypes.get(dishType).add(dishName);
        } else {
            dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByTypes.put(dishType, dishes);
        }
    }

    public void createCombo(int numberOfCombos, ArrayList<String> dishesTypes) {
        ArrayList<String> combos;
        ArrayList<String> dishesForCombo;

        for (int i = 0; i < numberOfCombos; i++) {
            combos = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String type : dishesTypes) {
                dishesForCombo = dishesByTypes.get(type);
                String dish = dishesForCombo.get(random.nextInt(dishesForCombo.size()));
                combos.add(dish);
            }
            System.out.println(combos);
        }
    }
}
