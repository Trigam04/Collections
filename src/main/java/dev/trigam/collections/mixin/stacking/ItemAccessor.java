package dev.trigam.collections.mixin.stacking;

import dev.trigam.collections.item.IItemCount;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.Item;

@Mixin(Item.class)
public abstract class ItemAccessor implements IItemCount {
	@Final @Mutable @Shadow private int maxCount;
	@Override
	public void setMaxCount(int i) {
		this.maxCount = i;
	}
}
