package nemos_Adventure.dev.utils;

public class Skill {
	private String name;
	private Rarity rarity;
	private Type type;

	
	public Skill(String name, Rarity rarity, Type type) {
		super();
		this.name = name;
		this.rarity = rarity;
		this.type = type;
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
	

	
}
