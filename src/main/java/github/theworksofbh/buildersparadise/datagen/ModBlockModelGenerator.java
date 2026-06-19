package github.theworksofbh.buildersparadise.datagen;

import com.mojang.datafixers.util.Pair;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
import github.theworksofbh.buildersparadise.model_layers.ModModelTemplates;
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
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

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
        } else if (fullBlock == ModBlocks.SMOOTH_DEEPSLATE.get()) {
            mapping = TexturedModel.CUBE.get(ModBlocks.SMOOTH_DEEPSLATE.get()).getMapping();
            mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), "_side"));
            mapping.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE.get(), ""));
            mapping.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE.get(), ""));
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
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.CHRISTMAS.single())),
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.REGULAR.single()))
                )
        );

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
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.CHRISTMAS.single())),
                        ItemModelUtils.specialModel(
                                Identifier.parse("minecraft:item/trapped_chest"),
                                new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.TRAPPED.single()))
                )
        );
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
        this.registerSimpleFlatItemModel(brewingStandBlock.asItem());
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


    public void createSmoothDeepslateSlab() {
        TextureMapping texturemapping = TextureMapping.cube(ModBlocks.SMOOTH_DEEPSLATE.get());
        TextureMapping texturemapping1 = TextureMapping.column(TextureMapping.getBlockTexture(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), "_side"), texturemapping.get(TextureSlot.TOP));
        MultiVariant multivariant = plainVariant(ModelTemplates.SLAB_BOTTOM.create(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), texturemapping1, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(ModelTemplates.SLAB_TOP.create(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), texturemapping1, this.modelOutput));
        MultiVariant multivariant2 = plainVariant(ModelTemplates.CUBE_COLUMN.createWithOverride(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), "_double", texturemapping1, this.modelOutput));
        this.blockStateOutput.accept(createSlab(ModBlocks.SMOOTH_DEEPSLATE_SLAB.get(), multivariant, multivariant1, multivariant2));
    }

    public void createTintedGlassPane(Block glassBlock, Block paneBlock) {
        TextureMapping texturemapping = TextureMapping.pane(glassBlock, paneBlock);
        MultiVariant multivariant = plainVariant(ModModelTemplates.TINTED_GLASS_PANE_POST.create(paneBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(ModModelTemplates.TINTED_GLASS_PANE_SIDE.create(paneBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant2 = plainVariant(ModModelTemplates.TINTED_GLASS_PANE_SIDE_ALT.create(paneBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant3 = plainVariant(ModModelTemplates.TINTED_GLASS_PANE_NOSIDE.create(paneBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant4 = plainVariant(ModModelTemplates.TINTED_GLASS_PANE_NOSIDE_ALT.create(paneBlock, texturemapping, this.modelOutput));
        Item item = paneBlock.asItem();
        this.registerSimpleItemModel(item, this.createFlatItemModelWithBlockTexture(item, glassBlock));
        this.blockStateOutput.accept(MultiPartGenerator.multiPart(paneBlock).with(multivariant).with(condition().term(BlockStateProperties.NORTH, true), multivariant1).with(condition().term(BlockStateProperties.EAST, true), multivariant1.with(Y_ROT_90)).with(condition().term(BlockStateProperties.SOUTH, true), multivariant2).with(condition().term(BlockStateProperties.WEST, true), multivariant2.with(Y_ROT_90)).with(condition().term(BlockStateProperties.NORTH, false), multivariant3).with(condition().term(BlockStateProperties.EAST, false), multivariant4).with(condition().term(BlockStateProperties.SOUTH, false), multivariant4.with(Y_ROT_90)).with(condition().term(BlockStateProperties.WEST, false), multivariant3.with(Y_ROT_270)));
    }

    public void createTintedDoor(Block doorBlock) {
        TextureMapping texturemapping = TextureMapping.door(doorBlock);
        MultiVariant multivariant = plainVariant(ModModelTemplates.TINTED_DOOR_BOTTOM_LEFT.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(ModModelTemplates.TINTED_DOOR_BOTTOM_LEFT_OPEN.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant2 = plainVariant(ModModelTemplates.TINTED_DOOR_BOTTOM_RIGHT.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant3 = plainVariant(ModModelTemplates.TINTED_DOOR_BOTTOM_RIGHT_OPEN.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant4 = plainVariant(ModModelTemplates.TINTED_DOOR_TOP_LEFT.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant5 = plainVariant(ModModelTemplates.TINTED_DOOR_TOP_LEFT_OPEN.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant6 = plainVariant(ModModelTemplates.TINTED_DOOR_TOP_RIGHT.create(doorBlock, texturemapping, this.modelOutput));
        MultiVariant multivariant7 = plainVariant(ModModelTemplates.TINTED_DOOR_TOP_RIGHT_OPEN.create(doorBlock, texturemapping, this.modelOutput));
        this.registerSimpleFlatItemModel(doorBlock.asItem());
        this.blockStateOutput.accept(createDoor(doorBlock, multivariant, multivariant1, multivariant2, multivariant3, multivariant4, multivariant5, multivariant6, multivariant7));
    }

    public void createTintedOrientableTrapdoor(Block orientableTrapdoorBlock) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(orientableTrapdoorBlock);
        MultiVariant multivariant = plainVariant(ModModelTemplates.TINTED_ORIENTABLE_TRAPDOOR_TOP.create(orientableTrapdoorBlock, texturemapping, this.modelOutput));
        Identifier identifier = ModModelTemplates.TINTED_ORIENTABLE_TRAPDOOR_BOTTOM.create(orientableTrapdoorBlock, texturemapping, this.modelOutput);
        MultiVariant multivariant1 = plainVariant(ModModelTemplates.TINTED_ORIENTABLE_TRAPDOOR_OPEN.create(orientableTrapdoorBlock, texturemapping, this.modelOutput));
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

        this.copyOrientableTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.WAXED_ZINC_TRAPDOOR.get());
        this.copyOrientableTrapdoorModel(ModBlocks.EXPOSED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_EXPOSED_ZINC_TRAPDOOR.get());
        this.copyOrientableTrapdoorModel(ModBlocks.WEATHERED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_WEATHERED_ZINC_TRAPDOOR.get());
        this.copyOrientableTrapdoorModel(ModBlocks.CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_CORRODED_ZINC_TRAPDOOR.get());

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

        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK.weathering().unaffected());
        this.createWeightedPressurePlate(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK.weathering().exposed());
        this.createWeightedPressurePlate(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK.weathering().weathered());
        this.createWeightedPressurePlate(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK.weathering().oxidized());

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

        this.createTrivialCube(ModBlocks.POLISHED_STONE.get());
        this.createTrivialCube(ModBlocks.SMOOTH_DEEPSLATE.get());
        this.createTrivialCube(ModBlocks.NETHERRACK_BRICKS.get());
        this.createTrivialCube(ModBlocks.TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.BIG_BRICKS.get());

        this.createTrivialCube(ModBlocks.WHITE_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.ORANGE_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.YELLOW_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIME_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.PINK_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.GRAY_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.CYAN_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.PURPLE_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.BLUE_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.BROWN_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.GREEN_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.RED_TERRACOTTA_BRICKS.get());
        this.createTrivialCube(ModBlocks.BLACK_TERRACOTTA_BRICKS.get());

        this.createTrivialCube(ModBlocks.WHITE_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.ORANGE_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.MAGENTA_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.YELLOW_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIME_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.PINK_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.GRAY_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.CYAN_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.PURPLE_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.BLUE_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.BROWN_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.GREEN_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.RED_CONCRETE_BRICKS.get());
        this.createTrivialCube(ModBlocks.BLACK_CONCRETE_BRICKS.get());

        this.createTintedGlassPane(Blocks.TINTED_GLASS, ModBlocks.TINTED_GLASS_PANE.get());

        this.createRotatedPillarWithHorizontalVariant(ModBlocks.LAPIS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);

        this.createTrivialBlock(ModBlocks.CHISELED_LAPIS.get(), TexturedModel.COLUMN.updateTexture(
                (mapping) -> mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS.get(), "_top"))
                        .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS.get()))
                        .put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS.get(), "_top"))
                        .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks.CHISELED_LAPIS.get(), "_top"))
        ));

        this.createTrivialCube(ModBlocks.IRON_GRATE.get());
        this.createTrivialCube(ModBlocks.EXPOSED_IRON_GRATE.get());
        this.createTrivialCube(ModBlocks.WEATHERED_IRON_GRATE.get());
        this.createTrivialCube(ModBlocks.RUSTED_IRON_GRATE.get());
        this.copyModel(ModBlocks.IRON_GRATE.get(), ModBlocks.WAXED_IRON_GRATE.get());
        this.copyModel(ModBlocks.EXPOSED_IRON_GRATE.get(), ModBlocks.WAXED_EXPOSED_IRON_GRATE.get());
        this.copyModel(ModBlocks.WEATHERED_IRON_GRATE.get(), ModBlocks.WAXED_WEATHERED_IRON_GRATE.get());
        this.copyModel(ModBlocks.RUSTED_IRON_GRATE.get(), ModBlocks.WAXED_RUSTED_IRON_GRATE.get());

        this.createTrivialCube(ModBlocks.ZINC_GRATE.get());
        this.createTrivialCube(ModBlocks.EXPOSED_ZINC_GRATE.get());
        this.createTrivialCube(ModBlocks.WEATHERED_ZINC_GRATE.get());
        this.createTrivialCube(ModBlocks.CORRODED_ZINC_GRATE.get());
        this.copyModel(ModBlocks.ZINC_GRATE.get(), ModBlocks.WAXED_ZINC_GRATE.get());
        this.copyModel(ModBlocks.EXPOSED_ZINC_GRATE.get(), ModBlocks.WAXED_EXPOSED_ZINC_GRATE.get());
        this.copyModel(ModBlocks.WEATHERED_ZINC_GRATE.get(), ModBlocks.WAXED_WEATHERED_ZINC_GRATE.get());
        this.copyModel(ModBlocks.CORRODED_ZINC_GRATE.get(), ModBlocks.WAXED_CORRODED_ZINC_GRATE.get());

        this.createTrivialCube(ModBlocks.SILVER_GRATE.get());
        this.createTrivialCube(ModBlocks.TIN_GRATE.get());
        this.createTrivialCube(ModBlocks.TUNGSTEN_GRATE.get());
        this.createTrivialCube(ModBlocks.PLATINUM_GRATE.get());
        this.createTrivialCube(ModBlocks.GOLD_GRATE.get());
        this.createTrivialCube(ModBlocks.LEAD_GRATE.get());
        this.createTrivialCube(ModBlocks.URANIUM_GRATE.get());

        this.createTrivialCube(ModBlocks.NETHERITE_GRATE.get());
        this.createTrivialCube(ModBlocks.BRONZE_GRATE.get());
        this.createTrivialCube(ModBlocks.BRASS_GRATE.get());
        this.createTrivialCube(ModBlocks.STEEL_GRATE.get());

        this.createCopperBulb(ModBlocks.IRON_BULB.get());
        this.createCopperBulb(ModBlocks.EXPOSED_IRON_BULB.get());
        this.createCopperBulb(ModBlocks.WEATHERED_IRON_BULB.get());
        this.createCopperBulb(ModBlocks.RUSTED_IRON_BULB.get());
        this.copyCopperBulbModel(ModBlocks.IRON_BULB.get(), ModBlocks.WAXED_IRON_BULB.get());
        this.copyCopperBulbModel(ModBlocks.EXPOSED_IRON_BULB.get(), ModBlocks.WAXED_EXPOSED_IRON_BULB.get());
        this.copyCopperBulbModel(ModBlocks.WEATHERED_IRON_BULB.get(), ModBlocks.WAXED_WEATHERED_IRON_BULB.get());
        this.copyCopperBulbModel(ModBlocks.RUSTED_IRON_BULB.get(), ModBlocks.WAXED_RUSTED_IRON_BULB.get());

        this.createCopperBulb(ModBlocks.ZINC_BULB.get());
        this.createCopperBulb(ModBlocks.EXPOSED_ZINC_BULB.get());
        this.createCopperBulb(ModBlocks.WEATHERED_ZINC_BULB.get());
        this.createCopperBulb(ModBlocks.CORRODED_ZINC_BULB.get());
        this.copyCopperBulbModel(ModBlocks.ZINC_BULB.get(), ModBlocks.WAXED_ZINC_BULB.get());
        this.copyCopperBulbModel(ModBlocks.EXPOSED_ZINC_BULB.get(), ModBlocks.WAXED_EXPOSED_ZINC_BULB.get());
        this.copyCopperBulbModel(ModBlocks.WEATHERED_ZINC_BULB.get(), ModBlocks.WAXED_WEATHERED_ZINC_BULB.get());
        this.copyCopperBulbModel(ModBlocks.CORRODED_ZINC_BULB.get(), ModBlocks.WAXED_CORRODED_ZINC_BULB.get());

        this.createCopperBulb(ModBlocks.SILVER_BULB.get());
        this.createCopperBulb(ModBlocks.TIN_BULB.get());
        this.createCopperBulb(ModBlocks.TUNGSTEN_BULB.get());
        this.createCopperBulb(ModBlocks.PLATINUM_BULB.get());
        this.createCopperBulb(ModBlocks.GOLD_BULB.get());
        this.createCopperBulb(ModBlocks.LEAD_BULB.get());
        this.createCopperBulb(ModBlocks.URANIUM_BULB.get());

        this.createCopperBulb(ModBlocks.NETHERITE_BULB.get());
        this.createCopperBulb(ModBlocks.BRONZE_BULB.get());
        this.createCopperBulb(ModBlocks.BRASS_BULB.get());
        this.createCopperBulb(ModBlocks.STEEL_BULB.get());



        ModBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(
                        family ->
                        {
                            if (family.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_SOUL_SANDSTONE.get() || family.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_LAPIS.get()) {
                                familyWithExistingFullBlock(family.getBaseBlock()).wall(family.get(BlockFamily.Variant.WALL));
                                familyWithExistingFullBlock(family.getBaseBlock()).slab(family.get(BlockFamily.Variant.SLAB));
                                familyWithExistingFullBlock(family.getBaseBlock()).stairs(family.get(BlockFamily.Variant.STAIRS));
                                familyWithExistingFullBlock(family.getBaseBlock()).fence(family.get(BlockFamily.Variant.FENCE));
                            } else if (family.getBaseBlock() == ModBlocks.SMOOTH_DEEPSLATE.get()) {
                                familyWithExistingFullBlock(family.getBaseBlock()).wall(ModBlocks.SMOOTH_DEEPSLATE_WALL.get());
                                createSmoothDeepslateSlab();
                                familyWithExistingFullBlock(family.getBaseBlock()).stairs(ModBlocks.SMOOTH_DEEPSLATE_STAIRS.get());
                                familyWithExistingFullBlock(family.getBaseBlock()).fence(ModBlocks.SMOOTH_DEEPSLATE_FENCE.get());
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
