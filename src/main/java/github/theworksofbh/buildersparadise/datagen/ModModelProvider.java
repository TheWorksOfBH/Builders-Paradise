package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, BuildersParadise.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels = new ModItemModelGenerator(itemModels.itemModelOutput, itemModels.modelOutput);
        blockModels = new ModBlockModelGenerator(blockModels.blockStateOutput, blockModels.itemModelOutput, itemModels.modelOutput);
        super.registerModels(blockModels, itemModels);
    }
}
