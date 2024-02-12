package de.greenman999.create.doener.block.kebabgrill;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import de.greenman999.create.doener.block.ModPartialModels;
import net.minecraft.core.Direction;

public class KebabGrillInstance extends SingleRotatingInstance<KebabGrillBlockEntity> {
    public KebabGrillInstance(MaterialManager materialManager, KebabGrillBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        return getRotatingMaterial().getModel(ModPartialModels.KEBAB_SKEWER, blockEntity.getBlockState());
    }
}
