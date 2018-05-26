package windowsExplorer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.apache.commons.io.FileUtils;

public class TreeInJava extends JFrame implements ActionListener, TreeSelectionListener, MouseListener, ItemListener {
	//Frame
	JFrame fr;
	JLabel pathname;
	JPanel panel, bt, pane;
	JScrollPane jScrollPane;
	//JTree 
	JTree root;
	JMenuItem cut, copy, paste, newfolder, delete, properties;
	JPopupMenu right_clickpopup;
	//Button
	JButton back, foward;
	Container cont;
	JComboBox<String> combobox;
	//String path used to save pathname
	//Clipboard variable save file to Paste
	String path = new String(), currentFolder = new String();
	String clipboard = new String();
	String pickedItem = "";
	String action = new String();
	//Find textfield
	JTextField find;
	public TreeInJava(Loading A)
	{
		this.setTitle("Windows Explorer");
		//Create a JTree with Root is Root of PC
		DefaultMutableTreeNode computer = new DefaultMutableTreeNode("My PC");
		DefaultMutableTreeNode disk1 = new DefaultMutableTreeNode("C:");
		DefaultMutableTreeNode disk2 = new DefaultMutableTreeNode("E:");
		DefaultMutableTreeNode disk3 = new DefaultMutableTreeNode("F:");
		computer.add(disk1);
		computer.add(disk2);
		computer.add(disk3);
		//Load folder and file in C, E, F disk
		//loadDisk(disk1, disk1.toString());
		loadDisk(disk2, "E:/");
		loadDisk(disk3, "F:/");
		root = new JTree(computer);
		//Panel
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		jScrollPane = new JScrollPane(panel);
		jScrollPane.setSize(500, 500);
		right_clickpopup = new JPopupMenu();
		//Di chuyển
		cut = new JMenuItem("Cut");
		right_clickpopup.add(cut);
		cut.addActionListener(this);
		//Sao chép
		copy = new JMenuItem("Copy");
		right_clickpopup.add(copy);
		copy.addActionListener(this);
		//Dán
		paste = new JMenuItem("Paste");
		right_clickpopup.add(paste);
		delete = new JMenuItem("Delete");
		right_clickpopup.add(delete);
		delete.addActionListener(this);
		
		paste.addActionListener(this);
		paste.setEnabled(false);
		newfolder = new JMenuItem("New Folder");
		newfolder.addActionListener(this);
		right_clickpopup.add(newfolder);
		properties = new JMenuItem("Properties");
		right_clickpopup.addSeparator();
		right_clickpopup.add(properties);
		properties.addActionListener(this);
		//Tạo thư mục
		
		//Add Tree into Panel
		panel.add(root);
		//Load image for button
		ImageIcon forwardicon = new ImageIcon("foward.png");
		ImageIcon backicon = new ImageIcon("back.png");
		

		bt = new JPanel();
		bt.setLayout(new FlowLayout());
		//Back button
		back = new JButton(backicon);
		back.setBorder(null);
		bt.add(back);
		back.setBackground(new Color(245, 245, 240));
		back.addActionListener(this);
		
		//Foward button
		foward = new JButton(forwardicon);
		foward.setBorder(null);
		bt.add(foward);
		foward.setBackground(new Color(245, 245, 240));
		foward.addActionListener(this);
		//Create JCombobox
		combobox = new JComboBox<>();
		combobox.setMaximumRowCount(20);
		combobox.addItem("C:");
		combobox.addItem("E:");
		combobox.addItem("F:");
		pathname = new JLabel("");
		bt.add(pathname);
		bt.add(combobox);
		combobox.addItemListener(this);
		
		//Create frame	
		fr = new JFrame();
		fr.getContentPane().setBackground(new Color(255, 255, 255));
		loadFile("My PC");
		root.addTreeSelectionListener(this);
		reload();
		
		Popup pm = new Popup();
		pane.addMouseListener(pm);
		JTree tree = new JTree(root.getModel());
		//Modify icon of JTree
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) root.getCellRenderer();
		Icon closedIcon = new ImageIcon("closed.png");
		Icon openIcon = new ImageIcon("open.png");
		Icon leafIcon = new ImageIcon("closed.png");
		cellRenderer.setClosedIcon(closedIcon);
		cellRenderer.setOpenIcon(openIcon);
		cellRenderer.setLeafIcon(leafIcon);
		//Set color
		fr.setBackground(Color.WHITE);
		jScrollPane.setBackground(Color.WHITE);
		bt.setBackground(Color.WHITE);
		//Find textfield
		find = new JTextField();
		bt.add(find);
		find.setColumns(10);
		find.setText("Search...");
		find.addMouseListener(this);
		find.setForeground(Color.GRAY);
		pane.setBackground(Color.WHITE);
		//Put JScrollPane into frame
		
