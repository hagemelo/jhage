package br.com.jhage.pedido_api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.helper.Helper;

/**
 * 
 * @author Alexnsander Melo
 * @since 15/01/2017
 *
 */
@Entity(name="ITEM_PEDIDO_GABI")
@Table
public class ItemPedido implements JhageEntidade{
	
private static final long serialVersionUID = 1L;
	
	@Version
	Integer versao;

	@Id
	@Column(name = "itempedido_ID", nullable = false)
	@SequenceGenerator(name = "itenid", sequenceName = "GEN_itempedido_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itenid")
	private Long id;
	
	private Integer quantidade;
	
	private Double valor;
	
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_ID", referencedColumnName = "pedido_ID")
	private Pedido pedido;
	
	ItemPedido(){
		
	}
	
	public ItemPedido(Integer quantidade){
		
		this.quantidade = Helper.ENULO.enulo(quantidade)?ValoresConstantes.UM:quantidade;
		this.valor = 0.;
	}
	
	@Override
	public Long getId() {

		return this.id;
	}
	
    public ItemPedido comPedido(Pedido ped){
    	
    	if(!Helper.ENULO.enulo(ped)){
    		this.pedido = ped;
    	}
		return this;
	}
	
	public Double total() {
		
		Double result =ValoresConstantes.DOUBLE_ZERO;
		if (this.isOKQuantidadeValor()){
			result =  this.getValor() * this.getQuantidade();
		}
		return result;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	private boolean isOKQuantidadeValor(){
		
		return !Helper.ENULO.enulo(this.valor) 
				& !Helper.ENULO.enulo(this.quantidade) 
				& Double.doubleToRawLongBits(this.valor)!=ValoresConstantes.ZERO;
	}
	
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((this.id == null) ? 0 : id.hashCode());
		result = prime * result + ((this.quantidade == null) ? 0 : this.quantidade.hashCode());
		result = prime * result + ((this.descricao == null) ? 0 : this.descricao.hashCode());
		result = prime * result + ((this.valor == null) ? 0 : this.valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemPedido)) {
			return false;
		}
		ItemPedido other = (ItemPedido) obj;

		return super.equals(obj) 
				&&  this.id.equals(other.id)
				&&  this.quantidade.equals(other.quantidade)
				&&  this.descricao.equals(other.descricao)
				&&  this.valor.equals(other.valor);
	}
}
