package nemos_Adventure.dev.model;

import nemos_Adventure.dev.utils.Stat;
import nemos_Adventure.dev.utils.Type;

public class Creature extends Stat {
	private String Name;
	private Type type;
	private int DEF = 0;

	public Creature(String name) {
		super();
		this.Name = name;
	}

	public Creature(String name, Type type) {
		super();
		this.Name = name;
		this.type = type;
	}

	public int calDamge() {
		if (type == Type.STR) {
			return getSTR() * 2 + getDEX() + getINT();
		}
		if (type == Type.DEX) {
			return getSTR() + getDEX() * 2 + getINT();
		}
		if (type == Type.INT) {
			return getSTR() + getDEX() + getINT() * 2;
		}
		return getSTR() + getDEX() + getINT();

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

}
