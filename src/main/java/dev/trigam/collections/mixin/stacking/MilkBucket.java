package dev.trigam.collections.mixin.stacking;

import dev.trigam.collections.util.ItemHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;

// Fixes drinking a milk bucket consuming the entire stack
@Mixin(MilkBucketItem.class)
public abstract class MilkBucket {
	@Inject(method = "finishUsing", at = @At(value = "RETURN"), cancellable = true)
	private void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> info) {
		if (!(user instanceof PlayerEntity playerEntity)) return;
		ItemStack newStack = ItemHelper.decrementStack(stack, playerEntity, Items.BUCKET, 0);
		info.setReturnValue(newStack);
	}
}
