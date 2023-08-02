package dev.trigam.collections.item;

import dev.trigam.collections.block.BlockInit;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class InventoryInit {

	public static void sortInventoryItems() {
		// Building Blocks
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.addAfter(Items.LAPIS_BLOCK, BlockInit.SULPHUR_BLOCK);
		});
		// Colored Blocks
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register((content) -> {
			content.addAfter(Items.PINK_STAINED_GLASS_PANE, ItemInit.GLASS_SHARD);
			content.addAfter(ItemInit.GLASS_SHARD, ItemInit.WHITE_GLASS_SHARD);
			content.addAfter(ItemInit.WHITE_GLASS_SHARD, ItemInit.LIGHT_GRAY_GLASS_SHARD);
			content.addAfter(ItemInit.LIGHT_GRAY_GLASS_SHARD, ItemInit.GRAY_GLASS_SHARD);
			content.addAfter(ItemInit.GRAY_GLASS_SHARD, ItemInit.BLACK_GLASS_SHARD);
			content.addAfter(ItemInit.BLACK_GLASS_SHARD, ItemInit.BROWN_GLASS_SHARD);
			content.addAfter(ItemInit.BROWN_GLASS_SHARD, ItemInit.RED_GLASS_SHARD);
			content.addAfter(ItemInit.RED_GLASS_SHARD, ItemInit.ORANGE_GLASS_SHARD);
			content.addAfter(ItemInit.ORANGE_GLASS_SHARD, ItemInit.YELLOW_GLASS_SHARD);
			content.addAfter(ItemInit.YELLOW_GLASS_SHARD, ItemInit.LIME_GLASS_SHARD);
			content.addAfter(ItemInit.LIME_GLASS_SHARD, ItemInit.GREEN_GLASS_SHARD);
			content.addAfter(ItemInit.GREEN_GLASS_SHARD, ItemInit.CYAN_GLASS_SHARD);
			content.addAfter(ItemInit.CYAN_GLASS_SHARD, ItemInit.LIGHT_BLUE_GLASS_SHARD);
			content.addAfter(ItemInit.LIGHT_BLUE_GLASS_SHARD, ItemInit.BLUE_GLASS_SHARD);
			content.addAfter(ItemInit.BLUE_GLASS_SHARD, ItemInit.PURPLE_GLASS_SHARD);
			content.addAfter(ItemInit.PURPLE_GLASS_SHARD, ItemInit.MAGENTA_GLASS_SHARD);
			content.addAfter(ItemInit.MAGENTA_GLASS_SHARD, ItemInit.PINK_GLASS_SHARD);
		});
		// Natural Blocks
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL_BLOCKS).register(content -> {
			content.addAfter(Items.DEEPSLATE_LAPIS_ORE, BlockInit.SULPHUR_ORE);
			content.addAfter(BlockInit.SULPHUR_ORE, BlockInit.DEEPSLATE_SULPHUR_ORE);
		});
		// Ingredients
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((content) -> {
			content.addAfter(Items.LAPIS_LAZULI, ItemInit.SULPHUR);
		});
	}

}
