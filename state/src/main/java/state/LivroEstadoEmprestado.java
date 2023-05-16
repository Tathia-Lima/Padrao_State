package state;

public class LivroEstadoEmprestado extends LivroEstado {

    private LivroEstadoEmprestado() {
    }

    ;
    private static LivroEstadoEmprestado instance = new LivroEstadoEmprestado();

    public static LivroEstadoEmprestado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Emprestado";
    }

    public boolean renovarEmprestimo(Livro livro) {
        livro.setEstado(LivroEstadoEmprestimoRenovado.getInstance());
        return true;
    }

    public boolean devolver(Livro livro) {
        livro.setEstado(LivroEstadoDevolvido.getInstance());
        return true;
    }

}
