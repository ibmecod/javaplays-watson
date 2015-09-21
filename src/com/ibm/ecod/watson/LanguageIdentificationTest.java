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

import com.ibm.watson.developer_cloud.language_identification.v1.LanguageIdentification;
import com.ibm.watson.developer_cloud.language_identification.v1.model.IdentifiedLanguage;


public class LanguageIdentificationTest  {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		/*
		import com.ibm.watson.developer_cloud.language_identification.v1.LanguageIdentification;
		import com.ibm.watson.developer_cloud.language_identification.v1.model.IdentifiedLanguage;
		 */
		LanguageIdentification lit = new LanguageIdentification();	
		try {
			lit.setUsernameAndPassword(
					"43d9762b-f0cb-46a5-80ef-aea6bcaf1b50",
                    "4vlwyOuaOZoE"
					);
			lit.setEndPoint("https://gateway.watsonplatform.net/language-translation/api");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IdentifiedLanguage lang = lit.identify("Good Morning");
		System.out.println(lang);
	}

}