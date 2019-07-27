package cn.yaxuan97.bambooItems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BambooFenceGateBlock extends FenceGateBlock {

	public BambooFenceGateBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 15.0F)
				.sound(SoundType.BAMBOO));

	}
}
