package nemo_adventure.dev.model;

import nemo_adventure.dev.utils.Type;

public class Player extends Creature{
	Weapon selectedWeapon = null;
	
	public Player(String name, Type type, int tT) {
		super(name, type, tT);
	}
	
	@Override
	public int calDamge() {
		if (selectedWeapon != null){
			int damage = super.calDamge();
			damage += damage*(selectedWeapon.getRarity().getValue()*0.1);
			return damage;
		}else { 
			return super.calDamge();
		}
	}

	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}

	public void setSelectedWeapon(Weapon selectedWeapon) {
		this.selectedWeapon = selectedWeapon;
	}	
}
