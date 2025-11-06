package com.swed.LR9;

/**
 * Describes contract for any stuffing that can be wrapped into a pancake.
 */
public interface Stuffing {
    /**
     * @return true when stuffing must be prepared before use.
     */
    boolean needsPreparation();

    /**
     * @return true if stuffing is ready for wrapping.
     */
    boolean isPrepared();

    /**
     * Performs the preparation step (if needed) to make the stuffing ready.
     */
    void prepare();
}
