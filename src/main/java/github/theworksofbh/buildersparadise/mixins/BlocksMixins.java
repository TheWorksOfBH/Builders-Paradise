package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Blocks.class)
public abstract class BlocksMixins {


    @Definition(id = "IRON_BLOCK", field = "Lnet/minecraft/world/level/block/Blocks;IRON_BLOCK:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "register", method = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    @Expression("IRON_BLOCK = @(register(?, ?))")
    @ModifyArg(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockBehaviour.Properties modifyIronProperties(BlockBehaviour.Properties properties) {
        return properties.randomTicks();
    }

    @Definition(id = "IRON_DOOR", field = "Lnet/minecraft/world/level/block/Blocks;IRON_DOOR:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "register", method = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    @Expression("IRON_DOOR = @(register(?, ?, ?))")
    @ModifyArg(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockBehaviour.Properties modifyIronDoorProperties(BlockBehaviour.Properties properties) {
        return properties.randomTicks();
    }

    @Definition(id = "IRON_TRAPDOOR", field = "Lnet/minecraft/world/level/block/Blocks;IRON_TRAPDOOR:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "register", method = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    @Expression("IRON_TRAPDOOR = @(register(?, ?, ?))")
    @ModifyArg(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockBehaviour.Properties modifyIronTrapdoorProperties(BlockBehaviour.Properties properties) {
        return properties.randomTicks();
    }

    @Definition(id = "HEAVY_WEIGHTED_PRESSURE_PLATE", field = "Lnet/minecraft/world/level/block/Blocks;HEAVY_WEIGHTED_PRESSURE_PLATE:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "register", method = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    @Expression("HEAVY_WEIGHTED_PRESSURE_PLATE = @(register(?, ?, ?))")
    @ModifyArg(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockBehaviour.Properties modifyIronPressurePlateProperties(BlockBehaviour.Properties properties) {
        return properties.randomTicks();
    }

    @Definition(id = "IRON_BARS", field = "Lnet/minecraft/world/level/block/Blocks;IRON_BARS:Lnet/minecraft/world/level/block/Block;")
    @Definition(id = "register", method = "Lnet/minecraft/world/level/block/Blocks;register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)Lnet/minecraft/world/level/block/Block;")
    @Expression("IRON_BARS = @(register(?, ?, ?))")
    @ModifyArg(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
    private static BlockBehaviour.Properties modifyIronBarsProperties(BlockBehaviour.Properties properties) {
        return properties.randomTicks();
    }
}
