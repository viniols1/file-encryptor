import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncryptorApp {

    public static void main(String[] args) {
        System.out.println("=== Passo 6: O Ciclo Completo de Segurança ===");

        String senhaSecreta = "mackenzie2026";
        String arquivoCriptografado = "arquivo_secreto.enc";
        String arquivoRecuperado = "resultado_final.txt";

        try {
            // 1. Preparamos a chave
            SecretKeySpec chave = criarChave(senhaSecreta);

            // 2. Lemos o arquivo que está criptografado (.enc)
            System.out.println("Lendo o arquivo criptografado...");
            String conteudoCifrado = new String(Files.readAllBytes(Paths.get(arquivoCriptografado)), StandardCharsets.UTF_8);

            // 3. Aplicamos a função de descriptografar
            System.out.println("Descriptografando dados...");
            String conteudoOriginal = descriptografar(conteudoCifrado, chave);

            // 4. Salvamos o texto recuperado em um novo arquivo .txt
            Files.write(Paths.get(arquivoRecuperado), conteudoOriginal.getBytes(StandardCharsets.UTF_8));

            System.out.println("SUCESSO TOTAL!");
            System.out.println("O arquivo '" + arquivoRecuperado + "' foi criado com o conteúdo original.");

        } catch (Exception e) {
            System.out.println("ERRO ao recuperar arquivo: " + e.getMessage());
        }
    }

    // Método para descriptografar (Motor de recuperação)
    public static String descriptografar(String textoCifrado, SecretKeySpec chave) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, chave);
            byte[] bytesCifrados = Base64.getDecoder().decode(textoCifrado);
            byte[] bytesOriginais = cipher.doFinal(bytesCifrados);
            return new String(bytesOriginais, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "Erro na chave ou arquivo corrompido.";
        }
    }

    // Método para criar a chave (Padrão AES 128-bits)
    public static SecretKeySpec criarChave(String senha) {
        try {
            byte[] chaveEmBytes = senha.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            chaveEmBytes = sha.digest(chaveEmBytes);
            chaveEmBytes = Arrays.copyOf(chaveEmBytes, 16);
            return new SecretKeySpec(chaveEmBytes, "AES");
        } catch (Exception e) {
            return null;
        }
    }
}