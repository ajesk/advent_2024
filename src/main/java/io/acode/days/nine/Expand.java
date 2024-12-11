package io.acode.days.nine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Expand implements Function<String, List<Integer>> {

    @Override
    public List<Integer> apply(String s) {
        boolean isEmptyBlock = false;
        int number = 0;
        List<Integer> nums = new ArrayList<>();

        for (String ch : s.split("")) {
            int count = Integer.parseInt(ch);
            Integer nextVal = isEmptyBlock ? -1 : number;
            isEmptyBlock = !isEmptyBlock;
            if (nextVal != -1) number++;

            for (int i = 0; i < count; i++) {
                nums.add(nextVal);
            }
        }

        return nums;
    }
}
