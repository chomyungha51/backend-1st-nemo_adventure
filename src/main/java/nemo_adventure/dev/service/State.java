package nemo_adventure.dev.service;

import nemo_adventure.dev.model.Item;
import nemo_adventure.dev.model.Monster;
import nemo_adventure.dev.model.Player;
import nemo_adventure.dev.model.Weapon;
import nemo_adventure.dev.utils.Type;

public class State {
	Player player;
	int playerHP;

	int monsterHP;
	Monster monster;

	boolean itemStage;
	boolean battleStage;
	boolean gameStage;

	public State(Player player) {
		super();
		playerHP = player.getHP();
		this.player = player;
	}

	public State(Player player, Monster monster) {
		super();
		playerHP = player.getHP();
		monsterHP = monster.getHP();
		this.player = player;
		this.monster = monster;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
		monsterHP = monster.getHP();
	}

	void printHPState() {
		System.out.printf("%s의 현재 체력은 %d입니다.%n%s 타입 몬스터 %s의 현재 체력은 %d입니다.%n", player.getName(), playerHP,
				monster.getType(), monster.getName(), monsterHP);

	}

	void attacked(boolean flag) {
		if (flag) {
			System.out.printf("플레이어 %s가 몬스터 %s를 공격했습니다.%n데미지가 %d만큼 닳았습니다.%n", player.getName(), monster.getName(),
					player.calDamge());
			monsterHP -= player.calDamge();
		} else {
			System.out.printf("%s 타입 몬스터 %s가 플레이어 %s를 공격했습니다.%n데미지가 %d만큼 닳았습니다.%n", monster.getType(),
					monster.getName(), player.getName(), monster.calDamge());
			playerHP -= monster.calDamge();
		}
	}

	void itemStage(Item item) {

		playerHP += item.getHP();
		System.out.printf("아이템 %s을 사용했습니다.%n플레이어 %s의 체력이 %d만큼 늘었습니다.%n플레이어의 현제 체력은 %d입니다.%n", item.getName(),
				player.getName(), item.getHP(), playerHP);

	}
	
	void weaponStage(Weapon weapon) {
		System.out.printf("플레이어 %s가 %s 타입 %s 무기를 발견했습니다.%n", player.getName(),weapon.getType(), weapon.getName());
		if(player.getType() == weapon.getType() && weapon.getRarity().getValue() > player.getSelectedWeapon().getRarity().getValue()) {
			player.setSelectedWeapon(weapon);
			System.out.printf("플레이어 %s가 %s 무기를 장착했습니다%n", player.getName(), weapon.getName());
		}else {
			System.out.printf("플레이어 %s가 %s 무기를 장착에 실패했습니다.%n", player.getName(), weapon.getName());
		}
		
	}

	boolean checkHP() {
		if (playerHP <= 0) {
			System.out.printf("플레이어 %s가 죽었습니다.%n", player.getName());
			this.battleStage = false;
			this.gameStage = false;
			return false;
		} else if (monsterHP <= 0) {
			System.out.printf("몬스터 %s가 죽었습니다.%n", monster.getName());
			player.setSTR(player.getSTR() + (int) (Math.floor(monster.getSTR() / 2)));
			player.setDEX(player.getDEX() + (int) (Math.floor(monster.getDEX() / 2)));
			player.setINT(player.getINT() + (int) (Math.floor(monster.getINT() / 2)));
			this.battleStage = false;
			if (player.getType() == null) {
				if (player.getSTR() >= 30) {
					player.setType(Type.STR);
					System.out.printf("플레이어 %s는 전사로 전직했습니다.", player.getName());
				} else if (player.getDEX() >= 30) {
					player.setType(Type.DEX);
					System.out.printf("플레이어 %s는 궁수로 전직했습니다.", player.getName());
				} else if (player.getINT() >= 30) {
					player.setType(Type.INT);
					System.out.printf("플레이어 %s는 마법사로 전직했습니다.", player.getName());
				}
			}
			return false;
		}
		return true;
	}

	public int getPlayerHP() {
		return playerHP;
	}

	public void setPlayerHP(int playerHP) {
		this.playerHP = playerHP;
	}

	public int getMonsterHP() {
		return monsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

	public boolean isBattleStage() {
		return battleStage;
	}

	public void setBattleStage(boolean battleStage) {
		this.battleStage = battleStage;
	}

}
