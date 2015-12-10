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

public class RelationshipExtractionTest
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
				"48c50795-9eea-4254-b5d6-889f4b7d8dda",
				// Bluemix Watson Content Insights service account password from env variables
				"4ukZ0Ho6uUIf"
		);

		ret.setDataset(Dataset.ENGLISH_NEWS);
		String response = ret.extract("John works in IBM. John kicked the ball.");
		System.out.println(response);
		
	}

}
