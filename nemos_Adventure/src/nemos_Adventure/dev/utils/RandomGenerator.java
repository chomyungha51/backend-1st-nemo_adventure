package nemos_Adventure.dev.utils;

import java.util.Random;

import nemos_Adventure.dev.model.Item;
import nemos_Adventure.dev.model.Monster;
import nemos_Adventure.dev.model.Weapon;

public class RandomGenerator {

	public Monster generateRandomMonster() {

		// 몬스터의 이름, 타입 및 레어도 배열
		String[] possibleMonsterNames = { "슬라임", "고블린", "스켈레톤", "오우거", "드래곤", "유니콘", "마왕", "요정", "젤리비스트", "베이지모스",
				"거대곰", "마녀", "뱀파이어", "코볼트", "해골마법사", "트롤", "픽시", "그림린", "데몬", "강아지" };

		Type[] possibleMonsterTypes = { Type.STR, Type.DEX, Type.INT };

		Rarity[] possibleMonsterRarities = { Rarity.normal, Rarity.rare, Rarity.unique, Rarity.legendary };

		// 랜덤으로 이름, 타입, 레어도 선택
		String randomMonsterName = possibleMonsterNames[getRandomIndex(possibleMonsterNames.length)];
		Type randomMonsterType = possibleMonsterTypes[getRandomIndex(possibleMonsterTypes.length)];
		Rarity randomMonsterRarity = possibleMonsterRarities[getRandomIndex(possibleMonsterRarities.length)];

		// 랜덤 생성된 몬스터 반환
		return new Monster(randomMonsterName, randomMonsterType, randomMonsterRarity);
	}

	public Item generateRandomItem() {
		Rarity randomRarity = Rarity.values()[getRandomIndex(Rarity.values().length)]; // 랜덤 레어도 선택

		// 아이템 종류 및 이름 배열
		String[] possibleItemNames = { "체력 회복 물약", "마나 회복 물약", "신속 물약", "독 물약", "화염 저항 물약", "냉기 저항 물약", "독침", "회복 물약",
				"폭탄 물약", "약화의 물약", "분노의 물약", "침묵의 물약", "혼란의 물약", "신성한 물약", "어둠의 물약", "영원한 물약", "파괴의 물약", "환각의 물약",
				"소생의 비약", "삶의 물약" };

		// 아이템 이름 랜덤 선택
		String randomItemName = possibleItemNames[getRandomIndex(possibleItemNames.length)];

		return new Item(randomItemName, randomRarity, false);
	}

	public Weapon generateRandomWeapon() {
		String[] possibleWeaponNames = { "소드", "도끼", "활", "창", "망치", "단검", "책", "지팡이", "활", "창" };
		Type[] possibleWeaponTypes = { Type.STR, Type.DEX, Type.INT };
		Rarity[] possibleWeaponRarities = { Rarity.normal, Rarity.rare, Rarity.unique, Rarity.legendary };

		// 랜덤으로 이름, 타입, 레어도 선택
		String randomWeaponName = possibleWeaponNames[(int) (getRandomIndex(possibleWeaponNames.length))];
		Type randomWeaponType = possibleWeaponTypes[(int) (getRandomIndex(possibleWeaponTypes.length))];
		Rarity randomWeaponRarity = possibleWeaponRarities[(int) (getRandomIndex(possibleWeaponRarities.length))];

		// 무기 객체 생성 및 반환
		return new Weapon(randomWeaponName, randomWeaponRarity, randomWeaponType);
	}

	int getRandomIndex(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}

}
