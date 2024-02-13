package de.greenman999.create.doener.block.kebabgrill;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import de.greenman999.create.doener.block.ModPartialModels;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class KebabGrillInstance extends SingleRotatingInstance<KebabGrillBlockEntity> {
    public KebabGrillInstance(MaterialManager materialManager, KebabGrillBlockEntity blockEntity) {
        super(materialManager, blockEntity);
        System.out.println("init");
        blockEntity.setInstance(this);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        if(!ItemStack.EMPTY.getItem().equals(blockEntity.getHeldItem().getItem()))
            return getRotatingMaterial().getModel(ModPartialModels.KEBAB_SKEWER, blockEntity.getBlockState());
        return getRotatingMaterial().getModel(ModPartialModels.EMPTY_GRILL, blockEntity.getBlockState());
    }

/*    //cause the block shape is full, the light is 0
    @Override
    public void updateLight() {
        relight(pos.above(), rotatingModel);
    }*/
}
