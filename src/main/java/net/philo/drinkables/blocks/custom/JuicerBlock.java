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
import net.philo.drinkables.item.ModItems;


public class JuicerBlock extends Block {

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
        if (level.isClientSide){return;}
        if (entity instanceof ItemEntity itemEntity) {

            ReturnItem(level, itemEntity, pos, Items.APPLE, ModItems.APPLE_JUICE.get());
            ReturnItem(level, itemEntity, pos, Items.MELON_SLICE, ModItems.MELON_JUICE.get());
            ReturnItem(level, itemEntity, pos, ModItems.LEMON.get(), ModItems.LEMON_JUICE.get());
            ReturnItem(level, itemEntity, pos,  ModItems.ORANGE.get(), ModItems.ORANGE_JUICE.get());
            ReturnItem(level, itemEntity, pos, Items.CARROT, ModItems.CARROT_JUICE.get());
            ReturnItem(level, itemEntity, pos, Items.SWEET_BERRIES, ModItems.BERRY_JUICE.get());

            super.stepOn(level, pos, state, entity);
        }
    }
}