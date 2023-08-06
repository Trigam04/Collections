package dev.trigam.collections.item;

import dev.trigam.collections.mixin.stacking.ItemAccessor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemModifyInit {

	public static int POTION_STACK_SIZE = 16;
	public static int THROWABLE_STACK_SIZE = 64;
	public static int BUCKET_STACK_SIZE = 16;
	public static int BED_STACK_SIZE = 64;

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
		((IItemCount) Items.POTION).setMaxCount(POTION_STACK_SIZE);
		((IItemCount) Items.SPLASH_POTION).setMaxCount(POTION_STACK_SIZE);
		((IItemCount) Items.LINGERING_POTION).setMaxCount(POTION_STACK_SIZE);
		// Throwables
		((IItemCount) Items.SNOWBALL).setMaxCount(THROWABLE_STACK_SIZE);
		((IItemCount) Items.EGG).setMaxCount(THROWABLE_STACK_SIZE);
		((IItemCount) Items.ENDER_PEARL).setMaxCount(THROWABLE_STACK_SIZE);
		// Buckets
		((IItemCount) Items.BUCKET).setMaxCount(BUCKET_STACK_SIZE);
		((IItemCount) Items.WATER_BUCKET).setMaxCount(BUCKET_STACK_SIZE);
		((IItemCount) Items.LAVA_BUCKET).setMaxCount(BUCKET_STACK_SIZE);
		((IItemCount) Items.MILK_BUCKET).setMaxCount(BUCKET_STACK_SIZE);
		((IItemCount) Items.POWDER_SNOW_BUCKET).setMaxCount(BUCKET_STACK_SIZE);
		// Beds
		((IItemCount) Items.WHITE_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.LIGHT_GRAY_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.GRAY_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.BLACK_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.BROWN_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.RED_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.ORANGE_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.YELLOW_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.LIME_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.GREEN_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.CYAN_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.LIGHT_BLUE_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.BLUE_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.PURPLE_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.MAGENTA_BED).setMaxCount(BED_STACK_SIZE);
		((IItemCount) Items.PINK_BED).setMaxCount(BED_STACK_SIZE);
	}
}
