package DemoUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;
public class UserRegistration {
    private List<String>usernames = new ArrayList<>();
    private List<String>passwords = new ArrayList<>();
    private List<String>emails = new ArrayList<>();

    private Scanner scanner =new Scanner(System.in);
    PrintStream screen= System.out;

    public void displaymenu(){
        boolean keepRunning = true;
        while(keepRunning){
            screen.println("\nMenu:");
            screen.println("1. crear usuario");
            screen.println("2. consultar usuario");
            screen.println("3. modificar usuario");
            screen.println("4. eliminar usuario");
            screen.println("Elige una opcion");
            String option = scanner.nextLine();
            switch(option){
                case "1":
                createUser();
                break;
                case "2":
                consultUser();
                break;
                case "3":
                modifyUser();
                break;
                case "4":
                deleteUser();
                break;
                case "5":
                keepRunning =false;
                break;
                default:
                screen.println("opcion no valida");

            }   
        }
    }
     private void createUser(){
        screen.print("introduce el nombre de usuario");
        usernames.add(scanner.nextLine());

        screen.print("introduce la contraseña");
        usernames.add(scanner.nextLine());

        screen.print("introduce el email");
        usernames.add(scanner.nextLine());

        screen.println("usuario creado exitosamente");
    }
    private int getUserIndexByUsername(String username){
        return usernames.indexOf(username);
    }
    private void consultUser(){
        System.out.print("introduce el nombre de usuario a consultar :");
        int index = getUserIndexByUsername(scanner.nextLine());
        if(index != -1){
            screen.println("usuario: " +usernames.get(index)+ ", Email: "+ emails.get(index));
        }else{
            screen.println("usuario no encontrado");
        }
    }
    private void modifyUser(){
        screen.print("introduce el nombre del usuario a modificar: ");
        int index= getUserIndexByUsername(scanner.nextLine());
        if (index != -1){
            screen.print("Introduce el nuevo email (actual: "+ emails.get(index)+"): " );
            emails.set(index,scanner.nextLine());
            screen.println("usuario modificado exitosamente. ");
        } else{
            screen.println("usuario no encontrado");
        }
    }
    private void deleteUser(){
        screen.print("introduce el nombre de usuario a eliminar: ");
        int index = getUserIndexByUsername(scanner.nextLine());
        if(index != -1){
            usernames.remove(index);
            passwords.remove(index);
            emails.remove(index);
            screen.println("usuario eliminado exitosamente");
        }else{
            screen.println("usuario no encontrado");
        }
   }
 
    public static void main(String[]args){
        new UserRegistration().displaymenu();

    }
}