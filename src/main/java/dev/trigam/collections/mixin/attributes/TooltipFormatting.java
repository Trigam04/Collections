package dev.trigam.collections.mixin.attributes;

import com.llamalad7.mixinextras.sugar.Local;
import dev.trigam.collections.attribute.AttributeInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Mixin(ItemStack.class)
public class TooltipFormatting {

	private static ArrayList<UUID> greenModifiers = new ArrayList<>(
		Arrays.asList(
			AttributeInit.ATTACK_DAMAGE_MODIFIER_ID,
			AttributeInit.ATTACK_SPEED_MODIFIER_ID,
			AttributeInit.ATTACK_REACH_MODIFIER_ID
		)
	);

	@ModifyVariable(
		method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;",
		at = @At("STORE"), ordinal = 0
	)
	public boolean formatGreen( boolean original, @Local( ordinal = 0 ) PlayerEntity player, @Local( ordinal = 0 ) EntityAttributeModifier modifier ) {
		if (player != null) if (greenModifiers.contains(modifier.getId())) return true;
		return original;
	}

	@ModifyVariable(
		method = "getTooltip(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/client/item/TooltipContext;)Ljava/util/List;",
		at = @At("STORE"), ordinal = 0
	)
	public double modifierValue( double original, @Local( ordinal = 0 ) PlayerEntity player, @Local( ordinal = 0 ) EntityAttributeModifier modifier ) {
		double value = modifier.getValue();
		if (player != null) {
			if (modifier.getId().toString().equals(AttributeInit.ATTACK_DAMAGE_MODIFIER_ID.toString())) {
				value += player.getBaseValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
				value += EnchantmentHelper.getAttackDamage((ItemStack) (Object) this, EntityGroup.DEFAULT);
			} else if (modifier.getId().toString().equals(AttributeInit.ATTACK_SPEED_MODIFIER_ID.toString())) {
				System.out.println(original);
				value += player.getBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED);
			} else if (modifier.getId() == AttributeInit.ATTACK_REACH_MODIFIER_ID) {
				value += player.getBaseValue(AttributeInit.ATTACK_REACH);
			}
		}
		return value;
	}
}
