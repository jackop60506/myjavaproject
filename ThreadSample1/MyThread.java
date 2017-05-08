public class MyThread extends Thread {
   public void run() {
       for (int i=0; i<2; i++) {
            if (i%100==50) System.out.println();
            System.out.print("MyThread1 speaks!");
        }
   }
}
