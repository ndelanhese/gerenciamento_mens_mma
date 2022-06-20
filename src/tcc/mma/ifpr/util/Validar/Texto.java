package tcc.mma.ifpr.util.Validar;

public class Texto {

    public String textoConverter(String string) {

        string = string.toLowerCase();
        String vetor[] = string.split(" ");
        String saida = "";

        for (String string1 : vetor) {
            if (string1.length() > 2) {
                saida += String.valueOf(string1.charAt(0)).toUpperCase();
                saida += string1.substring(1, string1.length());
            } else {
                saida += string1;
            }
            saida += " ";
        }

        return saida;

    }
    
    public String grande(String string){
        return string.toUpperCase();
    }
    
}
