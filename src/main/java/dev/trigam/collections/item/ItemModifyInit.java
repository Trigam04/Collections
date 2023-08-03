package dev.trigam.collections.item;

import net.minecraft.item.Items;

public class ItemModifyInit {

	public static void modifyItems() {
		// COMBAT REACH
		// Sword
		((IReachTool) Items.WOODEN_SWORD).setAttackReach(0.5);
		((IReachTool) Items.STONE_SWORD).setAttackReach(0.5);
		((IReachTool) Items.IRON_SWORD).setAttackReach(0.5);
		((IReachTool) Items.GOLDEN_SWORD).setAttackReach(0.5);
		((IReachTool) Items.DIAMOND_SWORD).setAttackReach(0.5);
		((IReachTool) Items.NETHERITE_SWORD).setAttackReach(0.5);
		// Pickaxe
//		((IReachTool) Items.WOODEN_PICKAXE).setAttackReach(2.5);
//		((IReachTool) Items.STONE_PICKAXE).setAttackReach(2.5);
//		((IReachTool) Items.IRON_PICKAXE).setAttackReach(2.5);
//		((IReachTool) Items.GOLDEN_PICKAXE).setAttackReach(2.5);
//		((IReachTool) Items.DIAMOND_PICKAXE).setAttackReach(2.5);
//		((IReachTool) Items.NETHERITE_PICKAXE).setAttackReach(2.5);
	}

}
