package nemo_adventure.dev.model;

import nemo_adventure.dev.utils.Rarity;
import nemo_adventure.dev.utils.Stat;

public class Item extends Stat{
	private String name;
	private Rarity rarity;
	private boolean used;
	
	public Item(String name, Rarity rarity,boolean used) {
		super();
		this.name = name;
		this.rarity = rarity;
		this.used = used;
		generateStat();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	private void generateStat() {

		setHP(rarity.getValue() * 10);
		setMP(rarity.getValue() * 10);
	}
	
}
