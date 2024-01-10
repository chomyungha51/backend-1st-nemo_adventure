package nemos_Adventure.dev.service;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import nemos_Adventure.dev.model.Item;
import nemos_Adventure.dev.model.Monster;
import nemos_Adventure.dev.model.Player;
import nemos_Adventure.dev.model.Weapon;
import nemos_Adventure.dev.utils.RandomGenerator;

public class Game {
	private static final Logger logger = Logger.getLogger(State.class.getName());
	static int turn = 0;

	public static Logger getLogger() {
		return logger;
	}

	private static RandomGenerator g = new RandomGenerator();
	private static Scanner sc = new Scanner(System.in);
	private static Random random = new Random();

	public static void main(String[] args) {

		String userInput;

		try {
			final String fileName = "game_log.log";
			FileHandler handler = new FileHandler(fileName);

			handler.setFormatter(new SimpleFormatter() {
				private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

				@Override
				public synchronized String format(LogRecord lr) {
					return String.format(format, new Date(lr.getMillis()), lr.getLevel(), lr.getMessage());
				}
			});
			logger.addHandler(handler);

			Player player1 = new Player("nemo", null);
			logger.info("player nemo를 생성했습니다.");

			State state = new State(player1, logger);
			logger.info("player nemo를 초기화했습니다.");
			state.gameStage = true;
			logger.info("게임을 시작합니다.");
			while (state.gameStage) {
				if (random.nextBoolean()) {
					logger.info("battle stage에 진입했습니다.");
					battle(state);
				} else {
					logger.info("item stage에 진입했습니다.");
					item(state);
				}
				if (state.gameStage) {
					System.out.println("게임을 계속하시겠습니까?(y/n)");
					userInput = sc.next();
					if (!userInput.equals("y")) {
						System.out.println("게임을 종료합니다.");
						logger.info("게임을 종료합니다.");
						break;
					}
				}
			}

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void battle(State state) {
		state.setBattleStage(true);
		Monster monster = g.generateRandomMonster();
		state.setMonster(monster);
		logger.info("monster " + monster.getName() + " 을/를 생성했습니다.");
		while (state.isBattleStage()) {
			turn++;
			logger.info(turn + " 턴입니다.");
//			System.out.printf("============%d 턴입니다.============%n%n", ++turn);
			logger.info("유저가 공격합니다.");
			state.attacked(true);
			state.printHPState();
			if (state.checkHP()) {
				logger.info("monster " + monster.getName() + " 이/가 공격합니다.");
				state.attacked(false);
				state.printHPState();
				state.checkHP();
			}
		}
		logger.info("battle stage가 종료합니다.");
	}

	static void item(State state) {
		turn++;
		logger.info(turn + " 턴입니다.");
//		System.out.printf("============%d 턴입니다.============%n%n", ++turn);
		if (random.nextBoolean()) {

			Item item = g.generateRandomItem();
			state.itemStage(item);
			logger.info("아이템 " + item.getName() + " 을/를 주웠습니다.");
		} else {
			Weapon weapon = g.generateRandomWeapon();
			state.weaponStage(weapon);
			logger.info(weapon.getType() + " 타입 무기 " + weapon.getName() + " 을/를 주웠습니다.");
		}
	}
}
