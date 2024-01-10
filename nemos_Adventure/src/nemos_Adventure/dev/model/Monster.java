package nemos_Adventure.dev.model;

import nemos_Adventure.dev.utils.Rarity;
import nemos_Adventure.dev.utils.Type;

public class Monster extends Creature{
	Rarity rarity;

	public Monster(String name, Type type, Rarity rarity) {
		super(name,type);
		this.rarity = rarity;
		generateStat();
	}
	
	void generateStat() {
		setINT(getType() == Type.INT ? rarity.getValue() : (int)(rarity.getValue()/2));
		setDEX(getType() == Type.DEX ? rarity.getValue() : (int)(rarity.getValue()/2));
		setSTR(getType() == Type.STR ? rarity.getValue() : (int)(rarity.getValue()/2));
	}

	@Override
	public int calDamge() {
		return (int) (super.calDamge() * 0.5) ;
	}
}
