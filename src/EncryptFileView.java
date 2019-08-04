import java.io.*;
import javax.swing.JOptionPane;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
public class EncryptFileView extends javax.swing.JFrame {
   private final static BigInteger one = new BigInteger("1");
   private BigInteger privateKey;
   private BigInteger publicKey;
   private BigInteger modulus;
   private BigInteger phi;
   private final int N=2048;
   long time=0;
    
    String ID,filePath,st="",keyPath,y1="";
    public EncryptFileView(String ID,String filePath,String keyPath) {
        this.ID=ID;
        this.filePath=filePath;
        this.keyPath=keyPath;
        initComponents();
        textView();
    }
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
            System.out.println(e);
            JOptionPane.showMessageDialog(this,"File Does Not exist.");
        }
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

        jButton1.setText("Encrypt");
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
                        .addGap(16, 16, 16)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 559, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getPublicKey();
        int start_index,end_index,i=0,j,end=0;
       String x="";
       String a=jTextArea1.getSelectedText();
       try
       {
       end=a.length();
       }
       catch(Exception abc)
       {
           JOptionPane.showMessageDialog(this,"Please Select Some Text.");
           return;
       }
       if(a.length()>240)
       {
           for(i=0;i<end;i+=240)
           {
           x = a.substring(i, Math.min(end, i + 240));
           EncryptionAlgo(x);
           }
           jTextArea1.setText(y1);
       }
       else{
           
       start_index=jTextArea1.getSelectionStart();
       end_index=jTextArea1.getSelectionEnd();
       EncryptionAlgo(a,start_index,end_index);
       }
       System.out.println("Encryption Time in Milli Seconds: "+time/1000000);
       
       
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FileWriter fw;
       try {
           fw = new FileWriter(filePath);
           fw.write(jTextArea1.getText());
           fw.close();
       } catch (IOException ex) {
           System.out.println(ex);
       }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        EncryptAndKeyUpload eaku=new EncryptAndKeyUpload(ID);
        eaku.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
  
    private void getPublicKey()
    {
        
        String publickey="",x="",e="";
         try
        {
          FileReader fr =new FileReader(keyPath); 
          int i=0,j=0,k=0; 
          while ((i=fr.read()) != -1) 
          {
              x+=(char)i;
          }
          i=0;
          while(i<x.length())
          {
              if(x.charAt(i)=='*')
              {
                  j=i+1;
                  while(x.charAt(j)!='*')
                  {
                      publickey+=x.charAt(j);
                      j++;
                  }
                  break;
                
              }
              i++;
          }
          j++;
          while(j<x.length())
          {
              if(x.charAt(j)=='*')
              {
                  k=j+1;
                  while(x.charAt(k)!='*')
                  {
                      e+=x.charAt(k);
                      k++;
                  }
                  break;
              }
              j++;
          }
          modulus=new BigInteger(publickey);
          publicKey=new BigInteger(e);
         
     
        }
        catch(Exception em)
        {
           System.out.println(em);
           JOptionPane.showMessageDialog(this,"File Does Not exist.");
        }
    }
    private void EncryptionAlgo(String a) 
        {
            String textEncryptedMessage="";
            byte []bytes=a.getBytes();
            BigInteger numericalMessage=new BigInteger(bytes);
            long start = System.nanoTime();
            BigInteger numericalEncryptedMessage=encrypt(numericalMessage);
            long finish=System.nanoTime(); 
            long timeElapsed=finish-start;
            time+=timeElapsed;
            textEncryptedMessage=numericalEncryptedMessage.toString(16);
            String y="*"+textEncryptedMessage+"*";
            y1=y1+y;
            //System.out.println(y1);
            //jTextArea1.replaceRange(y, start_index, end_index);
        }
    private void EncryptionAlgo(String a,int start_index,int end_index) 
        {
            String textEncryptedMessage="";
            byte []bytes=a.getBytes();
            BigInteger numericalMessage=new BigInteger(bytes);
            long start = System.nanoTime();
            BigInteger numericalEncryptedMessage=encrypt(numericalMessage);
            long finish=System.nanoTime(); 
            long timeElapsed=finish-start;
            time+=timeElapsed;
            textEncryptedMessage=numericalEncryptedMessage.toString(16);
            String y="*"+textEncryptedMessage+"*";
            jTextArea1.replaceRange(y, start_index, end_index);
        }
    private BigInteger encrypt(BigInteger message) {
      return message.modPow(publicKey, modulus);
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