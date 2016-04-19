package com.ibm.ecod.watson;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.AccountPermission;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.AccountPermission.Permission;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Corpus.Access;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Documents;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Part;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;

public class TestCorpora {

	  public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		    final ConceptInsights service = new ConceptInsights();
		    service.setEndPoint("https://gateway.watsonplatform.net/concept-insights/api");
		    service.setUsernameAndPassword(
		      // Bluemix Watson Content Insights service account username from env variables
		      "a425694b-f06a-4956-886d-e2e9e66d7c65",
		      // Bluemix Watson Content Insights service account password from env variables
		      "FPhRNXvLnJ9m");
		    
		    final String name = "devoxx_corpus1";
		    final String account = service.getFirstAccountId();
		    System.out.println(account);
		    
		    Corpus corpus = new Corpus(account, name);
		    corpus.addAccountPermissions(new AccountPermission(account, Permission.READ_WRITE_ADMIN));
		    
		    service.deleteCorpus(corpus);

		    try
		    {
		    	service.createCorpus(corpus);
		    	corpus = service.getCorpus(corpus);
		    	corpus.setAccess(Access.PUBLIC);
		    	service.updateCorpus(corpus);
		    	
		    }
		    catch (Exception e)
		    {
		    	
		    }
		    
		    corpus = service.getCorpus(corpus);
		    
			SpeechToText speechToTextService = new SpeechToText();
		    speechToTextService.setUsernameAndPassword("d2334b1a-4c18-41df-8dab-3659c0dbfb3d", "dRGqpp6tvCXD");
		    speechToTextService.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
		    RecognizeOptions options = new RecognizeOptions();
		    options.contentType("audio/ogg");
		    options.continuous(true);
		    options.interimResults(true);

		    SpeechResults speechResults = speechToTextService.recognize(new File("input/writing_groovy_ATS.ogg"), options);

		    
		    Document newDocument = new Document(corpus, "writing_groovy_ATS");
		    newDocument.setLabel("test document");
		    
		    for (Transcript transcript : speechResults.getResults())
		    {
			    newDocument.addParts(new Part("part1", transcript.getAlternatives().get(0).getTranscript(), HttpMediaType.TEXT_PLAIN));
		    	
		    }
		    
		    try {
		      service.createDocument(newDocument);
		      newDocument = service.getDocument(newDocument);
		      newDocument.setTimeToLive(3600);
		      service.updateDocument(newDocument);
		    } finally {
//		      service.deleteDocument(newDocument);
		    }
		    
		    final Map<String, Object> params = new HashMap<String, Object>();
		    params.put(ConceptInsights.CURSOR, 0);
		    params.put(ConceptInsights.LIMIT, 20);

		    final Documents documents = service.listDocuments(corpus, params);
		    
		    System.out.println(documents);
		    
		  }

}
