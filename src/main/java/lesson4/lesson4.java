package lesson4;

public class lesson4 {

    static Object mon = new Object();
    private static String s = "A";

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (mon){
                for (int i = 0; i < 5; i++) {
                    while(!s.equals("A")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(s);
                    s = "B";
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon){
                for (int i = 0; i < 5; i++) {
                    while(!s.equals("B")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(s);
                    s = "C";
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon){
                for (int i = 0; i < 5; i++) {
                    while(!s.equals("C")){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(s);
                    s = "A";
                    mon.notifyAll();
                }
            }
        }).start();

    }

}
