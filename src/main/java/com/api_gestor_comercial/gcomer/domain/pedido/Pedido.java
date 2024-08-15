package com.api_gestor_comercial.gcomer.domain.pedido;

import com.api_gestor_comercial.gcomer.domain.cliente.Cliente;
import com.api_gestor_comercial.gcomer.domain.producto.Producto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaDePedido;
    private boolean enviado;

    @ManyToOne
    private Cliente cliente;

    @ElementCollection
    @CollectionTable(name = "pedido_producto", joinColumns = @JoinColumn(name = "pedido_id"))
    @MapKeyJoinColumn(name = "producto_id")
    @Column(name = "cantidad")
    private Map<Producto, Integer> productos = new HashMap<>();
    private double precioTotal;

    public Pedido(DatosPedido datosPedido) {
    }

    public double calculaPrecioTotal(Map<Producto, Integer> productos) {
        return productos.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrecio() * entry.getValue())
                .sum();
  }

}
