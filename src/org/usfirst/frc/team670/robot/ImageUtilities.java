package org.usfirst.frc.team670.robot;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageUtilities{

	//Get bounding rectangle with defined HSV values
	public static Rect getBoundingRectangle(Mat frame, Scalar lowerHSV, Scalar upperHSV)
    {
			Mat processed = new Mat();
	    	Mat mHierarchy = new Mat();
	    	
	    	ArrayList<Rect> boxes = new ArrayList<Rect>();

	    	Core.inRange(frame, lowerHSV, upperHSV, processed);
	    	List<MatOfPoint> contours = new ArrayList<MatOfPoint>();   
	    	Imgproc.findContours(processed, contours, mHierarchy, Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
	    	MatOfPoint2f approxCurve = new MatOfPoint2f();
	    		    	
	    	for (int i = 0; i < contours.size(); i++)
	    	{
	    	        MatOfPoint2f contour2f = new MatOfPoint2f(contours.get(i).toArray());
	    	        double approxDistance = Imgproc.arcLength(contour2f, true)*0.02;
	    	        Imgproc.approxPolyDP(contour2f, approxCurve, approxDistance, true);
	    	        MatOfPoint points = new MatOfPoint( approxCurve.toArray() );
	    	        boxes.add(Imgproc.boundingRect(points));
	    	}
	    	
	    	if(boxes.size() < 1)
	    	{
	    		boxes.add(new Rect(0, 0, 0, 0));
	    	}
	    	
	    	Rect curr = new Rect(0,0,0,0);
	    	for(Rect r:boxes)
	    	{
	    		if(r.area() >= curr.area())
	    		{
	    			curr = r;
	    		}
	    	}
	    	
	    	return curr;
	}
}