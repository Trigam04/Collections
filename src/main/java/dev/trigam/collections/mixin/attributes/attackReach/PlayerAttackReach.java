package dev.trigam.collections.mixin.attributes.attackReach;

import dev.trigam.collections.attribute.AttributeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PlayerEntity.class)
abstract class PlayerAttackReach extends LivingEntity {

	protected PlayerAttackReach(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@ModifyConstant( method = "attack(Lnet/minecraft/entity/Entity;)V", constant = @Constant(doubleValue = 9.0) )
	private double getActualAttackRange(double attackRange) {
		return getAttributeValue(AttributeInit.ATTACK_REACH);
	}
}
