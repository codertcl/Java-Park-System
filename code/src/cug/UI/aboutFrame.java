//显示关于菜单项中的信息
package cug.UI;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class aboutFrame extends JInternalFrame {
	private  JLabel label;
	public  aboutFrame() {
		super("关于");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//标题栏有最大化按钮
		//setIconifiable(true);	//标题栏有最小化按钮
		setClosable(true);		//标题栏有关闭按钮
		setResizable(true);		//可以改变大小
		setBounds(new Rectangle(206,76,331,300));
		JPanel Panel1 = new JPanel();	//创建中心面板
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//设置边框
		getContentPane().add(Panel1);
		label = new JLabel();
		Panel1.add(label);
		label.setText("<html>《软件综合实习》<br />  智能停车场 <br /> 小组成员:孙学勇<br />  指导老师:颜雪松<br />2021年4月15日<br /></html>");//输入显示的汉字
		setVisible(true);		
	}
}