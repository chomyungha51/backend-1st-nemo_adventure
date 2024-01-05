package nemo_adventure.dev.model;

import nemo_adventure.dev.utils.Rarity;
import nemo_adventure.dev.utils.Type;

public class Monster extends Creature{
	Rarity rarity;

	public Monster(String name, int tT, Type type, Rarity rarity) {
		super(name,type, tT);
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
