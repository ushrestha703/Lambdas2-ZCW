import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class SocialNetworkTest {
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
    public void addPersonTest(){
        String expected1 = "Jack";
        String expected2 = "Jill";
        String expected3 = "Hill";
        Assert.assertEquals(expected1, p1.getName());
        Assert.assertEquals(expected2, p2.getName());
        Assert.assertEquals(expected3, p3.getName());
    }
}
