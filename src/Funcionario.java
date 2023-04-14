public class Funcionario {
    private double salario;
    private long registro;
    private boolean estaAtivo;
    private String nome;
    private String departamento;
    private String rg;

    public Funcionario(String nome,String rg, String departamento, long registro, double salario, boolean estaAtivo) {
        this.nome = nome;
        this.rg = rg;
        this.departamento = departamento;
        this.registro = registro;
        this.salario = salario;
        this.estaAtivo = estaAtivo;
    }

    public String toString(){
        return "-----Funcionário-----"+
                "\nNome: "+getNome()+
                "\nRG: "+getRg()+
                "\nDepartamento: "+getDepartamento()+
                "\nRegistro: "+getRegistro()+
                "\nSalário: "+getSalario()+
                "\nEstá ativo? "+isEstaAtivo()+
                "\n--------------------\n";
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getRegistro() {
        return registro;
    }

    public void setRegistro(long registro) {
        this.registro = registro;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void bonificar(double valor){
        salario = salario + valor;
        System.out.println(getNome()+" está recebendo uma bonificação de R$"+valor);
        }
    public void imprimir(){
        System.out.println("Nome: "+nome+
                "\nRG: "+rg+
                "\nDepartamento: "+departamento+
                "\nRegistro: "+registro+
                "\nSalário: "+salario+
                "\nEstá ativo? "+estaAtivo);
    }
}
