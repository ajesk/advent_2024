package io.acode.days.nine;

import java.util.List;
import java.util.function.Function;

public class Fragment implements Function<List<Integer>, List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> integers) {
        int left = 0;
        int right = integers.size() - 1;

        while (left < right) {
            Integer leftInt = integers.get(left);
            Integer rightInt = integers.get(right);
            if (leftInt == -1) {
                if (rightInt != -1) {
                    integers.set(left, rightInt);
                    integers.set(right, leftInt);
                    left++;
                }
                right--;
            } else {
                left++;
            }
        }

        return integers;
    }
}
