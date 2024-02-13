package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BehaviourType;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.nbt.CompoundTag;

public class KebabGrillBehaviour extends BlockEntityBehaviour {

    public static final BehaviourType<KebabGrillBehaviour> TYPE = new BehaviourType<>();

    TransportedItemStack heldItem;

    public KebabGrillBehaviour(SmartBlockEntity be) {
        super(be);
    }

    @Override
    public BehaviourType<KebabGrillBehaviour> getType() {
        return TYPE;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void read(CompoundTag nbt, boolean clientPacket) {
        heldItem = null;
        if (nbt.contains("HeldItem"))
            heldItem = TransportedItemStack.read(nbt.getCompound("HeldItem"));
    }

    @Override
    public void write(CompoundTag nbt, boolean clientPacket) {
        if (heldItem != null)
            nbt.put("HeldItem", heldItem.serializeNBT());
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
