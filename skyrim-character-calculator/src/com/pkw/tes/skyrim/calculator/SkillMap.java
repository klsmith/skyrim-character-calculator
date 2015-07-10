package com.pkw.tes.skyrim.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class SkillMap {

    private Map<Type, Skill> map;

    public static SkillMap createFor(Race race) {
        return new SkillMap(race);
    }

    private SkillMap(Race race) {
        super();
        map = new HashMap<>();
        addPrimarySkill(race);
        addFavoredSkills(race);
        fillInBaseSkills();
    }

    private void addPrimarySkill(Race race) {
        add(Skill.primaryLevel(race.primarySkill()));
    }

    private void addFavoredSkills(Race race) {
        for (Type type : race.favoredSkills()) {
            add(Skill.favoredLevel(type));
        }
    }

    private void fillInBaseSkills() {
        for (Type type : Type.values()) {
            if (!has(type)) {
                add(Skill.baseLevel(type));
            }
        }
    }

    public void add(Skill skill) {
        map.put(skill.type(), skill);
    }

    public Skill get(Type type) {
        return map.get(type);
    }

    public boolean has(Type type) {
        return map.containsKey(type);
    }

    public Set<Type> types() {
        return map.keySet();
    }

    public void addOnSkillLevelListenerToAll(OnSkillLevelListener listener) {
        for (Type type : types()) {
            map.get(type).addOnSkillLevelListener(listener);
        }
    }
}
