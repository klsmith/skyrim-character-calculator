package com.pkw.tes.skyrim.calculator;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class Character {

    private int xp;
    private int level;
    private SkillMap skillMap;

    public static Character create(Race race) {
        return new Character(race);
    }

    private Character(Race race) {
        xp = 0;
        level = 1;
        skillMap = race.initalSkills();
        skillMap.addOnSkillLevelListenerToAll(OnSkillLevelListener.getFor(this));
    }

    public void levelUp() {
        level++;
    }

    public Skill getSkill(Type type) {
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
}
