package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import de.greenman999.create.doener.block.ModPartialModels;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

public class KebabGrillRenderer extends KineticBlockEntityRenderer<KebabGrillBlockEntity> {
    public KebabGrillRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(KebabGrillBlockEntity  be, BlockState state) {
        return CachedBufferer.partial(ModPartialModels.KEBAB_SKEWER, state);
    }
}
