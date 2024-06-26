import java.util.Scanner;
import dao.ClienteDAO;
import dao.VeiculoDAO;
import dao.AluguelDAO;
import dao.ManutencaoDAO;
import models.Cliente;
import models.Veiculo;
import models.Aluguel;
import models.Manutencao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        AluguelDAO aluguelDAO = new AluguelDAO();
        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();

        while (true) {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Veículo");
            System.out.println("3. Realizar Aluguel");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Atualizar Cliente");
            System.out.println("6. Deletar Cliente");
            System.out.println("7. Registrar Manutenção");
            System.out.println("8. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf, telefone);
                    clienteDAO.inserir(cliente);
                    break;
                case 2:
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.println("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Placa: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
                    veiculoDAO.inserir(veiculo);
                    break;
                case 3:
                    System.out.println("ID Cliente: ");
                    int idCliente = scanner.nextInt();
                    System.out.println("ID Veículo: ");
                    int idVeiculo = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Data Início (YYYY-MM-DD): ");
                    String dataInicio = scanner.nextLine();
                    System.out.println("Data Fim (YYYY-MM-DD): ");
                    String dataFim = scanner.nextLine();

                    // Verificar se cliente e veículo existem
                    Cliente clienteVerificado = clienteDAO.obterPorId(idCliente);
                    Veiculo veiculoVerificado = veiculoDAO.obterPorId(idVeiculo);

                    if (clienteVerificado != null && veiculoVerificado != null) {
                        Aluguel aluguel = new Aluguel(idCliente, idVeiculo, dataInicio, dataFim);
                        aluguelDAO.inserir(aluguel);
                        System.out.println("Aluguel realizado com sucesso!");
                    } else {
                        System.out.println("Cliente ou Veículo não encontrados. Verifique os IDs.");
                    }
                    break;
                case 4:
                    for (Cliente c : clienteDAO.listarTodos()) {
                        System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf() + ", Telefone: " + c.getTelefone());
                    }
                    break;
                case 5:
                    System.out.println("ID Cliente: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.println("Novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    System.out.println("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoCpf, novoTelefone);
                    clienteDAO.atualizar(clienteAtualizado);
                    break;
                case 6:
                    System.out.println("ID Cliente: ");
                    int idDeletar = scanner.nextInt();
                    clienteDAO.deletar(idDeletar);
                    break;
                case 7:
                    System.out.println("ID Veículo: ");
                    int idVeiculoManutencao = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    // Verificar se veículo existe
                    Veiculo veiculoParaManutencao = veiculoDAO.obterPorId(idVeiculoManutencao);

                    if (veiculoParaManutencao != null) {
                        System.out.println("Data Manutenção (YYYY-MM-DD): ");
                        String dataManutencao = scanner.nextLine();
                        System.out.println("Descrição: ");
                        String descricao = scanner.nextLine();

                        Manutencao manutencao = new Manutencao(idVeiculoManutencao, dataManutencao, descricao);
                        manutencaoDAO.inserir(manutencao);
                        System.out.println("Manutenção registrada com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado. Verifique o ID.");
                    }
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
