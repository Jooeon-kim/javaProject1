package textgame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random  = new Random();
        System.out.println("링크 스타트");
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        System.out.println("번호를 입력하세요");
        int number = sc.nextInt();
        System.out.println("직업을 선택하세요 ( 전사,마법사,도적 ");
        String job = sc.next();
        Character character = new Character(name,number,job);
        System.out.println("캐릭터가 생성되었습니다");

        System.out.println(
                        "1:캐릭터 정보"+"\n"+
                        "2:스킬 정보"+"\n"+
                        "3:경험치 정보"+"\n"+
                        "4:전투시작"+"\n"+
                        "0: 종료");
        int select = 8;
        do{
            select = sc.nextInt();
            switch(select){
                case 1:
                    character.CharacterInfo();
                    break;
                case 2:
                    character.skillInfo();
                    break;
                case 3:
                    character.showXp();
                    break;
                case 4:
                    Enemies enemies = new Enemies();
                    Enemy firstEnemy = enemies.EnemyList[random.nextInt(3)];
                    BattleManager.BattleStart(character, firstEnemy);
                    break;
                case 0:
                    System.out.println("게임을 종료합니다");
            }

        }while(select!=0);
    }
}
