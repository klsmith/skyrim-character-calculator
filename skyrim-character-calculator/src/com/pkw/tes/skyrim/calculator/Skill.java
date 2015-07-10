package com.pkw.tes.skyrim.calculator;

import java.util.ArrayList;
import java.util.List;

public class Skill {

    private static final int PRIMARY_INTITIAL_LEVEL = 25;
    private static final int FAVORED_INTITIAL_LEVEL = 20;
    private static final int BASE_INTITIAL_LEVEL = 15;
    private int level;
    private Type type;
    private List<OnSkillLevelListener> onLevelListeners;

    public static Skill primaryLevel(Type type) {
        return new Skill(type, PRIMARY_INTITIAL_LEVEL);
    }

    public static Skill favoredLevel(Type type) {
        return new Skill(type, FAVORED_INTITIAL_LEVEL);
    }

    public static Skill baseLevel(Type type) {
        return new Skill(type, BASE_INTITIAL_LEVEL);
    }

    private Skill(Type type, int baseLevel) {
        this.type = type;
        this.level = baseLevel;
        this.onLevelListeners = new ArrayList<>();
    }

    public void levelUp() {
        level++;
        for (OnSkillLevelListener listener : onLevelListeners) {
            listener.onLevel(this);
        }
    }

    public void addLevel(int amount) {
        for (int i = 0; i < amount; i++) {
            levelUp();
        }
    }

    public int currentLevel() {
        return level;
    }

    public void addOnSkillLevelListener(OnSkillLevelListener onLevelListener) {
        onLevelListeners.add(onLevelListener);
    }

    public Type type() {
        return type;
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

    public PerkTree perkTree() {
        return null;
    }
}
