package DataFiles;

/**
 * Created by Bharatwaaj on 06-09-2015.
 */
public class UserDetails {

    String userName;
    private String password;
    String emailID;
    int itemsSold;
    int itemsBought;

    public UserDetails(){

    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getEmailID(){
        return emailID;
    }
    public int getItemsSold(){
        return itemsSold;
    }
    public int getItemsBought(){
        return itemsBought;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmailID(String emailID){
        this.emailID=emailID;
    }
    public void setItemsSold(int itemsSold){
        this.itemsSold=itemsSold;
    }
    public void setItemsBought(int itemsBought){
        this.itemsBought=itemsBought;
    }

}
