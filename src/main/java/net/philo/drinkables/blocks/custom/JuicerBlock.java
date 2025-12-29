package net.philo.drinkables.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.philo.drinkables.item.ModItems;


import java.util.Map;

public class JuicerBlock extends Block {
    private static final Map<DeferredHolder<Item, Item>, DeferredHolder<Item, Item>> JUICE_ITEMS = Map.of(
            //Items.APPLE, ModItems.APPLE_JUICE,
            ModItems.ORANGE, ModItems.ORANGE_JUICE,
            ModItems.LEMON, ModItems.LEMON_JUICE
    );

    public JuicerBlock(Properties properties) {
        super(properties);
    }

    private void ReturnItem(Level level, ItemEntity itemEntity, BlockPos pos, Item item, Item returnItem) {
        Item inputItem = itemEntity.getItem().getItem();
        if (inputItem == item) {
            itemEntity.setItem(new ItemStack(
                    returnItem,
                    itemEntity.getItem().getCount()
            ));

            level.playSound(null, pos,
                    SoundEvents.GRINDSTONE_USE,
                    SoundSource.BLOCKS,
                    1f, 1f
            );
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            Item inputItem = itemEntity.getItem().getItem();

            if (level.isClientSide) return;

            for (var entry : JUICE_ITEMS.entrySet()) {
                if (entry.getKey().get() == inputItem) {

                    itemEntity.setItem(new ItemStack(
                            entry.getValue().get(),
                            itemEntity.getItem().getCount()
                    ));

                    level.playSound(
                            null,
                            pos,
                            SoundEvents.GRINDSTONE_USE,
                            SoundSource.BLOCKS,
                            1f,
                            1f
                    );

                    return; // prevent double-processing
                }
            }

            ReturnItem(level, itemEntity, pos, Items.APPLE, ModItems.APPLE_JUICE.get());
            ReturnItem(level, itemEntity, pos, Items.MELON_SLICE, ModItems.MELON_JUICE.get());

            super.stepOn(level, pos, state, entity);
        }
    }
}