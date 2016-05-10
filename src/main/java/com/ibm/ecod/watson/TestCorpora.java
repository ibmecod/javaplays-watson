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
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Document;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Documents;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Matches;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Part;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.RequestedFields;
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
		    
//		    service.deleteCorpus(corpus);
//
//		    try
//		    {
//		    	service.createCorpus(corpus);
//		    	corpus = service.getCorpus(corpus);
//		    	corpus.setAccess(Access.PUBLIC);
//		    	service.updateCorpus(corpus);
//		    	
//		    }
//		    catch (Exception e)
//		    {
//		    	
//		    }
//		    
//		    corpus = service.getCorpus(corpus);
		    
			SpeechToText speechToTextService = new SpeechToText();
		    speechToTextService.setUsernameAndPassword("d2334b1a-4c18-41df-8dab-3659c0dbfb3d", "dRGqpp6tvCXD");
		    speechToTextService.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
		    RecognizeOptions options = new RecognizeOptions();
		    options.contentType("audio/ogg");
		    options.continuous(true);
		    options.interimResults(true);
		    
		    SpeechResults speechResults;
		    
		    Document newDocument;

//		    speechResults = speechToTextService.recognize(new File("input/InterviewWithPepperRobot.ogg"), options);
//		    System.out.println(speechResults.toString());
//		    SpeechResults speechResults = speechToTextService.recognize(new File("input/writing_groovy_ATS.ogg"), options);
//
//		    
//		    Document newDocument = new Document(corpus, "writing_groovy_ATS");
//		    newDocument.setLabel("test document");
//		    
//		    for (int i = 0; i < speechResults.getResults().size(); i++)
//		    {
//			    Transcript transcript = speechResults.getResults().get(i);
//			    	
//			    newDocument.addParts(new Part("part_" + i, transcript.getAlternatives().get(0).getTranscript(), HttpMediaType.TEXT_PLAIN));
//		    	
//		    }
//		    
//		    try {
//		      service.createDocument(newDocument);
//		      newDocument = service.getDocument(newDocument);
//		      newDocument.setTimeToLive(3600);
//		      service.updateDocument(newDocument);
//		    } finally {
////		      service.deleteDocument(newDocument);
//		    }
//		    
//		    speechResults = speechToTextService.recognize(new File("input/InterviewWithPepperRobot.ogg"), options);
//
//		    
//		    newDocument = new Document(corpus, "InterviewWithPepperRobot");
//		    newDocument.setLabel("test document 2");
//		    
//		    for (int i = 0; i < speechResults.getResults().size(); i++)
//		    {
//			    Transcript transcript = speechResults.getResults().get(i);
//			    	
//			    newDocument.addParts(new Part("part_" + i, transcript.getAlternatives().get(0).getTranscript(), HttpMediaType.TEXT_PLAIN));
//		    	
//		    }
//		    
//		    try {
//		      service.createDocument(newDocument);
//		      newDocument = service.getDocument(newDocument);
//		      newDocument.setTimeToLive(3600);
//		      service.updateDocument(newDocument);
//		    } finally {
////		      service.deleteDocument(newDocument);
//		    }

//		    for (int chunkIndex = 0; chunkIndex <= 1; chunkIndex++)
//		    {
//		    	String chunkFilePath = String.format("input/GetHip/chunks/audio%02d.ogg", chunkIndex);
//		    	System.out.println(chunkFilePath);
//		    	
//			    speechResults = speechToTextService.recognize(new File(chunkFilePath), options);
//
//			    newDocument = new Document(corpus, "GetHip");
//			    newDocument.setLabel(String.format("GetHip%02d", chunkIndex));
//
//			    Map<String, String> userFields = new HashMap<String, String>();
//			    userFields.put("link", "http://test.link.com");
//			    newDocument.setUserFields(userFields);
//			    
//			    for (int i = 0; i < speechResults.getResults().size(); i++)
//			    {
//				    Transcript transcript = speechResults.getResults().get(i);
//				    	
//				    newDocument.addParts(new Part("part_" + i, transcript.getAlternatives().get(0).getTranscript(), HttpMediaType.TEXT_PLAIN));
//			    	
//			    }
//			    
//			    try {
//			      service.createDocument(newDocument);
//			      newDocument = service.getDocument(newDocument);
//			      newDocument.setTimeToLive(3600);
//			      service.updateDocument(newDocument);
//			    } finally {
////			      service.deleteDocument(newDocument);
//			    }
//		    	
//		    }
//		    
	    	String smallFilePath = "input/GetHip/chunks/audio_small.ogg";
	    	System.out.println(smallFilePath);
	    	
		    speechResults = speechToTextService.recognize(new File(smallFilePath), options);

		    newDocument = new Document(corpus, "GetHip_small");
		    newDocument.setLabel("GetHip_small");

		    Map<String, String> userFields = new HashMap<String, String>();
		    userFields.put("link", "http://test.link.com");
		    newDocument.setUserFields(userFields);
		    
		    for (int i = 0; i < speechResults.getResults().size(); i++)
		    {
			    Transcript transcript = speechResults.getResults().get(i);
			    	
			    newDocument.addParts(new Part("part_" + i, transcript.getAlternatives().get(0).getTranscript(), HttpMediaType.TEXT_PLAIN));
		    	
		    }
		    
		    try {
		      service.createDocument(newDocument);
		      newDocument = service.getDocument(newDocument);
		      newDocument.setTimeToLive(3600);
		      service.updateDocument(newDocument);
		    } finally {
//		      service.deleteDocument(newDocument);
		    }
		    
		    System.out.println(newDocument.getUserFields());
		    
		    final Map<String, Object> params = new HashMap<String, Object>();
		    params.put(ConceptInsights.CURSOR, 0);
		    params.put(ConceptInsights.LIMIT, 20);

		    final Documents documents = service.listDocuments(corpus, params);
		    
		    System.out.println(documents);
		    
		    for (String keyword : new String[]{"robot", "concept", "cloud", })
		    {
			    Map <String, Object> searchGraphConceptByLabelParams = new HashMap<String, Object>();
			    searchGraphConceptByLabelParams.put("query", "robot");
			    searchGraphConceptByLabelParams.put("prefix", true);
			    searchGraphConceptByLabelParams.put("limit", 10);

			    RequestedFields concept_fields = new RequestedFields();
//			    concept_fields.include("link");
			    concept_fields.include("\"abstract\":1");
			    concept_fields.include("\"userFields\":1");

			    searchGraphConceptByLabelParams.put("concept_fields", concept_fields);

			    Matches matches = service.searchGraphsConceptByLabel(Graph.WIKIPEDIA, searchGraphConceptByLabelParams);
			    System.out.println(matches);
		    	
		    }
		    
//		    Map<String, Object> parameters = new HashMap<String, Object>();
//		    parameters.put("ids", Arrays.asList(new String[]{"/corpora/eve6tionsto1/devoxx_corpus1/documents/writing_groovy_ATS", "/corpora/eve6tionsto1/devoxx_corpus1/documents/InterviewWithPepperRobot", }));
//		    
//		    QueryConcepts queryConcepts = service.conceptualSearch(corpus, parameters);
//		    
//		    System.out.println(queryConcepts.toString());
//		    
//		    Concept concept = new Concept(account, "/graphs/wikipedia/en-20120601", "Code");
//		    ConceptMetadata conceptMetadata = service.getConcept(concept);
//		    
//		    System.out.println(conceptMetadata.toString());
		    
		  }

}
