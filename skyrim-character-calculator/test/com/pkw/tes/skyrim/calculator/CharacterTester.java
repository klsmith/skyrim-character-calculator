package com.pkw.tes.skyrim.calculator;

import static com.pkw.tes.skyrim.calculator.Skill.Type.ALTERATION;
import static com.pkw.tes.skyrim.calculator.Skill.Type.SMITHING;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CharacterTester {

    private Character character;

    @Before
    public void setup() {
        this.character = Character.create(Race.NORD);
    }

    @Test
    public void testLevelNordSmithing() {
        character.getSkill(SMITHING).levelUp();
        int actual = character.getSkill(SMITHING).currentLevel();
        int expected = 21;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlteration() {
        character.getSkill(ALTERATION).levelUp();
        int actual = character.getSkill(ALTERATION).currentLevel();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlterationTwice() {
        levelSkill(character.getSkill(ALTERATION), 2);
        int actual = character.getSkill(ALTERATION).currentLevel();
        int expected = 17;
        assertEquals(expected, actual);
    }

    private void levelSkill(Skill skill, int times) {
        for (int i = 0; i < times; i++) {
            skill.levelUp();
        }
    }

}
