package hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "database.zone")
public class DatabaseCollectionProperties {

    private Map<String, String> collections;

    //public void setCollections(final Map<String, String> collections) {this.collections = collections;}

    public String getCollectionByCountry(final String country) {
        return collections.get(country);
    }
}