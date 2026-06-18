public class ItemPedido
{
    private ItemCardapio item;
    private int qnt;

    public ItemPedido(ItemCardapio item, int qnt) {
        this.item = item;
        this.qnt = qnt;
    }

    public ItemCardapio getItem() {
        return this.item;
    }

    public void setItem(ItemCardapio i) {
        this.item = i;
    }

    public int getQnt() {
        return this.qnt;
    }

    public void setQnt(int q) {
        this.qnt = q;
    }
    
    public float calcularSubtotal() {
        return this.item.getPrecoltem() * this.qnt;
    }
}
