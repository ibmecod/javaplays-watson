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

import com.ibm.watson.developer_cloud.relationship_extraction.v1.RelationshipExtraction;
import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.Dataset;

public class RelationshipExtractionTest2
{

	public static void main(String[] args) throws UnsupportedEncodingException
	{

		RelationshipExtraction ret = new RelationshipExtraction();
		ret.setEndPoint
		(
				"https://gateway.watsonplatform.net/relationship-extraction-beta/api"
		);
		ret.setUsernameAndPassword
		(
				// Bluemix Watson Content Insights service account username from env variables
				"e254e369-25cd-410b-87e8-7c9a47103683",
				// Bluemix Watson Content Insights service account password from env variables
				"Q8osO9Tuw3MF"
		);

		ret.setDataset(Dataset.ENGLISH_NEWS);
		String response = ret.extract("Cognitive Computing is described as the 3rd era of computing as we move from data collection and manipulation to transmitting knowledge and decision making.  Leveraging a personality insight cognitive service from IBM Watson and rapid application development on a Cloud Foundry PaaS (using Java), learn how a new breed of application is allowing new interactions based on insights to data.   You will see an example of a Java-based app that can correlate personality traits to identify potential advocates for a product or service.  Hope you can join us as Joe Kozhaya from IBM Watson demonstrates this new platform for innovation.");
		System.out.println(response);
		
	}

}
