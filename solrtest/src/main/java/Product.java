import org.apache.solr.client.solrj.beans.Field;

public class Product {
    @Field
    private String id;

    @Field
    private String producttitle;

    @Field
    private String productdescription;
}
