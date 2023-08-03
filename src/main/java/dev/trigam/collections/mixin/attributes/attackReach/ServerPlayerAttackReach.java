package dev.trigam.collections.mixin.attributes.attackReach;

import dev.trigam.collections.attribute.AttributeInit;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetworkHandler.class)
abstract class ServerPlayerAttackReach implements ServerPlayPacketListener {
	@Shadow public ServerPlayerEntity player;

	@Redirect(
		method = "onPlayerInteractionWithEntity(Lnet/minecraft/network/packet/c2s/play/PlayerInteractionWithEntityC2SPacket;)V",
		at = @At(value = "FIELD", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;MAX_INTERACTION_DISTANCE:D",
			opcode = Opcodes.GETSTATIC
		)
	)
	private double getActualAttackRange() {
		return MathHelper.square(player.getAttributeValue(AttributeInit.ATTACK_REACH));
	}
}
