package com.pkw.tes.skyrim.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class SkillMap {

    private Map<Type, Skill> map;

    public static SkillMap getInstance() {
        return new SkillMap();
    }

    private SkillMap() {
        super();
        map = new HashMap<>();
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
}
