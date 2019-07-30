package cn.yaxuan97.bambooItems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BambooPlankBlock extends RotatedPillarBlock implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public BambooPlankBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.BAMBOO));
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(false)));
	}

	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean isSolid(BlockState state) {
		return false;
	}

	public static final VoxelShape fullVoxel = VoxelShapes.fullCube();
	private static final VoxelShape blockVoxel_y = VoxelShapes.combineAndSimplify(fullVoxel,
			Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D), IBooleanFunction.ONLY_FIRST);
	private static final VoxelShape blockVoxel_x = VoxelShapes.combineAndSimplify(fullVoxel,
			Block.makeCuboidShape(0.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D), IBooleanFunction.ONLY_FIRST);
	private static final VoxelShape blockVoxel_z = VoxelShapes.combineAndSimplify(fullVoxel,
			Block.makeCuboidShape(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 16.0D), IBooleanFunction.ONLY_FIRST);

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(AXIS)) {
		case X:
			return blockVoxel_x;
		case Y:
			return blockVoxel_y;
		case Z:
			return blockVoxel_z;
		default:
			return fullVoxel;
		}
	}

	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return fullVoxel;
	}

	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		return getShape(state, worldIn, pos, context);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS, WATERLOGGED);
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return super.getStateForPlacement(context).with(WATERLOGGED,
				Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
	}

	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
}
