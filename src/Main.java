import creacionUsuariosYMateriales.*;
import usecases.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TiendaService tienda = new TiendaService();
        Scanner sc = new Scanner(System.in);

        // CASOS DE USO
        RegistrarUsuarioUseCase registrarUsuario =
                new RegistrarUsuarioUseCase(tienda);

        RegistrarMaterialUseCase registrarMaterial =
                new RegistrarMaterialUseCase(tienda);

        ConsultarMaterialesDisponiblesUseCase verDisponibles =
                new ConsultarMaterialesDisponiblesUseCase(tienda);

        ConsultarComprasRealizadasUseCase verComprados =
                new ConsultarComprasRealizadasUseCase(tienda);


        // -------------------------
        // REGISTRAR USUARIO
        // -------------------------
        System.out.println("Ingrese datos del usuario");

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su ID: ");
        int id = sc.nextInt();

        registrarUsuario.ejecutar(nombre, email, id);


        // -------------------------
        // REGISTRAR MATERIAL
        // -------------------------

        System.out.println("1. carne 2. verdura 3. olla 4. utensilios");
        System.out.print("Ingrese material para registrar: ");

        int numeromaterial = sc.nextInt();
        sc.nextLine();

        switch (numeromaterial) {

            case 1: {

                System.out.println("Ingrese datos de la carne");

                System.out.print("Nombre: ");
                String carnom = sc.nextLine();

                System.out.print("Fecha vencimiento: ");
                String carfec = sc.nextLine();

                System.out.print("Precio: ");
                int carpre = sc.nextInt();

                Carne carne = new Carne(carnom, carfec, carpre);

                registrarMaterial.ejecutar(carne);

                break;
            }

            case 2: {

                System.out.println("Ingrese datos de la verdura");

                System.out.print("Nombre: ");
                String vernom = sc.nextLine();

                System.out.print("Precio: ");
                int verpre = sc.nextInt();

                Verdura verdura = new Verdura(vernom, verpre);

                registrarMaterial.ejecutar(verdura);

                break;
            }

            case 3: {

                System.out.println("Ingrese datos del juego de ollas");

                System.out.print("Cantidad: ");
                int ollacan = sc.nextInt();

                System.out.print("Precio: ");
                int ollapre = sc.nextInt();

                Olla olla = new Olla(ollacan, ollapre);

                registrarMaterial.ejecutar(olla);

                break;
            }

            case 4: {

                System.out.println("Ingrese datos del juego de utensilios");

                System.out.print("Cantidad: ");
                int utecan = sc.nextInt();

                System.out.print("Precio: ");
                int utepre = sc.nextInt();

                Utensilios utensilios = new Utensilios(utecan, utepre);

                registrarMaterial.ejecutar(utensilios);

                break;
            }

            default:
                System.out.println("Número incorrecto");
        }


        // -------------------------
        // MOSTRAR DATOS
        // -------------------------

        System.out.println("\nMateriales:");
        tienda.mostrarMateriales();

        System.out.println("\nUsuarios:");
        tienda.mostrarUsuarios();


        // -------------------------
        // COMPRAS
        // -------------------------

        System.out.println("\n--- Módulo de Compras ---");

        System.out.println("Ingrese el ID del usuario que va a comprar:");
        int idUsu = sc.nextInt();

        System.out.println("Ingrese el ID del material a comprar:");
        int idMat = sc.nextInt();

        tienda.realizarCompra(idUsu, idMat);


        System.out.println("\n--- Consultar estado después de la compra ---");

        verComprados.ejecutar();


        // -------------------------
        // REEMBOLSO
        // -------------------------

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


        // -------------------------
        // CONSULTAS
        // -------------------------

        System.out.println("\nConsultar materiales:");
        System.out.println("1. Ver disponibles");
        System.out.println("2. Ver comprados");

        int consulta = sc.nextInt();

        switch (consulta) {

            case 1:
                verDisponibles.ejecutar();
                break;

            case 2:
                verComprados.ejecutar();
                break;

            default:
                System.out.println("Opción incorrecta");
        }


        // -------------------------
        // COSTOS
        // -------------------------

        System.out.println("\n--- Cálculo final de costos ---");

        tienda.mostrarCostoTotalCompras();

    }
}



