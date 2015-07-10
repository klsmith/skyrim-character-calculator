package com.pkw.tes.skyrim.calculator;

public class OnSkillLevelListener {

	private Character character;

	public static OnSkillLevelListener getFor(Character character) {
		return new OnSkillLevelListener(character);
	}

	public OnSkillLevelListener(Character character) {
		this.character = character;
	}

	public void onLevel(Skill skill) {
		character.addXp(skill.currentLevel());
	}
}
