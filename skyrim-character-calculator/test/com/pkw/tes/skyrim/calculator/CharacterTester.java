package com.pkw.tes.skyrim.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public class CharacterTester {

	private Character character;

	@Before
	public void setup() {
		this.character = Character.create(Race.NORD);
	}

	@Test
	public void testLevelNordSmithing() {
		character.getSkill(Type.SMITHING).levelUp();
		int actual = character.getSkill(Type.SMITHING).currentLevel();
		int expected = 21;
		assertEquals(expected, actual);
	}

	@Test
	public void testLevelNordAlteration() {
		character.getSkill(Type.ALTERATION).levelUp();
		int actual = character.getSkill(Type.ALTERATION).currentLevel();
		int expected = 16;
		assertEquals(expected, actual);
	}

	@Test
	public void testLevelNordAlterationTwice() {
		levelSkill(character.getSkill(Type.ALTERATION), 2);
		int actual = character.getSkill(Type.ALTERATION).currentLevel();
		int expected = 17;
		assertEquals(expected, actual);
	}

	private void levelSkill(Skill skill, int times) {
		for (int i = 0; i < times; i++) {
			skill.levelUp();
		}
	}

}
