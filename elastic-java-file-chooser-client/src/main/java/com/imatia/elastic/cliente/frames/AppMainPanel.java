package com.imatia.elastic.cliente.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imatia.elastic.cliente.utils.ImageUtils;

public class AppMainPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	protected static AppMainPanel instance;
	protected static String lookAndFeelClass = "";

	public JScrollPane scrollPanel;
	public JPanel mainPanel;

	public JFileChooser fileChooser;
	public JFileChooser fileChooser2;

	protected boolean synchronize = true;

	private static final Logger logger = LoggerFactory.getLogger(AppMainPanel.class);

	protected static File lastDirectory;

	public static AppMainPanel getInstance() {
		if (AppMainPanel.instance == null) {
			AppMainPanel.instance = new AppMainPanel(null);
		}
		return AppMainPanel.instance;
	}

	public static AppMainPanel getInstance(String lookAndFeelClass) {
		if (AppMainPanel.instance == null) {
			AppMainPanel.instance = new AppMainPanel(lookAndFeelClass);
		}
		return AppMainPanel.instance;
	}

	protected AppMainPanel(String lookAndFeelClass) {
		super("App prueba ficheros Elastic");

		this.init(lookAndFeelClass);

	}

	protected void init(String lookAndFeelClass) {

		if (lookAndFeelClass != null) {
			AppMainPanel.lookAndFeelClass = lookAndFeelClass;
		}

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.addComponents();

		this.mainPanel.setPreferredSize(new Dimension(700, 200));
		this.pack();

		this.addIconImage();
	}

	protected void addIconImage() {

		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource(ImageUtils.APP_ICON);
			if (url != null) {

				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img = kit.createImage(url);
				if (img != null) {

					this.setIconImage(img);
				}
			}
		} catch (Exception e) {
			AppMainPanel.logger.error(null, e);
		}
	}

	protected void addComponents() {

		JMenuBar menubar = this.createMenuBar();

		JButton buttonChooseFile = new JButton();
		buttonChooseFile.setText("Seleccionar fichero");
		buttonChooseFile.addActionListener(ve -> this.doActionChooseFile(null));

		JButton buttonChooseFile2 = new JButton();
		buttonChooseFile2.setText("Seleccionar fichero desde C:\\");
		buttonChooseFile2.addActionListener(ve -> this.doActionChooseFile(new File("C:\\")));

		JButton buttonChooseFile3 = new JButton();
		buttonChooseFile3.setText("Seleccionar fichero btn3");
		buttonChooseFile3.addActionListener(ve -> this.doActionDefaultChooseFile(null));

		JPanel fileChooserPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.insets = new Insets(0, 0, 0, 20);
		fileChooserPanel.add(buttonChooseFile, gc);
		fileChooserPanel.add(buttonChooseFile2, gc);
		fileChooserPanel.add(buttonChooseFile3, gc);

		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout());

		this.scrollPanel = new JScrollPane(fileChooserPanel);

		this.mainPanel.removeAll();
		this.mainPanel.add(this.scrollPanel);
		this.mainPanel.revalidate();
		this.mainPanel.repaint();

		this.setJMenuBar(menubar);

		this.getContentPane().add(this.mainPanel);

	}

	protected JFileChooser createFileChooserPanel() {
		if (this.fileChooser == null) {
			this.fileChooser = new CustomFileChooser();
			this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
		return this.fileChooser;
	}

	protected void doActionDefaultChooseFile(File currentDirToOpen) {

		if (this.fileChooser2 == null) {
			this.fileChooser2 = new JFileChooser();
			this.fileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);

		}
		if (currentDirToOpen != null) {
			if (currentDirToOpen.isDirectory()) {
				this.fileChooser2.setCurrentDirectory(currentDirToOpen);
			} else {
				this.fileChooser2.setCurrentDirectory(currentDirToOpen.getParentFile());
			}
		} else {
			if (AppMainPanel.lastDirectory != null) {
				if (AppMainPanel.lastDirectory.isDirectory()) {
					this.fileChooser2.setCurrentDirectory(AppMainPanel.lastDirectory);
				} else {
					this.fileChooser2.setCurrentDirectory(AppMainPanel.lastDirectory.getParentFile());
				}
			}
		}

		File fSel = null;
		File[] fil = null;
		if (this.synchronize) {
			this.fileChooser2.setMultiSelectionEnabled(false);
		} else {
			this.fileChooser2.setMultiSelectionEnabled(true);
		}
		int option = this.fileChooser2.showOpenDialog(this.getParent());
		AppMainPanel.lastDirectory = this.fileChooser2.getCurrentDirectory();
		if (option != JFileChooser.APPROVE_OPTION) {
			return;
		}
		fSel = this.fileChooser2.getSelectedFile();
		fil = this.fileChooser2.getSelectedFiles();

	}

	protected void doActionChooseFile(File currentDirToOpen) {

		if (this.fileChooser == null) {
			this.fileChooser = this.createFileChooserPanel();
		}
		if (currentDirToOpen != null) {
			if (currentDirToOpen.isDirectory()) {
				this.fileChooser.setCurrentDirectory(currentDirToOpen);
			} else {
				this.fileChooser.setCurrentDirectory(currentDirToOpen.getParentFile());
			}
		} else {
			if (AppMainPanel.lastDirectory != null) {
				if (AppMainPanel.lastDirectory.isDirectory()) {
					this.fileChooser.setCurrentDirectory(AppMainPanel.lastDirectory);
				} else {
					this.fileChooser.setCurrentDirectory(AppMainPanel.lastDirectory.getParentFile());
				}
			}
		}

		File fSel = null;
		File[] fil = null;
		if (this.synchronize) {
			this.fileChooser.setMultiSelectionEnabled(false);
		} else {
			this.fileChooser.setMultiSelectionEnabled(true);
		}
		int option = this.fileChooser.showOpenDialog(this.getParent());
		AppMainPanel.lastDirectory = this.fileChooser.getCurrentDirectory();
		if (option != JFileChooser.APPROVE_OPTION) {
			return;
		}
		fSel = this.fileChooser.getSelectedFile();
		fil = this.fileChooser.getSelectedFiles();

	}

	protected JMenuBar createMenuBar() {
		return AppMenuBar.newInstance(new HashMap<>());
	}

}
