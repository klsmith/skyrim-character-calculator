package com.pkw.tes.skyrim.calculator.skills;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pkw.tes.skyrim.calculator.Character;
import com.pkw.tes.skyrim.calculator.skills.Skill.Type;

public class SkillMap {

	private Map<Type, Skill> map;

	public static SkillMap createFor(Character character) {
		return new SkillMap(character);
	}

	private SkillMap(Character character) {
		super();
		map = new HashMap<>();
		addPrimarySkill(character);
		addFavoredSkills(character);
		fillInBaseSkills(character);
	}

	private void addPrimarySkill(Character character) {
		add(Skill.primaryLevel(character, character.race().primarySkill()));
	}

	private void addFavoredSkills(Character character) {
		for (Type type : character.race().favoredSkills()) {
			add(Skill.favoredLevel(character, type));
		}
	}

	private void fillInBaseSkills(Character character) {
		for (Type type : Type.values()) {
			if (!has(type)) {
				add(Skill.baseLevel(character, type));
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
}
