import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LotoFacilGUI {
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
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        buttonAposta1.setPreferredSize(new Dimension(200,30));
        buttonAposta1.setBackground(Color.white);
        buttonAposta2.setPreferredSize(new Dimension(200,30));
        buttonAposta2.setBackground(Color.white);
        buttonAposta3.setPreferredSize(new Dimension(200,30));
        buttonAposta3.setBackground(Color.white);

        panelButtons.add(buttonAposta1);
        panelButtons.add(buttonAposta2);
        panelButtons.add(buttonAposta3);

        panelCover.setSize(900, 560);
        ImageIcon coverImage = new ImageIcon("coverimg4.png");
        JLabel labelImg = new JLabel(coverImage);
        panelCover.add(labelImg);

        frame.add(panelAposta1);
        frame.add(panelAposta2);
        frame.add(panelAposta3);
        frame.add(panelButtons);
        frame.add(panelCover);
    }

    private JPanel panelText = new JPanel();   // painel p dispor o texto descritivo da aposta, o input e o botao de apostar
    private JPanel panelResult = new JPanel();  // mostra o resultado da aposta, tem uma label dentro
    private JLabel textDescApostaLabel = new JLabel(); //label que vai ter o texto descritivo ("entre com/digite..)
    private JTextField inputAposta = new JTextField();  // inputar dados (número ou letra
    Label resultAposta = new Label();   // vai aparecer o resultado da aposta em formato de texto
    JButton btnConfirmar1 = new JButton("Apostar");

    public void configurarPanelAposta1() {
        panelText.setBounds(0, 50, 900, 50);
        panelText.setBackground(Color.white);
        panelResult.setBounds(0, 150, 900, 100);
        panelResult.setBackground(Color.white);

        panelAposta1.setLayout(null);
        panelAposta1.setBounds(0, 50, 900, 520);
        panelAposta1.setBackground(Color.white);
        panelAposta1.setVisible(false);

        textDescApostaLabel.setText("Entre com um número de 0 a 100: ");
        textDescApostaLabel.setFont(fontLabels);
        textDescApostaLabel.setBounds(20, 50, 900, 200);

        inputAposta.setPreferredSize(new Dimension(100, 30));

        btnConfirmar1.setPreferredSize(new Dimension(100, 30));
        btnConfirmar1.setBackground(Color.white);

        panelText.add(textDescApostaLabel);
        panelText.add(inputAposta);
        panelText.add(btnConfirmar1);

        btnConfirmar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
            }
        });

        panelAposta1.add(panelText);
        panelAposta1.add(panelResult);
    }

    public void aposta1() {
        String valorInput = inputAposta.getText();
        int aposta1 = Integer.parseInt(valorInput);

        Random random1 = new Random();
        int numeroSorteado = random1.nextInt(101);

        if (aposta1 == numeroSorteado) {
            resultAposta.setText("Parabéns! Você ganhou R$1.000,00 reais");
        } else {
            resultAposta.setText("Você perdeu! O número sorteado foi: " + numeroSorteado);
        }
        resultAposta.setFont(fontLabels);
        panelResult.removeAll(); // remover todos os componentes existentes
        panelResult.add(resultAposta);
        panelAposta1.revalidate();
    }

    private JPanel panelText2 = new JPanel();
    private JPanel panelResult2 = new JPanel();
    private JLabel textDescApostaLabel2 = new JLabel();
    private JTextField inputAposta2 = new JTextField();
    Label resultAposta2 = new Label();
    JButton btnConfirmar2 = new JButton("Apostar");
    public void configurarPanelAposta2() {
        panelAposta2.setLayout(null);
        panelAposta2.setBounds(0, 50, 900, 520);
        panelAposta2.setBackground(Color.white);
        panelAposta2.setVisible(false);

        panelText2.setBounds(0, 50, 900, 50);
        panelText2.setBackground(Color.white);

        panelResult2.setBounds(0, 150, 900, 100);
        panelResult2.setBackground(Color.white);

        textDescApostaLabel2.setText("Digite uma letra de A à Z:");
        textDescApostaLabel2.setFont(fontLabels);
        textDescApostaLabel2.setBounds(20, 50, 900, 200);
        inputAposta2.setPreferredSize(new Dimension(100, 30));

        btnConfirmar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta2();
            }
        });

        panelText2.add(textDescApostaLabel2);
        panelText2.add(inputAposta2);
        panelText2.add(btnConfirmar2);
        panelAposta2.add(panelResult2);

        panelAposta2.add(panelText2);
    }

    public void aposta2() {
        String valorInput = inputAposta2.getText();
        char aposta2 = valorInput.charAt(0);

        Random random2 = new Random();
        char letraSorteada = (char) (random2.nextInt(26) + 'A');

        if (Character.toUpperCase(aposta2) == letraSorteada) {
            resultAposta2.setText("Você ganhou R$ 500,00 reais!");
        } else {
            resultAposta2.setText("Você perdeu! A letra sorteada foi: " + letraSorteada);
        }
        resultAposta2.setFont(fontLabels);
        panelResult2.removeAll(); // Remover todos os componentes existentes
        panelResult2.add(resultAposta2);
        panelAposta1.revalidate();
    }


    private JPanel panelText3 = new JPanel();
    private JPanel panelResult3 = new JPanel();
    private JLabel textDescApostaLabel3 = new JLabel();
    private JTextField inputAposta3 = new JTextField();
    Label resultAposta3 = new Label();
    JButton btnConfirmar3 = new JButton("Apostar");
    public void configurarPanelAposta3() {
        panelAposta3.setLayout(null);
        panelAposta3.setBounds(0, 50, 900, 520);
        panelAposta3.setBackground(Color.white);
        panelAposta3.setVisible(false);

        panelText3.setBounds(0, 50, 900, 50);
        panelText3.setBackground(Color.white);

        panelResult3.setBounds(0, 150, 900, 100);
        panelResult3.setBackground(Color.white);

        textDescApostaLabel3.setText("Digite um número: ");
        textDescApostaLabel3.setFont(fontLabels);
        textDescApostaLabel3.setBounds(20, 50, 900, 200);

        inputAposta3.setPreferredSize(new Dimension(100, 30));

        btnConfirmar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
            }
        });

        panelText3.add(textDescApostaLabel3);
        panelText3.add(inputAposta3);
        panelText3.add(btnConfirmar3);
        panelAposta3.add(panelResult3);

        panelAposta3.add(panelText3);
    }

    public void aposta3() {
        String valorInput = inputAposta3.getText();
        int aposta3 = Integer.parseInt(valorInput);

        Random random3 = new Random();
        int numeroSorteado3 = random3.nextInt(1000);

        resultAposta3.setSize(900, 300);

        if (aposta3 % 2 == 0 && numeroSorteado3 % 2 == 0) {
            resultAposta3.setText("Você ganhou R$100,00! O número sorteado é par e você digitou um número par!");
        } else if (aposta3 % 2 == 1 && numeroSorteado3 % 2 == 1) {
            resultAposta3.setText("Você ganhou R$100,00! O número sorteado é ímpar e você digitou um número ímpar!");
        } else {
            resultAposta3.setText("Você perdeu, número sorteado: " + numeroSorteado3);
        }
        resultAposta3.setFont(fontLabels);
        panelResult3.removeAll(); // remover todos os componentes existentes
        panelResult3.add(resultAposta3);
        panelAposta3.revalidate();
    }


    public void chamarActionListeners() {
        buttonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCover.setVisible(false);
                panelAposta1.setVisible(true);
                panelAposta2.setVisible(false);
                panelAposta3.setVisible(false);
            }
        });

        buttonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAposta2.setVisible(true);
                panelAposta1.setVisible(false);
                panelAposta3.setVisible(false);
                panelCover.setVisible(false);
            }
        });

        buttonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
