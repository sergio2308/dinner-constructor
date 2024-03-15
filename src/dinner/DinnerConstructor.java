package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

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

    public HashMap<String, ArrayList<String>> createCombo(int numberOfCombos, ArrayList<String> dishesTypes) {
        Random random = new Random();
        HashMap<String, ArrayList<String>> combos = new HashMap<>();
        ArrayList<String> dishes = new ArrayList<>();
        for (String dish : dishesTypes) {
            ArrayList<String> item = dishesByTypes.get(dish);
            String d = item.get(random.nextInt() * item.size());
            dishes.add(d);
            combos.put();
        }
        return combos;
    }
}
