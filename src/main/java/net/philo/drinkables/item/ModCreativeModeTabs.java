package net.philo.drinkables.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.philo.drinkables.DrinkablesMod;

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
            }))
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
