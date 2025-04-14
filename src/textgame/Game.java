package textgame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("version a-0414");
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        System.out.println("번호를 입력하세요");
        int number = sc.nextInt();
        System.out.println("직업을 선택하세요 (전사,마법사,도적)");
        String job = sc.next();
        Character character = new Character(name, number, job);
        System.out.println("캐릭터가 생성되었습니다");
        character.menuList();
        int select = 100;
        int day = 1;
        int count = 3;
        do {
            if(character.life==0){
                System.out.println("게임오버");
                break;
            }
            if(day==10){
                System.out.println("보스 등장");
                Enemy boss = new Enemy("쏀놈",3);
                boss.health *=day;
                BattleManager.BattleStart(character,boss);
                day++;
                count =3;
            }
            if (count == 0) {
                day++;
                System.out.println("!!!!!!!!!!!행동력을 전부 소모했습니다 다음날로 넘어갑니다!!!!!!!!!!! ");
                count += 3;
            }
            System.out.println(">>>>>>>>>" + day + "<<<<<<<<<" + "일차");
            System.out.println("남은 행동력: " +"["+count+"]"+ "\t" + "메뉴: 8");
            System.out.print("실행할 메뉴 선택>>>");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    character.characterTrain();
                    count -= 1;
                    break;
                case 2:
                    character.skillInfo();
                    break;
                case 3:
                    character.characterRest();
                    day++;
                    count--;
                    break;
                case 4:
                    character.characterExercise();
                    count--;
                    break;
                case 5:
                    Enemies enemies = new Enemies();
                    Enemy firstEnemy = enemies.EnemyList[random.nextInt(3)];
                    BattleManager.BattleStart(character, firstEnemy);
                    count -= 1;
                    break;
                case 6:
                    character.CharacterInfo();
                    break;
                case 8:
                    character.menuList();
                    break;
                case 0:
                    System.out.println("게임을 종료합니다");
            }

        } while (select != 0);
    }
}
