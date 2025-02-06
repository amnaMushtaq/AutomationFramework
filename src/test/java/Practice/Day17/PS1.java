package Practice.Day17;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS1 {

    public void runme(){
        System.out.println("here I'm");
    }
    @BeforeMethod
    public void runBefore(){
        System.out.println("i will execute first");
    }
    @AfterMethod
    public void runAfter(){
        System.out.println("i will execute last");
    }
}
