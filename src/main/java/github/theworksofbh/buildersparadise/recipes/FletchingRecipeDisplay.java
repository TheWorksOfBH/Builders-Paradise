package github.theworksofbh.buildersparadise.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

public record FletchingRecipeDisplay(SlotDisplay arrow, SlotDisplay ingredient, SlotDisplay result, SlotDisplay craftingStation) implements RecipeDisplay {
    public static final MapCodec<FletchingRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(
            p_380861_ -> p_380861_.group(
                            SlotDisplay.CODEC.fieldOf("arrow").forGetter(FletchingRecipeDisplay::arrow),
                            SlotDisplay.CODEC.fieldOf("ingredient").forGetter(FletchingRecipeDisplay::ingredient),
                            SlotDisplay.CODEC.fieldOf("result").forGetter(FletchingRecipeDisplay::result),
                            SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(FletchingRecipeDisplay::craftingStation)
                    )
                    .apply(p_380861_, FletchingRecipeDisplay::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, FletchingRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
            SlotDisplay.STREAM_CODEC,
            FletchingRecipeDisplay::arrow,
            SlotDisplay.STREAM_CODEC,
            FletchingRecipeDisplay::ingredient,
            SlotDisplay.STREAM_CODEC,
            FletchingRecipeDisplay::result,
            SlotDisplay.STREAM_CODEC,
            FletchingRecipeDisplay::craftingStation,
            FletchingRecipeDisplay::new
    );
    public static final RecipeDisplay.Type<FletchingRecipeDisplay> TYPE = new RecipeDisplay.Type<>(MAP_CODEC, STREAM_CODEC);

    @Override
    public RecipeDisplay.Type<FletchingRecipeDisplay> type() { return TYPE; };
}
