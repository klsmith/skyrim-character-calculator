package com.pkw.tes.skyrim.calculator;

import static com.pkw.tes.skyrim.calculator.IllusionPerkType.NOVICE_ILLUSION;
import static com.pkw.tes.skyrim.calculator.Skill.Type.ILLUSION;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PerkTester {

    private Character character;

    @Before
    public void setup() {
        character = Character.create(Race.ALTMER);
    }

    @Test
    public void testLevelingGivesOnePerk() {
        character.skill(ILLUSION).addLevel(4);
        int actual = character.perkPoints();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testNoLevelingDoesNotGivePerk() {
        character.skill(ILLUSION).addLevel(3);
        int actual = character.perkPoints();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testLevelingAndSpendingPerkLeavesNoPerk() {
        character.skill(ILLUSION).addLevel(4);
        character.skill(ILLUSION).perkTree().perk(NOVICE_ILLUSION).addPoint();
        int actual = character.perkPoints();
        int expected = 0;
        assertEquals(expected, actual);
    }
}