		fr.setVisible(true);
		A.dispose();
		fr.setSize(700, 500);
		fr.setLocation(350, 120);
	}
	
	public void loadDisk(DefaultMutableTreeNode dmt, String path)
	{
		File f = new File(path);
		String[] names = f.list();
		DefaultMutableTreeNode t = dmt;
		for(int i = 0;i < names.length;i++)
		{	
			
			File fi = new File(path + "/" + names[i]);
//			System.out.println(fi.getName());
			DefaultMutableTreeNode fol = new DefaultMutableTreeNode(names[i]);
			if (fi.isDirectory() && !fi.isHidden())
				{
					t.add(fol);
					loadFolder(fol, fi.getAbsolutePath() + "/");
				}
		}
	}
	
	public void loadFolder(DefaultMutableTreeNode dmt, String path)
	{
		File f = new File(path);
		String t[] = f.list();
		DefaultMutableTreeNode dm = dmt;
		for (int i = 0;i < t.length;i++)
		{
			File fi = new File(path + "\\" + t[i]);
			DefaultMutableTreeNode x = new DefaultMutableTreeNode(t[i]);
			//Nếu fi là folder thì nạp vào cây
			if (fi.isDirectory()) {
					dm.add(x);
					loadFolder(x, fi.getAbsolutePath());
			}
			
		}
	}
	public void reload() {
		cont = fr.getContentPane();
		cont.removeAll();
		cont.add(jScrollPane, "West");
		cont.add(bt, "North");
		cont.add(pane, "Center");
		pane.setBackground(Color.WHITE);
		fr.setTitle("Windows Explorer");
		fr.validate();
		fr.repaint();
	}
	public void loadFile(String path) {
		pathname.setText(path);
		if (path.equals("My PC")) {
			pane = new JPanel();
			pane.setLayout(new FlowLayout());
			String localdisk[] = {"C:", "E:", "F:"};
			for (int i = 0;i < 3;i++) {
				JLabel lb = new JLabel(localdisk[i],new ImageIcon("localdisk.png"), 0);
				pane.add(lb);
				lb.addMouseListener(this);
				Popup pml = new Popup();
				lb.addMouseListener(pml);
			}
			reload();
		}
		else {
			
			pane = new JPanel();
			pane.setLayout(new FlowLayout());
			Popup pop = new Popup();
			pane.addMouseListener(pop);
			File f = new File(path);
			String t[] = f.list();
			if (t.length == 0) {
				JLabel lb_empty = new JLabel("Folder is empty");
				lb_empty.setFont(new Font("Courier", Font.BOLD, 20));
				lb_empty.setForeground(Color.GRAY);
				pane.add(lb_empty, "Center");
				reload();
			}
			else {
				for(int i = 0;i < t.length;i++) {
					File fi = new File(path + "\\" + t[i]);
					if (fi.isDirectory() && !fi.isHidden()) {
						JLabel lb = new JLabel(t[i], new ImageIcon("folder.png"), 0);
						pane.add(lb);
						lb.addMouseListener(this);
						Popup pml = new Popup();
						lb.addMouseListener(pml);
					}
				}
				for(int i = 0;i < t.length;i++) {
					File fi = new File(path + "\\" + t[i]);
					if (fi.isFile() && !fi.isHidden()) {
						JLabel lb = new JLabel(t[i], new ImageIcon("file.png"), 0);
						lb.setFont(new Font("Courier", Font.PLAIN, 12));
						pane.add(lb);
						lb.addMouseListener(this);
						Popup pml = new Popup();
						lb.addMouseListener(pml);
					}
					reload();
				}
			}
			
		}
	}
	public void delete(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			try {
				FileUtils.deleteDirectory(f);
				JOptionPane.showMessageDialog(null, "Deleted successfully");
				loadFile(f.getParent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Failed to delete the folder");
			}
		}
		if (f.isFile()) {
			if (f.delete()) {
				JOptionPane.showMessageDialog(null, "Deleted successfully");
				loadFile(f.getParent());
			}
			else {
				JOptionPane.showMessageDialog(null, "Failed to delete the file");
			}
		}
	}
	class Popup extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			showPopup(e);
		}
		public void mouseReleased(MouseEvent e) {
			showPopup(e);
		}
		private void showPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
					right_clickpopup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loading A = new Loading();
		new TreeInJava(A);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cut || e.getSource() == copy) {
			paste.setEnabled(true);
			clipboard = this.path + pickedItem;
			//JOptionPane.showMessageDialog(null, pickedItem);
			if (e.getSource() == cut) {
				action = "Cut";
			}
			if (e.getSource() == copy) {
				action = "Copy";
			}
		}
		if (e.getSource() == paste) {
			File src = new File(clipboard);
			if (src.isFile()) {
				File dst = new File(path);
				if (action.equals("Cut")) {
					try {
						FileUtils.moveFileToDirectory(src, dst, false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (action.equals("Copy")) {
					try {
						FileUtils.copyFileToDirectory(src, dst);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				loadFile(dst.getAbsolutePath());
			}
			if (src.isDirectory()) {
				File dst = new File(path);
				File fi = new File(dst, src.getName());
				if (!fi.exists()) {
					if (action.equals("Cut")) {
						try {
							FileUtils.moveDirectoryToDirectory(src, fi.getParentFile(), false);
							//FileUtils.copyDirectoryToDirectory(src, fi.getParentFile());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("IOException - Path: " + fi.getAbsolutePath());
						}
					}
					if (action.equals("Copy")) {
						try {
							
							FileUtils.copyDirectoryToDirectory(src, fi.getParentFile());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("IOException - Path: " + fi.getAbsolutePath());
						}
					}
				}
				loadFile(dst.getAbsolutePath());
				//JOptionPane.showMessageDialog(null, "Folder");
			}
			System.out.println(clipboard + " --> " + this.path);
			//copy(clipboard, path);
		}
		if (e.getSource() == delete) {
			int k = JOptionPane.showConfirmDialog(null, "Are you sure want to delete " + pickedItem + " file?");
			if (k == 0) {
				File p = new File(path, pickedItem);
				delete(p.getAbsolutePath());
			}
			else {
				System.out.println("Skip");
			}
		}
		if (e.getSource() == newfolder) {
			String foldername = JOptionPane.showInputDialog("Input name of folder: ");
			System.out.println(path + foldername);
			File fi = new File(path + foldername);
			if (fi.exists()) {
				JOptionPane.showMessageDialog(null, "The name of folder is duplicate");
			}
			else {
				try {
					fi.mkdirs();
				} catch (Exception ex) {
					// TODO: handle exception
				}
				loadFile(path);
			}
		}
		if (e.getSource() == properties) {
			new Properties(path + pickedItem);
		}
		//Nếu là nút Up to thì load lại giao diện
		if (e.getSource() == back) {
			if ((path.startsWith("E") || path.startsWith("F") || path.startsWith("C:/")) && path.length() == 3) {
				loadFile("My PC");
				//Reset path và currentFolder
				path = new String();
				currentFolder = new String();
			}
			else {
				File p = new File(path);
				String parentPath = p.getParent();
				//Load thư mục mẹ
				loadFile(parentPath);
				//Tìm currentFolder 
				StringTokenizer st = new StringTokenizer(parentPath, "/");
				path = parentPath;
				while (st.hasMoreTokens()) {
					currentFolder = st.nextToken();
				}
				
			}
		}
	}
	@Override
	public void valueChanged(TreeSelectionEvent t) {
		// TODO Auto-generated method stub
		String st = root.getSelectionPath().toString();
		String path = new String();
		StringTokenizer stz = new StringTokenizer(st, "[,]");
		while (stz.hasMoreTokens()) {
			String str = stz.nextToken();
			path = path + "/" + str.trim();
		}
		path = path.substring(7);
		this.pathname.setText(path);;
		this.path = path + "/";
		//System.out.println(this.path);
		loadFile(path);
	}
	//Mouse Event
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == find) {
			find.setText("");
			find.setForeground(Color.BLACK);
		}
		else {
			//Open folder if double mouse click
			if (e.getClickCount() == 1) {
				JLabel t = (JLabel) e.getSource();
				t.setBorder(BorderFactory.createTitledBorder(""));
				t.setForeground(Color.blue);
				pickedItem = t.getText();
				//System.out.println("Picking: " + pickedItem);
				//System.out.println(t.getText());
			}
			if (e.getClickCount() == 2) {
				JLabel t = (JLabel) e.getSource();
				File fi = new File(this.path + t.getText());
				if (fi.isFile()) {
					JOptionPane.showMessageDialog(null, "Cannot open the file", "ERROR", 0);
				}
				else {
					currentFolder = t.getText();
					this.path += t.getText() + "/";
					//System.out.println(this.path);
					loadFile(this.path);
				}
				
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		String disk = (String) combobox.getSelectedItem();
		//JOptionPane.showMessageDialog(null, disk);
		path = disk + "/";
		loadFile(path);
	}

}

class Loading extends JFrame implements ActionListener {
	public final static int ONE = 100;
	JProgressBar progress_bar;
	Timer timer;
	JPanel panel;
	JLabel label;
	public Loading() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		progress_bar = new JProgressBar(0, 100);
		progress_bar.setValue(0);
		progress_bar.setStringPainted(true);
		progress_bar.setForeground(Color.GREEN);
		timer = new Timer(ONE, this);
		timer.start();
		label = new JLabel("Initializing...");
		panel.add(progress_bar);
		panel.add(label);
		this.getContentPane().add(panel, "Center");
		this.setSize(100, 100);
		this.setLocation(500, 200);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		progress_bar.setValue(progress_bar.getValue()+3);
	}
}
class Properties extends JFrame {
	JLabel type, name, size, location, date_modified;
	JPanel panel;
	public String fileExtension(String name) {
		if (name.endsWith(".mp3")) {
			return "MP3 Format Sound";
		}
		if (name.endsWith(".txt")) {
			return "TXT File";
		}
		if (name.endsWith(".java")) {
			return "JAVA File";
		}
		return "";
	}
	public Properties(String path) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		File fi = new File(path);
		panel.add(new JLabel("Type: "));
		type = new JLabel();
		if (fi.isDirectory()) {
			type.setText("File Folder");
		}
		if (fi.isFile()) {
			type.setText(fileExtension(fi.getName()));
		}
		type.setFont(new Font("Courier", Font.PLAIN, 13));
		panel.add(type);
		panel.add(new JLabel("Name: "));
		name = new JLabel(fi.getName());
		name.setFont(new Font("Courier", Font.PLAIN, 13));
		panel.add(name);
		panel.add(new JLabel("Location: "));
		location = new JLabel(fi.getParent());
		location.setFont(new Font("Courier", Font.PLAIN, 13));
		panel.add(location);
		panel.add(new JLabel("Size: "));
		long s = fi.length()/1024/1024;
		size = new JLabel(String.valueOf(s) + " MB");
		size.setFont(new Font("Courier", Font.PLAIN, 13));
		panel.add(size);
		panel.add(new JLabel("Last Modified: "));
		Date date = new Date(fi.lastModified());
		date_modified = new JLabel(date.toString());
		date_modified.setFont(new Font("Courier", Font.PLAIN, 13));
		panel.add(date_modified);
		this.setTitle("Properties");
		this.getContentPane().add(panel);
		this.setSize(100, 170);
		this.setVisible(true);		
	}
}
;