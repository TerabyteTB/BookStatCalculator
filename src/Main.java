import utils.Character;
import utils.FractureStats;

import static utils.FractureStats.*;

public class Main {
    public static void main(String[] args) {
        utils.Character amber = new Character(5, FractureStats.Race.HUMAN);
        amber.addStat(FractureStats.Stat.STR, 11);
        amber.addStat(FractureStats.Stat.DEX, 15);
        amber.addStat(FractureStats.Stat.END, 17);
        amber.addStat(FractureStats.Stat.VIT, 16);
        amber.addStat(FractureStats.Stat.INT, 15);
        amber.addStat(FractureStats.Stat.WIS, 10);
        amber.addStat(FractureStats.Stat.PER, 10);
        amber.addStat(FractureStats.Stat.RES, 10);

        System.out.println("Max HP: " + maxHP(amber));
        System.out.println("Max MP: " + maxMP(amber));
        System.out.println("Max SP: " + maxSP(amber));
        System.out.println("HP Regen/s: " + hpRegenPerSecond(amber));
        System.out.println("MP Regen/s: " + mpRegenPerSecond(amber));
        System.out.println("SP Regen/s: " + spRegenPerSecond(amber));
        System.out.println("Melee Multiplier: " + meleeDamageMultiplier(amber));
        System.out.println("Spell Multiplier: " + spellDamageMultiplier(amber));
        System.out.println("Crit Chance (%): " + critChance(amber));
        System.out.println("XP Multiplier: " + experienceMultiplier(amber));
        System.out.println("Stat Points per Level: " + statPointsPerLevel(amber));
    }
}
