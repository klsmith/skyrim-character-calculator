package com.pkw.tes.skyrim.calculator;

import java.util.ArrayList;
import java.util.List;

public class Skill {
	private static final int PRIMARY_INTITIAL_LEVEL = 25;
	private static final int FAVORED_INTITIAL_LEVEL = 20;
	private static final int BASE_INTITIAL_LEVEL = 15;
	private int level;
	private List<OnLevelListener> onLevelListeners;

	public static Skill primaryLevel() {
		return new Skill(PRIMARY_INTITIAL_LEVEL);
	}

	public static Skill favoredLevel() {
		return new Skill(FAVORED_INTITIAL_LEVEL);
	}

	public static Skill baseLevel() {
		return new Skill(BASE_INTITIAL_LEVEL);
	}

	private Skill(int baseLevel) {
		this.level = baseLevel;
		this.onLevelListeners = new ArrayList<>();
	}

	public void levelUp() {
		level++;
		for (OnLevelListener listener : onLevelListeners) {
			listener.onLevel(this);
		}
	}

	public int currentLevel() {
		return level;
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

	public void addOnLevelListener(OnLevelListener onLevelListener) {
		onLevelListeners.add(onLevelListener);
	}
}
