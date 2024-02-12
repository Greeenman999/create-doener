package de.greenman999.create.doener.block.kebabgrill;

import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import net.minecraft.core.Direction;

public class KebabGrillInstance extends HalfShaftInstance<KebabGrillBlockEntity> {
    public KebabGrillInstance(MaterialManager materialManager, KebabGrillBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Direction getShaftDirection() {
        return Direction.DOWN;
    }
}
