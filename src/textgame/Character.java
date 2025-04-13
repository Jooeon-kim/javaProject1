package textgame;

public class Character {
    String name;
    int number;
    String job;
    int health = 10;
    int mana = 10;
    int intelligence = 0;
    int speed = 0 ;
    int strength= 0 ;
    int level = 1;
    int xp = 0;
    String [] Skills;
    Character(String name, int number, String job){
        this.name = name;
        this.number = number;

        if(job.equals("전사")){
            this.job = "전사";
            health += 10;
            strength +=10;
        }
        if(job.equals("도적")){
            this.job = "도적";
            health +=5;
            speed +=10;
        }
        if(job.equals("마법사")){
            this.job = "마법사";
            mana+=10;
            intelligence+=10;
            this.Skills = new String [1];
            Skills[0] = "파이어볼";
        }
    }
    void CharacterInfo(){
        System.out.println("캐릭터 이름: "+name+"\n"+
                            "번호: "+number+"\n"+
                            "직업: "+job+"\n"+
                            "레벨: "+level+"\n"+
                            "체력: "+health+"\t"+"마나: "+mana+"\n"+
                            "힘: "+strength+" 지능: "+intelligence+" 민첩: "+speed );
    }
    void showXp(){
        System.out.println("현재 레벨: "+level+" xp: "+xp);
    }
    void skillInfo(){
        System.out.println("보유 스킬");
        if(Skills==null){
            System.out.println("스킬창이 비어있습니다");
        }else{
            for(int i = 0 ; i <Skills.length ; i++){
                System.out.println(i+1+": "+Skills[i]);
            }
        }
    }
    int CharacterAttack(){
       int damage = 1;
        System.out.println("플레이어의 공격!");
        if(job.equals("전사")){
           damage *=strength;
       }else if(job.equals("마법사")){
            damage *=intelligence;
        }else{
            damage*=speed;
        }
        System.out.println("플레이어가 "+damage+"만큼의 피해를 입혔습니다");
           return damage;
    }

    void CharacterHit(int damage){
        System.out.println("공격당했습니다!");
        health-=damage;
        System.out.println("플레이어 남은체력: "+health);
    }
    void getXp(int xp){
        this.xp+=xp;
        if(this.xp>=1000){
            level = 5;
            System.out.println("플레이어 레벨 5 달성!");
        }else if(this.xp>=800){
            level = 4;
            System.out.println("플레이어 레벨 4 달성!");
        }else if(this.xp>=500){
            level = 3;
            System.out.println("플레이어 레벨 3 달성!");
        }else if(this.xp>=300){
            level = 2;
            System.out.println("플레이어 레벨 2 달성!");
        }else
            level=1;
    }

}
