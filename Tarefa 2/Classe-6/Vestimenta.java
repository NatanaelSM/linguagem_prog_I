public class Vestimenta {

    private String tipo;
    private int unidades;
    private double preco;

    public Vestimenta(String tipo, int unidades, double preco) {
        this.tipo = tipo;
        this.unidades = unidades;
        this.preco = preco;
    }

    public void aumentarPrecos(double percentual) {
        this.preco += this.preco * (percentual / 100);
        System.out.println("O preço da vestimenta aumentou para: " + preco);
    }

    public int getUnidades() {
        return unidades;
    }

    public void vender(int quantidade) {
        if (quantidade > unidades) {
            System.out.println("Não há unidades suficientes para venda.");
        } else {
            unidades -= quantidade;
            System.out.println("Foram vendidas " + quantidade + " unidades. Restam " + unidades + " unidades.");
        }
    }
}
