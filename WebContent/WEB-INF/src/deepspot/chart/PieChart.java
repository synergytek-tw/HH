package deepspot.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import deepspot.util.Util;

public class PieChart{
	
	public PieChart(String titleText){
		data = new DefaultPieDataset();
		this.titleText = titleText;
	}
	
	public PieChart(){
		data = new DefaultPieDataset();
	}
	
	DefaultPieDataset data;
	public void setData(DefaultPieDataset data){
		this.data = data;
	}
	public DefaultPieDataset getData(){
		return this.data;
	}
	
	boolean flag_3D = false;
	public void set3DFlag(boolean flag_3D){
		this.flag_3D = flag_3D;
	}
	public boolean get3DFlag(){
		return this.flag_3D;
	}
	
	boolean showTip = true;
	public void setShowTip(boolean showTip){
		this.showTip = showTip;
	}
	public boolean ShowTip(){
		return this.showTip;
	}
	
	int high = 500;
	public void setHigh(int high){
		this.high = high;
	}
	public int getHigh(){
		return this.high;
	}
	
	int width = 800;
	public void setWidth(int width){
		this.width = width;
	}
	public int getWidth(){
		return this.width;
	}
	
	String titleText;
	public void setTitleText(String titleText){
		this.titleText = titleText;
	}
	public String getTitleText(){
		return this.titleText;
	}
	
	Font titleFont = new Font("xx", Font.BOLD, 16);
	public void setTitleFont(Font titleFont){
		this.titleFont = titleFont;
	}
	public Font getTitleFont(){
		return this.titleFont;
	}
	
	public String genChart(){
		if(data.getItemCount()==0){
			this.setSampleData();
		}
		JFreeChart chart;
		if(flag_3D){
			chart = ChartFactory.createPieChart3D(titleText,data,showTip,false,false);
		} else {
			chart = ChartFactory.createPieChart(titleText,data,showTip,false,false);
		}
		
		Paint [] sPaint = {new Color(0x92, 0xD1, 0xF4), new Color(0xD9, 0xEB, 0xB1),
     		   new Color(0xA3, 0x7B, 0xAD), new Color(0xF2, 0xAE, 0xB9),
     		   new Color(0x7A, 0x7F, 0xB6), new Color(0x99, 0xBC, 0xE2),
     		   new Color(0xC2, 0x9A, 0x9B), new Color(0xEC, 0x89, 0xA5),
     		   new Color(0xB7, 0xDD, 0xC8), new Color(0x99, 0xCE, 0x7E),
     		   
     		   new Color(0x00, 0x6D, 0x8A), new Color(0xC4, 0x9A, 0x8E),
     		   new Color(0x34, 0x71, 0xB0), new Color(0x95, 0xD0, 0xDE),
     		   new Color(0x61, 0xBB, 0xA1), new Color(0x26, 0x58, 0x7D),
     		   new Color(0xC6, 0xAE, 0x94), new Color(0x59, 0x5D, 0x9D),
     		   new Color(0xD6, 0xA7, 0xC9), new Color(0xF4, 0xC6, 0xA2),
     		   
     		   new Color(0x17, 0x3C, 0x66), new Color(0x8E, 0xAD, 0x9B),
     		   new Color(0x70, 0x45, 0x8C), new Color(0xFF, 0xFB, 0xB1),
     		   new Color(0x00, 0xA2, 0x71), new Color(0x7A, 0xA6, 0xBF),
     		   new Color(0x7B, 0xA6, 0x9A), new Color(0x3E, 0x2D, 0x7D),
     		   new Color(0x00, 0x46, 0x8E), new Color(0x01, 0x9C, 0x9E),
     		   
     		   new Color(0x83, 0x88, 0xA6), new Color(0x7C, 0xA7, 0xAD),
     		   new Color(0x72, 0x9D, 0x68), new Color(0xFC, 0xED, 0x88),
     		   new Color(0x84, 0x82, 0x83), new Color(0xAB, 0x93, 0xA9),
     		   new Color(0x5C, 0x50, 0x80), new Color(0xF2, 0xAE, 0x7D),
     		   new Color(0x93, 0x8D, 0xA7), new Color(0xAC, 0xC7, 0x75),
     		   
     		   new Color(0x6A, 0xBA, 0xD0), new Color(0xC2, 0x8D, 0x3E)};

		Plot plot = chart.getPlot();

		plot.setDrawingSupplier(new DefaultDrawingSupplier(sPaint,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
		
		if(this.titleText != null){
			chart.setTitle(new TextTitle(titleText,titleFont));
		}
		String fileName;
		try {
			fileName = ServletUtilities.saveChartAsJPEG(chart,width,high,null,null);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
		return  Util.getGraphURL(fileName);
	}
	
	private void setSampleData(){
		data.setValue("1'st",380);
		data.setValue("2'st",1620);
		data.setValue("3'st",6100);
		data.setValue("4'st",8310);
		data.setValue("5'st",3520);
		data.setValue("6'st",180);
		if(this.flag_3D){
			this.setTitleText("This is Sample 3D PieChart");
		} else {
			this.setTitleText("This is Sample PieChart");
		}
		
	}
}
