package io.acode.days.three;

import java.util.function.ToIntFunction;

public class ExecuteMul implements ToIntFunction<String> {

    @Override
    public int applyAsInt(String s) {
        String[] nums = s.replace("mul(", "")
                .replace(")", "")
                .split(",");
        return Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
    }

}
