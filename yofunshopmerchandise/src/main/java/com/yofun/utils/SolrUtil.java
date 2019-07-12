package com.yofun.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.*;

public class SolrUtil {
    /**
     * batch build index
     *
     * @throws Exception
     */
    public static void addIndex(SolrClient solrClient, Map<String, Object> mapValue) throws Exception {

        SolrInputDocument document = new SolrInputDocument();
        Object idvalue = mapValue.get("id");
        document.addField("id", idvalue);

        if (mapValue != null) {
            Set<Map.Entry<String, Object>> entrySet = mapValue.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {

                String field = entry.getKey();
                Object value = entry.getValue();
                if ("id".equals(field)) {
                    continue;
                }
                Map<String, Object> operation = new HashMap<String, Object>();
                operation.put("set", value);
                document.addField(field, operation);
            }
        }
        UpdateResponse response = solrClient.add(document);
        solrClient.commit();

    }

    public static List<String> searchqyinfofromsolr(SolrClient solrClient, String searchName)
            throws SolrServerException, IOException {
        if(searchName == null) {
            return new ArrayList<>();
        }

        SolrQuery query = new SolrQuery();
        query.setQuery("producttitle:" + "*" + searchName + "* OR productdescription:" + "*" + searchName + "*");

        QueryResponse response = solrClient.query(query);
        SolrDocumentList docs = response.getResults();
        long count = docs.size();
        List<String> getliststring = new ArrayList<>();
        //traversal
        for (int i = 0; i < count; i++) {
            SolrDocument sd = docs.get(i);
            String rowkeyString = (String) sd.getFieldValue("id");
            getliststring.add(rowkeyString);
        }
        return getliststring;
    }

//    public static void main(String[] args) throws Exception {
//        Map<String, Object> mapValue = new HashMap<String,Object>();
//
//        mapValue.put("id","2");
//        mapValue.put("producttitle","pork");
//        mapValue.put("productdescription","chicken pork");
//
//        mapValue.put("id","3");
//        mapValue.put("producttitle","beef");
//        mapValue.put("productdescription","chicken beef");
//
//        addIndex2(mapValue);
//
//        List<String> list = searchqyinfofromsolr("chicken");
//
//        for (String temp : list) {
//            System.out.println(temp);
//        }
//    }
}
