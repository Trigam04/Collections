package dev.trigam.collections.attribute;

import dev.trigam.collections.Collections;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class AttributeInit {

	public static EntityAttribute ATTACK_REACH = registerAttribute(
		"generic.attack_reach",
		new ClampedEntityAttribute("attribute.generic.name.Collections.attack_reach", 2.5, 0, 1024).setTracked(true)
	);
	public static final UUID ATTACK_REACH_MODIFIER_ID = UUID.fromString("26cb07a3-209d-4110-8e10-1010243614c8");
	// Vanilla cause stupid
	public static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("cb3f55d3-645c-4f38-a497-9c13a33db5cf");
	public static final UUID ATTACK_SPEED_MODIFIER_ID = UUID.fromString("fa233e1c-4180-4865-b01b-bcce9785aca3");

	private static EntityAttribute registerAttribute(String name, EntityAttribute attribute) {
		return Registry.register(Registries.ENTITY_ATTRIBUTE, new Identifier(Collections.ModID, name), attribute);
	}

}
