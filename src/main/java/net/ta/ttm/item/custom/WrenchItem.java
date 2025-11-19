package net.ta.ttm.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.ta.ttm.block.ModBlocks;

import java.util.Map;

public class WrenchItem extends Item {
    private static final Map<Block, Block> WRENCH_MAP =
            Map.of(
                ModBlocks.OBSIDIANITE_BLOCK, Blocks.AIR
            );

    public WrenchItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        PlayerEntity player = context.getPlayer();

        if(WRENCH_MAP.containsKey(clickedBlock)){
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(), WRENCH_MAP.get(clickedBlock).getDefaultState());
                ItemStack stack = new ItemStack(clickedBlock.asItem());
                assert player != null;
                boolean inserted = player.getInventory().insertStack(stack);
            }
        }

        return ActionResult.SUCCESS;
    }
}
