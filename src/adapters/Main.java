package adapters;

import creacionUsuariosYMateriales.*;
import usecases.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TiendaService tienda = new TiendaService();
        Scanner sc = new Scanner(System.in);

        // USE CASES
        RegistrarUsuarioUseCase registrarUsuario =
                new RegistrarUsuarioUseCase(tienda);

        RegistrarMaterialUseCase registrarMaterial =
                new RegistrarMaterialUseCase(tienda);

        ConsultarMaterialesDisponiblesUseCase verDisponibles =
                new ConsultarMaterialesDisponiblesUseCase(tienda);

        ConsultarComprasRealizadasUseCase verComprados =
                new ConsultarComprasRealizadasUseCase(tienda);

        RealizarCompraUseCase realizarCompra =
                new RealizarCompraUseCase(
                        tienda.getMateriales(),
                        tienda.getUsuarios(),
                        tienda.getCompras()
                );

        RealizarReembolsoUseCase realizarReembolso =
                new RealizarReembolsoUseCase(
                        tienda.getCompras()
                );


        // -------------------------
        // REGISTRAR USUARIO
        // -------------------------

        System.out.println("Ingrese datos del usuario");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();

        registrarUsuario.ejecutar(nombre, email, id);


        // -------------------------
        // REGISTRAR MATERIAL
        // -------------------------

        System.out.println("1. Carne 2. Verdura 3. Olla 4. Utensilios");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:

                System.out.print("Nombre carne: ");
                String carnom = sc.nextLine();

                System.out.print("Fecha vencimiento: ");
                String carfec = sc.nextLine();

                System.out.print("Precio: ");
                int carpre = sc.nextInt();

                registrarMaterial.ejecutar(
                        new Carne(carnom, carfec, carpre)
                );

                break;

            case 2:

                System.out.print("Nombre verdura: ");
                String vernom = sc.nextLine();

                System.out.print("Precio: ");
                int verpre = sc.nextInt();

                registrarMaterial.ejecutar(
                        new Verdura(vernom, verpre)
                );

                break;

            case 3:

                System.out.print("Cantidad ollas: ");
                int ollacan = sc.nextInt();

                System.out.print("Precio: ");
                int ollapre = sc.nextInt();

                registrarMaterial.ejecutar(
                        new Olla(ollacan, ollapre)
                );

                break;

            case 4:

                System.out.print("Cantidad utensilios: ");
                int utecan = sc.nextInt();

                System.out.print("Precio: ");
                int utepre = sc.nextInt();

                registrarMaterial.ejecutar(
                        new Utensilios(utecan, utepre)
                );

                break;

            default:
                System.out.println("Opción inválida");
        }


        // -------------------------
        // MOSTRAR DATOS
        // -------------------------

        System.out.println("\nUsuarios:");
        tienda.mostrarUsuarios();

        System.out.println("\nMateriales:");
        tienda.mostrarMateriales();


        // -------------------------
        // COMPRA
        // -------------------------

        System.out.println("\n--- Comprar ---");

        System.out.print("ID Usuario: ");
        int idUsu = sc.nextInt();

        System.out.print("ID Material: ");
        int idMat = sc.nextInt();

        realizarCompra.ejecutar(idUsu, idMat);


        // -------------------------
        // REEMBOLSO
        // -------------------------

        System.out.println("\n¿Desea reembolso?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        int op = sc.nextInt();

        if (op == 1) {

            System.out.print("ID Material: ");
            int idReembolso = sc.nextInt();

            realizarReembolso.ejecutar(idReembolso);

        }


        // -------------------------
        // CONSULTAS
        // -------------------------

        System.out.println("\nConsultar:");
        System.out.println("1. Disponibles");
        System.out.println("2. Comprados");

        int consulta = sc.nextInt();

        switch (consulta) {

            case 1:
                verDisponibles.ejecutar();
                break;

            case 2:
                verComprados.ejecutar();
                break;

        }

        System.out.println("\nCosto total:");
        tienda.mostrarCostoTotalCompras();

    }
}



