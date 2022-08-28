package Btree;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class ValuesProvider {
    public static Stream<Arguments> insertIntegerElementsCheckingSize() {
        return Stream.of(
            Arguments.of(new Integer[] {89, 60, 23, 43, 54, 65}, 3,  6),
            Arguments.of(new Integer[] {89, 89, 89, 89, 89}, 3, 1), 
            Arguments.of(new Integer[] {21, 32, null, null, 12, 3}, 3, 4),
            Arguments.of(new Integer[] {12, 54, 645, 43, 23}, 4, 5),
            Arguments.of(new Integer[] {12, 12, 12, 12, 12}, 4, 1),
            Arguments.of(new Integer[] {null, 1, 23, 54, 23}, 4, 4),
            Arguments.of(new Integer[] {12, 115, 65, 67, 43}, 5, 5), 
            Arguments.of(new Integer[] {12, 12, 12, 12, 12}, 5, 1), 
            Arguments.of(new Integer[] {null, 12, 4, null, 54}, 5, 3)
        ); 
    }

    public static Stream<Arguments> insertIntegerElementsCheckingHeadValues() {
        return Stream.of(
            Arguments.of(new Integer[] {12, 45, 65, 23, 43}, 3, new Integer[] {23, 45}), 
            Arguments.of(new Integer[] {54, 23, 23, 1, 3}, 3, new Integer[] {23}), 
            Arguments.of(new Integer[] {23, 21, 32, 4, null, 12}, 3, new Integer[] {12, 23}),
            Arguments.of(new Integer[] {12, 45, 65, 23, 43}, 4, new Integer[] {45}),
            Arguments.of(new Integer[] {54, 23, 23, 1, 3}, 4, new Integer[] {23}),
            Arguments.of(new Integer[] {23, 21, 32, 4, null, 12}, 4, new Integer[] {23}),
            Arguments.of(new Integer[] {12, 45, 65, 23, 43}, 5, new Integer[] {43}), 
            Arguments.of(new Integer[] {54, 23, 23, 1, 3}, 5, new Integer[] {21}), 
            Arguments.of(new Integer[] {23, 21, 32, 4, null, 12}, 5, new Integer[] {21})
        );
    }

    public static Stream<Arguments> findExistingIntegerElements() {
        return Stream.of(
            Arguments.of(new Integer[] {12, 43, 54, 23, 1, 2}, 3, 12),
            Arguments.of(new Integer[] {12, 43, 32, 43, 2}, 3, 2),
            Arguments.of(new Integer[] {54, 23, 1, 5, 233}, 3, 1),
            Arguments.of(new Integer[] {43, 12, 12, 43, 4}, 4, 43), 
            Arguments.of(new Integer[] {12, 43, 23, 32, 12, 1}, 4, 1), 
            Arguments.of(new Integer[] {32, 12, 5, 23, 1}, 4, 5), 
            Arguments.of(new Integer[] {56, 23, 12, 54, 2,}, 5, 56),
            Arguments.of(new Integer[] {45, 65, 43, 2, 4}, 5, 4),
            Arguments.of(new Integer[] {43, 2, 54, 2, 43, 5}, 5, 54)
        ); 
    }

    public static Stream<Arguments> findNonExistingIntegerElements() {
        return Stream.of(
            Arguments.of(new Integer[] {12, 43, 54, 23, 1, 2}, 3, 10),
            Arguments.of(new Integer[] {12, 43, 32, 43, 2}, 3, 1),
            Arguments.of(new Integer[] {54, 23, 1, 5, 233}, 3, 200),
            Arguments.of(new Integer[] {43, 12, 12, 43, 4}, 4, 30), 
            Arguments.of(new Integer[] {12, 43, 23, 32, 12, 1}, 4, 10), 
            Arguments.of(new Integer[] {32, 12, 5, 23, 1}, 4, 4), 
            Arguments.of(new Integer[] {56, 23, 12, 54, 2}, 5, 4),
            Arguments.of(new Integer[] {45, 65, 43, 2, 4}, 5, 3),
            Arguments.of(new Integer[] {43, 2, 54, 2, 43, 5}, 5, 1)
        ); 
    }

    public static Stream<Arguments> deleteIntegerValuesCheckHead() {
        return Stream.of(
            Arguments.of(new Integer[] {53, 54, 2, 1, 45, 4}, 3, 53,  new Integer[] {2, 45}),
            Arguments.of(new Integer[] {54, 2, 345, 23, 53, 1}, 3, 1, new Integer[] {23, 54}),
            Arguments.of(new Integer[] {2433, 1, 3, 54, 2}, 3, 3, new Integer[] {54}),
            Arguments.of(new Integer[] {23, 44, 54, 2, 23, 1}, 4, 23, new Integer[] {44}), 
            Arguments.of(new Integer[] {54, 23, 65, 76, 54, 43}, 4, 54, new Integer[] {65}), 
            Arguments.of(new Integer[] {65, 23, 54, 23, 4}, 4, 54, new Integer[] {23}), 
            Arguments.of(new Integer[] {55, 43, 23, 54, 32 , 5}, 5, 55, new Integer[] {32}),
            Arguments.of(new Integer[] {67, 54, 32, 2, 54, 2}, 5, 2, new Integer[] {32, 54, 67}),
            Arguments.of(new Integer[] {43, 65, 43, 23,  5, 4}, 5, 43, new Integer[] {4, 5, 23, 65})
        ); 
    }
}
