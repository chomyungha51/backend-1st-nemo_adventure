package nemos_Adventure.dev.utils;

public abstract class Stat {
	private int HP = 100;
	private int MP = 100;
	private int INT = 1;
	private int DEX = 1;
	private int STR = 1;

	public Stat() {
		super();
	}

	public Stat(int hP, int mP, int iNT, int dEX, int sTR) {
		super();
		HP = hP;
		MP = mP;
		INT = iNT;
		DEX = dEX;
		STR = sTR;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getDEX() {
		return DEX;
	}

	public void setDEX(int dEX) {
		DEX = dEX;
	}

	public int getSTR() {
		return STR;
	}

	public void setSTR(int sTR) {
		STR = sTR;
	}

}
