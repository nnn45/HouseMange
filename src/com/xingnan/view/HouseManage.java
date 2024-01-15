package com.xingnan.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.xingnan.dao.HouseDao;
import com.xingnan.dao.HouseTypeDao;
import com.xingnan.model.House;
import com.xingnan.model.HouseType;
import com.xingnan.util.DbUtil;
import com.xingnan.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HouseManage extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable houseTable;
	private JTextField s_houseNameTxt;
	private JTextField s_addressTxt;
	private DbUtil dbUtil=new DbUtil();
	private HouseTypeDao houseTypeDao=new HouseTypeDao();
	private HouseDao houseDao=new HouseDao();
	private JComboBox s_houseTypeJcb;
	private JTextField idTxt;
	private JTextField houseNameTxt;
	private JTextField areaTxt;
	private JTextField priceTxt;
	private JTextArea addressTxt;
	private JTextArea houseDescTxt;
	private JComboBox houseTypeJcb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseManage frame = new HouseManage();
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
	public HouseManage() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u623F\u6E90\u7BA1\u7406");
		setBounds(100, 100, 760, 688);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6570\u636E\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u623F\u6E90\u7C7B\u578B\uFF1A");
		
		houseTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_5 = new JLabel("\u623F\u6E90\u540D\u79F0\uFF1A");
		
		houseNameTxt = new JTextField();
		houseNameTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u9762\u79EF\uFF1A");
		
		areaTxt = new JTextField();
		areaTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u5730\u5740\uFF1A");
		
		addressTxt = new JTextArea();
		addressTxt.setLineWrap(true);
		
		JLabel lblNewLabel_9 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		houseDescTxt = new JTextArea();
		houseDescTxt.setLineWrap(true);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HouseManage.class.getResource("/img/\u4FEE\u6539.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(HouseManage.class.getResource("/img/\u5220\u9664.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(areaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(houseNameTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblNewLabel_7)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(56, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(houseDescTxt, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(houseTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(84)
							.addComponent(btnNewButton_1)
							.addGap(65)
							.addComponent(btnNewButton_2)
							.addGap(185))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_6)
						.addComponent(areaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(houseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(houseDescTxt, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(houseTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u623F\u6E90\u540D\u79F0\uFF1A");
		
		s_houseNameTxt = new JTextField();
		s_houseNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5730\u5740\uFF1A");
		
		s_addressTxt = new JTextField();
		s_addressTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u623F\u6E90\u7C7B\u578B:");
		
		s_houseTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(HouseManage.class.getResource("/img/\u6570\u636E\u67E5\u8BE2.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_houseNameTxt, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_addressTxt, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_houseTypeJcb, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(18))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_houseNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_addressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_houseTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		houseTable = new JTable();
		houseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				houseTableMousePressed(e);	
			}
		});
		scrollPane.setViewportView(houseTable);
		houseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u623F\u6E90\u7C7B\u578B", "\u623F\u6E90\u540D\u79F0", "\u5730\u5740", "\u9762\u79EF", "\u4EF7\u683C", "\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		houseTable.getColumnModel().getColumn(3).setPreferredWidth(123);
		houseTable.getColumnModel().getColumn(4).setPreferredWidth(59);
		houseTable.getColumnModel().getColumn(5).setPreferredWidth(64);
		houseTable.getColumnModel().getColumn(6).setPreferredWidth(191);
		getContentPane().setLayout(groupLayout);
		fillHouseType("search");
		fillHouseType("modify");
		
		fillTable(new House());
		// �����ı���߿�
		addressTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		houseDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		
	}
	/**
	 * ���ݲ�ѯ
	 * @param e
	 */
	private void houseSearchActionPerformed(ActionEvent evt) {
		String houseName=this.s_houseNameTxt.getText();
		String address=this.s_addressTxt.getText();
		HouseType houseType=(HouseType) this.s_houseTypeJcb.getSelectedItem();
		int houseTypeId=houseType.getId();
		
		House house=new House(houseName,houseTypeId,address);
		this.fillTable(house);
	}
	
	/**
	 * ��������
	 * @param type
	 */
	private void fillHouseType(String type){
		Connection con=null;
		HouseType houseType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=houseTypeDao.list(con, new HouseType());
			if("search".equals(type)){
				houseType=new HouseType();
				houseType.setHouseTypeName("��ѡ��...");
				houseType.setId(-1);
				this.s_houseTypeJcb.addItem(houseType);
			}
			while(rs.next()){
				houseType=new HouseType();
				houseType.setHouseTypeName(rs.getString("houseTypeName"));
				houseType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_houseTypeJcb.addItem(houseType);
				}else if("modify".equals(type)){
					this.houseTypeJcb.addItem(houseType);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
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
	 * ��ʼ�����
	 * @param house
	 */
	private void fillTable(House house){
		DefaultTableModel dtm=(DefaultTableModel) houseTable.getModel();
		dtm.setRowCount(0); // ���ó�0��
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=houseDao.list(con, house);
			
			while(rs.next()){
				
				Vector v=new Vector();
				v.add(rs.getString("houseId"));
				v.add(rs.getString("houseTypeName"));
				v.add(rs.getString("houseName"));
				v.add(rs.getString("address"));
				v.add(rs.getInt("area"));
				v.add(rs.getInt("price"));
				v.add(rs.getString("houseDesc"));
				
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
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
	 * ����е��
	 * @param met
	 */
	private void houseTableMousePressed(MouseEvent met) {
		int row=this.houseTable.getSelectedRow();
		this.idTxt.setText((String)houseTable.getValueAt(row, 0));
		String houseTypeName=(String)this.houseTable.getValueAt(row, 1);
		this.houseNameTxt.setText((String)houseTable.getValueAt(row, 2));
		this.addressTxt.setText((String)houseTable.getValueAt(row, 3));
		this.areaTxt.setText((int)houseTable.getValueAt(row, 4)+"");
		this.priceTxt.setText((int)houseTable.getValueAt(row, 5)+"");
		this.houseDescTxt.setText((String)houseTable.getValueAt(row, 6));
		
		int n=this.houseTypeJcb.getItemCount();
		for(int i=0;i<n;i++){
			HouseType item=(HouseType)this.houseTypeJcb.getItemAt(i);
			if(item.getHouseTypeName().equals(houseTypeName)){
				this.houseTypeJcb.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * ��Դ�޸��¼�
	 * @param evt
	 */
	private void houseUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		
		String houseName=this.houseNameTxt.getText();
		String area=this.areaTxt.getText();
		String price=this.priceTxt.getText();
		String address=this.addressTxt.getText();
		String houseDesc=this.houseDescTxt.getText();
		
		if(StringUtil.isEmpty(houseName)){
			JOptionPane.showMessageDialog(null, "��Դ���Ʋ���Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(area)){
			JOptionPane.showMessageDialog(null, "�����������Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "���ݼ۸���Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(address)){
			JOptionPane.showMessageDialog(null, "���ݵ�ַ����Ϊ�գ�");
			return;
		}
		
		if(StringUtil.isEmpty(houseDesc)){
			JOptionPane.showMessageDialog(null, "������������Ϊ�գ�");
			return;
		}
	
		HouseType houseType = (HouseType) houseTypeJcb.getSelectedItem();
		int houseTypeId  = houseType.getId();
		House house = new House(Integer.parseInt(id),houseName, houseTypeId, address,
				Integer.parseInt(area), Integer.parseInt(price),houseDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = houseDao.update(con, house);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "��Դ��Ϣ�޸ĳɹ���");
				resetValue();
				this.fillTable(new House());
			}else {
				JOptionPane.showMessageDialog(null, "��Դ��Ϣ�޸�ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��Դ��Ϣ�޸�ʧ�ܣ�");
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
	 * ��Դɾ��
	 * @param evt
	 */
	private void houseDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=houseDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new House());
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ���ñ�
	 */
	private void resetValue(){
		this.houseNameTxt.setText("");
		this.areaTxt.setText("");
		this.priceTxt.setText("");
		this.addressTxt.setText("");
		this.houseDescTxt.setText("");
		if(this.houseTypeJcb.getItemCount()>0){
			this.houseTypeJcb.setSelectedIndex(0);
		}
	}

}
