class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] assigned = new int[groups.length];
        Arrays.fill(assigned, -1);
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int j = 0; j < elements.length; j++) {
            mpp.putIfAbsent(elements[j], j);
        }

        for (int i = 0; i < groups.length; i++) {
            assigned[i] = findSmallestIndex(groups[i], mpp);
        }

        return assigned;
    }

    int findSmallestIndex(int n, Map<Integer, Integer> mpp) {
        int minVal = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i ++) {
            if(n % i == 0) {
                if(mpp.containsKey(i))
                    minVal = Math.min(minVal, mpp.get(i));
                if(mpp.containsKey(n / i))
                    minVal = Math.min(minVal, mpp.get(n / i));
            }      
        }
        return( minVal == Integer.MAX_VALUE) ? -1 : minVal;
    }

}
