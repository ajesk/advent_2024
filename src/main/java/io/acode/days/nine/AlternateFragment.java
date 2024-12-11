package io.acode.days.nine;

import java.util.List;
import java.util.function.Function;

public class AlternateFragment implements Function<List<Integer>, List<Integer>> {

    @Override
    public List<Integer> apply(List<Integer> blocks) {
        int right = blocks.size() - 1;
        int currentFileId = blocks.get(right);
        int fileSize = 0;

        while (right >= 0) {
            int currentBlock = blocks.get(right);

            if (currentBlock == currentFileId) {
                fileSize++;
            } else {
                if (currentFileId != -1) {
                    // find free space and swap
                    int freeIndex = findIndexWithFreeSpace(blocks, fileSize, right + 1);
                    if (freeIndex != -1) {
                        swapAtIndices(right + 1, freeIndex, fileSize, blocks);
                    }
                }
                currentFileId = currentBlock;
                fileSize = 1;
            }

            right--;
        }

        return blocks;
    }

    private int findIndexWithFreeSpace(List<Integer> blocks, int size, int limit) {
        int count = 0;
        for (int index = 0; index < limit; index++) {
            int currentId = blocks.get(index);
            if (currentId == -1) {
                count++;
                if (count == size) {
                    return index - size + 1;
                }
            } else {
                count = 0;
            }
        }
        return -1;
    }

    private void swapAtIndices(int fileIndex, int freeIndex, int size, List<Integer> blocks) {
        int fileBlock = blocks.get(fileIndex);
        int freeBlock = blocks.get(freeIndex);
        for (int i = 0; i < size; i++) {
            blocks.set(fileIndex + i, freeBlock);
            blocks.set(freeIndex + i, fileBlock);
        }
    }
}
