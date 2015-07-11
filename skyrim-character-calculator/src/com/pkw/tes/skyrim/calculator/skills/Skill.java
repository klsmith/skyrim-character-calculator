package com.pkw.tes.skyrim.calculator.skills;

import com.pkw.tes.skyrim.calculator.Character;
import com.pkw.tes.skyrim.calculator.perks.PerkTree;

public class Skill {

	private static final int PRIMARY_INTITIAL_LEVEL = 25;
	private static final int FAVORED_INTITIAL_LEVEL = 20;
	private static final int BASE_INTITIAL_LEVEL = 15;
	private int level;
	private Type type;
	private Character character;

	public static Skill primaryLevel(Character character, Type type) {
		return new Skill(character, type, PRIMARY_INTITIAL_LEVEL);
	}

	public static Skill favoredLevel(Character character, Type type) {
		return new Skill(character, type, FAVORED_INTITIAL_LEVEL);
	}

	public static Skill baseLevel(Character character, Type type) {
		return new Skill(character, type, BASE_INTITIAL_LEVEL);
	}

	private Skill(Character character, Type type, int baseLevel) {
		this.type = type;
		this.level = baseLevel;
		this.character = character;
	}

	public void levelUp() {
		level++;
		character.addXp(currentLevel());
	}

	public void addLevel(int amount) {
		for (int i = 0; i < amount; i++) {
			levelUp();
		}
	}

	public int currentLevel() {
		return level;
	}

	public Type type() {
		return type;
	}

	public PerkTree perkTree() {
		return new PerkTree(character);
	}

	public enum Type {
		SMITHING, //
		HEAVY_ARMOR, //
		BLOCK, //
		TWO_HANDED, //
		ONE_HANDED, //
		ARCHERY, //
		LIGHT_ARMOR, //
		SNEAK, //
		LOCKPICKING, //
		PICKPOCKET, //
		SPEECH, //
		ALCHEMY, //
		ILLUSION, //
		CONJURATION, //
		DESTRUCTION, //
		RESTORATION, //
		ALTERATION, //
		ENCHANTING;
	}
}
