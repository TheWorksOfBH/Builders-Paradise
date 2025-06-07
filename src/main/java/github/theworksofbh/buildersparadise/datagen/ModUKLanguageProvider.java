package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModUKLanguageProvider extends LanguageProvider {
    public ModUKLanguageProvider(PackOutput output) {
        super(output, BuildersParadise.MODID, "en_gb");
    }

    protected Iterable<Block> getKnownBlocks() {
        List<DeferredBlock<?>> handMadeBlocks = List.of(

        );
        Collection<DeferredHolder<Block, ? extends Block>> BLOCKS = ModBlocks.BLOCKS.getEntries();
        Set<DeferredHolder<Block, ? extends Block>> COPY = new HashSet<>(BLOCKS);

        for (DeferredBlock<?> block : handMadeBlocks) {
            COPY.remove(block);
        }

        return COPY.stream()
                .map(DeferredHolder::value)
                .collect(Collectors.toList());
    }

    protected Iterable<Item> getKnownItems() {
        List<DeferredBlock<?>> handMadeItems = List.of(

        );
        Collection<DeferredHolder<Item, ? extends Item>> ITEMS = ModItems.ITEMS.getEntries();
        Set<DeferredHolder<Item, ? extends Item>> COPY = new HashSet<>(ITEMS);

        for (DeferredBlock<?> item : handMadeItems) {
            COPY.remove(item);
        }

        return COPY.stream()
                .map(DeferredHolder::value)
                .collect(Collectors.toList());
    }

    protected Iterable<MobEffect> getKnownEffects() {
        List<DeferredBlock<?>> handMadeEffects = List.of(

        );
        Collection<DeferredHolder<MobEffect, ? extends MobEffect>> MOB_EFFECTS = ModEffects.MOB_EFFECTS.getEntries();
        Set<DeferredHolder<MobEffect, ? extends MobEffect>> COPY = new HashSet<>(MOB_EFFECTS);

        for (DeferredBlock<?> effect : handMadeEffects) {
            COPY.remove(effect);
        }

        return COPY.stream()
                .map(DeferredHolder::value)
                .collect(Collectors.toList());
    }

    public static String formatString(String input) {
        String replaced = input.replace('_', ' ');
        String reformatted = "";
        String readjusted = "";
        String briIsh = "";
        
        if (replaced.contains("item")) {
            reformatted = replaced.replace("item.buildersparadise.", "");
        } else if (replaced.contains("block")) {
            reformatted = replaced.replace("block.buildersparadise.", "");
        }  else if (replaced.contains("effect")) {
            reformatted = replaced.replace("effect.buildersparadise.", "");
        }

        if (reformatted.contains("iron block")) {
            readjusted = reformatted.replace("iron block", "block of iron");
        } else if (reformatted.contains("charcoal block")) {
            readjusted = reformatted.replace("charcoal block", "block of charcoal");
        } else if (reformatted.contains("zinc block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw zinc block", "block of raw zinc");
            } else {
                readjusted = reformatted.replace("zinc block", "block of zinc");
            }
        } else if (reformatted.contains("silver block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw silver block", "block of raw silver");
            } else {
                readjusted = reformatted.replace("silver block", "block of silver");
            }
        } else if (reformatted.contains("tin block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw tin block", "block of raw tin");
            } else {
                readjusted = reformatted.replace("tin block", "block of tin");
            }
        } else if (reformatted.contains("tungsten block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw tungsten block", "block of raw tungsten");
            } else {
                readjusted = reformatted.replace("tungsten block", "block of tungsten");
            }
        } else if (reformatted.contains("platinum block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw platinum block", "block of raw platinum");
            } else {
                readjusted = reformatted.replace("platinum block", "block of platinum");
            }
        } else if (reformatted.contains("lead block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw lead block", "block of raw lead");
            } else {
                readjusted = reformatted.replace("lead block", "block of lead");
            }
        } else if (reformatted.contains("uranium block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw uranium block", "block of raw uranium");
            } else {
                readjusted = reformatted.replace("uranium block", "block of uranium");
            }
        } else if (reformatted.contains("bronze block")) {
            readjusted = reformatted.replace("bronze block", "block of bronze");
        } else if (reformatted.contains("brass block")) {
            readjusted = reformatted.replace("brass block", "block of brass");
        } else if (reformatted.contains("steel block")) {
            readjusted = reformatted.replace("steel block", "block of steel");
        } else {
            readjusted = reformatted;
        }

        if (readjusted.contains("ize")) {
            briIsh = readjusted.replace("ize", "ise");
        } else {
            briIsh = readjusted;
        }

        String[] words = briIsh.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.equals("of")){
                    result.append(word).append(" ");
                } else {
                    result.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1))
                            .append(" ");
                }
            }
        }
        return result.toString().trim();
    }

    @Override
    protected void addTranslations() {
        getKnownBlocks().forEach(
                block -> {
                    this.add(block, formatString(block.getDescriptionId()));
                }
        );
        getKnownItems().forEach(
                item -> {
                    this.add(item, formatString(item.getDescriptionId()));
                }
        );
        getKnownEffects().forEach(
                effect -> {
                    this.add(effect, formatString(effect.getDescriptionId()));
                }
        );
        this.add("death.attack.radiation", "%1$s received an unhealthy dose of nuclear radiation");
        this.add("death.attack.radiation.player", "%1$s received an unhealthy dose of nuclear radiation while trying to escape %2$s");

    }
}
