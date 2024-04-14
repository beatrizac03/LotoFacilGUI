import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class LotoFacilGUI extends JFrame {
    private JFrame frame = new JFrame("LotoFácil: Apostas");
    private JPanel panelAposta1 = new JPanel();
    private JPanel panelAposta2 = new JPanel();
    private JPanel panelAposta3 = new JPanel();
    private JPanel panelCover = new JPanel();
    private JPanel panelButtons = new JPanel();
    private JButton buttonAposta1 = new JButton("Apostar de 0 à 100");
    private JButton buttonAposta2 = new JButton("Apostar de A à Z");
    private JButton buttonAposta3 = new JButton("Apostar em ímpar ou par");

    Color colorRed = new Color(235, 21, 57);
    Font fontLabels = new Font("Arial", Font.BOLD, 20);

    public LotoFacilGUI() {
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        configurarComponentes();
        configurarPanelAposta1();
        configurarPanelAposta2();
        configurarPanelAposta3();
        chamarActionListeners();

        frame.setVisible(true);
    }

    public void configurarComponentes() {
        panelButtons.setSize(900, 50);
        panelButtons.setBackground(colorRed);

        Dimension buttonsDimension = new Dimension(200, 30);
        buttonAposta1.setPreferredSize(buttonsDimension);
        buttonAposta1.setBackground(Color.white);
        buttonAposta2.setPreferredSize(buttonsDimension);
        buttonAposta2.setBackground(Color.white);
        buttonAposta3.setPreferredSize(buttonsDimension);
        buttonAposta3.setBackground(Color.white);

        panelButtons.add(buttonAposta1);
        panelButtons.add(buttonAposta2);
        panelButtons.add(buttonAposta3);

        panelCover.setSize(900,560);
        ImageIcon coverImage = new ImageIcon("coverimg4.png");
        JLabel labelImg = new JLabel(coverImage);
        panelCover.add(labelImg);

        frame.add(panelAposta1);
        frame.add(panelAposta2);
        frame.add(panelAposta3);
        frame.add(panelButtons);
        frame.add(panelCover);
    }

    public void configurarPanelAposta1() {
        JPanel panelText1 = new JPanel();
        panelText1.setBounds(0, 50, 900,50);
        panelText1.setBackground(Color.white);
        JPanel panelResult1 = new JPanel();
        panelResult1.setBounds(0, 150, 900, 100);
        panelResult1.setBackground(Color.white);

        panelAposta1.setLayout(null);
        panelAposta1.setBounds(0, 50, 900, 520);
        panelAposta1.setBackground(Color.white);
        panelAposta1.setVisible(false);

        JLabel textLabelAposta1 = new JLabel("Entre com um número de 0 a 100:");
        textLabelAposta1.setFont(fontLabels);
        textLabelAposta1.setBounds(20, 50, 900, 200);
        JTextField inputAposta1 = new JTextField();
        inputAposta1.setPreferredSize(new Dimension(100, 30));
        JButton btnConfirmar1 = new JButton("Apostar");

        btnConfirmar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorInput = inputAposta1.getText();
                int aposta1 = Integer.parseInt(valorInput);

                Random random1 = new Random();
                int numeroSorteado = random1.nextInt(101);

                Label resultAposta1 = new Label();
                if(aposta1 == numeroSorteado) {
                    resultAposta1.setText("Parabéns! Você ganhou R$1.000,00 reais");
                } else {
                    resultAposta1.setText("Você perdeu! O número sorteado foi: " + numeroSorteado);
                }
                resultAposta1.setFont(fontLabels);
                panelResult1.removeAll(); // remover todos os componentes existentes
                panelResult1.add(resultAposta1);
                panelAposta1.revalidate();

            }
        });

        panelText1.add(textLabelAposta1);
        panelText1.add(inputAposta1);
        panelText1.add(btnConfirmar1);

        //panelAposta1.add(panelText1, BorderLayout.CENTER);
        panelAposta1.add(panelText1);
        panelAposta1.add(panelResult1);

        //panelAposta1.add(panelInput1, BorderLayout.CENTER);
    }

    public static void aposta1() {
    }

    public void configurarPanelAposta2() {
        panelAposta2.setLayout(null);
        panelAposta2.setBounds(0, 50, 900, 520);
        panelAposta2.setBackground(Color.white);
        panelAposta2.setVisible(false);

        JPanel panelText2 = new JPanel();
        panelText2.setBounds(0, 50, 900,50);
        panelText2.setBackground(Color.white);
        JPanel panelResult2 = new JPanel();
        panelResult2.setBounds(0, 150, 900, 100);
        panelResult2.setBackground(Color.white);

        JLabel textLabelAposta2 = new JLabel("Digite uma letra de A à Z:");
        textLabelAposta2.setFont(fontLabels);
        textLabelAposta2.setBounds(20, 50, 900, 200);
        JTextField inputAposta2 = new JTextField();
        inputAposta2.setPreferredSize(new Dimension(100, 30));
        JButton btnConfirmar2 = new JButton("Apostar");

        btnConfirmar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorInput = inputAposta2.getText();
                char aposta2 = valorInput.charAt(0);

                Random random2 = new Random();
                char letraSorteada = (char) (random2.nextInt(26) + 'A');

                Label resultAposta2 = new Label();

                if(Character.toUpperCase(aposta2) == letraSorteada) {
                    resultAposta2.setText("Você ganhou R$ 500,00 reais!");
                } else {
                    resultAposta2.setText("Você perdeu! A letra sorteada foi: " + letraSorteada);
                }
                resultAposta2.setFont(fontLabels);
                panelResult2.removeAll(); // Remover todos os componentes existentes
                panelResult2.add(resultAposta2);
                panelAposta1.revalidate();

            }
        });

        panelText2.add(textLabelAposta2);
        panelText2.add(inputAposta2);
        panelText2.add(btnConfirmar2);
        panelAposta2.add(panelResult2);


        panelAposta2.add(panelText2);
    }

    public static void aposta2() {

    }

    public void configurarPanelAposta3() {
        panelAposta3.setLayout(null);
        panelAposta3.setBounds(0, 50, 900, 520);
        panelAposta3.setBackground(Color.white);
        panelAposta3.setVisible(false);

        JPanel panelText3 = new JPanel();
        panelText3.setBounds(0, 50, 900,50);
        panelText3.setBackground(Color.white);
        JPanel panelResult3 = new JPanel();
        panelResult3.setBounds(0, 150, 900, 100);
        panelResult3.setBackground(Color.white);

        JLabel textLabelAposta3 = new JLabel("Digite um número:");
        textLabelAposta3.setFont(fontLabels);
        textLabelAposta3.setBounds(20, 50, 900, 200);
        JTextField inputAposta3 = new JTextField();
        inputAposta3.setPreferredSize(new Dimension(100, 30));
        JButton btnConfirmar3 = new JButton("Apostar");

        btnConfirmar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorInput = inputAposta3.getText();
                int aposta3 = Integer.parseInt(valorInput);

                Random random3 = new Random();
                int numeroSorteado3 = random3.nextInt(1000);

                Label resultAposta3 = new Label();
                resultAposta3.setSize(900, 300);

                if(aposta3 % 2 == 0 && numeroSorteado3 % 2 == 0) {
                    resultAposta3.setText("Você ganhou R$100,00! O número sorteado é par e você digitou um número par!");
                } else if (aposta3 % 2 == 1 && numeroSorteado3 % 2 == 1){
                    resultAposta3.setText("Você ganhou R$100,00! O número sorteado é ímpar e você digitou um número ímpar!");
                } else {
                    resultAposta3.setText("Você perdeu, número sorteado: " + numeroSorteado3);
                }
                resultAposta3.setFont(fontLabels);
                panelResult3.removeAll(); // Remover todos os componentes existentes
                panelResult3.add(resultAposta3);
                panelAposta3.revalidate();
            }
        });

        panelText3.add(textLabelAposta3);
        panelText3.add(inputAposta3);
        panelText3.add(btnConfirmar3);
        panelAposta3.add(panelResult3);


        panelAposta3.add(panelText3);
    }

    public static void aposta3() {}


    public void chamarActionListeners() {
        buttonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
                panelCover.setVisible(false);
                panelAposta1.setVisible(true);
                panelAposta2.setVisible(false);
                panelAposta3.setVisible(false);
            }
        });

        buttonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta2();
                panelAposta2.setVisible(true);
                panelAposta1.setVisible(false);
                panelAposta3.setVisible(false);
                panelCover.setVisible(false);
            }
        });

        buttonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
                panelAposta3.setVisible(true);
                panelAposta2.setVisible(false);
                panelAposta1.setVisible(false);
                panelCover.setVisible(false);
            }
        });

    }



    public static void main(String[] args) {
        new LotoFacilGUI();
    }

}
