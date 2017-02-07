import com.mongodb.*;

/**
 * Created by User on 07.02.2017.
 */
public class DBWorker {

    private DB db;
    private MongoClient mongoClient;

    DBWorker(String database) {
        mongoClient = new MongoClient( "localhost" , 27017 );
        setUpConnection(database);
    }

    private void setUpConnection(String database) {
        db = mongoClient.getDB(database);
    }

    public String getSmthFromCollection(String collection) {
        DBCollection col = db.getCollection(collection);
        //col.insert(new BasicDBObject("name", "Alex").append("surname", "Sobko"));
        return col.find().toString();
    }

    public void addToCollection(String collection, BasicDBObject obj) {
        DBCollection col = db.getCollection(collection);
        col.insert(obj);
    }
}
