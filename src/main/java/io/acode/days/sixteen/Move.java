package io.acode.days.sixteen;

import io.acode.util.Pair;

import java.util.Set;

public record Move(Pair coordinates, int direction, int tally, Set<Pair> previousMoves) {

}
