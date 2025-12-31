public class FractureStats {

    /* ---------- ENUMS ---------- */

    public static enum Stat {
        STR, DEX, END, VIT, INT, WIS, PER, RES
    }

    public static enum Race {
        HUMAN,
        ELF,
        DWARF,
        DEMON,
        GNOME
    }

    /* ---------- CORE DATA ---------- */

    public static class Character {
        int level;
        Race race;
        Map<Stat, Integer> stats = new EnumMap<>(Stat.class);

        Character(int level, Race race) {
            this.level = level;
            this.race = race;
            for (Stat s : Stat.values()) {
                stats.put(s, 10);
            }
        }

        void addStat(Stat stat, int value) {
            stats.put(stat, stats.get(stat) + value);
        }

        int getStat(Stat stat) {
            return stats.get(stat);
        }
    }

    /* ---------- RESOURCE CALCULATIONS ---------- */

    static double maxHP(Character c) {
        double base = 100 + (c.level * 10) + (c.getStat(Stat.END) * 5);
        if (c.race == Race.DWARF) base *= 1.10;
        return base;
    }

    static double maxMP(Character c) {
        double base = 100 + (c.level * 10) + (c.getStat(Stat.INT) * 5);
        return base;
    }

    static double maxSP(Character c) {
        double base = 100 + (c.level * 10) + (c.getStat(Stat.END) * 5);
        if (c.race == Race.ELF) base *= 1.10;
        return base;
    }

    static double hpRegenPerSecond(Character c) {
        double regen = maxHP(c) * (0.001 * c.getStat(Stat.VIT));
        if (c.race == Race.DWARF) regen *= 1.10;
        return regen;
    }

    static double mpRegenPerSecond(Character c) {
        double regen = maxMP(c) * (0.0015 * c.getStat(Stat.WIS));
        if (c.race == Race.DEMON) regen *= 1.10;
        return regen;
    }

    static double spRegenPerSecond(Character c) {
        double regen = maxSP(c) * (0.002 * c.getStat(Stat.VIT));
        if (c.race == Race.ELF || c.race == Race.DEMON) regen *= 1.10;
        return regen;
    }

    /* ---------- COMBAT MODIFIERS ---------- */

    public static double meleeDamageMultiplier(Character c) {
        return 1.0 + (c.getStat(Stat.STR) * 0.01);
    }

    public static double rangedDamageMultiplier(Character c) {
        return 1.0 + (c.getStat(Stat.DEX) * 0.008);
    }

    public static double spellDamageMultiplier(Character c) {
        return 1.0 + (c.getStat(Stat.INT) * 0.012);
    }

    public static double accuracy(Character c) {
        return c.getStat(Stat.DEX) * 0.5;
    }

    public static double dodgeChance(Character c) {
        return c.getStat(Stat.DEX) * 0.3;
    }

    public static double critChance(Character c) {
        return c.getStat(Stat.PER) * 0.25;
    }

    public static double physicalDamageReduction(Character c) {
        return c.getStat(Stat.END) * 0.2;
    }

    public static double manaCostReduction(Character c) {
        double reduction = c.getStat(Stat.WIS) * 0.15;
        if (c.race == Race.GNOME) reduction += 5.0;
        return reduction;
    }

    public static double cooldownReduction(Character c) {
        if (c.race == Race.GNOME) return 5.0;
        return 0.0;
    }

    public static double mentalResistance(Character c) {
        return c.getStat(Stat.RES);
    }

    /* ---------- EXPERIENCE ---------- */

    public static double experienceMultiplier(Character c) {
        if (c.race == Race.HUMAN) return 1.05;
        return 1.0;
    }

    public static int statPointsPerLevel(Character c) {
        if (c.race == Race.HUMAN) return 6;
        return 5;
    }
}