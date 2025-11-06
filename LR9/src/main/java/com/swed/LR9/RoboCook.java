package com.swed.LR9;

/**
 * Robot cook that knows how to fry pancakes, prepare stuffing and wrap it.
 */
public class RoboCook {

    public <T extends Pancake> T fryPancake(T pancake) {
        pancake.setFried(true);
        return pancake;
    }

    public <S extends Stuffing> S prepareStuffing(S stuffing) {
        if (stuffing.needsPreparation() && !stuffing.isPrepared()) {
            stuffing.prepare();
        }
        return stuffing;
    }

    public <T extends Pancake, S extends Stuffing> ReadyPancake<T, S> wrapStuffing(T pancake, S stuffing) {
        if (!pancake.isFried()) {
            throw new IllegalStateException("Потрібно спочатку підсмажити млинець.");
        }
        if (stuffing.needsPreparation() && !stuffing.isPrepared()) {
            throw new IllegalStateException("Начинка ще не готова до загортання.");
        }
        return new ReadyPancake<>(pancake, stuffing);
    }
}
