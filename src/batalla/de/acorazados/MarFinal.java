//INTEGRANTES:

//Guillén Mirabá José Felipe    
//Quimis Mendoza Jonathan Andy
//Victor Hugo Varas Roca

//CURSO:
//2-2


package batalla.de.acorazados;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author giamp
 */
public class MarFinal extends JPanel{
final JLabel[][] cuadrantes;
public MarFinal(){
VentanaJuego.listoBTN.setEnabled(false);
VentanaJuego.RUBTN.setVisible(false);
cuadrantes=new JLabel[11][11];
setPreferredSize(new Dimension(550,660));
setLayout(new GridLayout(11,11));
for(int i=0;i<11;i++){
    for(int j=0;j<11;j++){
    JLabel cuadro=new JLabel();
    if(i==0){
    cuadro.setIcon(new ImageIcon("C"+Integer.toString(j)+".png"));
    }
    else if(j==0){
    cuadro.setIcon(new ImageIcon("L"+Integer.toString(i)+".png"));
    }
    else{
    if(Batalla.Barcos[i-1][j-1]==5||Batalla.Barcos[i-1][j-1]==0){
    cuadro.setIcon(new ImageIcon("oceanoP.jpg"));}
    if(Batalla.Barcos[i-1][j-1]==1){
    cuadro.setIcon(new ImageIcon("BarcoJug.png"));}
    if(Batalla.Barcos[i-1][j-1]==2){
    cuadro.setIcon(new ImageIcon("BarcoComp.png"));}
    if(Batalla.Barcos[i-1][j-1]==3){
    cuadro.setIcon(new ImageIcon("BarcodestJug.png"));}
    if(Batalla.Barcos[i-1][j-1]==4){
    cuadro.setIcon(new ImageIcon("BarcodestComp.png"));}
    }
    cuadrantes[i][j]=cuadro;
    add(cuadro);       
    }
}
}   
    
}
