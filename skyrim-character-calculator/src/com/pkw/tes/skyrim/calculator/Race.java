package com.pkw.tes.skyrim.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pkw.tes.skyrim.calculator.Skill.Type;

public enum Race {

	ALTMER {
		@Override
		public Type primarySkill() {
			return Type.ILLUSION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.CONJURATION, Type.DESTRUCTION,
					Type.RESTORATION, Type.ALTERATION, Type.ENCHANTING);
		}
	},

	ARGONIAN {
		@Override
		public Type primarySkill() {
			return Type.LOCKPICKING;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.LIGHT_ARMOR, Type.SNEAK, Type.PICKPOCKET,
					Type.RESTORATION, Type.ALTERATION);
		}
	},

	BOSMER {
		@Override
		public Type primarySkill() {
			return Type.ARCHERY;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.LIGHT_ARMOR, Type.SNEAK, Type.LOCKPICKING,
					Type.PICKPOCKET, Type.ALCHEMY);
		}
	},

	BRETON {
		@Override
		public Type primarySkill() {
			return Type.CONJURATION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.SPEECH, Type.ALCHEMY, Type.ILLUSION,
					Type.RESTORATION, Type.ALTERATION);
		}
	},

	DUNMER {
		@Override
		public Type primarySkill() {
			return Type.DESTRUCTION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.LIGHT_ARMOR, Type.SNEAK, Type.ALCHEMY,
					Type.ILLUSION, Type.ALTERATION);
		}
	},

	IMPERIAL {
		@Override
		public Type primarySkill() {
			return Type.RESTORATION;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.HEAVY_ARMOR, Type.BLOCK, Type.ONE_HANDED,
					Type.DESTRUCTION, Type.ENCHANTING);
		}
	},

	KHAJIIT {
		@Override
		public Type primarySkill() {
			return Type.SNEAK;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.ONE_HANDED, Type.ARCHERY, Type.LOCKPICKING,
					Type.PICKPOCKET, Type.ALCHEMY);
		}
	},

	NORD {
		@Override
		public Type primarySkill() {
			return Type.TWO_HANDED;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.SMITHING, Type.BLOCK, Type.ONE_HANDED,
					Type.LIGHT_ARMOR, Type.SPEECH);
		}
	},

	ORSIMER {
		@Override
		public Type primarySkill() {
			return Type.HEAVY_ARMOR;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.SMITHING, Type.BLOCK, Type.TWO_HANDED,
					Type.ONE_HANDED, Type.ENCHANTING);
		}
	},

	REDGUARD {
		@Override
		public Type primarySkill() {
			return Type.ONE_HANDED;
		}

		@Override
		public List<Type> favoredSkills() {
			return skillsList(Type.SMITHING, Type.BLOCK, Type.ONE_HANDED,
					Type.CONJURATION, Type.ALTERATION);
		}
	};

	private Race() {
	}

	private static List<Type> skillsList(Type one, Type two, Type three,
			Type four, Type five) {
		return Arrays.asList(new Type[] { one, two, three, four, five });
	}

	private static Map<Type, Skill> fillInRemainingSkills(
			Map<Type, Skill> skills) {
		for (Type type : Type.values()) {
			if (!skills.containsKey(type)) {
				skills.put(type, Skill.baseLevel());
			}
		}
		return skills;
	}

	public abstract Type primarySkill();

	public abstract List<Type> favoredSkills();

	public final Map<Type, Skill> initalSkills() {
		Map<Type, Skill> skills = new HashMap<>();
		skills.put(primarySkill(), Skill.primaryLevel());
		for (Type type : favoredSkills()) {
			skills.put(type, Skill.favoredLevel());
		}
		return fillInRemainingSkills(skills);
	}
}
