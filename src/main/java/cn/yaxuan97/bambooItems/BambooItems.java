package cn.yaxuan97.bambooItems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import cn.yaxuan97.bambooItems.blocks.BambooDoorBlock;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
//import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import cn.yaxuan97.bambooItems.blocks.BambooFenceBlock;
import cn.yaxuan97.bambooItems.blocks.BambooFenceGateBlock;
import cn.yaxuan97.bambooItems.blocks.BambooLadderBlock;
import cn.yaxuan97.bambooItems.blocks.BambooPlankBlock;
//import net.minecraftforge.fml.common.Mod;

//import java.util.stream.Collectors;

import static cn.yaxuan97.bambooItems.util.ModInfo.MOD_ID;

@Mod(MOD_ID)
public class BambooItems {
	public static BambooLadderBlock bambooLadderBlock = new BambooLadderBlock();
	public static BambooFenceBlock bambooFenceBlock = new BambooFenceBlock();
	public static BambooFenceGateBlock bambooFenceGateBlock = new BambooFenceGateBlock();
	public static BambooPlankBlock bambooPlankBlock = new BambooPlankBlock();
	public static BambooDoorBlock bambooDoorBlock = new BambooDoorBlock();
//	private static final Logger LOGGER = LogManager.getLogger();

 	public BambooItems() {
//		// Register the setup method for modloading
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//		// Register the enqueueIMC method for modloading
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//		// Register the processIMC method for modloading
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//		// Register the doClientStuff method for modloading
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
//		// Register ourselves for server and other game events we are interested in
//		MinecraftForge.EVENT_BUS.register(this);
	}

	{
//	private void setup(final FMLCommonSetupEvent event) {
//		// some preinit code
//	}
//
//	private void doClientStuff(final FMLClientSetupEvent event) {
//		// do something that can only be done on the client
//	}
//
//	private void enqueueIMC(final InterModEnqueueEvent event) {
//		// some example code to dispatch IMC to another mod
//	}
//
//	private void processIMC(final InterModProcessEvent event) {
//		// some example code to receive and process InterModComms from other mods
//	}
//// You can use SubscribeEvent and let the Event Bus discover methods to call
//	@SubscribeEvent
//	public void onServerStarting(FMLServerStartingEvent event) {
//		// do something when the server starts
//	}

// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlockRegistry(RegistryEvent.Register<Block> event) {
			event.getRegistry().register(BambooItems.bambooPlankBlock.setRegistryName(MOD_ID, "bamboo_plank"));
			event.getRegistry().register(BambooItems.bambooLadderBlock.setRegistryName(MOD_ID, "bamboo_ladder"));
			event.getRegistry().register(BambooItems.bambooFenceBlock.setRegistryName(MOD_ID, "bamboo_fence"));
			event.getRegistry().register(BambooItems.bambooFenceGateBlock.setRegistryName(MOD_ID, "bamboo_fence_gate"));
			event.getRegistry().register(BambooItems.bambooDoorBlock.setRegistryName(MOD_ID, "bamboo_door"));
		}

		@SubscribeEvent
		public static void onItemRegisrty(RegistryEvent.Register<Item> event) {
			event.getRegistry().register(
					new BlockItem(BambooItems.bambooPlankBlock, new Item.Properties().group(ItemGroup.DECORATIONS))
							.setRegistryName(BambooItems.bambooPlankBlock.getRegistryName()));
			event.getRegistry().register(
					new BlockItem(BambooItems.bambooLadderBlock, new Item.Properties().group(ItemGroup.DECORATIONS))
							.setRegistryName(BambooItems.bambooLadderBlock.getRegistryName()));
			event.getRegistry().register(
					new BlockItem(BambooItems.bambooFenceBlock, new Item.Properties().group(ItemGroup.DECORATIONS))
							.setRegistryName(BambooItems.bambooFenceBlock.getRegistryName()));
			event.getRegistry().register(
					new BlockItem(BambooItems.bambooFenceGateBlock, new Item.Properties().group(ItemGroup.DECORATIONS))
							.setRegistryName(BambooItems.bambooFenceGateBlock.getRegistryName()));
			event.getRegistry().register(
					new BlockItem(BambooItems.bambooDoorBlock, new Item.Properties().group(ItemGroup.DECORATIONS))
							.setRegistryName(BambooItems.bambooDoorBlock.getRegistryName()));
		}
	}
}
