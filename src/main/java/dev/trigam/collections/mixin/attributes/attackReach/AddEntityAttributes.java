package dev.trigam.collections.mixin.attributes.attackReach;

import dev.trigam.collections.attribute.AttributeInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
abstract class AddEntityAttributes extends Entity {
	AddEntityAttributes(final EntityType<?> type, final World world) {
		super(type, world);
	}

	@Inject(
		method = "createAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
		at = @At("RETURN"))
	private static void addAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.getReturnValue().add(AttributeInit.ATTACK_REACH);
	}
}
