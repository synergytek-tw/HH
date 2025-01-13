package deepspot.chart;

import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import deepspot.util.Util;

public class BarChart{
	
	public BarChart(String titleText){
		data = new DefaultCategoryDataset();
		this.titleText = titleText;
	}
	
	public BarChart(){
		data = new DefaultCategoryDataset();
	}
	
	DefaultCategoryDataset data;
	public void setData(DefaultCategoryDataset data){
		this.data = data;
	}
	public DefaultCategoryDataset getData(){
		return this.data;
	}
	
	boolean showTip = true;
	public void setShowTip(boolean showTip){
		this.showTip = showTip;
	}
	public boolean ShowTip(){
		return this.showTip;
	}
	
	boolean flag_3D = false;
	public void set3DFlag(boolean flag_3D){
		this.flag_3D = flag_3D;
	}
	public boolean get3DFlag(){
		return this.flag_3D;
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
	
	String xAxis;
	public void setXAxis(String xAxis){
		this.xAxis = xAxis;
	}
	public String getXAxis(){
		return this.xAxis;
	}
	
	String yAxis;
	public void setYAxis(String yAxis){
		this.yAxis = yAxis;
	}
	public String getYAxis(){
		return this.yAxis;
	}
	
	PlotOrientation drawType = PlotOrientation.VERTICAL;
	public void setDrawType(String drawType){
		if(drawType.equals("HORIZONTAL")){
			this.drawType = PlotOrientation.HORIZONTAL;
		} else {
			this.drawType = PlotOrientation.VERTICAL;
		}
	}
	
	public String genChart(){
		if(data==null || data.getRowCount()==0){
			this.setSampleData();
		}
		JFreeChart chart;
		if(this.flag_3D){
			chart = ChartFactory.createBarChart3D(titleText,xAxis,yAxis,
					data,drawType,showTip,false,false);
		} else {
			chart = ChartFactory.createBarChart(titleText,xAxis,yAxis,
					data,drawType,showTip,false,false);
		}
		/* BarChart Color set */
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
		
		CategoryPlot categoryplot = chart.getCategoryPlot();
		
		categoryplot.setDrawingSupplier(new DefaultDrawingSupplier(sPaint,
				 DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
				 DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
				 DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
				 DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
		/* set don't draw barcharOutline */
		BarRenderer renderer = (BarRenderer) categoryplot.getRenderer();
		renderer.setDrawBarOutline(false);
		categoryplot.setRenderer(renderer);
		
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
		if(this.flag_3D){
			this.setTitleText("This is Sample 3D BarChart");
		} else {
			this.setTitleText("This is Sample BarChart");
		}
		this.setXAxis("Year");
		this.setYAxis("Qty");
		String[] xAxisData = {"JAN", "FEB", "MAR", "APE", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
		Number[][] dataSet ={
				{new Integer(120),new Integer(138),new Integer(230),new Integer(243),new Integer(300),new Integer(120),
				new Integer(300),new Integer(300),new Integer(300),new Integer(67),new Integer(124),new Integer(134)},
				{new Integer(98),new Integer(138),new Integer(280),new Integer(234),new Integer(158),new Integer(256),
				new Integer(300),new Integer(300),new Integer(120),new Integer(231),new Integer(125),new Integer(98)},
				{new Integer(34),new Integer(138),new Integer(230),new Integer(276),new Integer(253),new Integer(192),
				new Integer(300),new Integer(300),new Integer(340),new Integer(300),new Integer(213),new Integer(123)}
				};
		String[] year ={"2000","2001","2002"};
		data = new DefaultCategoryDataset();
		for (int i=0; i<year.length; i++){
			for (int j=0; j<xAxisData.length; j++){
			    data.addValue(dataSet[i][j],xAxisData[j],year[i]);
			}
		}
	}
}