package dev.trigam.collections.mixin.attributes.attackReach;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.trigam.collections.attribute.AttributeInit;
import dev.trigam.collections.item.ITool;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.TridentItem;
import net.minecraft.item.Vanishable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TridentItem.class)
public class TridentModifier extends Item implements Vanishable, ITool {
	@Shadow @Final @Mutable private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	private float attackDamage = 7;
	private double attackSpeed = 2;
	private double attackReach = 9;

	public TridentModifier(Settings settings) {
		super(settings);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = buildAttributes(
			this.attackDamage, this.attackSpeed, this.attackReach
		);
		this.attributeModifiers = builder.build();
	}

	public void setAttackDamage(float attackDamage) {
		this.attackDamage = attackDamage;
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = buildAttributes(
			this.attackDamage, this.attackSpeed, this.attackReach
		);
		this.attributeModifiers = builder.build();
	}

	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = buildAttributes(
			this.attackDamage, this.attackSpeed, this.attackReach
		);
		this.attributeModifiers = builder.build();
	}

	public void setAttackReach(double attackReach) {
		this.attackReach = attackReach;
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = buildAttributes(
			this.attackDamage, this.attackSpeed, this.attackReach
		);
		this.attributeModifiers = builder.build();
	}

	private ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> buildAttributes(float attackDamage, double attackSpeed, double attackReach) {
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(
			EntityAttributes.GENERIC_ATTACK_DAMAGE,
			new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", attackDamage, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
			EntityAttributes.GENERIC_ATTACK_SPEED,
			new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION)
		);
		builder.put(
			AttributeInit.ATTACK_REACH,
			new EntityAttributeModifier(AttributeInit.ATTACK_REACH_MODIFIER_ID, "Tool modifier", attackReach, EntityAttributeModifier.Operation.ADDITION)
		);
		return builder;
	}
}
