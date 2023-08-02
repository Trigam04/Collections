package dev.trigam.collections.mixin.attributes.attackReach;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.trigam.collections.attribute.AttributeInit;
import dev.trigam.collections.item.IReachTool;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(SwordItem.class)
public class SwordReachModifier extends ToolItem implements Vanishable, IReachTool {
	@Shadow @Final @Mutable private float attackDamage;
	@Shadow @Final @Mutable private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	private double attackReach = 9;

	public SwordReachModifier(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
		super(toolMaterial, settings);
		this.attackDamage = (float)attackDamage + toolMaterial.getAttackDamage();
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(
			EntityAttributes.GENERIC_ATTACK_DAMAGE,
			new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
			EntityAttributes.GENERIC_ATTACK_SPEED,
			new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
			AttributeInit.ATTACK_REACH,
			new EntityAttributeModifier(AttributeInit.ATTACK_REACH_MODIFIER_ID, "Weapon modifier", this.attackReach, EntityAttributeModifier.Operation.ADDITION)
		);
		this.attributeModifiers = builder.build();
	}

	public void setAttackReach(double attackReach) {
		this.attackReach = attackReach;
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		for (Map.Entry<EntityAttribute, EntityAttributeModifier> entry : this.attributeModifiers.entries()) {
			if (!entry.getKey().equals(AttributeInit.ATTACK_REACH)) {
				builder.put(entry.getKey(), entry.getValue());
			}
		}
		builder.put(AttributeInit.ATTACK_REACH, new EntityAttributeModifier(AttributeInit.ATTACK_REACH_MODIFIER_ID, "Weapon modifier", this.attackReach, EntityAttributeModifier.Operation.ADDITION));

		this.attributeModifiers = builder.build();
	}
}
