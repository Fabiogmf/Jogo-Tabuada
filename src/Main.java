import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int VidaInicial = 0;
        boolean acertou = false;

        System.out.println("Bem vindo ao jogo da Tabuada");
        System.out.println("Tens que acertar o valor correto da Tabuada de 9!");
        System.out.println("Ou seja, será gerado um número aleatório e terá que acertar o valor da sua respetiva multiplicação.");
        System.out.println("Começas o jogo com 3 de vida, se a vida chegar a 0, perde o jogo.");
        System.out.println("Mas a cada acerto, somas 2 pontos de vida e a cada erro perdes 1 ponto.");
        System.out.println("Podes digitar SAIR a qualquer momento para sair do jogo");
        System.out.println("Boa sorte e bom jogo!");


        while (VidaInicial >= 0 && !acertou) {

            int numeroSecreto = random.nextInt(90) + 1;
            int mult = 9 * numeroSecreto;

            System.out.println("Qual o valor da de 9 x " + numeroSecreto + " ?");

            String palpite = in.nextLine();

            if (palpite.equalsIgnoreCase("sair")) {
                System.out.println("Você desistiu do jogo");
                break;
            }

            if (palpite.matches("\\d+")) { //Verifica se a string contém apenas números
                int palpiteConvertido = Integer.parseInt(palpite);
                System.out.println("Você digitou o número: " + palpiteConvertido);


                if (palpiteConvertido == mult) {
                    System.out.println("Parabéns! Acertaste em cheio.");
                    VidaInicial += 2;
                }

                else {
                    System.out.println("Resposta Errada, a resposta correta era: " + mult);
                    VidaInicial -= 1;
                }

                if (VidaInicial > 0) {
                    System.out.println("Você agora tem: " + VidaInicial + " vidas.");
                }

                else {
                    System.out.println("Fim do jogo. Perdestes todas as vidas.");
                    break;
                }

            }
            else {
                System.out.println("Entrada inválida, insira um número.");
            }

        }
        in.close();
    }
}