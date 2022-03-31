package view;

import com.adobe.acrobat.Viewer;
import com.adobe.acrobat.ViewerCommand;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TelaAjuda extends javax.swing.JFrame implements TreeSelectionListener {

    private DefaultMutableTreeNode raiz;
    private Viewer panel;
String verifi;
    public TelaAjuda() throws Exception {

        raiz = new DefaultMutableTreeNode("Ajuda");

        DefaultMutableTreeNode telas;
        DefaultMutableTreeNode telas2;
        DefaultMutableTreeNode telas3;

        telas = new DefaultMutableTreeNode("Tela Inicial");
        telas2 = new DefaultMutableTreeNode("Tela de Configurações");
        telas3 = new DefaultMutableTreeNode("Tela de Autorização");
        raiz.add(telas);
        raiz.add(telas2);
        raiz.add(telas3);

        arvoreTopicosAjuda = new JTree(raiz);

        initComponents();
        layoutAreaPdf();

        arvoreTopicosAjuda.addTreeSelectionListener(this);
        add(panel);


    }

    public void layoutAreaPdf() throws Exception {
        panel = new Viewer();
        panel.setBackground(Color.WHITE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 28, Short.MAX_VALUE));

        jScrollPane3.setViewportView(arvoreTopicosAjuda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 568, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        pack();
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
        System.out.println(arvoreTopicosAjuda.getLastSelectedPathComponent().toString());
        verifi = arvoreTopicosAjuda.getLastSelectedPathComponent().toString();
        String caminho = new File("src/br/com/sispav/gui/ajuda").getAbsolutePath().toString();
        if (verifi.equalsIgnoreCase("Tela de Configurações")) {
            try {

//Este é o trecho do código do pdf

                InputStream file = new FileInputStream(caminho + "/Tela de Configurações.pdf");
                panel.setDocumentInputStream(file);

                panel.setEnableDebug(true);

                panel.setProperty("Default_Page_Layout", "SinglePage");
                panel.setProperty("Default_Zoom_Type", "FitPage");
                panel.setProperty("Default_Magnification", "100");

                System.out.println("Page Count: " + panel.getPageCount());
                System.out.println("Current Page: " + panel.getCurrentPage());

                panel.zoomTo(1.0);
                panel.execMenuItem(ViewerCommand.FitPage_K);

                panel.activate();

                setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
            } catch (Exception ex) {
                Logger.getLogger(TelaAjuda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (verifi.equalsIgnoreCase("Tela Inicial")) {
            try {
                System.out.println("caiu aqui");


//Este é o trecho do código do pdf

                InputStream file = new FileInputStream(caminho + "/Tela Inicial.pdf");
                panel.setDocumentInputStream(file);

                panel.setEnableDebug(true);

                panel.setProperty("Default_Page_Layout", "SinglePage");
                panel.setProperty("Default_Zoom_Type", "FitPage");
                panel.setProperty("Default_Magnification", "100");

                System.out.println("Page Count: " + panel.getPageCount());
                System.out.println("Current Page: " + panel.getCurrentPage());

                panel.zoomTo(1.0);
                panel.execMenuItem(ViewerCommand.FitPage_K);

                panel.activate();

                setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
            } catch (Exception ex) {
                Logger.getLogger(TelaAjuda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (verifi.equalsIgnoreCase("Tela de Autorização")) {
            try {

//Este é o trecho do código do pdf

                System.out.println("caiu aqui");
                      InputStream file = new FileInputStream(caminho + "/Tela de autorização.pdf");
                panel.setDocumentInputStream(file);

                panel.setEnableDebug(true);

                panel.setProperty("Default_Page_Layout", "SinglePage");
                panel.setProperty("Default_Zoom_Type", "FitPage");
                panel.setProperty("Default_Magnification", "100");

                System.out.println("Page Count: " + panel.getPageCount());
                System.out.println("Current Page: " + panel.getCurrentPage());

                panel.zoomTo(1.0);
                panel.execMenuItem(ViewerCommand.FitPage_K);

                panel.activate();

                setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
            } catch (Exception ex) {
                Logger.getLogger(TelaAjuda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jl_titulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        arvoreTopicosAjuda = new JTree(raiz);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuda");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel23.setBackground(new java.awt.Color(201, 222, 239));

        jl_titulo.setBackground(new java.awt.Color(201, 222, 239));
        jl_titulo.setFont(new java.awt.Font("Eras Bold ITC", 1, 36)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(0, 102, 204));
        jl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //jl_titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sispav/imagens/logo sample.png"))); // NOI18N
        jl_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jl_titulo.setOpaque(true);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(636, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jl_titulo))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(arvoreTopicosAjuda);

        jButton1.setText("Ler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Parar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(68, 68, 68))))
        );

        pack();
    }// </editor-fold>                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    
    	/*
        if(verifi.equalsIgnoreCase("Tela Inicial")){
         ExecutaSomTelaInicial executa = new ExecutaSomTelaInicial();
        Thread tre = new Thread(executa);
        tre.start();
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
     
        }else if(verifi.equalsIgnoreCase("Tela de Autorização")){
         ExecutaSomTelaAuto executa = new ExecutaSomTelaAuto();
        Thread tre = new Thread(executa);
        tre.start();
         jButton1.setEnabled(false);
         jButton2.setEnabled(true);
        }else if(verifi.equalsIgnoreCase("Tela de Configurações")){
         ExecutaSomTelaconfi executa = new ExecutaSomTelaconfi();
        Thread tre = new Thread(executa);
        tre.start();
         jButton1.setEnabled(false);
         jButton2.setEnabled(true);
        }
     */
     
    }                                      

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                      
      //Sintetizador.player.close();
      jButton1.setEnabled(true);
         jButton2.setEnabled(false);
    }                                      

    // Variables declaration - do not modify                  
    private javax.swing.JTree arvoreTopicosAjuda;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jl_titulo;
    // End of variables declaration                

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAjuda().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
