package com.pkw.tes.skyrim.calculator;

public class OnLevelListener {

	private Character character;

	public static OnLevelListener getFor(Character character) {
		return new OnLevelListener(character);
	}

	public OnLevelListener(Character character) {
		this.character = character;
	}

	public void onLevel(Skill skill) {
		character.addXp(skill.currentLevel());
	}
}
