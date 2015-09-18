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

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.message_resonance.v1.MessageResonance;
import com.ibm.watson.developer_cloud.message_resonance.v1.model.MessageResonanceDataset;
import com.ibm.watson.developer_cloud.message_resonance.v1.model.Message;
import com.ibm.watson.developer_cloud.message_resonance.v1.model.Resonance;


/**
 */
public class MessageResonanceTest extends WatsonServiceTest {

	/**
	 * Method testResonance.
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		MessageResonance mrt = new MessageResonance();	
		try {
			mrt.setUsernameAndPassword(
					"ca016c67-86cb-423c-9f77-e1fdfd335330",
					"2vC2caUNHTa9"
					);
			mrt.setEndPoint("https://gateway.watsonplatform.net/language-identification-beta/api");
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		String text = "See how we're keeping fans immersed in the match with @IBMcloud";
		mrt.setDataset(MessageResonanceDataset.BIG_DATA);

		Message message = mrt.getResonance(text);
		System.out.println(message.getText());		
		List<Resonance> resonances = message.getResonances();
		for (int i = 0; i < resonances.size(); i++) {
			Resonance element = resonances.get(i);
			System.out.println(element);
		}
	}
}
