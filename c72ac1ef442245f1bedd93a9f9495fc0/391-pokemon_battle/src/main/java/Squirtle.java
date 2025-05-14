public class Squirtle extends Pokemon{
    private int waterPressure;

    public Squirtle(String name, int level) {
        super(name, level, PokemonType.WATER);
        this.waterPressure = 0;
    }

    public int getWaterPressure() {
        // 测试用，请不要删除该方法
        return waterPressure;
    }

    @Override
    public void attack(Pokemon opponent) {
        // todo add code here
    }
}
