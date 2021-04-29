package cug.UI;// ��ui������ʵ�ֳ�������˵��µĳ����볡�˵���

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
    private JTextField cardidjtextfield;//�����ı���
    private JTextField caridjtextfield;//���ƺ��ı���
    private JTextField stationidjtextfield;
    private JComboBox parkTypejcombobox;
    private JButton ensurejbutton;
    private users user;

    //���췽��
    public ParkInFrame() {
        super("�����볡");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setClosable(true);        //�������йرհ�ť
        setResizable(true);        //���Ըı��С
        setBounds(136, 107, 428, 214);
        JPanel mainPanel = new JPanel();            //�����������
        GridBagLayout gridbag = new GridBagLayout();//������񲼾ֹ�����
        mainPanel.setLayout(gridbag);        //���ò���
        getContentPane().add(mainPanel);        //�����������뵽����
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;


        //���ƺű�ǩ
        JLabel caridjlabel = new JLabel();    //�������ű�ǩ
        caridjlabel.setText("���ƺţ�");//���ñ�ǩ�ı�
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(caridjlabel, c);                //��ӵ��������


        //�������ƺ��ı���
        caridjtextfield = new JTextField();
        caridjtextfield.setColumns(10);//�����ı��򳤶�
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(caridjtextfield, c);

        //��ť��ȡ�������ƺ���Ϣ
        JButton jIdButton = new JButton("ѡ����");    //ѡ����
        jIdButton.setSize(50, 50);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(jIdButton, c);                //��ӵ��������


        //Ϊ��Button���ʱ����������ڼ������м����ļ�ѡ������
        jIdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(new JLabel(), "ѡ��");
                File file = jfc.getSelectedFile();
                if (file.isDirectory()) {
                } else if (file.isFile()) {
                    String str = file.getAbsolutePath();//��ȡ�򿪵��ļ����ļ���
                    caridjtextfield.setText(cug.UI.ImageRecognition.webImage(str));
                }
            }
        });

        //���ű�ǩ
        JLabel cardidjlabel = new JLabel();    //�������ű�ǩ
        cardidjlabel.setText("���ţ�");//���ñ�ǩ�ı�
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(cardidjlabel, c);                //��ӵ��������


        //�����ı���
        cardidjtextfield = new JTextField();
        cardidjtextfield.setColumns(10);//�����ı��򳤶�
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(cardidjtextfield, c);                //��ӵ��������

        //���ó�λ�ű�ǩ�ı�
        JLabel stationidjlabel = new JLabel();
        stationidjlabel.setText("��λ�ţ�");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(stationidjlabel, c);                //��ӵ��������

        //��λ���ı���
        stationidjtextfield = new JTextField();//
        stationidjtextfield.setColumns(10);//�����ı��򳤶�
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(stationidjtextfield, c);

        //��λ���ͱ�ǩ
        JLabel parkTypejlabel = new JLabel();
        parkTypejlabel.setText("��λ���ͣ�");//���ñ�ǩ�ı�
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(parkTypejlabel, c);                //��ӵ��������

        //��λ���������б�
        parkTypejcombobox = new JComboBox();//������������������
        String[] array = new String[]{"���ͳ�λ", "С�ͳ�λ"};//���������б�
        parkTypejcombobox.setModel(new DefaultComboBoxModel(array));//����������ģ��
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(parkTypejcombobox, c);

        //ȷ���볡��ť
        ensurejbutton = new JButton();//�������水ť
        ensurejbutton.addActionListener(new parkActionListener());//ע�������
        ensurejbutton.setText("ȷ���볡");//���ð�ť�ı�
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(ensurejbutton, c);//��ӵ��������

        //�������ذ�ť
        JButton backjbutton = new JButton();
        backjbutton.addActionListener(new CloseActionListener());//ע�������
        backjbutton.setText("����");//���ð�ť�ı�
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        mainPanel.add(backjbutton, c);//��ӵ��������
        setVisible(true);                                            // ��ʾ����ɼ�
    }


    // ��ӹرհ�ť���¼�������
    class CloseActionListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            doDefaultCloseAction();
        }
    }


    // ���ȷ���볡��ť���¼�������
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
                JOptionPane.showMessageDialog(null, "�볡�ɹ���");
            else
                JOptionPane.showMessageDialog(null, "�볡ʧ�ܣ�");
        }
    }
}