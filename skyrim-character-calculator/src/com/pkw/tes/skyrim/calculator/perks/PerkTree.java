package com.pkw.tes.skyrim.calculator.perks;
import com.pkw.tes.skyrim.calculator.Character;
public class PerkTree {

	private Character character;

	public PerkTree(Character character) {
		this.character = character;
	}

	public Perk perk(PerkType perkType) {
		return new Perk(character);
	}

}
