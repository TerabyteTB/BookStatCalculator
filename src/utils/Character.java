package utils;

import java.util.EnumMap;
import java.util.Map;

public class Character {
    int level;
    FractureStats.Race race;
    Map<FractureStats.Stat, Integer> stats = new EnumMap<>(FractureStats.Stat.class);

    public Character(int level, FractureStats.Race race) {
        this.level = level;
        this.race = race;
        for (FractureStats.Stat s : FractureStats.Stat.values()) {
            stats.put(s, 10);
        }
    }

    public void addStat(FractureStats.Stat stat, int value) {
        stats.put(stat, stats.get(stat) + value);
    }

    public int getStat(FractureStats.Stat stat) {
        return stats.get(stat);
    }

}