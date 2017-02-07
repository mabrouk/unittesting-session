package model;


/**
 * Created by ahmad on 1/13/17.
 */

public class Reminder {
    public static final int TYPE_TIME_REMINDER = 1;
    public static final int TYPE_LOCATION_REMINDER = 2;

    public static Reminder createTimeReminder(long id, String name, long timestamp, boolean completed) {
        return new Reminder(id, TYPE_TIME_REMINDER, name, timestamp, 0, 0, completed);
    }

    public static Reminder createLocationReminder(long id, String name, double latitude, double longitude,
                                                  boolean completed) {
        return new Reminder(id, TYPE_LOCATION_REMINDER, name, 0, latitude, longitude, completed);
    }

    long id;
    int type;
    String name;
    long timestamp;
    double latitude;
    double longitude;
    boolean completed;

    private Reminder(long id, int type, String name, long timestamp, double latitude, double longitude, boolean completed) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.completed = completed;
        verify();
    }

    private void verify() {
        if(type == TYPE_TIME_REMINDER) {
            if(timestamp <= 0)
                throw new IllegalArgumentException("Reminder time cannot be zero or less");
        }else{
            if(latitude > 90 || latitude < -90)
                throw new IllegalArgumentException("Latitude can't be less than -90 or more than 90");
            if(longitude > 180 || longitude < -180)
                throw new IllegalArgumentException("Longitude can't be less than -180 or more than 180");
        }
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isCompleted() {
        return completed;
    }
}
