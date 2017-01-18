/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.DefaultListModel;
import napakalaki.BadConsequence;
import napakalaki.DeathBadConsequence;
import napakalaki.NumericBadConsequence;
import napakalaki.SpecificBadConsequence;

/**
 *
 * @author Alexis
 */
public class BadConsequenceView extends javax.swing.JPanel {

    /**
     * Creates new form BadConsequenceView
     */
    private BadConsequence badConModel;
    
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence b){
        this.badConModel = b;
        this.descrip.setText(this.badConModel.getText());
        this.levels.setText(Integer.toString(badConModel.getLevels()));
        //Para que muestre cero si no hay ninguna
        this.nHidden.setText(Integer.toString(0));
        this.nVisible.setText(Integer.toString(0));
        //Para establecer los specific aun que no haya ninguno
        //También nos silve para el death
        DefaultListModel ht = new DefaultListModel();
        DefaultListModel vt = new DefaultListModel();
        this.specificHidden.setModel(ht);
        this.specificVisible.setModel(vt);
        
        if(badConModel instanceof NumericBadConsequence){
           this.nVisible.setText(Integer.toString(((NumericBadConsequence)badConModel).getNVisibleTreasures()));
           this.nHidden.setText(Integer.toString(((NumericBadConsequence)badConModel).getNHiddenTreasures()));
        }else if(badConModel instanceof SpecificBadConsequence){
            if ((((SpecificBadConsequence)badConModel)).getSpecificHiddenTreasures() != null){
                for(int i = 0; i < (((SpecificBadConsequence)badConModel)).getSpecificHiddenTreasures().size(); i++)
                    ht.add(i, (((SpecificBadConsequence)badConModel)).getSpecificHiddenTreasures().get(i));
            }
            this.specificHidden.setModel(ht);
            
            if ((((SpecificBadConsequence)badConModel)).getSpecificVisibleTreasures() != null){
                for(int i = 0; i <(((SpecificBadConsequence)badConModel)).getSpecificVisibleTreasures().size(); i++)
                    vt.add(i,(((SpecificBadConsequence)badConModel)).getSpecificVisibleTreasures().get(i));
            }
            this.specificVisible.setModel(vt);
        }
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        descrip = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        specificVisible = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        specificHidden = new javax.swing.JList();
        levels = new javax.swing.JLabel();
        nVisible = new javax.swing.JLabel();
        nHidden = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 255)));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("BAD CONSEQUENCE");

        descrip.setText("jLabel2");

        jLabel2.setText("Levels:");

        jLabel3.setText("Visible Treasures:");

        jLabel4.setText("Hidden Treasures:");

        jLabel5.setText("Specific Visible Treasures:");

        jLabel6.setText("Specific Hidden Treasures:");

        specificVisible.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        specificVisible.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(specificVisible);

        specificHidden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        specificHidden.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(specificHidden);

        levels.setText("jLabel7");

        nVisible.setText("jLabel7");

        nHidden.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(levels)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addComponent(nVisible)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel4)
                                .addGap(33, 33, 33)
                                .addComponent(nHidden))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descrip)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(levels)
                    .addComponent(nVisible)
                    .addComponent(nHidden))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel nHidden;
    private javax.swing.JLabel nVisible;
    private javax.swing.JList specificHidden;
    private javax.swing.JList specificVisible;
    // End of variables declaration//GEN-END:variables
}