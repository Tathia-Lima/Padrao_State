package state;

public class LivroEstadoEmprestimoRenovado extends LivroEstado {


    private LivroEstadoEmprestimoRenovado() {
    };
    private static LivroEstadoEmprestimoRenovado instance = new LivroEstadoEmprestimoRenovado();

    public static LivroEstadoEmprestimoRenovado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Empréstimo Renovado";
    }

    public boolean devolver(Livro livro) {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        return true;
    }

}
