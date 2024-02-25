package de.greenman999.create.doener.block.kebabgrill;

import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.api.instance.DynamicInstance;
import com.jozufozu.flywheel.core.PartialModel;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.foundation.render.AllMaterialSpecs;
import de.greenman999.create.doener.block.ModPartialModels;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

public class KebabGrillInstance extends KineticBlockEntityInstance<KebabGrillBlockEntity> implements DynamicInstance {

    private RotatingData kebab_skewer;
    PartialModel lastModel;

    public KebabGrillInstance(MaterialManager materialManager, KebabGrillBlockEntity blockEntity) {
        super(materialManager, blockEntity);

        updateModel();
    }

    @Override
    protected void remove() {
        kebab_skewer.delete();
    }

    private PartialModel getModel() {
        if(blockEntity.getHeldItem() != null && !ItemStack.EMPTY.getItem().equals(blockEntity.getHeldItem().stack.getItem())) {
            System.out.println("Model changed to KEBAB_SKEWER");
            lastModel = ModPartialModels.KEBAB_SKEWER;
            return ModPartialModels.KEBAB_SKEWER;
        }
        System.out.println("Model changed to EMPTY_GRILL");
        lastModel = ModPartialModels.EMPTY_GRILL;
        return ModPartialModels. EMPTY_GRILL;
    }

    private void updateModel() {
        kebab_skewer = materialManager.defaultCutout()
                .material(AllMaterialSpecs.ROTATING)
                .getModel(getModel(), blockState)
                .createInstance();

        kebab_skewer.setRotationAxis(Direction. Axis.Y);
        kebab_skewer.setRotationalSpeed(blockEntity.getSpeed());
    }

    @Override
    public void beginFrame(){
        if(lastModel != getModel()){
            updateModel();
            System.out.println("Model changed");
        }
    }

    @Override
    public void updateLight() {
        relight(pos, kebab_skewer);
    }
}