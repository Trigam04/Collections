package dev.trigam.collections;

import dev.trigam.collections.block.BlockInit;
import dev.trigam.collections.item.InventoryInit;
import dev.trigam.collections.item.ItemInit;
import dev.trigam.collections.item.ItemModifyInit;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collections implements ModInitializer {
	public static String ModID = "collections";
	public static final Logger LOGGER = LoggerFactory.getLogger("Collections");

	@Override
	public void onInitialize(ModContainer mod) {

		ItemInit.registerModItems();
		BlockInit.registerModBlocks();
		InventoryInit.sortInventoryItems();

		ItemModifyInit.modifyItems();
	}
}
