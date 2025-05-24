package net.luko.random_mob_levels.util;

public class LevelUtil {
    public static int getRandomLevel(){
        //Survival function is used. Low levels are common, high levels are less common but extend far.
        return (int)Math.pow((1.0 / Math.random()) - 1.0, 0.65);
    }
}
