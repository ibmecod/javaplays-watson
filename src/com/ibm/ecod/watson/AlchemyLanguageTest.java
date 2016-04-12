package com.ibm.ecod.watson;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class AlchemyLanguageTest {

  public static void main(String[] args) {
    AlchemyLanguage service = new AlchemyLanguage();
    service.setApiKey("f4b85e6505edfd8532a43e5409d66504cdb4b74a");

    Map<String, Object> params = new HashMap<String, Object>();
    params.put(AlchemyLanguage.TEXT,
        "IBM Watson won the Jeopardy television show hosted by Alex Trebek");
    DocumentSentiment sentiment = service.getSentiment(params);

    System.out.println(sentiment);
  }

}
