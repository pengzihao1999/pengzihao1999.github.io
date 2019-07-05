/*
 * UserUI.java
 *
 * Created on __DATE__, __TIME__
 */

package BookUI;

import javax.swing.JOptionPane;

import BookDao.BookException;
import Bookbusiness.BookBus;

/**
 *
 * @author  __USER__
 */
public class UserUI extends javax.swing.JFrame {
	public BookBus bs = new BookBus();
	/** Creates new form UserUI */
	public UserUI() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jTextField1.setForeground(new java.awt.Color(255, 153, 153));
		jTextField1
				.setText("                  \u6b22\u8fce\u6765\u5230\u7528\u6237\u754c\u9762");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel1.setText("\u4f60\u8981\u501f\u6216\u8fd8\u4e66\u7684\u7f16\u53f7\uff1a");

		jLabel3.setText("\u4f60\u7684\u7528\u6237\u540d\uff1a");

		jCheckBox1.setText("\u501f\u4e66");

		jCheckBox2.setText("\u8fd8\u4e66");

		jButton1.setText("\u786e\u8ba4");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(147,
																		147,
																		147)
																.addComponent(
																		jLabel2))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(133,
																		133,
																		133)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel1))
																.addGap(38, 38,
																		38)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						jTextField2)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						280,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(228,
																		228,
																		228)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		358,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(234, 234, 234))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(407, Short.MAX_VALUE)
								.addComponent(jCheckBox1).addGap(44, 44, 44)
								.addComponent(jCheckBox2).addGap(266, 266, 266))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(593, Short.MAX_VALUE)
								.addComponent(jButton1).addGap(179, 179, 179)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(31, 31, 31)
								.addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(77, 77, 77)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(66, 66, 66)
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(55, 55, 55)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jCheckBox1)
												.addComponent(jCheckBox2))
								.addGap(52, 52, 52).addComponent(jButton1)
								.addContainerGap(121, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String UserID= jTextField2.getText().trim();
		String BookID = jTextField3.getText().trim();
		if(jCheckBox1.isSelected()){
			Boolean flag = true;
			try {
				bs.lend(UserID,BookID);
			} catch (BookException e) {
				// TODO Auto-generated catch block
				flag = false;
				JOptionPane.showInternalMessageDialog(jButton1, "借书失败","information", JOptionPane.INFORMATION_MESSAGE); 
			}
			if(flag == true)
			JOptionPane.showInternalMessageDialog(jButton1, "借书成功","information", JOptionPane.INFORMATION_MESSAGE); 
		}
		if(jCheckBox2.isSelected()){
			bs.returnBook(UserID,BookID);
			JOptionPane.showInternalMessageDialog(jButton1, "还书成功","information", JOptionPane.INFORMATION_MESSAGE); 
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UserUI().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}