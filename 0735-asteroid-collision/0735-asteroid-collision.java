class Solution {
    // public int[] asteroidCollision(int[] asteroids) {
    // Stack<Integer> stk = new Stack<>();
    // for (int i = 0; i < asteroids.length; i++) {
    // if (asteroids[i] > 0)
    // stk.push(asteroids[i]);
    // else {
    // while (!stk.isEmpty() && stk.peek() > 0 && (-1) * asteroids[i] > stk.peek())
    // stk.pop();
    // if (!stk.isEmpty() && (-1) * asteroids[i] == stk.peek()) {
    // stk.pop();
    // break;
    // } else if (stk.isEmpty() || stk.peek() < 0)
    // stk.push(asteroids[i]);
    // }
    // }
    // int[] result = new int[stk.size()];
    // for (int i = stk.size() - 1; i >= 0; --i) {
    // result[i] = stk.pop();
    // }
    // return result;
    // }

    // void reverse(int[] arr) {
    // int start = 0;
    // int end = arr.length - 1;
    // while (start < end) {
    // int temp = arr[start];
    // arr[start] = arr[end];
    // arr[end] = temp;

    // start++;
    // end--;
    // }
    // }

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0)
                list.add(asteroids[i]);
            else {
                while (!list.isEmpty() && ((-1) * asteroids[i] > list.get(list.size() - 1))
                        && list.get(list.size() - 1) > 0)
                    list.remove(list.size() - 1);
                if (list.isEmpty() || list.get(list.size() - 1) < 0)
                    list.add(asteroids[i]);
                if ((-1) * asteroids[i] == list.get(list.size() - 1))
                    list.remove(list.size() - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);

        return result;
    }
}