package co.com.softcol.softcol.model;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="pacientes")
public class pacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private BigInteger cedula;
    private String nombres;
    private String apellidos;
    private Date fechanacimiento;
    private BigInteger teléfono;
    private String dirección;
    private String estado;
    private String usuario;
    private String contraseña;
}
