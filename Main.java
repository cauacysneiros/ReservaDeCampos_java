import model.*;
import service.GestorCampo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorCampo gestor = new GestorCampo();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        gestor.cadastrarCampo(new Campo("Campo 1", 100.0));
        gestor.cadastrarCampo(new Campo("Campo 2", 150.0));

        while (true) {
            System.out.println("\n=== Sistema de Aluguel de Campos ===");
            System.out.println("1. Listar Campos");
            System.out.println("2. Reservar Campo");
            System.out.println("3. Consultar Reservas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nCampos disponíveis:");
                    gestor.getCampos().forEach(c -> System.out.println("- " + c.getNome() + " (R$" + c.getPrecoPorHora() + "/hora)"));
                    break;

                case 2:
                    System.out.print("Digite o nome do campo: ");
                    String nomeCampo = scanner.nextLine();
                    System.out.print("Digite a data e hora de início (dd/MM/yyyy HH:mm): ");
                    String dataHora = scanner.nextLine();
                    System.out.print("Digite a duração em horas: ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.println("Escolha a forma de pagamento:");
                    System.out.println("1. PIX");
                    System.out.println("2. DINHEIRO");
                    System.out.println("3. CRÉDITO");
                    System.out.println("4. DÉBITO");
                    int opcaoPagamento = scanner.nextInt();
                    scanner.nextLine();

                    Pagamento pagamento;
                    switch (opcaoPagamento) {
                        case 1 -> pagamento = new PagamentoPix();
                        case 2 -> pagamento = new PagamentoDinheiro();
                        case 3 -> pagamento = new PagamentoCartao("Crédito");
                        case 4 -> pagamento = new PagamentoCartao("Débito");
                        default -> {
                            System.out.println("Opção de pagamento inválida!");
                            continue;
                        }
                    }

                    LocalDateTime horario = LocalDateTime.parse(dataHora, formatter);
                    if (gestor.reservarCampo(nomeCampo, horario, duracao, cliente, pagamento)) {
                        System.out.println("Reserva realizada com sucesso!");
                    } else {
                        System.out.println("Erro: Campo não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\nReservas registradas:");
                    gestor.consultarReservas().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
