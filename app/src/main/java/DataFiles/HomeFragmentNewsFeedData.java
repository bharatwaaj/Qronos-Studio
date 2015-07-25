package DataFiles;

/**
 * Created by Bharatwaaj on 25-07-2015.
 */
public class HomeFragmentNewsFeedData {

    int imageResourceHomeFragmentNewsFeed;
    String titleResourceHomeFragmentNewsFeed;

    public HomeFragmentNewsFeedData(String titleResourceHomeFragmentNewsFeed,int imageResourceHomeFragmentNewsFeed){
        this.imageResourceHomeFragmentNewsFeed=imageResourceHomeFragmentNewsFeed;
        this.titleResourceHomeFragmentNewsFeed=titleResourceHomeFragmentNewsFeed;
    }

    public String setTitleResourceHomeFragmentNewsFeed(){
        return titleResourceHomeFragmentNewsFeed;
    }

    public int setImageResourceHomeFragmentNewsFeed (){
        return imageResourceHomeFragmentNewsFeed;
    }
}
