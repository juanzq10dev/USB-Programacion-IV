package Binomial.Heap;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ValuesProvider {

     public static Stream<Arguments> checkMaxValueArguments() {
        return Stream.of(
                Arguments.of(new Integer[] {60, 55, 34, 50, 3}, 60),
                Arguments.of(new Integer[] {1000, 300, 500, 1100, 400, 500, 568, 60}, 1100),
                Arguments.of(new Integer[] {77, 50, 30, 66, 54, 6, 78, null}, 78),
                Arguments.of(new Integer[] {null, null, null, null}, null),
                Arguments.of(new Integer[] {}, null)
        );
    }

    public static Stream<Arguments> checkTressNumbersArguments() {
         return  Stream.of(
                 Arguments.of(new Integer[] {60, 55, 34, 50, 3}, 2),
                 Arguments.of(new Integer[] {1000, 300, 500, 1100, 400, 500, 568, 60}, 1),
                 Arguments.of(new Integer[] {77, 50, 30, 66, 54, 6, 78}, 3),
                 Arguments.of(new Integer[] {}, 0),
                 Arguments.of(new Integer[] {null, null, null, null}, 0)
         );
    }

    public static Stream<Arguments> checkTressRanksArguments() {
        return  Stream.of(
                Arguments.of(new Integer[] {60, 55, 34, 50, 3}, new Integer[] {0, 2}),
                Arguments.of(new Integer[] {1000, 300, 500, 1100, 400, 500, 568, 60}, new Integer[] {3}),
                Arguments.of(new Integer[] {77, 50, 30, 66, 54, 6, 78}, new Integer[] {0, 1, 2}),
                Arguments.of(new Integer[] {}, new Integer[] {}),
                Arguments.of(new Integer[] {60, 20, 230, 12, 23, null}, new Integer[] {0, 2}),
                Arguments.of(new Integer[] {null, null, null, null}, new Integer[] {}),
                Arguments.of(new Integer[] {null, 102, 32, 43, 54, 54, 45}, new Integer[] {1, 2})
        );
    }

    public static Stream<Arguments> checkMaxAfterDelete() {
        return  Stream.of(
                Arguments.of(new Integer[] {60, 55, 34, 50, 3}, 55),
                Arguments.of(new Integer[] {1000, 300, 500, 1100, 400, 500, 568, 60}, 1000),
                Arguments.of(new Integer[] {77, 50, 30, 66, 54, 6, 78}, 77)
        );
    }

    public static Stream<Arguments> checkTreesNumberAfterDelete() {
        return  Stream.of(
                Arguments.of(new Integer[] {4532, 54, 74, 870, 5}, 1),
                Arguments.of(new Integer[] {54, 545, 50, 10, 450, 5234, 55, 60}, 3),
                Arguments.of(new Integer[] {543, 87, 98, 86, 6, 4, 54}, 2),
                Arguments.of(new Integer[] {0}, 0)
        );
    }

    public static Stream<Arguments> checkTreesRanksAfterDelete() {
        return  Stream.of(
                Arguments.of(new Integer[] {10, 550, 334, 65, 12}, new Integer[] {2}),
                Arguments.of(new Integer[] {234, 43, 5432, 2, 4, 543, 1, 2}, new Integer[] {0, 1, 2}),
                Arguments.of(new Integer[] {2, 5, 54, 52, 576, 24, 43}, new Integer[] {1, 2}),
                Arguments.of(new Integer[] {1}, new Integer[] {})
        );
    }

    public static Stream<Arguments> checkMaxInsertAfterDelete() {
         return Stream.of(
                 Arguments.of(new Integer[] {10, 550, 334, 65, 12}, 551, 551),
                 Arguments.of(new Integer[] {234, 453, 65, 764, 64}, 43, 453),
                 Arguments.of(new Integer[] {1234, 543, 543, 654, 32, 453}, 1200, 1200)
         );
    }

    public static Stream<Arguments> checkInsertionWithSameElements() {
        return Stream.of(
                Arguments.of(new Integer[] {60, 60, 60, 60, 60, 60}, new Integer[] {1, 2}),
                Arguments.of(new Integer[] {1000, 300, 500, 500, 400, 500, 568, 60, 90}, new Integer[] {0, 3}),
                Arguments.of(new Integer[] {77, 50, 30, 66, 54, 66, 78, 9, 89, 19}, new Integer[] {1, 3})
        );
    }

    public static Stream<Arguments> checkMaxDeletingAllElements() {
        return Stream.of(
                Arguments.of((Object) new Integer[] {60, 60, 50, 40}),
                Arguments.of((Object) new Integer[] {null, null, null, null}),
                Arguments.of((Object) new Integer[] {})
        );
    }
}
