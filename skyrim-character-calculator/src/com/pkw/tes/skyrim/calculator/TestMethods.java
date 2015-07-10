package com.pkw.tes.skyrim.calculator;

public class TestMethods {

	private static final int DEFAULT_XP_PER_SKILL_RANK = 1;

	public static void main(String[] args) {

	}

	public static int characterXpEarned(int skillLevelAquired) {
		return skillLevelAquired * DEFAULT_XP_PER_SKILL_RANK;
	}

	public static int xpToCharacterLevelUp(int currentLevel) {
		return (currentLevel + 3) * 25;
	}
}
