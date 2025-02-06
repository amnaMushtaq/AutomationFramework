package Practice.Day14;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streampractice {
    //@Test
    public void streamFilter() {

        ArrayList<String> names = new ArrayList<String>();
        names.add("Adan");
        names.add("urhan");
        names.add("Ayesha");
        names.add("younas");
        names.add("Ali");
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println("Names that starts with A are: " + count);
        long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        long d = Stream.of("Clark", "Carn", "dow", "robert").filter(t -> t.startsWith("C")).count();
        System.out.println(d);
        // names.stream().filter(t->t.length()>4).forEach(t->System.out.println(t));
        names.stream().filter(t -> t.length() > 5).limit(1).forEach(t -> System.out.println(t));
    }
    //@Test
    public void streamMap(){

        ArrayList<String> names = new ArrayList<String>();
        names.add("Adan");
        names.add("urhan");
        names.add("Ayesha");
        names.add("younas");
        names.add("Ali");

       // Stream.of("Robert","Aleza","Ana","Alex","Cook").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        List<String> names1=Arrays.asList("Azan","Abeera","Ali","ozaan","nimra","Alia");
       // names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        Stream<String> mergedNames=Stream.concat(names.stream(),names1.stream());
        //mergedNames.sorted().forEach(s-> System.out.println(s));
        boolean flag=mergedNames.anyMatch(s->s.equalsIgnoreCase("ali"));
        System.out.println(flag);
        Assert.assertTrue(true);

    }
    @Test
    public void collectStrem(){
        List<String> ls=Stream.of("Robert","Aleza","Ana","Alex","Cook").filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase()).collect(Collectors.toList());
        //System.out.println(ls);
        System.out.println(ls.get(0));
        List<Integer> values = Arrays.asList(3, 5, 7, 3, 7, 9, 2, 3, 7);
        //values.stream().distinct().sorted().forEach(s-> System.out.println(s));
        List<Integer> sortValues=values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println( sortValues.get(2)); // sort the array and get me the 3rd index

    }
}


