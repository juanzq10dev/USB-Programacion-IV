package Btree;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import person.Person;

public class PersonProvider {
    public static Stream<Arguments> insertElementsCheckingSize() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2020-05-06", "12345678"),
                    new Person("Juan", "2012-07-01", "123231"),
                    new Person("Juan", "2012-07-01", "65432")
                }, 3, 3
            ),
            Arguments.of(
                new Person[] {
                    new Person("Pedro", "2012-07-01", "123231"),
                    new Person("Pedro", "2012-07-01", "123231"),
                    new Person("Pedro", "2012-07-01", "123231"),
                }, 4, 1
            ),
            Arguments.of(
                new Person[] {
                    new Person("Pedro", "2012-07-01", "123231"),
                    new Person("Maria", "2010-07-10", "12343"),
                    new Person("Pedro", "2012-07-01", "123231"),
                    new Person("Roberto", "2011-04-11", "12332"),
                }, 5, 3
            )
        );
    }

    public static Stream<Arguments> insertElementsCheckingHeadValues() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2020-05-12", "12345678"),
                    new Person("Juan", "2020-05-05", "12345678"),
                    new Person("Juan", "2020-05-13", "12345678"),
                    new Person("Juan", "2020-05-24", "12345678"),
                    new Person("Juan", "2020-05-30", "12345678")
                }, 3, 
                new Person[] {
                    new Person("Juan", "2020-05-12", "12345678"),
                    new Person("Juan", "2020-05-24", "12345678")
                }
            ),
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2020-05-10", "12345678"),
                    new Person("Juan", "2021-05-10", "12345678"),
                    new Person("Juan", "2019-05-10", "12345678"),
                    new Person("Juan", "2012-05-10", "12345678"),
                    new Person("Juan", "2023-05-10", "12345678")
                }, 4, 
                new Person[] {
                    new Person("Juan", "2020-05-10", "12345678")
                }
            ),
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2020-05-10", "12345678"),
                    new Person("Juan", "2020-05-10", "12345679"),
                    new Person("Juan", "2020-05-10", "12345680"),
                    new Person("Juan", "2020-05-10", "12345682"),
                    new Person("Juan", "2020-05-10", "12345612")
                }, 5, 
                new Person[] {
                    new Person("Juan", "2020-05-10", "12345679")
                }
            ) 
        );
    }

    public static Stream<Arguments> findExistingElements() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2021-05-10", "12345678"),
                    new Person("Pedro", "2012-12-12", "123439"),
                    new Person("John", "2018-11-05", "123431")
                }, 3, new Person("Juan", "2021-05-10", "12345678")
            ),
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2019-04-12", "123432"),
                    new Person("Pedri", "2019-04-12", "123433"), 
                    new Person("Mario", "2019-04-12", "123433")
                }, 4, new Person("Pedri", "2019-04-12", "123433")
            ),
            Arguments.of(
                new Person[] {
                    new Person("Pedro", "2012-07-12", "123432"), 
                    new Person("Perez", "2022-04-12", "1232"), 
                    new Person("Maria", "2012-04-12", "43212")
                }, 5, new Person("Perez", "2022-04-12", "1232")
            )
        );
    }

    public static Stream<Arguments> findNonExistingElements() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2021-05-10", "12345678"),
                    new Person("Pedro", "2012-12-12", "123439"),
                    new Person("John", "2018-11-05", "123431")
                }, 3, new Person("Maria", "2012-12-12", "123439")
            ),
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2019-04-12", "123432"),
                    new Person("Pedri", "2019-04-12", "123433"), 
                    new Person("Mario", "2019-04-12", "123433")
                }, 4, new Person("Memo", "2019-04-12", "123436")
            ),
            Arguments.of(
                new Person[] {
                    new Person("Pedro", "2012-07-12", "123432"), 
                    new Person("Perez", "2022-04-12", "1232"), 
                    new Person("Maria", "2012-04-12", "43212")
                }, 5, new Person("Roma", "2011-04-12", "1232")
            )
        );
    }

    public static Stream<Arguments> deleteValuesCheckHead() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2012-04-10", "123"),
                    new Person("Juan", "2012-04-11", "123"),
                    new Person("Juan", "2012-04-09", "123"),
                    new Person("Juan", "2012-04-12", "123"),
                    new Person("Juan", "2012-04-03", "123"),
                }, 3, new Person("Juan", "2012-04-09", "123"),
                new Person[] {
                    new Person("Juan", "2012-04-10", "123"),
                }
            ),
            Arguments.of(
                new Person[] {
                    new Person("Marco", "2012-04-11", "120412"),
                    new Person("Maria", "2012-04-11", "120411"),
                    new Person("Mario", "2012-04-11", "120410"),
                    new Person("Marisol", "2012-04-11", "120413"),
                    new Person("Maricruz", "2012-04-11", "120414"),
                }, 4, new Person("Mario", "2012-04-11", "120410"), 
                new Person[] {
                    new Person("Marco", "2012-04-11", "120412")
                }
            ), 
            Arguments.of(
                new Person[] {
                    new Person("Juan", "2012-04-11", "12453"), 
                    new Person("Fer", "2015-04-11", "12453"), 
                    new Person("Pablo", "2011-04-11", "12453"), 
                    new Person("Mario", "2013-04-11", "12453"), 
                    new Person("Jonas", "2010-04-11", "12453"), 
                }, 5, new Person("Pablo", "2011-04-11", "12453"),
                new Person[] {
                    new Person("Jonas", "2010-04-11", "12453"), 
                    new Person("Juan", "2012-04-11", "12453"),
                    new Person("Mario", "2013-04-11", "12453"),
                    new Person("Fer", "2015-04-11", "12453")
                }
            )
        );
    }

    public static Stream<Arguments> deleteNullElements() {
        return Stream.of(
            Arguments.of(
                new Person[] {
                    new Person("Fer", "2015-04-11", "12453"),
                    new Person("Juan", "2012-04-09", "123"),
                    new Person("Mario", "2019-04-12", "123433")
                }, 3
            ),
            Arguments.of(
                new Person[] {
                    new Person("Perez", "2022-04-12", "1232"),
                    new Person("Pedro", "2012-12-12", "123439"), 
                    new Person("Pedro", "2012-07-12", "123432")
                }, 4
            ),
            Arguments.of(
                new Person[] {
                    new Person("Pedri", "2019-04-12", "123433"), 
                    new Person("Juan", "2021-05-10", "12345678"),
                    new Person("Maria", "2012-04-11", "120411"),
                }, 5
            )
        );
    }


}