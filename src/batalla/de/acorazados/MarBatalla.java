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

public class MarBatalla extends JPanel{
final JLabel[][] blancos;
public MarBatalla(){
blancos=new JLabel[11][11];
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
    cuadro.setIcon(new ImageIcon("oceanoP.jpg"));
    cuadro.addMouseListener(crearEvento(i,j));
    }
    blancos[i][j]=cuadro;
    add(cuadro);       
    }
}
}
public MouseListener crearEvento(int i,int j){
    MouseListener oyente=new MouseListener(){
    @Override
    public void mouseClicked(MouseEvent me) {
    if(Batalla.Barcos[i-1][j-1]<3){
    VentanaJuego.area.setText("");
    ImageIcon barcoDestComp=new ImageIcon("BarcodestComp.png");
    ImageIcon barcoDestJug=new ImageIcon("BarcodestJug.png");
    ImageIcon alAgua=new ImageIcon("oceanoPi.jpg");
    if(Batalla.Barcos[i-1][j-1]==1)
    {
    blancos[i][j].setIcon(barcoDestJug);
    }
    if(Batalla.Barcos[i-1][j-1]==2)
    {
    blancos[i][j].setIcon(barcoDestComp);
    }
    if(Batalla.Barcos[i-1][j-1]==1){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Oh no,hundiste tu propio barco"+"\n");
    Batalla.destruirBarJug();
    Batalla.Barcos[i-1][j-1]=3;
    }
    if(Batalla.Barcos[i-1][j-1]==2){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Boom, hundiste un barco enemigo"+"\n");
    Batalla.destruirBarCom();
    Batalla.Barcos[i-1][j-1]=4;
    }
    if(Batalla.Barcos[i-1][j-1]==0){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Al agua, te lo perdiste"+"\n");
    Batalla.Barcos[i-1][j-1]=5;
    blancos[i][j].setIcon(alAgua);
    }
    if(Batalla.getBarJug()==0||Batalla.getBarCom()==0){    
    if(Batalla.getBarCom()==0){
    VentanaJuego.area.setText("\n"+"             ¡ Felicidades !"+"\n"+"                Ganaste"+"\n"+"\n"+"\n"+"\n");}
    if(Batalla.getBarJug()==0){
    VentanaJuego.area.setText("\n"+"             ¡ Lo siento !"+"\n"+"                Perdiste"+"\n"+"\n"+"\n"+"\n");
    }
    VentanaJuego.finalizar();
    }
    else{
    // Computadora:
    boolean val=false;
    while(val==false){
    int x=(int)(Math.random()*10);
    int y=(int)(Math.random()*10);
    if(Batalla.Barcos[x][y]<3){
    if(Batalla.Barcos[x][y]==1)
    {
    blancos[x+1][y+1].setIcon(barcoDestJug);
    }
    if(Batalla.Barcos[x][y]==2)
    {
    blancos[x+1][y+1].setIcon(barcoDestComp);
    }
    if(Batalla.Barcos[x][y]==1){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Oh no, la computadora hundió tu barco"+"\n");
    Batalla.destruirBarJug();
    Batalla.Barcos[x][y]=3;
    }
    if(Batalla.Barcos[x][y]==2){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Boom, la computadora hundió su propio barco"+"\n");
    Batalla.destruirBarCom();
    Batalla.Barcos[x][y]=4;
    }
    if(Batalla.Barcos[x][y]==0){
    VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"-Al agua, la computadora se lo perdió"+"\n");
    blancos[x+1][y+1].setIcon(alAgua);
    Batalla.Barcos[x][y]=5;
    }
    val=true;
    }
    }
    if(Batalla.getBarCom()==0){
    VentanaJuego.finalizar();
    VentanaJuego.area.setText("\n"+"             ¡ Felicidades !"+"\n"+"                Ganaste"+"\n"+"\n"+"\n"+"\n");
    if(Batalla.getBarJug()==0){
    VentanaJuego.area.setText("\n"+"             ¡ Lo siento !"+"\n"+"                Perdiste"+"\n"+"\n"+"\n"+"\n");
    }
    }
    }
     VentanaJuego.area.setText(VentanaJuego.area.getText()+"\n"+"Barcos aliados: "+Batalla.getBarJug()+"\n"+"Barcos enemigos: "+Batalla.getBarCom()+"\n");
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
