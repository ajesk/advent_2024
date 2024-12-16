package io.acode.days.fourteen;

import io.acode.util.FileReader;
import io.acode.util.FileWriter;

import java.util.Arrays;
import java.util.List;


public class RestroomRedoubt {
    private final int height;
    private final int width;
    private final List<Robot> robotList;

    public RestroomRedoubt(String file, int height, int width) {
        this.height = height;
        this.width = width;

        robotList = FileReader.readFile(file)
                .map(x -> Arrays.stream(x.replace("p=", "")
                        .replace(" v=", ",")
                        .split(","))
                        .map(Integer::parseInt)
                        .toList())
                .map(x -> new Robot(x, height, width))
                .toList();
    }

    public int calculateQuadrants(int iterations) {
        RobotGrid robotGrid = new RobotGrid(height, width);

        robotList.forEach(robot -> robotGrid.record(robot.calculateMove(iterations)));

        return robotGrid.calculateQuadrants();
    }

    public void findTree(int iterations) {
        for (int i = 0; i < iterations; i++) {
            RobotGrid robotGrid = new RobotGrid(height, width, i);

            for (Robot robot : robotList) {
                robotGrid.record(robot.calculateMove(i));
            }
            FileWriter.write(robotGrid.print(), "findTree.txt");
        }
    }
}
