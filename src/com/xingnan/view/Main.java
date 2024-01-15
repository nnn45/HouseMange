package com.xingnan.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	
	private JPanel contentPane;
	private JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatDarkLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("\u623F\u6E90\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("\u623F\u6E90\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		mnNewMenu_2.setIcon(new ImageIcon(Main.class.getResource("/img/\u623F\u7C7B\u522B.png")));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u623F\u6E90\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseTypeAdd houseTypeAdd = new HouseTypeAdd();
				houseTypeAdd.setVisible(true);
				table.add(houseTypeAdd);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(Main.class.getResource("/img/\u6DFB\u52A0.png")));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u623F\u6E90\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseTypeManage houseTypeManage = new HouseTypeManage();
				houseTypeManage.setVisible(true);
				table.add(houseTypeManage);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(Main.class.getResource("/img/\u6570\u636E\u7EF4\u62A4.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("\u623F\u6E90\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.setIcon(new ImageIcon(Main.class.getResource("/img/\u623F\u7BA1\u7406.png")));
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u623F\u6E90\u4FE1\u606F\u6DFB\u52A0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HouseAdd houseAdd = new HouseAdd();
				houseAdd.setVisible(true);
				table.add(houseAdd);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(Main.class.getResource("/img/\u6DFB\u52A0.png")));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u623F\u6E90\u4FE1\u606F\u7EF4\u62A4");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HouseManage houseManage = new HouseManage();
				houseManage.setVisible(true);
				table.add(houseManage);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(Main.class.getResource("/img/\u6570\u636E\u7EF4\u62A4.png")));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u64CD\u4F5C");
		mnNewMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\u6570\u636E.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u9000\u51FA\u767B\u5F55");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出登录");
				if(result==0){
					dispose();
					new Login().setVisible(true);
				}
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(Main.class.getResource("/img/\u9000\u51FA.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u623F\u5C4B\u7C7B\u578B");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/\u4E3B\u754C\u9762\u80CC\u666F.png")));
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel)
		);
		table.setLayout(gl_table);
		
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
