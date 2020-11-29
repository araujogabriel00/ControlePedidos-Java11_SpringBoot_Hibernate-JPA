package com.example.controlepedidos.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.controlepedidos.entities.pk.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();

	private Integer quantidade;
	private Double price;

	public PedidoItem() {

	}

	public PedidoItem(Pedidos pedidos, Produtos produtos, Integer quantidade, Double price) {
		super();
		id.setPedido(pedidos);
		id.setProdutos(produtos);
		this.quantidade = quantidade;
		this.price = price;
	}

	@JsonIgnore
	public Pedidos getPedidos() {
		return id.getPedido();

	}

	public void setPedido(Pedidos pedidos) {
		id.setPedido(pedidos);

	}

	public void setProdutos(Produtos produtos) {
		id.setProdutos(produtos);

	}

	public Produtos getProdutos() {
		return id.getProdutos();

	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return price * quantidade;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
