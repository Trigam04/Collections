package dev.trigam.collections.block;

import dev.trigam.collections.Collections;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.UniformIntProvider;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BlockInit {

	public static final Block SULPHUR_ORE = registerBlock("sulphur_ore", new ExperienceDroppingBlock(QuiltBlockSettings.create().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0f, 3.0f), UniformIntProvider.create(1, 4)));
	public static final Block DEEPSLATE_SULPHUR_ORE = registerBlock("deepslate_sulphur_ore", new ExperienceDroppingBlock(QuiltBlockSettings.create().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(1, 4)));
	public static final Block SULPHUR_BLOCK = registerBlock("sulphur_block", new Block(QuiltBlockSettings.create().mapColor(MapColor.YELLOW_TERRACOTTA).requiresTool().strength(3.0F, 3.0F)));

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(Collections.ModID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(Collections.ModID, name), new BlockItem(block, new QuiltItemSettings()));
	}

	public static void registerModBlocks() {
		Collections.LOGGER.info("Registering blocks for {}...", Collections.ModID);
	}

}
