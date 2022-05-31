import java.lang.Math;

public class EggDrop {
    private final int eggs;
    private final int floors;
    private Integer minNumOfEggDrops = null;

    public EggDrop(final int eggs, final int floors) {
        this.eggs = eggs;
        this.floors = floors;
    }

    public int getMinNumOfEggDrops() {
        if (minNumOfEggDrops == null) {
            minNumOfEggDrops = EggDrop.calcMinNumOfEggDrops(
                this.eggs,
                this.floors
            );
        }
        return minNumOfEggDrops;
    }

    private static int calcMinNumOfEggDrops(int eggs, int floors) {
        int i, j, k, drop;
        int[][] minNumOfEggDrops = new int[eggs + 1][floors + 1];

        // Handle simple cases.
        if (floors == 0 || eggs == 0) {
            return 0;
        }

        if (floors == 1) {
            return 1;
        }

        if (eggs == 1) {
            return floors;
        }

        // For no floors we don't need any eggs to solve minimum number of eggs
        // drops required, for only one floor we only ever need one egg to test
        // whether the egg breaks.
        for (i = 0; i <= eggs; i++) {
            minNumOfEggDrops[i][0] = 0;
            minNumOfEggDrops[i][1] = 1;
        }

        // With no eggs not a single egg drop can be attempted in the first
        // place, with one egg we need to make the same number of attempts
        // as there are... floors to see where the egg breaks.
        for (j = 0; j <= floors; j++) {
            minNumOfEggDrops[0][j] = 0;
            minNumOfEggDrops[1][j] = j;
        }

        // Do something with all the egg sub problems.
        for (i = 2; i <= eggs; i++) {
            // Do something with all the floor sub problems.
            for (j = 2; j <= floors; j++) {
                // Infinity can be just the max value of the data type of the
                // answer.
                minNumOfEggDrops[i][j] = Integer.MAX_VALUE;
                // Check all the floors below the current floor that we are on.
                for (k = 1; k <= j; k++) {
                    drop = 1 + Math.max(
                        minNumOfEggDrops[i - 1][k - 1],
                        minNumOfEggDrops[i][j - k]
                    );

                    // Do we keep the array result, or is the most recent drop
                    // attempt better?
                    if (drop < minNumOfEggDrops[i][j])
                        minNumOfEggDrops[i][j] = drop;
                }
            }
        }

        return minNumOfEggDrops[eggs][floors];
    }
}
