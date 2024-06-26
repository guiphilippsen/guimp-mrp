package com.github.guiphilippsen.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidovenda")
public class PedidoVenda {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "idProduto", nullable = false)
        private int idProduto;

        @ManyToOne
        @JoinColumn(name = "idVendedor", nullable = false)
        private Funcionarios vendedor;

        @ManyToOne
        @JoinColumn(name = "idCliente", nullable = false)
        private Cliente cliente;

        @Column(name = "qtdVenda", nullable = false)
        private float qtdVenda;

        @Column(name = "valor", nullable = false)
        private float valor;

        @Column(name = "dataVenda", nullable = false)
        private Date dataVenda;

        public PedidoVenda() {
        }

        public PedidoVenda(int idProduto, Funcionarios vendedor, Cliente cliente, float qtdVenda, float valor, Date dataVenda) {
            this.idProduto = idProduto;
            this.vendedor = vendedor;
            this.cliente = cliente;
            this.qtdVenda = qtdVenda;
            this.valor = valor;
            this.dataVenda = dataVenda;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        public Funcionarios getVendedor() {
            return vendedor;
        }

        public void setVendedor(Funcionarios vendedor) {
            this.vendedor = vendedor;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public float getQtdVenda() {
            return qtdVenda;
        }

        public void setQtdVenda(float qtdVenda) {
            this.qtdVenda = qtdVenda;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Date getDataVenda() {
            return dataVenda;
        }

        public void setDataVenda(Date dataVenda) {
            this.dataVenda = dataVenda;
        }
}

