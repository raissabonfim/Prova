import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TENHA PIEDADE NA HORA DE CORRIGIR POIS MEU CODIGO N RODOU :( E AINDA MEU NOT N RODA O INTELL
//PROFESSOR QUERIDO CLEITINHO, SUAS AULAS SÃO MELHORES QUE A DO RODRIGO(QUE ELE NÃO VEJA ISSO) MAS AS PROVA DO RODRIGO SÃO MAIS TRANQUILA.
//OBRIGA POR LER ATÉ AQUI! QUE DEUS TE ABENÇÕE.

public class Sistema_Bancario_Simples {

    private Double saldo = 500.00;
    private Double cleitinho;

    private JButton btnSaque;
    private JButton btnDepositar;
    private JTextField txtValor;
    private JTextField txtvalor2;
    private JButton btnLimpar;
    private JLabel lblSaldo;
    private JButton btnRealizarSaque;
    private JButton btnRealizarDeposito;
    private JLabel lblInformeoValorDoSaque;
    private JLabel lblInformeoValorDoDeposito;
    private JLabel lblMensagem;
    private JPanel panelMain;

    public Sistema_Bancario_Simples() {
        lblSaldo.setText("R$ " + String.format("%.2f", saldo));
        lblInformeoValorDoSaque.setText("Informe o valor do saque");
        lblInformeoValorDoDeposito.setText("Informe o valor do depósito");

        btnRealizarDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtvalor2.getText().replace(",", ".").isEmpty()) {
                    lblMensagem.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitinho = Double.parseDouble(txtvalor2.getText().replace(",", "."));
                    if (cleitinho > 1000.00) {
                        lblMensagem.setText("Depósito acima do limite permitido!");
                    } else if (cleitinho < 0) {
                        lblMensagem.setText("Valor negativo!");
                    } else {
                        lblMensagem.setText("Depósito realizado com sucesso!");
                        saldo = saldo + cleitinho;
                        lblSaldo.setText("R$ " + String.format("%.2f", saldo));
                        cleitinho = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    lblMensagem.setText("Erro! Insira somente números!");
                }
            }
        });

        btnRealizarSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtValor.getText().replace(",", ".").isEmpty()) {
                    lblMensagem.setText("Informe um valor!");
                    return;
                }
                try {
                    cleitinho = Double.parseDouble(txtValor.getText().replace(",", "."));
                    if (cleitinho > saldo) {
                        lblMensagem.setText("Saldo insuficiente!");
                    } else if (cleitinho < 0) {
                        lblMensagem.setText("Valor negativo!");
                    } else {
                        lblMensagem.setText("Saque realizado com sucesso!");
                        saldo = saldo - cleitinho;
                        lblSaldo.setText("R$ " + String.format("%.2f", saldo));
                        cleitinho = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    lblMensagem.setText("Erro! Insira somente números!");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText("");
                txtvalor2.setText("");
                lblMensagem.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Bancário");
        frame.setContentPane(new Sistema_Bancario_Simples().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

//ME ESFORÇAREI MELHOR PRA APRENDER PROGRAMAÇÃO! TENHA PIEDADE DE MIM.




