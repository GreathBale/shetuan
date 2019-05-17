package test;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

	/**
	 * 生成扇形图
	 *
	 */
	public class pieChart {
	    
	    public static void main(String[] args) {
	        //生成扇形图
	        makePieChart3D();
	    }
	    /**
	     * 获取结果集
	     * @return
	     */
	    public static DefaultPieDataset getDataset(){
	        
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        
	        dataset.setValue("卡耐基协会", 20);
	        dataset.setValue("旅游协会", 20);
	        dataset.setValue("街舞协会", 20);
	        dataset.setValue("书法协会", 20);
	        dataset.setValue("文学社", 20);
	        
	        return dataset;
	        
	    }    
	    
	    /**
	     * 生成扇形图
	     */
	    public static void makePieChart3D(){
	        
	        String title = "社团人数排名前五的社团统计图";
	        // 获得数据集   
	        DefaultPieDataset dataset = getDataset();
	        
	        // 处理中文乱码
	        StandardChartTheme chartTheme = new StandardChartTheme("CN");
	        // 标题
	        chartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));
	        // legend
	        chartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 18));
	        // 轴向字体
	        chartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 16));
	        ChartFactory.setChartTheme(chartTheme);
	        
	        JFreeChart chart = ChartFactory.createPieChart3D(
	                title, //标题
	                dataset,     // 图表数据集   
	                true,         // 是否显示图例   
	                false,         // 是否生成工具（提示）   
	                false         // 是否生成URL链接  
	                );
	        
	        // 创建图表的窗体
	        ChartFrame frame = new ChartFrame(title, chart, true);
	        // 窗体的大小设置为自适应
	        frame.pack();
	        // 设置为可见
	        frame.setVisible(true);
	    }
	}