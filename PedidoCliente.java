import java.util.ArrayList;

public class PedidoCliente {
    private int id;
    private ArrayList <ItemPedido> itensPedido;
    private String statusPedido;
    private float valorTotal;

    public PedidoCliente(int id) {
        this.id = id;
        this.itensPedido = new ArrayList <ItemPedido> ();
        this.statusPedido = "Aberto";
        this.valorTotal = 0.00f;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public ArrayList <ItemPedido> getItensPedido() {
        return this.itensPedido;
    }

    public void setItensPedido(ArrayList <ItemPedido> i) {
        this.itensPedido = i;
    }

    public String getStatusPedido() {
        return this.statusPedido;
    }

    public void setStatusPedido(String s) {
        this.statusPedido = s;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float v) {
        this.valorTotal = v;
    }
    
    public void addItemPedido(ItemPedido i) {
        this.itensPedido.add(i);
    }

    public void calcularTotal() {
        this.valorTotal = 0.00f;
        for(ItemPedido item : itensPedido) {
            this.valorTotal += item.calcularSubtotal();
        }
    }
}
