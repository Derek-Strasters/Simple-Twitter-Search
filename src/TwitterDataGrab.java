/**
 * 
 */
package src;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author Team Dragon: Dustin, Brayden, Steph, Jeffrey
 * Hello Team! To run, just go to the green circle with an arrow up top, click on the drop down and select "Run Configuration"
 * There just go to "arguments" and put something there. Use " " for multiple expressions. Have fun!
 */
public class TwitterDataGrab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
            System.out.printf("\u001B[31m Usage \u001B[0m: java twitter4j.examples.search.SearchTweets [query]\n"
            		+ "For [query] more than one word use quotes");
            System.exit(-1);
		}
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(args[0]);
            QueryResult result; 
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
	}

}
