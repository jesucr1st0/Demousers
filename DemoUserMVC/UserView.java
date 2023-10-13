package DemoUserMVC;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class UserView {
    public void printUserDetails(User user){
        String message ="USER DETAILS\n\n";
        message += "Username : "+user.getUsername()+"\n";
        message += "Password : "+user.getPassword()+"\n";
        message +="Email : "+user.getEmail()+"\n";
        JOptionPane.showMessageDialog(null, message);
    }
    public String getInput(String message){
        return JOptionPane.showInputDialog(null,message);
    }
    public void showMessage(String message){
        System.out.println(message);
    }
    public void displayMenu(){
        System.out.println("1. Crear usuario");
        System.out.println("2. Consultar usuario");
        System.out.println("3. Modificar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
        System.out.println("Selecciona una opcion: ");
    }
    
}
