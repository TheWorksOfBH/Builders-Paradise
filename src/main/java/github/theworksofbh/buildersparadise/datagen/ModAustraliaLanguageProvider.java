package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadise;
import github.theworksofbh.buildersparadise.block.ModBlocks;
import github.theworksofbh.buildersparadise.effect.ModEffects;
import github.theworksofbh.buildersparadise.entity.ModEntities;
import github.theworksofbh.buildersparadise.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModAustraliaLanguageProvider extends LanguageProvider {
    public ModAustraliaLanguageProvider(PackOutput output) {
        super(output, BuildersParadise.MODID, "en_au");
    }

    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTranslations = Set.of(

        );

        Set<Block> handMadeBlocks = Set.of(
                ModBlocks.IRON_WALL_TORCH.get(),
                ModBlocks.ZINC_WALL_TORCH.get(),
                ModBlocks.SILVER_WALL_TORCH.get(),
                ModBlocks.TIN_WALL_TORCH.get(),
                ModBlocks.TUNGSTEN_WALL_TORCH.get(),
                ModBlocks.PLATINUM_WALL_TORCH.get(),
                ModBlocks.GOLD_WALL_TORCH.get(),
                ModBlocks.LEAD_WALL_TORCH.get(),
                ModBlocks.URANIUM_WALL_TORCH.get()
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTranslations.stream(),
                ModBlocks.BLOCKS.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeBlocks::contains))
        ).toList();
    }

    protected Iterable<Item> getKnownItems() {
        Set<Item> vanillaItemsThatNeedNewTranslations = Set.of(
        );

        Set<Item> handMadeItems = Set.of(

        );

        return Stream.concat(
                vanillaItemsThatNeedNewTranslations.stream(),
                ModItems.ITEMS.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeItems::contains))
        ).toList();
    }

    protected Iterable<MobEffect> getKnownEffects() {
        Set<MobEffect> vanillaEffectsThatNeedNewTranslations = Set.of(
        );

        Set<MobEffect> handMadeEffects = Set.of(

        );

        return Stream.concat(
                vanillaEffectsThatNeedNewTranslations.stream(),
                ModEffects.MOB_EFFECTS.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeEffects::contains))
        ).toList();
    }

    protected Iterable<EntityType<?>> getKnownEntities() {
        Set<EntityType<?>> vanillaEntitiesThatNeedNewTranslations = Set.of(
        );

        Set<EntityType<?>> handMadeEntities = Set.of(

        );

        return Stream.concat(
                vanillaEntitiesThatNeedNewTranslations.stream(),
                ModEntities.ENTITIES.getEntries().stream().map(
                        Supplier::get
                )
        ).filter(
                (Predicate.not(handMadeEntities::contains))
        ).toList();
    }

    public static String formatString(String input) {
        String replaced = input.replace('_', ' ');
        String reformatted = "";
        String readjusted = "";
        String imAussieM8 = "";

        if (replaced.contains("item")) {
            reformatted = replaced.replace("item.buildersparadise.", "");
        } else if (replaced.contains("block")) {
            reformatted = replaced.replace("block.buildersparadise.", "");
        } else if (replaced.contains("effect")) {
            reformatted = replaced.replace("effect.buildersparadise.", "");
        } else if (replaced.contains("stat")) {
            reformatted = replaced.replace("stat.buildersparadise.", "");
        } else if (replaced.contains("entity")) {
            reformatted = replaced.replace("entity.buildersparadise.", "");
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
        } else if (reformatted.contains("lapis")) {
            readjusted = reformatted.replace("lapis", "lapis lazuli");
        } else if (reformatted.contains("music disc")) {
            readjusted = "music disc";
        } else if (reformatted.contains("chest boat")) {
            readjusted = reformatted.replace("chest boat", "boat with chest");
        } else if (reformatted.contains("minecart")) {
            readjusted = "minecart with " + reformatted.replace(" minecart", "");
        } else if (reformatted.contains("smithing template")) {
            readjusted = reformatted.replace("smithing template", "");
        } else {
            readjusted = reformatted;
        }

        if (readjusted.contains("ize")) {
            imAussieM8 = readjusted.replace("ize", "ise");
        } else if (readjusted.contains("gray")) {
            imAussieM8 = readjusted.replace("gray", "grey");
        } else if (readjusted.contains("armor")) {
            imAussieM8 = readjusted.replace("armor", "armour");
        } else {
            imAussieM8 = readjusted;
        }

        String[] words = imAussieM8.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.equals("of") || word.equals("with")){
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
        getKnownEntities().forEach(
                entityType -> {
                    this.add(entityType, formatString(entityType.getDescriptionId()));
                }
        );
        this.add("death.attack.radiation", "%1$s received an unhealthy dose of nuclear radiation");
        this.add("death.attack.radiation.player", "%1$s received an unhealthy dose of nuclear radiation while trying to escape %2$s");
        this.add("stat.buildersparadise.interact_with_fletching_table", "Interactions with Fletching Table");
        this.add("container.fletching", "Fletching");
        this.add("jukebox_song.buildersparadise.circuitric_magnet", "The Works of BH - Circuitric Magnet");
        this.add("jukebox_song.buildersparadise.angry_boyfriends", "The Works of BH - Angry Boyfriends");
        this.add("item.buildersparadise.smithing_template.bronze_upgrade.applies_to", "Copper Equipment");
        this.add("item.buildersparadise.smithing_template.bronze_upgrade.ingredients", "Bronze Ingot");
        this.add("item.buildersparadise.smithing_template.bronze_upgrade.base_slot_description", "Add copper armour, weapon, or tool");
        this.add("item.buildersparadise.smithing_template.bronze_upgrade.additions_slot_description", "Add Bronze Ingot");
        this.add("trim_material.buildersparadise.zinc", "Zinc Material");
        this.add("trim_material.buildersparadise.silver", "Silver Material");
        this.add("trim_material.buildersparadise.tin", "Tin Material");
        this.add("trim_material.buildersparadise.tungsten", "Tungsten Material");
        this.add("trim_material.buildersparadise.platinum", "Platinum Material");
        this.add("trim_material.buildersparadise.lead", "Lead Material");
        this.add("trim_material.buildersparadise.uranium", "Uranium Material");
        this.add("trim_material.buildersparadise.bronze", "Bronze Material");
        this.add("trim_material.buildersparadise.brass", "Brass Material");
        this.add("trim_material.buildersparadise.steel", "Steel Material");
        this.add("trim_material.buildersparadise.sculk", "Sculk Material");
        this.add("jukebox_song.minecraft.creator", "Leif Chappelle - Creator");
        this.add("jukebox_song.minecraft.creator_music_box", "Leif Chappelle - Creator (Music Box)");
        this.add("jukebox_song.minecraft.otherside", "Leif Chappelle - otherside");
        this.add("jukebox_song.minecraft.pigstep", "Leif Chappelle - Pigstep");
        this.add("item.minecraft.music_disc_creator.desc", "Leif Chappelle - Creator");
        this.add("item.minecraft.music_disc_creator_music_box.desc", "Leif Chappelle - Creator (Music Box)");
        this.add("item.minecraft.music_disc_otherside.desc", "Leif Chappelle - otherside");
        this.add("item.minecraft.music_disc_pigstep.desc", "Leif Chappelle - Pigstep");
        this.add("music.game.ancestry", "Leif Chappelle - Ancestry");
        this.add("music.game.deeper", "Leif Chappelle - Deeper");
        this.add("music.game.eld_unknown", "Leif Chappelle - Eld Unknown");
        this.add("music.game.endless", "Leif Chappelle - Endless");
        this.add("music.game.infinite_amethyst", "Leif Chappelle - Infinite Amethyst");
        this.add("music.game.left_to_bloom", "Leif Chappelle - Left to Bloom");
        this.add("music.game.one_more_day", "Leif Chappelle - One More Day");
        this.add("music.game.stand_tall", "Leif Chappelle - Stand Tall");
        this.add("music.game.wending", "Leif Chappelle - Wending");
        this.add("music.game.nether.crimson_forest.chrysopoeia", "Leif Chappelle - Chrysopoeia");
        this.add("music.game.nether.nether_wastes.rubedo", "Leif Chappelle - Rubedo");
        this.add("music.game.nether.soulsand_valley.so_below", "Leif Chappelle - So Below");
        this.add("music.game.swamp.aerie", "Leif Chappelle - Aerie");
        this.add("music.game.swamp.firebugs", "Leif Chappelle - Firebugs");
        this.add("music.game.swamp.labyrinthine", "Leif Chappelle - Labyrinthine");
        this.add("block.minecraft.lantern", "Iron Lantern");
        this.add("block.minecraft.soul_lantern", "Iron Soul Lantern");
    }
}
