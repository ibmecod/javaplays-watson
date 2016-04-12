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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

public class PersonalityInsightsTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		PersonalityInsights pit = new PersonalityInsights();
		
		pit.setEndPoint
		(
				"https://gateway.watsonplatform.net/personality-insights/api"
		);
		pit.setUsernameAndPassword
		(
				// Bluemix Watson Personality Insights service account username from env variables
				"1f03fa07-f19b-4e91-b7a7-e14cdd7d6220",
				// Bluemix Watson Personality Insights service account password from env variables
				"kuRCFH31XtqB"
		);

		String str = "Dog is a domestic animal.He is a loving friend of humans.";
		str += "He guards the house of human whole day.He gives respect to his master.He can smell his master from far off.";
		str += "He is a four-footed animal.Dogs are of many kinds:-Bull dogs,Grey hounds,Blood hounds,lap dogs etc….";
		str += "It has sharp teeths.He has four legs,a tail and straight ears.He is very useful in catching thieves and criminals by its powerful sense of hearing and smelling.";
		str += "Each dog has a different nose print.People love him for its noble service.";
		str += "Dogs eat rice, bread, fish, meat and other eatables.The dog is an omnivores animal. They are intelligent and faithful to their master. They can take good training .";
		str += "Intelligent dogs are trained and used by the police or army to smell the traces of criminals and also in investigation work, either indoor or outdoor.";
        str += "In some of the families a dog is treated as a dear pet and regarded as one of the family members. The small size dogs are tamed and loved as darlings in the family. And the bigger dogs like are strong enough to fight the thieves and robbers.I love dogs very much.";
        str += "Dogs are not only animal but also they are pets , friends and Investigators.Investigation Department keep Dogs as Security agent to find the critical solution of a problem.They are trained so cleverly so they are called smart animal.Dogs are too Smart to catch up the things very easily.";
        str += "Dogs are also kept as pets in homes as their friends.people love to keep dogs as they are very loyal to their masters.they serve their purpose selflessly.they are ready to sacrifice their life to save their masters life.but some people don’t value dogs.But dogs are really loyal animals on earth.";		

		Profile profile = pit.getProfile(str);
		System.out.println(profile);
		
	}

	/**
	 * Gets the string from input stream.
	 * 
	 * @param is
	 *            the is
	 * 
	 * @return the string from input stream
	 */
	protected static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}
