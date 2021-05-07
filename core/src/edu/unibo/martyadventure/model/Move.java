package edu.unibo.martyadventure.model;

import java.util.Random;

public enum Move {
    // name(dmg, failRatio, reloadTime, Melee or Ranged)
    GANCIO(50, 10, 2, 'M', 0), LANCIO(50, 10, 2, 'R', 0);

    private final int damage;
    private final int failRatio; // 0 success 100 fail
    private final int reloadTime;
    private final char MeleeOrRanged;
    private int lastUse; // last turn of use

    Move(int damage, int failRatio, int reloadTime, char MeleeOrRanged, int lastUse) {
        this.damage = damage;
        this.failRatio = failRatio;
        this.reloadTime = reloadTime;
        this.MeleeOrRanged = MeleeOrRanged;
        setLastUse(lastUse);
    }

    public int getDamage() {
        return damage;
    }

    public int getFailRatio() {
        return failRatio;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public char getMeleeOrRanged() {
        return MeleeOrRanged;
    }

    public int getLastUse() {
        return lastUse;
    }

    public void setLastUse(int lastUse) {
        this.lastUse = lastUse;
    }

    public static Move getRandomMove() {
        return values()[(int) (Math.random() * values().length)];
    }

    // magari vanno in fight

    public boolean isUsable(int fightTurn) {
        if ((lastUse + reloadTime < fightTurn)) {
            this.lastUse = fightTurn;
            return true;
        } else
            return false;
    }

    public boolean failCalc(int failRatio) {
        Random rand = new Random();// random number if it's <= failRatio success, else fail
        return (rand.nextInt(101) >= failRatio);
    }

    /*
     * public static Move getRandomMeleeMove() {
     * 
     * }
     * 
     * public static Move getRandomRangedMove() {
     * 
     * }
     */

}