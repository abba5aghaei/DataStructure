//INOG
package ir.abba5aghaei;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

//@author abba5aghaei

public class Main extends JFrame {
	
	private static final long serialVersionUID = -8521630415200340600L;
	private Vector<String> stackObject = new Vector<String>();
	private Vector<String> queueObject = new Vector<String>();
	private LinkedList l = new LinkedList();
	private StackList s = new StackList();
	private Queue q = new Queue();
	private BinarySearchTree BST = new BinarySearchTree();
	private JTree tree;
	private DefaultTreeModel model;
	private DefaultMutableTreeNode root;
	private int counter, parent, index = 1, resetC = 0, resetP = 0;
	private JTextField qInsertData, qReturn, stackData, stackReturn, treeData, treeRemoveIndex, searchValue;
	//private File[] musicFile;
	//private Clip clip;
	//private AudioInputStream music;
	//private Random random;
	private boolean flagNext = true, flagRoot = true;
	private Vector<DefaultMutableTreeNode> treeNode = new Vector<DefaultMutableTreeNode>();
	@SuppressWarnings("unused")
	private FrameAbout aboutFrame;
	static Vector<String> treeObject = new Vector<String>();
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				
				try {
					Main main = new Main();
					main.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}}});
		}
	@SuppressWarnings({ "rawtypes", "serial" })
	public Main() {
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(
		//Main.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("Data Structures");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 70, 850, 500);
		setResizable(false);
		setUndecorated(true);
		
		/*musicFile = new File[3];
		musicFile[0] = new File("Data/harpy_01.wav");
		musicFile[1] = new File("Data/harpy_02.wav");
		musicFile[2] = new File("Data/harpy_03.wav");
		
		random = new Random();
		
		try {
			music = AudioSystem.getAudioInputStream(musicFile[random.nextInt(3)]);
			
			clip = AudioSystem.getClip();
			
			clip.open(music);
			
			clip.start();
			
		} catch (UnsupportedAudioFileException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		}*/
		
		Color mainColor = new Color(170, 170, 170);
		
		Container pane = getContentPane();
		pane.setBackground(mainColor);
		pane.setLayout(null);
		
		JToolBar bar = new JToolBar();
		bar.setBounds(0, 0, 850, 30);
		bar.setFloatable(false);
		bar.setLayout(null);
		pane.add(bar);
		
		JLabel title = new JLabel("Data Structures");
		title.setBounds(10, 10, 100, 10);
		bar.add(title);

		/*JToggleButton mute = new JToggleButton();
		mute.setBounds(741, 5, 23, 23);
		mute.setIcon(new ImageIcon(
		Main.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMuteDisabled.png")));
		mute.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				if(mute.isSelected())
					clip.stop();
				
				else if(!mute.isSelected())
					clip.start();
			}});
		bar.add(mute);*/
		
		JButton about = new JButton("?");
		about.setFont(new Font("Tohama", Font.PLAIN, 18));
		about.setBounds(765, 5, 23, 23);
		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				aboutFrame = new FrameAbout();
			}
		});
		bar.add(about);
				
		JButton min = new JButton("-");
		min.setBounds(790, 5, 23, 23);
		//min.setIcon(new ImageIcon(
		//Main.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		min.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				setExtendedState(ICONIFIED);
			}
		});
		bar.add(min);
		
		JButton close = new JButton("X");
		close.setBounds(815, 5, 23, 23);
		//close.setIcon(new ImageIcon(
		//Main.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				int r = JOptionPane.showConfirmDialog(
				null, "Are you sure to Exit?", "Exiting...", JOptionPane.YES_NO_OPTION);
				
				if(r == 0)
					System.exit(0);
			}
		});
		bar.add(close);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(mainColor);
		tabbedPane.setBounds(10, 31, 824, 449);
		pane.add(tabbedPane);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(mainColor);
		tabbedPane.addTab("Linked List", null, listPanel, null);
		listPanel.setLayout(null);
		
		JTextArea draw = new JTextArea();
		draw.setEditable(false);
		draw.setColumns(10);
		draw.setLineWrap(true);
		draw.setWrapStyleWord(true);
		draw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		draw.setBackground(Color.BLACK);
		draw.setForeground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(draw);
		scrollPane.setBounds(10, 10, 825, 300);
		listPanel.add(scrollPane);
		
		JPanel options = new JPanel();
		options.setBackground(Color.lightGray);
		options.setBounds(40, 320, 420, 40);
		options.setLayout(null);
		listPanel.add(options);
		
		Font font = new Font("Tahoma", Font.PLAIN, 12);
		
		JLabel lblInsert = new JLabel("Insert Node");
		lblInsert.setFont(font);
		lblInsert.setBounds(10, 11, 99, 14);
		options.add(lblInsert);
		
		JLabel lblInsertIndex = new JLabel("at");
		lblInsertIndex.setFont(font);
		lblInsertIndex.setBounds(187, 11, 20, 14);
		options.add(lblInsertIndex);
		
		JTextField InsertIndex = new JTextField("End");
		InsertIndex.setBounds(200, 9, 100, 20);
		InsertIndex.setBackground(Color.lightGray);
		options.add(InsertIndex);
		InsertIndex.setColumns(10);
		
		JTextField InsertData = new JTextField();
		InsertData.setBounds(75, 9, 110, 20);
		InsertData.setBackground(Color.lightGray);
		InsertData.addKeyListener(new KeyListener() {

			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter") || ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Insert") )
				{
					l.AddNode(InsertData.getText(), InsertIndex.getText(), l.head);
					
					l.Traverse(l.head);
					
					InsertData.setText("");
					
					draw.setText(l.result);
					
					if(!l.flag)
						JOptionPane.showMessageDialog(
						null, l.status, "Eror", JOptionPane.INFORMATION_MESSAGE);
					
					l.result = "";
				}
			}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		
		options.add(InsertData);
		
		JButton Insert = new JButton("Insert");
		Insert.setBounds(310, 8, 89, 23);
		Insert.setBackground(Color.lightGray);
		Insert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				l.AddNode(InsertData.getText(), InsertIndex.getText(), l.head);
				
				l.Traverse(l.head);
				
				InsertData.setText("");
				
				draw.setText(l.result);
				
				if(!l.flag)
					JOptionPane.showMessageDialog(
					null, l.status, "Eror", JOptionPane.INFORMATION_MESSAGE);
				
				l.result = "";
			}
		});
		options.add(Insert);
		
		JPanel option2 = new JPanel();
		option2.setBackground(Color.lightGray);
		option2.setBounds(490, 320, 310, 40);
		option2.setLayout(null);
		listPanel.add(option2);
		
		JTextField RemoveIndex = new JTextField();
		RemoveIndex.setBounds(88, 11, 100, 20);
		RemoveIndex.setBackground(Color.lightGray);
		RemoveIndex.addKeyListener(new KeyListener() {

			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Delete") )
				{
					l.RemoveNode(RemoveIndex.getText(), l.head);
					
					l.Traverse(l.head);
					
					RemoveIndex.setText("");
					
					draw.setText(l.result);
					
					if(!l.flag)
						JOptionPane.showMessageDialog(
						null, l.status, "Eror", JOptionPane.INFORMATION_MESSAGE);

					l.result = "";
				}
			}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		
		option2.add(RemoveIndex);
		
		JLabel lblRemove = new JLabel("Remove from:");
		lblRemove.setFont(font);
		lblRemove.setBounds(10, 9, 82, 20);
		option2.add(lblRemove);
		
		JButton Remove = new JButton("Remove");
		Remove.setBounds(200, 9, 89, 23);
		Remove.setBackground(Color.lightGray);
		Remove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				l.RemoveNode(RemoveIndex.getText(), l.head);
				
				l.Traverse(l.head);
				
				RemoveIndex.setText("");
				
				draw.setText(l.result);
				
				if(!l.flag)
					JOptionPane.showMessageDialog(
					null, l.status, "Eror", JOptionPane.INFORMATION_MESSAGE);

				l.result = "";
			}
		});
		option2.add(Remove);
		
		JPanel queuePanel = new JPanel();
		queuePanel.setBackground(mainColor);
		tabbedPane.addTab("Queue", null, queuePanel, null);
		queuePanel.setLayout(null);
		
		JScrollPane qScroll = new JScrollPane();
		qScroll.setBounds(99, 132, 601, 93);
		queuePanel.add(qScroll);
		
		JList qList = new JList();
		qList.setBackground(Color.BLACK);
		qList.setForeground(Color.WHITE);
		qList.setVisibleRowCount(1);
		qList.setFont(new Font("Tahoma", Font.PLAIN, 40));
		qList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		qScroll.setViewportView(qList);
		
		JLabel lblQueueSpace = new JLabel("Queue Space");
		lblQueueSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQueueSpace.setBounds(320, 90, 125, 31);
		queuePanel.add(lblQueueSpace);
		
		qInsertData = new JTextField();
		qInsertData.setBackground(Color.LIGHT_GRAY);
		qInsertData.setBounds(398, 236, 150, 30);
		qInsertData.addKeyListener(new KeyListener() {

			@SuppressWarnings({ "static-access", "unchecked" })
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter") || ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Insert") )
				{
					q.insert(qInsertData.getText());
					
					queueObject.addElement("|"+qInsertData.getText());
					
					qList.setListData(queueObject);
					
					qInsertData.setText("");
				}
				else if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Delete") )
				{
					try {
						
						qReturn.setText((String) q.remove());
						
						queueObject.removeElementAt(0);
						
						qList.setListData(queueObject);
					}
					catch (Exception e) {
						
						JOptionPane.showMessageDialog(
						null, "Queue is Empty", "Eror", JOptionPane.INFORMATION_MESSAGE);
					}
			}}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		
		queuePanel.add(qInsertData);
		qInsertData.setColumns(10);
		
		qReturn = new JTextField();
		qReturn.setEditable(false);
		qReturn.setBackground(Color.LIGHT_GRAY);
		qReturn.setColumns(10);
		qReturn.setBounds(398, 285, 150, 30);
		queuePanel.add(qReturn);
		
		JButton qInsert = new JButton("Insert");
		qInsert.setBackground(Color.LIGHT_GRAY);
		qInsert.setBounds(262, 232, 111, 38);
		qInsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent ae) {
				
				q.insert(qInsertData.getText());
				
				queueObject.addElement("|"+qInsertData.getText());
				
				qList.setListData(queueObject);
				
				qInsertData.setText("");
			}
		});
		queuePanel.add(qInsert);
		
		JButton qRemove = new JButton("Remove");
		qRemove.setBackground(Color.LIGHT_GRAY);
		qRemove.setBounds(262, 281, 111, 38);
		qRemove.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent ae) {
				
				try {
					
					qReturn.setText((String) q.remove());
					
					queueObject.removeElementAt(0);
					
					qList.setListData(queueObject);
				}
				catch (Exception e) {
					
					JOptionPane.showMessageDialog(
					null, "Queue is Empty", "Eror", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		queuePanel.add(qRemove);
		
		JPanel stackPanel = new JPanel();
		stackPanel.setBackground(mainColor);
		tabbedPane.addTab("Stack", null, stackPanel, null);
		stackPanel.setLayout(null);
		
		JScrollPane stackScroll = new JScrollPane();
		stackScroll.setBounds(294, 67, 214, 264);
		stackPanel.add(stackScroll);
		
		JList stackList = new JList();
		stackList.setForeground(Color.WHITE);
		stackList.setBackground(Color.BLACK);
		stackList.setFont(new Font("Tahoma", Font.PLAIN, 30));
		stackScroll.setViewportView(stackList);
		
		JLabel lblStack = new JLabel("Stack");
		lblStack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStack.setBounds(370, 35, 53, 26);
		stackPanel.add(lblStack);
		
		stackData = new JTextField();
		stackData.setBackground(Color.LIGHT_GRAY);
		stackData.setBounds(394, 339, 114, 30);
		stackData.addKeyListener(new KeyListener() {

			@SuppressWarnings({ "static-access", "unchecked" })
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter") || ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Insert") )
				{
					s.push(stackData.getText());
					
					stackObject.addElement(stackData.getText());
					
					stackList.setListData(stackObject);
					
					stackData.setText("");
				}
				else if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Delete") )
				{
					try {
						stackReturn.setText((String) s.pop());
						
						stackObject.removeElement(stackObject.lastElement());
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(
						null, "Stack is Empty", "Eror", JOptionPane.INFORMATION_MESSAGE);
					}
					stackList.setListData(stackObject);
				}}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		stackPanel.add(stackData);
		stackData.setColumns(10);
		
		stackReturn = new JTextField();
		stackReturn.setEditable(false);
		stackReturn.setBackground(Color.LIGHT_GRAY);
		stackReturn.setColumns(10);
		stackReturn.setBounds(394, 380, 114, 30);
		stackPanel.add(stackReturn);
		
		JButton stackPush = new JButton("Push");
		stackPush.setBackground(Color.LIGHT_GRAY);
		stackPush.setBounds(294, 339, 90, 30);
		stackPush.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent ae) {
				
				s.push(stackData.getText());
				
				stackObject.addElement(stackData.getText());
				
				stackList.setListData(stackObject);
				
				stackData.setText("");
			}
		});
		stackPanel.add(stackPush);
		
		JButton stackPop = new JButton("Pop");
		stackPop.setBackground(Color.LIGHT_GRAY);
		stackPop.setBounds(294, 380, 90, 30);
		stackPop.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent ae) {
				
				try {
					stackReturn.setText((String) s.pop());
					
					stackObject.removeElement(stackObject.lastElement());
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(
					null, "Stack is Empty", "Eror", JOptionPane.INFORMATION_MESSAGE);
				}
				stackList.setListData(stackObject);
			}
		});
		stackPanel.add(stackPop);
		
		JPanel treePanel = new JPanel();
		treePanel.setBackground(mainColor);
		tabbedPane.addTab("Tree", null, treePanel, null);
		treePanel.setLayout(null);
		
		JScrollPane treeScroll = new JScrollPane();
		treeScroll.setBounds(60, 40, 466, 340);
		treePanel.add(treeScroll);
		
		tree = new JTree();
		tree.setBackground(Color.BLACK);
		tree.setForeground(Color.WHITE);
		treeScroll.setViewportView(tree);
		
		model = new DefaultTreeModel(new DefaultMutableTreeNode("Empty") {{}});
		
		root = (DefaultMutableTreeNode) model.getRoot();
		counter = 0;
		parent = 0;
		treeNode.addElement(root);
		tree.setModel(model);
		
		JScrollPane traversalScroll = new JScrollPane();
		traversalScroll.setBounds(559, 220, 227, 160);
		treePanel.add(traversalScroll);
		
		JTextArea traversal = new JTextArea();
		traversal.setBackground(Color.BLACK);
		traversal.setForeground(Color.WHITE);
		traversal.setFont(UIManager.getFont("FileChooser.listFont"));
		traversal.setLineWrap(true);
		traversal.setWrapStyleWord(true);
		traversalScroll.setViewportView(traversal);
		
		treeData = new JTextField();
		treeData.setBackground(Color.LIGHT_GRAY);
		treeData.setBounds(656, 45, 114, 25);
		treeData.addKeyListener(new KeyListener() {

			@SuppressWarnings({ "static-access" })
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter") || ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Insert") )
				{
					if(BST.insert(treeData.getText())){ 
						traversal.setText(traversal.getText()+"\n"+treeData.getText()+" inserted to BST");
						
						if(flagRoot) {
							root.setUserObject(treeData.getText());
							
							model.reload();
							
							flagRoot = false;
						}
						else {
						BST.display();
						
						flagNext = (counter%2 == 0);
						
						root = setTree();
						
						index =0;
						
						separator(root);
						
						model.reload();
						}
					}
					else
						JOptionPane.showMessageDialog(
						null, treeData.getText()+" already is Exist.", "Unable to insert",
						JOptionPane.INFORMATION_MESSAGE);
					
					treeData.setText("");
				}
			}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		
		treePanel.add(treeData);

		treeRemoveIndex = new JTextField();
		treeRemoveIndex.setBackground(Color.LIGHT_GRAY);
		treeRemoveIndex.setBounds(656, 89, 114, 25);
		treeRemoveIndex.addKeyListener(new KeyListener() {

			@SuppressWarnings({ "static-access" })
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Delete") )
				{
					BST.display();
					
					if(BST.remove(treeRemoveIndex.getText())) {
						traversal.setText(traversal.getText()+"\n"+treeRemoveIndex.getText()+" removed from BST");

						BST.display();
						
						if(treeObject.size() == 0) {
							flagRoot = true;
							
							treeNode.removeAllElements();
							
							root.removeAllChildren();
							
							root.setUserObject("Empty");
							
							treeNode.addElement(root);
							
							model.reload();
						}
						else {
						treeNode.removeAllElements();
							
						root.removeAllChildren();
						
						root.setUserObject("Empty");
						
						treeNode.addElement(root);
						
						resetC = 1;
						
						resetP = 0;
						
						root = resetTree();
						
						index =0;
						
						separator(root);
						
						model.reload();
						}
						counter--;
					}
					else
						JOptionPane.showMessageDialog(
						null, treeRemoveIndex.getText()+" is not Exist.", "Unable to remove",
						JOptionPane.INFORMATION_MESSAGE);
					
					treeRemoveIndex.setText("");
				}}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		treePanel.add(treeRemoveIndex);

		searchValue = new JTextField();
		searchValue.setColumns(10);
		searchValue.setBackground(Color.LIGHT_GRAY);
		searchValue.setBounds(656, 139, 114, 25);
		searchValue.addKeyListener(new KeyListener() {

			@SuppressWarnings({ "static-access" })
			public void keyPressed(KeyEvent ke) {
				
				if(ke.getKeyText(ke.getKeyCode()).equalsIgnoreCase("Enter"))
				{
					if(BST.search(searchValue.getText()))
						JOptionPane.showMessageDialog(
						null, searchValue.getText()+" is Exist.", "Binary Search Tree",
						JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(
						null, searchValue.getText()+" is not Exist.", "Binary Search Tree"
						, JOptionPane.INFORMATION_MESSAGE);
					
					searchValue.setText("");
				}
			}
			public void keyReleased(KeyEvent ke) {}
			public void keyTyped(KeyEvent ke) {}});
		
		treePanel.add(searchValue);
		
		String[] order = { "inorder", "preorder" };
		
		@SuppressWarnings("unchecked")
		JComboBox comboTraversal = new JComboBox(order);
		comboTraversal.setBackground(Color.LIGHT_GRAY);
		comboTraversal.setBounds(656, 181, 114, 25);
		comboTraversal.setSelectedIndex(0);
		treePanel.add(comboTraversal);
		
		JButton treeTraversal = new JButton("Traversal");
		treeTraversal.setBackground(Color.LIGHT_GRAY);
		treeTraversal.setBounds(559, 179, 90, 30);
		treeTraversal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				BST.display();
				
				if(!treeObject.isEmpty()) {
					
				String to;
				
				if(comboTraversal.getSelectedIndex() == 0) {
					
					to = treeObject.elementAt(0);
					
					for(int i=1 ; i<treeObject.size() ; i++)
						to += ", "+treeObject.elementAt(i);
				}
				else {
					
					to = treeObject.lastElement();
					
					for(int i=treeObject.size()-2 ; i>=0 ; i--)
						to += ", "+treeObject.elementAt(i);
				}
				traversal.setText(traversal.getText()+"\n"+to);
			}
			else
				JOptionPane.showMessageDialog(
						null, "Tree is Empty.", "Unable to Traverse",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		treePanel.add(treeTraversal);

		JButton treeInsert = new JButton("Insert");
		treeInsert.setBackground(Color.LIGHT_GRAY);
		treeInsert.setBounds(559, 42, 90, 30);
		treeInsert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				if(BST.insert(treeData.getText())){ 
					traversal.setText(traversal.getText()+"\n"+treeData.getText()+" inserted to BST");
					
					if(flagRoot) {
						root.setUserObject(treeData.getText());
						
						model.reload();
						
						flagRoot = false;
					}
					else {
					BST.display();
					
					flagNext = (counter%2 == 0);
					
					root = setTree();
					
					index =0;
					
					separator(root);
					
					model.reload();
					}
				}
				else
					JOptionPane.showMessageDialog(
					null, treeData.getText()+" already is Exist.", "Unable to insert",
					JOptionPane.INFORMATION_MESSAGE);
				
				treeData.setText("");
			}
		});
		treePanel.add(treeInsert);
		
		JButton treeRemove = new JButton("Remove");
		treeRemove.setBackground(Color.LIGHT_GRAY);
		treeRemove.setBounds(559, 86, 90, 30);
		treeRemove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				BST.display();
				
				if(BST.remove(treeRemoveIndex.getText())) {
					traversal.setText(traversal.getText()+"\n"+treeRemoveIndex.getText()+" removed from BST");

					BST.display();
					
					if(treeObject.size() == 0) {
						flagRoot = true;
						
						treeNode.removeAllElements();
						
						root.removeAllChildren();
						
						root.setUserObject("Empty");
						
						treeNode.addElement(root);
						
						model.reload();
					}
					else {
					treeNode.removeAllElements();
						
					root.removeAllChildren();
					
					root.setUserObject("Empty");
					
					treeNode.addElement(root);
					
					resetC = 1;
					
					resetP = 0;
					
					root = resetTree();
					
					index =0;
					
					separator(root);
					
					model.reload();
					}
					counter--;
				}
				else
					JOptionPane.showMessageDialog(
					null, treeRemoveIndex.getText()+" is not Exist.", "Unable to remove",
					JOptionPane.INFORMATION_MESSAGE);
				
				treeRemoveIndex.setText("");
			}
		});
		treePanel.add(treeRemove);
		
		JButton treeSearch = new JButton("Search");
		treeSearch.setBackground(Color.LIGHT_GRAY);
		treeSearch.setBounds(559, 134, 90, 30);
		treeSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				if(BST.search(searchValue.getText()))
					JOptionPane.showMessageDialog(
					null, searchValue.getText()+" is Exist.", "Binary Search Tree",
					JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(
					null, searchValue.getText()+" is not Exist.", "Binary Search Tree"
					, JOptionPane.INFORMATION_MESSAGE);
				
				searchValue.setText("");
			}
		});
		treePanel.add(treeSearch);
	}
	public void separator(DefaultMutableTreeNode node) {
		
		if(node.getChildCount() > 0)
				separator((DefaultMutableTreeNode) node.getChildAt(0));
			
			node.setUserObject(treeObject.elementAt(index)); index++;
		
			if(node.getChildCount() == 2)
				separator((DefaultMutableTreeNode) node.getChildAt(1));
	}
	public DefaultMutableTreeNode setTree() {
		
		if(treeNode.elementAt(parent).getChildCount() == 2)
			parent++;
		
		if(flagNext)
			generateLeft(treeNode.elementAt(parent));
		
		else if(!flagNext)
			generateRight(treeNode.elementAt(parent));
		
		return root;
}
	public DefaultMutableTreeNode resetTree() {
		
		while(resetC < treeObject.size()) {
		
		if(treeNode.elementAt(resetP).getChildCount() == 2)
			resetP++;
		
		flagNext = (resetC%2 == 0);
		
		if(flagNext)
			regenerateLeft(treeNode.elementAt(resetP));
		
		else if(!flagNext)
			regenerateRight(treeNode.elementAt(resetP));
		}
		if(treeNode.elementAt(parent).getChildCount() == 0)
			if(parent>0)
				parent--;
		
		return root;
	}
	public void generateLeft(DefaultMutableTreeNode node) {
		
		DefaultMutableTreeNode lChild = new DefaultMutableTreeNode("L");
		node.add(lChild);
		treeNode.addElement(lChild);
		counter++;
	}
	public void generateRight(DefaultMutableTreeNode node) {
		
		DefaultMutableTreeNode rChild = new DefaultMutableTreeNode("R");
		node.add(rChild);
		treeNode.addElement(rChild);
		counter++;
	}
	public void regenerateLeft(DefaultMutableTreeNode node) {
		
		DefaultMutableTreeNode lChild = new DefaultMutableTreeNode("L");
		node.add(lChild);
		treeNode.addElement(lChild);
		resetC++;
	}
	public void regenerateRight(DefaultMutableTreeNode node) {
		
		DefaultMutableTreeNode rChild = new DefaultMutableTreeNode("R");
		node.add(rChild);
		treeNode.addElement(rChild);
		resetC++;
	}
	//Coded by @abba5aghaei
}