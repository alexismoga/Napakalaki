/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.Prize;

/**
 *
 * @author Alexis
 */
public class PrizeView extends javax.swing.JPanel {

    private Prize prizeModel;
    
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize p){
        this.prizeModel=p;
        this.level.setText(Integer.toString(prizeModel.getLevel()));
        this.treasures.setText(Integer.toString(prizeModel.getTreasures()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloPrize = new javax.swing.JLabel();
        etiquetaTrea = new javax.swing.JLabel();
        etiquetaLevel = new javax.swing.JLabel();
        treasures = new javax.swing.JLabel();
        level = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 0)));

        TituloPrize.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        TituloPrize.setText("PRIZE");

        etiquetaTrea.setText("Treasures :");

        etiquetaLevel.setText("Level:");

        treasures.setText("....");

        level.setText("....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(TituloPrize))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(treasures)
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(level)
                                    .addComponent(etiquetaLevel)))
                            .addComponent(etiquetaTrea))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloPrize)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTrea)
                    .addComponent(etiquetaLevel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treasures)
                    .addComponent(level))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloPrize;
    private javax.swing.JLabel etiquetaLevel;
    private javax.swing.JLabel etiquetaTrea;
    private javax.swing.JLabel level;
    private javax.swing.JLabel treasures;
    // End of variables declaration//GEN-END:variables
}
