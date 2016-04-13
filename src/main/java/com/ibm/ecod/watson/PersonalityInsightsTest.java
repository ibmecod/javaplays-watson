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

public class PersonalityInsightsTest {

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

		String str = "Call me Ishmael. Some years ago-never mind how long precisely-having little or no money in my purse, and nothing particular to interest me on shore,";
		str += "I thought I would sail about a little and see the watery part of the world. It is a way I have of driving off the spleen and regulating the";
		str += "circulation. Whenever I find myself growing grim about the mouth; whenever it is a damp, drizzly November in my soul; whenever I find myself";
		str += "involuntarily pausing before coffin warehouses, and bringing up the rear of every funeral I meet; and especially whenever my hypos get such";
		str += "an upper hand of me, that it requires a strong moral principle to prevent me from deliberately stepping into the street, and methodically";
		str += "knocking people's hats off-then, I account it high time to get to sea as soon as I can. This is my substitute for pistol and ball.";
		str += "With a philosophical flourish Cato throws himself upon his sword; I quietly take to the ship. There is nothing surprising in this.";
		str += "If they but knew it, almost all men in their degree, some time or other, cherish very nearly the same feelings towards the ocean with me.";
		str += "There now is your insular city of the Manhattoes, belted round by wharves as Indian isles by coral reefs-commerce surrounds it with her surf.";
		str += "Right and left, the streets take you waterward. Its extreme downtown is the battery, where that noble mole is washed by waves, and cooled by";
		str += "breezes, which a few hours previous were out of sight of land. Look at the crowds of water-gazers there. Circumambulate the city of a dreamy";
		str += "Sabbath afternoon. Go from Corlears Hook to Coenties Slip, and from thence, by Whitehall, northward. What do you see?-Posted like silent sentinels";
		str += "all around the town, stand thousands upon thousands of mortal men fixed in ocean reveries. Some leaning against the spiles; some seated upon the";
		str += "pier-heads; some looking over the bulwarks of ships from China; some high aloft in the rigging, as if striving to get a still better seaward peep.";
		str += "But these are all landsmen; of week days pent up in lath and plaster-tied to counters, nailed to benches, clinched to desks. How then is this? Are";
		str += "the green fields gone? What do they here?";

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
