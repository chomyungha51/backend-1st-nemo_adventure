package nemo_adventure.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import nemo_adventure.dev.model.Item;
import nemo_adventure.dev.model.Monster;
import nemo_adventure.dev.model.Player;
import nemo_adventure.dev.model.Weapon;
import nemo_adventure.dev.utils.Rarity;
import nemo_adventure.dev.utils.Type;

public class Game {
	static int turn = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput;

		Player player1 = new Player("nemo", null, 1);
		Random random = new Random();

		State state = new State(player1);
		state.gameStage = true;

		while (state.gameStage) {
			if (random.nextBoolean()) {
				battle(state);
			} else {
				item(state);
			}
			if(state.gameStage) {		
				System.out.println("게임을 계속하시겠습니까?(y/n)");
				userInput = sc.next();
				if (!userInput.equals("y")) {
					System.out.println("게임을 종료합니다.");
					break;
				}
			}
		}

	}

	static void battle(State state) {
		state.setBattleStage(true);
		Monster monster = generateRandomMonster();
		state.setMonster(monster);
		while (state.isBattleStage()) {
			System.out.printf("============%d 턴입니다.============%n%n", ++turn);
			state.attacked(true);
			state.printHPState();
			if (state.checkHP()) {
				state.attacked(false);
				state.printHPState();
				state.checkHP();
			}
		}
	}

	static void item(State state) {
		System.out.printf("============%d 턴입니다.============%n%n", ++turn);
		Random random = new Random();
		if (random.nextBoolean()) {
			Item item = generateRandomItem();
			state.itemStage(item);			
		}else {
			Weapon weapon = generateRandomWeapon();
			state.weaponStage(weapon);
		}
	}

	public static Monster generateRandomMonster() {

        // 몬스터의 이름, 타입 및 레어도 배열
        String[] possibleMonsterNames = {"슬라임", "고블린", "스켈레톤", "오우거", "드래곤", "유니콘", "마왕", "요정", "젤리비스트",
                "베이지모스", "거대곰", "마녀", "뱀파이어", "코볼트", "해골마법사", "트롤", "픽시", "그림린", "데몬", "강아지"};

        Type[] possibleMonsterTypes = {Type.STR, Type.DEX, Type.INT};

        Rarity[] possibleMonsterRarities = {Rarity.normal, Rarity.rare, Rarity.unique, Rarity.legendary};

        // 랜덤으로 이름, 타입, 레어도 선택
        String randomMonsterName = possibleMonsterNames[getRandomIndex(possibleMonsterNames.length)];
        Type randomMonsterType = possibleMonsterTypes[getRandomIndex(possibleMonsterTypes.length)];
        Rarity randomMonsterRarity = possibleMonsterRarities[getRandomIndex(possibleMonsterRarities.length)];

        // 랜덤 생성된 몬스터 반환
        return new Monster(randomMonsterName, 1, randomMonsterType, randomMonsterRarity);
    }

	 public static Item generateRandomItem() {
        Rarity randomRarity = Rarity.values()[getRandomIndex(Rarity.values().length)]; // 랜덤 레어도 선택

        // 아이템 종류 및 이름 배열
        String[] possibleItemNames = {"체력 회복 물약", "마나 회복 물약", "신속 물약", "독 물약", "화염 저항 물약", "냉기 저항 물약",
                "독침", "회복 물약", "폭탄 물약", "약화의 물약", "분노의 물약", "침묵의 물약", "혼란의 물약", "신성한 물약", "어둠의 물약",
                "영원한 물약", "파괴의 물약", "환각의 물약", "소생의 비약", "삶의 물약"};

        // 아이템 이름 랜덤 선택
        String randomItemName = possibleItemNames[getRandomIndex(possibleItemNames.length)];

        return new Item(randomItemName, randomRarity, false);
    }
	
	 public static Weapon generateRandomWeapon() {
	        String[] possibleWeaponNames = {"소드", "도끼", "활", "창", "망치", "단검", "책", "지팡이", "활", "창"};
	        Type[] possibleWeaponTypes = {Type.STR, Type.DEX, Type.INT};
	        Rarity[] possibleWeaponRarities = {Rarity.normal, Rarity.rare, Rarity.unique, Rarity.legendary};

	        // 랜덤으로 이름, 타입, 레어도 선택
	        String randomWeaponName = possibleWeaponNames[(int) (getRandomIndex(possibleWeaponNames.length))];
	        Type randomWeaponType = possibleWeaponTypes[(int) (getRandomIndex(possibleWeaponTypes.length))];
	        Rarity randomWeaponRarity = possibleWeaponRarities[(int) (getRandomIndex(possibleWeaponRarities.length))];

	        // 무기 객체 생성 및 반환
	        return new Weapon(randomWeaponName, randomWeaponRarity, randomWeaponType);
	    }

	static int getRandomIndex(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}

}
