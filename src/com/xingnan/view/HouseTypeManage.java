package com.xingnan.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xingnan.dao.HouseDao;
import com.xingnan.dao.HouseTypeDao;
import com.xingnan.model.HouseType;
import com.xingnan.util.DbUtil;
import com.xingnan.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class HouseTypeManage extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable houseTypeTable;
	private DbUtil dbUtil=new DbUtil();
	private HouseType houseType = new HouseType();
	private HouseDao houseDao = new HouseDao();
	private HouseTypeDao houseTypeDao = new HouseTypeDao();
	private JTextField searchHouseTypeNameTxt;
	private JTextField houseIdTxt;
	private JTextField houseTypeNameTxt;
	private JTextArea houseTypeDescTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseTypeManage frame = new HouseTypeManage();
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
	public HouseTypeManage() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u623F\u6E90\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 482, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u623F\u6E90\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		searchHouseTypeNameTxt = new JTextField();
		searchHouseTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseTypeSearchActionPerformed(e); 
			}
		});
		btnNewButton.setIcon(new ImageIcon(HouseTypeManage.class.getResource("/img/\u6570\u636E\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6570\u636E\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchHouseTypeNameTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchHouseTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		houseIdTxt = new JTextField();
		houseIdTxt.setEditable(false);
		houseIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u540D\u79F0\uFF1A");
		
		houseTypeNameTxt = new JTextField();
		houseTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		houseTypeDescTxt = new JTextArea();
		houseTypeDescTxt.setLineWrap(true);
		// 设置文本域边框
		houseTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HouseTypeManage.class.getResource("/img/\u4FEE\u6539.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				houseTypeDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(HouseTypeManage.class.getResource("/img/\u5220\u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(houseIdTxt, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(59)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(houseTypeNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(houseTypeDescTxt, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(85)
							.addComponent(btnNewButton_1)
							.addGap(54)
							.addComponent(btnNewButton_2)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(houseIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(houseTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(houseTypeDescTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		houseTypeTable = new JTable();
		houseTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				houseTypeTableMousePressed(arg0);
			}
		});
		houseTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		houseTypeTable.getColumnModel().getColumn(0).setPreferredWidth(44);
		houseTypeTable.getColumnModel().getColumn(2).setPreferredWidth(177);
		scrollPane.setViewportView(houseTypeTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new HouseType());

	}
	
	/**
	 * 数据删除
	 * @param e
	 */
	private void houseTypeDeleteActionEvent(ActionEvent evt) {
		String id=houseIdTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean flag=houseDao.existHouseByHouseTypeId(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "当前房源类别下有房源，不能删除此类别");
					return;
				}
				int deleteNum=houseTypeDao.delete(con, id);
				
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new HouseType());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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
	 * 数据修改
	 * @param e
	 */
	
	protected void houseTypeUpdateActionEvent(ActionEvent e) {
		String id = houseIdTxt.getText();
		String houseTypeName = houseTypeNameTxt.getText();
		String houseTypeDesc = houseTypeDescTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择需要修改的记录");
			return ;
			
		}
		if (StringUtil.isEmpty(houseTypeName)) {
			JOptionPane.showMessageDialog(null, "房源类别名称不可为空！！");
			return ;
			
		}
		HouseType houseType = new HouseType(Integer.parseInt(id), houseTypeName, houseTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = houseTypeDao.update(con, houseType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new HouseType());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 表格数据点击事件处理
	 */
	protected void houseTypeTableMousePressed(MouseEvent e) {
		//获取选中的行号
		int row =  houseTypeTable.getSelectedRow();
		houseIdTxt.setText((String) houseTypeTable.getValueAt(row, 0)); 
		houseTypeNameTxt.setText((String) houseTypeTable.getValueAt(row, 1));
		houseTypeDescTxt.setText((String) houseTypeTable.getValueAt(row, 2));
		
	}

	/**
	 * 房源类别搜索处理
	 * @param e
	 */
	private void houseTypeSearchActionPerformed(ActionEvent e) {
		String searchHouseTypeName = this.searchHouseTypeNameTxt.getText();
		HouseType houseType = new HouseType();
		houseType.setHouseTypeName(searchHouseTypeName);
		this.fillTable(houseType);
		
	}

	/**
	 * 初始化表格
	 * @param houseType
	 */
	private void fillTable(HouseType houseType){
		DefaultTableModel dtm=(DefaultTableModel) houseTypeTable.getModel();
		dtm.setRowCount(0); // 设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=houseTypeDao.list(con, houseType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("houseTypeName"));
				v.add(rs.getString("houseTypeDesc"));
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
	 * 重置表单
	 */
	private void resetValue(){
		this.houseIdTxt.setText(""); 
		this.houseTypeNameTxt.setText("");
		this.houseTypeDescTxt.setText("");
	}
}
