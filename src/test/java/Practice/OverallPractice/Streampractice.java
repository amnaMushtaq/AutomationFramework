package Practice.OverallPractice;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streampractice {
    @Test
    public void streaming(){
        String [] arr={"Alia", "Ani","Faiza","Urhan","Iqra","Aina"};
        List<String > listArray=Arrays.asList(arr);
        long count=listArray.stream().filter(s->s.startsWith("A")).count();
        System.out.println("name starting with 'A' are "+ count);
        Stream.of("Clark","George","Clock","Cary","Robert").filter(s->s.startsWith("C")).forEach(s-> System.out.println(s));

    }
}
