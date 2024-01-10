package nemos_Adventure.dev.model;

import nemos_Adventure.dev.utils.Type;

public class Player extends Creature {
	Weapon selectedWeapon = null;

	public Player(String name, Type type) {
		super(name, type);
	}

	@Override
	public int calDamge() {
		int damage = super.calDamge();
		if (selectedWeapon != null) {
			damage += damage * (selectedWeapon.getRarity().getValue() * 0.1);
		}
		return damage;
	}

	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}

	public void setSelectedWeapon(Weapon selectedWeapon) {
		this.selectedWeapon = selectedWeapon;
	}
}
