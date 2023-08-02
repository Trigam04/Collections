package dev.trigam.collections.item;

import dev.trigam.collections.Collections;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ItemInit {
	// GLASS SHARDS
	public static final Item GLASS_SHARD = registerItem("glass_shard", new Item(new QuiltItemSettings()));
	public static final Item WHITE_GLASS_SHARD = registerItem("white_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item LIGHT_GRAY_GLASS_SHARD = registerItem("light_gray_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item GRAY_GLASS_SHARD = registerItem("gray_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item BLACK_GLASS_SHARD = registerItem("black_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item BROWN_GLASS_SHARD = registerItem("brown_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item RED_GLASS_SHARD = registerItem("red_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item ORANGE_GLASS_SHARD = registerItem("orange_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item YELLOW_GLASS_SHARD = registerItem("yellow_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item LIME_GLASS_SHARD = registerItem("lime_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item GREEN_GLASS_SHARD = registerItem("green_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item CYAN_GLASS_SHARD = registerItem("cyan_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item LIGHT_BLUE_GLASS_SHARD = registerItem("light_blue_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item BLUE_GLASS_SHARD = registerItem("blue_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item PURPLE_GLASS_SHARD = registerItem("purple_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item MAGENTA_GLASS_SHARD = registerItem("magenta_stained_glass_shard", new Item(new QuiltItemSettings()));
	public static final Item PINK_GLASS_SHARD = registerItem("pink_stained_glass_shard", new Item(new QuiltItemSettings()));

	public static final Item SULPHUR = registerItem("sulphur", new Item(new QuiltItemSettings()));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(Collections.ModID, name), item);
	}
	public static void registerModItems() {
		Collections.LOGGER.info("Registering items for {}...", Collections.ModID);
	}
}
