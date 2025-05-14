public abstract class Pokemon {
    // 基本属性
    protected String name;
    protected int level;
    protected int hp;
    protected int attack;
    protected int defense;
    protected PokemonType type;

    public Pokemon(String name, int level, PokemonType type) {
        this.name = name;
        this.level = level;
        this.type = type;
        // 根据level计算初始属性
        this.hp = 50 + level * 10;
        this.attack = 5 + level * 2;
        this.defense = 5 + level * 2;
    }

    public void heal() {
        // 恢复初始hp
        this.hp = 50 + this.level * 10;
    }

    public abstract void attack(Pokemon opponent);

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isAlive() {
        // todo add code here
        return true;
    }

    // 属性类型克制优势计算
    protected double typeAdvantage(Pokemon opponent){
        // todo add code here
        return 1.0;
    }
}
