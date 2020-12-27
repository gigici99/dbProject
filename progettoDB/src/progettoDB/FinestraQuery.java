package progettoDB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class FinestraQuery extends JFrame {

	private JPanel contentPane;

	public FinestraQuery() {
		super("Spotify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextArea Results = new JTextArea();
		JScrollPane scrollV = new JScrollPane(Results);
		scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollV, BorderLayout.CENTER);


		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,2));
		contentPane.add(panel, BorderLayout.WEST);

		JButton btnNewButton = new JButton("Query 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 250);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(5,1));
				panel1.add(new JLabel("Nome e cognome"));
				panel1.add(new JLabel("Inserire data di nascita aaaa-mm-gg"));
				panel1.add(new JLabel("Codice fiscale"));
				panel1.add(new JLabel("Email"));
				panel1.add(new JLabel("Password"));
				tmp.add(panel1);
				JTextField t1= new JTextField();
				JTextField t2= new JTextField();
				JTextField t3= new JTextField();
				JTextField t4= new JTextField();
				JTextField t5= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(5,1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);
				panel.add(t4);
				panel.add(t5);
				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Interface.query1(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText());
						Results.setText("Cliente Inserito");
						tmp.dispose();
					}
				});
				tmp.add(btn);

			}
		});

		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Query 2");
		btnNewButton_1.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				try {	
					Results.setText("" + Interface.query2());
				}
				catch(NumberFormatException e) {
					System.out.println(e);
					JPanel pane= new JPanel();
					JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Query 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(300, 150);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(2,1));
				panel1.add(new JLabel("ID"));
				panel1.add(new JLabel("Email Paypal"));
				tmp.add(panel1);

				JTextField t1= new JTextField();
				JTextField t2= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(2,1));
				panel.add(t1);
				panel.add(t2);

				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						try{
							Interface.query3(Integer.parseInt(t1.getText()), t2.getText());
							Results.setText("Cambio effettuato");
							tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
							JPanel pane= new JPanel();
							JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Query 4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(400, 100);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(2,1));
				panel1.add(new JLabel("ID"));
				tmp.add(panel1);

				JTextField t1= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(2,1));
				panel.add(t1);

				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							Interface.query4(Integer.parseInt(t1.getText()));
							Results.setText("Cambio effettuato");
							tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
							JPanel pane= new JPanel();
							JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Query 5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(300, 150);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(3,1));
				panel1.add(new JLabel("ID"));
				tmp.add(panel1);

				JTextField t1= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3,1));
				panel.add(t1);
				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try{
							Interface.query5(Integer.parseInt(t1.getText()));
							Results.setText("Cliente rimosso");
							tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
							JPanel pane= new JPanel();
							JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);

			}
		});
		panel.add(btnNewButton_4);

		JButton btn4a= new JButton("Query 6");
		btn4a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try{
					Results.setText(Interface.query6());
				}
				catch(NumberFormatException ei) {
					System.out.println(e);
					JPanel pane= new JPanel();
					JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btn4a);

		JButton btn4b= new JButton("Query 7");
		btn4b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(500, 150);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(3,1));
				panel1.add(new JLabel("Titolo"));
				panel1.add(new JLabel("Durata"));
				panel1.add(new JLabel("Nome Artista"));
				tmp.add(panel1);

				JTextField t1= new JTextField();
				JTextField t2= new JTextField();
				JTextField t3= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3,1));
				panel.add(t1);
				panel.add(t2);
				panel.add(t3);

				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try{
							Interface.query7(t1.getText(),t2.getText(),t3.getText());
							Results.setText("Brano aggiunto");
							tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
							JPanel pane= new JPanel();
							JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btn4b);

		JButton btn4c= new JButton("Query 8");
		btn4c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try{
					Results.setText(Interface.query8());
				}
				catch(NumberFormatException ei) {
					System.out.println(e);
					JPanel pane= new JPanel();
					JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btn4c);

		JButton btn4d= new JButton("Query 9");
		btn4d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame tmp= new JFrame();
				tmp.setVisible(true);
				tmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				tmp.setSize(300, 150);
				tmp.setLayout(new GridLayout(1,3));

				JPanel panel1 = new JPanel();
				panel1.setVisible(true);
				panel1.setLayout(new GridLayout(3,1));
				panel1.add(new JLabel("Artista"));
				tmp.add(panel1);

				JTextField t1= new JTextField();

				JPanel panel = new JPanel();
				panel.setVisible(true);
				panel.setLayout(new GridLayout(3,1));
				panel.add(t1);
				tmp.add(panel);
				JButton btn= new JButton("Invia Dati");
				btn.setVisible(true);
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try{
							Results.setText(Interface.query9(t1.getText()));
							tmp.dispose();
						}
						catch(NumberFormatException e) {
							System.out.println(e);
							JPanel pane= new JPanel();
							JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				tmp.add(btn);
			}
		});
		panel.add(btn4d);
		
		JButton btnNewButton_5 = new JButton("Query 10");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try{
					Results.setText(Interface.query10());
				}
				catch(NumberFormatException ei) {
					System.out.println(e);
					JPanel pane= new JPanel();
					JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton_5);

		JButton btnNewButton_14 = new JButton("CONNESSIONE");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Interface.connessione());
			}
		});

		JButton btnNewButton_15 = new JButton("ESCI");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Results.setText(Interface.uscita());
			}
		});
		JPanel bt= new JPanel();
		bt.setVisible(true);
		bt.setLayout(new GridLayout(1,4));
		bt.add(new JPanel());
		bt.add(btnNewButton_14);
		bt.add(btnNewButton_15);
		bt.add(new JPanel());

		contentPane.add(bt, BorderLayout.NORTH);
		setVisible(true);
	}
}