package nemo_adventure.dev.utils;

public enum Rarity {
	normal(1), rare(2), unique(3), legendary(4);

	private final int value;

	Rarity(int i) {
		this.value = i;
	}

	public int getValue() {
		return value;
	}

}
