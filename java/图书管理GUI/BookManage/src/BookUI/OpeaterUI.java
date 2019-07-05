/*
 * OpeaterUI.java
 *
 * Created on __DATE__, __TIME__
 */

package BookUI;

import java.awt.DisplayMode;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import BookDomain.Book;
import Bookbusiness.BookBus;

/**
 *
 * @author  __USER__
 */
public class OpeaterUI extends javax.swing.JFrame {
	public BookBus bus = new BookBus();
	public DefaultTableModel dt = new DefaultTableModel(new Object[][] { { null, null, null, null,null },
	 }, new String[] { "图书的ID",
	"图书的名称", "图书的出版社", "图书的作者","剩余量" });
	/** Creates new form OpeaterUI */
	public OpeaterUI() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel7 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel1.setText("                    \u6b22\u8fce\u4f60\uff01\u7ba1\u7406\u5458");

		jLabel2.setText("\u56fe\u4e66\u7684ID");

		jLabel3.setText("\u56fe\u4e66\u7684\u540d\u79f0");

		jLabel4.setText("\u56fe\u4e66\u7684\u51fa\u7248\u793e");

		jLabel5.setText("\u56fe\u4e66\u7684\u4f5c\u8005");

		jLabel6.setText("\u56fe\u4e66\u7684\u5269\u4f59\u91cf");
		
		jTable1.setModel(dt);
		jTable1.setAutoscrolls(false);
		jScrollPane1.setViewportView(jTable1);

		jLabel7.setFont(new java.awt.Font("楷体", 0, 24));
		jLabel7.setText("\u56fe\u4e66\u4fe1\u606f\u8868");

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"修改图书", "删除图书", "新增图书" }));
		jComboBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox2ActionPerformed(evt);
			}
		});

		jButton1.setText("\u786e\u5b9a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(143, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5)
												.addComponent(jLabel2))
								.addGap(25, 25, 25)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jTextField1)
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														74, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jLabel6))
								.addGap(31, 31, 31)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(jTextField2)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														100, Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(43, 43,
																		43)
																.addComponent(
																		jComboBox2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(61, 61,
																		61)
																.addComponent(
																		jLabel4)))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														102,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton1))
								.addGap(151, 151, 151))
				.addGroup(
						layout.createSequentialGroup().addGap(402, 402, 402)
								.addComponent(jLabel7)
								.addContainerGap(432, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(225, 225, 225)
								.addComponent(jLabel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										534, Short.MAX_VALUE)
								.addGap(195, 195, 195))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(134, 134, 134)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										693,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(127, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(36, 36, 36)
								.addComponent(jLabel1)
								.addGap(64, 64, 64)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(jLabel3)
												.addComponent(jLabel2)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(58, 58, 58)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(jLabel6)
												.addComponent(jButton1)
												.addComponent(
														jComboBox2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jLabel7)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Book b = new Book();
		b.setBookID(jTextField1.getText().trim());
		b.setBookName(jTextField2.getText().trim());
		b.setBookPublish(jTextField3.getText().trim());
		b.setBookAuthor(jTextField4.getText().trim());
		b.setBookNumber(jTextField5.getText().trim());
		String s = jComboBox2.getSelectedItem().toString();
		if(s.equals("修改图书")){
			bus.update(b);
			
			System.out.println("调用修改");
		}if(s.equals("删除图书")){
			bus.delete(b);
			
			System.out.println("调用删除");
		}if(s.equals("新增图书")){
			System.out.println("调用新增");
			bus.add(b);
		}
			 List booklist = bus.queryAll();
			 System.out.println("查询全部信息");
			 //然后把booklist的数据全部显示到Jtable中
			 removejtable();
			 display(booklist);
			 
	}


	private void removejtable() {
		int count = dt.getRowCount();
		for(int i=0;i<count;i++){
			dt.removeRow(0);
		}
		
	}

	private void display(List booklist) {
		for(int i=0;i<booklist.size();i++){
			Book b = (Book)booklist.get(i);
			dt.addRow(new Object[] { b.getBookID(),b.getBookName(),b.getBookPublish(),b.getBookAuthor(),b.getBookNumber()});

		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OpeaterUI().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	// End of variables declaration//GEN-END:variables

}