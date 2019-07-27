package cn.yaxuan97.bambooItems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BambooDoorBlock extends DoorBlock {

	public BambooDoorBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F).sound(SoundType.BAMBOO));
	}

}
