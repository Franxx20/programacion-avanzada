public class SubsetSum {
    // https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    //  non dp solution
    static boolean isSubsetSum(int set[], int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum) return isSubsetSum(set, n - 1, sum);

        // Else, check if sum can be obtained
        // by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    // As seen in the previous recursion method, each state of the solution can be
    // uniquely identified using two variables – the index and the remaining sum.
    // So create a 2D array to store the value of each state to avoid
    // recalculation of the same state.
    //
    static int sumsetSumMem(int set[], int n, int sum) {
        int tab[][] = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }

        if (sum == 0) return 1;

        if (n <= 0) return 0;

        if (tab[n - 1][sum] != -1) return tab[n - 1][sum];

        if (tab[n - 1][sum] != -1) {
            return tab[n - 1][sum];
        }

        if (set[n - 1] > sum)
            return tab[n - 1][sum] = sumsetSumMem(set, n - 1, sum);

        else {
// Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            if (sumsetSumMem(set, n - 1, sum) != 0
                    || sumsetSumMem(set, n - 1, sum - set[n - 1])
                    != 0) {
                return tab[n - 1][sum] = 1;
            } else
                return tab[n - 1][sum] = 0;
        }
    }
    // Returns true if there is a subset of
    // set[] with sum equal to given sum
    static boolean isSubsetSumTab(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j]
                            = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }

        return subset[sum][n];
    }


    public static void main(String[] args) {

        int set[] = {3, 34, 4, 12, 5, 2};

        int sum = 9;
        int n = set.length;
        if (isSubsetSumTab(set, n, sum) == true) {
            System.out.println("Found a subset" + " with given sum");
        } else {
            System.out.println("No subset with" + " geiven sum");
        }
    }
}
