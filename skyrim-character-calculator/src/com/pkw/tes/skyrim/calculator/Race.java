package com.pkw.tes.skyrim.calculator;

import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ALCHEMY;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ALTERATION;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ARCHERY;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.BLOCK;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.CONJURATION;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.DESTRUCTION;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ENCHANTING;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.HEAVY_ARMOR;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ILLUSION;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.LIGHT_ARMOR;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.LOCKPICKING;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.ONE_HANDED;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.PICKPOCKET;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.RESTORATION;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.SMITHING;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.SNEAK;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.SPEECH;
import static com.pkw.tes.skyrim.calculator.skills.Skill.Type.TWO_HANDED;

import java.util.Arrays;
import java.util.List;

import com.pkw.tes.skyrim.calculator.skills.Skill.Type;

public enum Race {

	ALTMER {

		@Override
		public Type primarySkill() {
			return ILLUSION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(CONJURATION, DESTRUCTION, RESTORATION,
					ALTERATION, ENCHANTING);
		}
	},

	ARGONIAN {

		@Override
		public Type primarySkill() {
			return LOCKPICKING;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(LIGHT_ARMOR, SNEAK, PICKPOCKET, RESTORATION,
					ALTERATION);
		}
	},

	BOSMER {

		@Override
		public Type primarySkill() {
			return ARCHERY;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(LIGHT_ARMOR, SNEAK, LOCKPICKING, PICKPOCKET,
					ALCHEMY);
		}
	},

	BRETON {

		@Override
		public Type primarySkill() {
			return CONJURATION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(SPEECH, ALCHEMY, ILLUSION, RESTORATION,
					ALTERATION);
		}
	},

	DUNMER {

		@Override
		public Type primarySkill() {
			return DESTRUCTION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(LIGHT_ARMOR, SNEAK, ALCHEMY, ILLUSION, ALTERATION);
		}
	},

	IMPERIAL {

		@Override
		public Type primarySkill() {
			return RESTORATION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(HEAVY_ARMOR, BLOCK, ONE_HANDED, DESTRUCTION,
					ENCHANTING);
		}
	},

	KHAJIIT {

		@Override
		public Type primarySkill() {
			return SNEAK;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(ONE_HANDED, ARCHERY, LOCKPICKING, PICKPOCKET,
					ALCHEMY);
		}
	},

	NORD {

		@Override
		public Type primarySkill() {
			return TWO_HANDED;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(SMITHING, BLOCK, ONE_HANDED, LIGHT_ARMOR, SPEECH);
		}
	},

	ORSIMER {

		@Override
		public Type primarySkill() {
			return HEAVY_ARMOR;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(SMITHING, BLOCK, TWO_HANDED, ONE_HANDED,
					ENCHANTING);
		}
	},

	REDGUARD {

		@Override
		public Type primarySkill() {
			return ONE_HANDED;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(SMITHING, BLOCK, ONE_HANDED, CONJURATION,
					ALTERATION);
		}
	};

	public static final Race HIGH_ELF = ALTMER;
	public static final Race WOOD_ELF = BOSMER;
	public static final Race DARK_ELF = DUNMER;
	public static final Race ORC = ORSIMER;

	private static List<Type> skillsList(Type one, Type two, Type three,
			Type four, Type five) {
		return Arrays.asList(new Type[] { one, two, three, four, five });
	}

	public abstract Type primarySkill();

	public abstract List<Type> favoredSkills();
}
