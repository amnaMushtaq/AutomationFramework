package Practice.Day17;

import org.testng.annotations.Test;

public class PS extends PS1 {
    @Test
    public void doThis(){
        int inc=3;
        PS2 ps=new PS2(inc); //Parameterized constructor
        System.out.println(ps.increment());
        System.out.println(ps.decrment());
        PS3 ps3=new PS3(inc);
        System.out.println(ps3.multiple3());
        runme();

    }
}
