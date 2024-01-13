package org.backend1.que3;
import java.util.logging.Logger;

public class Factorial extends Thread{

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    private long factorial;
    private int num;

    Factorial(int num){
        this.num = num;
    }

    public long getfactorial(){
        return factorial;
    }

    public void run(){
        factorial = calculatefac(num);
        LOGGER.info(String.valueOf(factorial));
    }

    public long calculatefac(int num)
    {
        long res = 1;
        int i = 1;
        while(i <= this.num){
            factorial *= i;
            i++;
        }

        return res;
    }


}
