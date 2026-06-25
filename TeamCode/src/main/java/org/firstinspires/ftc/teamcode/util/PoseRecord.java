package org.firstinspires.ftc.teamcode.util;

// This class will be used for recording robot movements to replay them later
public class PoseRecord { // Java 8 < 16, can't use record classes
    double x;
    double y;
    float heading;
    long snapshotTime;

    public PoseRecord(double x, double y, float heading, long snapshotTime) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.snapshotTime = snapshotTime;
    }
}
