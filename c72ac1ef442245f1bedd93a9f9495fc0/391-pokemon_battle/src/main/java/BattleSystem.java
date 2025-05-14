public class BattleSystem {
    // 战斗，返回赢家
    public static Pokemon battle(Pokemon p1, Pokemon p2) {
        // todo add code here
        return null;
    }

    public static void main(String[] args) {
        Pokemon charizard = new Charizard("喷火龙", 10);
        Pokemon pikachu = new Pikachu("皮卡丘", 8);
        Pokemon winner = battle(charizard, pikachu);
        System.out.printf("赢家是: %s%n", winner.name);
    }
}
