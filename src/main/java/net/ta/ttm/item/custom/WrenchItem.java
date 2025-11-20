package net.ta.ttm.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.ta.ttm.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class WrenchItem extends Item {
    private static final Map<Block, Block> WRENCH_MAP =
            Map.of(
                ModBlocks.OBSIDIANITE_BLOCK, Blocks.AIR,
                ModBlocks.MAGIC_BLOCK, Blocks.AIR
            );

    public WrenchItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        PlayerEntity player = context.getPlayer();

        if(WRENCH_MAP.containsKey(clickedBlock)){
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(), WRENCH_MAP.get(clickedBlock).getDefaultState());
                ItemStack stack = new ItemStack(clickedBlock.asItem());
                assert player != null;
                boolean inserted = player.getInventory().insertStack(stack);
                if(!inserted){
                    ItemEntity drop = new ItemEntity(world, player.getPos().x, player.getPos().y, player.getPos().z, stack);
                    world.spawnEntity(drop);
                }

                world.playSound(
                        null,
                        context.getBlockPos(),
                        SoundEvents.BLOCK_STONE_BREAK,
                        SoundCategory.BLOCKS
                );
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.ttm.wrench.shift"));
        }else{
            tooltip.add(Text.translatable("tooltip.ttm.wrench.no_shift"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
