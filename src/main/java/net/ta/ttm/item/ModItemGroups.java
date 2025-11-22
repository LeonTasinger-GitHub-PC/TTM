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
                            .icon(() -> new ItemStack(ModItems.SILUMIN))
                            .displayName(Text.translatable("itemgroup.ttm.ttm_items"))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.CRUDE_SILICON);
                                entries.add(ModItems.CAULIFLOWER);
                                entries.add(ModItems.GRAPHITE);
                                entries.add(ModItems.GRAPHITE_ROD);
                                entries.add(ModItems.STEEL);
                                entries.add(ModItems.BAUXITE);
                                entries.add(ModItems.ALUMINIUM);
                                entries.add(ModItems.SILUMIN);

                                //Tools
                                entries.add(ModItems.ALUMINIUM_SWORD);
                                entries.add(ModItems.ALUMINIUM_PICKAXE);
                                entries.add(ModItems.ALUMINIUM_SHOVEL);
                                entries.add(ModItems.ALUMINIUM_AXE);
                                entries.add(ModItems.ALUMINIUM_HOE);

                                entries.add(ModItems.SILUMIN_SWORD);
                                entries.add(ModItems.SILUMIN_PICKAXE);
                                entries.add(ModItems.SILUMIN_SHOVEL);
                                entries.add(ModItems.SILUMIN_AXE);
                                entries.add(ModItems.SILUMIN_HOE);

                                entries.add(ModItems.STEEL_SWORD);
                                entries.add(ModItems.STEEL_PICKAXE);
                                entries.add(ModItems.STEEL_SHOVEL);
                                entries.add(ModItems.STEEL_AXE);
                                entries.add(ModItems.STEEL_HOE);
                            }).build());

    public static final ItemGroup TTM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TTM.MOD_ID, "ttm_blocks"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.SILUMIN_BLOCK))
                    .displayName(Text.translatable("itemgroup.ttm.ttm_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.QUARTZ_ORE);
                        entries.add(ModBlocks.BAUXITE_ORE);
                        entries.add(ModBlocks.SILUMIN_BLOCK);
                        entries.add(ModBlocks.ALUMINIUM_BLOCK);
                        entries.add(ModBlocks.SILICON_BLOCK);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.GRAPHITE_BLOCK);
                        entries.add(ModBlocks.METAL_LAMP);
                    }).build());

    public static void registerItemGroups() {
        TTM.LOGGER.info("Registering Item Groups for" + TTM.MOD_ID);
    }
}
