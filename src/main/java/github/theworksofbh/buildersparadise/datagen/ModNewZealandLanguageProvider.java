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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModNewZealandLanguageProvider extends LanguageProvider {
    public ModNewZealandLanguageProvider(PackOutput output) {
        super(output, BuildersParadise.MODID, "en_nz");
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
                ModBlocks.BISMUTH_WALL_TORCH.get(),
                ModBlocks.URANIUM_WALL_TORCH.get()
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTranslations.stream(),
                ModBlocks.BLOCKS.getEntries().stream().map(Supplier::get)
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
                ModItems.ITEMS.getEntries().stream().map(Supplier::get)
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
        String sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = "";

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
        } else if (reformatted.contains("bismuth block")) {
            if (reformatted.contains("raw")){
                readjusted = reformatted.replace("raw bismuth block", "block of raw bismuth");
            } else {
                readjusted = reformatted.replace("bismuth block", "block of bismuth");
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
        } else if (reformatted.contains("carbon block")) {
            readjusted = reformatted.replace("carbon block", "block of carbon");
        } else {
            readjusted = reformatted;
        }

        if (readjusted.contains("ize")) {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted.replace("ize", "ise");
        } else if (readjusted.contains("gray")) {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted.replace("gray", "grey");
        } else if (readjusted.contains("armor")) {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted.replace("armor", "armour");
        } else if (readjusted.contains("chiseled")) {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted.replace("chiseled", "chiselled");
        } else if (readjusted.contains("sulfur")) {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted.replace("sulfur", "sulphur");
        } else {
            sorryIcouldNotThinkOfAgoodPunRelatingToKiwis = readjusted;
        }

        String[] words = sorryIcouldNotThinkOfAgoodPunRelatingToKiwis.split(" ");

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

        Map<String, String> bannerColorNames = new HashMap<>();

        bannerColorNames.put("white", "White");
        bannerColorNames.put("orange", "Orange");
        bannerColorNames.put("magenta", "Magenta");
        bannerColorNames.put("light_blue", "Blue");
        bannerColorNames.put("yellow", "Yellow");
        bannerColorNames.put("lime", "Lime");
        bannerColorNames.put("pink", "Pink");
        bannerColorNames.put("gray", "Grey");
        bannerColorNames.put("light_gray", "Light Grey");
        bannerColorNames.put("cyan", "Cyan");
        bannerColorNames.put("purple", "Purple");
        bannerColorNames.put("blue", "Blue");
        bannerColorNames.put("brown", "Brown");
        bannerColorNames.put("green", "Green");
        bannerColorNames.put("red", "Red");
        bannerColorNames.put("black", "Black");

        Map<Integer, String> patternNames = new HashMap<>();

        patternNames.put(0, "Quarter Chief");
        patternNames.put(1, "Quarter Base");
        patternNames.put(2, "Sixth Chief");
        patternNames.put(3, "Sixth Base");
        patternNames.put(4, "Quarter Pale Dexter");
        patternNames.put(5, "Quarter Pale Sinister");
        patternNames.put(6, "Sixth Pale Dexter");
        patternNames.put(7, "Sixth Pale Sinister");
        patternNames.put(8, "Chief Sinister Quadrant");
        patternNames.put(9, "Chief Dexter Quadrant");
        patternNames.put(10, "Base Sinister Quadrant");
        patternNames.put(11, "Base Dexter Quadrant");
        patternNames.put(12, "Offset Cross");
        patternNames.put(13, "Inverted Offset Cross");
        patternNames.put(14, "Per Saltire");
        patternNames.put(15, "Inverted Per Saltire");
        patternNames.put(16, "Long Chevron");
        patternNames.put(17, "Inverted Long Chevron");
        patternNames.put(18, "Barry");
        patternNames.put(19, "Bendy Dexter");
        patternNames.put(20, "Bendy Sinister");
        patternNames.put(21, "Checkerboard");
        patternNames.put(22, "Inverted Checkerboard");
        patternNames.put(23, "Rhombus");
        patternNames.put(24, "Majuscule Outlined Pentagram");
        patternNames.put(25, "Majuscule Full Pentagram");
        patternNames.put(26, "Majuscule Outlined Hexagram");
        patternNames.put(27, "Majuscule Full Hexagram");
        patternNames.put(28, "Miniscule Outlined Pentagram");
        patternNames.put(29, "Miniscule Full Pentagram");
        patternNames.put(30, "Miniscule Outlined Hexagram");
        patternNames.put(31, "Miniscule Full Hexagram");
        patternNames.put(32, "Chief Canton Pentagram");
        patternNames.put(33, "Chief Sinister Canton Pentagram");
        patternNames.put(34, "Chief Dexter Canton Pentagram");
        patternNames.put(35, "Base Canton Pentagram");
        patternNames.put(36, "Base Sinister Canton Pentagram");
        patternNames.put(37, "Base Dexter Canton Pentagram");
        patternNames.put(38, "Heart");
        patternNames.put(39, "Diamond");
        patternNames.put(40, "Chief Canton Hexagram");
        patternNames.put(41, "Chief Sinister Canton Hexagram");
        patternNames.put(42, "Chief Dexter Canton Hexagram");
        patternNames.put(43, "Base Canton Hexagram");
        patternNames.put(44, "Base Sinister Canton Hexagram");
        patternNames.put(45, "Base Dexter Canton Hexagram");
        patternNames.put(46, "Spade");
        patternNames.put(47, "Club");
        patternNames.put(48, "Chief Sinister Per Bend");
        patternNames.put(49, "Chief Dexter Per Bend");
        patternNames.put(50, "Base Sinister Per Bend");
        patternNames.put(51, "Base Dexter Per Bend");
        patternNames.put(52, "Chief Per Pale");
        patternNames.put(53, "Base Per Pale");
        patternNames.put(54, "Sinister Per Fess");
        patternNames.put(55, "Dexter Per Fess");

        for (Map.Entry<Integer, String> patternEntry : patternNames.entrySet()) {
            int patternIndex = patternEntry.getKey();
            String patternDisplayName = patternEntry.getValue();

            String patternId = "pattern_" + patternIndex;

            String patternTranslationKey = "block.minecraft.banner." + patternId;

            String patternTranslationValue = patternDisplayName;

            this.add(patternTranslationKey, patternTranslationValue);

            for (Map.Entry<String, String> colorEntry : bannerColorNames.entrySet()) {
                String colorId = colorEntry.getKey();
                String colorDisplayName = colorEntry.getValue();

                String translationKey = "block.minecraft.banner." + patternId + "." + colorId;

                String translationValue = colorDisplayName + " " + patternDisplayName;

                this.add(translationKey, translationValue);
            }
        }

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
        this.add("trim_material.buildersparadise.bismuth", "Bismuth Material");
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
