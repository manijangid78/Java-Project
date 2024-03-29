package com.Jfacedetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Point;
public class Jfacedetection {
	public static void main(String args[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		System.out.println("Done");
		String imagefile ="images/multi.jpg";
		Mat src = Imgcodecs.imread(imagefile); 
		String xmlfile = "xml/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlfile);
		
		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Detected Faces: %d",faceDetection.toArray().length));
		
		for(Rect  rect: faceDetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y),new Point(rect.x + rect.width,rect.y + rect.height), new Scalar(0,0,255),3); 
		}
		
		Imgcodecs.imwrite("images/multi_out.jpg",src);
		System.out.println("Image Detection Finished");
	}
}