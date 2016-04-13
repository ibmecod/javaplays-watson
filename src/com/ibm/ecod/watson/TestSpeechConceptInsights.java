package com.ibm.ecod.watson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.Transcript;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeDelegate;

public class TestSpeechConceptInsights {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		SpeechToText service = new SpeechToText();
	    service.setUsernameAndPassword("d2334b1a-4c18-41df-8dab-3659c0dbfb3d", "dRGqpp6tvCXD");
	    service.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
	    RecognizeOptions options = new RecognizeOptions();
	    options.contentType("audio/wav");
	    options.continuous(true);
	    options.interimResults(true);

//	    service.recognizeUsingWebSockets(new FileInputStream(new File("input/Q1.wav")), options, new BaseRecognizeDelegate() {
//	      public void onMessage(SpeechResults speechResults) {
//	        List<Transcript> results = speechResults.getResults();
//	        for (Transcript transcript : results) {
//	          if (transcript.isFinal()) {
//	            List<SpeechAlternative> alternatives = transcript.getAlternatives();
//	            for (SpeechAlternative speechAlternative : alternatives) {
//	              System.out.println(speechAlternative.getTranscript());
//	              final ConceptInsights service = new ConceptInsights();
//	              service.setEndPoint("https://gateway.watsonplatform.net/concept-insights/api");
//	              service.setUsernameAndPassword(
//	                // Bluemix Watson Content Insights service account username from env variables
//	                "a425694b-f06a-4956-886d-e2e9e66d7c65",
//	                // Bluemix Watson Content Insights service account password from env variables
//	                "FPhRNXvLnJ9m");
//
//	              final Annotations annotations = service.annotateText(Graph.WIKIPEDIA, speechAlternative.getTranscript());
//	              System.out.println(annotations);
//	            }
//	          }
//	        }
//	      }
//	    });
	    
	    SpeechResults speechResults = service.recognize(new File("input/Q1.wav"), options);
	    
	    System.out.println(speechResults.toString());

	}

}
