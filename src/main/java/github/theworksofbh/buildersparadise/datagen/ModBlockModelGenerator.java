package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModBlockModelGenerator extends BlockModelGenerators {


    public ModBlockModelGenerator(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
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
        } else {
            TexturedModel texturedModel = BlockModelGenerators.TEXTURED_MODELS.getOrDefault(fullBlock, TexturedModel.CUBE.get(fullBlock));
            mapping = texturedModel.getMapping().put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock));
        }
        if (fullBlock == Blocks.BASALT || fullBlock == Blocks.POLISHED_BASALT || fullBlock == Blocks.QUARTZ_BLOCK) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock, "_side"));
        } else if (fullBlock == Blocks.SMOOTH_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
        } else if (fullBlock == Blocks.SMOOTH_RED_SANDSTONE) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"));
        } else if (fullBlock == ModBlocks.SMOOTH_SOUL_SANDSTONE.get()) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE.get(), "_top"));
        } else if (fullBlock == Blocks.SMOOTH_QUARTZ) {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom"));
        } else {
            mapping.put(TextureSlot.WALL, TextureMapping.getBlockTexture(fullBlock, ""));
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

    public void copyWeightedPressurePlateModel(Block pressurePlateBlock, Block sourceBlock) {
        MultiVariant resourceLocation = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.getDefaultModelLocation(pressurePlateBlock));
        MultiVariant resourceLocation1 = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.getDefaultModelLocation(pressurePlateBlock));
        itemModelOutput.copy(pressurePlateBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(sourceBlock).with(createEmptyOrFullDispatch(BlockStateProperties.POWER, 1, resourceLocation1, resourceLocation)));
    }

    public void copySlabModel(Block slabBlock, Block sourceBlock) {
        MultiVariant resourceLocation = plainVariant(ModelTemplates.SLAB_BOTTOM.getDefaultModelLocation(slabBlock));
        MultiVariant resourceLocation1 = plainVariant(ModelTemplates.SLAB_TOP.getDefaultModelLocation(slabBlock));
        MultiVariant resourceLocation2 = plainVariant(ModelTemplates.CUBE.getDefaultModelLocation(slabBlock));
        itemModelOutput.copy(slabBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(createSlab(sourceBlock, resourceLocation, resourceLocation1, resourceLocation2));
    }

    public void copyStairModel(Block stairBlock, Block sourceBlock) {
        MultiVariant resourceLocation = plainVariant(ModelTemplates.STAIRS_STRAIGHT.getDefaultModelLocation(stairBlock));
        MultiVariant resourceLocation1 = plainVariant(ModelTemplates.STAIRS_INNER.getDefaultModelLocation(stairBlock));
        MultiVariant resourceLocation2 = plainVariant(ModelTemplates.STAIRS_OUTER.getDefaultModelLocation(stairBlock));
        itemModelOutput.copy(stairBlock.asItem(), sourceBlock.asItem());
        this.blockStateOutput.accept(createStairs(sourceBlock, resourceLocation1, resourceLocation, resourceLocation2));
    }

    public void createWaxedIronBlock() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_BLOCK.get(), ResourceLocation.parse("minecraft:block/iron_block"));
        this.blockStateOutput.accept(
                createSimpleBlock(
                        ModBlocks.WAXED_IRON_BLOCK.get(),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_block"))
                )
        );
    }

    public void createWaxedIronDoor() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_DOOR.get(), ResourceLocation.parse("minecraft:item/iron_door"));
        this.blockStateOutput.accept(
                createDoor(
                        ModBlocks.WAXED_IRON_DOOR.get(),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_bottom_left")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_bottom_left_open")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_bottom_right")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_bottom_right_open")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_top_left")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_top_left_open")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_top_right")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_door_top_right_open"))
                )
        );
    }

    public void createWaxedIronTrapdoor() {
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_TRAPDOOR.get(), ResourceLocation.parse("minecraft:block/iron_trapdoor_bottom"));
        this.blockStateOutput.accept(
                createTrapdoor(
                        ModBlocks.WAXED_IRON_TRAPDOOR.get(),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_trapdoor_top")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_trapdoor_bottom")),
                        plainVariant(ResourceLocation.parse("minecraft:block/iron_trapdoor_open"))
                )
        );
    }

    public void createWaxedIronPressurePlate() {
        this.registerSimpleItemModel(ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ResourceLocation.parse("minecraft:block/heavy_weighted_pressure_plate"));
        this.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.WAXED_HEAVY_WEIGHTED_PRESSURE_PLATE.get())
                        .with(createEmptyOrFullDispatch(BlockStateProperties.POWER,
                                1,
                                plainVariant(ResourceLocation.parse("minecraft:block/heavy_weighted_pressure_plate_down")),
                                plainVariant(ResourceLocation.parse("minecraft:block/heavy_weighted_pressure_plate"))
                        )
                )
        );
    }

    public MultiVariant createBars(Block block, String suffix) {
        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.IRON_BARS, suffix);
        TextureSlot barsSlot = TextureSlot.create("bars");
        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(parent), Optional.of(suffix), TextureSlot.PARTICLE, barsSlot, TextureSlot.EDGE);
        return plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block))
                        .put(barsSlot, TextureMapping.getBlockTexture(block))
                        .put(TextureSlot.EDGE, TextureMapping.getBlockTexture(block)), modelTemplate)
                .create(block, modelOutput));
    }

    public void createBarsBlock(Block block) {
        MultiVariant resourcelocation = createBars(block, "_post_ends");
        MultiVariant resourcelocation1 = createBars(block, "_post");
        MultiVariant resourcelocation2 = createBars(block, "_cap");
        MultiVariant resourcelocation3 = createBars(block, "_cap_alt");
        MultiVariant resourcelocation4 = createBars(block, "_side");
        MultiVariant resourcelocation5 = createBars(block, "_side_alt");
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(block)
                        .with(resourcelocation)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), resourcelocation3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), resourcelocation3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), resourcelocation4)
                        .with(condition().term(BlockStateProperties.EAST, true), resourcelocation4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), resourcelocation5)
                        .with(condition().term(BlockStateProperties.WEST, true), resourcelocation5.with(Y_ROT_90))
        );
        this.registerSimpleFlatItemModel(block);
    }

    public void copyBarsModel(Block sourceBlock, Block targetBlock) {
        MultiVariant resourcelocation = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_post_ends"));
        MultiVariant resourcelocation1 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_post"));
        MultiVariant resourcelocation2 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_cap"));
        MultiVariant resourcelocation3 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_cap_alt"));
        MultiVariant resourcelocation4 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_side"));
        MultiVariant resourcelocation5 = plainVariant(ModelLocationUtils.getModelLocation(sourceBlock, "_side_alt"));
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(targetBlock)
                        .with(resourcelocation)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), resourcelocation3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), resourcelocation3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), resourcelocation4)
                        .with(condition().term(BlockStateProperties.EAST, true), resourcelocation4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), resourcelocation5)
                        .with(condition().term(BlockStateProperties.WEST, true), resourcelocation5.with(Y_ROT_90))
        );
        this.itemModelOutput.copy(sourceBlock.asItem(), targetBlock.asItem());
    }

    public void createWaxedIronBars() {
        MultiVariant resourcelocation = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_post_ends"));
        MultiVariant resourcelocation1 = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_post"));
        MultiVariant resourcelocation2 = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_cap"));
        MultiVariant resourcelocation3 = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_cap_alt"));
        MultiVariant resourcelocation4 = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_side"));
        MultiVariant resourcelocation5 = plainVariant(ResourceLocation.parse("minecraft:block/iron_bars_side_alt"));
        this.blockStateOutput.accept(
                MultiPartGenerator.multiPart(ModBlocks.WAXED_IRON_BARS.get())
                        .with(resourcelocation)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation1)
                        .with(condition().term(BlockStateProperties.NORTH, true)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, true)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, false), resourcelocation2.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, true)
                                .term(BlockStateProperties.WEST, false), resourcelocation3)
                        .with(condition().term(BlockStateProperties.NORTH, false)
                                .term(BlockStateProperties.EAST, false)
                                .term(BlockStateProperties.SOUTH, false)
                                .term(BlockStateProperties.WEST, true), resourcelocation3.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.NORTH, true), resourcelocation4)
                        .with(condition().term(BlockStateProperties.EAST, true), resourcelocation4.with(Y_ROT_90))
                        .with(condition().term(BlockStateProperties.SOUTH, true), resourcelocation5)
                        .with(condition().term(BlockStateProperties.WEST, true), resourcelocation5.with(Y_ROT_90))
        );
        this.registerSimpleItemModel(ModBlocks.WAXED_IRON_BARS.get(), ResourceLocation.parse("minecraft:item/iron_bars"));
    }

    public void createCustomPressurePlate(Block pressurePlate, Block baseBlock) {
        TextureMapping textureMapping = TextureMapping.defaultTexture(baseBlock);
        MultiVariant resourcelocation = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMapping, this.modelOutput));
        MultiVariant resourcelocation1 = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMapping, this.modelOutput));
        this.blockStateOutput.accept(createPressurePlate(pressurePlate, resourcelocation, resourcelocation1));
    }

    public void createNuke(Block nukeBlock, TexturedModel.Provider modelProvider) {
        MultiVariant resourcelocation = plainVariant(modelProvider.create(nukeBlock, this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(nukeBlock, resourcelocation).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
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
        this.createTrapdoor(ModBlocks.NETHERITE_TRAPDOOR.get());

        this.createBarsBlock(ModBlocks.MILDLY_RUSTED_IRON_BARS.get());
        this.createBarsBlock(ModBlocks.MODERATELY_RUSTED_IRON_BARS.get());
        this.createBarsBlock(ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get());

        this.createWaxedIronBars();
        this.copyBarsModel(ModBlocks.MILDLY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_BARS.get());
        this.copyBarsModel(ModBlocks.MODERATELY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BARS.get());
        this.copyBarsModel(ModBlocks.EXTREMELY_RUSTED_IRON_BARS.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BARS.get());

        this.createTrivialCube(ModBlocks.IRON_TILES.get());
        this.createTrivialCube(ModBlocks.MILDLY_RUSTED_IRON_TILES.get());
        this.createTrivialCube(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get());
        this.createTrivialCube(ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get());

        this.copyModel(ModBlocks.IRON_TILES.get(), ModBlocks.WAXED_IRON_TILES.get());
        this.copyModel(ModBlocks.MILDLY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILES.get());
        this.copyModel(ModBlocks.MODERATELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILES.get());
        this.copyModel(ModBlocks.EXTREMELY_RUSTED_IRON_TILES.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILES.get());

        this.copySlabModel(ModBlocks.IRON_TILE_SLAB.get(), ModBlocks.WAXED_IRON_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.MILDLY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.MODERATELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_SLAB.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_SLAB.get());

        this.copyStairModel(ModBlocks.IRON_TILE_STAIRS.get(), ModBlocks.WAXED_IRON_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.MILDLY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.MODERATELY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.EXTREMELY_RUSTED_IRON_TILE_STAIRS.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TILE_STAIRS.get());

        this.createDoor(ModBlocks.MILDLY_RUSTED_IRON_DOOR.get());
        this.createDoor(ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get());
        this.createDoor(ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get());

        this.createWaxedIronDoor();
        this.copyDoorModel(ModBlocks.MILDLY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_DOOR.get());
        this.copyDoorModel(ModBlocks.MODERATELY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_DOOR.get());
        this.copyDoorModel(ModBlocks.EXTREMELY_RUSTED_IRON_DOOR.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_DOOR.get());

        this.createTrapdoor(ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get());
        this.createTrapdoor(ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get());
        this.createTrapdoor(ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

        this.createWaxedIronTrapdoor();
        this.copyTrapdoorModel(ModBlocks.MILDLY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.MODERATELY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.EXTREMELY_RUSTED_IRON_TRAPDOOR.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_TRAPDOOR.get());

        this.createTrivialCube(ModBlocks.SILVER_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_SILVER_BLOCK.get());

        this.createTrivialCube(ModBlocks.SILVER_BLOCK.get());
        this.createTrivialCube(ModBlocks.SILVER_TILES.get());
        this.createDoor(ModBlocks.SILVER_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.SILVER_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SILVER_BLOCK.get());

        this.createTrivialCube(ModBlocks.TIN_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_TIN_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_TIN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TIN_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_TIN.get());
        this.createDoor(ModBlocks.TIN_DOOR.get());
        this.createTrapdoor(ModBlocks.TIN_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.BARELY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.TIN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TUNGSTEN_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_TUNGSTEN_BLOCK.get());

        this.createTrivialCube(ModBlocks.TUNGSTEN_BLOCK.get());
        this.createTrivialCube(ModBlocks.TUNGSTEN_TILES.get());
        this.createDoor(ModBlocks.TUNGSTEN_DOOR.get());
        this.createTrapdoor(ModBlocks.TUNGSTEN_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.TUNGSTEN_BLOCK.get());

        this.createTrivialCube(ModBlocks.PLATINUM_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_PLATINUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.PLATINUM_BLOCK.get());
        this.createTrivialCube(ModBlocks.PLATINUM_TILES.get());
        this.createDoor(ModBlocks.PLATINUM_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.PLATINUM_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.EXTRAORDINARILY_LIGHT_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.PLATINUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.LEAD_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK.get());

        this.createTrivialCube(ModBlocks.LEAD_BLOCK.get());
        this.createTrivialCube(ModBlocks.LEAD_TILES.get());
        this.createDoor(ModBlocks.LEAD_DOOR.get());
        this.createTrapdoor(ModBlocks.LEAD_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NOTICEABLY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.LEAD_BLOCK.get());

        this.createTrivialCube(ModBlocks.URANIUM_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_URANIUM_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_URANIUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.URANIUM_BLOCK.get());
        this.createTrivialCube(ModBlocks.URANIUM_TILES.get());
        this.createDoor(ModBlocks.URANIUM_DOOR.get());
        this.createTrapdoor(ModBlocks.URANIUM_TRAPDOOR.get());
        this.createWeightedPressurePlate(ModBlocks.NEGLIGIBLE_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.URANIUM_BLOCK.get());

        this.createTrivialCube(ModBlocks.ZINC_ORE.get());
        this.createTrivialCube(ModBlocks.DEEPSLATE_ZINC_ORE.get());
        this.createTrivialCube(ModBlocks.RAW_ZINC_BLOCK.get());

        this.createTrivialCube(ModBlocks.ZINC_BLOCK.get());
        this.createTrivialCube(ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get());
        this.createTrivialCube(ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get());
        this.createTrivialCube(ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get());

        this.createTrivialCube(ModBlocks.ZINC_TILES.get());
        this.createTrivialCube(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get());
        this.createTrivialCube(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get());
        this.createTrivialCube(ModBlocks.REALLY_CORRODED_ZINC_TILES.get());

        this.createDoor(ModBlocks.ZINC_DOOR.get());
        this.createDoor(ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get());
        this.createDoor(ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get());
        this.createDoor(ModBlocks.REALLY_CORRODED_ZINC_DOOR.get());

        this.createOrientableTrapdoor(ModBlocks.ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
        this.createOrientableTrapdoor(ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get());

        this.copyModel(ModBlocks.ZINC_BLOCK.get(), ModBlocks.WAXED_ZINC_BLOCK.get());
        this.copyModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_BLOCK.get());
        this.copyModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_BLOCK.get());
        this.copyModel(ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_BLOCK.get());

        this.copyModel(ModBlocks.ZINC_TILES.get(), ModBlocks.WAXED_ZINC_TILES.get());
        this.copyModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILES.get());
        this.copyModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILES.get());
        this.copyModel(ModBlocks.REALLY_CORRODED_ZINC_TILES.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILES.get());

        this.copySlabModel(ModBlocks.ZINC_TILE_SLAB.get(), ModBlocks.WAXED_ZINC_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_SLAB.get());
        this.copySlabModel(ModBlocks.REALLY_CORRODED_ZINC_TILE_SLAB.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_SLAB.get());

        this.copyStairModel(ModBlocks.ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_ZINC_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TILE_STAIRS.get());
        this.copyStairModel(ModBlocks.REALLY_CORRODED_ZINC_TILE_STAIRS.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TILE_STAIRS.get());

        this.copyDoorModel(ModBlocks.ZINC_DOOR.get(), ModBlocks.WAXED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_DOOR.get());
        this.copyDoorModel(ModBlocks.REALLY_CORRODED_ZINC_DOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_DOOR.get());

        this.copyTrapdoorModel(ModBlocks.ZINC_TRAPDOOR.get(), ModBlocks.WAXED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_ZINC_TRAPDOOR.get());
        this.copyTrapdoorModel(ModBlocks.REALLY_CORRODED_ZINC_TRAPDOOR.get(), ModBlocks.WAXED_REALLY_CORRODED_ZINC_TRAPDOOR.get());

        this.createTrivialCube(ModBlocks.GOLD_TILES.get());
        this.createTrivialCube(ModBlocks.DIAMOND_TILES.get());
        this.createTrivialCube(ModBlocks.EMERALD_TILES.get());
        this.createTrivialCube(ModBlocks.NETHERITE_TILES.get());

        this.createTrivialCube(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get());
        this.createTrivialCube(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get());
        this.createTrivialCube(ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get());

        this.createWeightedPressurePlate(ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get());

        this.createWaxedIronPressurePlate();
        this.copyWeightedPressurePlateModel(ModBlocks.MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MILDLY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MODERATELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        this.createWaxedIronBlock();
        this.copyModel(ModBlocks.MILDLY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_MILDLY_RUSTED_IRON_BLOCK.get());
        this.copyModel(ModBlocks.MODERATELY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_MODERATELY_RUSTED_IRON_BLOCK.get());
        this.copyModel(ModBlocks.EXTREMELY_RUSTED_IRON_BLOCK.get(), ModBlocks.WAXED_EXTREMELY_RUSTED_IRON_BLOCK.get());

        this.createWeightedPressurePlate(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.COPPER_BLOCK);
        this.createWeightedPressurePlate(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.EXPOSED_COPPER);
        this.createWeightedPressurePlate(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.WEATHERED_COPPER);
        this.createWeightedPressurePlate(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), Blocks.OXIDIZED_COPPER);

        this.copyWeightedPressurePlateModel(ModBlocks.MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_EXPOSED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_WEATHERED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_OXIDIZED_MEDIUM_WEIGHTED_PRESSURE_PLATE.get());

        this.createWeightedPressurePlate(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.ZINC_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SLIGHTLY_CORRODED_ZINC_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.SOMEWHAT_CORRODED_ZINC_BLOCK.get());
        this.createWeightedPressurePlate(ModBlocks.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.REALLY_CORRODED_ZINC_BLOCK.get());

        this.copyWeightedPressurePlateModel(ModBlocks.BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_SLIGHTLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_SOMEWHAT_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());
        this.copyWeightedPressurePlateModel(ModBlocks.REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get(), ModBlocks.WAXED_REALLY_CORRODED_BARELY_HEAVY_WEIGHTED_PRESSURE_PLATE.get());

        this.createTrivialCube(ModBlocks.BRONZE_BLOCK.get());
        this.createTrivialCube(ModBlocks.CUT_BRONZE.get());
        this.createDoor(ModBlocks.BRONZE_DOOR.get());
        this.createOrientableTrapdoor(ModBlocks.BRONZE_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.PASSIVE_MOB_ONLY_PRESSURE_PLATE.get(), ModBlocks.BRONZE_BLOCK.get());

        this.createTrivialCube(ModBlocks.BRASS_BLOCK.get());
        this.createTrivialCube(ModBlocks.BRASS_TILES.get());
        this.createDoor(ModBlocks.BRASS_DOOR.get());
        this.createTrapdoor(ModBlocks.BRASS_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.HOSTILE_MOB_ONLY_PRESSURE_PLATE.get(), ModBlocks.BRASS_BLOCK.get());

        this.createTrivialCube(ModBlocks.STEEL_BLOCK.get());
        this.createTrivialCube(ModBlocks.STEEL_TILES.get());
        this.createDoor(ModBlocks.STEEL_DOOR.get());
        this.createTrapdoor(ModBlocks.STEEL_TRAPDOOR.get());
        this.createCustomPressurePlate(ModBlocks.VILLAGER_ONLY_PRESSURE_PLATE.get(), ModBlocks.STEEL_BLOCK.get());

        this.createNonTemplateModelBlock(ModBlocks.NUCLEAR_WASTE.get());
        this.createNuke(ModBlocks.NUKE.get(), TexturedModel.ORIENTABLE);

        ModBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(
                        p_386718_ ->
                        {
                            if (p_386718_.get(BlockFamily.Variant.CHISELED) == ModBlocks.CHISELED_SOUL_SANDSTONE.get()) {
                                familyWithExistingFullBlock(p_386718_.getBaseBlock()).wall(ModBlocks.SOUL_SANDSTONE_WALL.get());
                                familyWithExistingFullBlock(p_386718_.getBaseBlock()).slab(ModBlocks.SOUL_SANDSTONE_SLAB.get());
                                familyWithExistingFullBlock(p_386718_.getBaseBlock()).stairs(ModBlocks.SOUL_SANDSTONE_STAIRS.get());
                            } else {
                                familyWithExistingFullBlock(p_386718_.getBaseBlock()).generateFor(p_386718_);
                            }
                            System.out.println(p_386718_);
                        }
                );
    }
}
