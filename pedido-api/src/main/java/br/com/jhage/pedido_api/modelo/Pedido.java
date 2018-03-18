package br.com.jhage.pedido_api.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jhage.pedido_api.constante.StatusPedido;
import br.com.jhage.pedido_api.constante.ValoresConstantes;
import br.com.jhage.pedido_api.helper.Helper;
import br.com.jhage.pedido_api.helper.NumberHelp;
import br.com.jhage.pedido_api.listen.PedidoListen;

/**
 * 
 * @author Alexnsander Melo
 * @since 15/01/2017
 *
 */
@Entity
@Table
@EntityListeners({ PedidoListen.class })
public class Pedido implements JhageEntidade{
	
	private static final long serialVersionUID = 1L;
	
	@Version
	Integer versao;

	@Id
	@Column(name = "pedido_ID", nullable = false)
	@SequenceGenerator(name = "pedid", sequenceName = "GEN_pedido_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedid")
	private Long id;
	
	private String contato;
	
	private String entrega;
	
	private Double troco;
	
	@JsonFormat(pattern="dd/MM/YYYY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@JsonBackReference
	@OneToMany(mappedBy = "pedido", cascade= CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
	private Set<ItemPedido> itens;
	
	
	Pedido(){
		
	}
	
	public Pedido(String contato , String entrega,  Double troco){
	
		this.contato = Helper.ENULO.enulo(contato)?ValoresConstantes.STRING_VAZIO:contato;
		this.entrega = Helper.ENULO.enulo(entrega)?ValoresConstantes.STRING_VAZIO:entrega;
		this.troco = Helper.ENULO.enulo(troco)?ValoresConstantes.DOUBLE_ZERO:troco;
		this.status = StatusPedido.REALIZADO;
		this.itens = new HashSet<ItemPedido>();
		this.cadastro = new Date();
		this.id =new Long(0);
	}
	
	@Override
	public Long getId() {

		return this.id;
	}
	
	@JsonProperty
	public String totalString(){
		
		return NumberHelp.parseDoubleToString(itens.stream().filter(Helper.NAO_E_NULO).mapToDouble(ItemPedido::total).sum());
	}
	
	@JsonProperty
	public String trocoString() {
		
		return NumberHelp.parseDoubleToString(this.troco);
	}
	
	public Double total(){
		
		return itens.stream().filter(Helper.NAO_E_NULO).mapToDouble(ItemPedido::total).sum();
	}
	
	public void addItemPedido(ItemPedido item) {
		
		this.getItens().add(item);
	}
	
	@JsonProperty
	public boolean isRealizado(){
		
		return StatusPedido.REALIZADO.equals(this.status);
	}
	
	@JsonProperty
	public boolean isPronto(){
		
		return StatusPedido.PRONTO.equals(this.status);
	}
	
	@JsonProperty
	public boolean isEntregue(){
		
		return StatusPedido.ENTREGUE.equals(this.status);
	}
	
	public void setStatus(StatusPedido status){
		
		this.status = status;
	}
	
	public String getContato() {
		
		return contato;
	}

	public String getEntrega() {
		
		return entrega;
	}

	public Double getTroco() {
		
		return troco;
	}

	public StatusPedido getStatus() {
		
		return status;
	}

	public Set<ItemPedido> getItens() {
		
		if (Helper.ENULO.enulo(this.itens)) {
			
			this.itens = new HashSet<ItemPedido>();
		}
		return itens;
	}
	
	public Date getCadastro() {
		
		return cadastro;
	}
	
	public void tratarNull(){
		
		this.tratarNUllContato();
		this.tratarNUllEntrega();
		this.tratarNUllTroco();
		this.tratarNUllCadastro();
		this.tratarNUllStatus();
		this.tratarNullItens();
	}
	
	private void tratarNUllContato(){
	
		if (Helper.ENULO.enulo(this.contato)){
			
			this.contato = ValoresConstantes.STRING_VAZIO;
		}
	}
	
	private void tratarNUllEntrega(){
		
		if (Helper.ENULO.enulo(this.entrega)){
			
			this.entrega = ValoresConstantes.STRING_VAZIO;
		}
	}
	
	private void tratarNullItens() {
		
		Pedido p = this;
		itens.stream().filter(i-> Helper.ENULO.enulo(i.getPedido())).forEach(i -> i.comPedido(p));
//		itens.forEach(i -> i.comPedido(p));
	}

	private void tratarNUllTroco(){

		if (Helper.ENULO.enulo(this.troco)){
			
			this.troco = ValoresConstantes.DOUBLE_ZERO;
		}
	}
	
	private void tratarNUllCadastro(){
		
		if (Helper.ENULO.enulo(this.cadastro)){
			
			this.cadastro = new Date();
		}
	}
	
	private void tratarNUllStatus(){
		
		if (Helper.ENULO.enulo(this.status)){
			
			this.status = StatusPedido.REALIZADO;
		}
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((this.id == null) ? ValoresConstantes.ZERO : id.hashCode());
		result = prime * result + ((this.contato == null) ? ValoresConstantes.ZERO : this.contato.hashCode());
		result = prime * result + ((this.troco == null) ? ValoresConstantes.ZERO : this.troco.hashCode());
		result = prime * result + ((this.entrega == null) ? ValoresConstantes.ZERO : this.entrega.hashCode());
		result = prime * result + ((this.cadastro == null) ? ValoresConstantes.ZERO : this.cadastro.hashCode());
		result = prime * result + ((this.status == null) ? ValoresConstantes.ZERO : this.status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pedido)) {
			return false;
		}
		Pedido other = (Pedido) obj;

		return super.equals(obj) 
				&&  this.id.equals(other.id)
				&&  this.contato.equals(other.contato)
				&&  this.entrega.equals(other.entrega)
				&&  this.status.equals(other.status)
				&&  this.cadastro.equals(other.cadastro);
	}
	
}
