import java.io.*;

public class runner {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        @SuppressWarnings("deprecation")
        final Process p = Runtime.getRuntime().exec("java -jar bungee/bungee.jar");

        Thread OutputThread = new Thread(new Runnable() {
            public void run() {
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;

                try {
                    while ((line = input.readLine()) != null)
                        System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        OutputThread.start();

        Thread bungeeThread = new Thread() {
            public void run() {
                try {
                    @SuppressWarnings("deprecation")
                    final Process p = Runtime.getRuntime().exec("java -jar server/server.jar");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        bungeeThread.start();

        try {
            p.waitFor();
            bungeeThread.stop();
            OutputThread.stop();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            bungeeThread.stop();
            OutputThread.stop();
            e.printStackTrace();
        }

    }
}