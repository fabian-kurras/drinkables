package net.philo.drinkables.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.philo.drinkables.DrinkablesMod;
import net.minecraft.world.item.UseAnim;
import net.minecraft.sounds.SoundEvents;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrinkablesMod.MODID);

    public static final DeferredItem<Item> MONSTER_ENERGY = ITEMS.register(
            "monster_energy",
            () -> new Item(new Properties()
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
            () -> new Item(new Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationModifier(0.0F)
                            .alwaysEdible()
                            // Strength II für 30 Sekunden
                            .effect(() -> new MobEffectInstance(
                                    MobEffects.MOVEMENT_SPEED,
                                    20 * 30,
                                    2
                            ), 1.0F)
                            .build()
                    )
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
