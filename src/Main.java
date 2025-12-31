public class Main{
    public static void main(String[] args) {
        Character amber = new Character(10, Race.HUMAN);
        amber.addStat(Stat.STR, 5);
        amber.addStat(Stat.INT, 8);
        amber.addStat(Stat.VIT, 4);

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
