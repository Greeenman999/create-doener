package de.greenman999.create.doener.block.kebabgrill;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.foundation.block.IBE;
import de.greenman999.create.doener.block.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class KebabGrillBlock extends KineticBlock implements IBE<KebabGrillBlockEntity> {

    public KebabGrillBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return AllShapes.TURNTABLE_SHAPE;
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
