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
import com.ibm.watson.developer_cloud.relationship_extraction.v1.model.RelationshipExtractionDataset;


public class RelationshipExtractionTest extends WatsonServiceTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		RelationshipExtraction ret = new RelationshipExtraction();
		try {
			ret.setUsernameAndPassword(
					"ca016c67-86cb-423c-9f77-e1fdfd335330",
					"2vC2caUNHTa9"
					);
			ret.setEndPoint("https://gateway.watsonplatform.net/relationship-extraction-beta/api");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		ret.setDataset(RelationshipExtractionDataset.ENGLISH_NEWS);
		String response = ret.extract("John works in IBM. John kicked the ball.");
		System.out.println(response);
	}


}
