//��ʾ���ڲ˵����е���Ϣ
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
		super("����");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setMaximizable(true);	//����������󻯰�ť
		//setIconifiable(true);	//����������С����ť
		setClosable(true);		//�������йرհ�ť
		setResizable(true);		//���Ըı��С
		setBounds(new Rectangle(206,76,331,300));
		JPanel Panel1 = new JPanel();	//�����������
		Panel1.setBorder(new EmptyBorder(30, 10, 50, 10));		//���ñ߿�
		getContentPane().add(Panel1);
		label = new JLabel();
		Panel1.add(label);
		label.setText("<html>������ۺ�ʵϰ��<br />  ����ͣ���� <br /> С���Ա:��ѧ��<br />  ָ����ʦ:��ѩ��<br />2021��4��15��<br /></html>");//������ʾ�ĺ���
		setVisible(true);		
	}
}