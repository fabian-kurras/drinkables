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

import java.util.List;

public class MixerBlock extends Block {
    public MixerBlock(Properties properties) {
        super(properties);
    }

    private void ReturnItemMixed(Level level, BlockPos pos, ItemEntity a, ItemEntity b, Item input1, Item input2, Item result){
        Item itemA = a.getItem().getItem();
        Item itemB = b.getItem().getItem();

        if((itemA == input1 && itemB == input2) || (itemA == input2 && itemB == input1)){

            a.getItem().shrink(1);
            b.getItem().shrink(1);

            level.addFreshEntity(new ItemEntity(level,
                    pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                    new ItemStack(result)));

            level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1f, 1f);
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(level.isClientSide){return;}
        if (!(entity instanceof ItemEntity itemA)) return;

        List<ItemEntity> items = level.getEntitiesOfClass(
                ItemEntity.class,
                itemA.getBoundingBox().inflate(0.1)
        );

        for (ItemEntity itemB : items) {
            if (itemB == itemA) continue;

            //ReturnItemMixed is the "crafting" recipe definition for the mixer (first 4 args never change)
            ReturnItemMixed(level, pos, itemA, itemB, Items.SWEET_BERRIES, Items.SUGAR, ModItems.CAFFEINE.get());
            ReturnItemMixed(level, pos, itemA, itemB, Items.SUGAR, ModItems.ORANGE_JUICE.get(),ModItems.ORANGE_LEMONADE.get());

        }

        super.stepOn(level, pos, state, entity);
    }
}
