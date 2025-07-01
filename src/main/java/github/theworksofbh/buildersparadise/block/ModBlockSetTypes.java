package github.theworksofbh.buildersparadise.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public record ModBlockSetTypes() {
    public static final BlockSetType NETHERITE = BlockSetType.register(
            new BlockSetType(
                    "netherite",
                    false,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.NETHERITE_BLOCK,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
                    )
            );

    public static final BlockSetType ZINC = BlockSetType.register(
            new BlockSetType(
                    "zinc",
                    true,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.IRON,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType SILVER = BlockSetType.register(
            new BlockSetType(
                    "silver",
                    false,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType TIN = BlockSetType.register(
            new BlockSetType(
                    "tin",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType TUNGSTEN = BlockSetType.register(
            new BlockSetType(
                    "tungsten",
                    false,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType PLATINUM = BlockSetType.register(
            new BlockSetType(
                    "platinum",
                    false,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType LEAD = BlockSetType.register(
            new BlockSetType(
                    "lead",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType URANIUM = BlockSetType.register(
            new BlockSetType(
                    "uranium",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType BRONZE = BlockSetType.register(
            new BlockSetType(
                    "bronze",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType BRASS = BlockSetType.register(
            new BlockSetType(
                    "brass",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.COPPER,
                    SoundEvents.COPPER_DOOR_CLOSE,
                    SoundEvents.COPPER_DOOR_OPEN,
                    SoundEvents.COPPER_TRAPDOOR_CLOSE,
                    SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );

    public static final BlockSetType STEEL = BlockSetType.register(
            new BlockSetType(
                    "steel",
                    false,
                    false,
                    false,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );
}
