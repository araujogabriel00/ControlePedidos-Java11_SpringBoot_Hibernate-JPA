package com.example.controlepedidos.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.controlepedidos.entities.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	private Integer pedidosStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItem> items = new HashSet<>();

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public Pedidos() {

	}

	public Pedidos(Long id, Instant moment, PedidoStatus pedidosStatus, Usuario cliente) {
		super();
		this.id = id;
		this.moment = moment;
		setPedidosStatus(pedidosStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public PedidoStatus getPedidosStatus() {
		return PedidoStatus.valueOf(pedidosStatus);
	}

	public void setPedidosStatus(PedidoStatus pedidosStatus) {
		if (pedidosStatus != null) {
			this.pedidosStatus = pedidosStatus.getCode();
		}

	}

	public Set<PedidoItem> getItems() {
		return items;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Double getTotal() {
		double soma = 0.0;
		for (PedidoItem x : items) {
			soma = soma + x.getSubTotal();
		}
		return soma;
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
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
