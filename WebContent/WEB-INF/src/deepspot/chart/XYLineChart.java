package deepspot.chart;

import java.awt.Font;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import deepspot.util.Util;

public class XYLineChart{
	
	public XYLineChart(String titleText){
		data = new XYSeriesCollection();
		this.titleText = titleText;
	}
	
	public XYLineChart(){
		data = new XYSeriesCollection();
	}
	
	XYSeriesCollection data;
	public void setData(XYSeriesCollection data){
		this.data = data;
	}
	public XYSeriesCollection getData(){
		return this.data;
	}
	
	boolean showTip = true;
	public void setShowTip(boolean showTip){
		this.showTip = showTip;
	}
	public boolean ShowTip(){
		return this.showTip;
	}
	
	int high = 600;
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
	
	@SuppressWarnings("deprecation")
	public String genChart(){
		if(data==null || data.getSeriesCount()==0){
			this.setSampleData();
		}
		JFreeChart chart;
		chart = ChartFactory.createXYLineChart(titleText,xAxis,yAxis,
				data,drawType,showTip,false,false);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
		renderer.setShapesVisible(true);
		renderer.setShapesFilled(true);
		// show Num Label
		renderer.setBaseItemLabelsVisible(false); 
		renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		renderer.setBaseItemLabelFont(new Font("Dialog", 1, 12));
		plot.setRenderer(renderer);
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
		this.setTitleText("This is Sample XYLineChart");
		this.setXAxis("inch");
		this.setYAxis("$");
		XYSeries s1 = new XYSeries("LCD TV");
		s1.add(30, 29000);
		s1.add(40, 48000);
		s1.add(50, 87000);
		s1.add(60, 198000);
		s1.add(70, 347000);
		data.addSeries(s1);
		
		XYSeries s2 = new XYSeries("LED TV");
		s2.add(30, 45000);
		s2.add(40, 72000);
		s2.add(50, 138000);
		s2.add(60, 359000);
		s2.add(70, 699000);
		data.addSeries(s2);
		
		XYSeries s3 = new XYSeries("DLP TV");
		s3.add(30, 18000);
		s3.add(40, 27000);
		s3.add(50, 65800);
		s3.add(60, 99900);
		s3.add(70, 189900);
		data.addSeries(s3);
	}
}