package cn.yaxuan97.bambooItems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BambooPlankBlock extends RotatedPillarBlock {

	public BambooPlankBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.BAMBOO));
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
}
