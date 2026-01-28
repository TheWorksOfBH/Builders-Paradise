package github.theworksofbh.buildersparadise.datagen;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.block.ThermalCalciteBlock;
import com.mojang.datafixers.util.Pair;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.compat.bop.*;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.client.renderer.block.model.multipart.CombinedCondition;
import net.minecraft.client.renderer.block.model.multipart.Condition;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ModBlockModelGenerator extends BlockModelGenerators {


    public ModBlockModelGenerator(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Override
    public BlockFamilyProvider familyWithExistingFullBlock(Block fullBlock){
        TextureMapping mapping;
        if (fullBlock == Blocks.BASALT || fullBlock == Blocks.POLISHED_BASALT) {
            mapping = TexturedModel.COLUMN_WITH_WALL.get(fullBlock).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(fullBlock, "_side"));
        } else if (fullBlock == Blocks.SMOOTH_STONE) {
            mapping = TexturedModel.COLUMN.get(Blocks.SMOOTH_STONE_SLAB).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE_SLAB, "_side"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE, ""));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SMOOTH_STONE, ""));
        } else if (fullBlock == ModBlocks.SOUL_SANDSTONE.get()) {
            mapping = TexturedModel.CUBE_TOP_BOTTOM.get(ModBlocks.SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_bottom"));
        } else if (fullBlock == ModBlocks.CUT_SOUL_SANDSTONE.get()) {
            mapping = TexturedModel.COLUMN.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CUT_SOUL_SANDSTONE.get(), ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
        } else if (fullBlock == ModBlocks.SMOOTH_SOUL_SANDSTONE.get()) {
            mapping = TexturedModel.CUBE.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
        } else if (fullBlock == BOPBlocks.WHITE_SANDSTONE) {
            mapping = TexturedModel.CUBE_TOP_BOTTOM.get(ModBlocks.SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_bottom"));
        } else if (fullBlock == BOPBlocks.CUT_WHITE_SANDSTONE) {
            mapping = TexturedModel.COLUMN.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.CUT_WHITE_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_WHITE_SANDSTONE) {
            mapping = TexturedModel.CUBE.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.BLACK_SANDSTONE) {
            mapping = TexturedModel.CUBE_TOP_BOTTOM.get(ModBlocks.SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_bottom"));
        } else if (fullBlock == BOPBlocks.CUT_BLACK_SANDSTONE) {
            mapping = TexturedModel.COLUMN.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.CUT_BLACK_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_BLACK_SANDSTONE) {
            mapping = TexturedModel.CUBE.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.ORANGE_SANDSTONE) {
            mapping = TexturedModel.CUBE_TOP_BOTTOM.get(ModBlocks.SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_bottom"));
        } else if (fullBlock == BOPBlocks.CUT_ORANGE_SANDSTONE) {
            mapping = TexturedModel.COLUMN.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.CUT_ORANGE_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_ORANGE_SANDSTONE) {
            mapping = TexturedModel.CUBE.get(ModBlocks.CUT_SOUL_SANDSTONE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
        } else if (fullBlock == Blocks.SNOW_BLOCK) {
            mapping = TexturedModel.CUBE.get(Blocks.SNOW).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.SNOW, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.SNOW, ""));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.SNOW, ""));
        } else {
            TexturedModel texturedModel = BlockModelGenerators.TEXTURED_MODELS.getOrDefault(fullBlock, TexturedModel.CUBE.get(fullBlock));
            mapping = texturedModel.getMapping()
                    .put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock))
                    .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(fullBlock));
        }
        if (fullBlock == Blocks.BASALT || fullBlock == Blocks.POLISHED_BASALT || fullBlock == Blocks.QUARTZ_BLOCK) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock, "_side"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(fullBlock, "_side"));
        } else if (fullBlock == Blocks.SMOOTH_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
        } else if (fullBlock == Blocks.SMOOTH_RED_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"));
        } else if (fullBlock == ModBlocks.SMOOTH_SOUL_SANDSTONE.get()) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_WHITE_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_BLACK_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(BOPBlocks.BLACK_SANDSTONE, "_top"));
        } else if (fullBlock == BOPBlocks.SMOOTH_ORANGE_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(BOPBlocks.ORANGE_SANDSTONE, "_top"));
        } else if (fullBlock == Blocks.SMOOTH_QUARTZ) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom"));
        } else if (fullBlock == Blocks.SNOW_BLOCK) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.SNOW, ""));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(Blocks.SNOW, ""));
        } else {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock, ""));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(fullBlock, ""));
        }
        var provider = new BlockFamilyProvider(mapping);
        try {
            Field field = BlockFamilyProvider.class.getDeclaredField("fullBlock");
            field.setAccessible(true);
            field.set(provider, plainModel(ModelLocationUtils.getModelLocation(fullBlock)));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return provider;
    }

    public void createCustomChests() {
        this.createChest(ModBlocks.SPRUCE_CHEST.get(), Blocks.SPRUCE_PLANKS, ModChestSpecialRenderers.SPRUCE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BIRCH_CHEST.get(), Blocks.BIRCH_PLANKS, ModChestSpecialRenderers.BIRCH_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.JUNGLE_CHEST.get(), Blocks.JUNGLE_PLANKS, ModChestSpecialRenderers.JUNGLE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.ACACIA_CHEST.get(), Blocks.ACACIA_PLANKS, ModChestSpecialRenderers.ACACIA_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.DARK_OAK_CHEST.get(), Blocks.DARK_OAK_PLANKS, ModChestSpecialRenderers.DARK_OAK_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CRIMSON_CHEST.get(), Blocks.CRIMSON_PLANKS, ModChestSpecialRenderers.CRIMSON_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.WARPED_CHEST.get(), Blocks.WARPED_PLANKS, ModChestSpecialRenderers.WARPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.MANGROVE_CHEST.get(), Blocks.MANGROVE_PLANKS, ModChestSpecialRenderers.MANGROVE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CHERRY_CHEST.get(), Blocks.CHERRY_PLANKS, ModChestSpecialRenderers.CHERRY_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BAMBOO_CHEST.get(), Blocks.BAMBOO_PLANKS, ModChestSpecialRenderers.BAMBOO_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.PALE_OAK_CHEST.get(), Blocks.PALE_OAK_PLANKS, ModChestSpecialRenderers.PALE_OAK_CHEST_TEXTURE, true);
        this.itemModelOutput.accept(ModItems.OAK_CHEST.get(),
                ItemModelUtils.isXmas(
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.GIFT_CHEST_TEXTURE)),
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.NORMAL_CHEST_TEXTURE))
                )
        );
        this.createChest(CompatModBlocks.DEAD_CHEST.get(), BOPBlocks.DEAD_PLANKS, ModChestSpecialRenderers.DEAD_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.EMPYREAL_CHEST.get(), BOPBlocks.EMPYREAL_PLANKS, ModChestSpecialRenderers.EMPYREAL_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.FIR_CHEST.get(), BOPBlocks.FIR_PLANKS, ModChestSpecialRenderers.FIR_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.HELLBARK_CHEST.get(), BOPBlocks.HELLBARK_PLANKS, ModChestSpecialRenderers.HELLBARK_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.JACARANDA_CHEST.get(), BOPBlocks.JACARANDA_PLANKS, ModChestSpecialRenderers.JACARANDA_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAGIC_CHEST.get(), BOPBlocks.MAGIC_PLANKS, ModChestSpecialRenderers.MAGIC_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAHOGANY_CHEST.get(), BOPBlocks.MAHOGANY_PLANKS, ModChestSpecialRenderers.MAHOGANY_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAPLE_CHEST.get(), BOPBlocks.MAPLE_PLANKS, ModChestSpecialRenderers.MAPLE_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.PALM_CHEST.get(), BOPBlocks.PALM_PLANKS, ModChestSpecialRenderers.PALM_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.PINE_CHEST.get(), BOPBlocks.PINE_PLANKS, ModChestSpecialRenderers.PINE_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.REDWOOD_CHEST.get(), BOPBlocks.REDWOOD_PLANKS, ModChestSpecialRenderers.REDWOOD_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.UMBRAN_CHEST.get(), BOPBlocks.UMBRAN_PLANKS, ModChestSpecialRenderers.UMBRAN_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.WILLOW_CHEST.get(), BOPBlocks.WILLOW_PLANKS, ModChestSpecialRenderers.WILLOW_CHEST_TEXTURE, true);

        this.createChest(ModBlocks.SPRUCE_TRAPPED_CHEST.get(), Blocks.SPRUCE_PLANKS, ModChestSpecialRenderers.SPRUCE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BIRCH_TRAPPED_CHEST.get(), Blocks.BIRCH_PLANKS, ModChestSpecialRenderers.BIRCH_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.JUNGLE_TRAPPED_CHEST.get(), Blocks.JUNGLE_PLANKS, ModChestSpecialRenderers.JUNGLE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.ACACIA_TRAPPED_CHEST.get(), Blocks.ACACIA_PLANKS, ModChestSpecialRenderers.ACACIA_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.DARK_OAK_TRAPPED_CHEST.get(), Blocks.DARK_OAK_PLANKS, ModChestSpecialRenderers.DARK_OAK_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CRIMSON_TRAPPED_CHEST.get(), Blocks.CRIMSON_PLANKS, ModChestSpecialRenderers.CRIMSON_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.WARPED_TRAPPED_CHEST.get(), Blocks.WARPED_PLANKS, ModChestSpecialRenderers.WARPED_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.MANGROVE_TRAPPED_CHEST.get(), Blocks.MANGROVE_PLANKS, ModChestSpecialRenderers.MANGROVE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CHERRY_TRAPPED_CHEST.get(), Blocks.CHERRY_PLANKS, ModChestSpecialRenderers.CHERRY_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BAMBOO_TRAPPED_CHEST.get(), Blocks.BAMBOO_PLANKS, ModChestSpecialRenderers.BAMBOO_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.PALE_OAK_TRAPPED_CHEST.get(), Blocks.PALE_OAK_PLANKS, ModChestSpecialRenderers.PALE_OAK_TRAPPED_CHEST_TEXTURE, true);
        this.itemModelOutput.accept(ModItems.OAK_TRAPPED_CHEST.get(),
                ItemModelUtils.isXmas(
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/trapped_chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.GIFT_CHEST_TEXTURE)),
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/trapped_chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.NORMAL_CHEST_TEXTURE))
                )
        );
        this.createChest(CompatModBlocks.DEAD_TRAPPED_CHEST.get(), BOPBlocks.DEAD_PLANKS, ModChestSpecialRenderers.DEAD_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.EMPYREAL_TRAPPED_CHEST.get(), BOPBlocks.EMPYREAL_PLANKS, ModChestSpecialRenderers.EMPYREAL_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.FIR_TRAPPED_CHEST.get(), BOPBlocks.FIR_PLANKS, ModChestSpecialRenderers.FIR_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.HELLBARK_TRAPPED_CHEST.get(), BOPBlocks.HELLBARK_PLANKS, ModChestSpecialRenderers.HELLBARK_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.JACARANDA_TRAPPED_CHEST.get(), BOPBlocks.JACARANDA_PLANKS, ModChestSpecialRenderers.JACARANDA_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAGIC_TRAPPED_CHEST.get(), BOPBlocks.MAGIC_PLANKS, ModChestSpecialRenderers.MAGIC_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAHOGANY_TRAPPED_CHEST.get(), BOPBlocks.MAHOGANY_PLANKS, ModChestSpecialRenderers.MAHOGANY_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.MAPLE_TRAPPED_CHEST.get(), BOPBlocks.MAPLE_PLANKS, ModChestSpecialRenderers.MAPLE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.PALM_TRAPPED_CHEST.get(), BOPBlocks.PALM_PLANKS, ModChestSpecialRenderers.PALM_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.PINE_TRAPPED_CHEST.get(), BOPBlocks.PINE_PLANKS, ModChestSpecialRenderers.PINE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.REDWOOD_TRAPPED_CHEST.get(), BOPBlocks.REDWOOD_PLANKS, ModChestSpecialRenderers.REDWOOD_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.UMBRAN_TRAPPED_CHEST.get(), BOPBlocks.UMBRAN_PLANKS, ModChestSpecialRenderers.UMBRAN_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(CompatModBlocks.WILLOW_TRAPPED_CHEST.get(), BOPBlocks.WILLOW_PLANKS, ModChestSpecialRenderers.WILLOW_TRAPPED_CHEST_TEXTURE, true);
    }

    public void createCustomCartographyTable(Block block, Block woodType) {
        TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(woodType)).put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_side1")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_side2"));
        this.blockStateOutput.accept(createSimpleBlock(block, plainVariant(ModelTemplates.CUBE.create(block, texturemapping, this.modelOutput))));
    }

    public void copyWeightedPressurePlateModel(Block pressurePlateBlock, Block sourceBlock) {
        MultiVariant identifier = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.getDefaultModelLocation(pressurePlateBlock));
        MultiVariant identifier1 = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.getDefaultModelLocation(pressurePlateBlock));
        itemModelOutput.copy(pressurePlateBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(sourceBlock).with(createEmptyOrFullDispatch(BlockStateProperties.POWER, 1, identifier1, identifier)));
    }

    public void copySlabModel(Block slabBlock, Block sourceBlock) {
        MultiVariant identifier = plainVariant(ModelTemplates.SLAB_BOTTOM.getDefaultModelLocation(slabBlock));
        MultiVariant identifier1 = plainVariant(ModelTemplates.SLAB_TOP.getDefaultModelLocation(slabBlock));
        MultiVariant identifier2 = plainVariant(ModelTemplates.CUBE.getDefaultModelLocation(slabBlock));
        itemModelOutput.copy(slabBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(createSlab(sourceBlock, identifier, identifier1, identifier2));
    }

    public void copyStairModel(Block stairBlock, Block sourceBlock) {
        MultiVariant identifier = plainVariant(ModelTemplates.STAIRS_STRAIGHT.getDefaultModelLocation(stairBlock));
        MultiVariant identifier1 = plainVariant(ModelTemplates.STAIRS_INNER.getDefaultModelLocation(stairBlock));
        MultiVariant identifier2 = plainVariant(ModelTemplates.STAIRS_OUTER.getDefaultModelLocation(stairBlock));
        itemModelOutput.copy(stairBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(createStairs(sourceBlock, identifier1, identifier, identifier2));
    }

    public void createWaxedIronBlock() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_BLOCK.get(), Identifier.parse("minecraft:block/iron_block"));
        this.blockStateOutput.accept(
                createSimpleBlock(
                        ModBlocks.WAXED_IRON_BLOCK.get(),
                        plainVariant(Identifier.parse("minecraft:block/iron_block"))
                )
        );
    }

    public void createWaxedIronDoor() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_DOOR.get(), Identifier.parse("minecraft:item/iron_door"));
        this.blockStateOutput.accept(
                createDoor(
                        ModBlocks.WAXED_IRON_DOOR.get(),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_bottom_left")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_bottom_left_open")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_bottom_right")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_bottom_right_open")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_top_left")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_top_left_open")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_top_right")),
                        plainVariant(Identifier.parse("minecraft:block/iron_door_top_right_open"))
                )
        );
    }

    public void createWaxedIronTrapdoor() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_TRAPDOOR.get(), Identifier.parse("minecraft:block/iron_trapdoor_bottom"));
        this.blockStateOutput.accept(
                createTrapdoor(
                        ModBlocks.WAXED_IRON_TRAPDOOR.get(),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_top")),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_bottom")),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_open"))
                )
        );
    }

    public void createWaxedIronPressurePlate() {
        this.registerSimpleItemModel(ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), Identifier.parse("minecraft:block/heavy_weighted_pressure_plate"));
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                        .with(createEmptyOrFullDispatch(BlockStateProperties.POWER,
                                1,
                                plainVariant(Identifier.parse("minecraft:block/heavy_weighted_pressure_plate_down")),
                                plainVariant(Identifier.parse("minecraft:block/heavy_weighted_pressure_plate"))
                        )
                )
        );
    }

    public MultiVariant createBars(Block block, String suffix) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.IRON_BARS, suffix);
        TextureSlot barsSlot = TextureSlot.create("bars");
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.of(suffix), TextureSlot.PARTICLE, barsSlot, TextureSlot.EDGE);
        return plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
                        .put(barsSlot, TextureMapping.getBlockTexture(block))
                        .put(TextureSlot.EDGE, TextureMapping.getBlockTexture(block)), modelTemplate)
                .create(block, modelOutput));
    }

    public void createBarsBlock(Block block) {
        MultiVariant identifier = createBars(block, "_post_ends");
        MultiVariant identifier1 = createBars(block, "_post");
        MultiVariant identifier2 = createBars(block, "_cap");
        MultiVariant identifier3 = createBars(block, "_cap_alt");
        MultiVariant identifier4 = createBars(block, "_side");
        MultiVariant identifier5 = createBars(block, "_side_alt");
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(block)
                        .with(identifier)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), identifier3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), identifier3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), identifier4)
                        .with(condition().term(BlockStateProperties.EAST, true), identifier4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), identifier5)
                        .with(condition().term(BlockStateProperties.WEST, true), identifier5.with(Y_ROT_90))
        );
        this.registerSimpleFlatItemModel(block);
    }

    public void createCustomBarrel(Block barrel) {
        Identifier identifier = TextureMapping.getBlockTexture(barrel, "_top_open");
        MultiVariant multivariant = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.create(barrel, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.get(barrel).updateTextures((p_386917_) -> p_386917_.put(TextureSlot.TOP, identifier)).createWithSuffix(barrel, "_open", this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(barrel).with(PropertyDispatch.initial(BlockStateProperties.OPEN).select(false, multivariant).select(true, multivariant1)).with(ROTATIONS_COLUMN_WITH_FACING));
    }

    public void copyBarsModel(Block sourceBlock, Block targetBlock) {
        MultiVariant identifier = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_post_ends"));
        MultiVariant identifier1 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_post"));
        MultiVariant identifier2 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_cap"));
        MultiVariant identifier3 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_cap_alt"));
        MultiVariant identifier4 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_side"));
        MultiVariant identifier5 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_side_alt"));
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(targetBlock)
                        .with(identifier)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), identifier3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), identifier3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), identifier4)
                        .with(condition().term(BlockStateProperties.EAST, true), identifier4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), identifier5)
                        .with(condition().term(BlockStateProperties.WEST, true), identifier5.with(Y_ROT_90))
        );
        this.itemModelOutput.copy(sourceBlock.asItem(), targetBlock.asItem());
    }

    public void createWaxedIronBars() {
        MultiVariant identifier = plainVariant(Identifier.parse("minecraft:block/iron_bars_post_ends"));
        MultiVariant identifier1 = plainVariant(Identifier.parse("minecraft:block/iron_bars_post"));
        MultiVariant identifier2 = plainVariant(Identifier.parse("minecraft:block/iron_bars_cap"));
        MultiVariant identifier3 = plainVariant(Identifier.parse("minecraft:block/iron_bars_cap_alt"));
        MultiVariant identifier4 = plainVariant(Identifier.parse("minecraft:block/iron_bars_side"));
        MultiVariant identifier5 = plainVariant(Identifier.parse("minecraft:block/iron_bars_side_alt"));
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(ModBlocks.WAXED_IRON_BARS.get())
                        .with(identifier)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), identifier2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), identifier3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), identifier3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), identifier4)
                        .with(condition().term(BlockStateProperties.EAST, true), identifier4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), identifier5)
                        .with(condition().term(BlockStateProperties.WEST, true), identifier5.with(Y_ROT_90))
        );
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_BARS.get(), Identifier.parse("minecraft:item/iron_bars"));
    }

    public void createCustomPressurePlate(Block pressurePlate, Block baseBlock) {
        TextureMapping textureMapping = TextureMapping.defaultTexture(baseBlock);
        MultiVariant identifier = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMapping, this.modelOutput));
        MultiVariant identifier1 = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMapping, this.modelOutput));
        this.blockStateOutput.accept(createPressurePlate(pressurePlate, identifier, identifier1));
    }

    public void createNuke(Block nukeBlock, TexturedModel.Provider modelProvider) {
        MultiVariant identifier = plainVariant(modelProvider.create(nukeBlock, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(nukeBlock, identifier).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
    }

    @Override
    public void createCraftingTableLike(Block craftingTableBlock, Block craftingTableMaterialBlock, BiFunction<Block, Block, TextureMapping> textureMappingGetter) {
        if (craftingTableBlock == ModBlocks.BIRCH_FLETCHING_TABLE.get()) {
            TextureMapping texturemapping = (TextureMapping)textureMappingGetter.apply(Blocks.FLETCHING_TABLE, craftingTableMaterialBlock);
            this.blockStateOutput.accept(createSimpleBlock(craftingTableBlock, plainVariant(ModelTemplates.CUBE.create(craftingTableBlock, texturemapping, this.modelOutput))));
        } else {
            TextureMapping texturemapping = (TextureMapping)textureMappingGetter.apply(craftingTableBlock, craftingTableMaterialBlock);
            this.blockStateOutput.accept(createSimpleBlock(craftingTableBlock, plainVariant(ModelTemplates.CUBE.create(craftingTableBlock, texturemapping, this.modelOutput))));
        }
    }

    public void createCustomSmithingTable(Block block) {
        TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.UP, TextureMapping.getBlockTexture(Blocks.SMITHING_TABLE, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_front")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_side"));
        this.blockStateOutput.accept(createSimpleBlock(block, plainVariant(ModelTemplates.CUBE.create(block, texturemapping, this.modelOutput))));
    }


    public void createGrindstoneTextureMapping(Block block, Block woodType) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.GRINDSTONE);
        TextureSlot pivotSlot = TextureSlot.create("pivot");
        TextureSlot roundelSlot = TextureSlot.create("round");
        TextureSlot legSlot = TextureSlot.create("leg");
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), pivotSlot, roundelSlot, TextureSlot.SIDE, TextureSlot.PARTICLE, legSlot);
        plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.GRINDSTONE, "_side"))
                        .put(pivotSlot, TextureMapping.getBlockTexture(block, "_pivot"))
                        .put(roundelSlot, TextureMapping.getBlockTexture(Blocks.GRINDSTONE, "_round"))
                        .put(legSlot, TextureMapping.getBlockTexture(woodType))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.GRINDSTONE, "_side")), modelTemplate)
                .create(block, modelOutput));
    }

    public void createCustomGrindstone(Block grindstoneBlock, Block woodType) {
        createGrindstoneTextureMapping(grindstoneBlock, woodType);
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(
                                grindstoneBlock, plainVariant(ModelLocationUtils.getModelLocation(grindstoneBlock)
                        )
                ).with(
                        PropertyDispatch.modify(
                                BlockStateProperties.ATTACH_FACE,
                                BlockStateProperties.HORIZONTAL_FACING
                        ).select(
                                AttachFace.FLOOR,
                                Direction.NORTH,
                                NOP
                        ).select(
                                AttachFace.FLOOR,
                                Direction.EAST,
                                Y_ROT_90
                        ).select(
                                AttachFace.FLOOR,
                                Direction.SOUTH,
                                Y_ROT_180
                        ).select(
                                AttachFace.FLOOR,
                                Direction.WEST,
                                Y_ROT_270
                        ).select(
                                AttachFace.WALL,
                                Direction.NORTH,
                                X_ROT_90
                        ).select(
                                AttachFace.WALL,
                                Direction.EAST,
                                X_ROT_90.then(Y_ROT_90)
                        ).select(
                                AttachFace.WALL,
                                Direction.SOUTH,
                                X_ROT_90.then(Y_ROT_180)
                        ).select(
                                AttachFace.WALL,
                                Direction.WEST,
                                X_ROT_90.then(Y_ROT_270)
                        ).select(AttachFace.CEILING,
                                Direction.SOUTH,
                                X_ROT_180
                        ).select(
                                AttachFace.CEILING,
                                Direction.WEST,
                                X_ROT_180.then(Y_ROT_90)
                        ).select(
                                AttachFace.CEILING,
                                Direction.NORTH,
                                X_ROT_180.then(Y_ROT_180)
                        ).select(
                                AttachFace.CEILING,
                                Direction.EAST,
                                X_ROT_180.then(Y_ROT_270)
                        )
                )
        );
    }
    @Override
    public void createCampfires(Block... campfireBlocks) {
        Identifier unlitVariant = ModelLocationUtils.getModelLocation(Blocks.CAMPFIRE, "_off");

        TextureSlot logSlot = TextureSlot.create("log");

        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(unlitVariant), Optional.of(""), TextureSlot.PARTICLE, logSlot);

        MultiVariant multiVariant = plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log"))
                        .put(logSlot, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")), modelTemplate)
                .createWithSuffix(Arrays.stream(campfireBlocks).findFirst().get(), "_off", modelOutput));

        for(Block block : campfireBlocks) {
            Identifier id = BuiltInRegistries.BLOCK.getKey(block);
            String name = id.getPath();
            boolean isSoul = name.contains("soul");

            Identifier litVariant = ModelLocationUtils.getModelLocation(Blocks.CAMPFIRE);

            ModelTemplate modelTemplate1 = new ModelTemplate(Optional.of(litVariant), Optional.of(""), TextureSlot.LIT_LOG, TextureSlot.PARTICLE, logSlot, TextureSlot.FIRE);

            MultiVariant multivariant1;

            if (!isSoul){
                MultiVariant multiVariant2 = plainVariant(
                        modelTemplate1.create(
                                block,
                                new TextureMapping().put(
                                        TextureSlot.LIT_LOG,
                                        TextureMapping.getBlockTexture(block, "_log_lit")
                                ).put(
                                        TextureSlot.PARTICLE,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")
                                ).put(
                                        logSlot,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")
                                ).put(
                                        TextureSlot.FIRE,
                                        TextureMapping.getBlockTexture(Blocks.CAMPFIRE, "_fire")
                                ),
                                this.modelOutput
                        )
                );

                multivariant1 = multiVariant2;
            } else {
                MultiVariant multiVariant2 = plainVariant(
                        modelTemplate1.create(
                                block,
                                new TextureMapping().put(
                                        TextureSlot.LIT_LOG,
                                        TextureMapping.getBlockTexture(block, "_log_lit")
                                ).put(
                                        TextureSlot.PARTICLE,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")
                                ).put(
                                        logSlot,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")
                                ).put(
                                        TextureSlot.FIRE,
                                        TextureMapping.getBlockTexture(Blocks.SOUL_CAMPFIRE, "_fire")
                                ),
                                this.modelOutput
                        )
                );

                multivariant1 = multiVariant2;
            }

            this.registerSimpleFlatItemModel(block.asItem());
            this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.LIT).select(false, multiVariant).select(true, multivariant1)).with(ROTATION_HORIZONTAL_FACING_ALT));
        }

    }

    public void createCustomBookshelf(Block bookshelfBlock, Block woodType) {
        TextureMapping texturemapping = TextureMapping.column(TextureMapping.getBlockTexture(bookshelfBlock), TextureMapping.getBlockTexture(woodType));
        MultiVariant multivariant = plainVariant(ModelTemplates.CUBE_COLUMN.create(bookshelfBlock, texturemapping, this.modelOutput));
        this.blockStateOutput.accept(createSimpleBlock(bookshelfBlock, multivariant));
    }

    public void createChiseledBookshelfTextureMapping(Block chiseledBookshelf) {
        Identifier topTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_top");
        Identifier sideTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_side");
        Identifier emptyFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_empty");
        Identifier occupiedFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_occupied");

        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.CHISELED_BOOKSHELF);
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.PARTICLE);

        for (int i = 0; i < 6; i++) {
            TextureMapping emptyMapping = new TextureMapping()
                    .put(TextureSlot.TEXTURE, emptyFrontTexture);
            makeBookshelfModel(chiseledBookshelf, i, false, emptyMapping);
            TextureMapping occupiedMapping = new TextureMapping()
                    .put(TextureSlot.TEXTURE, occupiedFrontTexture);
            makeBookshelfModel(chiseledBookshelf, i, true, occupiedMapping);
        }

        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.TOP, topTexture)
                                .put(TextureSlot.SIDE, sideTexture)
                                .put(TextureSlot.PARTICLE, topTexture),
                        modelTemplate)
                .create(chiseledBookshelf, this.modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.TOP, topTexture)
                                .put(TextureSlot.SIDE, sideTexture)
                                .put(TextureSlot.PARTICLE, topTexture)
                                .put(TextureSlot.FRONT, emptyFrontTexture),
                        ModelTemplates.CUBE_ORIENTABLE)
                .createWithSuffix(chiseledBookshelf, "_inventory", this.modelOutput));
    }

    private void makeBookshelfModel(Block block, int slotIndex, boolean occupied, TextureMapping mapping){
        ModelTemplate template = switch (slotIndex) {
            case 0 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_LEFT;
            case 1 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_MID;
            case 2 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_RIGHT;
            case 3 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_LEFT;
            case 4 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_MID;
            case 5 -> ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_RIGHT;
            default -> throw new IllegalArgumentException("Invalid chiseled bookshelf slot index: " + slotIndex);
        };
        String suffix = (occupied ? "_occupied_slot_" : "_empty_slot_")
                + switch (slotIndex) {
            case 0 -> "top_left";
            case 1 -> "top_mid";
            case 2 -> "top_right";
            case 3 -> "bottom_left";
            case 4 -> "bottom_mid";
            case 5 -> "bottom_right";
            default -> "error";
        };
        template.createWithSuffix(block, suffix, mapping, this.modelOutput);
    }

    public void createCustomChiseledBookshelf(Block chiseledBookshelf) {
        createChiseledBookshelfTextureMapping(chiseledBookshelf);

        MultiVariant multivariant = plainVariant(ModelLocationUtils.getModelLocation(chiseledBookshelf));
        MultiPartGenerator multipartgenerator = MultiPartGenerator.multiPart(chiseledBookshelf);

        forEachHorizontalDirection((direction, mutator) -> {
            Condition condition = condition().term(BlockStateProperties.HORIZONTAL_FACING, direction).build();
            multipartgenerator.with(condition, multivariant.with(mutator).with(UV_LOCK));
            this.addSlotStateAndRotationVariantsToCustomBookshelf(multipartgenerator, condition, mutator, chiseledBookshelf);
        });

        this.blockStateOutput.accept(multipartgenerator);
        this.registerSimpleItemModel(chiseledBookshelf, ModelLocationUtils.getModelLocation(chiseledBookshelf, "_inventory"));
        CHISELED_BOOKSHELF_SLOT_MODEL_CACHE.clear();
    }

    public void addSlotStateAndRotationVariantsToCustomBookshelf(MultiPartGenerator generator, Condition condition, VariantMutator rotation, Block block) {
        List.of(Pair.of(ChiseledBookShelfBlock.SLOT_0_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_LEFT), Pair.of(ChiseledBookShelfBlock.SLOT_1_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_MID), Pair.of(ChiseledBookShelfBlock.SLOT_2_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_TOP_RIGHT), Pair.of(ChiseledBookShelfBlock.SLOT_3_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_LEFT), Pair.of(ChiseledBookShelfBlock.SLOT_4_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_MID), Pair.of(ChiseledBookShelfBlock.SLOT_5_OCCUPIED, ModelTemplates.CHISELED_BOOKSHELF_SLOT_BOTTOM_RIGHT)).forEach((p_403863_) -> {
            BooleanProperty booleanproperty = (BooleanProperty)p_403863_.getFirst();
            ModelTemplate modeltemplate = (ModelTemplate)p_403863_.getSecond();
            this.addBookSlotModelToCustomBookShelf(generator, condition, rotation, booleanproperty, modeltemplate, true, block);
            this.addBookSlotModelToCustomBookShelf(generator, condition, rotation, booleanproperty, modeltemplate, false, block);
        });
    }

    public void addBookSlotModelToCustomBookShelf(MultiPartGenerator generator, Condition conditon, VariantMutator rotation, BooleanProperty hasBookProperty, ModelTemplate template, boolean hasBook, Block block) {
        String s = hasBook ? "_occupied" : "_empty";
        TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(block, s));
        BookSlotModelCacheKey blockmodelgenerators$bookslotmodelcachekey = new BookSlotModelCacheKey(template, s);
        MultiVariant multivariant = plainVariant((Identifier)CHISELED_BOOKSHELF_SLOT_MODEL_CACHE.computeIfAbsent(blockmodelgenerators$bookslotmodelcachekey, (p_387964_) -> template.createWithSuffix(block, s, texturemapping, this.modelOutput)));
        generator.with(new CombinedCondition(CombinedCondition.Operation.AND, List.of(conditon, condition().term(hasBookProperty, hasBook).build())), multivariant.with(rotation));
    }

    public void createLecternTextureMapping(Block block, Block woodType) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.LECTERN);
        TextureSlot baseSlot = TextureSlot.create("base");
        TextureSlot sidesSlot = TextureSlot.create("sides");
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), TextureSlot.PARTICLE, TextureSlot.BOTTOM, baseSlot, TextureSlot.FRONT, sidesSlot, TextureSlot.TOP);
        plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_sides"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(woodType))
                        .put(baseSlot, TextureMapping.getBlockTexture(block, "_base"))
                        .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(block, "_front"))
                        .put(sidesSlot, TextureMapping.getBlockTexture(block, "_sides"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")), modelTemplate)
                .create(block, modelOutput));
    }

    public void createLectern(Block block, Block bottomTexture){
        createLecternTextureMapping(block, bottomTexture);
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(
                        block, plainVariant(ModelLocationUtils.getModelLocation(block)
                        )
                ).with(
                        PropertyDispatch.modify(
                                 BlockStateProperties.HORIZONTAL_FACING
                        ).select(
                                Direction.NORTH,
                                NOP
                        ).select(
                                Direction.EAST,
                                Y_ROT_90
                        ).select(
                                Direction.SOUTH,
                                Y_ROT_180
                        ).select(
                                Direction.WEST,
                                Y_ROT_270
                        )
                )
        );
    }

    public void createBrewingStandTextureMapping(Block block) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND);
        TextureSlot baseSlot = TextureSlot.create("base");
        TextureSlot standSlot = TextureSlot.create("stand");
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), baseSlot, standSlot);
        plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Blocks.BREWING_STAND))
                        .put(baseSlot, TextureMapping.getBlockTexture(block, "_base"))
                        .put(standSlot, TextureMapping.getBlockTexture(Blocks.BREWING_STAND)), modelTemplate)
                .create(block, modelOutput));
    }

    public void createCustomBrewingStand(Block brewingStandBlock) {
        createBrewingStandTextureMapping(brewingStandBlock);
        this.registerSimpleFlatItemModel(brewingStandBlock.asItem());
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(brewingStandBlock)
                        .with(plainVariant(TextureMapping.getBlockTexture(brewingStandBlock)))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_0, true),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_bottle0")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_1, true),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_bottle1")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_2, true),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_bottle2")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_0, false),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_empty0")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_1, false),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_empty1")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_2, false),
                                plainVariant(TextureMapping.getBlockTexture(Blocks.BREWING_STAND, "_empty2"))));
    }

    public void createCustomDispenserBlock(Block dispenserBlock, Block furnaceBlock) {
        TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.TOP, TextureMapping.getBlockTexture(furnaceBlock, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(furnaceBlock, "_side")).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(dispenserBlock, "_front"));
        TextureMapping texturemapping1 = (new TextureMapping()).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(furnaceBlock, "_top")).put(TextureSlot.FRONT, TextureMapping.getBlockTexture(dispenserBlock, "_front_vertical"));
        MultiVariant multivariant = plainVariant(ModelTemplates.CUBE_ORIENTABLE.create(dispenserBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(ModelTemplates.CUBE_ORIENTABLE_VERTICAL.create(dispenserBlock, texturemapping1, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(dispenserBlock).with(PropertyDispatch.initial(BlockStateProperties.FACING).select(Direction.DOWN, multivariant1.with(X_ROT_180)).select(Direction.UP, multivariant1).select(Direction.NORTH, multivariant).select(Direction.EAST, multivariant.with(Y_ROT_90)).select(Direction.SOUTH, multivariant.with(Y_ROT_180)).select(Direction.WEST, multivariant.with(Y_ROT_270))));
    }

    public void createCustomObserver(Block observerBlock) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.OBSERVER);

        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.FRONT, TextureSlot.SIDE, TextureSlot.PARTICLE);


        MultiVariant multivariant = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_back"))
                .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(block, "_front"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_front")), modelTemplate)
                .create(observerBlock, modelOutput));
        MultiVariant multivariant1 = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_back_on"))
                        .put(TextureSlot.FRONT, TextureMapping.getBlockTexture(block, "_front"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"))
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_front")), modelTemplate)
                .createWithSuffix(observerBlock, "_on", modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(observerBlock).with(createBooleanModelDispatch(BlockStateProperties.POWERED, multivariant1, multivariant)).with(ROTATION_FACING));
    }

    public void createCustomCrafterBlock(Block crafterBlock) {
        Identifier parent = ModelLocationUtils.getModelLocation(Blocks.CRAFTER);

        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.empty(), TextureSlot.BOTTOM, TextureSlot.TOP, TextureSlot.NORTH, TextureSlot.SOUTH, TextureSlot.WEST, TextureSlot.EAST, TextureSlot.PARTICLE);

        MultiVariant multivariant = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_bottom"))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_top"))
                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(crafterBlock, "_north"))
                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(crafterBlock, "_south"))
                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(crafterBlock, "_east"))
                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(crafterBlock, "_west"))
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(crafterBlock, "_north")), modelTemplate)
                .create(crafterBlock, modelOutput));
        MultiVariant multivariant1 = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_bottom"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_top_triggered"))
                        .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(crafterBlock, "_north"))
                        .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(crafterBlock, "_south_triggered"))
                        .put(TextureSlot.EAST, TextureMapping.getBlockTexture(crafterBlock, "_east_triggered"))
                        .put(TextureSlot.WEST, TextureMapping.getBlockTexture(crafterBlock, "_west_triggered"))
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(crafterBlock, "_north")), modelTemplate)
                .createWithSuffix(crafterBlock, "_triggered", modelOutput));
        MultiVariant multivariant2 = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_bottom"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_top_crafting"))
                        .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(crafterBlock, "_north_crafting"))
                        .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(crafterBlock, "_south_triggered"))
                        .put(TextureSlot.EAST, TextureMapping.getBlockTexture(crafterBlock, "_east_crafting"))
                        .put(TextureSlot.WEST, TextureMapping.getBlockTexture(crafterBlock, "_west_crafting"))
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(crafterBlock, "_north_crafting")), modelTemplate)
                .createWithSuffix(crafterBlock, "_crafting", modelOutput));
        MultiVariant multivariant3 = plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_bottom"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(Blocks.CRAFTER, "_top_crafting"))
                        .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(crafterBlock, "_north_crafting"))
                        .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(crafterBlock, "_south_triggered"))
                        .put(TextureSlot.EAST, TextureMapping.getBlockTexture(crafterBlock, "_east_crafting"))
                        .put(TextureSlot.WEST, TextureMapping.getBlockTexture(crafterBlock, "_west_crafting"))
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(crafterBlock, "_north_crafting")), modelTemplate)
                .createWithSuffix(crafterBlock, "_crafting_triggered", modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(crafterBlock).with(PropertyDispatch.initial(BlockStateProperties.TRIGGERED, CrafterBlock.CRAFTING).select(false, false, multivariant).select(true, true, multivariant3).select(true, false, multivariant1).select(false, true, multivariant2)).with(PropertyDispatch.modify(BlockStateProperties.ORIENTATION).generate(BlockModelGenerators::applyRotation)));
    }

    public void createWaxedIronChain() {
        this.createAxisAlignedPillarBlockCustomModel(ModBlocks.WAXED_IRON_CHAIN.get(), plainVariant(Identifier.withDefaultNamespace("block/iron_chain")));
        this.registerSimpleItemModel(ModItems.WAXED_IRON_CHAIN.get(), Identifier.withDefaultNamespace("item/iron_chain"));
    }

    public void createWaxedIronLantern() {
        MultiVariant standing = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.LANTERN)
        );

        MultiVariant hanging = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.LANTERN, "_hanging")
        );

        this.itemModelOutput.accept(
                ModItems.WAXED_IRON_LANTERN.get(),
                ItemModelUtils.plainModel(
                        ModelLocationUtils.getModelLocation(Items.LANTERN)
                )
        );

        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.WAXED_IRON_LANTERN.get())
                        .with(createBooleanModelDispatch(
                                BlockStateProperties.HANGING,
                                hanging,
                                standing
                        ))
        );
    }

    public void createWaxedIronSoulLantern() {
        MultiVariant standing = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.SOUL_LANTERN)
        );

        MultiVariant hanging = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.SOUL_LANTERN, "_hanging")
        );

        this.itemModelOutput.accept(
                ModItems.WAXED_IRON_SOUL_LANTERN.get(),
                ItemModelUtils.plainModel(
                        ModelLocationUtils.getModelLocation(Items.SOUL_LANTERN)
                )
        );

        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.WAXED_IRON_SOUL_LANTERN.get())
                        .with(createBooleanModelDispatch(
                                BlockStateProperties.HANGING,
                                hanging,
                                standing
                        ))
        );
    }

    public void createCustomChain(Block chain) {
        MultiVariant multivariant = plainVariant(TexturedModel.CHAIN.create(chain, this.modelOutput));
        Identifier identifier = this.createFlatItemModel(chain.asItem());
        this.createAxisAlignedPillarBlockCustomModel(chain, multivariant);
        this.registerSimpleItemModel(chain.asItem(), identifier);
    }

    public static BlockModelDefinitionGenerator createThermalSlab(Block block, MultiVariant bottom1, MultiVariant top1, MultiVariant doubleVariants1, MultiVariant bottom2, MultiVariant top2, MultiVariant doubleVariants2, MultiVariant bottom3, MultiVariant top3, MultiVariant doubleVariants3, MultiVariant bottom4, MultiVariant top4, MultiVariant doubleVariants4, MultiVariant bottom5, MultiVariant top5, MultiVariant doubleVariants5) {
        return MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.SLAB_TYPE, ThermalCalciteSlabBlock.DISTANCE)
                        .select(SlabType.BOTTOM, 1, bottom1)
                        .select(SlabType.TOP, 1, top1)
                        .select(SlabType.DOUBLE, 1, doubleVariants1)
                        .select(SlabType.BOTTOM, 2, bottom2)
                        .select(SlabType.TOP, 2, top2)
                        .select(SlabType.DOUBLE, 2, doubleVariants2)
                        .select(SlabType.BOTTOM, 3, bottom3)
                        .select(SlabType.TOP, 3, top3)
                        .select(SlabType.DOUBLE, 3, doubleVariants3)
                        .select(SlabType.BOTTOM, 4, bottom4)
                        .select(SlabType.TOP, 4, top4)
                        .select(SlabType.DOUBLE, 4, doubleVariants4)
                        .select(SlabType.BOTTOM, 5, bottom5)
                        .select(SlabType.TOP, 5, top5)
                        .select(SlabType.DOUBLE, 5, doubleVariants5));
    }

    public void thermalSlab(Block slab, Block fullBlock) {

        TextureMapping d1 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock));
        TextureMapping d2 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_2"));
        TextureMapping d3 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_3"));
        TextureMapping d4 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_4"));
        TextureMapping d5 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_5"));

        MultiVariant bottomModel = plainVariant(ModelTemplates.SLAB_BOTTOM.createWithSuffix(slab, "", d1, modelOutput));
        MultiVariant topModel = plainVariant(ModelTemplates.SLAB_TOP.createWithSuffix(slab, "", d1, modelOutput));
        MultiVariant doubleVariant = plainVariant(ModelLocationUtils.getModelLocation(fullBlock, ""));

        MultiVariant bottomModel2 = plainVariant(ModelTemplates.SLAB_BOTTOM.createWithSuffix(slab, "_2", d2, modelOutput));
        MultiVariant topModel2 = plainVariant(ModelTemplates.SLAB_TOP.createWithSuffix(slab, "_2", d2, modelOutput));
        MultiVariant doubleVariant2 = plainVariant(ModelLocationUtils.getModelLocation(fullBlock, "_2"));

        MultiVariant bottomModel3 = plainVariant(ModelTemplates.SLAB_BOTTOM.createWithSuffix(slab, "_3", d3, modelOutput));
        MultiVariant topModel3 = plainVariant(ModelTemplates.SLAB_TOP.createWithSuffix(slab, "_3", d3, modelOutput));
        MultiVariant doubleVariant3 = plainVariant(ModelLocationUtils.getModelLocation(fullBlock, "_3"));

        MultiVariant bottomModel4 = plainVariant(ModelTemplates.SLAB_BOTTOM.createWithSuffix(slab, "_4", d4, modelOutput));
        MultiVariant topModel4 = plainVariant(ModelTemplates.SLAB_TOP.createWithSuffix(slab, "_4", d4, modelOutput));
        MultiVariant doubleVariant4 = plainVariant(ModelLocationUtils.getModelLocation(fullBlock, "_4"));

        MultiVariant bottomModel5 = plainVariant(ModelTemplates.SLAB_BOTTOM.createWithSuffix(slab, "_5", d5, modelOutput));
        MultiVariant topModel5 = plainVariant(ModelTemplates.SLAB_TOP.createWithSuffix(slab, "_5", d5, modelOutput));
        MultiVariant doubleVariant5 = plainVariant(ModelLocationUtils.getModelLocation(fullBlock, "_5"));

        blockStateOutput.accept(createThermalSlab(slab, bottomModel, topModel, doubleVariant, bottomModel2, topModel2, doubleVariant2, bottomModel3, topModel3, doubleVariant3, bottomModel4, topModel4, doubleVariant4, bottomModel5, topModel5, doubleVariant5));

        registerThermalInventoryModel(fullBlock, slab, ModelTemplates.SLAB_BOTTOM);
    }

    public static BlockModelDefinitionGenerator createThermalStairs(Block block, MultiVariant inner1, MultiVariant straight1, MultiVariant outer1, MultiVariant inner2, MultiVariant straight2, MultiVariant outer2, MultiVariant inner3, MultiVariant straight3, MultiVariant outer3, MultiVariant inner4, MultiVariant straight4, MultiVariant outer4, MultiVariant inner5, MultiVariant straight5, MultiVariant outer5) {
        return MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE, ThermalCalciteStairBlock.DISTANCE)
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, 1, straight1)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, 1, straight1.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, 1, straight1.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, 1, straight1.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 1, outer1)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 1, outer1.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 1, outer1.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 1, outer1.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, 1, outer1.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, 1, outer1.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 1, outer1)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 1, outer1.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, 1, inner1)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, 1, inner1.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 1, inner1.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 1, inner1.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, 1, inner1.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, 1, inner1.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, 1, inner1)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, 1, inner1.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, 1, straight1.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, 1, straight1.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, 1, straight1.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, 1, straight1.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, 1, outer1.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, 1, outer1.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, 1, outer1.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, 1, outer1.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, 1, outer1.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, 1, outer1.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, 1, outer1.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, 1, outer1.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, 1, inner1.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, 1, inner1.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, 1, inner1.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, 1, inner1.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, 1, inner1.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, 1, inner1.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, 1, inner1.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, 1, inner1.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, 2, straight2)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, 2, straight2.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, 2, straight2.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, 2, straight2.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 2, outer2)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 2, outer2.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 2, outer2.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 2, outer2.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, 2, outer2.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, 2, outer2.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 2, outer2)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 2, outer2.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, 2, inner2)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, 2, inner2.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 2, inner2.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 2, inner2.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, 2, inner2.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, 2, inner2.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, 2, inner2)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, 2, inner2.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, 2, straight2.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, 2, straight2.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, 2, straight2.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, 2, straight2.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, 2, outer2.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, 2, outer2.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, 2, outer2.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, 2, outer2.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, 2, outer2.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, 2, outer2.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, 2, outer2.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, 2, outer2.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, 2, inner2.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, 2, inner2.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, 2, inner2.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, 2, inner2.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, 2, inner2.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, 2, inner2.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, 2, inner2.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, 2, inner2.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, 3, straight3)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, 3, straight3.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, 3, straight3.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, 3, straight3.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 3, outer3)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 3, outer3.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 3, outer3.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 3, outer3.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, 3, outer3.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, 3, outer3.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 3, outer3)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 3, outer3.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, 3, inner3)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, 3, inner3.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 3, inner3.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 3, inner3.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, 3, inner3.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, 3, inner3.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, 3, inner3)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, 3, inner3.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, 3, straight3.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, 3, straight3.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, 3, straight3.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, 3, straight3.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, 3, outer3.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, 3, outer3.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, 3, outer3.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, 3, outer3.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, 3, outer3.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, 3, outer3.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, 3, outer3.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, 3, outer3.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, 3, inner3.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, 3, inner3.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, 3, inner3.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, 3, inner3.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, 3, inner3.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, 3, inner3.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, 3, inner3.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, 3, inner3.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, 4, straight4)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, 4, straight4.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, 4, straight4.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, 4, straight4.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 4, outer4)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 4, outer4.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 4, outer4.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 4, outer4.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, 4, outer4.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, 4, outer4.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 4, outer4)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 4, outer4.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, 4, inner4)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, 4, inner4.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 4, inner4.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 4, inner4.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, 4, inner4.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, 4, inner4.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, 4, inner4)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, 4, inner4.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, 4, straight4.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, 4, straight4.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, 4, straight4.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, 4, straight4.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, 4, outer4.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, 4, outer4.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, 4, outer4.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, 4, outer4.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, 4, outer4.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, 4, outer4.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, 4, outer4.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, 4, outer4.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, 4, inner4.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, 4, inner4.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, 4, inner4.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, 4, inner4.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, 4, inner4.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, 4, inner4.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, 4, inner4.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, 4, inner4.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, 5, straight5)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, 5, straight5.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, 5, straight5.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, 5, straight5.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 5, outer5)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, 5, outer5.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 5, outer5.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, 5, outer5.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, 5, outer5.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, 5, outer5.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 5, outer5)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, 5, outer5.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, 5, inner5)
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, 5, inner5.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 5, inner5.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, 5, inner5.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, 5, inner5.with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, 5, inner5.with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, 5, inner5)
                        .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, 5, inner5.with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, 5, straight5.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, 5, straight5.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, 5, straight5.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, 5, straight5.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, 5, outer5.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, 5, outer5.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, 5, outer5.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, 5, outer5.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, 5, outer5.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, 5, outer5.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, 5, outer5.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, 5, outer5.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, 5, inner5.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, 5, inner5.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, 5, inner5.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, 5, inner5.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, 5, inner5.with(X_ROT_180).with(UV_LOCK))
                        .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, 5, inner5.with(X_ROT_180).with(Y_ROT_180).with(UV_LOCK))
                        .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, 5, inner5.with(X_ROT_180).with(Y_ROT_90).with(UV_LOCK))
                        .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, 5, inner5.with(X_ROT_180).with(Y_ROT_270).with(UV_LOCK)));
    }

    public void thermalStairs(Block stairs, Block fullBlock) {
        TextureMapping d1 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock));
        TextureMapping d2 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_2"));
        TextureMapping d3 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_3"));
        TextureMapping d4 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_4"));
        TextureMapping d5 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_5"));

        MultiVariant inner1 = plainVariant(ModelTemplates.STAIRS_INNER.createWithSuffix(stairs, "", d1, modelOutput));
        MultiVariant straight1 = plainVariant(ModelTemplates.STAIRS_STRAIGHT.createWithSuffix(stairs, "", d1, modelOutput));
        MultiVariant outer1 = plainVariant(ModelTemplates.STAIRS_OUTER.createWithSuffix(stairs, "", d1, modelOutput));

        MultiVariant inner2 = plainVariant(ModelTemplates.STAIRS_INNER.createWithSuffix(stairs, "_2", d2, modelOutput));
        MultiVariant straight2 = plainVariant(ModelTemplates.STAIRS_STRAIGHT.createWithSuffix(stairs, "_2", d2, modelOutput));
        MultiVariant outer2 = plainVariant(ModelTemplates.STAIRS_OUTER.createWithSuffix(stairs, "_2", d2, modelOutput));

        MultiVariant inner3 = plainVariant(ModelTemplates.STAIRS_INNER.createWithSuffix(stairs, "_3", d3, modelOutput));
        MultiVariant straight3 = plainVariant(ModelTemplates.STAIRS_STRAIGHT.createWithSuffix(stairs, "_3", d3, modelOutput));
        MultiVariant outer3 = plainVariant(ModelTemplates.STAIRS_OUTER.createWithSuffix(stairs, "_3", d3, modelOutput));

        MultiVariant inner4 = plainVariant(ModelTemplates.STAIRS_INNER.createWithSuffix(stairs, "_4", d4, modelOutput));
        MultiVariant straight4 = plainVariant(ModelTemplates.STAIRS_STRAIGHT.createWithSuffix(stairs, "_4", d4, modelOutput));
        MultiVariant outer4 = plainVariant(ModelTemplates.STAIRS_OUTER.createWithSuffix(stairs, "_4", d4, modelOutput));

        MultiVariant inner5 = plainVariant(ModelTemplates.STAIRS_INNER.createWithSuffix(stairs, "_5", d5, modelOutput));
        MultiVariant straight5 = plainVariant(ModelTemplates.STAIRS_STRAIGHT.createWithSuffix(stairs, "_5", d5, modelOutput));
        MultiVariant outer5 = plainVariant(ModelTemplates.STAIRS_OUTER.createWithSuffix(stairs, "_5", d5, modelOutput));

        blockStateOutput.accept(createThermalStairs(stairs, inner1, straight1, outer1, inner2, straight2, outer2, inner3, straight3, outer3, inner4, straight4, outer4, inner5, straight5, outer5));

        registerThermalInventoryModel(fullBlock, stairs, ModelTemplates.STAIRS_STRAIGHT);
    }

    public static BlockModelDefinitionGenerator createThermalWall(Block block, MultiVariant post1, MultiVariant lowSide1, MultiVariant tallSide1, MultiVariant post2, MultiVariant lowSide2, MultiVariant tallSide2, MultiVariant post3, MultiVariant lowSide3, MultiVariant tallSide3, MultiVariant post4, MultiVariant lowSide4, MultiVariant tallSide4, MultiVariant post5, MultiVariant lowSide5, MultiVariant tallSide5) {
        return MultiPartGenerator.multiPart(block)
                .with(condition().term(BlockStateProperties.UP, true).term(ThermalCalciteWallBlock.DISTANCE, 1), post1)
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 1), lowSide1.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 1), lowSide1.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 1), lowSide1.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 1), lowSide1.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 1), tallSide1.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 1), tallSide1.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 1), tallSide1.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 1), tallSide1.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.UP, true).term(ThermalCalciteWallBlock.DISTANCE, 2), post2)
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 2), lowSide2.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 2), lowSide2.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 2), lowSide2.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 2), lowSide2.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 2), tallSide2.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 2), tallSide2.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 2), tallSide2.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 2), tallSide2.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.UP, true).term(ThermalCalciteWallBlock.DISTANCE, 3), post3)
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 3), lowSide3.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 3), lowSide3.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 3), lowSide3.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 3), lowSide3.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 3), tallSide3.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 3), tallSide3.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 3), tallSide3.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 3), tallSide3.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.UP, true).term(ThermalCalciteWallBlock.DISTANCE, 4), post4)
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 4), lowSide4.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 4), lowSide4.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 4), lowSide4.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 4), lowSide4.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 4), tallSide4.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 4), tallSide4.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 4), tallSide4.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 4), tallSide4.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.UP, true).term(ThermalCalciteWallBlock.DISTANCE, 5), post5)
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 5), lowSide5.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 5), lowSide5.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 5), lowSide5.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW).term(ThermalCalciteWallBlock.DISTANCE, 5), lowSide5.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 5), tallSide5.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 5), tallSide5.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 5), tallSide5.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL).term(ThermalCalciteWallBlock.DISTANCE, 5), tallSide5.with(Y_ROT_270).with(UV_LOCK));
    }

    public void thermalWall(Block wall, Block fullBlock) {
        TextureMapping d1 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock));
        TextureMapping d2 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_2"));
        TextureMapping d3 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_3"));
        TextureMapping d4 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_4"));
        TextureMapping d5 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_5"));

        MultiVariant post1 = plainVariant(ModelTemplates.WALL_POST.createWithSuffix(wall, "", d1, modelOutput));
        MultiVariant lowSide1 = plainVariant(ModelTemplates.WALL_LOW_SIDE.createWithSuffix(wall, "", d1, modelOutput));
        MultiVariant tallSide1 = plainVariant(ModelTemplates.WALL_TALL_SIDE.createWithSuffix(wall, "", d1, modelOutput));

        MultiVariant post2 = plainVariant(ModelTemplates.WALL_POST.createWithSuffix(wall, "_2", d2, modelOutput));
        MultiVariant lowSide2 = plainVariant(ModelTemplates.WALL_LOW_SIDE.createWithSuffix(wall, "_2", d2, modelOutput));
        MultiVariant tallSide2 = plainVariant(ModelTemplates.WALL_TALL_SIDE.createWithSuffix(wall, "_2", d2, modelOutput));

        MultiVariant post3 = plainVariant(ModelTemplates.WALL_POST.createWithSuffix(wall, "_3", d3, modelOutput));
        MultiVariant lowSide3 = plainVariant(ModelTemplates.WALL_LOW_SIDE.createWithSuffix(wall, "_3", d3, modelOutput));
        MultiVariant tallSide3 = plainVariant(ModelTemplates.WALL_TALL_SIDE.createWithSuffix(wall, "_3", d3, modelOutput));

        MultiVariant post4 = plainVariant(ModelTemplates.WALL_POST.createWithSuffix(wall, "_4", d4, modelOutput));
        MultiVariant lowSide4 = plainVariant(ModelTemplates.WALL_LOW_SIDE.createWithSuffix(wall, "_4", d4, modelOutput));
        MultiVariant tallSide4 = plainVariant(ModelTemplates.WALL_TALL_SIDE.createWithSuffix(wall, "_4", d4, modelOutput));

        MultiVariant post5 = plainVariant(ModelTemplates.WALL_POST.createWithSuffix(wall, "_5", d5, modelOutput));
        MultiVariant lowSide5 = plainVariant(ModelTemplates.WALL_LOW_SIDE.createWithSuffix(wall, "_5", d5, modelOutput));
        MultiVariant tallSide5 = plainVariant(ModelTemplates.WALL_TALL_SIDE.createWithSuffix(wall, "_5", d5, modelOutput));

        blockStateOutput.accept(createThermalWall(wall, post1, lowSide1, tallSide1, post2, lowSide2, tallSide2, post3, lowSide3, tallSide3, post4, lowSide4, tallSide4, post5, lowSide5, tallSide5));

        registerThermalInventoryModel(fullBlock, wall, ModelTemplates.WALL_INVENTORY);
    }

    public static BlockModelDefinitionGenerator createThermalFence(Block block, MultiVariant post, MultiVariant side, MultiVariant post2, MultiVariant side2, MultiVariant post3, MultiVariant side3, MultiVariant post4, MultiVariant side4, MultiVariant post5, MultiVariant side5) {
        return MultiPartGenerator.multiPart(block)
                .with(condition().term(ThermalCalciteFenceBlock.DISTANCE, 1), post)
                .with(condition().term(BlockStateProperties.NORTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 1), side.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST, true).term(ThermalCalciteFenceBlock.DISTANCE, 1), side.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 1), side.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST, true).term(ThermalCalciteFenceBlock.DISTANCE, 1), side.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(ThermalCalciteFenceBlock.DISTANCE, 2), post2)
                .with(condition().term(BlockStateProperties.NORTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 2), side2.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST, true).term(ThermalCalciteFenceBlock.DISTANCE, 2), side2.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 2), side2.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST, true).term(ThermalCalciteFenceBlock.DISTANCE, 2), side2.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(ThermalCalciteFenceBlock.DISTANCE, 3), post3)
                .with(condition().term(BlockStateProperties.NORTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 3), side3.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST, true).term(ThermalCalciteFenceBlock.DISTANCE, 3), side3.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 3), side3.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST, true).term(ThermalCalciteFenceBlock.DISTANCE, 3), side3.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(ThermalCalciteFenceBlock.DISTANCE, 4), post4)
                .with(condition().term(BlockStateProperties.NORTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 4), side4.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST, true).term(ThermalCalciteFenceBlock.DISTANCE, 4), side4.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 4), side4.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST, true).term(ThermalCalciteFenceBlock.DISTANCE, 4), side4.with(Y_ROT_270).with(UV_LOCK))
                .with(condition().term(ThermalCalciteFenceBlock.DISTANCE, 5), post5)
                .with(condition().term(BlockStateProperties.NORTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 5), side5.with(UV_LOCK))
                .with(condition().term(BlockStateProperties.EAST, true).term(ThermalCalciteFenceBlock.DISTANCE, 5), side5.with(Y_ROT_90).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.SOUTH, true).term(ThermalCalciteFenceBlock.DISTANCE, 5), side5.with(Y_ROT_180).with(UV_LOCK))
                .with(condition().term(BlockStateProperties.WEST, true).term(ThermalCalciteFenceBlock.DISTANCE, 5), side5.with(Y_ROT_270).with(UV_LOCK));
    }

    public void thermalFence(Block fence, Block fullBlock) {
        TextureMapping d1 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock));
        TextureMapping d2 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_2"));
        TextureMapping d3 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_3"));
        TextureMapping d4 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_4"));
        TextureMapping d5 = TextureMapping.cube(TextureMapping.getBlockTexture(fullBlock, "_5"));

        MultiVariant post1 = plainVariant(ModelTemplates.FENCE_POST.createWithSuffix(fence, "", d1, modelOutput));
        MultiVariant lowSide1 = plainVariant(ModelTemplates.FENCE_SIDE.createWithSuffix(fence, "", d1, modelOutput));

        MultiVariant post2 = plainVariant(ModelTemplates.FENCE_POST.createWithSuffix(fence, "_2", d2, modelOutput));
        MultiVariant lowSide2 = plainVariant(ModelTemplates.FENCE_SIDE.createWithSuffix(fence, "_2", d2, modelOutput));

        MultiVariant post3 = plainVariant(ModelTemplates.FENCE_POST.createWithSuffix(fence, "_3", d3, modelOutput));
        MultiVariant lowSide3 = plainVariant(ModelTemplates.FENCE_SIDE.createWithSuffix(fence, "_3", d3, modelOutput));

        MultiVariant post4 = plainVariant(ModelTemplates.FENCE_POST.createWithSuffix(fence, "_4", d4, modelOutput));
        MultiVariant lowSide4 = plainVariant(ModelTemplates.FENCE_SIDE.createWithSuffix(fence, "_4", d4, modelOutput));

        MultiVariant post5 = plainVariant(ModelTemplates.FENCE_POST.createWithSuffix(fence, "_5", d5, modelOutput));
        MultiVariant lowSide5 = plainVariant(ModelTemplates.FENCE_SIDE.createWithSuffix(fence, "_5", d5, modelOutput));

        blockStateOutput.accept(createThermalFence(fence, post1, lowSide1, post2, lowSide2, post3, lowSide3, post4, lowSide4, post5, lowSide5));

        registerThermalInventoryModel(fullBlock, fence, ModelTemplates.FENCE_INVENTORY);
    }

    private void registerThermalInventoryModel(Block baseBlock, Block block, ModelTemplate modelTemplate) {
         Identifier inventory = TexturedModel.createDefault(
                 invBlock -> new TextureMapping()
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock, ""))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock, "_5"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock, "_inventory"))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(baseBlock, "_inventory"))
                        .put(TextureSlot.WALL, TextureMapping.getBlockTexture(baseBlock, "_inventory")), modelTemplate).createWithSuffix(block, "_inventory", modelOutput);

        registerSimpleItemModel(block, inventory);
    }

    public void createThermalCalciteBlock(Block block) {
        TextureMapping d1 = TextureMapping.cube(TextureMapping.getBlockTexture(block));
        TextureMapping d2 = TextureMapping.cube(TextureMapping.getBlockTexture(block, "_2"));
        TextureMapping d3 = TextureMapping.cube(TextureMapping.getBlockTexture(block, "_3"));
        TextureMapping d4 = TextureMapping.cube(TextureMapping.getBlockTexture(block, "_4"));
        TextureMapping d5 = TextureMapping.cube(TextureMapping.getBlockTexture(block, "_5"));

        MultiVariant one = plainVariant(ModelTemplates.CUBE_ALL.createWithSuffix(block, "", d1, modelOutput));
        MultiVariant two = plainVariant(ModelTemplates.CUBE_ALL.createWithSuffix(block, "_2", d2, modelOutput));
        MultiVariant three = plainVariant(ModelTemplates.CUBE_ALL.createWithSuffix(block, "_3", d3, modelOutput));
        MultiVariant four = plainVariant(ModelTemplates.CUBE_ALL.createWithSuffix(block, "_4", d4, modelOutput));
        MultiVariant five = plainVariant(ModelTemplates.CUBE_ALL.createWithSuffix(block, "_5", d5, modelOutput));

        blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block)
                        .with(PropertyDispatch.initial(ThermalCalciteBlock.DISTANCE)
                                .select(1, one)
                                .select(2, two)
                                .select(3, three)
                                .select(4, four)
                                .select(5, five)
                        )
        );

        registerThermalInventoryModel(block, block, ModelTemplates.CUBE_BOTTOM_TOP);
    }

    public void createOriginOakChests() {
        Identifier chestSingle = TexturedModel.createDefault(
                block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                        .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                        .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                        .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_front"))
                        .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                        .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                        .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_single", modelOutput);

        MultiVariant chestRight = plainVariant(TexturedModel.createDefault(
                        block -> new TextureMapping()
                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_front_right"))
                                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_back_right"))
                                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_right", modelOutput));

        MultiVariant chestLeft = plainVariant(TexturedModel.createDefault(
                        block -> new TextureMapping()
                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_front_left"))
                                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_back_left"))
                                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_left", modelOutput));

        Identifier chestSingleTrapped = TexturedModel.createDefault(
                        block -> new TextureMapping()
                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_front"))
                                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_single", modelOutput);

        MultiVariant chestRightTrapped = plainVariant(TexturedModel.createDefault(
                        block -> new TextureMapping()
                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_front_right"))
                                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_back_right"))
                                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_right", modelOutput));

        MultiVariant chestLeftTrapped = plainVariant(TexturedModel.createDefault(
                        block -> new TextureMapping()
                                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.DOWN, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.UP, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_top"))
                                .put(TextureSlot.NORTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_front_left"))
                                .put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_back_left"))
                                .put(TextureSlot.WEST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side"))
                                .put(TextureSlot.EAST, TextureMapping.getBlockTexture(CompatModBlocks.ORIGIN_OAK_CHEST.get(), "_side")), ModelTemplates.CUBE)
                .createWithSuffix(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), "_left", modelOutput));

        blockStateOutput.accept(MultiVariantGenerator.dispatch(CompatModBlocks.ORIGIN_OAK_CHEST.get())
                .with(PropertyDispatch.initial(ChestBlock.TYPE, BlockStateProperties.HORIZONTAL_FACING)
                        .select(ChestType.SINGLE, Direction.NORTH, plainVariant(chestSingle))
                        .select(ChestType.RIGHT, Direction.NORTH, chestRight)
                        .select(ChestType.LEFT, Direction.NORTH, chestLeft)
                        .select(ChestType.SINGLE, Direction.EAST, plainVariant(chestSingle).with(Y_ROT_90))
                        .select(ChestType.RIGHT, Direction.EAST, chestRight.with(Y_ROT_90))
                        .select(ChestType.LEFT, Direction.EAST, chestLeft.with(Y_ROT_90))
                        .select(ChestType.SINGLE, Direction.SOUTH, plainVariant(chestSingle).with(Y_ROT_180))
                        .select(ChestType.RIGHT, Direction.SOUTH, chestRight.with(Y_ROT_180))
                        .select(ChestType.LEFT, Direction.SOUTH, chestLeft.with(Y_ROT_180))
                        .select(ChestType.SINGLE, Direction.WEST, plainVariant(chestSingle).with(Y_ROT_270))
                        .select(ChestType.RIGHT, Direction.WEST, chestRight.with(Y_ROT_270))
                        .select(ChestType.LEFT, Direction.WEST, chestLeft.with(Y_ROT_270))));

        blockStateOutput.accept(MultiVariantGenerator.dispatch(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get())
                .with(PropertyDispatch.initial(ChestBlock.TYPE, BlockStateProperties.HORIZONTAL_FACING)
                        .select(ChestType.SINGLE, Direction.NORTH, plainVariant(chestSingleTrapped))
                        .select(ChestType.RIGHT, Direction.NORTH, chestRightTrapped)
                        .select(ChestType.LEFT, Direction.NORTH, chestLeftTrapped)
                        .select(ChestType.SINGLE, Direction.EAST, plainVariant(chestSingleTrapped).with(Y_ROT_90))
                        .select(ChestType.RIGHT, Direction.EAST, chestRightTrapped.with(Y_ROT_90))
                        .select(ChestType.LEFT, Direction.EAST, chestLeftTrapped.with(Y_ROT_90))
                        .select(ChestType.SINGLE, Direction.SOUTH, plainVariant(chestSingleTrapped).with(Y_ROT_180))
                        .select(ChestType.RIGHT, Direction.SOUTH, chestRightTrapped.with(Y_ROT_180))
                        .select(ChestType.LEFT, Direction.SOUTH, chestLeftTrapped.with(Y_ROT_180))
                        .select(ChestType.SINGLE, Direction.WEST, plainVariant(chestSingleTrapped).with(Y_ROT_270))
                        .select(ChestType.RIGHT, Direction.WEST, chestRightTrapped.with(Y_ROT_270))
                        .select(ChestType.LEFT, Direction.WEST, chestLeftTrapped.with(Y_ROT_270))));

        registerSimpleItemModel(CompatModBlocks.ORIGIN_OAK_CHEST.get(), chestSingle);
        registerSimpleItemModel(CompatModBlocks.ORIGIN_OAK_TRAPPED_CHEST.get(), chestSingleTrapped);
    }

    @Override
    public void run() {
        this.createTrivialCube(ModBlocks.POLISHED_CALCITE.get());
        this.createTrivialCube(ModBlocks.POLISHED_DRIPSTONE.get());

        this.createTrivialCube(ModBlocks.POLISHED_GRANITE_BRICKS.get());
        this.createTrivialCube(ModBlocks.POLISHED_DIORITE_BRICKS.get());
        this.createTrivialCube(ModBlocks.POLISHED_ANDESITE_BRICKS.get());
        this.createTrivialCube(ModBlocks.CALCITE_BRICKS.get());
        this.createTrivialCube(ModBlocks.DRIPSTONE_BRICKS.get());
        this.createTrivialCube(ModBlocks.BASALT_BRICKS.get());

        this.createTrivialCube(ModBlocks.CHARCOAL_BLOCK.get());

        this.createTrivialCube(ModBlocks.ELDER_PRISMARINE.get());
        this.createTrivialCube(ModBlocks.ELDER_PRISMARINE_BRICKS.get());
        this.createTrivialCube(ModBlocks.DARK_ELDER_PRISMARINE.get());
        this.createTrivialCube(ModBlocks.ELDER_SEA_LANTERN.get());

        this.createTrivialBlock(ModBlocks.SOUL_SANDSTONE.get(), TexturedModel.CUBE_TOP_BOTTOM.updateTexture(
                (mapping) -> mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get()))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_bottom"))
        ));
        this.createTrivialBlock(ModBlocks.CUT_SOUL_SANDSTONE.get(), TexturedModel.COLUMN.updateTexture(
                (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CUT_SOUL_SANDSTONE.get()))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
        ));
        this.createTrivialBlock(ModBlocks.CHISELED_SOUL_SANDSTONE.get(), TexturedModel.COLUMN.updateTexture(
             (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CHISELED_SOUL_SANDSTONE.get()))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
        ));
        this.createTrivialBlock(ModBlocks.SMOOTH_SOUL_SANDSTONE.get(), TexturedModel.CUBE.updateTexture(
                (mapping) -> mapping.put(TextureSlot.ALL, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"))
        ));

        this.createDoor(ModBlocks.GOLD_DOOR.get());
        this.createTrapdoor(ModBlocks.GOLD_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE.get(), Blocks.NETHERITE_BLOCK);

        this.createDoor(ModBlocks.NETHERITE_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.NETHERITE_TRAPDOOR.get());

        this.createBarsBlock(ModBlocks.EXPOSED_IRON_BARS.get());
        this.createBarsBlock(ModBlocks.WEATHERED_IRON_BARS.get());
        this.createBarsBlock(ModBlocks.RUSTED_IRON_BARS.get());

        this.createWaxedIronBars();
        this.copyBarsModel(ModBlocks.EXPOSED_IRON_BARS.get(), ModBlocks.WAXED_EXPOSED_IRON_BARS.get());
        this.copyBarsModel(ModBlocks.WEATHERED_IRON_BARS.get(), ModBlocks.WAXED_WEATHERED_IRON_BARS.get());
        this.copyBarsModel(ModBlocks.RUSTED_IRON_BARS.get(), ModBlocks.WAXED_RUSTED_IRON_BARS.get());

        this.createTrivialCube(ModBlocks.CUT_IRON.get());
        this.createTrivialCube(ModBlocks.EXPOSED_CUT_IRON.get());
        this.createTrivialCube(ModBlocks.WEATHERED_CUT_IRON.get());
        this.createTrivialCube(ModBlocks.RUSTED_CUT_IRON.get());

        this.copyModel(ModBlocks.CUT_IRON.get(), ModBlocks.WAXED_CUT_IRON.get());
        this.copyModel(ModBlocks.EXPOSED_CUT_IRON.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON.get());
        this.copyModel(ModBlocks.WEATHERED_CUT_IRON.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON.get());
        this.copyModel(ModBlocks.RUSTED_CUT_IRON.get(), ModBlocks.WAXED_RUSTED_CUT_IRON.get());

        this.copySlabModel(ModBlocks.CUT_IRON_SLAB.get(), ModBlocks.WAXED_CUT_IRON_SLAB.get());
        this.copySlabModel(ModBlocks.EXPOSED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON_SLAB.get());
        this.copySlabModel(ModBlocks.WEATHERED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON_SLAB.get());
        this.copySlabModel(ModBlocks.RUSTED_CUT_IRON_SLAB.get(), ModBlocks.WAXED_RUSTED_CUT_IRON_SLAB.get());

        this.copyStairModel(ModBlocks.CUT_IRON_STAIRS.get(), ModBlocks.WAXED_CUT_IRON_STAIRS.get());
        this.copyStairModel(ModBlocks.EXPOSED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_EXPOSED_CUT_IRON_STAIRS.get());
        this.copyStairModel(ModBlocks.WEATHERED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_WEATHERED_CUT_IRON_STAIRS.get());
        this.copyStairModel(ModBlocks.RUSTED_CUT_IRON_STAIRS.get(), ModBlocks.WAXED_RUSTED_CUT_COPPER_STAIRS.get());

        this.createDoor(ModBlocks.EXPOSED_IRON_DOOR.get());
        this.createDoor(ModBlocks.WEATHERED_IRON_DOOR.get());
        this.createDoor(ModBlocks.RUSTED_IRON_DOOR.get());

        this.createWaxedIronDoor();
        this.copyDoorModel(ModBlocks.EXPOSED_IRON_DOOR.get(), ModBlocks.WAXED_EXPOSED_IRON_DOOR.get());
        this.copyDoorModel(ModBlocks.WEATHERED_IRON_DOOR.get(), ModBlocks.WAXED_WEATHERED_IRON_DOOR.get());
        this.copyDoorModel(ModBlocks.RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_RUSTED_IRON_DOOR.get());

        this.createTrapdoor(ModBlocks.EXPOSED_IRON_TRAPDOOR.get());
        this.createTrapdoor(ModBlocks.WEATHERED_IRON_TRAPDOOR.get());
        this.createTrapdoor(ModBlocks.RUSTED_IRON_TRAPDOOR.get());

        this.createWaxedIronTrapdoor();
        this.copyTrapdoorModel(ModBlocks.EXPOSED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_EXPOSED_IRON_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.WEATHERED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_WEATHERED_IRON_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_RUSTED_IRON_TRAPDOOR.get());

        this.createTrivialCube(ModBlocks.SILVER_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK.get());

        this.createTrivialCube(ModBlocks.SILVER_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_SILVER.get());
        this.createDoor(ModBlocks.SILVER_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.SILVER_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SILVER_BLOCK.get());

        this.createTrivialCube(ModBlocks.TIN_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_TIN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TIN_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_TIN.get());
        this.createDoor(ModBlocks.TIN_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.TIN_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.TIN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TUNGSTEN_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_TUNGSTEN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TUNGSTEN_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_TUNGSTEN.get());
        this.createDoor(ModBlocks.TUNGSTEN_DOOR.get());
        this.createTrapdoor(ModBlocks.TUNGSTEN_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.TUNGSTEN_BLOCK.get());

        this.createTrivialCube(ModBlocks.PLATINUM_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_PLATINUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.PLATINUM_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_PLATINUM.get());
        this.createDoor(ModBlocks.PLATINUM_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.PLATINUM_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.PLATINUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.LEAD_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK.get());

        this.createTrivialCube(ModBlocks.LEAD_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_LEAD.get());
        this.createDoor(ModBlocks.LEAD_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.LEAD_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.LEAD_BLOCK.get());

        this.createTrivialCube(ModBlocks.URANIUM_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_URANIUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.URANIUM_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_URANIUM.get());
        this.createDoor(ModBlocks.URANIUM_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.URANIUM_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.URANIUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.ZINC_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_ZINC_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_ZINC_BLOCK.get());

        this.createTrivialCube(ModBlocks.ZINC_BLOCK.get());
        this.createTrivialCube(ModBlocks.EXPOSED_ZINC.get());
        this.createTrivialCube(ModBlocks.WEATHERED_ZINC.get());
        this.createTrivialCube(ModBlocks.CORRODED_ZINC.get());

        this.createTrivialCube(ModBlocks.CUT_ZINC.get());
        this.createTrivialCube(ModBlocks.EXPOSED_CUT_ZINC.get());
        this.createTrivialCube(ModBlocks.WEATHERED_CUT_ZINC.get());
        this.createTrivialCube(ModBlocks.CORRODED_CUT_ZINC.get());

        this.createDoor(ModBlocks.ZINC_DOOR.get());
        this.createDoor(ModBlocks.EXPOSED_ZINC_DOOR.get());
        this.createDoor(ModBlocks.WEATHERED_ZINC_DOOR.get());
        this.createDoor(ModBlocks.CORRODED_ZINC_DOOR.get());

        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.CORRODED_ZINC_TRAPDOOR.get());

        this.copyModel(ModBlocks.ZINC_BLOCK.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        this.copyModel(ModBlocks.EXPOSED_ZINC.get(), ModBlocks.WAXED_EXPOSED_ZINC.get());
        this.copyModel(ModBlocks.WEATHERED_ZINC.get(), ModBlocks.WAXED_WEATHERED_ZINC.get());
        this.copyModel(ModBlocks.CORRODED_ZINC.get(), ModBlocks.WAXED_CORRODED_ZINC.get());

        this.copyModel(ModBlocks.CUT_ZINC.get(), ModBlocks.WAXED_CUT_ZINC.get());
        this.copyModel(ModBlocks.EXPOSED_CUT_ZINC.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC.get());
        this.copyModel(ModBlocks.WEATHERED_CUT_ZINC.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC.get());
        this.copyModel(ModBlocks.CORRODED_CUT_ZINC.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC.get());

        this.copySlabModel(ModBlocks.CUT_ZINC_SLAB.get(), ModBlocks.WAXED_CUT_ZINC_SLAB.get());
        this.copySlabModel(ModBlocks.EXPOSED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC_SLAB.get());
        this.copySlabModel(ModBlocks.WEATHERED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC_SLAB.get());
        this.copySlabModel(ModBlocks.CORRODED_CUT_ZINC_SLAB.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC_SLAB.get());

        this.copyStairModel(ModBlocks.CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_CUT_ZINC_STAIRS.get());
        this.copyStairModel(ModBlocks.EXPOSED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_EXPOSED_CUT_ZINC_STAIRS.get());
        this.copyStairModel(ModBlocks.WEATHERED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_WEATHERED_CUT_ZINC_STAIRS.get());
        this.copyStairModel(ModBlocks.CORRODED_CUT_ZINC_STAIRS.get(), ModBlocks.WAXED_CORRODED_CUT_ZINC_STAIRS.get());

        this.copyDoorModel(ModBlocks.ZINC_DOOR.get(), ModBlocks.WAXED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.EXPOSED_ZINC_DOOR.get(), ModBlocks.WAXED_EXPOSED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.WEATHERED_ZINC_DOOR.get(), ModBlocks.WAXED_WEATHERED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_CORRODED_ZINC_DOOR.get());

        this.copyTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.WAXED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get());

        this.createTrivialCube(ModBlocks.CUT_GOLD.get());
        this.createTrivialCube(ModBlocks.CUT_DIAMOND.get());
        this.createTrivialCube(ModBlocks.CUT_EMERALD.get());
        this.createTrivialCube(ModBlocks.CUT_NETHERITE.get());

        this.createTrivialCube(ModBlocks.EXPOSED_IRON.get());
        this.createTrivialCube(ModBlocks.WEATHERED_IRON.get());
        this.createTrivialCube(ModBlocks.RUSTED_IRON.get());

        this.createWeightedPressurePlate(ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXPOSED_IRON.get());
        this.createWeightedPressurePlate(ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_IRON.get());
        this.createWeightedPressurePlate(ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.RUSTED_IRON.get());

        this.createWaxedIronPressurePlate();
        this.copyWeightedPressurePlateModel(ModBlocks.EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        this.createWaxedIronBlock();
        this.copyModel(ModBlocks.EXPOSED_IRON.get(), ModBlocks.WAXED_EXPOSED_IRON.get());
        this.copyModel(ModBlocks.WEATHERED_IRON.get(), ModBlocks.WAXED_WEATHERED_IRON.get());
        this.copyModel(ModBlocks.RUSTED_IRON.get(), ModBlocks.WAXED_RUSTED_IRON.get());

        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK);
        this.createWeightedPressurePlate(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.EXPOSED_COPPER);
        this.createWeightedPressurePlate(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.WEATHERED_COPPER);
        this.createWeightedPressurePlate(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.OXIDIZED_COPPER);

        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.ZINC_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXPOSED_ZINC.get());
        this.createWeightedPressurePlate(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WEATHERED_ZINC.get());
        this.createWeightedPressurePlate(ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.CORRODED_ZINC.get());

        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        this.createTrivialCube(ModBlocks.BRONZE_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_BRONZE.get());
        this.createDoor(ModBlocks.BRONZE_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.BRONZE_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get(), ModBlocks.BRONZE_BLOCK.get());

        this.createTrivialCube(ModBlocks.BRASS_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_BRASS.get());
        this.createDoor(ModBlocks.BRASS_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.BRASS_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get(), ModBlocks.BRASS_BLOCK.get());

        this.createTrivialCube(ModBlocks.STEEL_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_STEEL.get());
        this.createDoor(ModBlocks.STEEL_DOOR.get());
        this.createTrapdoor(ModBlocks.STEEL_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE.get(), ModBlocks.STEEL_BLOCK.get());

        this.createNonTemplateModelBlock(ModBlocks.NUCLEAR_WASTE.get());
        this.createNuke(ModBlocks.NUKE.get(), TexturedModel.ORIENTABLE);

        this.createCraftingTableLike(ModBlocks.SPRUCE_CRAFTING_TABLE.get(), Blocks.SPRUCE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.BIRCH_CRAFTING_TABLE.get(), Blocks.BIRCH_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.JUNGLE_CRAFTING_TABLE.get(), Blocks.JUNGLE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.ACACIA_CRAFTING_TABLE.get(), Blocks.ACACIA_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.DARK_OAK_CRAFTING_TABLE.get(), Blocks.DARK_OAK_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.CRIMSON_CRAFTING_TABLE.get(), Blocks.CRIMSON_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.WARPED_CRAFTING_TABLE.get(), Blocks.WARPED_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.MANGROVE_CRAFTING_TABLE.get(), Blocks.MANGROVE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.CHERRY_CRAFTING_TABLE.get(), Blocks.CHERRY_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.BAMBOO_CRAFTING_TABLE.get(), Blocks.BAMBOO_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.PALE_OAK_CRAFTING_TABLE.get(), Blocks.PALE_OAK_PLANKS, TextureMapping::craftingTable);

        this.createCustomCartographyTable(ModBlocks.OAK_CARTOGRAPHY_TABLE.get(), Blocks.OAK_PLANKS);
        this.createCustomCartographyTable(ModBlocks.SPRUCE_CARTOGRAPHY_TABLE.get(), Blocks.SPRUCE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.BIRCH_CARTOGRAPHY_TABLE.get(), Blocks.BIRCH_PLANKS);
        this.createCustomCartographyTable(ModBlocks.JUNGLE_CARTOGRAPHY_TABLE.get(), Blocks.JUNGLE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.ACACIA_CARTOGRAPHY_TABLE.get(), Blocks.ACACIA_PLANKS);
        this.createCustomCartographyTable(ModBlocks.CRIMSON_CARTOGRAPHY_TABLE.get(), Blocks.CRIMSON_PLANKS);
        this.createCustomCartographyTable(ModBlocks.WARPED_CARTOGRAPHY_TABLE.get(), Blocks.WARPED_PLANKS);
        this.createCustomCartographyTable(ModBlocks.MANGROVE_CARTOGRAPHY_TABLE.get(), Blocks.MANGROVE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.CHERRY_CARTOGRAPHY_TABLE.get(), Blocks.CHERRY_PLANKS);
        this.createCustomCartographyTable(ModBlocks.BAMBOO_CARTOGRAPHY_TABLE.get(), Blocks.BAMBOO_PLANKS);
        this.createCustomCartographyTable(ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE.get(), Blocks.PALE_OAK_PLANKS);

        this.createCraftingTableLike(ModBlocks.OAK_FLETCHING_TABLE.get(), Blocks.OAK_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.SPRUCE_FLETCHING_TABLE.get(), Blocks.SPRUCE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.BIRCH_FLETCHING_TABLE.get(), Blocks.BIRCH_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.JUNGLE_FLETCHING_TABLE.get(), Blocks.JUNGLE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.ACACIA_FLETCHING_TABLE.get(), Blocks.ACACIA_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.DARK_OAK_FLETCHING_TABLE.get(), Blocks.DARK_OAK_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.CRIMSON_FLETCHING_TABLE.get(), Blocks.CRIMSON_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.WARPED_FLETCHING_TABLE.get(), Blocks.WARPED_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.MANGROVE_FLETCHING_TABLE.get(), Blocks.MANGROVE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.CHERRY_FLETCHING_TABLE.get(), Blocks.CHERRY_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.BAMBOO_FLETCHING_TABLE.get(), Blocks.BAMBOO_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.PALE_OAK_FLETCHING_TABLE.get(), Blocks.PALE_OAK_PLANKS, TextureMapping::fletchingTable);

        this.createCustomSmithingTable(ModBlocks.OAK_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.SPRUCE_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.BIRCH_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.JUNGLE_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.ACACIA_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.DARK_OAK_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.CRIMSON_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.WARPED_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.CHERRY_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.BAMBOO_SMITHING_TABLE.get());
        this.createCustomSmithingTable(ModBlocks.PALE_OAK_SMITHING_TABLE.get());

        this.createCustomGrindstone(ModBlocks.OAK_GRINDSTONE.get(), Blocks.OAK_LOG);
        this.createCustomGrindstone(ModBlocks.SPRUCE_GRINDSTONE.get(), Blocks.SPRUCE_LOG);
        this.createCustomGrindstone(ModBlocks.BIRCH_GRINDSTONE.get(), Blocks.BIRCH_LOG);
        this.createCustomGrindstone(ModBlocks.JUNGLE_GRINDSTONE.get(), Blocks.JUNGLE_LOG);
        this.createCustomGrindstone(ModBlocks.ACACIA_GRINDSTONE.get(), Blocks.ACACIA_LOG);
        this.createCustomGrindstone(ModBlocks.CRIMSON_GRINDSTONE.get(), Blocks.CRIMSON_STEM);
        this.createCustomGrindstone(ModBlocks.WARPED_GRINDSTONE.get(), Blocks.WARPED_STEM);
        this.createCustomGrindstone(ModBlocks.MANGROVE_GRINDSTONE.get(), Blocks.MANGROVE_LOG);
        this.createCustomGrindstone(ModBlocks.CHERRY_GRINDSTONE.get(), Blocks.CHERRY_LOG);
        this.createCustomGrindstone(ModBlocks.BAMBOO_GRINDSTONE.get(), Blocks.BAMBOO_BLOCK);
        this.createCustomGrindstone(ModBlocks.PALE_OAK_GRINDSTONE.get(), Blocks.PALE_OAK_LOG);

        this.createHorizontallyRotatedBlock(ModBlocks.SPRUCE_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.BIRCH_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.JUNGLE_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.ACACIA_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.DARK_OAK_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.CRIMSON_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.WARPED_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.MANGROVE_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.CHERRY_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.BAMBOO_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.PALE_OAK_LOOM.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.BLACKSTONE_FURNACE.get(), TexturedModel.ORIENTABLE_ONLY_TOP);
        this.createFurnace(ModBlocks.DEEPSLATE_FURNACE.get(), TexturedModel.ORIENTABLE_ONLY_TOP);

        this.createFurnace(ModBlocks.SPRUCE_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.OAK_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.SPRUCE_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.OAK_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.SPRUCE_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.BLACKSTONE_BLAST_FURNACE.get(), TexturedModel.ORIENTABLE_ONLY_TOP);
        this.createFurnace(ModBlocks.DEEPSLATE_BLAST_FURNACE.get(), TexturedModel.ORIENTABLE_ONLY_TOP);

        this.createCampfires(ModBlocks.SPRUCE_CAMPFIRE.get(), ModBlocks.SPRUCE_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.BIRCH_CAMPFIRE.get(), ModBlocks.BIRCH_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.JUNGLE_CAMPFIRE.get(), ModBlocks.JUNGLE_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.ACACIA_CAMPFIRE.get(), ModBlocks.ACACIA_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.DARK_OAK_CAMPFIRE.get(), ModBlocks.DARK_OAK_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.CRIMSON_CAMPFIRE.get(), ModBlocks.CRIMSON_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.WARPED_CAMPFIRE.get(), ModBlocks.WARPED_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.MANGROVE_CAMPFIRE.get(), ModBlocks.MANGROVE_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.CHERRY_CAMPFIRE.get(), ModBlocks.CHERRY_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.BAMBOO_CAMPFIRE.get(), ModBlocks.BAMBOO_SOUL_CAMPFIRE.get());
        this.createCampfires(ModBlocks.PALE_OAK_CAMPFIRE.get(), ModBlocks.PALE_OAK_SOUL_CAMPFIRE.get());

        this.registerSimpleItemModel(ModItems.OAK_CAMPFIRE.get(), Identifier.parse("minecraft:item/campfire"));
        this.registerSimpleItemModel(ModItems.OAK_SOUL_CAMPFIRE.get(), Identifier.parse("minecraft:item/soul_campfire"));

        this.createBeeNest(ModBlocks.SPRUCE_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.BIRCH_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.JUNGLE_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.ACACIA_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.DARK_OAK_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.CRIMSON_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.WARPED_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.MANGROVE_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.CHERRY_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.BAMBOO_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.PALE_OAK_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);

        this.itemModelOutput.accept(ModItems.OAK_BEEHIVE.get(), ItemModelUtils.selectBlockItemProperty(BeehiveBlock.HONEY_LEVEL, ItemModelUtils.plainModel(Identifier.withDefaultNamespace("block/beehive_empty")), Map.of(5, ItemModelUtils.plainModel(Identifier.withDefaultNamespace("block/beehive_honey")))));

        this.createCustomBookshelf(ModBlocks.SPRUCE_BOOKSHELF.get(), Blocks.SPRUCE_PLANKS);
        this.createCustomBookshelf(ModBlocks.BIRCH_BOOKSHELF.get(), Blocks.BIRCH_PLANKS);
        this.createCustomBookshelf(ModBlocks.JUNGLE_BOOKSHELF.get(), Blocks.JUNGLE_PLANKS);
        this.createCustomBookshelf(ModBlocks.ACACIA_BOOKSHELF.get(), Blocks.ACACIA_PLANKS);
        this.createCustomBookshelf(ModBlocks.DARK_OAK_BOOKSHELF.get(), Blocks.DARK_OAK_PLANKS);
        this.createCustomBookshelf(ModBlocks.CRIMSON_BOOKSHELF.get(), Blocks.CRIMSON_PLANKS);
        this.createCustomBookshelf(ModBlocks.WARPED_BOOKSHELF.get(), Blocks.WARPED_PLANKS);
        this.createCustomBookshelf(ModBlocks.MANGROVE_BOOKSHELF.get(), Blocks.MANGROVE_PLANKS);
        this.createCustomBookshelf(ModBlocks.CHERRY_BOOKSHELF.get(), Blocks.CHERRY_PLANKS);
        this.createCustomBookshelf(ModBlocks.BAMBOO_BOOKSHELF.get(), Blocks.BAMBOO_PLANKS);
        this.createCustomBookshelf(ModBlocks.PALE_OAK_BOOKSHELF.get(), Blocks.PALE_OAK_PLANKS);

        this.createCustomChiseledBookshelf(ModBlocks.SPRUCE_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.BIRCH_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.JUNGLE_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.ACACIA_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.DARK_OAK_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.CRIMSON_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.WARPED_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.MANGROVE_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.CHERRY_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.BAMBOO_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(ModBlocks.PALE_OAK_CHISELED_BOOKSHELF.get());

        this.registerSimpleItemModel(ModItems.OAK_CHISELED_BOOKSHELF.get(), Identifier.parse("minecraft:block/chiseled_bookshelf_inventory"));

        this.createLectern(ModBlocks.SPRUCE_LECTERN.get(), Blocks.SPRUCE_PLANKS);
        this.createLectern(ModBlocks.BIRCH_LECTERN.get(), Blocks.BIRCH_PLANKS);
        this.createLectern(ModBlocks.JUNGLE_LECTERN.get(), Blocks.JUNGLE_PLANKS);
        this.createLectern(ModBlocks.ACACIA_LECTERN.get(), Blocks.ACACIA_PLANKS);
        this.createLectern(ModBlocks.DARK_OAK_LECTERN.get(), Blocks.DARK_OAK_PLANKS);
        this.createLectern(ModBlocks.CRIMSON_LECTERN.get(), Blocks.CRIMSON_PLANKS);
        this.createLectern(ModBlocks.WARPED_LECTERN.get(), Blocks.WARPED_PLANKS);
        this.createLectern(ModBlocks.MANGROVE_LECTERN.get(), Blocks.MANGROVE_PLANKS);
        this.createLectern(ModBlocks.CHERRY_LECTERN.get(), Blocks.CHERRY_PLANKS);
        this.createLectern(ModBlocks.BAMBOO_LECTERN.get(), Blocks.BAMBOO_PLANKS);
        this.createLectern(ModBlocks.PALE_OAK_LECTERN.get(), Blocks.PALE_OAK_PLANKS);

        this.createCustomBrewingStand(ModBlocks.BLACKSTONE_BREWING_STAND.get());
        this.createCustomBrewingStand(ModBlocks.DEEPSLATE_BREWING_STAND.get());

        this.registerSimpleItemModel(ModItems.STONE_BREWING_STAND.get(), Identifier.parse("minecraft:item/brewing_stand"));

        this.createCustomBarrel(ModBlocks.OAK_BARREL.get());
        this.createCustomBarrel(ModBlocks.BIRCH_BARREL.get());
        this.createCustomBarrel(ModBlocks.JUNGLE_BARREL.get());
        this.createCustomBarrel(ModBlocks.ACACIA_BARREL.get());
        this.createCustomBarrel(ModBlocks.DARK_OAK_BARREL.get());
        this.createCustomBarrel(ModBlocks.CRIMSON_BARREL.get());
        this.createCustomBarrel(ModBlocks.WARPED_BARREL.get());
        this.createCustomBarrel(ModBlocks.MANGROVE_BARREL.get());
        this.createCustomBarrel(ModBlocks.CHERRY_BARREL.get());
        this.createCustomBarrel(ModBlocks.BAMBOO_BARREL.get());
        this.createCustomBarrel(ModBlocks.PALE_OAK_BARREL.get());

        this.createCustomDispenserBlock(ModBlocks.BLACKSTONE_DISPENSER.get(), ModBlocks.BLACKSTONE_FURNACE.get());
        this.createCustomDispenserBlock(ModBlocks.DEEPSLATE_DISPENSER.get(), ModBlocks.DEEPSLATE_FURNACE.get());

        this.createCustomDispenserBlock(ModBlocks.BLACKSTONE_DROPPER.get(), ModBlocks.BLACKSTONE_FURNACE.get());
        this.createCustomDispenserBlock(ModBlocks.DEEPSLATE_DROPPER.get(), ModBlocks.DEEPSLATE_FURNACE.get());

        this.createCustomObserver(ModBlocks.BLACKSTONE_OBSERVER.get());
        this.createCustomObserver(ModBlocks.DEEPSLATE_OBSERVER.get());

        this.createCustomCrafterBlock(ModBlocks.SPRUCE_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.BIRCH_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.JUNGLE_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.ACACIA_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.DARK_OAK_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.CRIMSON_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.WARPED_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.MANGROVE_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.CHERRY_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.BAMBOO_CRAFTER.get());
        this.createCustomCrafterBlock(ModBlocks.PALE_OAK_CRAFTER.get());

        this.createCustomChests();

        this.createTrivialCube(ModBlocks.OAK_MOSAIC.get());
        this.createTrivialCube(ModBlocks.SPRUCE_MOSAIC.get());
        this.createTrivialCube(ModBlocks.BIRCH_MOSAIC.get());
        this.createTrivialCube(ModBlocks.JUNGLE_MOSAIC.get());
        this.createTrivialCube(ModBlocks.ACACIA_MOSAIC.get());
        this.createTrivialCube(ModBlocks.DARK_OAK_MOSAIC.get());
        this.createTrivialCube(ModBlocks.CRIMSON_MOSAIC.get());
        this.createTrivialCube(ModBlocks.WARPED_MOSAIC.get());
        this.createTrivialCube(ModBlocks.MANGROVE_MOSAIC.get());
        this.createTrivialCube(ModBlocks.CHERRY_MOSAIC.get());
        this.createTrivialCube(ModBlocks.PALE_OAK_MOSAIC.get());

        this.createTrivialCube(ModBlocks.STONE_TILES.get());
        this.createTrivialCube(ModBlocks.MOSSY_STONE_TILES.get());
        this.createTrivialCube(ModBlocks.CRACKED_STONE_TILES.get());

        this.createCopperChain(ModBlocks.EXPOSED_IRON_CHAIN.get(), ModBlocks.WAXED_EXPOSED_IRON_CHAIN.get());
        this.createCopperChain(ModBlocks.WEATHERED_IRON_CHAIN.get(), ModBlocks.WAXED_WEATHERED_IRON_CHAIN.get());
        this.createCopperChain(ModBlocks.RUSTED_IRON_CHAIN.get(), ModBlocks.WAXED_RUSTED_IRON_CHAIN.get());
        this.createWaxedIronChain();
        this.createCopperChainItem(ModItems.EXPOSED_IRON_CHAIN.get(), ModItems.WAXED_EXPOSED_IRON_CHAIN.get());
        this.createCopperChainItem(ModItems.WEATHERED_IRON_CHAIN.get(), ModItems.WAXED_WEATHERED_IRON_CHAIN.get());
        this.createCopperChainItem(ModItems.RUSTED_IRON_CHAIN.get(), ModItems.WAXED_RUSTED_IRON_CHAIN.get());

        this.createTrivialCube(ModBlocks.OBSIDIAN_BRICKS.get());
        this.createTrivialCube(ModBlocks.CRYING_OBSIDIAN_BRICKS.get());

        this.createTrivialCube(ModBlocks.COAL_BRICKS.get());
        this.createTrivialCube(ModBlocks.CHARCOAL_BRICKS.get());

        this.createTrivialCube(ModBlocks.LAPIS_BRICKS.get());
        this.createTrivialCube(ModBlocks.SMOOTH_LAPIS.get());

        this.createTrivialCube(ModBlocks.SNOW_BRICKS.get());
        this.createTrivialCube(ModBlocks.ICE_BRICKS.get());
        this.createTrivialCube(ModBlocks.PACKED_ICE_BRICKS.get());
        this.createTrivialCube(ModBlocks.BLUE_ICE_BRICKS.get());

        this.createTrivialCube(ModBlocks.SCULK_BRICKS.get());
        this.createTrivialCube(ModBlocks.CUT_AMETHYST.get());

        this.createNormalTorch(ModBlocks.IRON_TORCH.get(), ModBlocks.IRON_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.ZINC_TORCH.get(), ModBlocks.ZINC_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.SILVER_TORCH.get(), ModBlocks.SILVER_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.TIN_TORCH.get(), ModBlocks.TIN_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.TUNGSTEN_TORCH.get(), ModBlocks.TUNGSTEN_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.PLATINUM_TORCH.get(), ModBlocks.PLATINUM_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.GOLD_TORCH.get(), ModBlocks.GOLD_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.LEAD_TORCH.get(), ModBlocks.LEAD_WALL_TORCH.get());
        this.createNormalTorch(ModBlocks.URANIUM_TORCH.get(), ModBlocks.URANIUM_WALL_TORCH.get());

        this.createWaxedIronLantern();
        this.createCopperLantern(ModBlocks.EXPOSED_IRON_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_LANTERN.get());
        this.createCopperLantern(ModBlocks.WEATHERED_IRON_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_LANTERN.get());
        this.createCopperLantern(ModBlocks.RUSTED_IRON_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_LANTERN.get());

        this.createWaxedIronSoulLantern();
        this.createCopperLantern(ModBlocks.EXPOSED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_SOUL_LANTERN.get());
        this.createCopperLantern(ModBlocks.WEATHERED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_SOUL_LANTERN.get());
        this.createCopperLantern(ModBlocks.RUSTED_IRON_SOUL_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_SOUL_LANTERN.get());

        this.createCopperLantern(ModBlocks.IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_IRON_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.EXPOSED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_EXPOSED_IRON_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.WEATHERED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_WEATHERED_IRON_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.RUSTED_IRON_FIRE_LANTERN.get(), ModBlocks.WAXED_RUSTED_IRON_FIRE_LANTERN.get());

        this.createCopperLantern(ModBlocks.COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_COPPER_SOUL_LANTERN.get());
        this.createCopperLantern(ModBlocks.EXPOSED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_EXPOSED_COPPER_SOUL_LANTERN.get());
        this.createCopperLantern(ModBlocks.WEATHERED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_WEATHERED_COPPER_SOUL_LANTERN.get());
        this.createCopperLantern(ModBlocks.OXIDIZED_COPPER_SOUL_LANTERN.get(), ModBlocks.WAXED_OXIDIZED_COPPER_SOUL_LANTERN.get());

        this.createCopperLantern(ModBlocks.COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_COPPER_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.EXPOSED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_EXPOSED_COPPER_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.WEATHERED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_WEATHERED_COPPER_FIRE_LANTERN.get());
        this.createCopperLantern(ModBlocks.OXIDIZED_COPPER_FIRE_LANTERN.get(), ModBlocks.WAXED_OXIDIZED_COPPER_FIRE_LANTERN.get());

        this.createCopperChain(ModBlocks.ZINC_CHAIN.get(), ModBlocks.WAXED_ZINC_CHAIN.get());
        this.createCopperChain(ModBlocks.EXPOSED_ZINC_CHAIN.get(), ModBlocks.WAXED_EXPOSED_ZINC_CHAIN.get());
        this.createCopperChain(ModBlocks.WEATHERED_ZINC_CHAIN.get(), ModBlocks.WAXED_WEATHERED_ZINC_CHAIN.get());
        this.createCopperChain(ModBlocks.CORRODED_ZINC_CHAIN.get(), ModBlocks.WAXED_CORRODED_ZINC_CHAIN.get());
        this.createCopperChainItem(ModItems.ZINC_CHAIN.get(), ModItems.WAXED_ZINC_CHAIN.get());
        this.createCopperChainItem(ModItems.EXPOSED_ZINC_CHAIN.get(), ModItems.WAXED_EXPOSED_ZINC_CHAIN.get());
        this.createCopperChainItem(ModItems.WEATHERED_ZINC_CHAIN.get(), ModItems.WAXED_WEATHERED_ZINC_CHAIN.get());
        this.createCopperChainItem(ModItems.CORRODED_ZINC_CHAIN.get(), ModItems.WAXED_CORRODED_ZINC_CHAIN.get());

        this.createCustomChain(ModBlocks.GOLD_CHAIN.get());
        this.createCustomChain(ModBlocks.NETHERITE_CHAIN.get());
        this.createCustomChain(ModBlocks.SILVER_CHAIN.get());
        this.createCustomChain(ModBlocks.TIN_CHAIN.get());
        this.createCustomChain(ModBlocks.TUNGSTEN_CHAIN.get());
        this.createCustomChain(ModBlocks.PLATINUM_CHAIN.get());
        this.createCustomChain(ModBlocks.LEAD_CHAIN.get());
        this.createCustomChain(ModBlocks.URANIUM_CHAIN.get());
        this.createCustomChain(ModBlocks.BRONZE_CHAIN.get());
        this.createCustomChain(ModBlocks.BRASS_CHAIN.get());
        this.createCustomChain(ModBlocks.STEEL_CHAIN.get());

        this.createTrivialCube(ModBlocks.GABBRO.get());
        this.createTrivialCube(ModBlocks.POLISHED_GABBRO.get());
        this.createTrivialCube(ModBlocks.GABBRO_BRICKS.get());

        this.createTrivialCube(ModBlocks.RHYOLITE.get());
        this.createTrivialCube(ModBlocks.POLISHED_RHYOLITE.get());
        this.createTrivialCube(ModBlocks.RHYOLITE_BRICKS.get());

        this.createTrivialCube(ModBlocks.PUMICE.get());
        this.createTrivialCube(ModBlocks.POLISHED_PUMICE.get());
        this.createTrivialCube(ModBlocks.PUMICE_BRICKS.get());

        this.createThermalCalciteBlock(CompatModBlocks.POLISHED_THERMAL_CALCITE.get());
        this.createThermalCalciteBlock(CompatModBlocks.THERMAL_CALCITE_BRICKS.get());

        this.createTrivialCube(CompatModBlocks.CUT_ROSE_QUARTZ.get());

        this.createTrivialCube(CompatModBlocks.DEAD_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.EMPYREAL_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.FIR_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.HELLBARK_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.JACARANDA_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.MAGIC_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.MAHOGANY_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.MAPLE_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.PALM_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.PINE_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.REDWOOD_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.UMBRAN_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.WILLOW_MOSAIC.get());
        this.createTrivialCube(CompatModBlocks.ORIGIN_OAK_MOSAIC.get());

        this.createCraftingTableLike(CompatModBlocks.DEAD_CRAFTING_TABLE.get(), BOPBlocks.DEAD_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.EMPYREAL_CRAFTING_TABLE.get(), BOPBlocks.EMPYREAL_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.FIR_CRAFTING_TABLE.get(), BOPBlocks.FIR_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.HELLBARK_CRAFTING_TABLE.get(), BOPBlocks.HELLBARK_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.JACARANDA_CRAFTING_TABLE.get(), BOPBlocks.JACARANDA_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.MAGIC_CRAFTING_TABLE.get(), BOPBlocks.MAGIC_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.MAHOGANY_CRAFTING_TABLE.get(), BOPBlocks.MAHOGANY_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.MAPLE_CRAFTING_TABLE.get(), BOPBlocks.MAPLE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.PALM_CRAFTING_TABLE.get(), BOPBlocks.PALM_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.PINE_CRAFTING_TABLE.get(), BOPBlocks.PINE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.REDWOOD_CRAFTING_TABLE.get(), BOPBlocks.REDWOOD_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.UMBRAN_CRAFTING_TABLE.get(), BOPBlocks.UMBRAN_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.WILLOW_CRAFTING_TABLE.get(), BOPBlocks.WILLOW_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(CompatModBlocks.ORIGIN_OAK_CRAFTING_TABLE.get(), BOPBlocks.ORIGIN_OAK_PLANKS, TextureMapping::craftingTable);

        this.createCustomCartographyTable(CompatModBlocks.DEAD_CARTOGRAPHY_TABLE.get(), BOPBlocks.DEAD_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.EMPYREAL_CARTOGRAPHY_TABLE.get(), BOPBlocks.EMPYREAL_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.FIR_CARTOGRAPHY_TABLE.get(), BOPBlocks.FIR_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.HELLBARK_CARTOGRAPHY_TABLE.get(), BOPBlocks.HELLBARK_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.JACARANDA_CARTOGRAPHY_TABLE.get(), BOPBlocks.JACARANDA_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.MAGIC_CARTOGRAPHY_TABLE.get(), BOPBlocks.MAGIC_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.MAHOGANY_CARTOGRAPHY_TABLE.get(), BOPBlocks.MAHOGANY_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.MAPLE_CARTOGRAPHY_TABLE.get(), BOPBlocks.MAPLE_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.PALM_CARTOGRAPHY_TABLE.get(), BOPBlocks.PALM_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.PINE_CARTOGRAPHY_TABLE.get(), BOPBlocks.PINE_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.REDWOOD_CARTOGRAPHY_TABLE.get(), BOPBlocks.REDWOOD_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.UMBRAN_CARTOGRAPHY_TABLE.get(), BOPBlocks.UMBRAN_PLANKS);
        this.createCustomCartographyTable(CompatModBlocks.WILLOW_CARTOGRAPHY_TABLE.get(), BOPBlocks.WILLOW_PLANKS);

        this.createCraftingTableLike(CompatModBlocks.DEAD_FLETCHING_TABLE.get(), BOPBlocks.DEAD_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.EMPYREAL_FLETCHING_TABLE.get(), BOPBlocks.EMPYREAL_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.FIR_FLETCHING_TABLE.get(), BOPBlocks.FIR_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.HELLBARK_FLETCHING_TABLE.get(), BOPBlocks.HELLBARK_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.JACARANDA_FLETCHING_TABLE.get(), BOPBlocks.JACARANDA_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.MAGIC_FLETCHING_TABLE.get(), BOPBlocks.MAGIC_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.MAHOGANY_FLETCHING_TABLE.get(), BOPBlocks.MAHOGANY_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.MAPLE_FLETCHING_TABLE.get(), BOPBlocks.MAPLE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.PALM_FLETCHING_TABLE.get(), BOPBlocks.PALM_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.PINE_FLETCHING_TABLE.get(), BOPBlocks.PINE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.REDWOOD_FLETCHING_TABLE.get(), BOPBlocks.REDWOOD_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.UMBRAN_FLETCHING_TABLE.get(), BOPBlocks.UMBRAN_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(CompatModBlocks.WILLOW_FLETCHING_TABLE.get(), BOPBlocks.WILLOW_PLANKS, TextureMapping::fletchingTable);

        this.createBeeNest(CompatModBlocks.DEAD_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.EMPYREAL_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.FIR_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.HELLBARK_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.JACARANDA_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.MAGIC_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.MAHOGANY_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.MAPLE_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.PALM_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.PINE_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.REDWOOD_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.UMBRAN_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(CompatModBlocks.WILLOW_BEEHIVE.get(), TextureMapping::orientableCubeSameEnds);

        this.createCustomBarrel(CompatModBlocks.DEAD_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.EMPYREAL_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.FIR_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.HELLBARK_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.JACARANDA_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.MAGIC_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.MAHOGANY_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.MAPLE_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.PALM_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.PINE_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.REDWOOD_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.UMBRAN_BARREL.get());
        this.createCustomBarrel(CompatModBlocks.WILLOW_BARREL.get());

        this.createLectern(CompatModBlocks.DEAD_LECTERN.get(), BOPBlocks.DEAD_PLANKS);
        this.createLectern(CompatModBlocks.EMPYREAL_LECTERN.get(), BOPBlocks.EMPYREAL_PLANKS);
        this.createLectern(CompatModBlocks.FIR_LECTERN.get(), BOPBlocks.FIR_PLANKS);
        this.createLectern(CompatModBlocks.HELLBARK_LECTERN.get(), BOPBlocks.HELLBARK_PLANKS);
        this.createLectern(CompatModBlocks.JACARANDA_LECTERN.get(), BOPBlocks.JACARANDA_PLANKS);
        this.createLectern(CompatModBlocks.MAGIC_LECTERN.get(), BOPBlocks.MAGIC_PLANKS);
        this.createLectern(CompatModBlocks.MAHOGANY_LECTERN.get(), BOPBlocks.MAHOGANY_PLANKS);
        this.createLectern(CompatModBlocks.MAPLE_LECTERN.get(), BOPBlocks.MAPLE_PLANKS);
        this.createLectern(CompatModBlocks.PALM_LECTERN.get(), BOPBlocks.PALM_PLANKS);
        this.createLectern(CompatModBlocks.PINE_LECTERN.get(), BOPBlocks.PINE_PLANKS);
        this.createLectern(CompatModBlocks.REDWOOD_LECTERN.get(), BOPBlocks.REDWOOD_PLANKS);
        this.createLectern(CompatModBlocks.UMBRAN_LECTERN.get(), BOPBlocks.UMBRAN_PLANKS);
        this.createLectern(CompatModBlocks.WILLOW_LECTERN.get(), BOPBlocks.WILLOW_PLANKS);

        this.createCustomSmithingTable(CompatModBlocks.DEAD_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.EMPYREAL_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.FIR_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.HELLBARK_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.JACARANDA_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.MAGIC_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.MAHOGANY_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.MAPLE_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.PALM_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.PINE_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.REDWOOD_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.UMBRAN_SMITHING_TABLE.get());
        this.createCustomSmithingTable(CompatModBlocks.WILLOW_SMITHING_TABLE.get());

        this.createCustomBookshelf(CompatModBlocks.DEAD_BOOKSHELF.get(), BOPBlocks.DEAD_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.EMPYREAL_BOOKSHELF.get(), BOPBlocks.EMPYREAL_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.FIR_BOOKSHELF.get(), BOPBlocks.FIR_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.HELLBARK_BOOKSHELF.get(), BOPBlocks.HELLBARK_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.JACARANDA_BOOKSHELF.get(), BOPBlocks.JACARANDA_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.MAGIC_BOOKSHELF.get(), BOPBlocks.MAGIC_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.MAHOGANY_BOOKSHELF.get(), BOPBlocks.MAHOGANY_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.MAPLE_BOOKSHELF.get(), BOPBlocks.MAPLE_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.PALM_BOOKSHELF.get(), BOPBlocks.PALM_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.PINE_BOOKSHELF.get(), BOPBlocks.PINE_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.REDWOOD_BOOKSHELF.get(), BOPBlocks.REDWOOD_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.UMBRAN_BOOKSHELF.get(), BOPBlocks.UMBRAN_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.WILLOW_BOOKSHELF.get(), BOPBlocks.WILLOW_PLANKS);
        this.createCustomBookshelf(CompatModBlocks.ORIGIN_OAK_BOOKSHELF.get(), BOPBlocks.ORIGIN_OAK_PLANKS);

        this.createCampfires(CompatModBlocks.DEAD_CAMPFIRE.get(), CompatModBlocks.DEAD_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.EMPYREAL_CAMPFIRE.get(), CompatModBlocks.EMPYREAL_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.FIR_CAMPFIRE.get(), CompatModBlocks.FIR_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.HELLBARK_CAMPFIRE.get(), CompatModBlocks.HELLBARK_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.JACARANDA_CAMPFIRE.get(), CompatModBlocks.JACARANDA_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.MAGIC_CAMPFIRE.get(), CompatModBlocks.MAGIC_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.MAHOGANY_CAMPFIRE.get(), CompatModBlocks.MAHOGANY_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.MAPLE_CAMPFIRE.get(), CompatModBlocks.MAPLE_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.PALM_CAMPFIRE.get(), CompatModBlocks.PALM_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.PINE_CAMPFIRE.get(), CompatModBlocks.PINE_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.REDWOOD_CAMPFIRE.get(), CompatModBlocks.REDWOOD_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.UMBRAN_CAMPFIRE.get(), CompatModBlocks.UMBRAN_SOUL_CAMPFIRE.get());
        this.createCampfires(CompatModBlocks.WILLOW_CAMPFIRE.get(), CompatModBlocks.WILLOW_SOUL_CAMPFIRE.get());

        this.createCustomGrindstone(CompatModBlocks.DEAD_GRINDSTONE.get(), BOPBlocks.DEAD_LOG);
        this.createCustomGrindstone(CompatModBlocks.EMPYREAL_GRINDSTONE.get(), BOPBlocks.EMPYREAL_LOG);
        this.createCustomGrindstone(CompatModBlocks.FIR_GRINDSTONE.get(), BOPBlocks.FIR_LOG);
        this.createCustomGrindstone(CompatModBlocks.HELLBARK_GRINDSTONE.get(), BOPBlocks.HELLBARK_LOG);
        this.createCustomGrindstone(CompatModBlocks.JACARANDA_GRINDSTONE.get(), BOPBlocks.JACARANDA_LOG);
        this.createCustomGrindstone(CompatModBlocks.MAGIC_GRINDSTONE.get(), BOPBlocks.MAGIC_LOG);
        this.createCustomGrindstone(CompatModBlocks.MAHOGANY_GRINDSTONE.get(), BOPBlocks.MAHOGANY_LOG);
        this.createCustomGrindstone(CompatModBlocks.MAPLE_GRINDSTONE.get(), BOPBlocks.MAPLE_LOG);
        this.createCustomGrindstone(CompatModBlocks.PALM_GRINDSTONE.get(), BOPBlocks.PALM_LOG);
        this.createCustomGrindstone(CompatModBlocks.PINE_GRINDSTONE.get(), BOPBlocks.PINE_LOG);
        this.createCustomGrindstone(CompatModBlocks.REDWOOD_GRINDSTONE.get(), BOPBlocks.REDWOOD_LOG);
        this.createCustomGrindstone(CompatModBlocks.UMBRAN_GRINDSTONE.get(), BOPBlocks.UMBRAN_LOG);
        this.createCustomGrindstone(CompatModBlocks.WILLOW_GRINDSTONE.get(), BOPBlocks.WILLOW_LOG);

        this.createCustomChiseledBookshelf(CompatModBlocks.DEAD_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.EMPYREAL_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.FIR_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.HELLBARK_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.JACARANDA_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.MAGIC_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.MAHOGANY_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.MAPLE_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.PALM_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.PINE_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.REDWOOD_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.UMBRAN_CHISELED_BOOKSHELF.get());
        this.createCustomChiseledBookshelf(CompatModBlocks.WILLOW_CHISELED_BOOKSHELF.get());

        this.createCustomCrafterBlock(CompatModBlocks.DEAD_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.EMPYREAL_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.FIR_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.HELLBARK_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.JACARANDA_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.MAGIC_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.MAHOGANY_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.MAPLE_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.PALM_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.PINE_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.REDWOOD_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.UMBRAN_CRAFTER.get());
        this.createCustomCrafterBlock(CompatModBlocks.WILLOW_CRAFTER.get());

        this.createFurnace(CompatModBlocks.DEAD_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.EMPYREAL_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.FIR_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.HELLBARK_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.JACARANDA_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAGIC_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAHOGANY_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAPLE_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PALM_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PINE_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.REDWOOD_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.UMBRAN_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.WILLOW_STONE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(CompatModBlocks.DEAD_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.EMPYREAL_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.FIR_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.HELLBARK_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.JACARANDA_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAGIC_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAHOGANY_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAPLE_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PALM_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PINE_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.REDWOOD_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.UMBRAN_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.WILLOW_BLACKSTONE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createFurnace(CompatModBlocks.DEAD_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.EMPYREAL_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.FIR_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.HELLBARK_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.JACARANDA_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAGIC_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAHOGANY_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.MAPLE_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PALM_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.PINE_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.REDWOOD_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.UMBRAN_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);
        this.createFurnace(CompatModBlocks.WILLOW_DEEPSLATE_SMOKER.get(), TexturedModel.ORIENTABLE);

        this.createHorizontallyRotatedBlock(CompatModBlocks.DEAD_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.EMPYREAL_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.FIR_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.HELLBARK_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.JACARANDA_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.MAGIC_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.MAHOGANY_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.MAPLE_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.PALM_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.PINE_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.REDWOOD_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.UMBRAN_LOOM.get(), TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(CompatModBlocks.WILLOW_LOOM.get(), TexturedModel.ORIENTABLE);

        this.createOriginOakChests();


        Stream.concat(ModBlockFamilies.getAllFamilies(), CompatModBlockFamilies.getAllFamilies())
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(
                        family ->
                        {
                            if (family.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_SOUL_SANDSTONE.get()) {
                                familyWithExistingFullBlock(family.getBaseBlock()).wall(ModBlocks.SOUL_SANDSTONE_WALL.get());
                                familyWithExistingFullBlock(family.getBaseBlock()).slab(ModBlocks.SOUL_SANDSTONE_SLAB.get());
                                familyWithExistingFullBlock(family.getBaseBlock()).stairs(ModBlocks.SOUL_SANDSTONE_STAIRS.get());
                                familyWithExistingFullBlock(family.getBaseBlock()).fence(ModBlocks.SOUL_SANDSTONE_FENCE.get());
                            } else if (family.getBaseBlock().getDescriptionId().contains("thermal")) {
                                thermalSlab(family.get(BlockFamily.Variant.SLAB), family.getBaseBlock());
                                thermalStairs(family.get(BlockFamily.Variant.STAIRS), family.getBaseBlock());
                                thermalWall(family.get(BlockFamily.Variant.WALL), family.getBaseBlock());
                                thermalFence(family.get(BlockFamily.Variant.FENCE), family.getBaseBlock());
                            } else {
                                familyWithExistingFullBlock(family.getBaseBlock()).generateFor(family);
                            }
                            System.out.println(family);
                        }
                );
    }
}
