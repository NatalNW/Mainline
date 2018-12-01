package software.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import software.classes.CnxSQL;
import software.classes.DadosOshi;
import software.classes.JSlack;
import software.classes.arquivoLog;

public class BemVindo extends javax.swing.JFrame {

    private int i = 0;
    private final JSlack jslack = new JSlack();
    private DadosOshi oshi = new DadosOshi();
    private final String idAtivo = oshi.getAtivoID();
    private CnxSQL insertRede = new CnxSQL();
    private CnxSQL insertCpu = new CnxSQL();
    private CnxSQL insertHD = new CnxSQL();
    private CnxSQL insertRam = new CnxSQL();
    public arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");
    private Date dataHoraAtual = new Date();
    private String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    private String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

    public BemVindo() {
        this.ram = () -> {
            while (true) {
                try {

                    try {
                        insertRam.insertComponente("infoRam", "infoRam", "Ram", oshi.getConsumoRam(), 20000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv Ram", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                         arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.hd = () -> {
            while (true) {
                try {

                    try {
                        insertHD.insertComponente("infoHD", "infoHD", "HD", oshi.getConsumoHD(), 600000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv hd", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                         arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.cpu = () -> {
            while (true) {
                try {

                    try {
                        insertCpu.insertComponente("infoCpu", "infoCpu", "CPU", oshi.getConsumoCPU(), 20000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv cpu", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.rede = () -> {
            while (true) {
                try {
                    try {
                        insertRede.insertRede();
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv Rede", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bntIniciar = new javax.swing.JButton();
        jlBemVindo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntIniciar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bntIniciar.setText("Iniciar");
        bntIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bntIniciarActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " Erro na execução! método: actionPerformed.");
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });

        jlBemVindo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N   

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Clque no botão iniciar para coletar os dados de seu ativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(121, 121, 121)
                                                .addComponent(jlBemVindo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(bntIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlBemVindo)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(bntIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>                        

    private void bntIniciarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (i % 2 == 0) {
            jLabel2.setText("Captura de dados iniciada. ID deste Ativo: " + idAtivo);
            bntIniciar.setText("Fechar");
            jslack.capturaIniciada(idAtivo);
            new Thread(ram).start();
            new Thread(cpu).start();
            new Thread(hd).start();
            new Thread(rede).start();
            arq.escreverLog(quebraLinha + data2 + hora2 + " Captura de dados iniciada. ID deste Ativo:" + idAtivo);
            i++;
        } else {
            jslack.fimCaptura();
            arq.escreverLog(quebraLinha + data2 + hora2 + " Fim da captura de dados.");
            System.exit(0); // fecha a aplicação com saida 0(sem erros)
        }
    }

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BemVindo().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bntIniciar;
    public javax.swing.JLabel jlBemVindo;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration                   

    private final Runnable ram;
    private final Runnable cpu;
    private final Runnable hd;
    private final Runnable rede;

}
