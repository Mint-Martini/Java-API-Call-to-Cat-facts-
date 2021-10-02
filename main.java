package com.company;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;




public class Main {

    int mainAge;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();


        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet getRequest = new HttpGet("https://catfact.ninja/fact");


            try (CloseableHttpResponse response1 = httpclient.execute(getRequest)) {
                HttpEntity entity1 = response1.getEntity();
                String content = EntityUtils.toString(entity1);
                CatFact testCat  = mapper.readValue(content, CatFact.class);
                System.out.println(testCat.toString());
                EntityUtils.consume(entity1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Main (int x){

        mainAge = x;

    }

    public int displayAge(){
        return mainAge;
    }
}


class CatFact {

   private String fact ;
    private  String length ;

     public CatFact (){}

    void setFact(String x){
         fact=x;

    }

    void setlength(String x){
        length=x;

    }

    String getLength() {
         return length;

    }

    String getFacts() {
        return fact;

    }

    public String toString() {
         String fin = "All The Stuff "+ fact + ", "+ length;
        return fin;

    }



}
