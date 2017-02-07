package model;

/**
 * Created by ahmad on 2/2/17.
 */
public class Tweet {
    private final int id;
    private final String text;
    private final Tweet replyTo;

    public Tweet(int id, String text) {
        this(id, text, null);
    }

    public Tweet(int id, String text, Tweet replyTo) {
        this.id = id;
        this.text = text;
        this.replyTo = replyTo;
        if(this.replyTo != null && this.replyTo.id > this.id)
            throw new IllegalArgumentException("our id is lower than the tweet we reply to");
    }
}
