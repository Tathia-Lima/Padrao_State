package state;

public class Livro {

    private LivroEstado estado;

    public Livro() {
        this.estado = LivroEstadoDisponivel.getInstance();
    }

    public void setEstado(LivroEstado estado) {
        this.estado = estado;
    }

    public boolean emprestar() {
        return estado.emprestar(this);
    }

    public boolean devolver() {
        return estado.devolver(this);
    }

    public boolean reservar() {
        return estado.reservar(this);
    }

    public boolean disponivel() {
        return estado.disponivel(this);
    }

    public boolean renovarEmprestimo() {
        return estado.renovarEmprestimo(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

 
    public LivroEstado getEstado() {
        return estado;
    }
}




