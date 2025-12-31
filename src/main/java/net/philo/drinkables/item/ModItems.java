package net.philo.drinkables.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.food.FoodProperties;
import net.philo.drinkables.DrinkablesMod;
import net.philo.drinkables.item.custom.DrinkableItem;
import net.philo.drinkables.item.food.Foods;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrinkablesMod.MODID);

    public static final DeferredItem<Item> MONSTER_ENERGY = ITEMS.register(
            "monster_energy",
            () -> new DrinkableItem(new Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationModifier(0.0F)
                            .alwaysEdible()
                            // Strength II für 30 Sekunden
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.DAMAGE_BOOST,
                                    20 * 30,
                                    1
                            ), 1.0F)
                            .build()
                    )
            )
    );


    public static final DeferredItem<Item> RED_BULL = ITEMS.register("red_bull",
            () -> new DrinkableItem(new Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationModifier(0.0F)
                            .alwaysEdible()
                            // Speed III für 30 Sekunden
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SPEED,
                                    20 * 30,
                                    2
                            ), 1.0F)
                            .build()
                    )
            )
    );

   /* public static final DeferredItem<Item> COFFEINE = ITEMS.register("coffeine",
            () -> new Item(new Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationModifier(0.0F)
                            .alwaysEdible()
                            // Speed VI for 30 Seconds && Weakness
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SPEED,
                                    20 * 30,
                                    5
                            ), 1.0F)
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.HARM,
                                    2,
                                    1
                            ), 1.0F)
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.HUNGER,
                                    20 * 30,
                                    2
                            ), 1.0F)


                            .build()
                    )
            )
    );
*/

    public static final DeferredItem<Item> COFFEINE = ITEMS.register("coffeine", () -> new Item(new Properties()));
    public static final DeferredItem<Item> ASPARTAM = ITEMS.register("aspartam", () -> new Item(new Properties()));
    public static final DeferredItem<Item> VITAMIN_POWDER = ITEMS.register("vitamin_powder", () -> new Item(new Properties()));
    public static final DeferredItem<Item> STEVIA_LEAF = ITEMS.register("stevia_leaf", () -> new Item(new Properties()));
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Properties()));
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Properties()));
    public static final DeferredItem<Item> MINT_LEAF = ITEMS.register("mint_leaf", () -> new Item(new Properties()));
    public static final DeferredItem<Item> CHAMOMILE = ITEMS.register("chamomile", () -> new Item(new Properties()));
    public static final DeferredItem<Item> TEA_LEAF = ITEMS.register("tea_leaf", () -> new Item(new Properties()));
    public static final DeferredItem<Item> CINNAMON = ITEMS.register("cinnamon", () -> new Item(new Properties()));
    public static final DeferredItem<Item> Z_FOOD = ITEMS.register("z_food", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> ORANGE_JUICE = ITEMS.register("orange_juice", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice", () ->new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> LEMON_JUICE = ITEMS.register("lemon_juice", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> MELON_JUICE = ITEMS.register("melon_juice", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> CARROT_JUICE = ITEMS.register("carrot_juice", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));;
    public static final DeferredItem<Item> BERRY_JUICE = ITEMS.register("berry_juice", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> WATER = ITEMS.register("water", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> SPARKLING_WATER = ITEMS.register("sparkling_water", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> COLA = ITEMS.register("cola", () -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> LIMES_LEMONADE = ITEMS.register("limes_lemonade",() -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> ORANGE_LEMONADE = ITEMS.register("orange_lemonade",() -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> HOT_CHOCOLATE = ITEMS.register("hot_chocolate",() -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> HOT_COFFEE = ITEMS.register("hot_coffee",() -> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> GLOWBERRIE_JUICE = ITEMS.register("glowberrie_juice",()-> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> LIME = ITEMS.register("lime",()-> new Item(new Properties()));
    public static final DeferredItem<Item> GRAPE = ITEMS.register("grape",()-> new Item(new Properties()));
    public static final DeferredItem<Item> GRAPE_JUICE = ITEMS.register("grape_juice",()-> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));
    public static final DeferredItem<Item> LIME_JUICE = ITEMS.register("lime_juice",()-> new DrinkableItem( new Properties().food(Foods.DEFAULT_DRINK)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
