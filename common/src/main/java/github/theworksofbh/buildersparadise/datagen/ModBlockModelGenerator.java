package github.theworksofbh.buildersparadise.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import github.theworksofbh.buildersparadise.blocks.ModBlockFamilies;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import github.theworksofbh.buildersparadise.renderers.ModChestSpecialRenderers;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.renderer.block.dispatch.multipart.CombinedCondition;
import net.minecraft.client.renderer.block.dispatch.multipart.Condition;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.CrafterBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ModBlockModelGenerator extends BlockModelGenerators {


    public ModBlockModelGenerator(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

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
        } else if (fullBlock == ModBlocks.SMOOTH_DEEPSLATE) {
            mapping = TexturedModel.CUBE.get(ModBlocks.SMOOTH_DEEPSLATE).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE_SLAB, "_side"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE, ""));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE, ""));
        } else if (fullBlock == ModBlocks.SOUL_SANDSTONE) {
            mapping = TexturedModel.CUBE_TOP_BOTTOM.get(ModBlocks.SOUL_SANDSTONE).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_bottom"));
        } else if (fullBlock == ModBlocks.CUT_SOUL_SANDSTONE) {
            mapping = TexturedModel.COLUMN.get(ModBlocks.CUT_SOUL_SANDSTONE).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CUT_SOUL_SANDSTONE, ""));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
        } else if (fullBlock == ModBlocks.SMOOTH_SOUL_SANDSTONE) {
            mapping = TexturedModel.CUBE.get(ModBlocks.CUT_SOUL_SANDSTONE).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
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
        } else if (fullBlock == ModBlocks.SMOOTH_SOUL_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
            mapping.put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
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
        this.createChest(ModBlocks.SPRUCE_CHEST, Blocks.SPRUCE_PLANKS, ModChestSpecialRenderers.SPRUCE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BIRCH_CHEST, Blocks.BIRCH_PLANKS, ModChestSpecialRenderers.BIRCH_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.JUNGLE_CHEST, Blocks.JUNGLE_PLANKS, ModChestSpecialRenderers.JUNGLE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.ACACIA_CHEST, Blocks.ACACIA_PLANKS, ModChestSpecialRenderers.ACACIA_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.DARK_OAK_CHEST, Blocks.DARK_OAK_PLANKS, ModChestSpecialRenderers.DARK_OAK_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CRIMSON_CHEST, Blocks.CRIMSON_PLANKS, ModChestSpecialRenderers.CRIMSON_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.WARPED_CHEST, Blocks.WARPED_PLANKS, ModChestSpecialRenderers.WARPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.MANGROVE_CHEST, Blocks.MANGROVE_PLANKS, ModChestSpecialRenderers.MANGROVE_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CHERRY_CHEST, Blocks.CHERRY_PLANKS, ModChestSpecialRenderers.CHERRY_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BAMBOO_CHEST, Blocks.BAMBOO_PLANKS, ModChestSpecialRenderers.BAMBOO_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.PALE_OAK_CHEST, Blocks.PALE_OAK_PLANKS, ModChestSpecialRenderers.PALE_OAK_CHEST_TEXTURE, true);

        this.createChest(ModBlocks.SPRUCE_TRAPPED_CHEST, Blocks.SPRUCE_PLANKS, ModChestSpecialRenderers.SPRUCE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BIRCH_TRAPPED_CHEST, Blocks.BIRCH_PLANKS, ModChestSpecialRenderers.BIRCH_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.JUNGLE_TRAPPED_CHEST, Blocks.JUNGLE_PLANKS, ModChestSpecialRenderers.JUNGLE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.ACACIA_TRAPPED_CHEST, Blocks.ACACIA_PLANKS, ModChestSpecialRenderers.ACACIA_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.DARK_OAK_TRAPPED_CHEST, Blocks.DARK_OAK_PLANKS, ModChestSpecialRenderers.DARK_OAK_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CRIMSON_TRAPPED_CHEST, Blocks.CRIMSON_PLANKS, ModChestSpecialRenderers.CRIMSON_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.WARPED_TRAPPED_CHEST, Blocks.WARPED_PLANKS, ModChestSpecialRenderers.WARPED_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.MANGROVE_TRAPPED_CHEST, Blocks.MANGROVE_PLANKS, ModChestSpecialRenderers.MANGROVE_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.CHERRY_TRAPPED_CHEST, Blocks.CHERRY_PLANKS, ModChestSpecialRenderers.CHERRY_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.BAMBOO_TRAPPED_CHEST, Blocks.BAMBOO_PLANKS, ModChestSpecialRenderers.BAMBOO_TRAPPED_CHEST_TEXTURE, true);
        this.createChest(ModBlocks.PALE_OAK_TRAPPED_CHEST, Blocks.PALE_OAK_PLANKS, ModChestSpecialRenderers.PALE_OAK_TRAPPED_CHEST_TEXTURE, true);
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
        this.registerSimpleItemModel(ModBlocks.IRON_BLOCK.waxed().unaffected(), Identifier.parse("minecraft:block/iron_block"));
        this.blockStateOutput.accept(
                createSimpleBlock(
                        ModBlocks.IRON_BLOCK.waxed().unaffected(),
                        plainVariant(Identifier.parse("minecraft:block/iron_block"))
                )
        );
    }

    public void createWaxedIronDoor() {
        this.registerSimpleItemModel(ModBlocks.IRON_DOOR.waxed().unaffected(), Identifier.parse("minecraft:item/iron_door"));
        this.blockStateOutput.accept(
                createDoor(
                        ModBlocks.IRON_DOOR.waxed().unaffected(),
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
        this.registerSimpleItemModel(ModBlocks.IRON_TRAPDOOR.waxed().unaffected(), Identifier.parse("minecraft:block/iron_trapdoor_bottom"));
        this.blockStateOutput.accept(
                createTrapdoor(
                        ModBlocks.IRON_TRAPDOOR.waxed().unaffected(),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_top")),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_bottom")),
                        plainVariant(Identifier.parse("minecraft:block/iron_trapdoor_open"))
                )
        );
    }

    public void createWaxedIronPressurePlate() {
        this.registerSimpleItemModel(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().unaffected(), Identifier.parse("minecraft:block/heavy_weighted_pressure_plate"));
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().unaffected())
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
        Material topOpen = TextureMapping.getBlockTexture(barrel, "_top_open");
        MultiVariant multivariant = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.create(barrel, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.get(barrel).updateTextures((mapping) -> mapping.put(TextureSlot.TOP, topOpen)).createWithSuffix(barrel, "_open", this.modelOutput));
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
                MultiPartGenerator.multiPart(ModBlocks.IRON_BARS.waxed().unaffected())
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
        this.registerSimpleItemModel(ModBlocks.IRON_BARS.waxed().unaffected(), Identifier.parse("minecraft:item/iron_bars"));
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
        TextureMapping texturemapping = (TextureMapping)textureMappingGetter.apply(craftingTableBlock, craftingTableMaterialBlock);
        this.blockStateOutput.accept(createSimpleBlock(craftingTableBlock, plainVariant(ModelTemplates.CUBE.create(craftingTableBlock, texturemapping, this.modelOutput))));
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
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log"))
                        .put(logSlot, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log")), modelTemplate)
                .createWithSuffix(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_off", modelOutput));

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
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log")
                                ).put(
                                        logSlot,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log")
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
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log")
                                ).put(
                                        logSlot,
                                        TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().orElseThrow(), "_log")
                                ).put(
                                        TextureSlot.FIRE,
                                        TextureMapping.getBlockTexture(Blocks.SOUL_CAMPFIRE, "_fire")
                                ),
                                this.modelOutput
                        )
                );

                multivariant1 = multiVariant2;
            }

            this.registerSimpleFlatItemModel(block);
            this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.LIT).select(false, multiVariant).select(true, multivariant1)).with(ROTATION_HORIZONTAL_FACING_ALT));
        }

    }

    public void createCustomBookshelf(Block bookshelfBlock, Block woodType) {
        TextureMapping texturemapping = TextureMapping.column(TextureMapping.getBlockTexture(bookshelfBlock), TextureMapping.getBlockTexture(woodType));
        MultiVariant multivariant = plainVariant(ModelTemplates.CUBE_COLUMN.create(bookshelfBlock, texturemapping, this.modelOutput));
        this.blockStateOutput.accept(createSimpleBlock(bookshelfBlock, multivariant));
    }

    public void createChiseledBookshelfTextureMapping(Block chiseledBookshelf) {
        Material topTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_top");
        Material sideTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_side");
        Material emptyFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_empty");
        Material occupiedFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_occupied");

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
        this.registerSimpleFlatItemModel(brewingStandBlock);
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(brewingStandBlock)
                        .with(plainVariant(ModelLocationUtils.getModelLocation(brewingStandBlock)))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_0, true),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_bottle0")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_1, true),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_bottle1")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_2, true),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_bottle2")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_0, false),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_empty0")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_1, false),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_empty1")))
                        .with(condition().term(BlockStateProperties.HAS_BOTTLE_2, false),
                                plainVariant(ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND, "_empty2"))));
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
        this.createAxisAlignedPillarBlockCustomModel(ModBlocks.IRON_CHAIN.weathering().unaffected(), plainVariant(Identifier.withDefaultNamespace("block/iron_chain")));
        this.registerSimpleItemModel(ModBlocks.IRON_CHAIN.weathering().unaffected(), Identifier.withDefaultNamespace("item/iron_chain"));
    }

    public void createWaxedIronLantern() {
        MultiVariant standing = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.LANTERN)
        );

        MultiVariant hanging = plainVariant(
                ModelLocationUtils.getModelLocation(Blocks.LANTERN, "_hanging")
        );

        this.itemModelOutput.accept(
                ModBlocks.IRON_LANTERN.waxed().unaffected().asItem(),
                ItemModelUtils.plainModel(
                        ModelLocationUtils.getModelLocation(Items.LANTERN)
                )
        );

        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.IRON_LANTERN.waxed().unaffected())
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
                ModBlocks.IRON_SOUL_LANTERN.waxed().unaffected().asItem(),
                ItemModelUtils.plainModel(
                        ModelLocationUtils.getModelLocation(Items.SOUL_LANTERN)
                )
        );

        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.IRON_SOUL_LANTERN.waxed().unaffected())
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
        this.registerSimpleItemModel(chain, identifier);
    }


    public void createSmoothDeepslateSlab() {
        TextureMapping texturemapping = TextureMapping.cube(ModBlocks.SMOOTH_DEEPSLATE);
        TextureMapping texturemapping1 = TextureMapping.column(TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE_SLAB, "_side"), texturemapping.get(TextureSlot.TOP));
        MultiVariant multivariant = plainVariant(ModelTemplates.SLAB_BOTTOM.create(ModBlocks.SMOOTH_DEEPSLATE_SLAB, texturemapping1, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(ModelTemplates.SLAB_TOP.create(ModBlocks.SMOOTH_DEEPSLATE_SLAB, texturemapping1, this.modelOutput));
        MultiVariant multivariant2 = plainVariant(ModelTemplates.CUBE_COLUMN.createWithOverride(ModBlocks.SMOOTH_DEEPSLATE_SLAB, "_double", texturemapping1, this.modelOutput));
        this.blockStateOutput.accept(createSlab(ModBlocks.SMOOTH_DEEPSLATE_SLAB, multivariant, multivariant1, multivariant2));
    }

    public void createTintedGlassPane(Block glassBlock, Block paneBlock) {
        TextureMapping texturemapping = TextureMapping.pane(glassBlock, paneBlock);
        MultiVariant multivariant = plainVariant(createModelWithAmbientOcclusionAndSuffix(paneBlock, "_post", texturemapping, this.modelOutput, "template_glass_pane_post"));
        MultiVariant multivariant1 = plainVariant(createModelWithAmbientOcclusionAndSuffix(paneBlock, "_side", texturemapping, this.modelOutput, "template_glass_pane_side"));
        MultiVariant multivariant2 = plainVariant(createModelWithAmbientOcclusionAndSuffix(paneBlock, "_side_alt", texturemapping, this.modelOutput, "template_glass_pane_side_alt"));
        MultiVariant multivariant3 = plainVariant(createModelWithAmbientOcclusionAndSuffix(paneBlock, "_noside", texturemapping, this.modelOutput, "template_glass_pane_noside"));
        MultiVariant multivariant4 = plainVariant(createModelWithAmbientOcclusionAndSuffix(paneBlock, "_noside_alt", texturemapping, this.modelOutput, "template_glass_pane_noside_alt"));
        Item item = paneBlock.asItem();
        this.registerSimpleItemModel(paneBlock, this.createFlatItemModelWithBlockTexture(item, glassBlock));
        this.blockStateOutput.accept(MultiPartGenerator.multiPart(paneBlock).with(multivariant).with(condition().term(BlockStateProperties.NORTH, true), multivariant1).with(condition().term(BlockStateProperties.EAST, true), multivariant1.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH, true), multivariant2).with(condition().term(BlockStateProperties.WEST, true), multivariant2.with(Y_ROT_90)).with(condition().term(BlockStateProperties.NORTH, false), multivariant3).with(condition().term(BlockStateProperties.EAST, false), multivariant4).with(condition().term(BlockStateProperties.SOUTH, false), multivariant4.with(Y_ROT_90)).with(condition().term(BlockStateProperties.WEST, false), multivariant3.with(Y_ROT_270)));
    }

    public void createTintedDoor(Block doorBlock) {
        TextureMapping texturemapping = TextureMapping.door(doorBlock);
        MultiVariant multivariant = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_bottom_left", texturemapping, this.modelOutput, "door_bottom_left"));
        MultiVariant multivariant1 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_bottom_left_open", texturemapping, this.modelOutput, "door_bottom_left_open"));
        MultiVariant multivariant2 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_bottom_right", texturemapping, this.modelOutput, "door_bottom_right"));
        MultiVariant multivariant3 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_bottom_right_open", texturemapping, this.modelOutput, "door_bottom_right_open"));
        MultiVariant multivariant4 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_top_left", texturemapping, this.modelOutput, "door_top_left"));
        MultiVariant multivariant5 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_top_left_open", texturemapping, this.modelOutput, "door_top_left_open"));
        MultiVariant multivariant6 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_top_right", texturemapping, this.modelOutput, "door_top_right"));
        MultiVariant multivariant7 = plainVariant(createModelWithAmbientOcclusionAndSuffix(doorBlock, "_top_right_open", texturemapping, this.modelOutput, "door_top_right_open"));
        this.registerSimpleFlatItemModel(doorBlock);
        this.blockStateOutput.accept(createDoor(doorBlock, multivariant, multivariant1, multivariant2, multivariant3, multivariant4, multivariant5, multivariant6, multivariant7));
    }

    public void createTintedOrientableTrapdoor(Block orientableTrapdoorBlock) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(orientableTrapdoorBlock);
        MultiVariant multivariant = plainVariant(createModelWithAmbientOcclusionAndSuffix(orientableTrapdoorBlock, "_top", texturemapping, this.modelOutput, "template_trapdoor_top"));
        Identifier identifier = createModelWithAmbientOcclusionAndSuffix(orientableTrapdoorBlock, "_bottom", texturemapping, this.modelOutput, "template_trapdoor_bottom");
        MultiVariant multivariant1 = plainVariant(createModelWithAmbientOcclusionAndSuffix(orientableTrapdoorBlock, "_open", texturemapping, this.modelOutput, "template_trapdoor_open"));
        this.blockStateOutput.accept(createOrientableTrapdoor(orientableTrapdoorBlock, multivariant, plainVariant(identifier), multivariant1));
        this.registerSimpleItemModel(orientableTrapdoorBlock, identifier);
    }

    public void copyOrientableTrapdoorModel(Block donor, Block acceptor) {
        MultiVariant top = plainVariant(ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.getDefaultModelLocation(donor));
        MultiVariant bottom = plainVariant(ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.getDefaultModelLocation(donor));
        MultiVariant open = plainVariant(ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.getDefaultModelLocation(donor));
        this.itemModelOutput.copy(donor.asItem(), acceptor.asItem());
        this.blockStateOutput.accept(createOrientableTrapdoor(acceptor, top, bottom, open));
    }

    public void createBlockEndingWithEne(Block ite, Block ene) {
        Identifier height2 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height2");
        Identifier height4 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height4");
        Identifier height6 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height6");
        Identifier height8 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height8");
        Identifier height10 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height10");
        Identifier height12 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height12");
        Identifier height14 = ModelLocationUtils.getModelLocation(Blocks.SNOW, "_height14");
        Identifier height16 = ModelLocationUtils.getModelLocation(ite);

        ModelTemplate modelTemplate2 = new ModelTemplate(Optional.of(height2), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate4 = new ModelTemplate(Optional.of(height4), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate6 = new ModelTemplate(Optional.of(height6), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate8 = new ModelTemplate(Optional.of(height8), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate10 = new ModelTemplate(Optional.of(height10), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate12 = new ModelTemplate(Optional.of(height12), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
        ModelTemplate modelTemplate14 = new ModelTemplate(Optional.of(height14), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);

        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate2)
                .createWithSuffix(ene, "_height2", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate4)
                .createWithSuffix(ene, "_height4", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate6)
                .createWithSuffix(ene, "_height6", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate8)
                .createWithSuffix(ene, "_height8", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate10)
                .createWithSuffix(ene, "_height10", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate12)
                .createWithSuffix(ene, "_height12", modelOutput));
        plainVariant(TexturedModel.createDefault(block -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(ite))
                        .put(TextureSlot.TEXTURE, TextureMapping.getBlockTexture(ite)), modelTemplate14)
                .createWithSuffix(ene, "_height14", modelOutput));

        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(ene).with(PropertyDispatch.initial(BlockStateProperties.LAYERS).generate((level) -> {
            MultiVariant var2;
            if (level < 8) {
                Block var10000 = ene;
                int var10001 = level;
                var2 = plainVariant(ModelLocationUtils.getModelLocation(var10000, "_height" + var10001 * 2));
            } else {
                var2 = plainVariant(height16);
            }

            return var2;
        })));
        this.registerSimpleItemModel(ene, ModelLocationUtils.getModelLocation(ene, "_height2"));
    }

    public Identifier createModelWithAmbientOcclusion(Identifier target, TextureMapping textures, BiConsumer<Identifier, ModelInstance> output, String modelType) {
        output.accept(target, () -> {
            JsonObject model = new JsonObject();

            model.addProperty("parent", "minecraft:block/" + modelType);
            model.addProperty("ambientocclusion", true);

            JsonObject textureObject = new JsonObject();

            for (TextureSlot slot : textures.getForced().toList()) {
                Material material = textures.get(slot);

                JsonElement value = Material.CODEC
                        .encodeStart(JsonOps.INSTANCE, material)
                        .getOrThrow();

                textureObject.add(slot.getId(), value);
            }

            if (!textureObject.isEmpty()) {
                model.add("textures", textureObject);
            }

            return model;
        });

        return target;
    }

    public Identifier createModelWithAmbientOcclusion(Block block, TextureMapping textures, BiConsumer<Identifier, ModelInstance> output, String modelType) {
        return this.createModelWithAmbientOcclusion(ModelLocationUtils.getModelLocation(block), textures, output, modelType);
    }

    public Identifier createModelWithAmbientOcclusionAndSuffix(Block block, String extraSuffix, TextureMapping textures, BiConsumer<Identifier, ModelInstance> output, String modelType) {
        return this.createModelWithAmbientOcclusion(ModelLocationUtils.getModelLocation(block, extraSuffix), textures, output, modelType);
    }

    @Override
    public void run() {
        this.createTrivialCube(ModBlocks.POLISHED_CALCITE);
        this.createTrivialCube(ModBlocks.POLISHED_DRIPSTONE);

        this.createTrivialCube(ModBlocks.POLISHED_GRANITE_BRICKS);
        this.createTrivialCube(ModBlocks.POLISHED_DIORITE_BRICKS);
        this.createTrivialCube(ModBlocks.POLISHED_ANDESITE_BRICKS);
        this.createTrivialCube(ModBlocks.CALCITE_BRICKS);
        this.createTrivialCube(ModBlocks.DRIPSTONE_BRICKS);
        this.createTrivialCube(ModBlocks.BASALT_BRICKS);

        this.createTrivialCube(ModBlocks.CHARCOAL_BLOCK);

        this.createTrivialCube(ModBlocks.ELDER_PRISMARINE);
        this.createTrivialCube(ModBlocks.ELDER_PRISMARINE_BRICKS);
        this.createTrivialCube(ModBlocks.DARK_ELDER_PRISMARINE);
        this.createTrivialCube(ModBlocks.ELDER_SEA_LANTERN);

        this.createTrivialBlock(ModBlocks.SOUL_SANDSTONE, TexturedModel.CUBE_TOP_BOTTOM.updateTexture(
                (mapping) -> mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_bottom"))
        ));
        this.createTrivialBlock(ModBlocks.CUT_SOUL_SANDSTONE, TexturedModel.COLUMN.updateTexture(
                (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CUT_SOUL_SANDSTONE))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
        ));
        this.createTrivialBlock(ModBlocks.CHISELED_SOUL_SANDSTONE, TexturedModel.COLUMN.updateTexture(
                (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
        ));
        this.createTrivialBlock(ModBlocks.SMOOTH_SOUL_SANDSTONE, TexturedModel.CUBE.updateTexture(
                (mapping) -> mapping.put(TextureSlot.ALL, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"))
        ));

        this.createDoor(ModBlocks.GOLD_DOOR);
        this.createTrapdoor(ModBlocks.GOLD_TRAPDOOR);
        this.createCustomPressurePlate(ModBlocks.PLAYER_ONLY_PRESSURE_PLATE, Blocks.NETHERITE_BLOCK);

        this.createDoor(ModBlocks.NETHERITE_DOOR);
        this.createOrientableTrapdoor(ModBlocks.NETHERITE_TRAPDOOR);

        this.createBarsBlock(ModBlocks.IRON_BARS.weathering().exposed());
        this.createBarsBlock(ModBlocks.IRON_BARS.weathering().weathered());
        this.createBarsBlock(ModBlocks.IRON_BARS.weathering().rusted());

        this.createWaxedIronBars();
        this.copyBarsModel(ModBlocks.IRON_BARS.weathering().exposed(), ModBlocks.IRON_BARS.waxed().exposed());
        this.copyBarsModel(ModBlocks.IRON_BARS.weathering().weathered(), ModBlocks.IRON_BARS.weathering().weathered());
        this.copyBarsModel(ModBlocks.IRON_BARS.weathering().rusted(), ModBlocks.IRON_BARS.weathering().rusted());

        this.createTrivialCube(ModBlocks.CUT_IRON.weathering().unaffected());
        this.createTrivialCube(ModBlocks.CUT_IRON.weathering().exposed());
        this.createTrivialCube(ModBlocks.CUT_IRON.weathering().weathered());
        this.createTrivialCube(ModBlocks.CUT_IRON.weathering().rusted());

        this.copyModel(ModBlocks.CUT_IRON.weathering().unaffected(), ModBlocks.CUT_IRON.waxed().unaffected());
        this.copyModel(ModBlocks.CUT_IRON.weathering().exposed(), ModBlocks.CUT_IRON.waxed().exposed());
        this.copyModel(ModBlocks.CUT_IRON.weathering().weathered(), ModBlocks.CUT_IRON.weathering().weathered());
        this.copyModel(ModBlocks.CUT_IRON.weathering().rusted(), ModBlocks.CUT_IRON.weathering().rusted());

        this.copySlabModel(ModBlocks.CUT_IRON_SLAB.weathering().unaffected(), ModBlocks.CUT_IRON_SLAB.waxed().unaffected());
        this.copySlabModel(ModBlocks.CUT_IRON_SLAB.weathering().exposed(), ModBlocks.CUT_IRON_SLAB.waxed().exposed());
        this.copySlabModel(ModBlocks.CUT_IRON_SLAB.weathering().weathered(), ModBlocks.CUT_IRON_SLAB.waxed().weathered());
        this.copySlabModel(ModBlocks.CUT_IRON_SLAB.weathering().rusted(), ModBlocks.CUT_IRON_SLAB.waxed().rusted());

        this.copyStairModel(ModBlocks.CUT_IRON_STAIRS.weathering().unaffected(), ModBlocks.CUT_IRON_STAIRS.waxed().unaffected());
        this.copyStairModel(ModBlocks.CUT_IRON_STAIRS.weathering().exposed(), ModBlocks.CUT_IRON_STAIRS.waxed().exposed());
        this.copyStairModel(ModBlocks.CUT_IRON_STAIRS.weathering().weathered(), ModBlocks.CUT_IRON_STAIRS.waxed().weathered());
        this.copyStairModel(ModBlocks.CUT_IRON_STAIRS.weathering().rusted(), ModBlocks.CUT_IRON_STAIRS.waxed().rusted());

        this.createDoor(ModBlocks.IRON_DOOR.weathering().exposed());
        this.createDoor(ModBlocks.IRON_DOOR.weathering().weathered());
        this.createDoor(ModBlocks.IRON_DOOR.weathering().rusted());

        this.createWaxedIronDoor();
        this.copyDoorModel(ModBlocks.IRON_DOOR.weathering().exposed(), ModBlocks.IRON_DOOR.waxed().exposed());
        this.copyDoorModel(ModBlocks.IRON_DOOR.weathering().weathered(), ModBlocks.IRON_DOOR.waxed().weathered());
        this.copyDoorModel(ModBlocks.IRON_DOOR.weathering().rusted(), ModBlocks.IRON_DOOR.waxed().rusted());

        this.createDoor(ModBlocks.IRON_TRAPDOOR.weathering().exposed());
        this.createDoor(ModBlocks.IRON_TRAPDOOR.weathering().weathered());
        this.createDoor(ModBlocks.IRON_TRAPDOOR.weathering().rusted());

        this.createWaxedIronTrapdoor();
        this.copyDoorModel(ModBlocks.IRON_TRAPDOOR.weathering().exposed(), ModBlocks.IRON_TRAPDOOR.waxed().exposed());
        this.copyDoorModel(ModBlocks.IRON_TRAPDOOR.weathering().weathered(), ModBlocks.IRON_TRAPDOOR.waxed().weathered());
        this.copyDoorModel(ModBlocks.IRON_TRAPDOOR.weathering().rusted(), ModBlocks.IRON_TRAPDOOR.waxed().rusted());

        this.createTrivialCube(ModBlocks.SILVER_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE);
        this.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK);

        this.createTrivialCube(ModBlocks.SILVER_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_SILVER);
        this.createDoor(ModBlocks.SILVER_DOOR);
        this.createOrientableTrapdoor(ModBlocks.SILVER_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModBlocks.SILVER_BLOCK);

        this.createTrivialCube(ModBlocks.TIN_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE);
        this.createTrivialCube(ModBlocks.RAW_TIN_BLOCK);

        this.createTrivialCube(ModBlocks.TIN_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_TIN);
        this.createDoor(ModBlocks.TIN_DOOR);
        this.createOrientableTrapdoor(ModBlocks.TIN_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModBlocks.TIN_BLOCK);

        this.createTrivialCube(ModBlocks.TUNGSTEN_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        this.createTrivialCube(ModBlocks.RAW_TUNGSTEN_BLOCK);

        this.createTrivialCube(ModBlocks.TUNGSTEN_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_TUNGSTEN);
        this.createDoor(ModBlocks.TUNGSTEN_DOOR);
        this.createTrapdoor(ModBlocks.TUNGSTEN_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.TUNGSTEN_BLOCK);

        this.createTrivialCube(ModBlocks.PLATINUM_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_PLATINUM_ORE);
        this.createTrivialCube(ModBlocks.RAW_PLATINUM_BLOCK);

        this.createTrivialCube(ModBlocks.PLATINUM_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_PLATINUM);
        this.createDoor(ModBlocks.PLATINUM_DOOR);
        this.createOrientableTrapdoor(ModBlocks.PLATINUM_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE, ModBlocks.PLATINUM_BLOCK);

        this.createTrivialCube(ModBlocks.LEAD_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE);
        this.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK);

        this.createTrivialCube(ModBlocks.LEAD_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_LEAD);
        this.createDoor(ModBlocks.LEAD_DOOR);
        this.createOrientableTrapdoor(ModBlocks.LEAD_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.LEAD_BLOCK);

        this.createTrivialCube(ModBlocks.URANIUM_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_URANIUM_ORE);
        this.createTrivialCube(ModBlocks.RAW_URANIUM_BLOCK);

        this.createTrivialCube(ModBlocks.URANIUM_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_URANIUM);
        this.createDoor(ModBlocks.URANIUM_DOOR);
        this.createOrientableTrapdoor(ModBlocks.URANIUM_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE, ModBlocks.URANIUM_BLOCK);

        this.createTrivialCube(ModBlocks.ZINC_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_ZINC_ORE);
        this.createTrivialCube(ModBlocks.RAW_ZINC_BLOCK);

        this.createTrivialCube(ModBlocks.ZINC_BLOCK.weathering().unaffected());
        this.createTrivialCube(ModBlocks.ZINC_BLOCK.weathering().exposed());
        this.createTrivialCube(ModBlocks.ZINC_BLOCK.weathering().weathered());
        this.createTrivialCube(ModBlocks.ZINC_BLOCK.weathering().corroded());

        this.createTrivialCube(ModBlocks.CUT_ZINC.weathering().unaffected());
        this.createTrivialCube(ModBlocks.CUT_ZINC.weathering().exposed());
        this.createTrivialCube(ModBlocks.CUT_ZINC.weathering().weathered());
        this.createTrivialCube(ModBlocks.CUT_ZINC.weathering().corroded());

        this.createDoor(ModBlocks.ZINC_DOOR.weathering().unaffected());
        this.createDoor(ModBlocks.ZINC_DOOR.weathering().exposed());
        this.createDoor(ModBlocks.ZINC_DOOR.weathering().weathered());
        this.createDoor(ModBlocks.ZINC_DOOR.weathering().corroded());

        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.weathering().unaffected());
        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.weathering().exposed());
        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.weathering().weathered());
        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.weathering().corroded());

        this.copyModel(ModBlocks.ZINC_BLOCK.weathering().unaffected(), ModBlocks.ZINC_BLOCK.waxed().unaffected());
        this.copyModel(ModBlocks.ZINC_BLOCK.weathering().exposed(), ModBlocks.ZINC_BLOCK.waxed().exposed());
        this.copyModel(ModBlocks.ZINC_BLOCK.weathering().weathered(), ModBlocks.ZINC_BLOCK.waxed().weathered());
        this.copyModel(ModBlocks.ZINC_BLOCK.weathering().corroded(), ModBlocks.ZINC_BLOCK.waxed().corroded());

        this.copyModel(ModBlocks.CUT_ZINC.weathering().unaffected(), ModBlocks.CUT_ZINC.waxed().unaffected());
        this.copyModel(ModBlocks.CUT_ZINC.weathering().exposed(), ModBlocks.CUT_ZINC.waxed().exposed());
        this.copyModel(ModBlocks.CUT_ZINC.weathering().weathered(), ModBlocks.CUT_ZINC.waxed().weathered());
        this.copyModel(ModBlocks.CUT_ZINC.weathering().corroded(), ModBlocks.CUT_ZINC.waxed().corroded());

        this.copySlabModel(ModBlocks.CUT_ZINC_SLAB.weathering().unaffected(), ModBlocks.CUT_ZINC_SLAB.waxed().unaffected());
        this.copySlabModel(ModBlocks.CUT_ZINC_SLAB.weathering().exposed(), ModBlocks.CUT_ZINC_SLAB.waxed().exposed());
        this.copySlabModel(ModBlocks.CUT_ZINC_SLAB.weathering().weathered(), ModBlocks.CUT_ZINC_SLAB.waxed().weathered());
        this.copySlabModel(ModBlocks.CUT_ZINC_SLAB.weathering().corroded(), ModBlocks.CUT_ZINC_SLAB.waxed().corroded());

        this.copyStairModel(ModBlocks.CUT_ZINC_STAIRS.weathering().unaffected(), ModBlocks.CUT_ZINC_STAIRS.waxed().unaffected());
        this.copyStairModel(ModBlocks.CUT_ZINC_STAIRS.weathering().exposed(), ModBlocks.CUT_ZINC_STAIRS.waxed().exposed());
        this.copyStairModel(ModBlocks.CUT_ZINC_STAIRS.weathering().weathered(), ModBlocks.CUT_ZINC_STAIRS.waxed().weathered());
        this.copyStairModel(ModBlocks.CUT_ZINC_STAIRS.weathering().corroded(), ModBlocks.CUT_ZINC_STAIRS.waxed().corroded());

        this.copyDoorModel(ModBlocks.ZINC_DOOR.weathering().unaffected(), ModBlocks.ZINC_DOOR.waxed().unaffected());
        this.copyDoorModel(ModBlocks.ZINC_DOOR.weathering().exposed(), ModBlocks.ZINC_DOOR.waxed().exposed());
        this.copyDoorModel(ModBlocks.ZINC_DOOR.weathering().weathered(), ModBlocks.ZINC_DOOR.waxed().weathered());
        this.copyDoorModel(ModBlocks.ZINC_DOOR.weathering().corroded(), ModBlocks.ZINC_DOOR.waxed().corroded());

        this.copyOrientableTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.weathering().unaffected(), ModBlocks.ZINC_TRAPDOOR.waxed().unaffected());
        this.copyOrientableTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.weathering().exposed(), ModBlocks.ZINC_TRAPDOOR.waxed().exposed());
        this.copyOrientableTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.weathering().weathered(), ModBlocks.ZINC_TRAPDOOR.waxed().weathered());
        this.copyOrientableTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.weathering().corroded(), ModBlocks.ZINC_TRAPDOOR.waxed().corroded());

        this.createTrivialCube(ModBlocks.CUT_GOLD);
        this.createTrivialCube(ModBlocks.CUT_DIAMOND);
        this.createTrivialCube(ModBlocks.CUT_EMERALD);
        this.createTrivialCube(ModBlocks.CUT_NETHERITE);

        this.createTrivialCube(ModBlocks.IRON_BLOCK.weathering().exposed());
        this.createTrivialCube(ModBlocks.IRON_BLOCK.weathering().weathered());
        this.createTrivialCube(ModBlocks.IRON_BLOCK.weathering().rusted());

        this.createWeightedPressurePlate(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), ModBlocks.IRON_BLOCK.weathering().exposed());
        this.createWeightedPressurePlate(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), ModBlocks.IRON_BLOCK.weathering().weathered());
        this.createWeightedPressurePlate(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().rusted(), ModBlocks.IRON_BLOCK.weathering().rusted());

        this.createWaxedIronPressurePlate();
        this.copyWeightedPressurePlateModel(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed());
        this.copyWeightedPressurePlateModel(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered());
        this.copyWeightedPressurePlateModel(ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().rusted(), ModBlocks.HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().rusted());

        this.createWaxedIronBlock();
        this.copyModel(ModBlocks.IRON_BLOCK.weathering().exposed(), ModBlocks.IRON_BLOCK.waxed().exposed());
        this.copyModel(ModBlocks.IRON_BLOCK.weathering().weathered(), ModBlocks.IRON_BLOCK.waxed().weathered());
        this.copyModel(ModBlocks.IRON_BLOCK.weathering().rusted(), ModBlocks.IRON_BLOCK.waxed().rusted());

        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), Blocks.COPPER_BLOCK.weathering().unaffected());
        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), Blocks.COPPER_BLOCK.weathering().exposed());
        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), Blocks.COPPER_BLOCK.weathering().weathered());
        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().oxidized(), Blocks.COPPER_BLOCK.weathering().oxidized());

        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.waxed().unaffected());
        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.waxed().exposed());
        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.waxed().weathered());
        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.weathering().oxidized(), ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.waxed().oxidized());

        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), ModBlocks.ZINC_BLOCK.weathering().unaffected());
        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), ModBlocks.ZINC_BLOCK.weathering().exposed());
        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), ModBlocks.ZINC_BLOCK.weathering().weathered());
        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().corroded(), ModBlocks.ZINC_BLOCK.weathering().corroded());

        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().unaffected(), ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().unaffected());
        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().exposed(), ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().exposed());
        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().weathered(), ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().weathered());
        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.weathering().corroded(), ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.waxed().corroded());

        this.createTrivialCube(ModBlocks.BRONZE_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_BRONZE);
        this.createDoor(ModBlocks.BRONZE_DOOR);
        this.createOrientableTrapdoor(ModBlocks.BRONZE_TRAPDOOR);
        this.createCustomPressurePlate(ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE, ModBlocks.BRONZE_BLOCK);

        this.createTrivialCube(ModBlocks.BRASS_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_BRASS);
        this.createDoor(ModBlocks.BRASS_DOOR);
        this.createOrientableTrapdoor(ModBlocks.BRASS_TRAPDOOR);
        this.createCustomPressurePlate(ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE, ModBlocks.BRASS_BLOCK);

        this.createTrivialCube(ModBlocks.STEEL_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_STEEL);
        this.createDoor(ModBlocks.STEEL_DOOR);
        this.createTrapdoor(ModBlocks.STEEL_TRAPDOOR);
        this.createCustomPressurePlate(ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE, ModBlocks.STEEL_BLOCK);

        this.createNonTemplateModelBlock(ModBlocks.NUCLEAR_WASTE);
        this.createNuke(ModBlocks.NUKE, TexturedModel.ORIENTABLE);

        this.createCraftingTableLike(ModBlocks.SPRUCE_CRAFTING_TABLE, Blocks.SPRUCE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.BIRCH_CRAFTING_TABLE, Blocks.BIRCH_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.JUNGLE_CRAFTING_TABLE, Blocks.JUNGLE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.ACACIA_CRAFTING_TABLE, Blocks.ACACIA_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.DARK_OAK_CRAFTING_TABLE, Blocks.DARK_OAK_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.CRIMSON_CRAFTING_TABLE, Blocks.CRIMSON_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.WARPED_CRAFTING_TABLE, Blocks.WARPED_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.MANGROVE_CRAFTING_TABLE, Blocks.MANGROVE_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.CHERRY_CRAFTING_TABLE, Blocks.CHERRY_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.BAMBOO_CRAFTING_TABLE, Blocks.BAMBOO_PLANKS, TextureMapping::craftingTable);
        this.createCraftingTableLike(ModBlocks.PALE_OAK_CRAFTING_TABLE, Blocks.PALE_OAK_PLANKS, TextureMapping::craftingTable);

        this.createCustomCartographyTable(ModBlocks.OAK_CARTOGRAPHY_TABLE, Blocks.OAK_PLANKS);
        this.createCustomCartographyTable(ModBlocks.SPRUCE_CARTOGRAPHY_TABLE, Blocks.SPRUCE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.BIRCH_CARTOGRAPHY_TABLE, Blocks.BIRCH_PLANKS);
        this.createCustomCartographyTable(ModBlocks.JUNGLE_CARTOGRAPHY_TABLE, Blocks.JUNGLE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.ACACIA_CARTOGRAPHY_TABLE, Blocks.ACACIA_PLANKS);
        this.createCustomCartographyTable(ModBlocks.CRIMSON_CARTOGRAPHY_TABLE, Blocks.CRIMSON_PLANKS);
        this.createCustomCartographyTable(ModBlocks.WARPED_CARTOGRAPHY_TABLE, Blocks.WARPED_PLANKS);
        this.createCustomCartographyTable(ModBlocks.MANGROVE_CARTOGRAPHY_TABLE, Blocks.MANGROVE_PLANKS);
        this.createCustomCartographyTable(ModBlocks.CHERRY_CARTOGRAPHY_TABLE, Blocks.CHERRY_PLANKS);
        this.createCustomCartographyTable(ModBlocks.BAMBOO_CARTOGRAPHY_TABLE, Blocks.BAMBOO_PLANKS);
        this.createCustomCartographyTable(ModBlocks.PALE_OAK_CARTOGRAPHY_TABLE, Blocks.PALE_OAK_PLANKS);

        this.createCraftingTableLike(ModBlocks.OAK_FLETCHING_TABLE, Blocks.OAK_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.SPRUCE_FLETCHING_TABLE, Blocks.SPRUCE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.JUNGLE_FLETCHING_TABLE, Blocks.JUNGLE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.ACACIA_FLETCHING_TABLE, Blocks.ACACIA_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.DARK_OAK_FLETCHING_TABLE, Blocks.DARK_OAK_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.CRIMSON_FLETCHING_TABLE, Blocks.CRIMSON_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.WARPED_FLETCHING_TABLE, Blocks.WARPED_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.MANGROVE_FLETCHING_TABLE, Blocks.MANGROVE_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.CHERRY_FLETCHING_TABLE, Blocks.CHERRY_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.BAMBOO_FLETCHING_TABLE, Blocks.BAMBOO_PLANKS, TextureMapping::fletchingTable);
        this.createCraftingTableLike(ModBlocks.PALE_OAK_FLETCHING_TABLE, Blocks.PALE_OAK_PLANKS, TextureMapping::fletchingTable);

        this.createCustomSmithingTable(ModBlocks.OAK_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.SPRUCE_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.BIRCH_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.JUNGLE_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.ACACIA_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.DARK_OAK_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.CRIMSON_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.WARPED_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.CHERRY_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.BAMBOO_SMITHING_TABLE);
        this.createCustomSmithingTable(ModBlocks.PALE_OAK_SMITHING_TABLE);

        this.createCustomGrindstone(ModBlocks.OAK_GRINDSTONE, Blocks.OAK_LOG);
        this.createCustomGrindstone(ModBlocks.SPRUCE_GRINDSTONE, Blocks.SPRUCE_LOG);
        this.createCustomGrindstone(ModBlocks.BIRCH_GRINDSTONE, Blocks.BIRCH_LOG);
        this.createCustomGrindstone(ModBlocks.JUNGLE_GRINDSTONE, Blocks.JUNGLE_LOG);
        this.createCustomGrindstone(ModBlocks.ACACIA_GRINDSTONE, Blocks.ACACIA_LOG);
        this.createCustomGrindstone(ModBlocks.CRIMSON_GRINDSTONE, Blocks.CRIMSON_STEM);
        this.createCustomGrindstone(ModBlocks.WARPED_GRINDSTONE, Blocks.WARPED_STEM);
        this.createCustomGrindstone(ModBlocks.MANGROVE_GRINDSTONE, Blocks.MANGROVE_LOG);
        this.createCustomGrindstone(ModBlocks.CHERRY_GRINDSTONE, Blocks.CHERRY_LOG);
        this.createCustomGrindstone(ModBlocks.BAMBOO_GRINDSTONE, Blocks.BAMBOO_BLOCK);
        this.createCustomGrindstone(ModBlocks.PALE_OAK_GRINDSTONE, Blocks.PALE_OAK_LOG);

        this.createHorizontallyRotatedBlock(ModBlocks.SPRUCE_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.BIRCH_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.JUNGLE_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.ACACIA_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.DARK_OAK_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.CRIMSON_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.WARPED_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.MANGROVE_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.CHERRY_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.BAMBOO_LOOM, TexturedModel.ORIENTABLE);
        this.createHorizontallyRotatedBlock(ModBlocks.PALE_OAK_LOOM, TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.BLACKSTONE_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);
        this.createFurnace(ModBlocks.DEEPSLATE_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);

        this.createFurnace(ModBlocks.SPRUCE_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_STONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_STONE_SMOKER, TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.OAK_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.SPRUCE_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_BLACKSTONE_SMOKER, TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.OAK_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.SPRUCE_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BIRCH_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.JUNGLE_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.ACACIA_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.DARK_OAK_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CRIMSON_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.WARPED_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.MANGROVE_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.CHERRY_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.BAMBOO_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);
        this.createFurnace(ModBlocks.PALE_OAK_DEEPSLATE_SMOKER, TexturedModel.ORIENTABLE);

        this.createFurnace(ModBlocks.BLACKSTONE_BLAST_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);
        this.createFurnace(ModBlocks.DEEPSLATE_BLAST_FURNACE, TexturedModel.ORIENTABLE_ONLY_TOP);

        this.createCampfires(ModBlocks.SPRUCE_CAMPFIRE, ModBlocks.SPRUCE_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.BIRCH_CAMPFIRE, ModBlocks.BIRCH_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.JUNGLE_CAMPFIRE, ModBlocks.JUNGLE_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.ACACIA_CAMPFIRE, ModBlocks.ACACIA_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.DARK_OAK_CAMPFIRE, ModBlocks.DARK_OAK_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.CRIMSON_CAMPFIRE, ModBlocks.CRIMSON_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.WARPED_CAMPFIRE, ModBlocks.WARPED_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.MANGROVE_CAMPFIRE, ModBlocks.MANGROVE_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.CHERRY_CAMPFIRE, ModBlocks.CHERRY_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.BAMBOO_CAMPFIRE, ModBlocks.BAMBOO_SOUL_CAMPFIRE);
        this.createCampfires(ModBlocks.PALE_OAK_CAMPFIRE, ModBlocks.PALE_OAK_SOUL_CAMPFIRE);

        this.createBeeNest(ModBlocks.SPRUCE_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.BIRCH_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.JUNGLE_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.ACACIA_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.DARK_OAK_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.CRIMSON_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.WARPED_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.MANGROVE_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.CHERRY_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.BAMBOO_BEEHIVE, TextureMapping::orientableCubeSameEnds);
        this.createBeeNest(ModBlocks.PALE_OAK_BEEHIVE, TextureMapping::orientableCubeSameEnds);

        this.createCustomBookshelf(ModBlocks.SPRUCE_BOOKSHELF, Blocks.SPRUCE_PLANKS);
        this.createCustomBookshelf(ModBlocks.BIRCH_BOOKSHELF, Blocks.BIRCH_PLANKS);
        this.createCustomBookshelf(ModBlocks.JUNGLE_BOOKSHELF, Blocks.JUNGLE_PLANKS);
        this.createCustomBookshelf(ModBlocks.ACACIA_BOOKSHELF, Blocks.ACACIA_PLANKS);
        this.createCustomBookshelf(ModBlocks.DARK_OAK_BOOKSHELF, Blocks.DARK_OAK_PLANKS);
        this.createCustomBookshelf(ModBlocks.CRIMSON_BOOKSHELF, Blocks.CRIMSON_PLANKS);
        this.createCustomBookshelf(ModBlocks.WARPED_BOOKSHELF, Blocks.WARPED_PLANKS);
        this.createCustomBookshelf(ModBlocks.MANGROVE_BOOKSHELF, Blocks.MANGROVE_PLANKS);
        this.createCustomBookshelf(ModBlocks.CHERRY_BOOKSHELF, Blocks.CHERRY_PLANKS);
        this.createCustomBookshelf(ModBlocks.BAMBOO_BOOKSHELF, Blocks.BAMBOO_PLANKS);
        this.createCustomBookshelf(ModBlocks.PALE_OAK_BOOKSHELF, Blocks.PALE_OAK_PLANKS);

        this.createCustomChiseledBookshelf(ModBlocks.SPRUCE_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.BIRCH_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.JUNGLE_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.ACACIA_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.DARK_OAK_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.CRIMSON_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.WARPED_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.MANGROVE_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.CHERRY_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.BAMBOO_CHISELED_BOOKSHELF);
        this.createCustomChiseledBookshelf(ModBlocks.PALE_OAK_CHISELED_BOOKSHELF);

        this.createLectern(ModBlocks.SPRUCE_LECTERN, Blocks.SPRUCE_PLANKS);
        this.createLectern(ModBlocks.BIRCH_LECTERN, Blocks.BIRCH_PLANKS);
        this.createLectern(ModBlocks.JUNGLE_LECTERN, Blocks.JUNGLE_PLANKS);
        this.createLectern(ModBlocks.ACACIA_LECTERN, Blocks.ACACIA_PLANKS);
        this.createLectern(ModBlocks.DARK_OAK_LECTERN, Blocks.DARK_OAK_PLANKS);
        this.createLectern(ModBlocks.CRIMSON_LECTERN, Blocks.CRIMSON_PLANKS);
        this.createLectern(ModBlocks.WARPED_LECTERN, Blocks.WARPED_PLANKS);
        this.createLectern(ModBlocks.MANGROVE_LECTERN, Blocks.MANGROVE_PLANKS);
        this.createLectern(ModBlocks.CHERRY_LECTERN, Blocks.CHERRY_PLANKS);
        this.createLectern(ModBlocks.BAMBOO_LECTERN, Blocks.BAMBOO_PLANKS);
        this.createLectern(ModBlocks.PALE_OAK_LECTERN, Blocks.PALE_OAK_PLANKS);

        this.createCustomBrewingStand(ModBlocks.BLACKSTONE_BREWING_STAND);
        this.createCustomBrewingStand(ModBlocks.DEEPSLATE_BREWING_STAND);

        this.createCustomBarrel(ModBlocks.OAK_BARREL);
        this.createCustomBarrel(ModBlocks.BIRCH_BARREL);
        this.createCustomBarrel(ModBlocks.JUNGLE_BARREL);
        this.createCustomBarrel(ModBlocks.ACACIA_BARREL);
        this.createCustomBarrel(ModBlocks.DARK_OAK_BARREL);
        this.createCustomBarrel(ModBlocks.CRIMSON_BARREL);
        this.createCustomBarrel(ModBlocks.WARPED_BARREL);
        this.createCustomBarrel(ModBlocks.MANGROVE_BARREL);
        this.createCustomBarrel(ModBlocks.CHERRY_BARREL);
        this.createCustomBarrel(ModBlocks.BAMBOO_BARREL);
        this.createCustomBarrel(ModBlocks.PALE_OAK_BARREL);

        this.createCustomDispenserBlock(ModBlocks.BLACKSTONE_DISPENSER, ModBlocks.BLACKSTONE_FURNACE);
        this.createCustomDispenserBlock(ModBlocks.DEEPSLATE_DISPENSER, ModBlocks.DEEPSLATE_FURNACE);

        this.createCustomDispenserBlock(ModBlocks.BLACKSTONE_DROPPER, ModBlocks.BLACKSTONE_FURNACE);
        this.createCustomDispenserBlock(ModBlocks.DEEPSLATE_DROPPER, ModBlocks.DEEPSLATE_FURNACE);

        this.createCustomObserver(ModBlocks.BLACKSTONE_OBSERVER);
        this.createCustomObserver(ModBlocks.DEEPSLATE_OBSERVER);

        this.createCustomCrafterBlock(ModBlocks.SPRUCE_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.BIRCH_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.JUNGLE_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.ACACIA_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.DARK_OAK_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.CRIMSON_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.WARPED_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.MANGROVE_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.CHERRY_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.BAMBOO_CRAFTER);
        this.createCustomCrafterBlock(ModBlocks.PALE_OAK_CRAFTER);

        this.createCustomChests();

        this.createTrivialCube(ModBlocks.OAK_MOSAIC);
        this.createTrivialCube(ModBlocks.SPRUCE_MOSAIC);
        this.createTrivialCube(ModBlocks.BIRCH_MOSAIC);
        this.createTrivialCube(ModBlocks.JUNGLE_MOSAIC);
        this.createTrivialCube(ModBlocks.ACACIA_MOSAIC);
        this.createTrivialCube(ModBlocks.DARK_OAK_MOSAIC);
        this.createTrivialCube(ModBlocks.CRIMSON_MOSAIC);
        this.createTrivialCube(ModBlocks.WARPED_MOSAIC);
        this.createTrivialCube(ModBlocks.MANGROVE_MOSAIC);
        this.createTrivialCube(ModBlocks.CHERRY_MOSAIC);
        this.createTrivialCube(ModBlocks.PALE_OAK_MOSAIC);

        this.createTrivialCube(ModBlocks.STONE_TILES);
        this.createTrivialCube(ModBlocks.MOSSY_STONE_TILES);
        this.createTrivialCube(ModBlocks.CRACKED_STONE_TILES);

        this.createCopperChain(ModBlocks.IRON_CHAIN.weathering().exposed(), ModBlocks.IRON_CHAIN.waxed().exposed());
        this.createCopperChain(ModBlocks.IRON_CHAIN.weathering().weathered(), ModBlocks.IRON_CHAIN.waxed().weathered());
        this.createCopperChain(ModBlocks.IRON_CHAIN.weathering().rusted(), ModBlocks.IRON_CHAIN.waxed().rusted());
        this.createWaxedIronChain();
        this.createCopperChainItem(ModBlocks.IRON_CHAIN.weathering().exposed().asItem(), ModBlocks.IRON_CHAIN.waxed().exposed().asItem());
        this.createCopperChainItem(ModBlocks.IRON_CHAIN.weathering().weathered().asItem(), ModBlocks.IRON_CHAIN.waxed().weathered().asItem());
        this.createCopperChainItem(ModBlocks.IRON_CHAIN.weathering().rusted().asItem(), ModBlocks.IRON_CHAIN.waxed().rusted().asItem());

        this.createTrivialCube(ModBlocks.OBSIDIAN_BRICKS);
        this.createTrivialCube(ModBlocks.CRYING_OBSIDIAN_BRICKS);

        this.createTrivialCube(ModBlocks.COAL_BRICKS);
        this.createTrivialCube(ModBlocks.CHARCOAL_BRICKS);

        this.createTrivialCube(ModBlocks.LAPIS_BRICKS);
        this.createTrivialCube(ModBlocks.SMOOTH_LAPIS);

        this.createTrivialCube(ModBlocks.SNOW_BRICKS);
        this.createTrivialCube(ModBlocks.ICE_BRICKS);
        this.createTrivialCube(ModBlocks.PACKED_ICE_BRICKS);
        this.createTrivialCube(ModBlocks.BLUE_ICE_BRICKS);

        this.createTrivialCube(ModBlocks.SCULK_BRICKS);
        this.createTrivialCube(ModBlocks.CUT_AMETHYST);

        this.createNormalTorch(ModBlocks.IRON_TORCH, ModBlocks.IRON_WALL_TORCH);
        this.createNormalTorch(ModBlocks.ZINC_TORCH, ModBlocks.ZINC_WALL_TORCH);
        this.createNormalTorch(ModBlocks.SILVER_TORCH, ModBlocks.SILVER_WALL_TORCH);
        this.createNormalTorch(ModBlocks.TIN_TORCH, ModBlocks.TIN_WALL_TORCH);
        this.createNormalTorch(ModBlocks.TUNGSTEN_TORCH, ModBlocks.TUNGSTEN_WALL_TORCH);
        this.createNormalTorch(ModBlocks.PLATINUM_TORCH, ModBlocks.PLATINUM_WALL_TORCH);
        this.createNormalTorch(ModBlocks.GOLD_TORCH, ModBlocks.GOLD_WALL_TORCH);
        this.createNormalTorch(ModBlocks.LEAD_TORCH, ModBlocks.LEAD_WALL_TORCH);
        this.createNormalTorch(ModBlocks.URANIUM_TORCH, ModBlocks.URANIUM_WALL_TORCH);

        this.createWaxedIronLantern();
        this.createCopperLantern(ModBlocks.IRON_LANTERN.weathering().exposed(), ModBlocks.IRON_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.IRON_LANTERN.weathering().weathered(), ModBlocks.IRON_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.IRON_LANTERN.weathering().rusted(), ModBlocks.IRON_LANTERN.waxed().rusted());

        this.createWaxedIronSoulLantern();
        this.createCopperLantern(ModBlocks.IRON_SOUL_LANTERN.weathering().exposed(), ModBlocks.IRON_SOUL_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.IRON_SOUL_LANTERN.weathering().weathered(), ModBlocks.IRON_SOUL_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.IRON_SOUL_LANTERN.weathering().rusted(), ModBlocks.IRON_SOUL_LANTERN.waxed().rusted());

        this.createCopperLantern(ModBlocks.IRON_FIRE_LANTERN.weathering().unaffected(), ModBlocks.IRON_FIRE_LANTERN.waxed().unaffected());
        this.createCopperLantern(ModBlocks.IRON_FIRE_LANTERN.weathering().exposed(), ModBlocks.IRON_FIRE_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.IRON_FIRE_LANTERN.weathering().weathered(), ModBlocks.IRON_FIRE_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.IRON_FIRE_LANTERN.weathering().rusted(), ModBlocks.IRON_FIRE_LANTERN.waxed().rusted());

        this.createCopperLantern(ModBlocks.COPPER_SOUL_LANTERN.weathering().unaffected(), ModBlocks.COPPER_SOUL_LANTERN.waxed().unaffected());
        this.createCopperLantern(ModBlocks.COPPER_SOUL_LANTERN.weathering().exposed(), ModBlocks.COPPER_SOUL_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.COPPER_SOUL_LANTERN.weathering().weathered(), ModBlocks.COPPER_SOUL_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.COPPER_SOUL_LANTERN.weathering().oxidized(), ModBlocks.COPPER_SOUL_LANTERN.waxed().oxidized());

        this.createCopperLantern(ModBlocks.COPPER_FIRE_LANTERN.weathering().unaffected(), ModBlocks.COPPER_FIRE_LANTERN.waxed().unaffected());
        this.createCopperLantern(ModBlocks.COPPER_FIRE_LANTERN.weathering().exposed(), ModBlocks.COPPER_FIRE_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.COPPER_FIRE_LANTERN.weathering().weathered(), ModBlocks.COPPER_FIRE_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.COPPER_FIRE_LANTERN.weathering().oxidized(), ModBlocks.COPPER_FIRE_LANTERN.waxed().oxidized());

        this.createCopperChain(ModBlocks.ZINC_CHAIN.weathering().unaffected(), ModBlocks.ZINC_CHAIN.waxed().unaffected());
        this.createCopperChain(ModBlocks.ZINC_CHAIN.weathering().exposed(), ModBlocks.ZINC_CHAIN.waxed().exposed());
        this.createCopperChain(ModBlocks.ZINC_CHAIN.weathering().weathered(), ModBlocks.ZINC_CHAIN.waxed().weathered());
        this.createCopperChain(ModBlocks.ZINC_CHAIN.weathering().corroded(), ModBlocks.ZINC_CHAIN.waxed().corroded());
        this.createCopperChainItem(ModBlocks.ZINC_CHAIN.weathering().unaffected().asItem(), ModBlocks.ZINC_CHAIN.waxed().unaffected().asItem());
        this.createCopperChainItem(ModBlocks.ZINC_CHAIN.weathering().exposed().asItem(), ModBlocks.ZINC_CHAIN.waxed().exposed().asItem());
        this.createCopperChainItem(ModBlocks.ZINC_CHAIN.weathering().weathered().asItem(), ModBlocks.ZINC_CHAIN.waxed().weathered().asItem());
        this.createCopperChainItem(ModBlocks.ZINC_CHAIN.weathering().corroded().asItem(), ModBlocks.ZINC_CHAIN.waxed().corroded().asItem());

        this.createCustomChain(ModBlocks.GOLD_CHAIN);
        this.createCustomChain(ModBlocks.NETHERITE_CHAIN);
        this.createCustomChain(ModBlocks.SILVER_CHAIN);
        this.createCustomChain(ModBlocks.TIN_CHAIN);
        this.createCustomChain(ModBlocks.TUNGSTEN_CHAIN);
        this.createCustomChain(ModBlocks.PLATINUM_CHAIN);
        this.createCustomChain(ModBlocks.LEAD_CHAIN);
        this.createCustomChain(ModBlocks.URANIUM_CHAIN);
        this.createCustomChain(ModBlocks.BRONZE_CHAIN);
        this.createCustomChain(ModBlocks.BRASS_CHAIN);
        this.createCustomChain(ModBlocks.STEEL_CHAIN);

        this.createTrivialCube(ModBlocks.GABBRO);
        this.createTrivialCube(ModBlocks.POLISHED_GABBRO);
        this.createTrivialCube(ModBlocks.GABBRO_BRICKS);

        this.createTrivialCube(ModBlocks.RHYOLITE);
        this.createTrivialCube(ModBlocks.POLISHED_RHYOLITE);
        this.createTrivialCube(ModBlocks.RHYOLITE_BRICKS);

        this.createTrivialCube(ModBlocks.PUMICE);
        this.createTrivialCube(ModBlocks.POLISHED_PUMICE);
        this.createTrivialCube(ModBlocks.PUMICE_BRICKS);

        this.createTrivialCube(ModBlocks.POLISHED_STONE);
        this.createTrivialCube(ModBlocks.SMOOTH_DEEPSLATE);
        this.createTrivialCube(ModBlocks.NETHERRACK_BRICKS);
        this.createTrivialCube(ModBlocks.TERRACOTTA_BRICKS);
        this.createTrivialCube(ModBlocks.BIG_BRICKS);

        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.white());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.orange());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.magenta());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.lightBlue());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.yellow());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.lime());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.pink());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.gray());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.lightGray());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.cyan());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.purple());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.blue());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.brown());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.green());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.red());
        this.createTrivialCube(ModBlocks.DYED_TERRACOTTA_BRICKS.black());

        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.white());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.orange());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.magenta());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.lightBlue());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.yellow());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.lime());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.pink());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.gray());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.lightGray());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.cyan());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.purple());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.blue());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.brown());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.green());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.red());
        this.createTrivialCube(ModBlocks.CONCRETE_BRICKS.black());

        this.createTintedGlassPane(Blocks.TINTED_GLASS, ModBlocks.TINTED_GLASS_PANE);

        this.createRotatedPillarWithHorizontalVariant(ModBlocks.LAPIS_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);

        this.createTrivialBlock(ModBlocks.CHISELED_LAPIS, TexturedModel.COLUMN.updateTexture(
                (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS, "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS, "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS, "_top"))
        ));

        this.createTrivialCube(ModBlocks.IRON_GRATE.weathering().unaffected());
        this.createTrivialCube(ModBlocks.IRON_GRATE.weathering().exposed());
        this.createTrivialCube(ModBlocks.IRON_GRATE.weathering().weathered());
        this.createTrivialCube(ModBlocks.IRON_GRATE.weathering().rusted());
        this.copyModel(ModBlocks.IRON_GRATE.weathering().unaffected(), ModBlocks.IRON_GRATE.waxed().unaffected());
        this.copyModel(ModBlocks.IRON_GRATE.weathering().exposed(), ModBlocks.IRON_GRATE.waxed().exposed());
        this.copyModel(ModBlocks.IRON_GRATE.weathering().weathered(), ModBlocks.IRON_GRATE.waxed().weathered());
        this.copyModel(ModBlocks.IRON_GRATE.weathering().rusted(), ModBlocks.IRON_GRATE.waxed().rusted());

        this.createTrivialCube(ModBlocks.ZINC_GRATE.weathering().unaffected());
        this.createTrivialCube(ModBlocks.ZINC_GRATE.weathering().exposed());
        this.createTrivialCube(ModBlocks.ZINC_GRATE.weathering().weathered());
        this.createTrivialCube(ModBlocks.ZINC_GRATE.weathering().corroded());
        this.copyModel(ModBlocks.ZINC_GRATE.weathering().unaffected(), ModBlocks.ZINC_GRATE.waxed().unaffected());
        this.copyModel(ModBlocks.ZINC_GRATE.weathering().exposed(), ModBlocks.ZINC_GRATE.waxed().exposed());
        this.copyModel(ModBlocks.ZINC_GRATE.weathering().weathered(), ModBlocks.ZINC_GRATE.waxed().weathered());
        this.copyModel(ModBlocks.ZINC_GRATE.weathering().corroded(), ModBlocks.ZINC_GRATE.waxed().corroded());

        this.createTrivialCube(ModBlocks.SILVER_GRATE);
        this.createTrivialCube(ModBlocks.TIN_GRATE);
        this.createTrivialCube(ModBlocks.TUNGSTEN_GRATE);
        this.createTrivialCube(ModBlocks.PLATINUM_GRATE);
        this.createTrivialCube(ModBlocks.GOLD_GRATE);
        this.createTrivialCube(ModBlocks.LEAD_GRATE);
        this.createTrivialCube(ModBlocks.URANIUM_GRATE);

        this.createTrivialCube(ModBlocks.NETHERITE_GRATE);
        this.createTrivialCube(ModBlocks.BRONZE_GRATE);
        this.createTrivialCube(ModBlocks.BRASS_GRATE);
        this.createTrivialCube(ModBlocks.STEEL_GRATE);

        this.createCopperBulb(ModBlocks.IRON_BULB.weathering().unaffected());
        this.createCopperBulb(ModBlocks.IRON_BULB.weathering().exposed());
        this.createCopperBulb(ModBlocks.IRON_BULB.weathering().weathered());
        this.createCopperBulb(ModBlocks.IRON_BULB.weathering().rusted());
        this.copyCopperBulbModel(ModBlocks.IRON_BULB.weathering().unaffected(), ModBlocks.IRON_BULB.waxed().unaffected());
        this.copyCopperBulbModel(ModBlocks.IRON_BULB.weathering().exposed(), ModBlocks.IRON_BULB.waxed().exposed());
        this.copyCopperBulbModel(ModBlocks.IRON_BULB.weathering().weathered(), ModBlocks.IRON_BULB.waxed().weathered());
        this.copyCopperBulbModel(ModBlocks.IRON_BULB.weathering().rusted(), ModBlocks.IRON_BULB.waxed().rusted());

        this.createCopperBulb(ModBlocks.ZINC_BULB.weathering().unaffected());
        this.createCopperBulb(ModBlocks.ZINC_BULB.weathering().exposed());
        this.createCopperBulb(ModBlocks.ZINC_BULB.weathering().weathered());
        this.createCopperBulb(ModBlocks.ZINC_BULB.weathering().corroded());
        this.copyCopperBulbModel(ModBlocks.ZINC_BULB.weathering().unaffected(), ModBlocks.ZINC_BULB.waxed().unaffected());
        this.copyCopperBulbModel(ModBlocks.ZINC_BULB.weathering().exposed(), ModBlocks.ZINC_BULB.waxed().exposed());
        this.copyCopperBulbModel(ModBlocks.ZINC_BULB.weathering().weathered(), ModBlocks.ZINC_BULB.waxed().weathered());
        this.copyCopperBulbModel(ModBlocks.ZINC_BULB.weathering().corroded(), ModBlocks.ZINC_BULB.waxed().corroded());

        this.createCopperBulb(ModBlocks.SILVER_BULB);
        this.createCopperBulb(ModBlocks.TIN_BULB);
        this.createCopperBulb(ModBlocks.TUNGSTEN_BULB);
        this.createCopperBulb(ModBlocks.PLATINUM_BULB);
        this.createCopperBulb(ModBlocks.GOLD_BULB);
        this.createCopperBulb(ModBlocks.LEAD_BULB);
        this.createCopperBulb(ModBlocks.URANIUM_BULB);

        this.createCopperBulb(ModBlocks.NETHERITE_BULB);
        this.createCopperBulb(ModBlocks.BRONZE_BULB);
        this.createCopperBulb(ModBlocks.BRASS_BULB);
        this.createCopperBulb(ModBlocks.STEEL_BULB);

        this.createTrivialCube(ModBlocks.GRAPHITE);
        this.createTrivialCube(ModBlocks.POLISHED_GRAPHITE);
        this.createTrivialCube(ModBlocks.GRAPHITE_BRICKS);
        this.createBlockEndingWithEne(ModBlocks.GRAPHITE, ModBlocks.GRAPHENE);
        this.createTrivialCube(ModBlocks.CARBON_BLOCK);

        this.createTrivialCube(ModBlocks.BISMUTH_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_BISMUTH_ORE);
        this.createTrivialCube(ModBlocks.RAW_BISMUTH_BLOCK);

        this.createTrivialCube(ModBlocks.BISMUTH_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_BISMUTH);
        this.createDoor(ModBlocks.BISMUTH_DOOR);
        this.createOrientableTrapdoor(ModBlocks.BISMUTH_TRAPDOOR);
        this.createWeightedPressurePlate(ModBlocks.VEHEMENT_WEIGHTED_PRESSURE_PLATE, ModBlocks.BISMUTH_BLOCK);

        this.createNormalTorch(ModBlocks.BISMUTH_TORCH, ModBlocks.BISMUTH_WALL_TORCH);
        this.createCustomChain(ModBlocks.BISMUTH_CHAIN);
        this.createTrivialCube(ModBlocks.BISMUTH_GRATE);
        this.createCopperBulb(ModBlocks.BISMUTH_BULB);

        this.createCopperLantern(ModBlocks.ZINC_FIRE_LANTERN.weathering().unaffected(), ModBlocks.ZINC_FIRE_LANTERN.waxed().unaffected());
        this.createCopperLantern(ModBlocks.ZINC_SOUL_LANTERN.weathering().unaffected(), ModBlocks.ZINC_FIRE_LANTERN.waxed().unaffected());
        this.createCopperLantern(ModBlocks.ZINC_LANTERN.weathering().unaffected(), ModBlocks.ZINC_FIRE_LANTERN.waxed().unaffected());

        this.createCopperLantern(ModBlocks.ZINC_FIRE_LANTERN.weathering().exposed(), ModBlocks.ZINC_FIRE_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.ZINC_SOUL_LANTERN.weathering().exposed(), ModBlocks.ZINC_FIRE_LANTERN.waxed().exposed());
        this.createCopperLantern(ModBlocks.ZINC_LANTERN.weathering().exposed(), ModBlocks.ZINC_FIRE_LANTERN.waxed().exposed());

        this.createCopperLantern(ModBlocks.ZINC_FIRE_LANTERN.weathering().weathered(), ModBlocks.ZINC_FIRE_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.ZINC_SOUL_LANTERN.weathering().weathered(), ModBlocks.ZINC_FIRE_LANTERN.waxed().weathered());
        this.createCopperLantern(ModBlocks.ZINC_LANTERN.weathering().weathered(), ModBlocks.ZINC_FIRE_LANTERN.waxed().weathered());

        this.createCopperLantern(ModBlocks.ZINC_FIRE_LANTERN.weathering().corroded(), ModBlocks.ZINC_FIRE_LANTERN.waxed().corroded());
        this.createCopperLantern(ModBlocks.ZINC_SOUL_LANTERN.weathering().corroded(), ModBlocks.ZINC_FIRE_LANTERN.waxed().corroded());
        this.createCopperLantern(ModBlocks.ZINC_LANTERN.weathering().corroded(), ModBlocks.ZINC_FIRE_LANTERN.waxed().corroded());

        this.createLantern(ModBlocks.SILVER_FIRE_LANTERN);
        this.createLantern(ModBlocks.SILVER_SOUL_LANTERN);
        this.createLantern(ModBlocks.SILVER_LANTERN);

        this.createLantern(ModBlocks.TIN_FIRE_LANTERN);
        this.createLantern(ModBlocks.TIN_SOUL_LANTERN);
        this.createLantern(ModBlocks.TIN_LANTERN);

        this.createLantern(ModBlocks.TUNGSTEN_FIRE_LANTERN);
        this.createLantern(ModBlocks.TUNGSTEN_SOUL_LANTERN);
        this.createLantern(ModBlocks.TUNGSTEN_LANTERN);

        this.createLantern(ModBlocks.PLATINUM_FIRE_LANTERN);
        this.createLantern(ModBlocks.PLATINUM_SOUL_LANTERN);
        this.createLantern(ModBlocks.PLATINUM_LANTERN);

        this.createLantern(ModBlocks.GOLD_FIRE_LANTERN);
        this.createLantern(ModBlocks.GOLD_SOUL_LANTERN);
        this.createLantern(ModBlocks.GOLD_LANTERN);

        this.createLantern(ModBlocks.LEAD_FIRE_LANTERN);
        this.createLantern(ModBlocks.LEAD_SOUL_LANTERN);
        this.createLantern(ModBlocks.LEAD_LANTERN);

        this.createLantern(ModBlocks.BISMUTH_FIRE_LANTERN);
        this.createLantern(ModBlocks.BISMUTH_SOUL_LANTERN);
        this.createLantern(ModBlocks.BISMUTH_LANTERN);

        this.createLantern(ModBlocks.URANIUM_FIRE_LANTERN);
        this.createLantern(ModBlocks.URANIUM_SOUL_LANTERN);
        this.createLantern(ModBlocks.URANIUM_LANTERN);

        this.createLantern(ModBlocks.NETHERITE_FIRE_LANTERN);
        this.createLantern(ModBlocks.NETHERITE_SOUL_LANTERN);

        this.createLantern(ModBlocks.BRONZE_FIRE_LANTERN);
        this.createLantern(ModBlocks.BRONZE_SOUL_LANTERN);

        this.createLantern(ModBlocks.BRASS_FIRE_LANTERN);
        this.createLantern(ModBlocks.BRASS_SOUL_LANTERN);

        this.createLantern(ModBlocks.STEEL_FIRE_LANTERN);
        this.createLantern(ModBlocks.STEEL_SOUL_LANTERN);

        this.createTrivialCube(ModBlocks.SILICITE);
        this.createTrivialCube(ModBlocks.POLISHED_SILICITE);
        this.createTrivialCube(ModBlocks.SILICITE_BRICKS);
        this.createBlockEndingWithEne(ModBlocks.SILICITE, ModBlocks.SILICENE);
        this.createTrivialCube(ModBlocks.SILICON_BLOCK);

        this.createTrivialCube(ModBlocks.NETHER_MONOCRYSTAL_ORE);
        this.createTrivialCube(ModBlocks.MONOCRYSTAL_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_MONOCRYSTAL);

        this.createTrivialCube(ModBlocks.RUBY_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_RUBY_ORE);
        this.createTrivialCube(ModBlocks.RUBY_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_RUBY);

        this.createTrivialCube(ModBlocks.SAPPHIRE_ORE);
        this.createTrivialCube(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        this.createTrivialCube(ModBlocks.SAPPHIRE_BLOCK);
        this.createTrivialCube(ModBlocks.CUT_SAPPHIRE);

        ModBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(
                        family ->
                        {
                            if (family.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_SOUL_SANDSTONE || family.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_LAPIS) {
                                familyWithExistingFullBlock(family.getBaseBlock()).wall(family.get(BlockFamily.Variant.WALL));
                                familyWithExistingFullBlock(family.getBaseBlock()).slab(family.get(BlockFamily.Variant.SLAB));
                                familyWithExistingFullBlock(family.getBaseBlock()).stairs(family.get(BlockFamily.Variant.STAIRS));
                                familyWithExistingFullBlock(family.getBaseBlock()).fence(family.get(BlockFamily.Variant.FENCE));
                            } else if (family.getBaseBlock() == ModBlocks.SMOOTH_DEEPSLATE) {
                                familyWithExistingFullBlock(family.getBaseBlock()).wall(ModBlocks.SMOOTH_DEEPSLATE_WALL);
                                createSmoothDeepslateSlab();
                                familyWithExistingFullBlock(family.getBaseBlock()).stairs(ModBlocks.SMOOTH_DEEPSLATE_STAIRS);
                                familyWithExistingFullBlock(family.getBaseBlock()).fence(ModBlocks.SMOOTH_DEEPSLATE_FENCE);
                            } else if (family.getBaseBlock() == Blocks.TINTED_GLASS || family.getBaseBlock().getDescriptionId().contains("stained")) {
                                createTintedDoor(family.get(BlockFamily.Variant.DOOR));
                                createTintedOrientableTrapdoor(family.get(BlockFamily.Variant.TRAPDOOR));
                            } else {
                                familyWithExistingFullBlock(family.getBaseBlock()).generateFor(family);
                            }
                            System.out.println(family);
                        }
                );
    }
}