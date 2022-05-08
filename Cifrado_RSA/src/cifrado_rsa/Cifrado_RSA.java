/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado_rsa;

/**
 *
 * @author RoNy Cx
 */
public class Cifrado_RSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se define texto a cifrar
        String str = "Este texto a cifrar";
        
        System.out.println("\n Texto a cifrar");
        System.out.println(str);
        
        //Instanciamos la clase
        RSA rsa = RSA();
        
        // Generamos las claves 512, 1024, 2048, 4096
        rsa.genKeyPair(512);
        
        String privado = "/tmp/rsa.pri";
        String publico = "/tmp/rsa.pub";
        
        //cifrar y mostrar
        String secure = rsa.Encrypt(str);
        System.out.println("\n Cifrado");
        System.out.println(secure);
        
        //ahora se utiliza automaticamente las llaves ya cargadas
        RSA rsa2 = new RSA();
        
        rsa2.openFromDiskPrivateKey("/tmp/rsa.pri");
        rsa2.openFromDiskPrivateKey("/tmp/rsa.pub");
        
        String nosecure = rsa.Decrypt(secure);
        
        //mostramos
        System.out.println("\nDescifrado: ");
        System.out.println(nosecure);
    }
    
}
