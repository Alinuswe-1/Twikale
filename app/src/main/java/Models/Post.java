package Models;

import android.widget.ImageButton;

import com.google.firebase.Timestamp;

public class Post {
    String imageUrl;
    String location;

    String userName;

    String town;

    Timestamp timeAdded;

    float price;

    public Post(String imageUrl, String location, String userName, String town, Timestamp timeAdded,float price) {
        this.imageUrl = imageUrl;
        this.location = location;
        this.userName = userName;
        this.town = town;
        this.timeAdded = timeAdded;
        this.price = price;
    }

    public Timestamp getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        this.timeAdded = timeAdded;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "k "+price;
    }
}
