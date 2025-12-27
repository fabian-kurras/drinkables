package net.philo.drinkables.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.philo.drinkables.DrinkablesMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DrinkablesMod.MODID);

    public static final DeferredItem<Item> MONSTER_ENERGY = ITEMS.register("monster_energy", () -> new Item( new Item.Properties()));

    public static final DeferredItem<Item> RED_BULL = ITEMS.register("red_bull", () -> new Item( new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
