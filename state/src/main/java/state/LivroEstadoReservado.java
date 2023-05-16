package state;

public class LivroEstadoReservado extends LivroEstado {

   private LivroEstadoReservado() {};
   private static LivroEstadoReservado instance = new LivroEstadoReservado();
   public static LivroEstadoReservado getInstance() {
       return instance;
   }

   public String getEstado() {
       return "Reservado";
   }

   public boolean emprestar(Livro livro) {
       livro.setEstado(LivroEstadoEmprestado.getInstance());
       return true;
   }

   public boolean disponivel(Livro livro) {
       livro.setEstado(LivroEstadoDisponivel.getInstance());
       return true;
   }
   }
