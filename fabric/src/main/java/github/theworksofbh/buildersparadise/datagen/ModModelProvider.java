package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModels) {
        ItemModelGenerators itemModels = new ItemModelGenerators(blockModels.itemModelOutput, blockModels.modelOutput);

        ModBlockModelGenerator modBlockModels = new ModBlockModelGenerator(
                blockModels.blockStateOutput,
                blockModels.itemModelOutput,
                itemModels.modelOutput
        );

        modBlockModels.run();
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModels) {
        ModItemModelGenerator modItemModels = new ModItemModelGenerator(
                itemModels.itemModelOutput,
                itemModels.modelOutput
        );

        modItemModels.run();
    }

    @Override
    public String getName() {
        return BuildersParadiseConstants.MOD_ID + " models";
    }
}

