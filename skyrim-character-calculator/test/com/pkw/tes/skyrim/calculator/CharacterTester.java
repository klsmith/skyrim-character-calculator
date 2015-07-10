package com.pkw.tes.skyrim.calculator;

import static com.pkw.tes.skyrim.calculator.Skill.Type.ALTERATION;
import static com.pkw.tes.skyrim.calculator.Skill.Type.SMITHING;
import static com.pkw.tes.skyrim.calculator.Skill.Type.TWO_HANDED;
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
        character.skill(SMITHING).levelUp();
        int actual = character.skill(SMITHING).currentLevel();
        int expected = 21;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlteration() {
        character.skill(ALTERATION).levelUp();
        int actual = character.skill(ALTERATION).currentLevel();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlterationTwice() {
        character.skill(ALTERATION).addLevel(2);
        int actual = character.skill(ALTERATION).currentLevel();
        int expected = 17;
        assertEquals(expected, actual);
    }

    @Test
    public void testNordXpToLevel2Is100() {
        int actual = character.xpForNextLevel();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordTwoHandedTwiceXpIs81() {
        character.skill(TWO_HANDED).addLevel(2);
        int actual = character.currentXp();
        int expected = 53;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordTwoHandedFourTimesLevelsCharacter() {
        character.skill(TWO_HANDED).addLevel(4);
        int actual = character.currentLevel();
        int expected = 2;
        assertEquals(expected, actual);
    }

}
