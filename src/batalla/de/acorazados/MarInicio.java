//INTEGRANTES:

//Guillén Mirabá José Felipe    
//Quimis Mendoza Jonathan Andy
//Victor Hugo Varas Roca

//CURSO:
//2-2


package batalla.de.acorazados;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MarInicio extends JPanel {
final JLabel[][] cuadrantes;
public MarInicio(){
VentanaJuego.listoBTN.setEnabled(false);
VentanaJuego.RUBTN.setVisible(false);
Batalla.reubicar();
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
    Batalla.Barcos[i-1][j-1]=0;
    cuadro.setIcon(new ImageIcon("oceanoP.jpg"));
    cuadro.addMouseListener(crearEvento(i,j));
    }
    cuadrantes[i][j]=cuadro;
    add(cuadro);       
    }
}
}
public MouseListener crearEvento(int i,int j){
    MouseListener oyente=new MouseListener(){
    @Override
    public void mouseClicked(MouseEvent me) {
    if(Batalla.getBarJug()<5&&Batalla.Barcos[i-1][j-1]==0){
    ImageIcon barco=new ImageIcon("BarcoJug.png");
    cuadrantes[i][j].setIcon(barco);
    Batalla.Barcos[i-1][j-1]=1;
    Batalla.colocarBarJug();
    if(Batalla.getBarJug()==5)
    {
    VentanaJuego.RUBTN.setVisible(true);
    VentanaJuego.listoBTN.setEnabled(true);
    }    
    }
    }
    @Override
    public void mousePressed(MouseEvent me) {
    }
    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mouseExited(MouseEvent me) {
    }

};
return oyente;
}
}
