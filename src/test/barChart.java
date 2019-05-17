package test;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class barChart {
    public static void main(String[] args) {
        //生成柱形图
        makeBarChart3D();
    }
    /**
     * 获取结果集
     * @return
     */
    public static DefaultCategoryDataset getDataset(){
        
    	DefaultCategoryDataset  dataset = new  DefaultCategoryDataset();
        
        dataset.addValue(3.0, "", "诗歌协会");   
        dataset.addValue(4.0, "", "书法协会");   
        dataset.addValue(5.0, "", "文学社");   
        dataset.addValue(5.0, "", "IT社团");   
        dataset.addValue(6.0, "", "dato竞技协会");          
        return dataset;       
    }
        
    /**
     * 生成柱形图
     */
    public static void makeBarChart3D(){
        
        String title = "活动数排名前五的社团统计柱形图";
        // 获得数据集   
        DefaultCategoryDataset  dataset = getDataset();
        
        // 处理中文乱码
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        // 标题
        chartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));
        // legend
        chartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 12));
        // 轴向字体
        chartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 14));
        
        ChartFactory.setChartTheme(chartTheme);

        
        JFreeChart chart = ChartFactory.createBarChart3D(
        		 "活动数排名前五的社团统计柱形图", // 图表标题                       
        		 "社团", // 目录轴的显示标签                       
        		 "活动数", // 数值轴的显示标签                        
        		 dataset, // 数据集                       
        		 PlotOrientation.VERTICAL, // 图表方向，此处为垂直方向                        
        		 // PlotOrientation.HORIZONTAL, //图表方向，此处为水平方向                      
        		 true, // 是否显示图例                       
        		 true, // 是否生成工具                        
        		 false // 是否生成URL链接  
                );
        
        // 创建图表的窗体
        ChartFrame frame = new ChartFrame(title, chart, true);
        chart.setBackgroundPaint(ChartColor.WHITE); 
        // 窗体的大小设置为自适应
        frame.pack();
        // 设置为可见
        frame.setVisible(true);
    }
}
