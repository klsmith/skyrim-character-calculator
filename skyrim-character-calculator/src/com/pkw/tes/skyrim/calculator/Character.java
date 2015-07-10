package com.pkw.tes.skyrim.calculator;

import java.util.Map;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class Character {

	private int xp;
	private int level;
	private Map<Skill.Type, Skill> skillMap;

	public static Character create(Race race) {
		return new Character(race);
	}

	private Character(Race race) {
		xp = 0;
		level = 1;
		skillMap = race.initalSkills();
		for (Type type : skillMap.keySet()) {
			skillMap.get(type).addOnLevelListener(OnLevelListener.getFor(this));
		}
	}

	public void levelUp() {
		level++;
	}

	public Skill getSkill(Type type) {
		return skillMap.get(type);
	}

	public void addXp(int xp) {
		this.xp += xp;
		if (xp >= xpForNextLevel()) {
			xp -= xpForNextLevel();
			levelUp();
		}
	}

	public int currentXp() {
		return xp;
	}

	public int xpForNextLevel() {
		return (level + 3) * 25;
	}
}
