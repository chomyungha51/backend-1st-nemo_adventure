package nemo_adventure.dev.model;

import nemo_adventure.dev.utils.Stat;
import nemo_adventure.dev.utils.Type;

public class Creature extends Stat{
	private String Name;
	private Type type;
	private int TT;
	private int DEF = 0;
	
	public Creature(String name, int tT) {
		super();
		this.Name = name;
		this.TT = tT;
	}
	
	public Creature(String name, Type type, int tT) {
		super();
		this.Name = name;
		this.type = type;
		this.TT = tT;
	}
	
	public int calDamge() {
		int damage = 0;
		if(type == Type.STR) {
			damage += getSTR() * 2;
			damage += getDEX();
			damage += getINT();
			return damage;
		}
		if(type == Type.DEX) {
			damage += getSTR();
			damage += getDEX() * 2;
			damage += getINT();
			return damage;
		}
		if(type == Type.INT) {
			damage += getSTR();
			damage += getDEX();
			damage += getINT() * 2;
			return damage;
		}
		damage += getSTR();
		damage += getDEX();
		damage += getINT();
		return damage;
		
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

	public int getTT() {
		return TT;
	}

	public void setTT(int tT) {
		TT = tT;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}
	
	
}
