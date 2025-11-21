package net.ta.ttm.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;
import net.ta.ttm.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TTM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TTM.MOD_ID, "ttm_items"), FabricItemGroup.builder()
                            .icon(() -> new ItemStack(ModItems.CRUDE_SILICON))
                            .displayName(Text.translatable("itemgroup.ttm.ttm_items"))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.CRUDE_SILICON);
                                entries.add(ModItems.CAULIFLOWER);
                            }).build());

    public static final ItemGroup TTM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TTM.MOD_ID, "ttm_blocks"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.QUARTZ_ORE))
                    .displayName(Text.translatable("itemgroup.ttm.ttm_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.QUARTZ_ORE);
                        entries.add(ModBlocks.SILICON_BLOCK);
                        entries.add(ModBlocks.METAL_LAMP);
                    }).build());

    public static void registerItemGroups() {
        TTM.LOGGER.info("Registering Item Groups for" + TTM.MOD_ID);
    }
}
