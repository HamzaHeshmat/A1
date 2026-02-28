
public class LiveStopWatch {


    private long StartTime ;
    private long PausedTime ;
    private boolean running = false;
    private boolean paused = false;
    private  Thread timerThread ;



    private String formatTime(long milles ) {
        long seconds = milles / 1000 ;
        long minutes = seconds / 60 ;
        seconds %=60 ;
        return String.format("%02d:%02d", minutes, seconds);
    }
    public void Start() {
        StartTime=System.currentTimeMillis();
        running= true ;

        timerThread= new Thread(() -> {

            while (running) {

                if (!paused) {
                    long current = System.currentTimeMillis();
                    long elapsed = current - StartTime ;
                    System.out.print("\rTime: " + formatTime(elapsed));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        timerThread.start();
    }
    public void Paused() {
        if (!paused){
            paused = true ;
            PausedTime = System.currentTimeMillis()- StartTime;
        }
    }
    public void resume() {
        if (paused){
            paused = false;
            StartTime = System.currentTimeMillis() - PausedTime ;
        }
    }
    public void stop() {
        running = false ;
        System.out.println("StopWatch has Stopped ! ");
    }
}
