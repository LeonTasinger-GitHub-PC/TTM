package net.ta.ttm.item;

import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ta.ttm.TTM;

import java.util.List;

public class ModItems {
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.ttm.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item CRUDE_SILICON = registerItem("crude_silicon", new Item(new Item.Settings()));
    public static final Item BAUXITE = registerItem("bauxite", new Item(new Item.Settings()));
    public static final Item ALUMINIUM = registerItem("aluminium", new Item(new Item.Settings()));
    public static final Item SILUMIN = registerItem("silumin", new Item(new Item.Settings()));
    public static final Item GRAPHITE = registerItem("graphite", new Item(new Item.Settings()));
    public static final Item GRAPHITE_ROD = registerItem("graphite_rod", new Item(new Item.Settings()));
    public static final Item STEEL = registerItem("steel", new Item(new Item.Settings()));

    public static final Item ALUMINIUM_SWORD = registerItem("aluminium_sword",
            new SwordItem(ModToolMaterials.ALUMINIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM, 3, -2.4f))));
    public static final Item ALUMINIUM_PICKAXE = registerItem("aluminium_pickaxe",
            new PickaxeItem(ModToolMaterials.ALUMINIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM, 1, -2.8f))));
    public static final Item ALUMINIUM_SHOVEL = registerItem("aluminium_shovel",
            new ShovelItem(ModToolMaterials.ALUMINIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM, 1.5f, -3.0f))));
    public static final Item ALUMINIUM_AXE = registerItem("aluminium_axe",
            new AxeItem(ModToolMaterials.ALUMINIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM, 6, -3.2f))));
    public static final Item ALUMINIUM_HOE = registerItem("aluminium_hoe",
            new HoeItem(ModToolMaterials.ALUMINIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ALUMINIUM, 0, -3f))));

    public static final Item SILUMIN_SWORD = registerItem("silumin_sword",
            new SwordItem(ModToolMaterials.SILUMIN, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SILUMIN, 3, -2.4f))));
    public static final Item SILUMIN_PICKAXE = registerItem("silumin_pickaxe",
            new PickaxeItem(ModToolMaterials.SILUMIN, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SILUMIN, 1, -2.8f))));
    public static final Item SILUMIN_SHOVEL = registerItem("silumin_shovel",
            new ShovelItem(ModToolMaterials.SILUMIN, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SILUMIN, 1.5f, -3.0f))));
    public static final Item SILUMIN_AXE = registerItem("silumin_axe",
            new AxeItem(ModToolMaterials.SILUMIN, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SILUMIN, 6, -3.2f))));
    public static final Item SILUMIN_HOE = registerItem("silumin_hoe",
            new HoeItem(ModToolMaterials.SILUMIN, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SILUMIN, 0, -3f))));

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -2.4f))));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 1, -2.8f))));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 1.5f, -3.0f))));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 6, -3.2f))));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STEEL, 0, -3f))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TTM.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TTM.LOGGER.info("Registering Mod Items for" + TTM.MOD_ID);
    }
}
