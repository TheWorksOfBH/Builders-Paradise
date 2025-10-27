package github.theworksofbh.buildersparadise.datagen;

import com.mojang.datafixers.util.Pair;
import github.theworksofbh.buildersparadise.block.ModBlockFamilies;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.items.ModItems;
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
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
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

    public void createCustomCartographyTable(Block block, Block woodType) {
        TextureMapping texturemapping = (new TextureMapping()).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.DOWN, TextureMapping.getBlockTexture(woodType)).put(TextureSlot.UP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.NORTH, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.EAST, TextureMapping.getBlockTexture(block, "_side3")).put(TextureSlot.SOUTH, TextureMapping.getBlockTexture(block, "_side1")).put(TextureSlot.WEST, TextureMapping.getBlockTexture(block, "_side2"));
        this.blockStateOutput.accept(createSimpleBlock(block, plainVariant(ModelTemplates.CUBE.create(block, texturemapping, this.modelOutput))));
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

    public void createCustomBarrel(Block barrel) {
        ResourceLocation resourcelocation = TextureMapping.getBlockTexture(barrel, "_top_open");
        MultiVariant multivariant = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.create(barrel, this.modelOutput));
        MultiVariant multivariant1 = plainVariant(TexturedModel.CUBE_TOP_BOTTOM.get(barrel).updateTextures((p_386917_) -> p_386917_.put(TextureSlot.TOP, resourcelocation)).createWithSuffix(barrel, "_open", this.modelOutput));
        this.blockStateOutput.accept(MultiVariantGenerator.dispatch(barrel).with(PropertyDispatch.initial(BlockStateProperties.OPEN).select(false, multivariant).select(true, multivariant1)).with(ROTATIONS_COLUMN_WITH_FACING));
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
        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.GRINDSTONE);
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
        ResourceLocation unlitVariant = ModelLocationUtils.getModelLocation(Blocks.CAMPFIRE, "_off");

        TextureSlot logSlot = TextureSlot.create("log");

        ModelTemplate modelTemplate = new ModelTemplate(Optional.of(unlitVariant), Optional.of(""), TextureSlot.PARTICLE, logSlot);

        MultiVariant multiVariant = plainVariant(TexturedModel.createDefault(b -> new TextureMapping()
                        .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log"))
                        .put(logSlot, TextureMapping.getBlockTexture(Arrays.stream(campfireBlocks).findFirst().get(), "_log")), modelTemplate)
                .createWithSuffix(Arrays.stream(campfireBlocks).findFirst().get(), "_off", modelOutput));

        for(Block block : campfireBlocks) {
            ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
            String name = id.getPath();
            boolean isSoul = name.contains("soul");

            ResourceLocation litVariant = ModelLocationUtils.getModelLocation(Blocks.CAMPFIRE);

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
        ResourceLocation topTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_top");
        ResourceLocation sideTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_side");
        ResourceLocation emptyFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_empty");
        ResourceLocation occupiedFrontTexture = TextureMapping.getBlockTexture(chiseledBookshelf, "_occupied");

        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.CHISELED_BOOKSHELF);
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
        MultiVariant multivariant = plainVariant((ResourceLocation)CHISELED_BOOKSHELF_SLOT_MODEL_CACHE.computeIfAbsent(blockmodelgenerators$bookslotmodelcachekey, (p_387964_) -> template.createWithSuffix(block, s, texturemapping, this.modelOutput)));
        generator.with(new CombinedCondition(CombinedCondition.Operation.AND, List.of(conditon, condition().term(hasBookProperty, hasBook).build())), multivariant.with(rotation));
    }

    public void createLecternTextureMapping(Block block, Block woodType) {
        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.LECTERN);
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
        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.BREWING_STAND);
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
        ResourceLocation parent = ModelLocationUtils.getModelLocation(Blocks.OBSERVER);

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

        this.registerSimpleItemModel(ModItems.OAK_CAMPFIRE.get(), ResourceLocation.parse("minecraft:item/campfire"));
        this.registerSimpleItemModel(ModItems.OAK_SOUL_CAMPFIRE.get(), ResourceLocation.parse("minecraft:item/soul_campfire"));

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

        this.itemModelOutput.accept(ModItems.OAK_BEEHIVE.get(), ItemModelUtils.selectBlockItemProperty(BeehiveBlock.HONEY_LEVEL, ItemModelUtils.plainModel(ResourceLocation.withDefaultNamespace("block/beehive_empty")), Map.of(5, ItemModelUtils.plainModel(ResourceLocation.withDefaultNamespace("block/beehive_honey")))));

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

        this.registerSimpleItemModel(ModItems.OAK_CHISELED_BOOKSHELF.get(), ResourceLocation.parse("minecraft:block/chiseled_bookshelf_inventory"));

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

        this.registerSimpleItemModel(ModItems.STONE_BREWING_STAND.get(), ResourceLocation.parse("minecraft:item/brewing_stand"));

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
