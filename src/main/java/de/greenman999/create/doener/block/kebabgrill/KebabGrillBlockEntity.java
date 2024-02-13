package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.logistics.depot.DepotBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class KebabGrillBlockEntity extends KineticBlockEntity {

    KebabGrillBehaviour kebabGrillBehaviour;
    KebabGrillInstance kebabGrillInstance;

    public KebabGrillBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        behaviours.add(kebabGrillBehaviour = new KebabGrillBehaviour(this));
    }

    public ItemStack getHeldItem() {
        return kebabGrillBehaviour.getHeldItem() == null ? ItemStack.EMPTY : kebabGrillBehaviour.getHeldItem().stack;
    }

    public void setInstance(KebabGrillInstance kebabGrillInstance) {
        this.kebabGrillInstance = kebabGrillInstance;
    }

    public KebabGrillInstance getInstance() {
        return kebabGrillInstance;
    }
}
