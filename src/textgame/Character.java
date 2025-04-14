package textgame;

import java.util.Random;

public class Character {
    String name;
    int number;
    String job;
    int maxHealth = 10;
    int health = maxHealth;
    int mana = 10;
    int intelligence = 0;
    int speed = 0;
    int strength = 0;
    int level = 1;
    int xp = 0;
    int life = 3;
    String[] Skills;

    Character(String name, int number, String job) {
        this.name = name;
        this.number = number;

        if (job.equals("전사")) {
            this.job = "전사";
            maxHealth += 10;
            strength += 10;
        }
        if (job.equals("도적")) {
            this.job = "도적";
            speed += 10;
        }
        if (job.equals("마법사")) {
            this.job = "마법사";
            mana += 10;
            intelligence += 10;
            this.Skills = new String[1];
            Skills[0] = "파이어볼";
        }
    }

    void CharacterInfo() {
        System.out.println("*****************************************\n" +
                "캐릭터 이름: " + name + "\n" +
                "현재 체력: " + health + "\n" +
                "직업: " + job + "\n" +
                "레벨: " + level + "\n" +
                "xp: " + xp + "\n" +
                "최대체력: " + maxHealth + "\t" + "마나: " + mana + "\n" +
                "힘: " + strength + " 지능: " + intelligence + " 민첩: " + speed + "\n" +
                "남은 목숨: " + life + "\n" +
                "*****************************************\n");
    }

    void skillInfo() {
        System.out.println("보유 스킬");
        if (Skills == null) {
            System.out.println("스킬창이 비어있습니다");
        } else {
            for (int i = 0; i < Skills.length; i++) {
                System.out.println(i + 1 + ": " + Skills[i]);
            }
        }
    }

    int CharacterAttack() {
        int damage = 1;

        System.out.println("플레이어의 공격!");
        if (job.equals("전사")) {
            damage *= strength;
        } else if (job.equals("마법사")) {
            damage *= intelligence;
        } else {
            damage *= speed;
        }
        Random rd = new Random();
        int critical = (int)(damage*1.5);
        int isCritical= rd.nextInt(100);
        if(isCritical< speed){
            System.out.println("!!크리티컬!!");
            damage = critical;
        }
        System.out.println("플레이어가 " + damage + "만큼의 피해를 입혔습니다");
        return damage;
    }

    void CharacterHit(int damage) {
        Random random = new Random();
        int dodge = speed;
        int isDodge = random.nextInt(100);
        if(isDodge<dodge){
            System.out.println("감나빗!");
        }else{
        System.out.println("!공격당했습니다!");
        health -= damage;
        System.out.println("플레이어 남은체력: " + health);
        }
    }
    void CharacterDie(){
        System.out.println("!플레이어 케릭터가 사망했습니다!");
        xp-= (int)(xp*0.2);
        maxHealth -= 5;
        System.out.println("xp , 최대체력 감소");
    }

    void getXp(int xp) {
        this.xp += xp;
        if (this.xp >= 1000) {
            level = 5;
            System.out.println("플레이어 레벨 5 달성!");
            maxHealth += 5;
        } else if (this.xp >= 800) {
            level = 4;
            System.out.println("플레이어 레벨 4 달성!");
            maxHealth += 5;
        } else if (this.xp >= 500) {
            level = 3;
            System.out.println("플레이어 레벨 3 달성!");
            maxHealth += 5;
        } else if (this.xp >= 300) {
            level = 2;
            System.out.println("플레이어 레벨 2 달성!");
            maxHealth += 5;
        } else
            level = 1;
    }

    void characterTrain() {
        Random rd = new Random();
        int randomChoice = rd.nextInt(3);
        switch (randomChoice) {
            case 0:
                intelligence += 1;
                System.out.println("지능이 1 올랐습니다! 현재: " + intelligence);
                break;
            case 1:
                strength += 1;
                System.out.println("힘이 1 올랐습니다! 현재: " + strength);
                break;
            case 2:
                speed += 1;
                System.out.println("민첩이 1 올랐습니다! 현재: " + speed);
                break;
        }
    }

    void characterRest() {
        health = maxHealth;
        System.out.println("체력이 충전되었습니다");
    }

    void characterExercise() {
        maxHealth += 3;
        System.out.println("최대체력이 올랐습니다");
    }

    void menuList() {
        System.out.println(
                """
                        *****************************************
                        1:캐릭터 훈련(랜덤 공격 스텟+1) 행동력 1 소모
                        2:스킬 정보
                        3:휴식(체력 충전)행동력 전부 소모
                        4:운동(최대체력 업) 행동력 1 소모
                        5:전투시작 행동력 1 소모
                        6:캐릭터 정보
                        8:메뉴선택확인
                        0: 종료
                        *****************************************
                        """);
    }

}
