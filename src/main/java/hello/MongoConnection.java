package hello;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection {
    public void iniciandoConnection(long id,String sku, int qty) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("BaseP");
        MongoCollection<Document> collection = database.getCollection("Customer_Test");
        Document doc = new Document("id",id)
                .append("Sku", sku)
                .append("Qty", qty);
        collection.insertOne(doc);
    }
}
