
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DecryptFileView extends javax.swing.JFrame {
 
    String ID,filePath,st="";
    private BigInteger p;
    private BigInteger q;
    private BigInteger r;
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;
    private BigInteger phi;
    private final int N=2048;
    long time=0;
    private final static BigInteger one = new BigInteger("1");
    public DecryptFileView(String ID,String filePath) {
        initComponents();
        this.ID=ID;
        this.filePath=filePath;
        textView();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Decrypt");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 530, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void textView()
    {
        
        try
        {
        FileReader f1=new FileReader(filePath);
         BufferedReader br=new BufferedReader(f1);
         jTextArea1.read(br,null);
         br.close();
         jTextArea1.requestFocus();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"File Does Not exist.");
        }
    }
     
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        retrieve(jTextArea1.getText());
        System.out.println("Decryption Time in Milli Seconds: "+time/1000000);

    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void retrieve(String a)
    {
        int i=0,j=0,start_index=-1,end_index=-1,flag=0;
        while(i<a.length())
        {  st="";

            if(a.charAt(i)=='*')
            {
                start_index=i;
                j=i+1;
                while(a.charAt(j)!='*'&&j<a.length())
                {
                    
                    st=st+a.charAt(j);
                    j++;
                }
                end_index=j+1;
                flag=1;
                
                DecryptAlgo(st,start_index,end_index);
                break;
                
            }
                i++;
            
        }
        if(flag==0)
            return;
        retrieve(jTextArea1.getText());
         
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
       Decrypt d=new Decrypt(ID);
       d.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            BufferedWriter fw=null;
            
            try
            {
                
                File fileToSave = fileChooser.getSelectedFile();
                if(fileToSave==null)
                {
                    return;
                }
                if(fileToSave.exists())
                {
                     userSelection = JOptionPane.showConfirmDialog(this,
                                   "Replace existing file?");
                 if (userSelection == JOptionPane.NO_OPTION)
                    return;
                }
                fw=new BufferedWriter(new FileWriter(fileToSave));
                jTextArea1.write(fw);
                fw.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
    private void DecryptAlgo(String st,int start_index,int end_index)
    {
        p = new BigInteger("13640047657781151865528188757023801948018871523576735317687601356074648174131164801043977079381040509687217991433492905486660809030528138756434750379279625654630604229485719232674720890961134123386059837271");
        q = new BigInteger("12555143747421696120819599190515340419988664996974204804822062792296535223755520625517722652796931723736574663445978960994960034584343603769255532673842873902779927785852479804988458055034535740118993343537");
        r = new BigInteger("15502517192924842380065912747956093628192377639235479793655370487877451116856959550979033885783668262292849712317970958441024089531705480176402183907771096509424674019892111700177709508100120932596769312399");
        phi = ((p.subtract(one)).multiply(q.subtract(one))).multiply(r.subtract(one));
        modulus    = (p.multiply(q)).multiply(r);
        publicKey  = new BigInteger("65537");     
        privateKey = publicKey.modInverse(phi);
        BigInteger encryptedMessage=new BigInteger(st,16);
        long start=System.nanoTime();
        BigInteger decryptedMessage=decrypt(encryptedMessage);
        long end=System.nanoTime();
        time+=end-start;
        byte []bytes=decryptedMessage.toByteArray();
        String textDecryptedMessage=new String(bytes);
        jTextArea1.replaceRange(textDecryptedMessage, start_index, end_index);
    }
    private BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
