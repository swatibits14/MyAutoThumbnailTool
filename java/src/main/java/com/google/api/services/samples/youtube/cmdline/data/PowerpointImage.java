package com.google.api.services.samples.youtube.cmdline.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.TextAlign;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class PowerpointImage {
	public static String CreateImage(String title) throws IOException{
	      
	      //creating an empty presentation
	      File file=new File("C:/Users/swatisharma/Desktop/DesignPattern.pptx");
	      XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(file));
	      //XSLFSlideMaster slideMaster = ppt.getSlideMasters()[0];
	      XSLFSlide[] slides = ppt.getSlides();    
	      XSLFSlide slide = slides[0];
	      
	      //select a layout from specified list
	      //XSLFSlideLayout titleLayout = slideMaster.getLayout(SlideLayout.TITLE_ONLY);
	      //creating a slide with title and content layout
	      //XSLFSlide slide = ppt.createSlide(titleLayout);
	      
	      //selection of title place holder
	      XSLFTextShape body = slide.getPlaceholder(0);
	      
	      //clear the existing text in the slide
	      body.clearText();
	      
	      //adding new paragraph
	      XSLFTextParagraph paragraph=body.addNewTextParagraph();
	      
	      paragraph.setTextAlign(TextAlign.CENTER);
	      XSLFTextRun run2 = paragraph.addNewTextRun();
	      run2.setText(title);
	    
	      run2.setFontSize(70);
	      run2.setFontColor(java.awt.Color.black);
	           
	      //making the text bold
	      run2.setBold(true);
	      paragraph.addLineBreak();
	      BufferedImage img = null;
	      //getting the dimensions and size of the slide 
	      Dimension pgsize = ppt.getPageSize();
	     	      
	      for (int i = 0; i < 1; i++) {
	         img = new BufferedImage(pgsize.width, pgsize.height,BufferedImage.TYPE_INT_RGB);
	         Graphics2D graphics = img.createGraphics();

	         //clear the drawing area
	         graphics.setPaint(Color.green);
	         graphics.drawString("Swati", 200.34f, 340.23f);
	         
	         //graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

	         //render
	         slide.draw(graphics);
	      }

	      //creating an image file as output
	     // FileOutputStream out = new FileOutputStream("ppt_image.png");
	      String out1 = "C:/Users/swatisharma/Desktop/myimages/"+title+".png";
	      FileOutputStream out = new FileOutputStream(out1);
	      ImageIO.write(img, "png", out);
	      //writeJpeg(img,out,1);
	      //String imagePath=null;
	      return out1;
	      //System.out.println("Image successfully created");
	      
	   }
	public static void main(String args[]) throws IOException
	{
		CreateImage("Swati");
	}
	private static void writeJpeg(BufferedImage image, String destFile, float quality) 
			throws IOException {
			    ImageWriter writer = null;
			    FileImageOutputStream output = null;
			    try {
			        writer = ImageIO.getImageWritersByFormatName("jpeg").next();
			        ImageWriteParam param = writer.getDefaultWriteParam();
			        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			        param.setCompressionQuality(quality);
			        output = new FileImageOutputStream(new File(destFile));
			        writer.setOutput(output);
			        IIOImage iioImage = new IIOImage(image, null, null);
			        writer.write(null, iioImage, param);
			    } catch (IOException ex) {
			        throw ex;
			    } finally {
			        if (writer != null) writer.dispose();
			        if (output != null) output.close();
			    }
			}
}
