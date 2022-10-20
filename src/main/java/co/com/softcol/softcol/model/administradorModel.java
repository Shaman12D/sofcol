package co.com.softcol.softcol.model;

import java.math.BigInteger;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="administrador")
public class administradorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombres;
    private String apellidos;
    private BigInteger teléfono;
    private String dirección;
    private String usuario;
    private String contraseña;
}
