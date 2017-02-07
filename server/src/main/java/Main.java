import com.mongodb.BasicDBObject;

/**
 * Created by User on 07.02.2017.
 */

public class Main {
    public static void main(String[] args) {
        DBWorker db = new DBWorker("users");
        db.addToCollection("users", new BasicDBObject("name", "Andrey"));
        System.out.println(db.getSmthFromCollection("people"));
    }
}
