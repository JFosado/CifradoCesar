package cesar;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class cifrado extends JFrame {

	private JPanel contentPane;
	private JTextField txtTexto;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cifrado frame = new cifrado();
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
	public cifrado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce un Texto");
		lblNewLabel.setBounds(54, 40, 134, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce el codigo");
		lblNewLabel_1.setBounds(54, 112, 134, 13);
		contentPane.add(lblNewLabel_1);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(216, 37, 169, 19);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(216, 109, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnNewButton = new JButton("Cifrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				String texto = txtTexto.getText();
				JOptionPane.showMessageDialog(contentPane,cifradoCesar (texto, codigo));
				
			}
		});
		btnNewButton.setBounds(71, 186, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decifrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				String texto = txtTexto.getText();
				JOptionPane.showMessageDialog(contentPane,descifradoCesar (texto, codigo));
			}
		});
		btnNewButton_1.setBounds(277, 186, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	 public static String cifradoCesar(String texto, int codigo) {
	        StringBuilder cifrado = new StringBuilder();
	        codigo = codigo % 26;
	        for (int i = 0; i < texto.length(); i++) {
	            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
	                if ((texto.charAt(i) + codigo) > 'z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
	                if ((texto.charAt(i) + codigo) > 'Z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            }
	        }
	        return cifrado.toString();
	    }

	    //método para descifrar el texto
	    public static String descifradoCesar(String texto, int codigo) {
	        StringBuilder cifrado = new StringBuilder();
	        codigo = codigo % 26;
	        for (int i = 0; i < texto.length(); i++) {
	            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
	                if ((texto.charAt(i) - codigo) < 'a') {
	                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) - codigo));
	                }
	            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
	                if ((texto.charAt(i) - codigo) < 'A') {
	                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) - codigo));
	                }
	            }
	        }
	        return cifrado.toString();
	    }
	} //Fin cifrado Cesar

