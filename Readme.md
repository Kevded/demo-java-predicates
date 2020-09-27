# Example Java Predicates and Functions
[![Build](https://github.com/kevded/demo-java-predicates/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/kevded/demo-java-predicates/workflows/Java%20CI%20with%20Maven/badge.svg)

## Predicates :
- [AddressPredicates](src/main/java/com/example/demopredicates/predicates/AddressPredicates.java)
- [PersonPredicates](src/main/java/com/example/demopredicates/predicates/PersonPredicates.java)
- [StringPredicates](src/main/java/com/example/demopredicates/predicates/StringPredicates.java)

```java
public class AddressPredicates {

    public static Predicate<Address> hasStreetCode(@NonNull String streetCode) {
        return address -> nonNullAddress().and(equalsIgnoreCaseStreetCode(streetCode)).test(address);
    }


    public static Predicate<Address> hasStreet(@NonNull String street) {
        return address -> nonNullAddress().and(equalsIgnoreCaseStreet(street)).test(address);
    }


    public static Predicate<Address> equalsIgnoreCaseStreet(@NonNull String street) {
        return address -> street.equalsIgnoreCase(address.getStreet());
    }

    public static Predicate<Address> equalsIgnoreCaseStreetCode(@NonNull String streetCode) {
        return address -> streetCode.equalsIgnoreCase(address.getStreetCode());
    }

    public static Predicate<Address> nonNullAddress() {
        return Objects::nonNull;
    }
}
```

```java
public class PersonPredicates {

    public static Predicate<Person> hasNicknameAndHasNicknamePrefixAndAsStreetAddress(@NonNull String nickname,
                                                                                      @NonNull String nicknamePrefix,
                                                                                      @NonNull String streetAddress) {
        
        return person -> hasNonNullPersonAndHasNickname(nickname)
                .and(hasNonNullPersonAndHasNicknameStartWith(nicknamePrefix))
                .and(hasNonNullPersonAndHasStreetAddress(streetAddress))
                .test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasNicknameStartWith(@NonNull String nicknamePrefix) {
        return person -> nonNullPerson().and(hasNicknameStartWith(nicknamePrefix)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasNickname(@NonNull String nickname) {
        return person -> nonNullPerson().and(equalsIgnoreCaseNickname(nickname)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasStreetAddress(@NonNull String streetAddress) {
        return person -> nonNullPerson().and(hasStreetAddress(streetAddress)).test(person);
    }

    public static Predicate<Person> hasNonNullPersonAndHasStreetCodeAddress(@NonNull String streetCodeAddress) {
        return person -> nonNullPerson().and(hasStreetCodeAddress(streetCodeAddress)).test(person);
    }

    public static Predicate<Person> equalsIgnoreCaseNickname(@NonNull String nickname) {
        return person -> person.getNicknames().stream().anyMatch(equalsIgnoreCaseString(nickname));
    }

    public static Predicate<Person> hasNicknameStartWith(@NonNull String nicknamePrefix) {
        return person -> person.getNicknames().stream().anyMatch(startWithString(nicknamePrefix));
    }


    public static Predicate<Person> hasStreetAddress(@NonNull String streetAddress) {
        return person -> AddressPredicates.hasStreet(streetAddress).test(person.getAddress());
    }

    public static Predicate<Person> hasStreetCodeAddress(@NonNull String streetCodeAddress) {
        return person -> AddressPredicates.hasStreetCode(streetCodeAddress).test(person.getAddress());
    }

    public static Predicate<Person> nonNullPerson() {
        return Objects::nonNull;
    }
}
```

```java
public class StringPredicates {

    public static Predicate<String> equalsIgnoreCaseString(@NonNull String value) {
        return value::equalsIgnoreCase;
    }

    public static Predicate<String> startWithString(@NonNull String value) {
        return str -> str.startsWith(value);
    }
}
```


## DTO : 

- [Address](src/main/java/com/example/demopredicates/dto/Address.java)
- [Person](src/main/java/com/example/demopredicates/dto/Person.java)

```java
public class Address {
    private String streetCode;
    private String street;
}
```

```java
public class Person {
    private String firstname;
    private String lastname;
    private Address address;
    private List<String> nicknames;
}
```


## Unit Test :

- [AddressPredicatesUnitTest](src/test/java/com/example/demopredicates/predicates/AddressPredicatesUnitTest.java)
- [PersonPredicatesUnitTest](src/test/java/com/example/demopredicates/predicates/PersonPredicatesUnitTest.java)
- [StringPredicatesUnitTest](src/test/java/com/example/demopredicates/predicates/StringPredicatesUnitTest.java)

```java
public class AddressPredicatesUnitTest {

    @Test
    public void AddressPredicates_hasStreet_returnTrue(){
        // GIVEN
        var address = Address.builder().street("Ferdinand").build();
        // WHEN
        var result = AddressPredicates.hasStreet("Ferdinand").test(address);
        // THEN
        assertTrue(result);
    }
    @Test
    public void AddressPredicates_hasStreetCode_returnTrue(){
        // GIVEN
        var address = Address.builder().streetCode("22").build();
        // WHEN
        var result = AddressPredicates.hasStreetCode("22").test(address);
        // THEN
        assertTrue(result);
    }
}
```

```java
public class PersonPredicatesUnitTest {

    @Test
    public void PersonPredicates_hasNicknameAndHasNicknamePrefixAndAsStreetAddress_returnTrue() {
        // GIVEN
        var nicknames = List.of("el patron", "pablo");
        var address = Address.builder().street("forest").build();
        var person = Person.builder().nicknames(nicknames).address(address).build();
        // WHEN
        var result = PersonPredicates.hasNicknameAndHasNicknamePrefixAndAsStreetAddress("pablo", "el", "forest").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasNicknameStartWith_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo1")).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasNicknameStartWith("el").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_equalsIgnoreCaseNickname_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo1")).build();
        // WHEN
        var result = PersonPredicates.equalsIgnoreCaseNickname("pablo1").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasNickname_returnTrue() {
        // GIVEN
        var person = Person.builder().nicknames(List.of("el patron", "pablo")).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasNickname("pablo").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasStreetCodeAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().streetCode("222").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasStreetCodeAddress("222").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasNonNullPersonAndHasStreetAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().street("Ferdinand2").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasNonNullPersonAndHasStreetAddress("Ferdinand2").test(person);
        // THEN
        assertTrue(result);
    }


    @Test
    public void PersonPredicates_hasStreetAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().street("Ferdinand").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasStreetAddress("Ferdinand").test(person);
        // THEN
        assertTrue(result);
    }

    @Test
    public void PersonPredicates_hasStreetCodeAddress_returnTrue() {
        // GIVEN
        var address = Address.builder().streetCode("45").build();
        var person = Person.builder().address(address).build();
        // WHEN
        var result = PersonPredicates.hasStreetCodeAddress("45").test(person);
        // THEN
        assertTrue(result);
    }
}
```

# Article

- [https://gitbook.deddy.me/exemple-java-predicates](https://gitbook.deddy.me/exemple-java-predicates)