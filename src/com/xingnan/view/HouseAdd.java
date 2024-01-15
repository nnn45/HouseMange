package com.xingnan.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;


import com.xingnan.dao.HouseDao;
import com.xingnan.dao.HouseTypeDao;
import com.xingnan.model.House;
import com.xingnan.model.HouseType;
import com.xingnan.util.DbUtil;
import com.xingnan.util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HouseAdd extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField nameTxt;
	private JTextField areaTxt;
	private JTextField priceTxt;
	private DbUtil dbUtil=new DbUtil();
	private HouseTypeDao houseTypeDao=new HouseTypeDao();
	private HouseDao houseDao=new HouseDao();
	private JComboBox houseTypeJcb;
	private JTextArea houseDescTxt;
	private JTextArea addressTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseAdd frame = new HouseAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HouseAdd() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u623F\u6E90\u6DFB\u52A0");
		setBounds(100, 100, 450, 564);
		
		JLabel lblNewLabel = new JLabel("\u623F\u6E90\u540D\u79F0\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u9762   \u79EF\uFF1A");
		
		areaTxt = new JTextField();
		areaTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7   \u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u623F\u6E90\u7C7B\u578B\uFF1A");
		
		houseTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("\u623F\u6E90\u5730\u5740\uFF1A");
		
		addressTxt = new JTextArea();
		addressTxt.setLineWrap(true);
		
		JLabel lblNewLabel_5 = new JLabel("\u57FA\u672C\u60C5\u51B5\uFF1A");
		
		houseDescTxt = new JTextArea();
		houseDescTxt.setLineWrap(true);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				houseAddActionPerformed(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(HouseAdd.class.getResource("/img/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValue();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HouseAdd.class.getResource("/img/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(houseDescTxt, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(houseTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(areaTxt, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(priceTxt)))))
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(btnNewButton)
					.addGap(47)
					.addComponent(btnNewButton_1)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(areaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(houseTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(houseDescTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(43))
		);
		getContentPane().setLayout(groupLayout);
		fillHouseType();
		// 设置文本域边框
		addressTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		houseDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}
	/**
	 * 房源添加
	 * @param arg0
	 */
	private void houseAddActionPerformed(ActionEvent arg0) {
		String houseName=this.nameTxt.getText();
		String area=this.areaTxt.getText();
		String price=this.priceTxt.getText();
		String address=this.addressTxt.getText();
		String houseDesc=this.houseDescTxt.getText();
		if(StringUtil.isEmpty(houseName)){
			JOptionPane.showMessageDialog(null, "房源名称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(area)){
			JOptionPane.showMessageDialog(null, "房屋面积不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "房屋价格不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(address)){
			JOptionPane.showMessageDialog(null, "房屋地址不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(houseDesc)){
			JOptionPane.showMessageDialog(null, "房屋描述不能为空！");
			return;
		}
		
		HouseType houseType = (HouseType) houseTypeJcb.getSelectedItem();
		int houseTypeId  = houseType.getId();
		House house = new House(houseName, houseTypeId , address,
				Integer.parseInt(area), Integer.parseInt(price), houseDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = houseDao.add(con, house);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "房屋添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "房屋添加失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "房屋添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.nameTxt.setText("");
		this.areaTxt.setText("");
		this.priceTxt.setText("");
		this.addressTxt.setText("");
		this.houseDescTxt.setText("");
		if(this.houseTypeJcb.getItemCount()>0){
			this.houseTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化房屋类别下拉框
	 */
	private void fillHouseType() {
		Connection con = null;
		HouseType houseType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs  = houseTypeDao.list(con, new HouseType());
			while(rs.next()) {
				houseType = new HouseType();
				houseType.setId(rs.getInt("id"));
				houseType.setHouseTypeName(rs.getString("houseTypeName"));
				this.houseTypeJcb.addItem(houseType);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
