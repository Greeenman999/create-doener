package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.logistics.depot.SharedDepotBlockMethods;
import com.simibubi.create.foundation.block.IBE;
import de.greenman999.create.doener.block.ModBlockEntityTypes;
import de.greenman999.create.doener.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static com.simibubi.create.content.kinetics.base.DirectionalKineticBlock.FACING;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

public class KebabGrillBlock extends HorizontalKineticBlock implements IBE<KebabGrillBlockEntity> {

    public KebabGrillBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult ray) {
        if(hand != InteractionHand.MAIN_HAND)
            return InteractionResult.PASS;
        if(ray.getDirection() == Direction.DOWN)
            return InteractionResult.PASS;
        if(world.isClientSide)
            return InteractionResult.SUCCESS;

        KebabGrillBlockEntity kebabGrillBlockEntity = getBlockEntity(world, pos);
        ItemStack heldItem = player.getItemInHand(hand);
        if(ModItems.KEBAB_SKEWER.asItem().equals(heldItem.getItem()) && kebabGrillBlockEntity.getHeldItem().isEmpty()) {
            System.out.println("set");
            kebabGrillBlockEntity.kebabGrillBehaviour.setHeldItem(new TransportedItemStack(heldItem.copyWithCount(1)));
            kebabGrillBlockEntity.getInstance().init();
            if(!player.isCreative())
                heldItem.shrink(1);
            return InteractionResult.SUCCESS;

        } else if(ItemStack.EMPTY.getItem().equals(heldItem.getItem())) {
            if(!ItemStack.EMPTY.getItem().equals(kebabGrillBlockEntity.getHeldItem().getItem())) {
                System.out.println("remove");
                player.getInventory().placeItemBackInInventory(kebabGrillBlockEntity.getHeldItem().copyWithCount(1));
                kebabGrillBlockEntity.kebabGrillBehaviour.removeHeldItem();
                kebabGrillBlockEntity.getInstance().init();
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return new AllShapes.Builder(Block.box(0, 0, 0, 16, 2, 16))
                .add(15, 2, 15, 16, 16, 16)
                .add(0, 2, 15, 1, 16, 16)
                .add(1, 15, 15, 15, 16, 16)
                .add(7, 15, 7, 9, 16, 15)
                .forHorizontal(Direction.NORTH).get(state.getValue(HORIZONTAL_FACING));
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == Direction.DOWN;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<KebabGrillBlockEntity> getBlockEntityClass() {
        return KebabGrillBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends KebabGrillBlockEntity> getBlockEntityType() {
        return ModBlockEntityTypes.KEBAB_GRILL.get();
    }

    @Override
    public boolean isPathfindable(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull PathComputationType type) {
        return false;
    }

}
