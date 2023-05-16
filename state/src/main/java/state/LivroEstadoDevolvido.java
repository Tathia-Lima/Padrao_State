package state;

public class LivroEstadoDevolvido extends LivroEstado {

    private LivroEstadoDevolvido() {
    }

    ;
    private static LivroEstadoDevolvido instance = new LivroEstadoDevolvido();

    public static LivroEstadoDevolvido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Devolvido";
    }

    public boolean disponivel(Livro livro) {
        livro.setEstado(LivroEstadoDisponivel.getInstance());
        return true;
    }

}
