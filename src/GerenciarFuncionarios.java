import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarFuncionarios {
    public List<Funcionario> funcionarios = new ArrayList<>();
    Scanner leitura = new Scanner(System.in);
    public static void main(String[] args) {
        GerenciarFuncionarios gf = new GerenciarFuncionarios();
    int opcao;
    do {
        System.out.println("-----MENU PRINCIPAL-----" );
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Consultar Funcionário");
        System.out.println("3. Bonificar ÚNICO Usuário");
        System.out.println("4. Bonificar TODOS os Usuários");
        System.out.println("5. Mostrar todos os funcionários");
        //System.out.println("6. Ativar/Desativar funcionário");
        System.out.println("9. SAIR");
        System.out.println("------------------------");
        System.out.print("Escolha a sua opção: ");
        opcao = Integer.parseInt(gf.leitura.nextLine());
        switch (opcao){
            case 1:
                gf.execCadastrar();
                break;
            case 2:
                gf.execConsultarUnico();
                break;
            case 3:
                gf.execBonificarUnico();
                break;
            case 4:
                gf.execBonificar();
                break;
            case 5:
                gf.execMostrarFuncionarios();
                break;
            /*case 6:
                gf.execAtivarDesativar();*/
            case 9:
                System.out.println("Você escolheu sair do programa. Até mais!");
                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (opcao!=9);

    }

    /*private void execAtivarDesativar() {
        System.out.print("Digite o registro do funcionário: ");
        long registro = Long.parseLong(leitura.nextLine());
        Funcionario funcionario = buscarFuncionario(registro);
        if (funcionario ==null){
            System.out.println("Não existe um funcionário com esse registro no sistema.");
            return;
        }
        if (funcionario.isEstaAtivo() == true){
            funcionario.isEstaAtivo() = false;

        }

    }*/

    private void execCadastrar() {
        System.out.println("-----CADASTRO DE FUNCIONÁRIOS-----");
        System.out.print("Digite o seu Nome: ");
        String nome = (leitura.nextLine());

        System.out.print("Digite o seu RG: ");
        String rg = (leitura.nextLine());

        System.out.print("Digite o seu departamento: ");
        String departamento = (leitura.nextLine());

        System.out.print("Digite o seu registro: ");
        long registro = Long.parseLong(leitura.nextLine());

        System.out.print("Digite o seu salário: ");
        double salario = Double.parseDouble(leitura.nextLine());

        System.out.print("Está ativo? ");
        boolean estaAtivo = Boolean.parseBoolean(leitura.nextLine());

        System.out.println("-----DADOS CADASTRADOS COM SUCESSO-----");
        Funcionario funcionario = new Funcionario(nome, rg, departamento, registro, salario, estaAtivo);
        funcionarios.add(funcionario);
    }
    private void execConsultarUnico(){
        System.out.print("Digite o registro do funcionário: ");
        long registro = Long.parseLong(leitura.nextLine());
        for (Funcionario funcionario: funcionarios){
            if (funcionario.getRegistro() == registro){
                System.out.println("-----DADOS DA CONTA-----");
                funcionario.imprimir();
            }
        }
        System.out.println("Não existe um funcionário com esse registro no sistema.");
    }
    private Funcionario buscarFuncionario(long resgistro) {
        for (Funcionario funcionario:funcionarios){
            if (funcionario.getRegistro() == resgistro){
                return funcionario;
            }
        }
        return null;
    }
    public void execBonificarUnico(){
        System.out.print("Digite o REGISTRO do funcionário que deseja bonificar: ");
        long registro = Long.parseLong(leitura.nextLine());
        Funcionario funcionario = buscarFuncionario(registro);
        if (funcionario==null){
            System.out.println("Não existe um funcionário com esse registro no sistema.");
            return;
        }
        System.out.print("Digite o valor da bonificação que deseja fazer para o funcionário "+funcionario.getNome()+":");
        double valor = Double.parseDouble(leitura.nextLine());
        System.out.print("(salário anterior era de "+funcionario.getSalario()+")\n");
        if (funcionario.isEstaAtivo()){
            funcionario.bonificar(valor);
            System.out.println(funcionario);
            return;
        }
        System.out.println("Funcionário não está eleito à receber a bonificação.");

        /*for (Funcionario funcionario: funcionarios){
            if (funcionario.getRegistro() == registro){
                System.out.print("Digite o valor da bonificação que deseja fazer para UM funcionário: ");
                double valor = Double.parseDouble(leitura.nextLine());
                funcionario.bonificar(valor);
            }*/
    }
    public void execBonificar(){
            System.out.print("Digite o valor da bonificação que deseja fazer para TODOS funcionários: ");
            double salario = Double.parseDouble(leitura.nextLine());
            for (Funcionario funcionario: funcionarios){
                if (funcionario.isEstaAtivo()){
                    funcionario.bonificar(salario);
                }
            }
            System.out.println("Funcionários não estão eleitos à receberem bonificação");
    }
    public void execMostrarFuncionarios(){
        System.out.println("-----LISTA COM TODOS OS FUNCIONÁRIOS CADASTRADOS-----");
        System.out.println(funcionarios);
    }
}