package com.pkw.tes.skyrim.calculator.perks;
import com.pkw.tes.skyrim.calculator.Character;
public class Perk {

	private Character character;

	public Perk(Character character) {
		this.character = character;
	}

	public void addPoint() {
		character.usePerkPoint();
	}
}
