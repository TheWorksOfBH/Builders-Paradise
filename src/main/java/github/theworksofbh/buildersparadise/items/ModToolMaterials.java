package github.theworksofbh.buildersparadise.items;

import github.theworksofbh.buildersparadise.tags.ModBlockTags;
import github.theworksofbh.buildersparadise.tags.ModItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public record ModToolMaterials(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
    public static final ToolMaterial BRONZE = new ToolMaterial(ModBlockTags.INCORRECT_FOR_BRONZE_TOOL, 220, 5.5F, 2.5F, 12, ModItemTags.BRONZE_TOOL_MATERIALS);

    private Item.Properties applyCommonProperties(Item.Properties properties) {
        return properties.durability(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Properties applyToolProperties(Item.Properties properties, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed, float disableBlockingForSeconfs) {
        HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties).component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.deniesDrops(holdergetter.getOrThrow(this.incorrectBlocksForDrops)), Tool.Rule.minesAndDrops(holdergetter.getOrThrow(mineableBlocks), this.speed)), 1.0F, 1, true)).attributes(this.createToolAttributes(attackDamage, attackSpeed)).component(DataComponents.WEAPON, new Weapon(2, disableBlockingForSeconfs));
    }

    private ItemAttributeModifiers createToolAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public Item.Properties applySwordProperties(Item.Properties properties, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties).component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(HolderSet.direct(new Holder[]{Blocks.COBWEB.builtInRegistryHolder()}), 15.0F), Tool.Rule.overrideSpeed(holdergetter.getOrThrow(BlockTags.SWORD_INSTANTLY_MINES), Float.MAX_VALUE), Tool.Rule.overrideSpeed(holdergetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)), 1.0F, 2, false)).attributes(this.createSwordAttributes(attackDamage, attackSpeed)).component(DataComponents.WEAPON, new Weapon(1));
    }

    private ItemAttributeModifiers createSwordAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }
}
