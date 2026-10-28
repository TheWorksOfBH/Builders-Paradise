package github.theworksofbh.buildersparadise.datagen;

import github.theworksofbh.buildersparadise.BuildersParadiseConstants;
import github.theworksofbh.buildersparadise.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
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
import java.util.stream.Stream;

public class ModCanadaLanguageProvider extends LanguageProvider {
    public ModCanadaLanguageProvider(PackOutput output) {
        super(output, BuildersParadiseConstants.MOD_ID, "en_ca");
    }

    protected Iterable<Block> getKnownBlocks() {
        Set<Block> vanillaBlocksThatNeedNewTranslations = Set.of(

        );

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
                        .filter(block ->
                                BuiltInRegistries.BLOCK.getKey(block)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
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
                BuiltInRegistries.ITEM.stream()
                        .filter(item ->
                                BuiltInRegistries.ITEM.getKey(item)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
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
                BuiltInRegistries.MOB_EFFECT.stream()
                        .filter(mobEffect ->
                                BuiltInRegistries.MOB_EFFECT.getKey(mobEffect)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
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
                BuiltInRegistries.ENTITY_TYPE.stream()
                        .filter(entityType ->
                                BuiltInRegistries.ENTITY_TYPE.getKey(entityType)
                                        .getNamespace()
                                        .equals(BuildersParadiseConstants.MOD_ID)
                        )
        ).filter(
                (Predicate.not(handMadeEntities::contains))
        ).toList();
    }

    public static String formatString(String input) {
        String replaced = input.replace('_', ' ');
        String reformatted = "";
        String readjusted = "";
        String terranceAndPhillip = "";

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
            terranceAndPhillip = readjusted.replace("ize", "ise");
        } else if (readjusted.contains("gray")) {
            terranceAndPhillip = readjusted.replace("gray", "grey");
        } else if (readjusted.contains("armor")) {
            terranceAndPhillip = readjusted.replace("armor", "armour");
        } else if (readjusted.contains("chiseled")) {
            terranceAndPhillip = readjusted.replace("chiseled", "chiselled");
        } else if (readjusted.contains("sulfur")) {
            terranceAndPhillip = readjusted.replace("sulfur", "sulphur");
        } else {
            terranceAndPhillip = readjusted;
        }

        String[] words = terranceAndPhillip.split(" ");

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

            this.add("block.minecraft.banner." + patternId, patternName);

            for (Map.Entry<String, String> color : bannerColorNames.entrySet()) {
                this.add("block.minecraft.banner." + patternId + "." + color.getKey(), color.getValue() + " " + patternName);
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

        String[] trimMaterials = {
                "zinc", "silver", "tin", "tungsten", "platinum", "lead",
                "bismuth", "uranium", "bronze", "brass", "steel",
                "sculk", "monocrystal", "ruby", "sapphire"
        };

        for (String material : trimMaterials) {
            this.add("trim_material.buildersparadise." + material, Character.toUpperCase(material.charAt(0)) + material.substring(1) + " Material");
        }

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
        this.add("block.minecraft.crafting_table", "Oak Crafting Table");
        this.add("block.minecraft.cartography_table", "Dark Oak Cartography Table");
        this.add("block.minecraft.smithing_table", "Mangrove Smithing Table");
        this.add("block.minecraft.fletching_table", "Birch Fletching Table");
        this.add("block.minecraft.grindstone", "Dark Oak Grindstone");
        this.add("block.minecraft.loom", "Oak Loom");
        this.add("block.minecraft.furnace", "Stone Furnace");
        this.add("block.minecraft.smoker", "Oak Stone Smoker");
        this.add("block.minecraft.blast_furnace", "Stone Blast Furnace");
        this.add("block.minecraft.campfire", "Oak Campfire");
        this.add("block.minecraft.soul_campfire", "Oak Soul Campfire");
        this.add("block.minecraft.beehive", "Oak Beehive");
        this.add("block.minecraft.bookshelf", "Oak Bookshelf");
        this.add("block.minecraft.chiseled_bookshelf", "Oak Chiselled Bookshelf");
        this.add("block.minecraft.brewing_stand", "Stone Brewing Stand");
        this.add("block.minecraft.barrel", "Spruce Barrel");
        this.add("block.minecraft.dispenser", "Stone Dispenser");
        this.add("block.minecraft.dropper", "Stone Dropper");
        this.add("block.minecraft.observer", "Stone Observer");
        this.add("block.minecraft.crafter", "Oak Crafter");
        this.add("block.minecraft.chest", "Oak Chest");
        this.add("block.minecraft.trapped_chest", "Oak Trapped Chest");

    }
}