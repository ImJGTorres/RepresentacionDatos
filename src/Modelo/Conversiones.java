package Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Gabriel Torres & Emerson Vera
 */
public class Conversiones {

    public boolean validarNumero(String num) {
        String caracteresDecimales = "0123456789.-";
        for (int i = 0; i < num.length(); i++) {
            char caracter = num.charAt(i);
            if (caracteresDecimales.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public BigDecimal[] convertirBytes(BigDecimal bytes) {
        BigDecimal[] conversiones = new BigDecimal[4];
        for (int i = 0; i < 4; i++) {
            conversiones[i] = bytes.divide(BigDecimal.valueOf(Math.pow(1000, i + 1)), 20, RoundingMode.HALF_UP);
        }
        return conversiones;
    }

    public BigDecimal[] convertirBibytes(BigDecimal bytes) {
        BigDecimal[] conversiones = new BigDecimal[4];
        for (int i = 0; i < 4; i++) {
            conversiones[i] = bytes.divide(BigDecimal.valueOf(Math.pow(1024, i + 1)), 20, RoundingMode.HALF_UP);
        }
        return conversiones;
    }
    
    public BigDecimal convertirDeCualquierUnidad(BigDecimal valor, String unidadA, String unidadB) {
        // Convertir la unidad de origen a la unidad base (bits o bytes)
        BigDecimal valorEnBase = convertirABits(valor, unidadA);

        // Convertir desde la unidad base a la unidad de destino
        BigDecimal resultado = convertirDesdeBits(valorEnBase, unidadB);

        return resultado;
    }

    private BigDecimal convertirABits(BigDecimal valor, String unidad) {
        unidad = unidad.toLowerCase(); // Convertir a minúsculas para evitar errores de case

       BigDecimal factor;
        switch (unidad) {
            case "bit": return valor;
            case "kilobit": factor = BigDecimal.valueOf(1000); break;
            case "kibibit": factor = BigDecimal.valueOf(1024); break;
            case "megabit": factor = BigDecimal.valueOf(1000).pow(2); break;
            case "mebibit": factor = BigDecimal.valueOf(1024).pow(2); break;
            case "gigabit": factor = BigDecimal.valueOf(1000).pow(3); break;
            case "gibibit": factor = BigDecimal.valueOf(1024).pow(3); break;
            case "terabit": factor = BigDecimal.valueOf(1000).pow(4); break;
            case "tebibit": factor = BigDecimal.valueOf(1024).pow(4); break;
            case "petabit": factor = BigDecimal.valueOf(1000).pow(5); break;
            case "pebibit": factor = BigDecimal.valueOf(1024).pow(5); break;
            case "exabit": factor = BigDecimal.valueOf(1000).pow(6); break;
            case "exbibit": factor = BigDecimal.valueOf(1024).pow(6); break;
            case "zettabit": factor = BigDecimal.valueOf(1000).pow(7); break;
            case "zebibit": factor = BigDecimal.valueOf(1024).pow(7); break;
            case "yotabit": factor = BigDecimal.valueOf(1000).pow(8); break;
            case "yobibit": factor = BigDecimal.valueOf(1024).pow(8); break;
            
            case "byte": factor = BigDecimal.valueOf(8); break;
            case "kilobyte": factor = BigDecimal.valueOf(8 * 1000); break;
            case "kibibyte": factor = BigDecimal.valueOf(8 * 1024); break;
            case "megabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(2)); break;
            case "mebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(2)); break;
            case "gigabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(3)); break;
            case "gibibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(3)); break;
            case "terabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(4)); break;
            case "tebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(4)); break;
            case "petabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(5)); break;
            case "pebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(5)); break;
            case "exabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(6)); break;
            case "exbibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(6)); break;
            case "zettabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(7)); break;
            case "zebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(7)); break;
            case "yotabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(8)); break;
            case "yobibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(8)); break;
            
            default:
                throw new IllegalArgumentException("Unidad no válida: " + unidad);
        }
        return valor.multiply(factor);
    }

    private BigDecimal convertirDesdeBits(BigDecimal valorEnBits, String unidad) {
        unidad = unidad.toLowerCase(); // Convertir a minúsculas para evitar errores de case

        BigDecimal factor;
        switch (unidad) {
            case "bit": return valorEnBits;
            case "kilobit": factor = BigDecimal.valueOf(1000); break;
            case "kibibit": factor = BigDecimal.valueOf(1024); break;
            case "megabit": factor = BigDecimal.valueOf(1000).pow(2); break;
            case "mebibit": factor = BigDecimal.valueOf(1024).pow(2); break;
            case "gigabit": factor = BigDecimal.valueOf(1000).pow(3); break;
            case "gibibit": factor = BigDecimal.valueOf(1024).pow(3); break;
            case "terabit": factor = BigDecimal.valueOf(1000).pow(4); break;
            case "tebibit": factor = BigDecimal.valueOf(1024).pow(4); break;
            case "petabit": factor = BigDecimal.valueOf(1000).pow(5); break;
            case "pebibit": factor = BigDecimal.valueOf(1024).pow(5); break;
            case "exabit": factor = BigDecimal.valueOf(1000).pow(6); break;
            case "exbibit": factor = BigDecimal.valueOf(1024).pow(6); break;
            case "zettabit": factor = BigDecimal.valueOf(1000).pow(7); break;
            case "zebibit": factor = BigDecimal.valueOf(1024).pow(7); break;
            case "yotabit": factor = BigDecimal.valueOf(1000).pow(8); break;
            case "yobibit": factor = BigDecimal.valueOf(1024).pow(8); break;
            
            case "byte": factor = BigDecimal.valueOf(8); break;
            case "kilobyte": factor = BigDecimal.valueOf(8 * 1000); break;
            case "kibibyte": factor = BigDecimal.valueOf(8 * 1024); break;
            case "megabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(2)); break;
            case "mebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(2)); break;
            case "gigabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(3)); break;
            case "gibibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(3)); break;
            case "terabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(4)); break;
            case "tebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(4)); break;
            case "petabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(5)); break;
            case "pebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(5)); break;
            case "exabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(6)); break;
            case "exbibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(6)); break;
            case "zettabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(7)); break;
            case "zebibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(7)); break;
            case "yotabyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1000).pow(8)); break;
            case "yobibyte": factor = BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(1024).pow(8)); break;

            default:
                throw new IllegalArgumentException("Unidad no válida: " + unidad);
        }
        return valorEnBits.divide(factor, 20, RoundingMode.HALF_UP);
    }
}
