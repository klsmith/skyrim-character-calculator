package com.pkw.tes.skyrim.calculator;

import java.util.Map;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class Character {

    private int xp;
    private int level;
    private Map<Skill.Type, Skill> skills;

    public static Character create(Race race) {
        return new Character(race);
    }

    private Character(Race race) {
        xp = 0;
        level = 1;
        skills = race.initalSkills();
        for (Type type : skills.keySet()) {
            skills.get(type).addOnSkillLevelListener(OnSkillLevelListener.getFor(this));
        }
    }

    public void levelUp() {
        level++;
    }

    public Skill getSkill(Type type) {
        return skills.get(type);
    }

    public void addXp(int amount) {
        xp += amount;
        if (amount >= xpForNextLevel()) {
            amount -= xpForNextLevel();
            levelUp();
        }
    }

    public int currentXp() {
        return xp;
    }

    public int xpForNextLevel() {
        return ((level - 1) * 25) + 100;
    }
}
