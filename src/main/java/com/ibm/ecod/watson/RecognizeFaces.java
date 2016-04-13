package com.ibm.ecod.watson;

import java.io.File;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;

public class RecognizeFaces {

  public static void main(String[] args) {
    AlchemyVision service = new AlchemyVision();
    service.setApiKey("f4b85e6505edfd8532a43e5409d66504cdb4b74a");

    File image = new File("src/2011_Feb_group.jpg");
    ImageFaces faces = service.recognizeFaces(image, true);

    System.out.println(faces);
  }

}
