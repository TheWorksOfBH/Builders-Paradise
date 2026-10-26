package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, BuildersParadiseConstants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels = new ModItemModelGenerator(itemModels.itemModelOutput, itemModels.modelOutput);
        blockModels = new ModBlockModelGenerator(blockModels.blockStateOutput, blockModels.itemModelOutput, itemModels.modelOutput);
        super.registerModels(blockModels, itemModels);
    }
}