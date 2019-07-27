package cn.yaxuan97.bambooItems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BambooFenceBlock extends FenceBlock {

	public BambooFenceBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 20.0F)
				.sound(SoundType.BAMBOO));
	}

}
