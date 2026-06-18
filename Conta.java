import java.util.ArrayList;

public class Conta
{
    private float bonusUsado, valor;
    private String formaPagamento;
    private ArrayList <PedidoCliente> listaPedidos;
    
    public Conta() {
        this.bonusUsado = 0.00f;
        this.valor = 0.00f;
        this.formaPagamento = "";
        this.listaPedidos = new ArrayList <PedidoCliente> ();
    }
    
    public float getBonusUsado() {
        return this.bonusUsado;
    }
    
    public void setBonusUsado(float b) {
        this.bonusUsado = b;
    }
    
    public float getValor() {
        return this.valor;
    }
    
    public void setValor(float v) {
        this.valor = v;
    }
    
    public String getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(String f) {
        this.formaPagamento = f;
    }
    
    public ArrayList <PedidoCliente> getListaPedidos() {
        return this.listaPedidos;
    }
    
    public void setListaPedidos(ArrayList <PedidoCliente> l) {
        this.listaPedidos = l;
    }

    public void addPedido(PedidoCliente p) {
        if (p != null) {
            this.listaPedidos.add(p);
        }
    }
    
    public float fecharConta(Cliente c) {
        float somaPedidos = 0.00f;
        
        for(PedidoCliente pedido: listaPedidos) {
            somaPedidos += pedido.getValorTotal();
        }
        
        float bonusDisp = c.getBonusAcumulado();
        
        if(bonusDisp > 0 && somaPedidos > 0) {
            if(bonusDisp >= somaPedidos) {
                this.bonusUsado = somaPedidos;
                this.valor = 0.00f;
                c.setBonusAcumulado(bonusDisp - somaPedidos);
            } else {
                this.bonusUsado = bonusDisp;
                this.valor = somaPedidos - bonusDisp;
                c.setBonusAcumulado(0.00f);
            }
        } else {
            this.bonusUsado = 0.00f;
            this.valor = somaPedidos;
        }
        
        if(somaPedidos > 0) {
            float bonusGerado = somaPedidos * 0.10f;
            float bonusAtualizado = c.getBonusAcumulado() + bonusGerado;
            c.setBonusAcumulado(bonusAtualizado);
        }
        
        return this.valor;
    }
    
    public void addPedido(PedidoCliente p) {
        this.listaPedidos.add(p);
    }
}
