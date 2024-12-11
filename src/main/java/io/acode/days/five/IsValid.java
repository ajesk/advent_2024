package io.acode.days.five;

import java.util.function.BiPredicate;

public class IsValid implements BiPredicate<String[], PageMap> {

    @Override
    public boolean test(String[] pageGroup, PageMap pageMap) {
        for (int i = 0; i < pageGroup.length - 1; i++) {
            for (int j = i + 1; j < pageGroup.length; j++) {
                if (pageMap.validOrder(pageGroup[j], pageGroup[i])) {
                    return false;
                }

            }
        }
        return true;
    }
}
