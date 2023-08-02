package dev.trigam.collections.mixin.attributes;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class TooltipFormatting {
	@ModifyVariable(method = "getAttributeModifiers", at = @At("STORE"), ordinal = 0)
	private Multimap<EntityAttribute, EntityAttributeModifier> load(Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
		LinkedHashMultimap<EntityAttribute, EntityAttributeModifier> result = LinkedHashMultimap.create();
		result.putAll(attributes);
		return result;
	}
}
