package Btree;

import java.util.LinkedList;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class IntegerProvider {
    public static Stream<Arguments> addElementsCheckHead() {
        return Stream.of(
            Arguments.of(new Integer[] {7, 5, 2, 1, 4}, 3, new Integer[] {2, 5}),
            Arguments.of(new Integer[] {7, 5, 2, 2, 1, 1, 4}, 3, new Integer[] {2, 5}),
            Arguments.of(new Integer[] {7, 5, null, 2, null, 1, 4}, 3, new Integer[] {2, 5}),
            Arguments.of(new Integer[] {5, 3, 2, 1, 7, 4}, 4, new Integer[] {3, 5}), 
            Arguments.of(new Integer[] {5, 3, 3, 3, 2, 1, 2, 7, 4, 4}, 4, new Integer[] {3, 5}), 
            Arguments.of(new Integer[] {5, 3, null, 2, 1, null, 7, null, 4}, 4, new Integer[] {3, 5}), 
            Arguments.of(new Integer[] {7, 4, 2, 6, 12, 5, 64}, 5, new Integer[] {6}),
            Arguments.of(new Integer[] {7, 4, 2, 2, 7, 6, 6, 12, 12, 5, 5, 64}, 5, new Integer[] {6}),
            Arguments.of(new Integer[] {7, 4, null, 2, 6, null, 12, 5, null, 64}, 5, new Integer[] {6})
        );
    }

    public static Stream<Arguments> addElementsCheckSize() {
        return Stream.of(
            Arguments.of(new Integer[] {4, 5, 2, 1, 6}, 3, 5),
            Arguments.of(new Integer[] {4, 5, 5, 2, 1, 4, 2, 6}, 3, 5),
            Arguments.of(new Integer[] {4, null, null, 5, 2, null, 1, 6}, 3, 5), 
            Arguments.of(new Integer[] {7, 5, 2, 1, 6, 8}, 4, 6), 
            Arguments.of(new Integer[] {7, 5, 2, 2, 1, 7, 5, 6, 8}, 4, 6), 
            Arguments.of(new Integer[] {null, 7, 5, 2, null, 1, null, 6, 8}, 4, 6),
            Arguments.of(new Integer[] {6, 7, 3, 1, 2, 0}, 5, 6), 
            Arguments.of(new Integer[] {6, 7, 7, 3, 3, 1, 1, 2, 0}, 5, 6), 
            Arguments.of(new Integer[] {null, 6, 7, null, 3, 1, 2, 0, null}, 5, 6)
        ); 
    }

    public static Stream<Arguments> searchAllElements() {
        return Stream.of(
            Arguments.of(new Integer[] {2, 5, 6, 7, 9}, 3),
            Arguments.of(new Integer[] {4, 5, 7, 3, 2, 5, 2, 1}, 4),
            Arguments.of(new Integer[] {6, 5, 2, 4, 5, 4, 2}, 5)
        ); 
    }

    public static Stream<Arguments> searchNonExistingElements() {
        return Stream.of(
            Arguments.of(new Integer[] {4, 5, 6, 3, 2, 1}, 3, 81),
            Arguments.of(new Integer[] {4, 5, 6, 3, 2, 1}, 3, null),
            Arguments.of(new Integer[] {6, 7, 3, 2, 1, 3}, 4, 90),
            Arguments.of(new Integer[] {7, 6, 4, 3, 2, 1}, 5, 12)
        ); 
    }

    public static Stream<Arguments> removeExistingElementsCheckSize() {
        return Stream.of(
            Arguments.of(new Integer[] {5, 6, 7, 4, 3, 2, 1}, 3, 5),
            Arguments.of(new Integer[] {5, 6, 4, 3, 2, 1}, 4, 1), 
            Arguments.of(new Integer[] {6, 5, 3, 1, 12, 4}, 5, 6)
        );
    }

    public static Stream<Arguments> removeExistingElementsSearchAllElements() {
        return Stream.of(
            Arguments.of(new Integer[] {5, 4, 3, 1}, 3, 3, new Integer[] {5, 4, 1}),
            Arguments.of(new Integer[] {6, 7, 8, 9, 3, 1}, 4, 6, new Integer[] {7, 8, 9, 3, 1}),
            Arguments.of(new Integer[] {6, 7, 5, 2, 1, 4}, 5, 4, new Integer[] {6, 7, 5, 2, 1})
        );  
    }

    public static Stream<Arguments> removeExistingElementsCheckHeadValues() {
        return Stream.of(
            Arguments.of(new Integer[] {6, 7, 8, 1, 2}, 3, 6, new Integer[] {2, 7}),
            Arguments.of(new Integer[] {6, 7, 8, 1, 2}, 3, 1, new Integer[] {6, 7}),
            Arguments.of(new Integer[] {7, 8, 12, 5, 121}, 4, 12, new Integer[] {8}),
            Arguments.of(new Integer[] {9, 6, 3, 1, 5, 7, 6}, 5, 5, new Integer[] {6})
        );
    }

    public static Stream<Arguments> removeManyElementsCheckHeadValues() {
        return Stream.of(
            Arguments.of(new Integer[]{6, 7, 8, 1, 2}, 3, new Integer[]{8, 6, 2}, new Integer[]{7}),
            Arguments.of(new Integer[]{6, 7, 8, 1, 2}, 3, new Integer[]{8, 6, 7}, new Integer[]{2})
        );
    }

    public static Stream<Arguments> removeNonExistingElements() {
        return Stream.of(
            Arguments.of(new Integer[] {6, 5, 3, 1, 4, 7}, 3, 8),
            Arguments.of(new Integer[] {8, 9, 3, 2, 1}, 4, 6), 
            Arguments.of(new Integer[] {7, 9, 5, 2, 1, 4}, 5, 90),
            Arguments.of(new Integer[] {7, 8, 7, 8, 3, 2}, 3, null)
        );
    }
}
