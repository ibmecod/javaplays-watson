package com.ibm.ecod.watson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.dialog.v1.model.Conversation;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;

/**
 * Tests Bluemix Watson Dialog service.
 * Create folder "input" in your working directory.
 * Copy "input/DialogTest.xml" file to "input" folder.
 * 
 * Correction to exercise instruction.
 * Use this version of Watson Java wrapper library.
 * java-wrapper-1.1.1-jar-with-dependencies.jar
 * 
 * @author tnevoli
 *
 */
public class DialogTest
{
	public static void main(String[] args)
	{

		DialogService service = new DialogService();
		service.setUsernameAndPassword
		(
				// account username from VCAP_SERVICES env variable of the Dialog service instance
				"04827ce9-2397-4ee1-aef2-b48ddb1002bc",
				// account password from VCAP_SERVICES env variable of the Dialog service instance
				"sYD19zNJy29x"
		);
		service.setEndPoint("https://gateway.watsonplatform.net/dialog/api");

		// Note Dialog name must be unique for each user ! Use your initials and
		// last 4 digits of your phone number
		// to make sure
		Dialog dialog = service.createDialog("dialog-name-goes-here", new File("input/DialogTest.xml"));

		// Create conversation
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(DialogService.DIALOG_ID, dialog.getId());

		Conversation conversation = service.converse(params);
		System.out.println("Mike's Pizza: " + conversation.getResponse().get(0));

		// Ask question
		System.out.println("me : " + "Hi, what type of toppings do you have?");
		params.put(DialogService.CLIENT_ID, conversation.getClientId());
		params.put(DialogService.INPUT, "What type of toppings do you have?");
		params.put(DialogService.CONVERSATION_ID, conversation.getId());
		conversation = service.converse(params);

		// Get reply
		System.out.println("Mike's Pizza: " + conversation.getResponse().get(0));

		if (dialog != null)
		{
			service.deleteDialog(dialog.getId());
			System.out.println("\nConversation ended");
		}

	}

}
