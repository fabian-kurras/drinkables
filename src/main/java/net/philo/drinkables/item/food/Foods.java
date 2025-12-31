package net.philo.drinkables.item.food;

import net.minecraft.world.food.FoodProperties;

public class Foods {
    public static final FoodProperties DEFAULT_DRINK;

    static {
        DEFAULT_DRINK = (new FoodProperties.Builder().nutrition(0).saturationModifier(0.0F).alwaysEdible().build());
    }

}
