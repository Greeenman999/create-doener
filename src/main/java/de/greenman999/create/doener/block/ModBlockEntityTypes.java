package de.greenman999.create.doener.block;

import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import de.greenman999.create.doener.CreateDoener;
import de.greenman999.create.doener.block.kebabgrill.KebabGrillBlockEntity;
import de.greenman999.create.doener.block.kebabgrill.KebabGrillInstance;

public class ModBlockEntityTypes {

    public static final BlockEntityEntry<KebabGrillBlockEntity> KEBAB_GRILL = CreateDoener.REGISTRATE
            .blockEntity("kebab_grill", KebabGrillBlockEntity::new)
            .instance(() -> KebabGrillInstance::new)
            .validBlocks(ModBlocks.KEBAB_GRILL)
            .renderer(() -> KineticBlockEntityRenderer::new)
            .register();

    public static void register() {}

}
