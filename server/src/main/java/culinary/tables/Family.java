package culinary.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by olya on 09.02.2017.
 */

@Document(collection = "Family")
public class Family {

    @Id
    private String id;
    @JsonProperty("name")
    private String familyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Family(String name) {
        this.familyName = name;
    }

    public Family() {}

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


}
