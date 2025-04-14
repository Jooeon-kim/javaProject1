package textgame;

import java.util.Random;

public class Enemy {
    String name;
    int level;
    int health;
    int speed;
    int strength;

    Enemy(String name, int level) {
        this.name = name;
        this.level = level;
        this.health = 10 * level;
        this.speed = 2 * level;
        this.strength = 2 * level;
    }

    int EnemyAttack() {
        System.out.println(name + "의 공격!");
        int damage = 1;
        damage += level;
        return damage;
    }

    void EnemyHit(int damage) {
        health -= damage;
        System.out.println("남은 적 체력: " + health);
    }
}

class Enemies {
    Enemy[] EnemyList = new Enemy[3];

    Enemies() {
        Random random = new Random();
        EnemyList[0] = new Enemy("박쥐", 1);
        EnemyList[0].strength += random.nextInt(5);
        EnemyList[1] = new Enemy("공룡", 1);
        EnemyList[1].health += random.nextInt(20);
        EnemyList[2] = new Enemy("생쥐", 1);
        EnemyList[2].speed += random.nextInt(10);
    }

}


class BattleManager {
    static void BattleStart(Character player, Enemy enemy) {
        System.out.println("시작");
        int playerDamage;
        int enemyDamage;
        while (player.health > 0 && enemy.health > 0) {
            if (player.speed > enemy.speed) {
                System.out.println("플레이어 선공");
                playerDamage = player.CharacterAttack();
                enemy.EnemyHit(playerDamage);
                if(enemy.health<0)
                    break;
                enemyDamage = enemy.EnemyAttack();
                player.CharacterHit(enemyDamage);
            } else {
                System.out.println(enemy.name+"의 선공");
                enemyDamage = enemy.EnemyAttack();
                player.CharacterHit(enemyDamage);
                playerDamage = player.CharacterAttack();
                enemy.EnemyHit(playerDamage);
            }
        }
        System.out.println("전투 종료");
        if (player.health > 0) {
            System.out.println("플레이어 승리!");
            player.getXp(50 * enemy.level);
        } else {
            player.CharacterDie();
            player.life -= 1;
        }
    }
}