package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.logistics.depot.DepotBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class KebabGrillBlockEntity extends KineticBlockEntity {

    TransportedItemStack heldItem;
    KebabGrillInstance kebabGrillInstance;

    public KebabGrillBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void read(CompoundTag nbt, boolean clientPacket) {
        heldItem = null;
        if (nbt.contains("HeldItem"))
            heldItem = TransportedItemStack.read(nbt.getCompound("HeldItem"));
        super.read(nbt, clientPacket);
    }

    @Override
    public void write(CompoundTag nbt, boolean clientPacket) {
        if (heldItem != null)
            nbt.put("HeldItem", heldItem.serializeNBT());
        super.write(nbt, clientPacket);
    }

    public void setHeldItem(TransportedItemStack heldItem) {
        this.heldItem = heldItem;
    }

    public void removeHeldItem() {
        this.heldItem = null;
    }

    public TransportedItemStack getHeldItem() {
        return heldItem;
    }
}
