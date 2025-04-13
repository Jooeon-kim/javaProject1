package textgame;

public class Enemy {
    String name;
    int level;
    int health;
    int speed;
    int strength;
    Enemy(String name,int level){
        this.name = name;
        this.level = level;
        this.health = 10*level;
        this.speed = 2*level;
        this.strength = 2*level;
        }
    int EnemyAttack(){
        System.out.println(name+"의 공격!");
        int damage = 1;
        damage+=level;
        return damage;
    }
    void EnemyHit(int damage){
        health-=damage;
        System.out.println("남은 적 체력: "+health);
    }
}

class Enemies{
    Enemy [] EnemyList = new Enemy[3];
    Enemies(){
        EnemyList [0] = new Enemy("박쥐",1);
        EnemyList [1] = new Enemy("공룡",1);
        EnemyList[1].health+=10;
        EnemyList [2] = new Enemy("생쥐",1);
        EnemyList[2].speed+=2;
    }

}
class BattleManager{
    static void BattleStart(Character player , Enemy enemy){
        System.out.println("시작");
        int playerDamage;
        int enemyDamage;
        while(player.health>0 && enemy.health>0) {
            if (player.speed > enemy.speed) {
                System.out.println("플레이어 선공");
                playerDamage = player.CharacterAttack();
                enemy.EnemyHit(playerDamage);
                enemyDamage = enemy.EnemyAttack();
                player.CharacterHit(enemyDamage);
            } else {
                System.out.println("적의 선공");
                enemyDamage = enemy.EnemyAttack();
                player.CharacterHit(enemyDamage);
                playerDamage = player.CharacterAttack();
                enemy.EnemyHit(playerDamage);
            }
        }
        System.out.println("전투 종료");
        if(player.health>0){
            System.out.println("플레이어 승리!");
            player.getXp(300);
        }else
            System.out.println("플레이어 패배");
    }
}