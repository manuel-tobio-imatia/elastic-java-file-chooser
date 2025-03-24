package com.imatia.elastic.cliente;

import javax.swing.JFrame;

import com.imatia.elastic.cliente.frames.AppMainPanel;

public class ElasticSpecificLauncher {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame menu = AppMainPanel.getInstance(null);

		menu.pack();
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
	}
}