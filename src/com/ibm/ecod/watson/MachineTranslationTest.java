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

import com.ibm.watson.developer_cloud.machine_translation.v1.MachineTranslation;
import com.ibm.watson.developer_cloud.machine_translation.v1.model.Language;

public class MachineTranslationTest extends WatsonServiceTest {

	public static void mainold(String[] args) throws UnsupportedEncodingException {
		MachineTranslation mt = new MachineTranslation();
		try {
			mt.setUsernameAndPassword(
					"ca016c67-86cb-423c-9f77-e1fdfd335330",
					"2vC2caUNHTa9"
					);
			mt.setEndPoint("https://gateway.watsonplatform.net/language-identification-beta/api");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String response = mt.translate("The IBM ECOD team is awesome",
				Language.ENGLISH, Language.SPANISH);
		System.out.println(response);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		
		//import com.ibm.watson.developer_cloud.machine_translation.v1.MachineTranslation;
		//import com.ibm.watson.developer_cloud.machine_translation.v1.model.Language;
		
		MachineTranslation mtservice = new MachineTranslation();
		try {
			mtservice.setUsernameAndPassword(
					"ca016c67-86cb-423c-9f77-e1fdfd335330",
					"2vC2caUNHTa9"
					);
			mtservice.setEndPoint("https://gateway.watsonplatform.net/machine-translation-beta/api");
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		String response = mtservice.translate("The IBM ECOD team is awesome",
				Language.ENGLISH, Language.SPANISH);
		System.out.println(response);
	}
}
