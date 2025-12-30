package net.philo.drinkables.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.philo.drinkables.DrinkablesMod;
import net.philo.drinkables.blocks.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DrinkablesMod.MODID);

    public static final Supplier<CreativeModeTab> DRINKABLES_TAB = CREATIVE_MODE_TAB.register("drinkables_tab", () -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.RED_BULL.get()))
            .title(Component.translatable("creativetab.drinkablesmod.drinkables"))
            .displayItems(((itemDisplayParameters, output) -> {
                output.accept(ModItems.MONSTER_ENERGY);
                output.accept(ModItems.RED_BULL);
                output.accept(ModItems.COFFEINE);
                output.accept(ModItems.ASPARTAM);
                output.accept(ModItems.ORANGE);
                output.accept(ModItems.LEMON);
                output.accept(ModItems.TEA_LEAF);
                output.accept(ModItems.CINNAMON);
                output.accept(ModItems.Z_FOOD);
                output.accept(ModItems.ORANGE_JUICE);
                output.accept(ModItems.APPLE_JUICE);
                output.accept(ModItems.LEMON_JUICE);
                output.accept(ModBlocks.JUICER);
                output.accept(ModBlocks.MIXER);
                output.accept(ModItems.MELON_JUICE);
                output.accept(ModItems.CARROT_JUICE);
                output.accept(ModItems.BERRY_JUICE);
                output.accept(ModItems.WATER);
                output.accept(ModItems.SPARKLING_WATER);
                output.accept(ModItems.COLA);
                output.accept(ModItems.LIMES_LEMONADE);
                output.accept(ModItems.ORANGE_LEMONADE);
                output.accept(ModItems.HOT_CHOCOLATE);
                output.accept(ModItems.HOT_COFFEE);

            }))
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
