package dev.trigam.collections.mixin.attributes.attackReach;

import dev.trigam.collections.attribute.AttributeInit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GameRenderer.class)
public class AttackIndicatorMixin {

	@Shadow @Final @Mutable
	MinecraftClient client;

	@ModifyVariable(method = "updateTargetedEntity", ordinal = 0, at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/entity/Entity;getCameraPosVec(F)Lnet/minecraft/util/math/Vec3d;"))
	private double setTargetDistance(double value, float tickDelta) {
		final PlayerEntity player = (PlayerEntity) client.getCameraEntity();

		if (player != null) return player.getAttributeValue(AttributeInit.ATTACK_REACH);
		return value;
	}

	@ModifyVariable(method = "updateTargetedEntity", ordinal = 1, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getRotationVec(F)Lnet/minecraft/util/math/Vec3d;"))
	private double setTargetSquaredDistance(double value, float tickDelta) {
		final PlayerEntity player = (PlayerEntity) client.getCameraEntity();

		if (player != null) {
			if (this.client.crosshairTarget == null || this.client.crosshairTarget.getType() == HitResult.Type.MISS) {
				final double reach = player.getAttributeValue(AttributeInit.ATTACK_REACH);
				return reach * reach;
			}
		}
		return value;
	}

	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 3.0D))
	private double targetDistance(double value, float tickDelta) {
		final PlayerEntity player = (PlayerEntity) client.getCameraEntity();

		if (player != null) return player.getAttributeValue(AttributeInit.ATTACK_REACH);
		return value;
	}

	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 6.0D))
	private double targetExtendedDistance(double value, float tickDelta) {
		final PlayerEntity player = (PlayerEntity) client.getCameraEntity();

		if (player != null) return player.getAttributeValue(AttributeInit.ATTACK_REACH);
		return value;
	}

	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 9.0D))
	private double targetSquaredMaxDistance(double value, float tickDelta) {
		final PlayerEntity player = (PlayerEntity) client.getCameraEntity();

		if (player != null) {
			if (this.client.crosshairTarget == null || this.client.crosshairTarget.getType() == HitResult.Type.MISS) {
				final double reach = player.getAttributeValue(AttributeInit.ATTACK_REACH);
				return reach * reach;
			}
		}
		return value;
	}
}
