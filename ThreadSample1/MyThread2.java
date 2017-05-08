public class MyThread2 implements Runnable {
   public void run() {
       for (int i=0; i<2; i++) {
           
 
            if (i%100==50) System.out.println();
            System.out.print("MyThread2 speaks!");
        }
   }
}
