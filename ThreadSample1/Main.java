public class Main {
    public static void main(String[] args)    {
      new Main().test1();
      new Main().test2();
    }
    
    void test1() {
      MyThread t = new MyThread ();
      t.start();
      for (int i=0; i<2; i++) {
            if (i%100==50) System.out.println();
            System.out.print("Main Thread speaks!");
        }
    }
    
    void test2() {
      Thread t = new Thread (new MyThread2());
      t.start();
      for (int i=0; i<2; i++) {
            if (i%100==50) System.out.println();
            System.out.print("Main Thread speaks!");
        }
    }
}
