package nemo_adventure.dev.model;

import java.util.ArrayList;
import java.util.List;

import nemo_adventure.dev.utils.Rarity;
import nemo_adventure.dev.utils.Stat;
import nemo_adventure.dev.utils.Type;

public class Weapon extends Stat {
	private String name;
	private Type type;
	private Rarity rarity;

	public Weapon(String name, Rarity rarity, Type type) {

		super();
		this.name = name;
		this.type = type;
		this.rarity = rarity;
		generateStat();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	
	

//	public List<Skill> getSkillList() {
//		return skillList;
//	}
//
//	public void setSkillList(List<Skill> skillList) {
//		this.skillList = skillList;
//	}
//
//	public void addSkill(Skill newSkill) {
//		this.skillList.add(newSkill);
//
//	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private void generateStat() {

		setINT(this.type == Type.INT ? rarity.getValue() * 2 : rarity.getValue());
		setDEX(this.type == Type.DEX ? rarity.getValue() * 2 : rarity.getValue());
		setSTR(this.type == Type.STR ? rarity.getValue() * 2 : rarity.getValue());
		// TODO hp, mp 추가 
		// TODO 방패...
	}
}
