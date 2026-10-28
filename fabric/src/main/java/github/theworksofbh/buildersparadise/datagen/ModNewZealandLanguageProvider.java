
package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ModNewZealandLanguageProvider extends FabricLanguageProvider {

    public ModNewZealandLanguageProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, "en_nz", registriesFuture);
    }

    private Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTranslations = Set.of();

        Set<Block> handMadeBlocks = Set.of(
                ModBlocks.IRON_WALL_TORCH,
                ModBlocks.ZINC_WALL_TORCH,
                ModBlocks.SILVER_WALL_TORCH,
                ModBlocks.TIN_WALL_TORCH,
                ModBlocks.TUNGSTEN_WALL_TORCH,
                ModBlocks.PLATINUM_WALL_TORCH,
                ModBlocks.GOLD_WALL_TORCH,
                ModBlocks.LEAD_WALL_TORCH,
                ModBlocks.BISMUTH_WALL_TORCH,
                ModBlocks.URANIUM_WALL_TORCH
        );

        return Stream.concat(
                vanillaBlocksThatNeedNewTranslations.stream(),
                BuiltInRegistries.BLOCK.stream()
                        .filter(block -> BuiltInRegistries.BLOCK
                                .getKey(block)
                                .getNamespace()
                                .equals(BuildersParadiseConstants.MOD_ID))
        ).filter(Predicate.not(handMadeBlocks::contains)).toList();
    }

    private Iterable<Item> getKnownItems() {
        Set<Item> vanillaItemsThatNeedNewTranslations = Set.of();
        Set<Item> handMadeItems = Set.of();

        return Stream.concat(
                vanillaItemsThatNeedNewTranslations.stream(),
                BuiltInRegistries.ITEM.stream()
                        .filter(item -> BuiltInRegistries.ITEM
                                .getKey(item)
                                .getNamespace()
                                .equals(BuildersParadiseConstants.MOD_ID))
        ).filter(Predicate.not(handMadeItems::contains)).toList();
    }

    private Iterable<MobEffect> getKnownEffects() {
        Set<MobEffect> vanillaEffectsThatNeedNewTranslations = Set.of();
        Set<MobEffect> handMadeEffects = Set.of();

        return Stream.concat(
                vanillaEffectsThatNeedNewTranslations.stream(),
                BuiltInRegistries.MOB_EFFECT.stream()
                        .filter(effect -> BuiltInRegistries.MOB_EFFECT
                                .getKey(effect)
                                .getNamespace()
                                .equals(BuildersParadiseConstants.MOD_ID))
        ).filter(Predicate.not(handMadeEffects::contains)).toList();
    }

    private Iterable<EntityType<?>> getKnownEntities() {
        Set<EntityType<?>> vanillaEntitiesThatNeedNewTranslations = Set.of();
        Set<EntityType<?>> handMadeEntities = Set.of();

        return Stream.concat(
                vanillaEntitiesThatNeedNewTranslations.stream(),
                BuiltInRegistries.ENTITY_TYPE.stream()
                        .filter(entity -> BuiltInRegistries.ENTITY_TYPE
                                .getKey(entity)
                                .getNamespace()
                                .equals(BuildersParadiseConstants.MOD_ID))
        ).filter(Predicate.not(handMadeEntities::contains)).toList();
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
        } else if (reformatted.contains("silicon block")) {
            readjusted = reformatted.replace("silicon block", "block of silicon");
        } else if (reformatted.contains("monocrystal block")) {
            readjusted = reformatted.replace("monocrystal block", "block of monocrystal");
        } else if (reformatted.contains("ruby block")) {
            readjusted = reformatted.replace("ruby block", "block of ruby");
        } else if (reformatted.contains("sapphire block")) {
            readjusted = reformatted.replace("sapphire block", "block of sapphire");
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
    public void generateTranslations(HolderLookup.Provider registries, TranslationBuilder translations) {
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

        String[] patternNames = {
                "Quarter Chief",
                "Quarter Base",
                "Sixth Chief",
                "Sixth Base",
                "Quarter Pale Dexter",
                "Quarter Pale Sinister",
                "Sixth Pale Dexter",
                "Sixth Pale Sinister",
                "Chief Sinister Quadrant",
                "Chief Dexter Quadrant",
                "Base Sinister Quadrant",
                "Base Dexter Quadrant",
                "Offset Cross",
                "Inverted Offset Cross",
                "Per Saltire",
                "Inverted Per Saltire",
                "Long Chevron",
                "Inverted Long Chevron",
                "Barry",
                "Bendy Dexter",
                "Bendy Sinister",
                "Checkerboard",
                "Inverted Checkerboard",
                "Rhombus",
                "Majuscule Outlined Pentagram",
                "Majuscule Full Pentagram",
                "Majuscule Outlined Hexagram",
                "Majuscule Full Hexagram",
                "Miniscule Outlined Pentagram",
                "Miniscule Full Pentagram",
                "Miniscule Outlined Hexagram",
                "Miniscule Full Hexagram",
                "Chief Canton Pentagram",
                "Chief Sinister Canton Pentagram",
                "Chief Dexter Canton Pentagram",
                "Base Canton Pentagram",
                "Base Sinister Canton Pentagram",
                "Base Dexter Canton Pentagram",
                "Heart",
                "Diamond",
                "Chief Canton Hexagram",
                "Chief Sinister Canton Hexagram",
                "Chief Dexter Canton Hexagram",
                "Base Canton Hexagram",
                "Base Sinister Canton Hexagram",
                "Base Dexter Canton Hexagram",
                "Spade",
                "Club",
                "Chief Sinister Per Bend",
                "Chief Dexter Per Bend",
                "Base Sinister Per Bend",
                "Base Dexter Per Bend",
                "Chief Per Pale",
                "Base Per Pale",
                "Sinister Per Fess",
                "Dexter Per Fess"
        };

        for (int i = 0; i < patternNames.length; i++) {
            String patternId = "pattern_" + i;
            String patternName = patternNames[i];

            translations.add("block.minecraft.banner." + patternId, patternName);

            for (Map.Entry<String, String> color : bannerColorNames.entrySet()) {
                translations.add(
                        "block.minecraft.banner." + patternId + "." + color.getKey(),
                        color.getValue() + " " + patternName
                );
            }
        }

        getKnownBlocks().forEach(block ->
                translations.add(block.getDescriptionId(),
                        formatString(block.getDescriptionId())));

        getKnownItems().forEach(item ->
                translations.add(item.getDescriptionId(),
                        formatString(item.getDescriptionId())));

        getKnownEffects().forEach(effect ->
                translations.add(effect.getDescriptionId(),
                        formatString(effect.getDescriptionId())));

        getKnownEntities().forEach(entity ->
                translations.add(entity.getDescriptionId(),
                        formatString(entity.getDescriptionId())));

        add(translations, "death.attack.radiation", "%1$s received an unhealthy dose of nuclear radiation");
        add(translations, "death.attack.radiation.player", "%1$s received an unhealthy dose of nuclear radiation while trying to escape %2$s");
        add(translations, "stat.buildersparadise.interact_with_fletching_table", "Interactions with Fletching Table");
        add(translations, "container.fletching", "Fletching");
        add(translations, "jukebox_song.buildersparadise.circuitric_magnet", "The Works of BH - Circuitric Magnet");
        add(translations, "jukebox_song.buildersparadise.angry_boyfriends", "The Works of BH - Angry Boyfriends");

        add(translations, "item.buildersparadise.smithing_template.bronze_upgrade.applies_to", "Copper Equipment");
        add(translations, "item.buildersparadise.smithing_template.bronze_upgrade.ingredients", "Bronze Ingot");
        add(translations, "item.buildersparadise.smithing_template.bronze_upgrade.base_slot_description", "Add copper armour, weapon, or tool");
        add(translations, "item.buildersparadise.smithing_template.bronze_upgrade.additions_slot_description", "Add Bronze Ingot");

        String[] trimMaterials = {
                "zinc", "silver", "tin", "tungsten", "platinum", "lead",
                "bismuth", "uranium", "bronze", "brass", "steel",
                "sculk", "monocrystal", "ruby", "sapphire"
        };

        for (String material : trimMaterials) {
            add(translations, "trim_material.buildersparadise." + material,
                    Character.toUpperCase(material.charAt(0))
                            + material.substring(1) + " Material");
        }

        Map<String, String> extraTranslations = new HashMap<>();

        extraTranslations.put("jukebox_song.minecraft.creator", "Leif Chappelle - Creator");
        extraTranslations.put("jukebox_song.minecraft.creator_music_box", "Leif Chappelle - Creator (Music Box)");
        extraTranslations.put("jukebox_song.minecraft.otherside", "Leif Chappelle - otherside");
        extraTranslations.put("jukebox_song.minecraft.pigstep", "Leif Chappelle - Pigstep");

        extraTranslations.put("item.minecraft.music_disc_creator.desc", "Leif Chappelle - Creator");
        extraTranslations.put("item.minecraft.music_disc_creator_music_box.desc", "Leif Chappelle - Creator (Music Box)");
        extraTranslations.put("item.minecraft.music_disc_otherside.desc", "Leif Chappelle - otherside");
        extraTranslations.put("item.minecraft.music_disc_pigstep.desc", "Leif Chappelle - Pigstep");

        extraTranslations.put("music.game.ancestry", "Leif Chappelle - Ancestry");
        extraTranslations.put("music.game.deeper", "Leif Chappelle - Deeper");
        extraTranslations.put("music.game.eld_unknown", "Leif Chappelle - Eld Unknown");
        extraTranslations.put("music.game.endless", "Leif Chappelle - Endless");
        extraTranslations.put("music.game.infinite_amethyst", "Leif Chappelle - Infinite Amethyst");
        extraTranslations.put("music.game.left_to_bloom", "Leif Chappelle - Left to Bloom");
        extraTranslations.put("music.game.one_more_day", "Leif Chappelle - One More Day");
        extraTranslations.put("music.game.stand_tall", "Leif Chappelle - Stand Tall");
        extraTranslations.put("music.game.wending", "Leif Chappelle - Wending");

        extraTranslations.put("music.game.nether.crimson_forest.chrysopoeia", "Leif Chappelle - Chrysopoeia");
        extraTranslations.put("music.game.nether.nether_wastes.rubedo", "Leif Chappelle - Rubedo");
        extraTranslations.put("music.game.nether.soulsand_valley.so_below", "Leif Chappelle - So Below");
        extraTranslations.put("music.game.swamp.aerie", "Leif Chappelle - Aerie");
        extraTranslations.put("music.game.swamp.firebugs", "Leif Chappelle - Firebugs");
        extraTranslations.put("music.game.swamp.labyrinthine", "Leif Chappelle - Labyrinthine");

        extraTranslations.put("block.minecraft.lantern", "Iron Lantern");
        extraTranslations.put("block.minecraft.soul_lantern", "Iron Soul Lantern");
        extraTranslations.put("block.minecraft.crafting_table", "Oak Crafting Table");
        extraTranslations.put("block.minecraft.cartography_table", "Dark Oak Cartography Table");
        extraTranslations.put("block.minecraft.smithing_table", "Mangrove Smithing Table");
        extraTranslations.put("block.minecraft.fletching_table", "Birch Fletching Table");
        extraTranslations.put("block.minecraft.grindstone", "Dark Oak Grindstone");
        extraTranslations.put("block.minecraft.loom", "Oak Loom");
        extraTranslations.put("block.minecraft.furnace", "Stone Furnace");
        extraTranslations.put("block.minecraft.smoker", "Oak Stone Smoker");
        extraTranslations.put("block.minecraft.blast_furnace", "Stone Blast Furnace");
        extraTranslations.put("block.minecraft.campfire", "Oak Campfire");
        extraTranslations.put("block.minecraft.soul_campfire", "Oak Soul Campfire");
        extraTranslations.put("block.minecraft.beehive", "Oak Beehive");
        extraTranslations.put("block.minecraft.bookshelf", "Oak Bookshelf");
        extraTranslations.put("block.minecraft.chiseled_bookshelf", "Oak Chiseled Bookshelf");
        extraTranslations.put("block.minecraft.brewing_stand", "Stone Brewing Stand");
        extraTranslations.put("block.minecraft.barrel", "Spruce Barrel");
        extraTranslations.put("block.minecraft.dispenser", "Stone Dispenser");
        extraTranslations.put("block.minecraft.dropper", "Stone Dropper");
        extraTranslations.put("block.minecraft.observer", "Stone Observer");
        extraTranslations.put("block.minecraft.crafter", "Oak Crafter");
        extraTranslations.put("block.minecraft.chest", "Oak Chest");
        extraTranslations.put("block.minecraft.trapped_chest", "Oak Trapped Chest");

        extraTranslations.forEach((key, value) ->
                add(translations, key, value));
    }

    private static void add(
            TranslationBuilder translations,
            String key,
            String value
    ) {
        translations.add(key, value);
    }
}
