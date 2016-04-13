/**
 * Copyright 2014 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.ecod.watson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

/**
 * Tests Bluemix Watson Dialog service.
 * Create folder "input" in your working directory.
 * Copy "input/DialogTest.xml" file to "input" folder.
 * 
 * Correction to exercise instruction.
 * REMOVE OLD WRAPPER LIBRARY FROM THE PROJECT
 * Use this version of Watson Java wrapper library.
 * java-wrapper-1.1.1-jar-with-dependencies.jar
 * 
 */
public class DialogTest
{
	public static void main(String[] args)
	{

		DialogService service = new DialogService();
		service.setEndPoint("https://gateway.watsonplatform.net/dialog/api");
		service.setUsernameAndPassword
		(
				// account username from VCAP_SERVICES env variable of the Dialog service instance
				"144570fe-e5d5-4b98-b188-aa92cbafe14c",
				// account password from VCAP_SERVICES env variable of the Dialog service instance
				"mEBqVd9MRAkH"
		);

		// Note Dialog name must be unique for each user ! Use your initials and
		// last 4 digits of your phone number
		// to make sure
		Dialog dialog = service.createDialog("dialog-sk4251", new File("input/DialogTest.xml"));

		// Create conversation
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DialogService.DIALOG_ID, dialog.getId());

		Conversation conversation = service.converse(params);
		System.out.println("Viacom: " + conversation.getResponse().get(0));
		
		// Ask question
		
		/**
		 * Recognize a sample wav file and print the transcript into the console output. Make sure you are
		 * using UTF-8 to print messages; otherwise, you will see question marks.
		 */
		
		  SpeechToText speechToTextService = new SpeechToText();
		  speechToTextService.setUsernameAndPassword("d2334b1a-4c18-41df-8dab-3659c0dbfb3d", "dRGqpp6tvCXD");
		  speechToTextService.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
		  RecognizeOptions options = new RecognizeOptions();
		  options.contentType("audio/wav");
		  options.continuous(true);
		  options.interimResults(true);
		  
		  for (int i = 1; i <= 4; i++)
		  {
			    File audio = new File("input/Q" + i + ".wav");
			    SpeechResults transcript = speechToTextService.recognize(audio, options);

			    String question = transcript.getResults().get(0).getAlternatives().get(0).getTranscript();
				  
				
						System.out.println("me : " + question);
						params.put(DialogService.CLIENT_ID, conversation.getClientId());
						params.put(DialogService.INPUT, question);
						params.put(DialogService.CONVERSATION_ID, conversation.getId());
						conversation = service.converse(params);

				// Get reply
						System.out.println("Caterers at Viacom: " + conversation.getResponse().get(0));
				
			  
		  }

		if (dialog != null)
		{
			service.deleteDialog(dialog.getId());
			System.out.println("\nConversation ended");
		}

	}

}
