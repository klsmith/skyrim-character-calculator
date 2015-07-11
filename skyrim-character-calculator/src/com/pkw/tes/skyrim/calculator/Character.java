package com.pkw.tes.skyrim.calculator;

import com.pkw.tes.skyrim.calculator.skills.Skill;
import com.pkw.tes.skyrim.calculator.skills.Skill.Type;
import com.pkw.tes.skyrim.calculator.skills.SkillMap;

public class Character {

	private int xp;
	private int level;
	private Race race;
	private SkillMap skillMap;
	private int perkPoints;

	public static Character create(Race race) {
		return new Character(race);
	}

	private Character(Race race) {
		xp = 0;
		level = 1;
		this.race = race;
		skillMap = SkillMap.createFor(this);
		perkPoints = 0;
	}

	public void levelUp() {
		addLevel(1);
	}

	public void addLevel(int amount) {
		level += amount;
		perkPoints += amount;
	}

	public Skill skill(Type type) {
		return skillMap.get(type);
	}

	public void addXp(int amount) {
		xp += amount;
		if (xp >= xpForNextLevel()) {
			xp -= xpForNextLevel();
			levelUp();
		}
	}

	public int currentXp() {
		return xp;
	}

	public int xpForNextLevel() {
		return ((level - 1) * 25) + 100;
	}

	public int currentLevel() {
		return level;
	}

	public int perkPoints() {
		return perkPoints;
	}

	public Race race() {
		return race;
	}

	public void usePerkPoint() {
		perkPoints -= 1;
	}
}
