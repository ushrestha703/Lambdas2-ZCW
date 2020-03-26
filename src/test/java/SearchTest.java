import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    SocialNetwork<Person> socialNetwork;
    Person p1 = new Person("Jack", LocalDate.of(1980, Month.JANUARY,1), Person.Sex.MALE,"jack@email.com");
    Person p2 = new Person("Jill",LocalDate.of(1990, Month.APRIL,1), Person.Sex.FEMALE,"jill@email.com");
    Person p3 = new Person("Hill",LocalDate.of(2000, Month.NOVEMBER,1), Person.Sex.FEMALE,"hill@email.com");

    @Before
    public void setUp(){
        socialNetwork = new SocialNetwork<>();
        socialNetwork.addPerson(p1);
        socialNetwork.addPerson(p2);
        socialNetwork.addPerson(p3);
    }

    @Test
    public void checkBirthDate(){
        int expected = 40;
        int actual = socialNetwork.roster.get(0).getAge();
        assertEquals(expected,actual);
    }

    @Test
    public void personsOlderThanTest(){
        Search.printPersonsOlderThan(socialNetwork,20);
    }

    @Test
    public void printWithinRangeTest(){
        Search.printPersonsWithinAgeRange(socialNetwork,20,40);
    }

    @Test
    public void printPersonsTestLocal(){
        CheckPerson tester = new Person(){};
        Search.printPersons(socialNetwork, tester);
    }

    @Test
    public void printPersonsTestAnonymous(){
        CheckPerson tester = new Person(){
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE;
            }
        };
        Search.printPersons(socialNetwork, tester);
    }

    @Test
    public void printPersonsTestLambda(){
        CheckPerson tester = p -> p.getAge() > 30;
        Search.printPersons(socialNetwork, tester);
    }

}