package Practice.Day16_framework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngBasics {
    @Parameters({"URL","APIKeyUser"})
    @Test(groups = {"Smoke"})
    public void test1(String urllink,String apiUser){
        System.out.println("Hello");
        System.out.println(urllink);
        System.out.println(apiUser);
    }

    @Test(dependsOnMethods = {"login"})
    public void dashboar(){
        System.out.println("dashboard");

    }
    @Test
    public void test3(){
        System.out.println("bye");
    }
    @Test(enabled = false)
    public void checkout(){
        System.out.println("checkout");
    }
    @Test
    public void cart(){
        System.out.println("cart");
    }
    @Test
    public void favorites(){
        System.out.println("fav");
        Assert.assertTrue(false);
    }
    @Test
    public void login(){
        System.out.println("login");

    }

    @Test(dataProvider = "getData")
    public void test2(String username, String password){
        System.out.println("bye");
        System.out.println(username);
        System.out.println(password);
    }
    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[3][2];
        //first set of data for first combination and on fisr index we have username and for second index we have password
        data[0][0]="firstusername";
        data[0][1]="firstpassword";
        //columns in the rows are the values of that combination
        //second set
        data[1][0]="firstusername";
        data[1][1]="firstpassword";
        // third set
        data[2][0]="firstusername";
        data[2][1]="firstpassword";
        return data;

    }

}
