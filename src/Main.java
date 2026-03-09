
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        TiendaService tienda = new TiendaService();
        Scanner sc = new Scanner(System.in);


        // Registrar usuarios
        System.out.println("ingrese datos del usuario");

        System.out.print("Ingrese su nombre: ");

        String nombre = sc.nextLine();

        System.out.print("Ingrese su email: ");

        String email = sc.nextLine();

        System.out.print("Ingrese su ID: ");

        int id = sc.nextInt();

        Usuario u1 = new Usuario(nombre, email,id);

        tienda.registrarUsuario(u1);


        // Registrar materiales


        System.out.println("1.carne 2.verdura 3.olla 4.utenciulios");
        System.out.print("ingrese material para registrar: ");
        int numeromaterial = sc.nextInt();

        sc.nextLine();
        switch(numeromaterial) {
            case 1: {
                // Registrar carne
                System.out.print("ingrese datos de la carne");

                System.out.print("\nIngrese nombre: ");
                String carnom = sc.nextLine();

                System.out.print("\nIngrese fecha de venciminto: ");
                String carfec = sc.nextLine();

                System.out.print("\nIngrese precio: ");
                int carpre = sc.nextInt();

                Carne carne = new Carne(carnom, carfec, carpre);
                tienda.registrarMaterial(carne);
                break;
            }
            case 2: {
                System.out.print("ingrese datos de la verdura");

                System.out.print("\nIngrese nombre: ");
                String vernom = sc.nextLine();

                System.out.print("\nIngrese precio: ");
                int verpre = sc.nextInt();

                Verdura verdura = new Verdura(vernom, verpre);

                tienda.registrarMaterial(verdura);
            break;}

            case 3: {
                System.out.print("ingrese datos del juego de ollas");

                System.out.print("\nIngrese cantidad: ");
                int ollacan = sc.nextInt();

                System.out.print("\nIngrese precio: ");
                int ollapre = sc.nextInt();

                Olla olla = new Olla(ollacan, ollapre);

                tienda.registrarMaterial(olla);
            break;}

            case 4: {
                System.out.print("ingrese datos del juego de utensilios");

                System.out.print("\nIngrese cantidad: ");
                int utecan = sc.nextInt();

                System.out.print("\nIngrese precio: ");
                int utepre = sc.nextInt();

                utensilios utensilios = new utensilios(utecan, utepre);

                tienda.registrarMaterial(utensilios);
                break;}

            default:
                System.out.println("numero incorecto ");
        }









        System.out.println("Materiales:");
        tienda.mostrarMateriales();

        System.out.println("\nUsuarios:");
        tienda.mostrarUsuarios();




                // --- PRUEBA COMPRAS Y REEMBOLSOS  ---
        System.out.println("\n--- Módulo de Compras ---");
        System.out.println("Ingrese el ID del usuario que va a comprar:");
        int idUsu = sc.nextInt();
        System.out.println("Ingrese el ID del material a comprar:");
        int idMat = sc.nextInt();

        // Ejecutar la compra
        tienda.realizarCompra(idUsu, idMat);

        System.out.println("\n--- Consultar estado después de la compra ---");
        tienda.consultarMaterialesComprados();

        System.out.println("\n¿Desea realizar un reembolso?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        int opcionReembolso = sc.nextInt();

        if (opcionReembolso == 1) {

            System.out.println("Ingrese el ID del material a reembolsar:");
            int idReembolso = sc.nextInt();

            tienda.realizarReembolso(idReembolso);

        } else {

            System.out.println("No se realizó ningún reembolso.");

        }


        //parte del punto 3
        System.out.println("\nConsultar materiales:");
        System.out.println("1. Ver disponibles");
        System.out.println("2. Ver comprados");

        int consulta = sc.nextInt();

        switch (consulta) {

            case 1:
                tienda.consultarMaterialesDisponibles();
                break;

            case 2:
                tienda.consultarMaterialesComprados();
                break;

            default:
                System.out.println("Opción incorrecta");

        }


    }



}





