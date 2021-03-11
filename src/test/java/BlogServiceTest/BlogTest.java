package BlogServiceTest;


import org.junit.jupiter.api.Test;

public class BlogTest {


    public static abstract class A{
        public int test_a=1;
        public int test_b=1;
        final static int test_c=1;
        A(){}
        public void sayHi(){System.out.println("hi from A");}
        public abstract void sayNoHi();
    }

    public class B extends A{
        B(){
            super();
        }

        @Override
        public void sayNoHi() {
            
        }

        public void sayHi(){System.out.println("hi from B");}
    }

    @Test
    public void testKeyword(){
        B test = new B();
        test.sayHi();
        System.out.println(test.test_a+" "+test.test_b);

    }
}
