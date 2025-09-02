package org.example;

import in.Demo;
import org.testng.annotations.Test;

public class DemoTest {

    Demo d1 = new Demo();

    @Test
    public void test1(){
        int result = d1.AddCalculation(5,1);
        System.out.println("The results is: "+ result);
    }
}
