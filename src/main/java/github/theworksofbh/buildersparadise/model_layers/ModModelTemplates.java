package github.theworksofbh.buildersparadise.model_layers;

import net.minecraft.client.data.models.model.ModelTemplates;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;

public class ModModelTemplates {
    public static final ExtendedModelTemplate TINTED_GLASS_PANE_POST = ModelTemplates.STAINED_GLASS_PANE_POST.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_GLASS_PANE_SIDE = ModelTemplates.STAINED_GLASS_PANE_SIDE.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_GLASS_PANE_SIDE_ALT = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_GLASS_PANE_NOSIDE = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_GLASS_PANE_NOSIDE_ALT = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.extend().ambientOcclusion(true).build();

    public static final ExtendedModelTemplate TINTED_DOOR_BOTTOM_LEFT = ModelTemplates.DOOR_BOTTOM_LEFT.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_BOTTOM_LEFT_OPEN = ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_BOTTOM_RIGHT = ModelTemplates.DOOR_BOTTOM_RIGHT.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_BOTTOM_RIGHT_OPEN = ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_TOP_LEFT = ModelTemplates.DOOR_TOP_LEFT.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_TOP_LEFT_OPEN = ModelTemplates.DOOR_TOP_LEFT_OPEN.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_TOP_RIGHT = ModelTemplates.DOOR_TOP_RIGHT.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_DOOR_TOP_RIGHT_OPEN = ModelTemplates.DOOR_TOP_RIGHT_OPEN.extend().ambientOcclusion(true).build();

    public static final ExtendedModelTemplate TINTED_ORIENTABLE_TRAPDOOR_TOP = ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_ORIENTABLE_TRAPDOOR_BOTTOM = ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.extend().ambientOcclusion(true).build();
    public static final ExtendedModelTemplate TINTED_ORIENTABLE_TRAPDOOR_OPEN = ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.extend().ambientOcclusion(true).build();
}
