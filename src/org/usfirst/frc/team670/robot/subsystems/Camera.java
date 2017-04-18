package org.usfirst.frc.team670.robot.subsystems;

import java.awt.Color;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.usfirst.frc.team670.robot.ImageUtilities;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
public class Camera extends Subsystem {
	
	double resolutionFactor = 0.5;
	double invalResFactor = 0.1;
	int resWidth = (int) (640*resolutionFactor), resHeight = (int) (480*resolutionFactor);
	UsbCamera winchCam, backCam, frontCam;
	//0 = Front, 1 = winch, 2 = back
	private CvSource outputStream;
	private CvSink cvSinkFront, cvSinkBack, cvSinkWinch, currentCvSink;
	private Mat src = new Mat();
	
	public Camera()
	{
		
	}
	
	public void init()
	{
		winchCam = CameraServer.getInstance().startAutomaticCapture("winch", 1);
		backCam = CameraServer.getInstance().startAutomaticCapture("back", 0);
		frontCam = CameraServer.getInstance().startAutomaticCapture("front", 2);
		frontCam.setResolution(resWidth, resHeight);
		backCam.setResolution(resWidth, resHeight);
		winchCam.setResolution(resWidth, resHeight);
        cvSinkWinch = CameraServer.getInstance().getVideo("winch");
        cvSinkFront = CameraServer.getInstance().getVideo("front");
        cvSinkBack = CameraServer.getInstance().getVideo("back");
        outputStream = CameraServer.getInstance().putVideo("Video", 640, 480);
        currentCvSink = cvSinkFront;
        
        //Run thread to start the processing
        new Thread(() -> {
	        	while(true)
	        	{
				        currentCvSink.grabFrame(src);
				        //Run processing here if you are inclined to do so
				        outputStream.putFrame(src);
	        	}
        }).start();
	}
	
	public void moveNextColorFollow(Color input, Jaguar left, Jaguar right, double speed)
	{
		double r = input.getRed();
		double g = input.getGreen();
		double b = input.getBlue();
	        double h, s, v;
	        
	        double min, max, delta;
	        if(r==b && b==g)
	        {
	            b++;
	        }
	        
	        min = Math.min(Math.min(r, g), b);
	        max = Math.max(Math.max(r, g), b);
	        // V
	        v = max;
	         delta = max - min;
	        // S
	         if( max != 0 )
	            s = delta / max;
	         else {
	            s = 0;
	            h = -1;
	         }
	        // H
	         if( r == max )
	            h = ( g - b ) / delta; // between yellow & magenta
	         else if( g == max )
	            h = 2 + ( b - r ) / delta; // between cyan & yellow
	         else
	            h = 4 + ( r - g ) / delta; // between magenta & cyan
	         h *= 60;    // degrees
	        if( h < 0 )
	            h += 360;
	      
		int len = 3;
		Rect rect = ImageUtilities.getBoundingRectangle(src, new Scalar(h-len,s-len,v-len), new Scalar(h+len,s+len,v+len));
		Point p = new Point(rect.x+rect.width/2, rect.y+rect.height/2);
		
		if(p.x < src.width()/2)
		{
			//More to the left
			right.set(speed);
			left.set(-speed);
		}
		else
		{
			//More to the right
			right.set(-speed);
			left.set(speed);
			
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
