public class Pikachu extends Pokemon {
    // 取值0-3
    private int chargeLevel;

    public Pikachu(String name, int level) {
        super(name, level, PokemonType.ELECTRIC);
        this.chargeLevel = 0;
    }

    public int getChargeLevel() {
        // 测试用，请不要删除该方法
        return chargeLevel;
    }

    @Override
    public void attack(Pokemon opponent) {
        // todo add code here
    }
}