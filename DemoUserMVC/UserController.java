package DemoUserMVC;

public class UserController {
    private UserModel model;
    private UserView view;
    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }
    public void run() {
        boolean keepRunning = true;
        while(keepRunning){
            view.displayMenu();
            String option = view.getInput("");
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
                view.showMessage("opcion no valida");
            }
        }
        view.showMessage("Hasta pronto!");    
    }
    private void createUser(){
        String username = view.getInput("introduce el nombre de usuario");
        String password = view.getInput("introduce la contraseña");
        String email = view.getInput("introduce el email");
        model.addUser(new User(username,password,email));
        view.showMessage("usuario creado exitosamente");
    } 
    private void consultUser(){
        String username = view.getInput("introduce el nombre de usuario a consultar :");
        User user = model.getUserByUsername(username);
        if(user != null){
            view.printUserDetails(user);
        }else{
            view.showMessage("usuario no encontrado");
        }
    }  
    private void modifyUser(){
        String username = view.getInput("introduce el nombre del usuario a modificar: ");
        User user = model.getUserByUsername(username);
        if(user != null){
            String password = view.getInput("introduce la nueva contraseña: ");
            String email = view.getInput("introduce el nuevo email: ");
            user.setPassword(password);
            user.setEmail(email);
            view.showMessage("usuario modificado exitosamente");
        }else{
            view.showMessage("usuario no encontrado");
        }
    }

    private void deleteUser(){
        String username = view.getInput("introduce el nombre del usuario a eliminar: ");
        User user = model.getUserByUsername(username);
        if(user != null){
            model.deleteUser(user);
            view.showMessage("usuario eliminado exitosamente");
        }else{
            view.showMessage("usuario no encontrado");
        }
    }
}
