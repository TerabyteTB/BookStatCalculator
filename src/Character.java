public class Character {
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