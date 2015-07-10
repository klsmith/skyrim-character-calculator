package com.pkw.tes.skyrim.calculator;

import static com.pkw.tes.skyrim.calculator.Skill.Type.ALTERATION;
import static com.pkw.tes.skyrim.calculator.Skill.Type.SMITHING;
import static com.pkw.tes.skyrim.calculator.Skill.Type.TWO_HANDED;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SkillLevelingTester {

    private Character nordCharacter;

    @Before
    public void setup() {
        this.nordCharacter = Character.create(Race.NORD);
    }

    @Test
    public void testLevelNordSmithing() {
        nordCharacter.skill(SMITHING).levelUp();
        int actual = nordCharacter.skill(SMITHING).currentLevel();
        int expected = 21;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlteration() {
        nordCharacter.skill(ALTERATION).levelUp();
        int actual = nordCharacter.skill(ALTERATION).currentLevel();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordAlterationTwice() {
        nordCharacter.skill(ALTERATION).addLevel(2);
        int actual = nordCharacter.skill(ALTERATION).currentLevel();
        int expected = 17;
        assertEquals(expected, actual);
    }

    @Test
    public void testNordXpToLevel2Is100() {
        int actual = nordCharacter.xpForNextLevel();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordTwoHandedTwiceXpIs81() {
        nordCharacter.skill(TWO_HANDED).addLevel(2);
        int actual = nordCharacter.currentXp();
        int expected = 53;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelNordTwoHandedFourTimesLevelsCharacter() {
        nordCharacter.skill(TWO_HANDED).addLevel(4);
        int actual = nordCharacter.currentLevel();
        int expected = 2;
        assertEquals(expected, actual);
    }

}
