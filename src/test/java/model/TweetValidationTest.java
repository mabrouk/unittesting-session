package model;

import org.junit.Test;

/**
 * Created by ahmad on 2/2/17.
 */
public class TweetValidationTest {

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenTweetIdIsBiggerThanReplyToTweet() {
        Tweet replyTo = new Tweet(10, "");
        Tweet testTweet = new Tweet(9, "", replyTo);
    }
}
