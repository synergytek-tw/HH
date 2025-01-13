package deepspot.chart;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import deepspot.util.Util;

public class LineChart{
	
	public LineChart(String titleText){
		data = new DefaultCategoryDataset();
		this.titleText = titleText;
	}
	
	public LineChart(){
		data = new DefaultCategoryDataset();
	}
	
	DefaultCategoryDataset data;
	public void setData(DefaultCategoryDataset data){
		this.data = data;
	}
	public DefaultCategoryDataset getData(){
		return this.data;
	}
	
	DefaultCategoryDataset data2;
	public void setData2(DefaultCategoryDataset data){
		this.data2 = data;
	}
	public DefaultCategoryDataset getData2(){
		return this.data2;
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
	
	String yAxis2;
	public void setYAxis2(String yAxis){
		this.yAxis2 = yAxis;
	}
	public String getYAxis2(){
		return this.yAxis2;
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
		if(this.data==null || this.data.getRowCount()==0){
			return null;
		}
		JFreeChart chart;
		chart = ChartFactory.createLineChart(titleText,xAxis,yAxis,
				data,drawType,showTip,false,false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
		renderer.setShapesVisible(true);
		renderer.setShapesFilled(true);
		renderer.setBaseItemLabelsVisible(false); 
		renderer.setBaseItemLabelFont(new Font("Dialog", 1, 12));
		plot.setRenderer(renderer);
		
		if(this.data2!=null && this.data2.getRowCount()>0){
			this.setSecondPlot(plot);
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
	
	private void setSecondPlot(CategoryPlot plot){
		NumberAxis axis = new NumberAxis(this.yAxis2);
		plot.setRangeAxis(1, axis);
		plot.setRangeAxisLocation(1,AxisLocation.BOTTOM_OR_RIGHT);
		plot.setDataset(1,this.data2);
		plot.mapDatasetToRangeAxis(1,1);
		LineAndShapeRenderer renderer = new LineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.red);
		renderer.setSeriesPaint(1, Color.blue);
		plot.setRenderer(1,renderer);
	}
}