import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        exibirMenu(); // llamamos al menú
    }

    public static void exibirMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {

            System.out.println("""
            *************************************************
            Conversor de Moneda del Challenge de Alura =)

            1) Dólar ==> Peso argentino
            2) Peso argentino ==> Dólar
            3) Dólar ==> Real brasileño
            4) Real brasileño ==> Dólar
            5) Dólar ==> Peso colombiano
            6) Peso colombiano ==> Dólar
            7) Salir

            Elija una opción válida:
            *************************************************
            """);

            opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }

            System.out.println("Ingrese el valor que desea convertir:");
            double cantidad = scanner.nextDouble();

            String base = "";
            String destino = "";

            switch (opcion) {

                case 1 -> { base = "USD"; destino = "ARS"; }
                case 2 -> { base = "ARS"; destino = "USD"; }
                case 3 -> { base = "USD"; destino = "BRL"; }
                case 4 -> { base = "BRL"; destino = "USD"; }
                case 5 -> { base = "USD"; destino = "COP"; }
                case 6 -> { base = "COP"; destino = "USD"; }

                default -> {
                    System.out.println("Opción inválida");
                    continue;
                }
            }

            String json = ConsultaAPI.obtenerDatos(base, destino);

            double tasa = AnalizadorJSON.obtenerTasa(json);

            double resultado = Conversion.convertir(cantidad, tasa);

            System.out.println("El valor "+ cantidad +" ["+base+"]"+" corresponde al valor final de " + resultado + " [" + destino+"]");
        }

        System.out.println("Programa finalizado, gracias por su visita :)");
    }
}