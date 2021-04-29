package cug.UI;// 该ui类用于实现车辆管理菜单下的车辆入场菜单项

import cug.DAL.Dal;
import cug.DAO.users;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class ParkInFrame extends JInternalFrame {
    private JTextField cardidjtextfield;//卡号文本框
    private JTextField caridjtextfield;//车牌号文本框
    private JTextField stationidjtextfield;
    private JComboBox parkTypejcombobox;
    private JButton ensurejbutton;
    private users user;

    //构造方法
    public ParkInFrame() {
        super("车辆入场");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setClosable(true);        //标题栏有关闭按钮
        setResizable(true);        //可以改变大小
        setBounds(136, 107, 428, 214);
        JPanel mainPanel = new JPanel();            //创建中心面板
        GridBagLayout gridbag = new GridBagLayout();//创建表格布局管理器
        mainPanel.setLayout(gridbag);        //设置布局
        getContentPane().add(mainPanel);        //将中心面板加入到窗体
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;


        //车牌号标签
        JLabel caridjlabel = new JLabel();    //创建卡号标签
        caridjlabel.setText("车牌号：");//设置标签文本
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(caridjlabel, c);                //添加到中心面板


        //创建车牌号文本框
        caridjtextfield = new JTextField();
        caridjtextfield.setColumns(10);//设置文本框长度
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(caridjtextfield, c);

        //按钮获取车辆车牌号信息
        JButton jIdButton = new JButton("选择车辆");    //选择车辆
        jIdButton.setSize(50, 50);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(jIdButton, c);                //添加到中心面板


        //为该Button添加时间监听器，在监听器中加入文件选择器：
        jIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(new JLabel(), "选择");
                File file = jfc.getSelectedFile();
                if (file.isDirectory()) {
                } else if (file.isFile()) {
                    String str = file.getAbsolutePath();//获取打开的文件的文件名
                    caridjtextfield.setText(cug.UI.ImageRecognition.webImage(str));
                }
            }
        });

        //卡号标签
        JLabel cardidjlabel = new JLabel();    //创建卡号标签
        cardidjlabel.setText("卡号：");//设置标签文本
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(cardidjlabel, c);                //添加到中心面板


        //卡号文本框
        cardidjtextfield = new JTextField();
        cardidjtextfield.setColumns(10);//设置文本框长度
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(cardidjtextfield, c);                //添加到中心面板

        //设置车位号标签文本
        JLabel stationidjlabel = new JLabel();
        stationidjlabel.setText("车位号：");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(stationidjlabel, c);                //添加到中心面板

        //车位号文本框
        stationidjtextfield = new JTextField();//
        stationidjtextfield.setColumns(10);//设置文本框长度
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(stationidjtextfield, c);

        //车位类型标签
        JLabel parkTypejlabel = new JLabel();
        parkTypejlabel.setText("车位类型：");//设置标签文本
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(parkTypejlabel, c);                //添加到中心面板

        //车位类型下拉列表
        parkTypejcombobox = new JComboBox();//创建卡的类型下拉框
        String[] array = new String[]{"大型车位", "小型车位"};//卡的类型列表
        parkTypejcombobox.setModel(new DefaultComboBoxModel(array));//设置下拉框模型
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(parkTypejcombobox, c);

        //确认入场按钮
        ensurejbutton = new JButton();//创建保存按钮
        ensurejbutton.addActionListener(new parkActionListener());//注册监听器
        ensurejbutton.setText("确认入场");//设置按钮文本
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(ensurejbutton, c);//添加到中心面板

        //创建返回按钮
        JButton backjbutton = new JButton();
        backjbutton.addActionListener(new CloseActionListener());//注册监听器
        backjbutton.setText("返回");//设置按钮文本
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(backjbutton, c);//添加到中心面板
        setVisible(true);                                            // 显示窗体可见
    }


    // 添加关闭按钮的事件监听器
    class CloseActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            doDefaultCloseAction();
        }
    }


    // 添加确认入场按钮的事件监听器
    class parkActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            String a1 = cardidjtextfield.getText();
            int a2 = Integer.parseInt(stationidjtextfield.getText());
            String a3 = (String) parkTypejcombobox.getSelectedItem();
            SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String a4 = myfmt.format(new java.util.Date()).toString();
            String a5 = caridjtextfield.getText();

            int i = Dal.parkin(a1, a2, a3, a4, a5);
            if (i == 1)
                JOptionPane.showMessageDialog(null, "入场成功！");
            else
                JOptionPane.showMessageDialog(null, "入场失败！");
        }
    }
}