package controller;

import model.Conversor;
import model.ConversorMoeda;
import model.ConversorTemperatura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerJframe extends JFrame {
    private JPanel contentPane;
    int resposta = -1;

    public ControllerJframe() {
        configuraJframe();
        inicializaPanel();
        header();
        body();
        footer();
    }

    private void configuraJframe() {
        setResizable(false);
        setTitle("Conversor ");
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 633, 473);
    }

    private void inicializaPanel () {
        contentPane = new JPanel();
        contentPane.setBackground(new Color(98, 96, 15));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void header () {
        var lblMenu = new JLabel("Menu Principal");
        lblMenu.setForeground(new Color(255, 255, 255));
        lblMenu.setFont(new Font("Arial", Font.PLAIN, 23));
        lblMenu.setBounds(216, -12, 225, 107);
        contentPane.add(lblMenu);

        var lblImgMoeda = new JLabel("");
       lblImgMoeda.setIcon(new ImageIcon(("C:\\\\Users\\\\duart\\\\eclipse-workspace\\\\ConversorDeMoedas\\\\src\\\\main\\\\resources\\\\imagens\\\\moeda-icon.png")));
        lblImgMoeda.setBounds(60, 11, 80, 70);
        contentPane.add(lblImgMoeda);

        var lblImgTemp = new JLabel("");
        lblImgTemp.setIcon(new ImageIcon(("C:\\\\Users\\\\duart\\\\eclipse-workspace\\\\ConversorDeMoedas\\\\src\\\\main\\\\resources\\\\imagens\\\\temp-icon.png")));
        lblImgTemp.setBounds(10, 22, 73, 70);
        contentPane.add(lblImgTemp);
    }

    private void body () {
        var lblSelecione = new JLabel("Selecione o conversor desejado:");
        lblSelecione.setFont(new Font("Arial", Font.PLAIN, 19));
        lblSelecione.setForeground(new Color(255, 255, 255));
        lblSelecione.setBounds(180, 107, 340, 35);
        contentPane.add(lblSelecione);

        var opcoesBox = new JComboBox();
        opcoesBox.setFont(new Font("Arial", Font.PLAIN, 14));
        opcoesBox.setModel(new DefaultComboBoxModel(new String[]{"Conversor de Moeda", "Conversor de Temperatura"}));
        opcoesBox.setBounds(180, 164, 261, 38);
        contentPane.add(opcoesBox);

        var btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String selecionado = (String) opcoesBox.getSelectedItem();

                try {
                    String mensagem = "";
                    Conversor conversor = null;
                    switch (selecionado) {
                        case "Conversor de Moeda":
                            conversor = new ConversorMoeda();
                            break;

                        case "Conversor de Temperatura":
                            conversor = new ConversorTemperatura();
                            break;
                    }

                    String valorDigitado = JOptionPane.showInputDialog(contentPane, "Digite o valor");
                    double valor = Double.parseDouble(valorDigitado);
                    conversor.convert(valor);
                    resposta = JOptionPane.showConfirmDialog(contentPane, "Deseja continuar?");
                    terminate(resposta);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, digite apenas números");
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Operação cancelada", "Cancel",  JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        btnOk.setBounds(245, 210, 111, 27);
        contentPane.add(btnOk);
    }

    private void footer () {
        var lblCopyright = new JLabel("© Desenvolvido por Diogo Duarte - 2023");
        lblCopyright.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCopyright.setIcon(null);
        lblCopyright.setForeground(Color.WHITE);
        lblCopyright.setBackground(Color.BLACK);
        lblCopyright.setBounds(182, 365, 918, 70);
        contentPane.add(lblCopyright);

        var lblImgCopyright = new JLabel("");
        lblImgCopyright.setIcon(new ImageIcon("C:\\\\Users\\\\duart\\\\eclipse-workspace\\\\ConversorDeMoedas\\\\src\\\\main\\\\resources\\\\imagens\\\\black.png"));
        lblImgCopyright.setForeground(Color.BLACK);
        lblImgCopyright.setBackground(Color.BLACK);
        lblImgCopyright.setBounds(0, 365, 680, 70);
        contentPane.add(lblImgCopyright);
    }

    public static void terminate(int resposta) {
        if (resposta == 0) {
        	JOptionPane.showMessageDialog(null, "Voltando ao Menu Principal");
           
        } else if (resposta == 1) {
            JOptionPane.showMessageDialog(null, "Fechando o programa");
            System. exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada", "Cancel",  JOptionPane.ERROR_MESSAGE);
        }
    }
}

