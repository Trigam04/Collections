package dev.trigam.collections.mixin.stacking;

import dev.trigam.collections.util.ItemHelper;
import net.minecraft.item.BucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Mixin(BucketItem.class)
public abstract class Bucket {
	@Inject(method = "getEmptiedStack", at = @At(value = "HEAD"), cancellable = true)
	private static void getEmptiedStack(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<ItemStack> info) {
		ItemStack newStack = ItemHelper.decrementStack(stack, player, Items.BUCKET, 1);
		info.setReturnValue(newStack);
	}
}
