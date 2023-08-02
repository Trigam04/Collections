package dev.trigam.collections.mixin.attributes;

import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ItemStack.class)
public abstract class FullTooltipList {
	@Shadow public abstract Item getItem();
	@Inject(method = "getAttributeModifiers", locals = LocalCapture.CAPTURE_FAILHARD,
		at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;getList(Ljava/lang/String;I)Lnet/minecraft/nbt/NbtList;"))
	private void combineModifiers(EquipmentSlot slot, CallbackInfoReturnable<Multimap<EntityAttribute, EntityAttributeModifier>> cir, Multimap<EntityAttribute, EntityAttributeModifier> multimap) {
		multimap.putAll(getItem().getAttributeModifiers(slot));
	}
}
