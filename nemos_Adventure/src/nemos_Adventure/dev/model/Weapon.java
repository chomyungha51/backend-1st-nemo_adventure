package nemos_Adventure.dev.model;

import nemos_Adventure.dev.utils.Rarity;
import nemos_Adventure.dev.utils.Stat;
import nemos_Adventure.dev.utils.Type;

public class Weapon extends Stat {
	private String name;
	private Type type;
	private Rarity rarity;

	public Weapon(String name, Rarity rarity, Type type) {
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
	}
}
