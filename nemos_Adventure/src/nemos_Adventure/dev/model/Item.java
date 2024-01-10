package nemos_Adventure.dev.model;

import nemos_Adventure.dev.utils.Rarity;
import nemos_Adventure.dev.utils.Stat;

public class Item extends Stat{
	private String name;
	private Rarity rarity;
	
	public Item(String name, Rarity rarity,boolean used) {
		super();
		this.name = name;
		this.rarity = rarity;
		generateStat();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void generateStat() {
		setHP(rarity.getValue() * 10);
		setMP(rarity.getValue() * 10);
	}
	
}
