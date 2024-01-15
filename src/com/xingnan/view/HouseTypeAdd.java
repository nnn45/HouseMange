package com.xingnan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.xingnan.dao.HouseTypeDao;
import com.xingnan.model.HouseType;
import com.xingnan.util.DbUtil;
import com.xingnan.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class HouseTypeAdd extends JInternalFrame {

	
	private JTextField houseTypeNameTxt;
	private JTextArea houseTypeDescTxt;
	private DbUtil dbUtil=new DbUtil();
	private HouseTypeDao houseTypeDao=new HouseTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseTypeAdd frame = new HouseTypeAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 */
	public HouseTypeAdd() {
		
		setIconifiable(true);
		setClosable(true);
		setTitle("\u623F\u5C4B\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 527, 382);
		
		
		JLabel lblNewLabel = new JLabel("\u623F\u5C4B\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u623F\u5C4B\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		houseTypeNameTxt = new JTextField();
		houseTypeNameTxt.setColumns(10);
		
		houseTypeDescTxt = new JTextArea();
		houseTypeDescTxt.setLineWrap(true);
		
		JButton resetHouseTypeButton = new JButton("\u6DFB\u52A0");
		resetHouseTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseTypeAddActionPerformed(e);
			}
		});
		resetHouseTypeButton.setIcon(new ImageIcon(HouseTypeAdd.class.getResource("/img/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HouseTypeAdd.class.getResource("/img/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(houseTypeDescTxt)
						.addComponent(houseTypeNameTxt, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(resetHouseTypeButton)
					.addGap(72)
					.addComponent(btnNewButton_1)
					.addGap(137))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(houseTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(houseTypeDescTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetHouseTypeButton)
						.addComponent(btnNewButton_1))
					.addGap(69))
		);
		getContentPane().setLayout(groupLayout);
		// 设置文本域边框
		houseTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}


	/**
	 * 房屋类别添加事件处理
	 * @param e
	 */
	private void houseTypeAddActionPerformed(ActionEvent evt) {
		String houseTypeName=this.houseTypeNameTxt.getText();
		String houseTypeDesc=this.houseTypeDescTxt.getText();
		if(StringUtil.isEmpty(houseTypeName)){
			JOptionPane.showMessageDialog(null, "房屋类别名称不能为空！");
			return;
		}
		HouseType houseType=new HouseType(houseTypeName,houseTypeDesc);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=houseTypeDao.add(con, houseType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "房屋类别添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "房屋类别添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "房屋类别添加失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.houseTypeNameTxt.setText("");
		this.houseTypeDescTxt.setText("");
	}
}
