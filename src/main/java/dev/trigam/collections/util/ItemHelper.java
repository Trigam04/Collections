package dev.trigam.collections.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ItemHelper {

	public static ItemStack decrementStack(ItemStack stack, PlayerEntity player, Item returnItem, int decrementAmount) {
		// Don't do anything in creative
		if (player.getAbilities().creativeMode) return stack;
		// Decrement stack
		stack.decrement(decrementAmount);
		// Get a stack of the return item
		ItemStack output = new ItemStack(returnItem);
		if (stack.isEmpty()) return output;
		// Drop item if inventory full
		if (!player.getInventory().insertStack(output)) player.dropItem(output, false);
		return stack;
	}

}
