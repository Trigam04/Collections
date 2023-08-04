package dev.trigam.collections.item;

import dev.trigam.collections.mixin.stacking.ItemAccessor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemModifyInit {

	public static void modifyItems() {
		modifyWeaponStats();
		modifyStackSize();
	}

	private static void modifyWeaponStats() {
		// Wooden
		setStats(Items.WOODEN_SWORD, 4, 3, 3);
		setStats(Items.WOODEN_PICKAXE, 3, 2.5, 2.5);
		setStats(Items.WOODEN_AXE, 5, 2 , 2.5);
		setStats(Items.WOODEN_SHOVEL, 2, 2 , 2.5);
		setStats(Items.WOODEN_HOE, 2, 2 , 3.5);
		// Stone
		setStats(Items.STONE_SWORD, 4, 3, 3);
		setStats(Items.STONE_PICKAXE, 3, 2.5, 2.5);
		setStats(Items.STONE_AXE, 5, 2 , 2.5);
		setStats(Items.STONE_SHOVEL, 2, 2 , 2.5);
		setStats(Items.STONE_HOE, 2, 2.5 , 3.5);
		// Iron
		setStats(Items.IRON_SWORD, 5, 3, 3);
		setStats(Items.IRON_PICKAXE, 4, 2.5, 2.5);
		setStats(Items.IRON_AXE, 6, 2, 2.5);
		setStats(Items.IRON_SHOVEL, 3, 2, 2.5);
		setStats(Items.IRON_HOE, 3, 3, 3.5);
		// Golden
		setStats(Items.GOLDEN_SWORD, 4, 3, 3);
		setStats(Items.GOLDEN_PICKAXE, 3, 2.5, 2.5);
		setStats(Items.GOLDEN_AXE, 5, 2, 2.5);
		setStats(Items.GOLDEN_SHOVEL, 2, 2, 2.5);
		setStats(Items.GOLDEN_HOE, 2, 3.5, 3.5);
		// Diamond
		setStats(Items.DIAMOND_SWORD, 6, 3, 3);
		setStats(Items.DIAMOND_PICKAXE, 5, 2.5, 2.5);
		setStats(Items.DIAMOND_AXE, 7, 2, 2.5);
		setStats(Items.DIAMOND_SHOVEL, 4, 2, 2.5);
		setStats(Items.DIAMOND_HOE, 3, 3.5, 3.5);
		// Netherite
		setStats(Items.NETHERITE_SWORD, 7, 3, 3);
		setStats(Items.NETHERITE_PICKAXE, 6, 2.5, 2.5);
		setStats(Items.NETHERITE_AXE, 8, 2, 2.5);
		setStats(Items.NETHERITE_SHOVEL, 5, 2, 2.5);
		setStats(Items.NETHERITE_HOE, 4, 3.5, 3.5);
		// Trident
		setStats(Items.TRIDENT, 7, 2, 3.5);
	}

	private static void setStats(Item item, double attackDamage, double attackSpeed, double attackReach) {
		((ITool) item).setAttackDamage((float) attackDamage - 1);
		((ITool) item).setAttackSpeed(attackSpeed - 4);
		((ITool) item).setAttackReach(attackReach - 2.5);
	}

	private static void modifyStackSize() {
		// Throwables
		((IItemCount) Items.SNOWBALL).setMaxCount(64);
		((IItemCount) Items.EGG).setMaxCount(64);
		// Tools
		((IItemCount) Items.WATER_BUCKET).setMaxCount(16);
		((IItemCount) Items.LAVA_BUCKET).setMaxCount(16);
		((IItemCount) Items.MILK_BUCKET).setMaxCount(16);
	}
}
