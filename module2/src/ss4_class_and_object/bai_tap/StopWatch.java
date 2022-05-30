package ss4_class_and_object.bai_tap;
import javafx.scene.paint.Stop;

import java.util.*;
public class StopWatch {
    private Date startTime;
    private Date endTime;
    public StopWatch(){
        this.startTime = new Date();
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void start(){
        this.startTime = new Date();
    }
    public void stop(){
        this.endTime = new Date();
    }
    public long getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }
    public static void main(String[] args) {
        StopWatch stop = new StopWatch();
        for (int i =0;i<1000;i++){
            System.out.println(i + " ");
        }
        stop.stop();
        System.out.println("Thoi gian thuc hien phep tinh la: "+stop.getElapsedTime());
    }
}
